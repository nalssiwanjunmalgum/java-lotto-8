package lotto.domain;

public class LottoWithBonus {
    private final Lotto userLotto;
    private final Bonus userBonus;

    public LottoWithBonus(Lotto lotto, Bonus bonus) {
        this.userLotto = lotto;
        this.userBonus = bonus;
    }
}
