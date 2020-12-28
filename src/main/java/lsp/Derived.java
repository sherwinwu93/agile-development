package lsp;

/**
 * @author wusd
 * @date 2020/1/16 23:20
 */
public class Derived extends Base {
    @Override
    public void f() {
        //退化了
    }
}
class Base {
    public void f() {
        System.out.println("Base.f()");
    }
}
