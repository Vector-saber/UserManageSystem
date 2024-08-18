package nk.lx.ums_backend.controller;

import nk.lx.ums_backend.entity.User;
import nk.lx.ums_backend.service.UserService;
import nk.lx.ums_backend.vo.PageVO;
import nk.lx.ums_backend.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public ResponseVO<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return ResponseVO.success(userList);
    }


    @GetMapping("/getUsersPage")
    public ResponseVO<PageVO<User>> getUsersPage(@RequestParam("str")String str, @RequestParam("value") Object value, @RequestParam("currentPage")Integer currentPage, @RequestParam("pageSize")Integer pageSize){
        List<User> userList = new ArrayList<>();
        PageVO<User> page = new PageVO<>();
        Long userCount=0l;
        if (value==null||value.toString().length()==0) {
            userList = userService.getUsersPage((currentPage - 1) * pageSize, pageSize);
            userCount = userService.getUserCount();
        }
        page.setTotal(userCount);
        page.setPage(currentPage);
        page.setSize(pageSize);
        page.setData(userList);
        return ResponseVO.success(page);
    }


    @PostMapping("/deleteUser")
    public ResponseVO<?> deleteUser(@RequestParam("id")Integer id){
        userService.updateValid(id,0);
        return ResponseVO.success();
    }

    @PostMapping("/updateUser")
    public ResponseVO<?> updateUser(User user){
        userService.updateUser(user.getId(),user.getUserName(),user.getTrueName(),user.getTelephone(),user.getEmail());
        return ResponseVO.success();
    }

}
