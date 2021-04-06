package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.rgb(102, 178, 255));
        stage.setScene(scene);
        stage.show();
        root.getChildren().addAll(AngryBird.getPicture());
        animateNode(root);
    }

    public void animateNode(Node node) {
        Path path = new Path();
        path.getElements().add(new MoveTo(100, 150));
        path.getElements().add(new CubicCurveTo(440, 0, 380, 320, 250, 300));
        path.getElements().add(new CubicCurveTo(150, 250, 300, 180, 260, 280));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(node);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(2000), node);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(false);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), node);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                pathTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
