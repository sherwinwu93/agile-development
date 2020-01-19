package templateMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author wusd
 * @date 2020/1/19 23:33
 */
public class Ftocraw {
    //todo 需要实实在在debug一次,搞清执行过程
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        boolean done = false;
        while (!done) {
            String fahrString = br.readLine();
            if (fahrString == null || fahrString.length() == 0) {
                done = true;
            } else {
                double fahr = Double.parseDouble(fahrString);
                double celcius = 5.0 / 9.0 * (fahr - 32);
                System.out.println("F=" + fahr + ", C=" + celcius);
            }
        }
        System.out.println("ftoc exit");
    }
}
