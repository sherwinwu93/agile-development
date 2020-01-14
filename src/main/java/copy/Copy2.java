package copy;

import java.util.Scanner;

/**
 * @author wusd
 * @date 2020/1/15 0:29
 */
public class Copy2 {
    boolean ptFlag = false;
    //remember to reset this flag
    public void copy() {
        Scanner scan = new Scanner(System.in);
        String next = scan.next();
        while (scan.hasNext()) {
            if (ptFlag) {
                System.out.println(scan.next());
            } else {
                System.out.println(scan.nextInt());
            }
        }
    }
}
