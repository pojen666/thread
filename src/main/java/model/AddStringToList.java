package model;

import java.util.List;
import java.util.Random;

public class AddStringToList implements Runnable {
    public AddStringToList(List<String> list) {
        this.list = list;
    }

    private final List<String> list;

    public void run() {
        long startTime = System.currentTimeMillis();
        sleep();
        for (int i = 0; i < 10; i++) {
            list.add("test");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format(
                "%s花了%s秒",
                Thread.currentThread().getName(),
                (endTime - startTime) / 1000
        ));
    }

    private void sleep() {
        Random random = new Random();
        int time = random.nextInt(4) + 1;
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
