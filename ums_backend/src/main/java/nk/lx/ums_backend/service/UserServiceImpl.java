package nk.lx.ums_backend.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import nk.lx.ums_backend.entity.User;
import nk.lx.ums_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userMapper.selectAll();
    }

    @Override
    public List<User> getUsersPage(Integer currentPage, Integer pageSize) {
        return userMapper.selectUsersPage(currentPage,pageSize);
    }

    @Override
    public Long getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public void updateValid(Integer id, Integer valid) {
        userMapper.updateValid(id, valid);
    }

    @Override
    public void updateUser(Integer id, String userName, String trueName, String telephone, String email) {
        userMapper.updateUser(id,userName,trueName,telephone,email);
    }

    @Override
    public void insertUser(String userName, String trueName, String telephone, String email) {
        userMapper.insertUser(userName,trueName,telephone,email);
    }

}
