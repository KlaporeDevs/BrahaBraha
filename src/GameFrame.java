import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame{
    JButton Start;
    JButton Settings;
    JButton Exit;
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

            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
}
