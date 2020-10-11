package model;

public class Waiter implements Runnable {
    private final Result result;

    public Waiter(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        synchronized (result) {
            try {
                System.out.println(threadName + " 開始等待");
                result.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " 受到通知");
            System.out.println(threadName + " 處理結果:" + result.getCode());
        }
    }
}
