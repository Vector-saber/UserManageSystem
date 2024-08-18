package nk.lx.ums_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import nk.lx.ums_backend.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where valid=1 limit #{currentPage}, #{pageSize}")
    List<User> selectUsersPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    @Select("select count(*) from user")
    Long getUserCount();

    @Update("update user set valid = #{valid} where id = #{id}")
    void updateValid(@Param("id")Integer id,@Param("valid")Integer valid);

}
