import java.util.*;

public class Minge {
    private int x;
    private int y;
    private static CoordinateGenerator generator = new CoordinateGenerator();

    public Minge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void suteaza() throws GolException, OutException, CornerException {
        this.x = generator.generateX();
        this.y = generator.generateY();

        if (this.y == 0 || this.y == 50) {
            throw new OutException("Mingea este in out la pozitia (" + this.x + ", " + this.y + ").");
        }
        if ((this.x == 0 || this.x == 100) && (this.y >= 20 && this.y <= 30)) {
            throw new GolException("Mingea este in gol la pozitia (" + this.x + ", " + this.y + ").");
        }
        if (this.x == 0 || this.x == 100) {
            throw new CornerException("Mingea este in corner la pozitia (" + this.x + ", " + this.y + ").");
        }
    }
}
