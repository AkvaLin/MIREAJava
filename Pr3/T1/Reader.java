package Pr3.T1;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable {
    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Reader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Read: " + listOfNumbers);
                Thread.sleep(700);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
