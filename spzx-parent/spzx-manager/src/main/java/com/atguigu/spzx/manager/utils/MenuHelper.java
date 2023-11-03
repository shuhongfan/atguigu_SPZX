package com.atguigu.spzx.manager.utils;

import com.atguigu.spzx.model.entity.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

//封装树形菜单数据
public class MenuHelper {

    //递归实现封装过程
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        //sysMenuList所有菜单集合
        //创建list集合，用于封装最终的数据
        List<SysMenu> trees = new ArrayList<>();
        //遍历所有菜单集合
        for(SysMenu sysMenu:sysMenuList) {
            //找到递归操作入口，第一层的菜单
            //条件： parent_id=0
            if(sysMenu.getParentId().longValue()==0) {
                //根据第一层，找下层数据，使用递归完成
                //写方法实现找下层过程，
                // 方法里面传递两个参数：第一个参数当前第一层菜单，第二个参数是所有菜单集合
                trees.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }

    //递归查找下层菜单
    public static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> sysMenuList) {
        // SysMenu有属性 private List<SysMenu> children;封装下一层数据
        sysMenu.setChildren(new ArrayList<>());
        //递归查询
        // sysMenu的id值 和  sysMenuList中parentId相同
        for(SysMenu it:sysMenuList) {
            //判断id 和  parentid是否相同
            if(sysMenu.getId().longValue() == it.getParentId().longValue()) {
                // it就是下层数据，进行封装
                sysMenu.getChildren().add(findChildren(it,sysMenuList));
            }
        }
        return sysMenu;
    }
}
