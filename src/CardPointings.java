<<<<<<< HEAD
import javax.swing.*;

public class CardPointings {
    private int points = 0;
    private JLabel pointsLabel;

    public CardPointings(JLabel pointsLabel) {
        this.pointsLabel = pointsLabel;
        this.points = 0;
        updatePointsLabel();
    }

    public void addPoints() {
        points += 10;
        updatePointsLabel();
    }

    private void updatePointsLabel() {
        if (pointsLabel != null){
            pointsLabel.setText("Points: " + points);
=======
import javax.swing.*; // Importing the javax.swing library for using JLabel

public class CardPointings { // Class representing the card pointings

    private int points; // Variable to store the current points
    private JLabel pointsLabel; // Variable to store the reference to the JLabel for displaying points

    public CardPointings(JLabel pointsLabel) { // Constructor to initialize the CardPointings object
        this.pointsLabel = pointsLabel; // Assigning the passed JLabel to the instance variable
        this.points = 0; // Initializing the points to 0
        updatePointsLabel(); // Calling the updatePointsLabel method to display the initial points
    }

    public void addPoints() { // Method to add points to the current points
        points += 10; // Adding 10 points to the current points
        updatePointsLabel(); // Calling the updatePointsLabel method to display the updated points
    }

    private void updatePointsLabel() { // Method to update the JLabel with the current points
        if (pointsLabel != null) { // Checking if the JLabel is not null
            pointsLabel.setText("Points: " + points); // Setting the text of the JLabel to display the current points
>>>>>>> origin/master
        }
    }
}