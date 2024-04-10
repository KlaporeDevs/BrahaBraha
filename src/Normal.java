import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Normal extends JPanel {
    private JFrame frame;
    private JButton selectButton = null;
    private JButton clickButton = null;
    private JLabel timerLabel;
    private Timer timer;
    private int timeElapsed = 0;
    private int pairsMatched = 0;

    public Normal(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());

        // Add timer label
        timerLabel = new JLabel("Time: " + timeElapsed);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timerLabel, BorderLayout.NORTH);

        // Initialize game board
        JPanel gamePanel = new JPanel(new GridLayout(4, 5));
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

    private int initialGame(JPanel gamePanel) {
        ArrayList<ImageIcon> images = new ArrayList<>();
        //Images Holder
        ImageIcon image1 = new ImageIcon("Card1.png");
        ImageIcon image2 = new ImageIcon("Card2.png");
        ImageIcon image3 = new ImageIcon("Card3.png");
        ImageIcon image4 = new ImageIcon("Card4.png");
        ImageIcon image5 = new ImageIcon("Card5.png");
        ImageIcon image6 = new ImageIcon("Card6.png");
        ImageIcon image7 = new ImageIcon("Card7.png");
        ImageIcon image8 = new ImageIcon("Card8.png");
        ImageIcon image9 = new ImageIcon("Card9.png");
        ImageIcon image10 = new ImageIcon("Card10.png");
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
        images.add(image6);
        images.add(image6);
        images.add(image7);
        images.add(image7);
        images.add(image8);
        images.add(image8);
        images.add(image9);
        images.add(image9);
        images.add(image10);
        images.add(image10);
        Collections.shuffle(images);

        int buttonWidth = 100;
        int buttonHeight = 100;
        int pairs = images.size() / 2;

        for (ImageIcon image : images) {
            Image img = image.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledImage = new ImageIcon(img);

            JButton button = new JButton(scaledImage);
            button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
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
                                pairsMatched++;
                                if (pairsMatched == pairs) {
                                    timer.stop();
                                    JOptionPane.showMessageDialog(frame, "Congratulations! You've Earned A Points");
                                    frame.dispose();
                                    new GameFrame();
                                }
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
        return pairs;
    }
    public void addWindowListener() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to Quit the game?", "Return To Main Menu", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    new GameFrame();
                } else{
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
}