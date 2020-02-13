package singleton.usage;

/**
 * @author wusd
 * @date 2020/2/13 21:44
 */
public class UserDatabaseSource implements UserDatabase {
    private static UserDatabase theInstance = new UserDatabaseSource();
    public static UserDatabase instance() {
        return theInstance;
    }
    @Override
    public User readUser(String username) {
        return null;
    }

    @Override
    public void writeUser(User user) {

    }
}
