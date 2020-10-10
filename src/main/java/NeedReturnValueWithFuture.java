import model.Result;
import service.RequestService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 多執行緒使用CompletableFuture處理需要回傳的狀況
 */
public class NeedReturnValueWithFuture {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<CompletableFuture<Result>> resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RequestService requestService = new RequestService();
            resultList.add(requestService.send());
        }
        CompletableFuture.allOf(resultList.toArray(new CompletableFuture[0]))
                .whenComplete((n, e) ->
                        resultList.forEach(resultCompletableFuture -> {
                            try {
                                Result result = resultCompletableFuture.get();
                                System.out.println(String.format(
                                        "%s花了%s秒",
                                        result.getSource(),
                                        result.getSeconds()
                                ));
                            } catch (InterruptedException | ExecutionException ex) {
                                ex.printStackTrace();
                            }
                        })
                ).join();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format(
                "%s花了%s秒",
                Thread.currentThread().getName(),
                (endTime - startTime) / 1000
        ));
    }
}
