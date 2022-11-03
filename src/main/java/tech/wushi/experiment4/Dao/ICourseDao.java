package tech.wushi.experiment4.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.wushi.experiment4.Entity.Course;

import javax.transaction.Transactional;
import java.util.List;

public interface ICourseDao extends JpaRepository<Course,Long> {
    Course findCourseById(Long id);
    Course findCourseByName(String name);
    List<Course> findCoursesByTeacher(String teacher);
    @Transactional
    @Modifying
    int deleteCourseById(Long id);
    @Transactional
    @Modifying
    @Query("update Course s set s.name=?1 where s.id=?2")
    int UpdateCourseNameById(String name,Long id);
}

