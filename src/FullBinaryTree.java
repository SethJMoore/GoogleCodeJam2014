import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Seth on 4/11/2014.
 */
public class FullBinaryTree {
    private static PrintWriter out;

    private static boolean notADraw = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        Scanner scanner = new Scanner(br);

        out = new PrintWriter("output.txt");

        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= t; i++) {
            int y = 0;
            int n = Integer.parseInt(scanner.nextLine());
//            if (n == 2) {
//                y = 1;
//                scanner.nextLine();
//            }
//            else if (n == 3) {
//                y = 0;
//                scanner.nextLine();
//                scanner.nextLine();
//            }
//            else {
                BTree bTree = new BTree();
                for (int j = 0; j < n - 1; j++) {
                    String[] xY = scanner.nextLine().split(" ");
                    bTree.addEdge(Integer.parseInt(xY[0]), Integer.parseInt(xY[1]));
                }

                y = bTree.pruneToFullBinary();
//            }
            out.println("Case #" + i + ": " + y);
        }

        out.close();
    }
}

/*  Problem Description:

A tree is a connected graph with no cycles.

A rooted tree is a tree in which one special vertex is called the root. If there is an edge between X and Y in a rooted tree, we say that Y is a child of X if X is closer to the root than Y (in other words, the shortest path from the root to X is shorter than the shortest path from the root to Y).

A full binary tree is a rooted tree where every node has either exactly 2 children or 0 children.

You are given a tree G with N nodes (numbered from 1 to N). You are allowed to delete some of the nodes. When a node is deleted, the edges connected to the deleted node are also deleted. Your task is to delete as few nodes as possible so that the remaining nodes form a full binary tree for some choice of the root from the remaining nodes.

Input

The first line of the input gives the number of test cases, T. T test cases follow. The first line of each test case contains a single integer N, the number of nodes in the tree. The following N-1 lines each one will contain two space-separated integers: Xi Yi, indicating that G contains an undirected edge between Xi and Yi.

Output

For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the minimum number of nodes to delete from G to make a full binary tree.

Limits

1 ≤ T ≤ 100.
1 ≤ Xi, Yi ≤ N
Each test case will form a valid connected tree.

Small dataset

2 ≤ N ≤ 15.
Large dataset

2 ≤ N ≤ 1000.
Sample


Input

Output

3
3
2 1
1 3
7
4 5
4 2
1 2
3 1
6 4
3 7
4
1 2
2 3
3 4

Case #1: 0
Case #2: 2
Case #3: 1

In the first case, G is already a full binary tree (if we consider node 1 as the root), so we don't need to do anything.

In the second case, we may delete nodes 3 and 7; then 2 can be the root of a full binary tree.

In the third case, we may delete node 1; then 3 will become the root of a full binary tree (we could also have deleted node 4; then we could have made 2 the root).
 */

