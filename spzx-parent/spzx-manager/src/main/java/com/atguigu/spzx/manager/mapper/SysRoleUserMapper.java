package com.atguigu.spzx.manager.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleUserMapper {
    //1 根据userId删除用户之前分配角色数据
    void deleteByUserId(Long userId);

    //2 重新分配新数据
    void doAssign(Long userId, Long roleId);

    //根据userId查询用户分配过角色id列表
    List<Long> selectRoleIdsByUserId(Long userId);
}
