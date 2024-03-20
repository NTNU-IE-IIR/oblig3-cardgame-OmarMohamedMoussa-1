package no.ntnu.idatx2003.oblig3.cardgame.GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.idatx2003.oblig3.cardgame.DeckOfCards;
import no.ntnu.idatx2003.oblig3.cardgame.Hand;
import no.ntnu.idatx2003.oblig3.cardgame.PlayingCard;

import java.util.List;

public class CardGame{

    private Hand playerHand;
    private DeckOfCards deck;
    private Stage primaryStage;
    private Stage gameStage;


    public void show(Stage primaryStage) {
        Stage gameStage = new Stage();
        primaryStage.setTitle("Card Game");

        BorderPane root = new BorderPane();

        // Set background
        setBackground(root, "mountain-8401084_1280.png");


        // Create the buttons
        Button dealButton = new Button("Deal Hand");
        Button checkButton = new Button("Check Flush");
        Button goBack = new Button("Go back to start");

        VBox buttonBox = new VBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(dealButton, checkButton);

        HBox labelBox = new HBox(10);
        labelBox.setAlignment(Pos.CENTER);
        Label flushLabel = new Label("Flush: ");
        Label sumLabel = new Label("Sum of Faces: ");
        Label queenLabel = new Label("Contains Queens: ");
        labelBox.getChildren().addAll(flushLabel, sumLabel, queenLabel);

        Text heartsText = new Text(); // Text field to display hearts cards
        root.setBottom(heartsText);

        deck = new DeckOfCards(); // Create a deck of cards

        dealButton.setOnAction(event -> {
            if (deck.isEmpty()) {
                // Display message when deck is empty
                heartsText.setText("No more cards");
                return;
            }
            List<PlayingCard> hand = deck.dealHand(5); // Deal a hand of cards
            playerHand = new Hand();
            for (PlayingCard card : hand) {
                playerHand.addCard(card);
            }
            displayHand(hand, root, heartsText); // Display the hand
            boolean isFlush = playerHand.isFlush();
            int sumOfFaces = playerHand.getSumOfFaces();
            boolean containsQueens = playerHand.containsQueens();
            flushLabel.setText("Flush: " + (isFlush ? "Yes" : "No"));
            sumLabel.setText("Sum of Faces: " + sumOfFaces);
            queenLabel.setText("Contains Queens: " + (containsQueens ? "Yes" : "No"));
        });

        root.setRight(buttonBox);
        root.setTop(labelBox);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void displayHand(List<PlayingCard> hand, BorderPane root, Text heartsText) {
        HBox handBox = new HBox(10);
        handBox.setAlignment(Pos.CENTER);
        StringBuilder heartsCards = new StringBuilder(); // String to store hearts cards
        for (PlayingCard card : hand) {
            Label cardLabel = new Label(card.getAsString());
            handBox.getChildren().add(cardLabel);
            // Check if the card is a heart
            if (card.getSuit() == 'H') {
                heartsCards.append(card.getAsString()).append(" ");
            }
        }
        // Display hearts cards or "No Hearts" if no hearts cards are present in the hand
        heartsText.setText(heartsCards.length() > 0 ? heartsCards.toString() : "No Hearts");
        root.setLeft(handBox);
    }

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




}
