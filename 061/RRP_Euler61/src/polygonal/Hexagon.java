package polygonal;

public class Hexagon extends Polygon {
    @Override
    public int getNum (int n) {
        return n*(2*n - 1);
    }
}
