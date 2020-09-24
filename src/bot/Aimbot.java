package bot;

import java.awt.*;
import java.awt.Robot;

public class Aimbot extends Robot {

    private static final Color target = new Color(255, 134, 144);
    private static final int MONITOR_WIDTH = 2560;
    private static final int MONITOR_HEIGHT = 1440;
    /* top left corner of a square to scan */
    private static final int SCAN_START_X = 1200;
    private static final int SCAN_START_Y = 550;
    /* square height and width */
    private static final int SCAN_RANGE = 200;
    private static final int DELAY = 1;

    public Aimbot() throws AWTException {

    }

    public void aim() {
        while (true) {
            delay(DELAY);
            int[] tabOfColors = createScreenCapture(new Rectangle(MONITOR_WIDTH, MONITOR_HEIGHT)).getRGB(SCAN_START_X, SCAN_START_Y, SCAN_RANGE, SCAN_RANGE, null, 0, SCAN_RANGE);
            int targetIndex = 0;
            for (int i = 0; i < tabOfColors.length; i++) {
                if (tabOfColors[i] == target.getRGB()) {
                    targetIndex = i;
                }
            }
            int xPos = (targetIndex % SCAN_RANGE) + SCAN_START_X;
            int yPos = (targetIndex / SCAN_RANGE) + SCAN_START_Y;
            if (xPos > SCAN_START_X && xPos < MONITOR_HEIGHT && yPos > SCAN_START_Y && yPos < SCAN_START_Y+200) {
                mouseMove(xPos, yPos);
            }
        }
    }

}
