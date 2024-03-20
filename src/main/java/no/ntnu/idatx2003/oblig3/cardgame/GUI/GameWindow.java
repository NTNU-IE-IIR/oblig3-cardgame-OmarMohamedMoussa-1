package no.ntnu.idatx2003.oblig3.cardgame.GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.Hand;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

import java.util.List;


/**
 * This class is not used, but was made to practice
 */
public class GameWindow {
    private static Hand playerHand; // Declare playerHand as a class-level variable

    public static void show(Stage primaryStage) {
        Stage gameStage = new Stage();
        BorderPane root = new BorderPane();

        // Create the buttons
        Button dealButton = new Button("Deal Hand"); // Initialize dealButton
        Button checkButton = new Button("Check Flush"); // Initialize checkButton

        // Create labels for displaying information
        Label flushLabel = new Label("Flush: ");
        Label sumLabel = new Label("Sum of Faces: ");
        Label queenLabel = new Label("Contains Queens: ");

        // Handle deal button action
        dealButton.setOnAction(event -> {
            // Deal a hand of cards
            DeckOfCards deck = new DeckOfCards();
            List<PlayingCard> hand = deck.dealHand(5); // Deal 5 cards

            // Create a new hand
            playerHand = new Hand();

            // Add each card to the player's hand
            for (PlayingCard card : hand) {
                playerHand.addCard(card); // Add the PlayingCard object directly
            }

            // Display the dealt hand
            displayHand(hand, root);

            // Check if the hand is a flush
            boolean isFlush = playerHand.isFlush();

            // Calculate the sum of faces
            int sumOfFaces = playerHand.getSumOfFaces();

            // Check if the hand contains any Queens
            boolean containsQueens = playerHand.containsQueens();

            // Update the labels accordingly
            flushLabel.setText("Flush: " + (isFlush ? "Yes" : "No"));
            sumLabel.setText("Sum of Faces: " + sumOfFaces);
            queenLabel.setText("Contains Queens: " + (containsQueens ? "Yes" : "No"));
        });

        // Arrange the buttons in a VBox
        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(dealButton, checkButton);

        // Set the buttons to the right side of the root layout
        root.setRight(buttonBox);

        // Arrange the labels in a VBox
        VBox labelBox = new VBox(10);
        labelBox.setAlignment(Pos.CENTER);
        labelBox.getChildren().addAll(flushLabel, sumLabel, queenLabel);

        // Set the labels to the top side of the root layout
        root.setTop(labelBox);

        // Set the scene
        Scene scene = new Scene(root, 600, 400);
        gameStage.setScene(scene);
        gameStage.setTitle("Card Game");
        gameStage.show();
    }


    // Helper method to display the hand of cards
    private static void displayHand(List<PlayingCard> hand, BorderPane root) {
        // Create a HBox to display cards horizontally
        HBox handBox = new HBox(10);
        handBox.setAlignment(Pos.CENTER);
        // Add each card to the handBox
        for (PlayingCard card : hand) {
            Label cardLabel = new Label(card.getAsString());
            handBox.getChildren().add(cardLabel);
        }
        // Set the handBox to the left side of the root layout
        root.setLeft(handBox);
    }
}
