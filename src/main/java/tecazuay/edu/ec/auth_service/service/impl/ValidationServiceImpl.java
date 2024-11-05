package tecazuay.edu.ec.auth_service.service.impl;

import org.springframework.stereotype.Service;
import tecazuay.edu.ec.auth_service.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean isNumeric(String input) {
        return input.matches("^[0-9]*$");
    }

    @Override
    public boolean isLowercase(String input) {
        return input.matches("[a-z]+");
    }

    @Override
    public boolean isUppercase(String input) {
        return input.matches("^[A-Z]*$");
    }

    @Override
    public boolean isAlphanumeric(String input) {
        return input.matches("^[a-zA-Z0-9]*$");
    }

    @Override
    public boolean containsLetterAndNumber(String input) {
        return input.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]*$");
    }
}
