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
        Rectangle leftBar = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle rightBar = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle middleBar = new Rectangle(halfMaxWidth, halfStripeThickness);

        leftBar.rotate(leftBar.getCoords(),25.0);
        leftBar.translate(leftBar.getCoords(), new Point2d(halfMaxWidth/2, 0.0));
        rightBar.rotate(rightBar.getCoords(),-25.0);
        rightBar.translate(rightBar.getCoords(), new Point2d(-halfMaxWidth/2, 0.0));
        middleBar.translate(middleBar.getCoords(), new Point2d(0.0, 0.0));

        letterA.add(leftBar);
        letterA.add(rightBar);
        letterA.add(middleBar);

        return letterA;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        BaseShape letterB = new BaseShape();
        Circle topCircle = new Circle(maxWidth/2 + halfStripeThickness);
        Circle topHole = new Circle(maxWidth/2);
        Circle bottomCircle = new Circle(maxWidth/2 + halfStripeThickness);
        Rectangle verticalStripe = new Rectangle(stripeThickness, maxHeight);
        Circle bottomHole = new Circle(maxWidth/2);

        verticalStripe.translate(verticalStripe.getCoords(), new Point2d(0.0, 0.0));
        topCircle.translate(topCircle.getCoords(), new Point2d(halfMaxWidth, halfMaxHeight/2));
        topHole.translate(topHole.getCoords(), new Point2d(halfMaxWidth, halfMaxHeight/2));
        bottomCircle.translate(bottomCircle.getCoords(), new Point2d(halfMaxWidth, -halfMaxHeight/2));
        bottomHole.translate(bottomHole.getCoords(), new Point2d(halfMaxWidth, -halfMaxHeight/2));

        letterB.add(topCircle);
        letterB.add(bottomCircle);
        letterB.remove(topHole);
        letterB.remove(bottomHole);
        letterB.add(verticalStripe);

        return letterB;
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        BaseShape letterC = new BaseShape();
        Ellipse ellipse = new Ellipse(maxWidth + halfStripeThickness, maxHeight);
        Ellipse ellipseHole = new Ellipse(maxWidth - stripeThickness, maxHeight - stripeThickness);
        Rectangle rightBar = new Rectangle(halfMaxWidth, halfMaxHeight + stripeThickness);

        letterC.add(ellipse);
        letterC.remove(ellipseHole);
        rightBar.translate(rightBar.getCoords(), new Point2d(halfMaxWidth, 0.0));
        letterC.remove(rightBar);

        return letterC;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        BaseShape letterE = new BaseShape();
        Rectangle verticalBar = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle middleBar = new Rectangle(maxWidth, halfStripeThickness);
        Rectangle topBar = new Rectangle(maxWidth, halfStripeThickness);
        Rectangle bottomBar = new Rectangle(maxWidth, halfStripeThickness);

        middleBar.translate(middleBar.getCoords(), new Point2d(halfMaxWidth, 0.0));
        topBar.translate(topBar.getCoords(), new Point2d(halfMaxWidth, halfMaxHeight - halfStripeThickness/2));
        bottomBar.translate(bottomBar.getCoords(), new Point2d(halfMaxWidth, -halfMaxHeight + halfStripeThickness/2));

        letterE.add(verticalBar);
        letterE.add(middleBar);
        letterE.add(topBar);
        letterE.add(bottomBar);

        return letterE;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        BaseShape letterH = new BaseShape();
        Rectangle leftBar = new Rectangle(stripeThickness, maxHeight);
        Rectangle middleBar = new Rectangle(maxWidth, stripeThickness);
        Rectangle rightBar = leftBar.clone();

        rightBar.translate(rightBar.getCoords(), new Point2d(maxWidth, 0.0));
        middleBar.translate(middleBar.getCoords(), new Point2d(halfMaxWidth, 0.0));

        letterH.add(leftBar);
        letterH.add(rightBar);
        letterH.add(middleBar);
        return letterH;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        BaseShape letterN = new BaseShape();
        Rectangle leftVerticalBar = new Rectangle(halfStripeThickness, maxHeight);

        Rectangle rightVerticalBar = leftVerticalBar.clone();
        rightVerticalBar.translate(rightVerticalBar.getCoords(), new Point2d(maxWidth, 0.0));
        Rectangle inclineBar = leftVerticalBar.clone();
        inclineBar.rotate(inclineBar.getCoords(), 75.0);
        inclineBar.translate(inclineBar.getCoords(), new Point2d(halfMaxWidth, 0.0));

        letterN.add(leftVerticalBar);
        letterN.add(rightVerticalBar);
        letterN.add(inclineBar);

        return letterN;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        BaseShape letterO = new BaseShape();
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        Ellipse ellipseHole = new Ellipse(maxWidth - stripeThickness, maxHeight - stripeThickness);

        letterO.add(ellipse);
        letterO.remove(ellipseHole);

        return letterO;
    }

}
