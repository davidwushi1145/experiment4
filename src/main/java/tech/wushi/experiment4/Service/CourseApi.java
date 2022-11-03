package tech.wushi.experiment4.Service;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.wushi.experiment4.Dao.ICourseDao;

/**
 * @author Davidlee
 * @version 1.0
 * Create by 2022/10/21 14:55
 */
@Api(tags = "课程信息管理")
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/course")
public class CourseApi {
    @Autowired
    private ICourseDao courseDao;

    @GetMapping(value = "/list")
    @ApiOperation(value = "课程列表")
    public Object list() {
        return courseDao.findAll();
    }

    @GetMapping(value = "/listById")
    @ApiOperation(value = "课程列表id")
    @ApiImplicitParam(name = "id", value = "课程序号", required = true, dataType = "Long")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public Object listById(@RequestParam Long Id) {
        return courseDao.findCourseById(Id);
    }

    @GetMapping(value = "/listByName")
    @ApiOperation(value = "课程列表name")
    @ApiImplicitParam(name = "name", value = "课程名", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public Object listByName(@RequestParam String name) {
        return courseDao.findCourseByName(name);
    }

    @GetMapping(value = "/listByTeacher")
    @ApiOperation(value = "课程列表teacher")
    @ApiImplicitParam(name = "teacher", value = "教师名", required = true, dataType = "String")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public Object listByTeacher(@RequestParam String teacher) {
        return courseDao.findCoursesByTeacher(teacher);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "课程更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "课程序号", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "name", value = "课程名", required = true, dataType = "String"),
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public boolean update(@RequestParam String name, @RequestParam Long id) {
        try {
            courseDao.UpdateCourseNameById(name, id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
