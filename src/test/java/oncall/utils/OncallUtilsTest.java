package oncall.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OncallUtilsTest {

    @DisplayName("주문 입력에서 comma에 대한 예외 처리")
    @ValueSource(strings = {"5,,월", "5, 월", ",5,월", "5,"})
    @ParameterizedTest
    void checkComma(String input) {
        assertThatThrownBy(() -> OncallUtils.splitWithComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}