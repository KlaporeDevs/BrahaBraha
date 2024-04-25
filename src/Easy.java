import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

// Easy class extends JPanel and represents the easy level of the memory card game
public class Easy extends JPanel {
    private JFrame frame; // The main JFrame of the application
    private JButton selectButton = null; // The currently selected button
    private JLabel timerLabel; // The label displaying the elapsed time
    private Timer timer; // The timer responsible for updating the elapsed time
    private int timeElapsed = 0; // The elapsed time in seconds
    private int pairsMatched = 0; // The number of matched pairs
    private int totalPairs; // The total number of pairs in the game
    private String soundFilePath; // The path to the background sound file
    private CardPointings cardPointings; // The CardPointings object responsible for tracking the player's points

    // Constructor initializes the game board and starts the timer
    public Easy(JFrame frame, String soundFilePath, CardPointings cardPointings, JLabel pointsLabel) {
        this.frame = frame;
        setLayout(new BorderLayout());
        this.soundFilePath = soundFilePath;
        this.cardPointings = cardPointings;
        ImageIcon brahabrahaLogo = new ImageIcon("src/logo.png");
        frame.setIconImage(brahabrahaLogo.getImage());
        // Add timer label
        timerLabel = new JLabel("Time: " + timeElapsed);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timerLabel, BorderLayout.NORTH);

        // Initialize game board
        JPanel gamePanel = new JPanel(new GridLayout(2, 5));
        add(gamePanel, BorderLayout.CENTER);
        totalPairs = initialGame(gamePanel);

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
    // initialGame method initializes the game board with the card images
    private int initialGame(JPanel gamePanel) {
        ArrayList<ImageIcon> images = new ArrayList<>();
        // Images Holder
        ImageIcon image1 = new ImageIcon("src/NEW SPADES/1.png");
        ImageIcon image2 = new ImageIcon("src/NEW HEARTS/3.png");
        ImageIcon image3 = new ImageIcon("src/NEW CLUBS/4.png");
        ImageIcon image4 = new ImageIcon("src/NEW DIAMONDS/5.png");
        ImageIcon image5 = new ImageIcon("src/NEW SPADES/6.png");
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

        int buttonWidth = 200;
        int buttonHeight = 300;
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
        int butts = buttonWidth + 10;
        int butts1 = buttonHeight + 10;

        for (ImageIcon image : images) {
            JButton button = new JButton(image);
            button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    CardAnimations.flipCard(clickedButton, (ImageIcon) clickedButton.getIcon());
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
                                    JOptionPane.showMessageDialog(frame, "Congratulations, You've Earned Points!");
                                    cardPointings.addPoints();
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

    // addWindowListener method adds a window listener to the main JFrame
    public void addWindowListener() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                timer.stop();
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the game?",
                        "Close Game", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    new GameFrame();
                } else {
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    timer.start();
                }
            }
        });
    }

    // playBackgroundSound method plays the background sound
    private void playBackgroundSound(String filePath) {
        try {
            File audiof = new File(filePath);
            AudioInputStream audios = AudioSystem.getAudioInputStream(audiof);
            Clip clip = AudioSystem.getClip();
            clip.open(audios);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}