package service;

import model.Result;
import model.ResultCode;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class RequestService {

    public CompletableFuture<Result> send() {
        return CompletableFuture
                .supplyAsync(() -> {
                    long startTime = System.currentTimeMillis();
                    Random random = new Random();
                    int time = random.nextInt(4) + 1;
                    try {
                        Thread.sleep(time * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long endTime = System.currentTimeMillis();
                    return new Result(
                            ResultCode.OK,
                            Thread.currentThread().getName(),
                            (endTime - startTime) / 1000
                    );
                });
    }
}
