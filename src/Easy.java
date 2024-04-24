import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

<<<<<<< HEAD
public class Easy extends JPanel {
    private JFrame frame;
    private JButton selectButton = null;
    private JLabel timerLabel;
    private Timer timer;
    private int timeElapsed = 0;
    private int pairsMatched = 0;
    private int totalPairs;
    private String soundFilePath;
    private final CardPointings cardPointings;
=======
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
>>>>>>> origin/master
    public Easy(JFrame frame, String soundFilePath, CardPointings cardPointings, JLabel pointsLabel) {
        this.frame = frame;
        setLayout(new BorderLayout());
        this.soundFilePath = soundFilePath;
        this.cardPointings = cardPointings;

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

<<<<<<< HEAD
    private int initialGame(JPanel gamePanel) {
        ArrayList<ImageIcon> images = new ArrayList<>();
        //Images Holder
        ImageIcon image1 = new ImageIcon("Card1.png");
        ImageIcon image2 = new ImageIcon("Card2.png");
        ImageIcon image3 = new ImageIcon("Card3.png");
        ImageIcon image4 = new ImageIcon("Card4.png");
        ImageIcon image5 = new ImageIcon("Card5.png");
=======
    // initialGame method initializes the game board with the card images
    private int initialGame(JPanel gamePanel) {
        ArrayList<ImageIcon> images = new ArrayList<>();
        // Images Holder
<<<<<<< HEAD
        ImageIcon image1 = new ImageIcon("src/CARDS SET 1/SPADES2.png");
        ImageIcon image2 = new ImageIcon("src/CARDS SET 2 (HEARTS)/HEARTS3.png");
        ImageIcon image3 = new ImageIcon("src/CARDS SET 3 (CLUBS)/CLUBS3.png");
        ImageIcon image4 = new ImageIcon("src/CARDS SET 2 (HEARTS)/HEARTS5.png");
        ImageIcon image5 = new ImageIcon("src/CARDS SET 1/SPADES6.png");
>>>>>>> origin/master
=======
        ImageIcon image1 = new ImageIcon("src/NEW SPADES/1.png");
        ImageIcon image2 = new ImageIcon("src/NEW HEARTS/3.png");
        ImageIcon image3 = new ImageIcon("src/NEW CLUBS/4.png");
        ImageIcon image4 = new ImageIcon("src/NEW DIAMONDS/5.png");
        ImageIcon image5 = new ImageIcon("src/NEW SPADES/6.png");
>>>>>>> da80fdae61e9eaf466bef124e1c88d3b4ef5ff50
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

<<<<<<< HEAD
        int buttonWidth = 234;
        int buttonHeight = 350;
=======
        int buttonWidth = 200;
        int buttonHeight = 300;
>>>>>>> origin/master
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
<<<<<<< HEAD
                                    JOptionPane.showMessageDialog(frame, "Congratulations! You've Earned Points");
=======
                                    JOptionPane.showMessageDialog(frame, "Congratulations, You've Earned Points!");
>>>>>>> origin/master
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

<<<<<<< HEAD
=======
    // addWindowListener method adds a window listener to the main JFrame
>>>>>>> origin/master
    public void addWindowListener() {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                timer.stop();
<<<<<<< HEAD
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the game?", "Close Game", JOptionPane.YES_NO_OPTION);
=======
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the game?",
                        "Close Game", JOptionPane.YES_NO_OPTION);
>>>>>>> origin/master
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
<<<<<<< HEAD
    private void playBackgroundSound(String filePath) {
        try{
=======

    // playBackgroundSound method plays the background sound
    private void playBackgroundSound(String filePath) {
        try {
>>>>>>> origin/master
            File audiof = new File(filePath);
            AudioInputStream audios = AudioSystem.getAudioInputStream(audiof);
            Clip clip = AudioSystem.getClip();
            clip.open(audios);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
<<<<<<< HEAD
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){
            ex.printStackTrace();
        }
    }
}

=======
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}
>>>>>>> origin/master
