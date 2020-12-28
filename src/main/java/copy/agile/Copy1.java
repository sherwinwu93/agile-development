package copy.agile;

import java.util.Scanner;

/**
 * @author wusd
 * @date 2020/1/15 0:26
 */
public class Copy1 {
    void copy() {
        Scanner scan = new Scanner(System.in);
        String next = scan.next();
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
    }
}
