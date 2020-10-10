import model.Runner;

public class Race {

    public static void main(String[] args) {
        Thread runner1 = new Thread(new Runner("阿明"));
        Thread runner2 = new Thread(new Runner("小美"));
        runner1.start();
        runner2.start();
    }
}
