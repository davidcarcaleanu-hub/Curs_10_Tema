import java.util.Random;

import javax.swing.event.SwingPropertyChangeSupport;

import java.util.Date;

class CoordinateGenerator { // aceasta este clasa din enunt
    private Random randomGenerator;

    public CoordinateGenerator() {
        Date now = new Date();
        long sec = now.getTime();
        randomGenerator = new Random(sec);
    }

    public int generateX() {
        int x = randomGenerator.nextInt(101);
        if (x < 5) {
            x = 0;
        } else if (x > 95) {
            x = 100;
        } else {
            x = randomGenerator.nextInt(99) + 1;
        }
        return x;
    }

    public int generateY() {
        int y = randomGenerator.nextInt(101);
        if (y < 5) {
            y = 0;
        } else if (y > 95) {
            y = 50;
        } else {
            y = randomGenerator.nextInt(49) + 1;
        }
        return y;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Simulare Meci 1");
        Joc meci1 = new Joc("FC Barcelona", "Manchester United", 0, 0, 0, 0);
        meci1.simuleaza();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }

        System.out.println("\n Simulare Meci 2");
        Joc meci2 = new Joc("Manchester City", "Paris PSG", 0, 0, 0, 0);
        meci2.simuleaza();

        System.out.println("\n Rezultate");
        System.out.println(meci1);
        System.out.println(meci2);
    }
}
