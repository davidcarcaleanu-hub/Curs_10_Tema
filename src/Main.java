
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
