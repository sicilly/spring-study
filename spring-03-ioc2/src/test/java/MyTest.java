import com.sicilly.pojo.User;
import com.sicilly.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 拿到容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过beans.xml中定义好的id拿到bean，转成User类
        //  User user = (User)context.getBean("user");

        //  使用别名
//        User user = (User)context.getBean("userNew");

        UserT user = (UserT)context.getBean("u2");

        // 调用user中的方法show
        user.show();
    }
}
