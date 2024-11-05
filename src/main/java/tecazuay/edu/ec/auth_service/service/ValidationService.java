package tecazuay.edu.ec.auth_service.service;

public interface ValidationService {

    boolean isNumeric(String input);

    boolean isLowercase(String input);

    boolean isUppercase(String input);

    boolean isAlphanumeric(String input);

    boolean containsLetterAndNumber(String input);
}
