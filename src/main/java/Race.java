import model.Runner;

public class Race {

    public static void main(String[] args) {
        new Thread(new Runner(), "阿明").start();
        new Thread(new Runner(), "小美").start();
    }
}
