import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Easy extends JPanel {
    private JFrame frame;
    private JButton selectButton = null;
    private JButton clickButton = null;

    public Easy(JFrame frame) {
        this.frame = frame;
        setLayout(new GridLayout(2, 5));
        initialGame();
    }

    private void initialGame() {
        ArrayList<ImageIcon> images = new ArrayList<>();
        ImageIcon image1 = new ImageIcon("Card1.png");
        ImageIcon image2 = new ImageIcon("Card2.png");
        ImageIcon image3 = new ImageIcon("Card3.png");
        ImageIcon image4 = new ImageIcon("Card4.png");
        ImageIcon image5 = new ImageIcon("Card5,png");

        images.add(image1);
        images.add(image1);
        images.add(image2);
        images.add(image2);
        images.add(image3);
        images.add(image3);
        images.add(image4);
        images.add(image4);
        images.add(image5);
        images.add(image5);
        Collections.shuffle(images);

        for (ImageIcon image : images) {
            JButton button = new JButton(image);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    if (selectButton == null) {
                        selectButton = clickedButton;
                        selectButton.setEnabled(false);
                    } else {
                        if (!selectButton.equals(clickedButton)) {
                            if (selectButton.getIcon().equals(clickedButton.getIcon())) {
                                selectButton.setEnabled(false);
                                clickedButton.setEnabled(false);
                            } else {
                                selectButton.setEnabled(true);
                            }
                            selectButton = null;
                        }
                    }
                }
            });
            add(button);
        }
    }
}