package lsp.collection;

import java.util.Iterator;

/**
 * @author wusd
 * @date 2020/1/16 0:20
 */
public abstract class Set<T> implements Iterable<T>{
    public abstract void add(T t);

    public abstract void delete(T t);

    public abstract boolean isMemeber(T t);

    public static <T> void printSet(Set<T> s) {
        Iterator<T> iterator = s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
