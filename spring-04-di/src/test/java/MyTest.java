import com.sicilly.pojo.Student;
import com.sicilly.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user", User.class);

        User user1 = context.getBean("user2", User.class);
        User user2 = context.getBean("user2", User.class);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1==user2);
    }
}
