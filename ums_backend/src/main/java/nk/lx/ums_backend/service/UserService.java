package nk.lx.ums_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import nk.lx.ums_backend.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> getAllUsers();

    List<User> getUsersPage(Integer currentPage, Integer pageSize);

    Long getUserCount();

    void updateValid(Integer id,Integer valid);

    void updateUser(Integer id, String userName, String trueName, String telephone, String email);

    void insertUser(String userName, String trueName, String telephone, String email);

    List<User> getUserLike(String str, String value, Integer currentPage, Integer pageSize);

    Long getUserLikeCount(String str, String value);

}