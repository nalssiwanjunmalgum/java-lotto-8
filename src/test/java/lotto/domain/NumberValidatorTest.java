package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionMessage;
import lotto.util.validator.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    @DisplayName("입력이 null이거나 빈 문자열이면 예외 발생")
    void isNullOrEmpty_shouldThrowException_whenNullOrEmpty() {
        assertThatThrownBy(() -> NumberValidator.isNullOrEmpty(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NULL_INPUT.getErrorDescription());

        assertThatThrownBy(() -> NumberValidator.isNullOrEmpty(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NULL_INPUT.getErrorDescription());
    }

    @Test
    @DisplayName("입력이 올바른 숫자 형태면 통과")
    void isNumberPattern_shouldPass_whenValidNumber() {
        assertThatCode(() -> NumberValidator.isNumberPattern("123456")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함되면 예외 발생")
    void isNumberPattern_shouldThrow_whenInvalidNumber() {
        assertThatThrownBy(() -> NumberValidator.isNumberPattern("12a3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MATCHES_NUMBER_PATTERN.getErrorDescription());
    }

    @Test
    @DisplayName("로또 번호 형식(콤마 구분 숫자)일 경우 통과")
    void isLottoPattern_shouldPass_whenValidFormat() {
        assertThatCode(() -> NumberValidator.isLottoPattern("1,2,3,4,5,6"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호 형식이 잘못된 경우 예외 발생")
    void isLottoPattern_shouldThrow_whenInvalidFormat() {
        assertThatThrownBy(() -> NumberValidator.isLottoPattern("1,,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MATCHES_NUMBER_PATTERN.getErrorDescription());

        assertThatThrownBy(() -> NumberValidator.isLottoPattern("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_MATCHES_NUMBER_PATTERN.getErrorDescription());
    }

    @Test
    @DisplayName("0으로 시작하는 단일 숫자는 허용하지만 다자리수는 예외 발생")
    void startsWithZero_shouldThrow_whenMultipleDigitsStartWithZero() {
        assertThatCode(() -> NumberValidator.startsWithZero("0")).doesNotThrowAnyException();
        assertThatCode(() -> NumberValidator.startsWithZero("9")).doesNotThrowAnyException();

        assertThatThrownBy(() -> NumberValidator.startsWithZero("01"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MULTIPLE_LETTERS_STARTS_WITH_ZERO.getErrorDescription());
    }
}
