import com.sicilly.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 获取ApplicationContext,拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 容器在手，天下我有，需要什么就get什么
        UserService userServiceImpl = (UserService)context.getBean("UserServiceImpl");
        userServiceImpl.getUser();

    }
}
