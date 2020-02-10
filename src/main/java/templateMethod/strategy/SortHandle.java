package templateMethod.strategy;

/**
 * @author wusd
 * @date 2020/2/10 22:18
 */
public interface SortHandle {
    void swap(int index);
    boolean outOfOrder(int index);
    int length();
    void setArray(Object array);
}
