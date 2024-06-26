import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    private final AppSounds appSounds;
    private JPanel mainPanel;
    JButton Shop;
    JButton Start;
    JButton Settings;
    JButton Exit;
    JLabel pointsLabel;
    private boolean fullscreenchecked = false;
    private boolean timerchecked = false;
    private int musicvolume = 50;
    private int soundvolume = 50;
    private final CardPointings cardPointings;

    GameFrame() {
        // Icon
        appSounds = new AppSounds();
        playBackgroundMusic();
        ImageIcon brahabrahalogo = new ImageIcon("src/logo.png");
        setIconImage(brahabrahalogo.getImage());
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("src/Bg1.jpeg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        mainPanel.setLayout(null);
        // Buttons
        Shop = new JButton("Shop");
        Start = new JButton("Start");
        Settings = new JButton("Settings");
        Exit = new JButton("Exit");
        // Operations
        Shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame shopFrame = new JFrame("Shop");
                ImageIcon brahabrahalogo = new ImageIcon("src/logo.png");
                shopFrame.setIconImage(brahabrahalogo.getImage());
                InGameShopUI shopUI = new InGameShopUI(pointsLabel);
                shopFrame.getContentPane().add(shopUI);
                shopFrame.setSize(300, 400);
                shopFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                shopFrame.setLocationRelativeTo(null);
                shopFrame.setResizable(false);
                shopFrame.setVisible(true);
            }
        });
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] Choice = { "Easy", "Normal", "Hard" };
                int choice = JOptionPane.showOptionDialog(null, "Choose Difficulty", "Select Difficulty",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Choice, Choice[0]);
                // Choice Handling
                switch (choice) {
                    case 0:
                        JFrame easyFrame = new JFrame("Easy Difficulty - BrahaBraha");
                        JLabel pointsLabel = new JLabel("Points: 0");
                        Easy easyPanel = new Easy(easyFrame, "Easy.wav", cardPointings, pointsLabel);
                        easyPanel.addWindowListener();
                        easyFrame.getContentPane().add(easyPanel);
                        easyFrame.setSize(800, 700);
                        easyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        easyFrame.setLocationRelativeTo(null);
                        easyFrame.setResizable(false);
                        easyFrame.setVisible(true);
                        dispose();
                        break;
                    case 1:
                        JFrame normalFrame = new JFrame("Normal Difficulty - BrahaBraha");
                        Normal normalPanel = new Normal(normalFrame);
                        normalPanel.addWindowListener();
                        normalFrame.getContentPane().add(normalPanel);
                        normalFrame.setSize(800, 700);
                        normalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        normalFrame.setLocationRelativeTo(null);
                        normalFrame.setResizable(false);
                        normalFrame.setVisible(true);
                        dispose();
                        break;
                    case 2:
                        JFrame hardFrame = new JFrame("Hard Difficulty - BrahaBraha");
                        Hard hardPanel = new Hard(hardFrame);
                        hardPanel.addWindowListener();
                        hardFrame.getContentPane().add(hardPanel);
                        hardFrame.setSize(900, 700);
                        hardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        hardFrame.setLocationRelativeTo(null);
                        hardFrame.setResizable(false);
                        hardFrame.setVisible(true);
                        dispose();
                        break;
                }
            }
        });

        Settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSettingsDialog();
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pili = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (pili == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        // Layouts
        setLayout(null);
        // Buttons Bounds
        Shop.setBounds(10, 20, 100, 30);
        Start.setBounds(195, 100, 100, 30);
        Settings.setBounds(195, 150, 100, 30);
        Exit.setBounds(195, 200, 100, 30);
        // add Buttons
        mainPanel.add(Shop);
        mainPanel.add(Start);
        mainPanel.add(Settings);
        mainPanel.add(Exit);
        // Added Score
        pointsLabel = new JLabel("Points: 0");
        pointsLabel.setForeground(Color.GREEN);
        pointsLabel.setBounds(400, 20, 100, 30);
        mainPanel.add(pointsLabel);
        cardPointings = new CardPointings(pointsLabel);

        setContentPane(mainPanel);
        // Frame Set
        this.setSize(500, 600);
        this.setTitle("BrahaBraha");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    private void playBackgroundMusic(){
        appSounds.playBackgroundMusic();
    }
    private void stopBackgroundMusic(){
        appSounds.stopBackgroundMusic();
    }
    private void playEasySound(){
        appSounds.playEasySound();
    }
    private void showSettingsDialog() {
        // Settings Contents
        JDialog settingsDialogs = new JDialog(this, "Settings", true);
        settingsDialogs.setSize(300, 300);
        settingsDialogs.setLayout(null);
        settingsDialogs.setLocationRelativeTo(this);
        // Components
        JCheckBox fullscreen = new JCheckBox("FullScreen");
        fullscreen.setBounds(20, 20, 150, 30);
        fullscreen.setSelected(fullscreenchecked);
        fullscreen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fullscreenchecked = fullscreen.isSelected();
            }
        });
        JCheckBox timer = new JCheckBox("Timer On/Off");
        timer.setBounds(20, 60, 150, 30);
        timer.setSelected(timerchecked);
        timer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                timerchecked = timer.isSelected();
            }
        });
        JLabel musics = new JLabel("Music Volume");
        musics.setBounds(20, 100, 150, 30);
        JSlider music = new JSlider(JSlider.HORIZONTAL, 0, 100, musicvolume);
        music.setBounds(20, 130, 200, 30);
        music.setPaintTicks(false);
        // Indicator
        JLabel musicIndicator = new JLabel(musicvolume + "");
        musicIndicator.setBounds(230, 130, 50, 30);
        music.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                musicvolume = music.getValue();
                musicIndicator.setText(musicvolume + "");
            }
        });
        JLabel sounds = new JLabel("Sound Volume");
        sounds.setBounds(20, 160, 200, 30);
        JSlider sound = new JSlider(JSlider.HORIZONTAL, 0, 100, soundvolume);
        sound.setBounds(20, 190, 200, 30);
        sound.setPaintTicks(false);
        JLabel soundIndicator = new JLabel(soundvolume + "");
        soundIndicator.setBounds(230, 160, 200, 30);
        sound.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                soundvolume = sound.getValue();
                soundIndicator.setText(soundvolume + "");
            }
        });
        // Save Settings
        JButton save = new JButton("Save Settings");
        save.setBounds(100, 230, 120, 30);
        // save button config
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(settingsDialogs, "Settings Saved");
                settingsDialogs.dispose();
            }
        });
        // add to settings parts
        settingsDialogs.add(fullscreen);
        settingsDialogs.add(timer);
        settingsDialogs.add(music);
        settingsDialogs.add(musics);
        settingsDialogs.add(musicIndicator);
        settingsDialogs.add(sound);
        settingsDialogs.add(soundIndicator);
        settingsDialogs.add(sounds);
        settingsDialogs.add(save);
        // Visibility
        settingsDialogs.setVisible(true);
    }
}