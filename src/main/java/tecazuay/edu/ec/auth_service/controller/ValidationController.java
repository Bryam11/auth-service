package tecazuay.edu.ec.auth_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tecazuay.edu.ec.auth_service.service.ValidationService;

@RestController
@RequestMapping("/validate")
@RequiredArgsConstructor
public class ValidationController {

    private final ValidationService validationService;

    @GetMapping("/numeric")
    public ResponseEntity<Boolean> validateNumeric(@RequestParam(name = "input") String input) {
        return ResponseEntity.ok(validationService.isNumeric(input));
    }

    @GetMapping("/lowercase")
    public ResponseEntity<Boolean> validateLowercase(@RequestParam String input) {
        return ResponseEntity.ok(validationService.isLowercase(input));
    }

    @GetMapping("/uppercase")
    public ResponseEntity<Boolean> validateUppercase(@RequestParam String input) {
        return ResponseEntity.ok(validationService.isUppercase(input));
    }

    @GetMapping("/alphanumeric")
    public ResponseEntity<Boolean> validateAlphanumeric(@RequestParam String input) {
        return ResponseEntity.ok(validationService.isAlphanumeric(input));
    }

    @GetMapping("/letter-and-number")
    public ResponseEntity<Boolean> validateLetterAndNumber(@RequestParam String input) {
        return ResponseEntity.ok(validationService.containsLetterAndNumber(input));
    }
}
