package Letter;

import Point.Point2d;
import Shape.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        BaseShape letterA = new BaseShape();
        Rectangle rectangle = new Rectangle(stripeThickness, maxHeight);
        rectangle.rotate(rectangle.getCoords(),75.0);
        Rectangle rectangle2 = new Rectangle(stripeThickness, maxHeight);
        rectangle2.rotate(rectangle2.getCoords(),-75.0);
        rectangle2.translate(rectangle2.getCoords(), new Point2d(0.0, 0.0));
        Rectangle rectangle3 = new Rectangle(maxWidth, stripeThickness);
        rectangle3.translate(rectangle3.getCoords(), new Point2d(-10.0, halfMaxHeight));
        letterA.add(rectangle);
        letterA.add(rectangle2);
        letterA.add(rectangle3);

        return letterA;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        BaseShape letterB = new BaseShape();
        Rectangle rectangle = new Rectangle(stripeThickness, maxHeight);
        rectangle.translate(rectangle.getCoords(), new Point2d(-halfMaxWidth - 10.0, -halfMaxHeight/2));
        Circle circle1 = new Circle(maxWidth+stripeThickness);
        circle1.translate(circle1.getCoords(), new Point2d(0.0, 0.0));
        Circle circle2 = new Circle(maxWidth);
        circle2.translate(circle2.getCoords(), new Point2d(0.0, 0.0));
        Circle circle3 = new Circle(maxWidth+stripeThickness);
        circle1.translate(circle3.getCoords(), new Point2d(0.0, halfMaxHeight));
        Circle circle4 = new Circle(maxWidth);
        circle2.translate(circle4.getCoords(), new Point2d(0.0, halfMaxHeight));
        letterB.add(circle1);
        letterB.remove(circle2);
        letterB.add(circle3);
        letterB.remove(circle4);
        letterB.add(rectangle);

        return letterB;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        BaseShape letterC = new BaseShape();
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        letterC.add(ellipse);
        Ellipse ellipse2 = new Ellipse(halfMaxWidth, halfMaxHeight);
        letterC.remove(ellipse2);
        Rectangle rectangle = new Rectangle(stripeThickness*2, 3/2*maxHeight);
        rectangle.translate(rectangle.getCoords(),new Point2d(halfMaxWidth/4, -halfMaxHeight));
        letterC.remove(rectangle);
        return letterC;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        BaseShape letterE = new BaseShape();
        Rectangle rectangle = new Rectangle(stripeThickness, maxHeight);
        Rectangle rectangle2 = new Rectangle(maxWidth, stripeThickness);
        Rectangle rectangle3 = new Rectangle(maxWidth, stripeThickness);
        rectangle3.translate(rectangle3.getCoords(), new Point2d(0.0, maxHeight));
        Rectangle rectangle4 = new Rectangle(maxWidth, stripeThickness);
        rectangle4.translate(rectangle4.getCoords(), new Point2d(0.0, halfMaxHeight));
        letterE.add(rectangle);
        letterE.add(rectangle2);
        letterE.add(rectangle3);
        letterE.add(rectangle4);
        return letterE;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        BaseShape letterH = new BaseShape();
        Rectangle rectangle = new Rectangle(stripeThickness, maxHeight);
        Rectangle rectangle2 = rectangle.clone();
        rectangle2.translate(rectangle2.getCoords(), new Point2d(maxWidth, 0.0));
        Rectangle rectangle3 = new Rectangle(maxWidth, stripeThickness);
        rectangle3.translate(rectangle3.getCoords(), new Point2d(0.0, halfMaxHeight));
        letterH.add(rectangle);
        letterH.add(rectangle2);
        letterH.add(rectangle3);
        return letterH;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        BaseShape letterN = new BaseShape();
        Rectangle rectangle = new Rectangle(stripeThickness, maxHeight);
        Rectangle rectangle2 = rectangle.clone();
        rectangle2.translate(rectangle2.getCoords(), new Point2d(maxWidth, 0.0));
        Rectangle rectangle3 = rectangle.clone();
        rectangle3.rotate(rectangle3.getCoords(), 75.0);
        letterN.add(rectangle);
        letterN.add(rectangle2);
        letterN.add(rectangle3);
        return letterN;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        BaseShape letterO = new BaseShape();
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        letterO.add(ellipse);
        Ellipse ellipse2 = new Ellipse(halfMaxWidth, halfMaxHeight);
        letterO.remove(ellipse2);
        return letterO;
    }

}
