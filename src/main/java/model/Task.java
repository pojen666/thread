package model;

public class Task extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
