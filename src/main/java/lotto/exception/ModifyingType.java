package lotto.exception;

public enum ModifyingType {
    LOTTO_NUMBER(" 로또 번호을 다시 입력해주세요."),

    ;

    ModifyingType(String errorType) {
        this.modifyingTypeMessage = errorType;
    }

    private final String modifyingTypeMessage;

    public String getModifyingMessage() {
        return modifyingTypeMessage;
    }
}
