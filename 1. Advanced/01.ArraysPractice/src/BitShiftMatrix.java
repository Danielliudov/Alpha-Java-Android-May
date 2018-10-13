import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class BitShiftMatrix {
    private static void fakeInput() {
        String input = "5 \n" +
                "6\n" +
                "4\n" +
                "14 27 1 5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        //fakeInput();
        Scanner in = new Scanner(System.in);

        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        int[] cells = new int[n];
        for (int i = 0; i < n; i++) {
            cells[i] = in.nextInt();
        }

        BigInteger[] powsTwo = new BigInteger[r + c - 1];
        BigInteger powTwo = BigInteger.ONE;
        for (int i = 0; i < r + c - 1; i++) {
            powsTwo[i] = powTwo;
            powTwo = powTwo.multiply(BigInteger.valueOf(2));
        }

        boolean[][] matrix = new boolean[r][c];
        int coef = Math.max(r, c);
        int currentR = r - 1;
        int currentC = 0;
        BigInteger result = BigInteger.ZERO;
        for (int cell : cells) {
            int targetR = cell / coef;
            int targetC = cell % coef;

            int horizontalDirection;
            if (currentC <= targetC) {
                horizontalDirection = 1;
            } else {
                horizontalDirection = -1;
            }

            int verticalDirection;
            if (currentR <= targetR) {
                verticalDirection = 1;
            } else {
                verticalDirection = -1;
            }

            while (currentC != targetC || currentR != targetR) {
                if (!matrix[currentR][currentC]) {
                    matrix[currentR][currentC] = true;
                    int pow = r - currentR + currentC - 1;
                    result = result.add(powsTwo[pow]);
                }

                if (currentC != targetC) {
                    currentC += horizontalDirection;
                    continue;
                }
                if (currentR != targetR) {
                    currentR += verticalDirection;
                }
            }
        }

        if (!matrix[currentR][currentC]) {
            matrix[currentR][currentC] = true;
            int pow = r - currentR + currentC - 1;
            result = result.add(powsTwo[pow]);
        }

        System.out.println(result);
    }
}
