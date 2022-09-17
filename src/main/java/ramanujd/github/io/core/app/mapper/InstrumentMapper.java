package ramanujd.github.io.core.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ramanujd.github.io.core.app.dto.InstrumentDto;
import ramanujd.github.io.core.app.model.Instrument;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InstrumentMapper {
    InstrumentDto instrumentToInstrumentDto(Instrument instrument);

    Instrument instrumentDtoToInstrument(InstrumentDto instrumentDto);

    List<InstrumentDto> instrumentListToInstrumentDtoList(List<Instrument> instrument);
}
