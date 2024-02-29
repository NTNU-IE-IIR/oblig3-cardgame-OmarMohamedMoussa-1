package no.ntnu.idatx2003.oblig3.cardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyFirstApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a button
        Button button = new Button("Click me!");

        // Create a layout pane
        StackPane root = new StackPane();
        root.getChildren().add(button);

        // Create a scene
        Scene scene = new Scene(root, 300, 250);

        // Set the scene on the stage
        primaryStage.setScene(scene);

        // Set the title of the stage
        primaryStage.setTitle("JavaFX Application");

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}