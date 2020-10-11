package model;

import lombok.Data;

@Data
public class Result {

    private ResultCode code;

    private String source;

    private long seconds;

    public Result(ResultCode code, String source, long seconds) {
        this.code = code;
        this.source = source;
        this.seconds = seconds;
    }

    public Result() {
    }
}
