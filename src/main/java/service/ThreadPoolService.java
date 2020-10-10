package service;

import model.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolService {

    //建立固定執行緒數量的執行緒池
    public void testFixedThreadPool() {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            Task task = new Task();
            threadPool.execute(task);
        }
        threadPool.shutdown();
    }

    //建立一個執行緒池，該執行緒池會根據需要建立新的執行緒，但如果之前建立的執行緒可以使用，會重用之前建立的執行緒
    public void testCachedThreadPool() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            Task task = new Task();
            threadPool.execute(task);
        }
        threadPool.shutdown();
    }

    //建立一個只有一個執行緒的執行緒池
    public void testSingleThreadPool() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            Task task = new Task();
            threadPool.execute(task);
        }
        threadPool.shutdown();
    }
}
