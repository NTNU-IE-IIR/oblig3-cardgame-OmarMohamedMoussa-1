package no.ntnu.idatx2003.oblig3.cardgame.GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MyFirstApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        BorderPane root = new BorderPane();

        // Set background
        setBackground(root, "src/mountain-8401084_1280.png");

        primaryStage.setTitle("Start Menu");

        // Display the start menu
        showStartMenu();
    }

    private void showStartMenu() {
        // Create buttons for menu options
        Button playButton = new Button("Play");
        Button optionsButton = new Button("Options");
        Button exitButton = new Button("Exit");

        // Set actions for the buttons
        playButton.setOnAction(event -> {
            // Show the game window
            showGameWindow();
        });

        optionsButton.setOnAction(event -> {
            // Add your options logic here
            System.out.println("Options button clicked");
        });

        exitButton.setOnAction(event -> {
            // Add your exit logic here
            System.out.println("Exit button clicked");
            primaryStage.close(); // Close the application
        });

        // Create a layout for the start menu
        VBox menuLayout = new VBox(10); // 10 pixels spacing between elements
        menuLayout.setAlignment(Pos.CENTER); // Center align the elements
        menuLayout.getChildren().addAll(playButton, optionsButton, exitButton);

        // Set the scene with the start menu layout
        primaryStage.setScene(new Scene(menuLayout, 600, 600));
        primaryStage.show();
    }

//    private void showGameWindow() {
//        // Create an instance of the game
//        GameWindow gameWindow = new GameWindow();
//
//        // Show the game window
//        gameWindow.show(primaryStage);
//    }

    // Method to set background
    private void setBackground(BorderPane pane, String imagePath) {
        try {
            // Load image from file
            Image backgroundImage = new Image(imagePath);

            // Create background image
            BackgroundImage background = new BackgroundImage(
                    backgroundImage,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);

            // Create background
            Background backgroundObj = new Background(background);

            // Apply background to root pane
            pane.setBackground(backgroundObj);
        } catch (IllegalArgumentException e) {
            System.err.println("Error loading background image: " + e.getMessage());
            // You can also log the stack trace if needed: e.printStackTrace();
        }
    }

    private void showGameWindow() {
        CardGame cardGame = new CardGame();

        cardGame.show(primaryStage);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
