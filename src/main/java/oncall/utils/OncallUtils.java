package oncall.utils;

import java.util.Arrays;
import java.util.List;
import oncall.OncallValidator;

public class OncallUtils {
    private static final String COMMA = ",";

    public static List<String> splitWithComma(String input) {
        OncallValidator.validateComma(input);
        return Arrays.asList(input.split(COMMA));
    }
}
