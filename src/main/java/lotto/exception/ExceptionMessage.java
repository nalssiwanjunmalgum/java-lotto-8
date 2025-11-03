package lotto.exception;

public enum ExceptionMessage {
    WRONG_LOTTO_SIZE("6개의 숫자를 입력하지 않았습니다.", ModifyingType.LOTTO_NUMBER),
    DUPLICATED_NUMBER("중복된 숫자를 입력했습니다.", ModifyingType.LOTTO_NUMBER),
    OUT_OF_RANGE_LOTTO_NUMBER("범위에서 벗어난 수를 입력했습니다. 로또 번호 범위는 1~45까지입니다",
            ModifyingType.LOTTO_NUMBER),
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String errorDescription;
    private final ModifyingType modifyingType;

    ExceptionMessage(String errorDescription, ModifyingType modifyingType) {
        this.errorDescription = errorDescription;
        this.modifyingType = modifyingType;
    }

    public String getErrorDescription() {
        return PREFIX
                + errorDescription
                + modifyingType.getModifyingMessage();
    }
}

