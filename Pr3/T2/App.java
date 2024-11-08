package Pr3.T2;

public class App {
    private int totalYoung = 0;
    private int totalOld = 0;
    private int totalBusiness = 0;

    private int leftYoung = 0;
    private int leftOld = 0;
    private int leftBusiness = 0;

    public synchronized void incrementTotalCount(int category) {
        if (category == 1) {
            totalYoung++;
        } else if (category == 2) {
            totalOld++;
        } else if (category == 3) {
            totalBusiness++;
        }
    }

    public synchronized void incrementLeftCount(int category) {
        if (category == 1) {
            leftYoung++;
        } else if (category == 2) {
            leftOld++;
        } else if (category == 3) {
            leftBusiness++;
        }
    }

    public void printLeftPercentages() {
        System.out.println("\nStatistics:");
        if (totalYoung > 0) {
            System.out.printf("Young people left: %.2f%%\n", (leftYoung * 100.0) / totalYoung);
        } else {
            System.out.println("No young people processed.");
        }
        if (totalOld > 0) {
            System.out.printf("Old people left: %.2f%%\n", (leftOld * 100.0) / totalOld);
        } else {
            System.out.println("No old people processed.");
        }
        if (totalBusiness > 0) {
            System.out.printf("Business people left: %.2f%%\n", (leftBusiness * 100.0) / totalBusiness);
        } else {
            System.out.println("No business people processed.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        Window[] windows = { new Window(0), new Window(2), new Window(3) };

        int totalPersons = 30;

        for (int i = 0; i < totalPersons; i++) {
            int category = (i % 3) + 1;  // Категории: 1 - молодые, 2 - пожилые, 3 - бизнесмены
            app.incrementTotalCount(category);
            Person person = new Person(category, windows, app);
            person.start();
            Thread.sleep(300);
        }

        Thread.sleep(20000);

        app.printLeftPercentages();
    }
}
