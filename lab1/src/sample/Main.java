package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        double width = 300;
        double height = 250;
        Scene scene = new Scene(root, width, height);
        scene.setFill(Color.YELLOW);

        Rectangle mashta = new Rectangle(140,100,10,100);
        mashta.setFill(Color.BLACK);
        root.getChildren().add(mashta);

        Polygon flag = new Polygon();
        double flagWidth = width / 2.5;
        double flagHeight = height / 2.5;
        double zazor = width / 12;
        flag.getPoints().add(0 + (width - flagWidth) / 2);
        flag.getPoints().add(0 + (height - flagHeight) / 2 + 10);

        flag.getPoints().add(0 + (width - flagWidth) / 2 + zazor);
        flag.getPoints().add(0 + (height - flagHeight) / 2 - flagHeight / 2);

        flag.getPoints().add(0 + (width - flagWidth) / 2 + flagWidth);
        flag.getPoints().add(0 + (height - flagHeight) / 2 - flagHeight / 2);

        flag.getPoints().add(0 + (width - flagWidth) / 2 + flagWidth - zazor);
        flag.getPoints().add(0 + (height - flagHeight) / 2 + 14);

        flag.getPoints().add(0 + (width - flagWidth) / 2 + flagWidth);
        flag.getPoints().add(0 + (height - flagHeight) / 2 + flagHeight / 2);

        flag.getPoints().add(0 + (width - flagWidth) / 2 + zazor);
        flag.getPoints().add(0 + (height - flagHeight) / 2 + flagHeight / 2 - 4);

        flag.setFill(Color.GREY);
        root.getChildren().add(flag);

        Polygon trym = new Polygon(20, 140, 100, 170, 200, 170, 250, 140, 210, 240, 90, 240);
        trym.setFill(Color.BROWN);
        root.getChildren().add(trym);

        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
