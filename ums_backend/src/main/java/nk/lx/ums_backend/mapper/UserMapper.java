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

    @Select("select count(*) from user where valid=1")
    Long getUserCount();

    @Update("update user set valid = #{valid} where id = #{id}")
    void updateValid(@Param("id")Integer id,@Param("valid")Integer valid);

    @Update("update user set user_name=#{userName},true_name=#{trueName},telephone=#{telephone},email=#{email} where id=#{id}")
    void updateUser(@Param("id")Integer id,
                    @Param("userName")String userName,@Param("trueName")String trueName,
                    @Param("telephone")String telephone,@Param("email")String email);

    @Insert("insert into user (user_name,true_name,telephone,email) values(#{userName},#{trueName},#{telephone},#{email})")
    void insertUser(@Param("userName")String userName,@Param("trueName")String trueName,
                    @Param("telephone")String telephone,@Param("email")String email);

    @Select("select * from user where ${str} like '%${value}%' limit #{currentPage},#{pageSize} ")
    List<User> getUserLike(@Param("str")String str, @Param("value")String value,@Param("currentPage")Integer currentPage
            ,@Param("pageSize")Integer pageSize);

    @Select("select count(*) from user where ${str} like '%${value}%' ")
    Long getUserLikeCount(@Param("str")String str, @Param("value")String value);

}
