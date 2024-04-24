import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InGameShopUI extends JPanel{
    private JLabel pointsLabel;
    private JButton Item1;
    private JButton Item2;
    private  JButton Item3;
    private JButton Item4;
    private int points;

    public InGameShopUI(JLabel pointsLabel){
        this.pointsLabel = pointsLabel;
        this.points = 0;
        setupUI();
    }
    private void setupUI(){
        setLayout(new GridLayout(4, 1));
        Item1 = new JButton("Skin 1 (200 Points)");
        Item2 = new JButton("Skin 2 (500 Points)");
        Item3 = new JButton("Skin 3 (1000 Points)");
        Item4 = new JButton("Skin 4 (2000 Points");
        Item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyItem(10);
            }
        });
        Item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyItem(20);
            }
        });
        Item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyItem(30);
            }
        });
        Item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyItem(40);
            }
        });
        add(Item1);
        add(Item2);
        add(Item3);
        add(Item4);
    }
    private void buyItem(int cost){
        if(points >= cost){
            points -= cost;
            pointsLabel.setText("Points: " + points);
            JOptionPane.showMessageDialog(this, "Item Purchased Successfully");
        } else{
            JOptionPane.showMessageDialog(this, "Insufficient Points To buy This Item");
        }
    }
    public void updatePoints(int newPoints){
        this.points = newPoints;
        pointsLabel.setText("Points: " + points);
    }
}
