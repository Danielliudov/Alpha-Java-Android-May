import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Bounce {
    private static void fakeInput() {
        String input = "1 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        //fakeInput();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        long[] powsTwo = new long[n + m - 1];
        powsTwo[0] = 1;
        for (int i = 1; i < n + m - 1; i++) {
            powsTwo[i] = powsTwo[i - 1] * 2;
        }

        int currentR = 0;
        int currentC = 0;
        int horizontal = 1;
        int vertical = 1;
        long result = 1;

        if (m == 1 || n == 1) {
            System.out.println(result);
            return;
        }

        while (true) {
            int nextR = currentR + vertical;
            int nextC = currentC + horizontal;
            if (nextR < 0 || n <= nextR) {
                vertical *= -1;
            }
            if (nextC < 0 || m <= nextC) {
                horizontal *= -1;
            }
            currentR += vertical;
            currentC += horizontal;

            result += powsTwo[currentR + currentC];

            if ((currentR == 0 && currentC == 0) ||
                    (currentR == 0 && currentC == m - 1) ||
                    (currentR == n - 1 && currentC == 0) ||
                    (currentR == n - 1 && currentC == m - 1)) {
                break;
            }
        }

        System.out.println(result);
    }
}
