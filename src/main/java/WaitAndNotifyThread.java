import model.Notifier;
import model.Result;
import model.ResultCode;
import model.Waiter;

public class WaitAndNotifyThread {

    public static void main(String[] args) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        Waiter waiter = new Waiter(result);
        new Thread(waiter, "waiter").start();
        Notifier notifier = new Notifier(result);
        new Thread(notifier, "notifier").start();
        System.out.println("執行緒已經開始執行");
    }
}
