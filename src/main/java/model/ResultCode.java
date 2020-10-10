package model;

import lombok.Getter;

public enum ResultCode {
    OK(0, "成功"), FAIL(-1, "失敗");

    @Getter
    private final int code;

    @Getter
    private final String text;

    ResultCode(int code, String text) {
        this.code = code;
        this.text = text;
    }
}
