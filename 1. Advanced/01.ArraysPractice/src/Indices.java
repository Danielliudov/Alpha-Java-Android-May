import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Indices {
    private static void fakeInput() {
        String input = "6\n" +
                "1 2 3 5 7 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        //fakeInput();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            used[i] = false;
        }

        ArrayList<Integer> result = new ArrayList();

        int cycleStartIndex = -1;
        int currentIndex = 0;
        while (-1 < currentIndex && currentIndex < n) {
            if (used[currentIndex]) {
                cycleStartIndex = currentIndex;
                break;
            }

            used[currentIndex] = true;
            result.add(currentIndex);
            currentIndex = numbers[currentIndex];
        }

        StringBuilder output = new StringBuilder();
        for (int x : result) {
            if (x == cycleStartIndex) {
                output.append("(");
            }
            output.append(x);
            output.append(" ");
        }

        if(cycleStartIndex!=-1) {
            output.append(")");
        }
        String outputString = output.toString();
        outputString = outputString.replace(" (", "(");
        outputString = outputString.replace(" )", ")");
        outputString = outputString.trim();

        System.out.println(outputString);
    }
}
