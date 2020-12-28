package lsp.subtle;

/**
 * 继承是 IS-A ("是一个")
 * IS-A: 面向对象分析(OOA)基本技术之一
 * @author wusd
 * @date 2020/1/15 23:29
 */
public class Square extends Rectangle{
    @Override
    public void setItsWidth(double itsWidth) {
        super.setItsWidth(itsWidth);
        super.setItsHeight(itsWidth);
    }

    @Override
    public void setItsHeight(double itsHeight) {
        super.setItsWidth(itsHeight);
        super.setItsHeight(itsHeight);
    }
}
