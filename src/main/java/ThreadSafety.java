import model.AddStringToList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafety {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        List<String> resultList = Collections.synchronizedList(new ArrayList<>());
        List<Thread> taskList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread task = new Thread(new AddStringToList(resultList));
            task.start();
            taskList.add(task);
        }
        for (Thread task : taskList) {
            task.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format(
                "塞入了%s個字串%s花了%s秒",
                resultList.size(),
                Thread.currentThread().getName(),
                (endTime - startTime) / 1000
        ));
    }
}
