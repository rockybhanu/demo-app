package ramanujd.github.io.core.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import ramanujd.github.io.core.app.dto.ApiOperationResponse;
import ramanujd.github.io.core.app.dto.InstrumentDto;
import ramanujd.github.io.core.app.mapper.InstrumentMapper;
import ramanujd.github.io.core.app.model.Instrument;
import ramanujd.github.io.core.app.repo.InstrumentRepository;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/instrument")
public class InstrumentController {

    private final InstrumentRepository instrumentRepository;
    private final InstrumentMapper instrumentMapper;

    @GetMapping("/all")
    public List<InstrumentDto> getAllInstruments() {
        return instrumentMapper.instrumentListToInstrumentDtoList(instrumentRepository.findAll());
    }

    @PostMapping("/create")
    public InstrumentDto createInstrument(InstrumentDto instrumentDto) {
        Instrument newInstrument = instrumentRepository.save(instrumentMapper.instrumentDtoToInstrument(instrumentDto));
        return instrumentMapper.instrumentToInstrumentDto(newInstrument);
    }



    @DeleteMapping("/{id}")
    public ApiOperationResponse deleteInstrument(@PathVariable Long id) {
        ApiOperationResponse apiOperationResponse = new ApiOperationResponse();
        try {
            instrumentRepository.deleteById(id);
            apiOperationResponse.setStatus("SUCCESS");
            log.info("Instrument Id " + id + " deleted.");
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            apiOperationResponse.setStatus("FAILED");
            apiOperationResponse.setMessage("Instrument Id " + id + " doesn't exists.");
            log.error(apiOperationResponse.getMessage());
        }
        return apiOperationResponse;
    }
}