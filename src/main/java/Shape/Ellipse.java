package Shape;

import Point.Point2d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Ellipse extends BaseShape {
    /** TODO
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        for (double i = -widthDiameter/2; i <= widthDiameter/2; i += 0.5) {
            for (double j = -heightDiameter/2; j <= heightDiameter/2; j += 0.5) {
                if ((i * i) / (widthDiameter/2 * widthDiameter/2) + (j * j) / (heightDiameter/2 * heightDiameter/2) <= 1) {
                    this.add(new Point2d(i, j));
                }
            }
        }
    }

    /** TODO
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) {
        for (Point2d p : coords) {
            this.add(new Point2d(p.X(), p.Y()));
        }
    }

    /** TODO
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        Collection<Point2d> coords = new ArrayList<>();
        for (Point2d p : this.getCoords()) {
            coords.add(p.clone());
        }
        return new Ellipse(coords);
    }
}
