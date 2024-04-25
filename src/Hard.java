import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Hard extends JPanel {
    private JFrame frame;
    private JButton selectButton = null;
    private JButton clickButton = null;
    private JLabel timerLabel;
    private Timer timer;
    private int timeElapsed = 0;
    private int pairMatched = 0;

    public Hard(JFrame frame) {
        this.frame = frame;
        setLayout(new BorderLayout());
        ImageIcon brahabrahalogo = new ImageIcon("src/logo.png");
        frame.setIconImage(brahabrahalogo.getImage());

        // Add timer label
        timerLabel = new JLabel("Time: " + timeElapsed);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timerLabel, BorderLayout.NORTH);

        // Initialize game board
        JPanel gamePanel = new JPanel(new GridLayout(5, 5));
        add(gamePanel, BorderLayout.CENTER);
        initialGame(gamePanel);

        // Create timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeElapsed++;
                int minutes = timeElapsed / 60;
                int seconds = timeElapsed % 60;
                String formatTime = String.format("%02d:%02d", minutes, seconds);
                timerLabel.setText("Time: " + formatTime);
            }
        });
        timer.start();
    }

    private int initialGame(JPanel gamePanel) {
        ArrayList<ImageIcon> images = new ArrayList<>();
        // Images Holder
        ImageIcon image1 = new ImageIcon("src/CARDS SET 1/SPADES10.png");
        ImageIcon image2 = new ImageIcon("src/CARDS SET 2 (HEARTS)/HEARTS3.png");
        ImageIcon image3 = new ImageIcon("src/CARDS SET 4 (DIAMONDS)/DIAMONDS6.png");
        ImageIcon image4 = new ImageIcon("src/CARDS SET 1/SPADES5.png");
        ImageIcon image5 = new ImageIcon("src/CARDS SET 2 (HEARTS)/HEARTS6.png");
        ImageIcon image6 = new ImageIcon("src/CARDS SET 4 (DIAMONDS)/DIAMONDS5.png");
        ImageIcon image7 = new ImageIcon("src/CARDS SET 1/SPADES8.png");
        ImageIcon image8 = new ImageIcon("src/CARDS SET 2 (HEARTS)/HEARTS9.png");
        ImageIcon image9 = new ImageIcon("src/CARDS SET 4 (DIAMONDS)/DIAMONDS3.png");
        ImageIcon image10 = new ImageIcon("src/CARDS SET 1/SPADES3.png");
        ImageIcon image11 = new ImageIcon("src/CARDS SET 2 (HEARTS)/HEARTS10.png");
        ImageIcon image12 = new ImageIcon("src/CARDS SET 3 (CLUBS)/CLUBS5.png");
        ImageIcon image13 = new ImageIcon("src/CARDS SET 1/SPADES6.png");
        ImageIcon image14 = new ImageIcon("src/CARDS SET 2 (HEARTS)/HEARTS7.png");
        ImageIcon image15 = new ImageIcon("src/CARDS SET 3 (CLUBS)/CLUBS8.png");
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
        images.add(image11);
        images.add(image11);
        images.add(image12);
        images.add(image12);
        images.add(image13);
        images.add(image13);
        images.add(image14);
        images.add(image14);
        images.add(image15);
        images.add(image15);
        Collections.shuffle(images);

        int buttonWidth = 100;
        int buttonHeight = 100;
        int pairs = images.size() / 2;

        for (ImageIcon image : images) {
            Image img = image.getImage();
            int imgWidth = img.getWidth(null);
            int imgHeight = img.getHeight(null);

            if (imgWidth > buttonWidth) {
                buttonWidth = imgWidth;
            }
            if (imgHeight > buttonHeight) {
                buttonHeight = imgHeight;
            }
        }

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
                                pairMatched++;
                                if (pairMatched == pairs) {
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
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to Quit the game?",
                        "Return To Main Menu", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    new GameFrame();
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
}