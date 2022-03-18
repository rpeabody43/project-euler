package polygonal;

import java.util.List;
import java.util.ArrayList;

public class Polygon {

    int getNum (int n) {
        return -1;
    }

    public int indexOf (int num) {
        return indexOfHelper(num, 0, 1000);
    }
    private int indexOfHelper (int num, int l, int r) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (getNum(mid) > num)
                return indexOfHelper(num, l, mid - 1);
            if (getNum(mid) < num)
                return indexOfHelper(num, mid + 1, r);

            return mid;
        }
        return -1;
    }

    public int[] inRange (int start, int end) {
        while (indexOf(start) == -1)
            start++;
        int lower = indexOf(start);
        while (indexOf(end) == -1)
            end++;
        int upper = indexOf(end);
        int[] ret = new int[upper - lower];
        for (int i = lower; i < upper; i++)
            ret[i - lower] = getNum(i);
        return ret;
    }

    public static Polygon[] polygons () {

        Polygon[] ret = new Polygon[6];
        ret[0] = new Triangle();
        ret[1] = new Square();
        ret[2] = new Pentagon();
        ret[3] = new Hexagon();
        ret[4] = new Heptagon();
        ret[5] = new Octagon();

        return ret;
    }
}