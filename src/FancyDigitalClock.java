import java.time.LocalTime;

public class FancyDigitalClock {
    static final int[] FONT = {31599,19812,14479,31207,23524,29411,29679,30866,31727,31719,1040};
    static final int FONT_ROWS = 5;
    static final int FONT_COLS = 3;
    static final int DIGITS_COUNT = 8;
    static final int DIGITS_PAD = 2;
    static final int DISPLAY_WIDTH = (FONT_COLS + DIGITS_PAD) * DIGITS_COUNT;
    static  final int DISPLAY_HEIGHT = FONT_ROWS;
    public static void main(String[] args) {

        while (true) {
            LocalTime now = java.time.LocalTime.now();
            int[] digits = new int[DIGITS_COUNT];
            digits[0] = now.getHour() / 10;
            digits[1] = now.getHour() % 10;
            digits[2] = 10;
            digits[3] = now.getMinute() / 10;
            digits[4] = now.getMinute() % 10;
            digits[5] = 10;
            digits[6] = now.getSecond() / 10;
            digits[7] = now.getSecond() % 10;

            for (int y = 0; y < DISPLAY_HEIGHT; y++) {
                for (int x = 0; x < DISPLAY_WIDTH; x++) {
                    int i = x / (FONT_COLS + DIGITS_PAD);
                    int dx = x % (FONT_COLS + DIGITS_PAD);
                    if (dx < FONT_COLS && ((FONT[digits[i]]>> ((FONT_ROWS - y - 1)*FONT_COLS + dx))&1) != 0) {
                        System.out.print("\033[1;31m█\033[0m");
                    } else {
                        System.out.print("█");
                    }
                }
                System.out.print("\n");
            }
            System.out.printf("\n\u001B[%dA\u001B[%dD", DISPLAY_HEIGHT + 1, DISPLAY_WIDTH);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}
