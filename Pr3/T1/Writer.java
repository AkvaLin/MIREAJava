package Pr3.T1;
import java.util.concurrent.CopyOnWriteArrayList;

public class Writer implements Runnable {
    private CopyOnWriteArrayList<Integer> listOfNumbers;

    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                listOfNumbers.add(i);
                System.out.println("Written: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
