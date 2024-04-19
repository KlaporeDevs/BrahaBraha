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
        }
    }
}