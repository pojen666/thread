package model;

public class Runner implements Runnable {


    @Override
    public void run() {
        int distance = 0;
        for (int i = 0; i < 300; i++) {
            distance++;
            if (distance == 300) {
                System.out.println(String.format("%s跑完了", Thread.currentThread().getName()));
            }
        }
    }
}
