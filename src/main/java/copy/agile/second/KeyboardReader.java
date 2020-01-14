package copy.agile.second;

import java.util.Scanner;

/**
 * @author wusd
 * @date 2020/1/15 0:42
 */
public class KeyboardReader extends Reader {
    Scanner scan = new Scanner(System.in);
    public int read() {
        return scan.nextInt();
    }
}
