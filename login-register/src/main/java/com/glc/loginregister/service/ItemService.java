package com.glc.loginregister.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glc.loginregister.entity.Item;
import com.glc.loginregister.entity.PageBean;
import com.glc.loginregister.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;


    public PageBean findItemByPage(Integer currentPage, Integer pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);

        List<Item> allItems = itemMapper.listItem();        //全部商品
        int countNums = itemMapper.countItem();            //总记录数
        PageBean<Item> pageBean =new PageBean<>();
        pageBean.setItems(allItems);//分页结果
        pageBean.setCurrentPage(currentPage);//当前页
        pageBean.setPageSize(pageSize);//设置每页显示条数
        pageBean.setTotalNum(countNums);//设置总条数


        //计算分页数
        int pageConnt=(countNums+pageSize-1)/pageSize;
        pageBean.setTotalPage(pageConnt);//设置总页数
        if(currentPage<pageConnt){
                pageBean.setIsMore(1);
        }else {
           pageBean.setIsMore(0);
        }
        return pageBean;
    }


    public PageBean findItemByName(String name,Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage, pageSize);
        Map param=new HashMap<>();
        param.put("name",name);
        List<Item> items = itemMapper.listItemByName(name);
        int countNums = itemMapper.countItemByName(name);
        PageBean<Item> pageBean =new PageBean<>();
        pageBean.setItems(items);//分页结果
        pageBean.setCurrentPage(currentPage);//当前页
        pageBean.setPageSize(pageSize);//设置每页显示条数
        pageBean.setTotalNum(countNums);//设置总条数

        //计算分页数
        int pageConnt=(countNums+pageSize-1)/pageSize;
        pageBean.setTotalPage(pageConnt);//设置总页数
        if(currentPage<pageConnt){
            pageBean.setIsMore(1);
        }else {
            pageBean.setIsMore(0);
        }
        return pageBean;
    }

    public Integer countItem() {
        return itemMapper.countItem();
    }


    /**
     * 添加
     * @param item
     * @return
     */
    public  Integer insertItem(Item item){
        return itemMapper.insertItem(item);
    }


    /**
     * 删除
     * @param id
     * @return
     */
   public Integer deleteItem(int id){
        return itemMapper.deleteItem(id);
   }

    /**
     * 修改
     */
    public Integer updateItem(Item item){
        return itemMapper.updateItem(item);
    }
}
