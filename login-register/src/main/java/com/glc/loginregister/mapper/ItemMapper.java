package com.glc.loginregister.mapper;

import com.glc.loginregister.entity.Item;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMapper {

    /**
     * 查询所有记录
     * @return
     */
    @Select("SELECT * FROM item")
    public List<Item> listItem();

    /**
     * 查询总数
     * @return
     */
    @Select("SELECT count(*) from item")
    Integer countItem();


    @Select("SELECT * FROM item WHERE book_name LIKE '%${value}%'")
    public List<Item> listItemByName(String name);


    /**
     * 模糊查询的总记录数
     * @return
     */
    @Select("SELECT COUNT(*)  FROM item WHERE book_name LIKE '%${value}%';")
    Integer countItemByName(String name);


    /**
     * 添加
     * @param item
     * @return
     */
    @Insert("INSERT INTO item (id, book_name, book_img, book_author, book_info, book_download, book_FileSize)\n" +
            "    VALUES(#{id},#{book_name},#{book_img},#{book_author},#{book_info},#{book_download},#{book_FileSize});")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer insertItem(Item item);


    /**
     * 删除
     * @param id
     * @return
     */
    @Delete(" DELETE FROM item WHERE id=#{id}")
    Integer deleteItem(int id);


    /**
     * 修改
     * @param item
     * @return
     */
    @Update("UPDATE item SET book_name=#{book_name},book_img=#{book_img},book_author=#{book_author},book_info=#{book_info},book_download=#{book_download},book_FileSize=#{book_FileSize} WHERE id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    Integer updateItem(Item item);
}
