package tech.wushi.experiment4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.wushi.experiment4.Dao.ICourseDao;
import tech.wushi.experiment4.Entity.Course;

/**
 * @author Davidlee
 * @version 1.0
 * Create by 2022/10/21 12:23
 */
@SpringBootTest
public class CourseDaoTest {
    @Autowired
    private ICourseDao cDao;

    @Test
    public void insertCourse() {
        Course c = new Course();
        c.setName("java");
        c.setCredit(3);
        c.setTeacher("David");
        cDao.save(c);
    }
    @Test
    public void findCourseById(){
        Course c = cDao.findCourseById(6L);
        System.out.println(c.getName()+" "+c.getCredit()+" "+c.getTeacher());
    }
    @Test
    public void updateCourseNameById(){
        int i = cDao.UpdateCourseNameById("C#",6L);
        System.out.println(i);
    }
    @Test
    public void deleteCourseById(){
        int i = cDao.deleteCourseById(6L);
        System.out.println(i);
    }
}
