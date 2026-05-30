import javax.swing.plaf.synth.SynthStyle;

public class Joc {
    private String echipa1;
    private String echipa2;
    private int goluriEchipa1;
    private int goluriEchipa2;
    private int totalCornere;
    private int totalOuturi;

    public Joc(String echipa1, String echipa2, int goluriEchipa1, int goluriEchipa2, int totalCornere,
            int totalOuturi) {
        this.echipa1 = echipa1;
        this.echipa2 = echipa2;
        this.goluriEchipa1 = 0;
        this.goluriEchipa2 = 0;
        this.totalCornere = 0;
        this.totalOuturi = 0;
    }

    public void simuleaza() {
        Minge minge = new Minge(50, 25);

        for (int i = 1; i <= 1000; i++) {
            try {
                minge.suteaza();
                System.out.println(echipa1 + "-" + echipa2 + " : Mingea este la coordonatele (" + minge.getX() + ", "
                        + minge.getY() + ")");

            } catch (GolException e) {
                System.out.println(echipa1 + "-" + echipa2 + " : Mingea este la coordonatele (" + minge.getX() + ", "
                        + minge.getY() + ")");
                System.out.println("A avut loc un eveniment" + e.getMessage());

                if (minge.getX() == 0) {
                    goluriEchipa2++;
                } else {
                    goluriEchipa1++;
                }
                minge = new Minge(50, 25);

            } catch (OutException e) {
                System.out.println(echipa1 + "-" + echipa2 + " : Mingea este la coordonatele (" + minge.getX() + ", "
                        + minge.getY() + ")");
                System.out.println("A avut loc un eveniment: " + e.getMessage());
                totalOuturi++;

                minge = new Minge(minge.getX(), minge.getY());

            } catch (CornerException e) {
                System.out.println(echipa1 + "-" + echipa2 + " : Mingea este la coordonatele (" + minge.getX() + ", "
                        + minge.getY() + ")");
                System.out.println("A avut loc un eveniment: " + e.getMessage());
                totalCornere++;

                int coltX = minge.getX();
                int coltY = (minge.getY() < 20) ? 0 : 50;
                minge = new Minge(coltX, coltY);
            }

        }

    }

    @Override
    public String toString() {
        return "Meci: " + echipa1 + "vs" + echipa2 + "\n" +
                "Scor final:" + goluriEchipa1 + " - " + goluriEchipa2 + "\n" +
                "Cornere: " + totalCornere + "\n" +
                "Out-uri: " + totalOuturi;

    }
}
