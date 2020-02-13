package singleton.usage;

/**
 * @author wusd
 * @date 2020/2/13 21:43
 */
public interface UserDatabase {
    User readUser(String username);
    void writeUser(User user);
}
