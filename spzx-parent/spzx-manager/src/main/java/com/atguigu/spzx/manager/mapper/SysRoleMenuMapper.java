package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.dto.system.AssginMenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper {

    // 询角色分配过菜单id列表
    List<Long> findSysRoleMenuByRoleId(Long roleId);

    //删除角色分配菜单数据
    void deleteByRoleId(Long roleId);

    //保存分配数据
    void doAssign(AssginMenuDto assginMenuDto);

    //把父菜单isHalf半开状态 1
    void updateSysRoleMenuIsHalf(Long menuId);
}
