package sample;


import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


public class AngryBird {
    public static Node[] getPicture() {
        //body
        Polygon body = new Polygon();
        body.getPoints().addAll(new Double[]{100.0, 100.0, 180.0, 100.0, 140.0, 40.0});
        body.setFill(Color.YELLOW);
        QuadCurve bottomQuadCurve = new QuadCurve(100, 100, 140, 106, 180, 100);
        bottomQuadCurve.setFill(Color.YELLOW);
        bottomQuadCurve.setStroke(Color.BLACK);
        bottomQuadCurve.setStrokeWidth(2);
        QuadCurve leftQuadCurve = new QuadCurve(100, 100, 117, 67, 140.0, 40.0);
        leftQuadCurve.setFill(Color.YELLOW);
        leftQuadCurve.setStroke(Color.BLACK);
        leftQuadCurve.setStrokeWidth(2);
        QuadCurve rightQuadCurve = new QuadCurve(180.0, 100, 163, 67, 140.0, 40.0);
        rightQuadCurve.setFill(Color.YELLOW);
        rightQuadCurve.setStroke(Color.BLACK);
        rightQuadCurve.setStrokeWidth(2);
        //tail
        Polygon tail = new Polygon();
        tail.getPoints().addAll(new Double[]{105.0, 91.5, 112.0, 78.0, 90.0, 90.0});
        tail.setFill(Color.BLACK);
        //bang
        QuadCurve bangQuadCurve1 = new QuadCurve(145, 48, 145, 35, 130.0, 35.0);
        QuadCurve bangQuadCurve2 = new QuadCurve(145, 48, 130, 30, 105.0, 48);
        //eyes
        Circle leftEye = new Circle(130, 80, 14);
        Circle leftEyePoint = new Circle(130, 80, 1);
        leftEye.setFill(Color.WHITE);
        leftEye.setStroke(Color.BLACK);
        leftEye.setStrokeWidth(1);
        Circle rightEye = new Circle(160, 80, 14);
        Circle rightEyePoint = new Circle(160, 80, 1);
        rightEye.setFill(Color.WHITE);
        rightEye.setStroke(Color.BLACK);
        rightEye.setStrokeWidth(1);
        //mouth
//        Line mouth = new Line(140, 97, 150, 97);
        Ellipse mouth = new Ellipse(145, 96, 6, 5);
        Rectangle teeth = new Rectangle(144, 92, 3, 4);
        teeth.setFill(Color.WHITE);

        return new Node[]{body,
                leftQuadCurve, rightQuadCurve, bottomQuadCurve,
                tail,
                bangQuadCurve1, bangQuadCurve2,
                leftEye, leftEyePoint, rightEye, rightEyePoint,
                mouth, teeth};
    }


}
