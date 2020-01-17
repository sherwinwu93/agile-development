package isp;

import java.sql.Time;

/**
 * @author wusd
 * @date 2020/1/17 20:14
 */
public abstract class TimedDoor implements Door {
    public abstract void doorTimeOut(int timeOutId);
}

/**
 * 适配器,参考Door定时器适配器
 * 每次注册一个超时请求,都要去创建一个新的对象.此外委托处理会导致一些很小但仍然存在的运行时间和内存的开销.
 * 嵌入式实时控制系统,其中内存和运行时间都非常宝贵.
 */
class DoorTimeAdapter implements TimerClient {
    private TimedDoor itsTimedDoor;
    public DoorTimeAdapter(TimedDoor theDoor) {
        itsTimedDoor = theDoor;
    }

    @Override
    public void timeOut(int timeOutId) {
        itsTimedDoor.doorTimeOut(timeOutId);
    }
}
