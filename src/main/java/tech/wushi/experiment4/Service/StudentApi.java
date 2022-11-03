package tech.wushi.experiment4.Service;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wushi.experiment4.Dao.IStudentDao;
import tech.wushi.experiment4.Entity.Student;

/**
 * @author Davidlee
 * @version 1.0
 * Create by 2022/10/21 13:33
 */
@Api(tags = "学生信息管理")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/student")
public class StudentApi {
    @Autowired
    private IStudentDao studentDao;

//    @RequestMapping(value = "/logint",method = RequestMethod.GET)
//    @GetMapping(value = "/login/{name}/{password}")
//    public Student login1(@PathVariable String name,@PathVariable String password){
//        Student s= studentDao.findStudentByNameAndPassword(name,password);
//        if (s==null){
//            return null;
//        }else {
//            return s;
//        }
//    }

    @GetMapping(value = "/login")
    @ApiOperation(value = "学生登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "学生姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "学生密码", required = true, dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public Student login(@RequestParam String name, @RequestParam String password) {
        Student s= studentDao.findStudentByNameAndPassword(name,password);
        return s;
    }

    @PostMapping(value = "/register")
    @ApiOperation(value = "学生注册")
    @ApiImplicitParam(name = "student", value = "学生实体", required = true, dataType = "Student")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public boolean register(@RequestBody Student student) {
        try {
            studentDao.save(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "学生修改")
    @ApiImplicitParam(name = "student", value = "学生实体", required = true, dataType = "Student")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public boolean update(@RequestBody Student student) {
        try {
            studentDao.save(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "学生删除")
    @ApiImplicitParam(name = "id", value = "学生序号", required = true, dataType = "Long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public boolean delete(@RequestParam Long id) {
        try {
            studentDao.deleteStudentById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
