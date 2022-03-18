package polygonal;

public class Triangle extends Polygon {
    @Override
    public int getNum(int n) {
        return n*(n + 1)/2;
    }
}
