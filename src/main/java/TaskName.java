import model.Task;

public class TaskName {

    public static void main(String [] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1000; i++) {
            Task task = new Task();
            task.start();
        }
    }
}
