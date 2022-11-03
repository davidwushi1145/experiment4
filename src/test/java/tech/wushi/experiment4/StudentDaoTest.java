package tech.wushi.experiment4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wushi.experiment4.Dao.IStudentDao;
import tech.wushi.experiment4.Entity.Student;

/**
 * @author Davidlee
 * @version 1.0
 * Create by 2022/10/20 16:42
 */
@SpringBootTest
public class StudentDaoTest {
    @Autowired
    private IStudentDao sDao;
    @Test
    public void insertStudent(){
        Student s = new Student();
        s.setAge(18);
        s.setName("david");
        s.setSex(true);
        s.setPassword("123456");
        sDao.save(s);
    }
    @Test
    public void updateStudentNameById(){
        int i =sDao.UpdateStudentNameById("David",2L);
        System.out.println(i);
    }
    @Test
    public void findStudentById(){
        Student s=sDao.findStudentById(2L);
        System.out.println(s.getName()+" "+s.getAge()+" "+s.getSex());
    }
    @Test
    public void deleteStudentById(){
        int i=sDao.deleteStudentById(5L);
        System.out.println(i);
    }
}
