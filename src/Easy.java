import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Easy extends JPanel {
    private JFrame frame;
    private JButton selectButton = null;
    private JButton clickButton = null;
    private JLabel timerLabel;
    private Timer timer;
    private int timeElapsed = 0;

    public Easy(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        // Add timer label
        timerLabel = new JLabel("Time: " + timeElapsed);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timerLabel, BorderLayout.NORTH);

        // Initialize game board
        JPanel gamePanel = new JPanel(new GridLayout(2, 5));
        add(gamePanel, BorderLayout.CENTER);
        initialGame(gamePanel);

        // Create timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeElapsed++;
                timerLabel.setText("Time: " + timeElapsed);
            }
        });
        timer.start();
    }

    private void initialGame(JPanel gamePanel) {
        ArrayList<ImageIcon> images = new ArrayList<>();
        //Images Holder
        ImageIcon image1 = new ImageIcon("Card1.png");
        ImageIcon image2 = new ImageIcon("Card2.png");
        ImageIcon image3 = new ImageIcon("Card3.png");
        ImageIcon image4 = new ImageIcon("Card4.png");
        ImageIcon image5 = new ImageIcon("Card5.png");
        // Add to The Screen
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
            gamePanel.add(button);
        }
    }
    public void addWindowListener() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the game?", "Close Game", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                } else{
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
}