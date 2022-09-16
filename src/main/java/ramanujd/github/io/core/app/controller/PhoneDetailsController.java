package ramanujd.github.io.core.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ramanujd.github.io.core.app.model.PhoneDetails;
import ramanujd.github.io.core.app.repo.PhoneDetailsRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneDetailsController {

    private final PhoneDetailsRepository phoneDetailsRepository;

    @GetMapping
    public List<PhoneDetails> getPhones() {
        return phoneDetailsRepository.findAll();
    }

    @GetMapping("/{id}")
    public PhoneDetails getPhone(@PathVariable Long id) {
        return phoneDetailsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createPhone(@RequestBody PhoneDetails phoneDetails) throws URISyntaxException {
        PhoneDetails savedPhoneDetails = phoneDetailsRepository.save(phoneDetails);
        return ResponseEntity.created(new URI("/phone/" + savedPhoneDetails.getId())).body(savedPhoneDetails);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePhone(@PathVariable Long id, @RequestBody PhoneDetails phoneDetails) throws URISyntaxException {
        PhoneDetails savedPhoneDetails = phoneDetailsRepository.save(phoneDetails);
        return ResponseEntity.created(new URI("/phone/" + savedPhoneDetails.getId())).body(savedPhoneDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        phoneDetailsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}