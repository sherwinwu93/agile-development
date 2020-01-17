package isp;

/**
 * @author wusd
 * @date 2020/1/17 14:00
 */
public interface Door {
    void lock();
    void unlock();
    boolean isDoorOpen();
}
interface Timer {
    /**
     * TimerClient会在超时到达时被调用
     * @param timeout: 超时时间
     * @param client: 指向TimerClient对象
     */
    void register(int timeout, TimerClient client);
}
interface TimerClient {
//    void timeOut();
    //这个改变影响到timerClient的所有使用者.但是由于缺少timeOutId时一个必须要改正的错误,所以我们接受这种改变.
    //然而,这个修正还会影响到Door以及Door的所有客户端.这是僵化性和粘滞性的臭味.
    //如果程序部分更改会影响程序中完全和它无关的其他部分,那么更改的代价和影响就变得不可预测,并且更改所附带的风险也会急剧增加.

    void timeOut(int timeOutId);
}
