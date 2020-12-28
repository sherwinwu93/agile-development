package singleton.monostate;

/**
 * @author wusd
 * @date 2020/2/14 0:21
 */
public class Monostate {
    private static int itsX = 0;
    public Monostate() {}
    public void setX(int x) {
        itsX = x;
    }
    public int getX() {
        return itsX;
    }
}
