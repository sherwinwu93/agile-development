package dip;

/**
 * @author wusd
 * @date 2020/1/17 0:18
 */
public class Button {
    private Lamp itsLamp;

    /**
     * 高层策略没有和低层实现分离.
     * 抽象没有和具体细节分离.
     * 没有这种分离,高层策略就自动地依赖于低层模块,抽象就自动地依赖于具体细节
     * @param f
     */
    public void poll(boolean f) {
        if (f) {
            itsLamp.turnOn();
        } else {
            itsLamp.turnOff();
        }
    }
}
class Lamp {
    void turnOn() {}
    void turnOff() {}
}
