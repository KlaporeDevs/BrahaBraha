import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
public class GameFrame extends JFrame{
    JButton Start;
    JButton Settings;
    JButton Exit;
    private boolean fullscreenchecked = false;
    private boolean timerchecked = false;
    private int musicvolume = 50;
    private int soundvolume = 50;
    GameFrame(){
        //Buttons
        Start = new JButton("Start");
        Settings = new JButton("Settings");
        Exit = new JButton("Exit");
        //Operations
        Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] Choice = {"Easy", "Normal", "Hard"};
                int choice = JOptionPane.showOptionDialog(null, "Choose Difficulty", "Select Difficulty", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, Choice, Choice[0]);
                //Choice Handling
                switch(choice){
                    case 0:
                        JOptionPane.showMessageDialog(null, "Easy Difficulty");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Normal Difficulty");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Hard Diificulty");
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
               int pili = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit", "Exit", JOptionPane.YES_NO_OPTION);
               if (pili == JOptionPane.YES_OPTION){
                   System.exit(0);
               }
            }
        });
        //Layouts
        setLayout(null);
        //Buttons Bounds
        Start.setBounds(195, 100, 100, 30);
        Settings.setBounds(195, 150, 100, 30);
        Exit.setBounds(195, 200, 100, 30);
        //add Buttons
        add(Start);
        add(Settings);
        add(Exit);
        //Frame Set
        this.add(new GamePanel());
        this.setSize(500, 600);
        this.setTitle("BrahaBraha");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    private void showSettingsDialog(){
        //Settings Contents
        JDialog settingsDialogs = new JDialog(this, "Settings", true);
        settingsDialogs.setSize(300, 300);
        settingsDialogs.setLayout(null);
        settingsDialogs.setLocationRelativeTo(this);
        //Components
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
        music.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                musicvolume = music.getValue();
            }
        });
        JLabel sounds = new JLabel("Sound Volume");
        sounds.setBounds(20, 160, 200, 30);
        JSlider sound = new JSlider(JSlider.HORIZONTAL, 0, 100, soundvolume);
        sound.setBounds(20, 190, 200, 30);
        sound.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                soundvolume = sound.getValue();
            }
        });
        //Save Settings
        JButton save = new JButton("Save Settings");
        save.setBounds(100, 230, 120, 30);
        //save button config
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(settingsDialogs, "Settings Saved");
                settingsDialogs.dispose();
            }
        });
        //add to settings parts
        settingsDialogs.add(fullscreen);
        settingsDialogs.add(timer);
        settingsDialogs.add(music);
        settingsDialogs.add(musics);
        settingsDialogs.add(sound);
        settingsDialogs.add(sounds);
        settingsDialogs.add(save);
        //Visibility
        settingsDialogs.setVisible(true);
    }
}
