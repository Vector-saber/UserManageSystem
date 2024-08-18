package nk.lx.ums_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import nk.lx.ums_backend.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> getAllUsers();

    List<User> getUsersPage(Integer currentPage, Integer pageSize);

    Long getUserCount();

}