package model;

public class Notifier implements Runnable {

    private final Result result;

    public Notifier(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " 開始將狀態調整成成功");

        synchronized (result) {
            result.setCode(ResultCode.OK);
            result.notify();
        }
        System.out.println(threadName + " 結束");
    }
}
