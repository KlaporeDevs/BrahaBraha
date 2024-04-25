import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardAnimations {
    private static final int FLIP_DELAY = 1000;

    public static void flipCard(JButton cardButton, ImageIcon image) {
        Timer timer = new Timer(FLIP_DELAY, new ActionListener() {
            boolean flipped = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (flipped) {
                    cardButton.setIcon(null);
                } else {
                    cardButton.setIcon(image);
                }
                flipped = !flipped;
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}