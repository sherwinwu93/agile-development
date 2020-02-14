package nullobject;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author wusd
 * @date 2020/2/14 14:28
 */
public class EmployeeTest {

    @Test
    public void dnull() throws Exception {
        Employee e = DB.getEmployee("Bob");
        if (e.isTimeToPay(new Date()))
            fail();
        assertEquals(Employee.NULL, e);
    }

}