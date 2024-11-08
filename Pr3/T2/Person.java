package Pr3.T2;
import java.util.Random;

public class Person extends Thread {
    private final int category;
    private final Window[] windows;
    private final App app;

    public Person(int category, Window[] windows, App app) {
        this.category = category;
        this.windows = windows;
        this.app = app;
    }

    public int getCategory() {
        return category;
    }

    @Override
    public void run() {
        Random rand = new Random();
        boolean served = false;

        for (int i = 0; i < windows.length; i++) {
            Window window = windows[rand.nextInt(windows.length)];
            if (window.service(this)) {
                System.out.println("Person of category " + category + " has been served.");
                served = true;
                break;
            }
        }

        if (!served) {
            System.out.println("Person of category " + category + " left angrily.");
            app.incrementLeftCount(category);
        }
    }
}
