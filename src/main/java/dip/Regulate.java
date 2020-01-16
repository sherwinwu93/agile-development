package dip;

import java.util.Scanner;

/**
 * @author wusd
 * @date 2020/1/17 0:30
 */
public class Regulate {
    public void regulate(double minTemp, double maxTemp) throws Exception {
        Scanner scan = new Scanner(System.in);
        for (;;) {
            while (scan.nextDouble() > minTemp) {
                Thread.sleep(1);
                System.out.println("engage");
            }
            while (scan.nextDouble() < minTemp) {
                Thread.sleep(1);
                System.out.println("disengage");
            }
        }
    }
}
