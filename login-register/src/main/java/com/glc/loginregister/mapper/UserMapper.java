package com.glc.loginregister.mapper;


import com.glc.loginregister.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper
@Repository
public interface UserMapper {


    /**
     *查看用户名是否已经存在
     * @param username
     * @return
     */
    @Select("select u.username,u.password from usermessage u where u.username=#{username}")
    User findUserByName(@Param("username") String username);


    @Select("SELECT * FROM usermessage WHERE id=#{id}")
    User findUserById(@Param("id") Long id);


    /**
     * 注册
     * @param user
     */
    @Insert("insert into usermessage values(#{id},#{username},#{password},#{address},#{phone})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void register(User user);


    /**
     * 登录
     * @param user
     * @return
     */
    @Select("select u.id from usermessage u where u.username=#{username} and password=#{password}")
    Long login(User user);

}
