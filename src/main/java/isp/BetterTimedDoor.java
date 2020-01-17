package isp;

/**
 * @author wusd
 * @date 2020/1/17 20:25
 */
public abstract class BetterTimedDoor implements Door, TimerClient{
    abstract void doorTimeOut(int timeOutId);
}
