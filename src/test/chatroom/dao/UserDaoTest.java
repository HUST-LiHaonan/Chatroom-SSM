package chatroom.dao;

import chatroom.BaseTest;
import com.lhn.chatroom.Dao.UserDao;
import com.lhn.chatroom.Entity.User;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lhn on 2017/3/3.
 */
@Transactional
public class UserDaoTest extends BaseTest{
    @Resource
    UserDao userDao;

    @Test
    public void testGetById(){
        User user = userDao.getById(1);
        System.out.println(user.toString());
    }

    @Test
    public void testGetByName(){
        User user = userDao.getByName("Nick");
        System.out.println(user.toString());
    }

    @Test
    public void testRegisterByName(){
        User user = new User();
        user.setName("Lhnxxx");
        user.setPassword("123456");
        int flag =userDao.registerByName(user);
        System.out.print(flag);
    }

    @Test
    public void testGetAllUser(){
        List<User> userList = userDao.getAllUser();
        System.out.print(userList);
    }

    @Test
    public void testGetUser(){
        Map<String,Object> userMap = userDao.getUser(1);
        for (Map.Entry<String, Object> user : userMap.entrySet())
        {
            System.out.println(user.getKey() + " : " + user.getValue());
        }
    }
}
