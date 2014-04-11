import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Seth on 4/11/2014.
 */
public class Template {
    private static PrintWriter out;

    private static boolean notADraw = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Scanner scanner = new Scanner(br);

        out = new PrintWriter("output.txt");

        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            String line1 = scanner.nextLine();
            out.println(line1);
        }

        out.close();
    }
}
