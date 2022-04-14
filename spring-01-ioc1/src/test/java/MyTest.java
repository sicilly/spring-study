import com.sicilly.dao.UserDaoImpl;
import com.sicilly.dao.UserDaoMysqlImpl;
import com.sicilly.dao.UserDaoOracleImpl;
import com.sicilly.dao.UserDaoSqlserverImpl;
import com.sicilly.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        // 用户实际调用的是业务层，不需要接触dao层
        UserServiceImpl userService = new UserServiceImpl();

//        userService.setUserDao(new UserDaoImpl());
//        userService.setUserDao(new UserDaoMysqlImpl());
//        userService.setUserDao(new UserDaoOracleImpl());
        userService.setUserDao(new UserDaoSqlserverImpl());


        userService.getUser();

    }
}
