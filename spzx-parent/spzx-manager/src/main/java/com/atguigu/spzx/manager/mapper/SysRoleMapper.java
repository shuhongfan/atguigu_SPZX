package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.dto.system.SysRoleDto;
import com.atguigu.spzx.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    //角色列表的方法
    List<SysRole> findByPage(SysRoleDto sysRoleDto);

    //2 角色添加的方法
    void save(SysRole sysRole);

    //3 角色修改的方法
    void update(SysRole sysRole);

    //4 角色删除的方法
    void delete(Long roleId);

    //查询所有角色
    List<SysRole> findAll();
}
