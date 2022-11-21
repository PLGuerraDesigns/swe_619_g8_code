package inclass_11.src;
public class Point { // routine code
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) { // Standard recipe
        if (!(obj instanceof Point))
            return false;

        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}