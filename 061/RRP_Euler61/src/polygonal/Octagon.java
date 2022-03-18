package polygonal;

public class Octagon extends Polygon{
    @Override
    public int getNum (int n) {
        return n*(3*n - 2);
    }
}
