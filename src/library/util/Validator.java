package library.util;

public interface Validator {
    static void validate(Object object) {
        if(object == null || (object instanceof String && ((String) object).trim().isEmpty()))
            throw new IllegalArgumentException("Input cannot be null or empty!");
    };
}
