package Shape;

import Point.Point2d;

import java.util.ArrayList;
import java.util.Collection;

public class Rectangle extends BaseShape {
    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(Double width, Double height) {
        for (double i = -width/2 ; i <= width/2 ; i += 0.5) {
            for (double j = -height/2 ; j <= height/2 ; j += 0.5) {
                this.add(new Point2d(i, j));
            }
        }
    }

    /** TODO
     * Create a filled rectangle centered on (0, 0)
     * @param dimensions 2D point containing the width and height of the rectangle
     */
    public Rectangle(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create a rectangle from a given collection of Points
     * @param coords The collection of 2D points
     */
    private Rectangle(Collection<Point2d> coords) {
        for (Point2d p : coords) {
            this.add(p);
        }
    }

    /** TODO
     * @return Deep copy of the rectangle
     */
    @Override
    public Rectangle clone() {
        Collection<Point2d> coords = new ArrayList<>();
        for (Point2d p : this.getCoords()) {
            coords.add(p.clone());
        }
        return new Rectangle(coords);
    }
}
