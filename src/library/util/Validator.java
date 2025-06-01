package library.util;

public interface Validator {
    static void validate(Object object) {
        if(object == null)
            throw new IllegalArgumentException("Input cannot be null!");
    };
}
