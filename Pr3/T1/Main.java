package Pr3.T1;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        Thread writerThread = new Thread(new Writer(listOfNumbers));
        Thread readerThread = new Thread(new Reader(listOfNumbers));

        writerThread.start();
        readerThread.start();
    }
}
