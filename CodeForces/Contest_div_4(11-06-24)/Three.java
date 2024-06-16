import java.util.*;

public class Three {
    public static void main(String[] args) {
        Scanner rs = new Scanner(System.in);
        int test_cases = rs.nextInt(); 
        for (int t = 0; t < test_cases; t++) {
            int m = rs.nextInt();
            int n = rs.nextInt();
            char cord[][] = new char[m][n];
            int start_x = -1;
            int start_y = -1;
            int end_x = -1;
            int end_y = -1;
            for (int m1 = 0; m1 < m; m1++) {
                String rowString = rs.next(); // Read the row as a string
                for (int n1 = 0; n1 < n; n1++) {
                    cord[m1][n1] = rowString.charAt(n1); // Get each character of the row
                    if (cord[m1][n1] == '#' && start_x == -1 && start_y == -1) {
                        start_x = m1 + 1;
                        start_y = n1 + 1;
                    }
                    if (cord[m1][n1] == '#') {
                        end_x = m1 + 1;
                        end_y = n1 + 1;
                    }
                }
            }
            int row = (start_x + end_x) / 2;
            System.out.println(row + " " + end_y);
        }
    }
}
