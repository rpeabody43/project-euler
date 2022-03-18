package polygonal;

public class Heptagon extends Polygon {
    @Override
    public int getNum (int n) {
        return n*(5*n - 3)/2;
    }
}
