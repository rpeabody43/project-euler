package polygonal;

public class Pentagon extends Polygon {
    @Override
    public int getNum (int n) {
        return n*(3*n - 1)/2;
    }
}
