import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Seth on 4/11/2014.
 */
public class CookieCutterAlpha {
    private static PrintWriter out;

    private static boolean notADraw = false;
    private static double C;
    private static double F;
    private static double X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Scanner scanner = new Scanner(br);

        out = new PrintWriter("output.txt");

        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            double numberOfCookies = 0;
            double time = Double.MAX_VALUE;
            double currentRate = 2.0;
            String[] line = scanner.nextLine().split(" ");
            C = Double.parseDouble(line[0]);
            F = Double.parseDouble(line[1]);
            X = Double.parseDouble(line[2]);

            //for (int cookieFarms = 0; cookieFarms < X; cookieFarms++) {
            for (int cookieFarms = 0; cookieFarms < 10000; cookieFarms++) { // Probably won't work for large problem set, but I'll try it.
                double thisTime = getTime(cookieFarms, currentRate);
                if (thisTime < time){
                    time = thisTime;
                }
            }

            out.println("Case #" + i + ": " + time);
        }

        out.close();
    }

    private static double getTime(int cookieFarms, double currentRate) {
        if (cookieFarms == 0){
            return X/currentRate;
        }
        else {
            return C/currentRate + getTime(cookieFarms - 1, currentRate + F);
        }
    }
}

/* Problem:


In this problem, you start with 0 cookies. You gain cookies at a rate of 2 cookies per second, by clicking on a giant cookie. Any time you have at least C cookies, you can buy a cookie farm. Every time you buy a cookie farm, it costs you C cookies and gives you an extra F cookies per second.

Once you have X cookies that you haven't spent on farms, you win! Figure out how long it will take you to win if you use the best possible strategy.

Example

Suppose C=500.0, F=4.0 and X=2000.0. Here's how the best possible strategy plays out:

You start with 0 cookies, but producing 2 cookies per second.
After 250 seconds, you will have C=500 cookies and can buy a farm that produces F=4 cookies per second.
After buying the farm, you have 0 cookies, and your total cookie production is 6 cookies per second.
The next farm will cost 500 cookies, which you can buy after about 83.3333333 seconds.
After buying your second farm, you have 0 cookies, and your total cookie production is 10 cookies per second.
Another farm will cost 500 cookies, while you can buy after 50 seconds.
After buying your third farm, you have 0 cookies, and your total cookie production is 14 cookies per second.
Another farm would cost 500 cookies, but it actually makes sense not to buy it: instead you can just wait until you have X=2000 cookies, which takes about 142.8571429 seconds.
Total time: 250 + 83.3333333 + 50 + 142.8571429 = 526.1904762 seconds.
Notice that you get cookies continuously: so 0.1 seconds after the game starts you'll have 0.2 cookies, and π seconds after the game starts you'll have 2π cookies.

Input

The first line of the input gives the number of test cases, T. T lines follow. Each line contains three space-separated real-valued numbers: C, F and X, whose meanings are described earlier in the problem statement.

C, F and X will each consist of at least 1 digit followed by 1 decimal point followed by from 1 to 5 digits. There will be no leading zeroes.

Output

For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the minimum number of seconds it takes before you can have X delicious cookies.

We recommend outputting y to 7 decimal places, but it is not required. y will be considered correct if it is close enough to the correct number: within an absolute or relative error of 10-6. See the FAQ for an explanation of what that means, and what formats of real numbers we accept.

Limits

1 ≤ T ≤ 100.

Small dataset

1 ≤ C ≤ 500.
1 ≤ F ≤ 4.
1 ≤ X ≤ 2000.
Large dataset

1 ≤ C ≤ 10000.
1 ≤ F ≤ 100.
1 ≤ X ≤ 100000.
Sample


Input

Output

4
30.0 1.0 2.0
30.0 2.0 100.0
30.50000 3.14159 1999.19990
500.0 4.0 2000.0

Case #1: 1.0000000
Case #2: 39.1666667
Case #3: 63.9680013
Case #4: 526.1904762 */
