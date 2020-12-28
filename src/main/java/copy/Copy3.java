package copy;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author wusd
 * @date 2020/1/15 0:29
 */
public class Copy3 {
    boolean ptFlag = false;
    boolean punchFlag = false;
    //remember to reset this flag
    public void copy() {
        Scanner scan = new Scanner(System.in);
        String next = scan.next();
        while (scan.hasNext()) {
            if (ptFlag) {
                if (punchFlag) {
                    System.out.println(scan.next());
                } else {
                    PrintWriter printWriter = new PrintWriter(System.out);
                    printWriter.print(scan.next());
                }
            } else {
                if (punchFlag) {
                    System.out.println(scan.nextInt());
                } else {
                    PrintWriter printWriter = new PrintWriter(System.out);
                    printWriter.print(scan.nextInt());
                }
            }
        }
    }
}
