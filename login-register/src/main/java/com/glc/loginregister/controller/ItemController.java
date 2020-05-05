package com.glc.loginregister.controller;


import com.glc.loginregister.entity.Item;
import com.glc.loginregister.entity.Message;
import com.glc.loginregister.entity.PageBean;
import com.glc.loginregister.entity.User;
import com.glc.loginregister.mapper.ItemMapper;
import com.glc.loginregister.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private ItemService itemService;

    /**
     * 分页显示所有数据
     * @param currentPage
     * @param pageSize
     * @return
     *
     *
     * http://localhost:8080/item/findByPage?currentPage=1&pageSize=10
     */
    @RequestMapping("/findByPage")
    @ResponseBody
    public PageBean itemsPage( int currentPage, int pageSize){
        return itemService.findItemByPage(currentPage,pageSize);
    }


    /**
     * 根据book_name名称查询记录信息
     * @param name
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/findByPageName")
    @ResponseBody
    public PageBean itemsPageByName(String name,int currentPage, int pageSize){
        return itemService.findItemByName(name,currentPage,pageSize);
    }

    /**
     * 添加
     * @param item
     * @return
     */
    @RequestMapping("/insertItem")
    @ResponseBody
    public Message insertItem(Item item){
        Integer integer = itemService.insertItem(item);
        Message message=new Message();
        if(integer>=1){
             message.setInfo("添加成功");
             return message;
        }else {
             message.setInfo("添加失败");
             return message;
        }
    }


    /**
     * 删除
     * @param
     * @return
     */
    @RequestMapping("/deleteItem")
    @ResponseBody
    public Message deleteItem(int id){
        Integer integer = itemService.deleteItem(id);
        Message message=new Message();
        if(integer>=1){
            message.setInfo("删除成功");
            return message;
        }else {
            message.setInfo("删除失败");
            return message;
        }
    }


    /**
     * 修改
     *
     * @param item
     * @return
     */
    @RequestMapping("/updateItem")
    @ResponseBody
    public Message updateItem(Item item){
        Integer integer = itemService.updateItem(item);
        Message message=new Message();
        if(integer>=1){
            message.setInfo("修改成功");
            return message;
        }else {
            message.setInfo("修改失败");
            return message;
        }
    }



}
