package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    @DisplayName("예외가 발생하는 조건")
    class LottoExcpetionCases {
        @DisplayName("로또 번호의 개수가 6개보다 적다면 예외가 발생한다.")
        @Test
        void createLottoByLowerSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호에 범위에서 벗어난 숫자가 있으면 예외가 발생한다")
        @Test
        void createLottoByOutOfRangeNumber() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호가 서로 다른 6개의 숫자인 경우 예외가 발생하지 않는다")
        @Test
        void createLottoByDifferentSixNumbers() {
            assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                    .doesNotThrowAnyException();
        }
    }
}
