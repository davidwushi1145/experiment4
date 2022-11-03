package tech.wushi.experiment4.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.wushi.experiment4.Entity.Student;

import javax.transaction.Transactional;

public interface IStudentDao extends JpaRepository<Student,Long> {
    Student findStudentByNameAndPassword(String name,String password);
    Student findStudentById(Long id);
    @Modifying
    @Transactional
    int deleteStudentById(Long id);
    @Transactional
    @Modifying
    @Query("update Student s set s.name=?1 where s.id=?2")
    int UpdateStudentNameById(String name,Long id);
}


