package salaryimpl;

import org.joda.time.DateTime;

/**
 * 支付安排接口
 *
 * 支付薪水时间表和支付类别之间的关联是非本质的.
 * 用来确定支付期的函数应该属于PaymentSchedule类,而不应该属于PaymentClassification类.
 * todo UMl图并没有帮助我们捕捉到这个问题.只是在考虑UnionAffiliation的测试用例时才显现出来.
 * todo 再一次说明了代码反馈对于任何设计是多么的必要.
 * todo 图示是有用的,但是没有代码反馈的情况下依赖它们就是冒险行为.
 * @author wusd
 * @date 2020/2/15 22:50
 */
public interface PaymentSchedule {
    /**
     * 是否是发薪日
     * @param date
     * @return
     */
    boolean isPayDate(DateTime date);
    DateTime getPayPeriodStartDate(DateTime payPeriodEndDate);
}
