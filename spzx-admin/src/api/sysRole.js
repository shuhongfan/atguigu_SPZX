import request from '@/utils/request'

const base_api = '/admin/system/sysRole'

// 角色列表
export const GetSysRoleListByPage = (current,limit,queryDto) => {
  return request({
    // ``模板字符串
    url: `${base_api}/findByPage/${current}/${limit}`, //路径
    method: 'post', //提交方式
    // 接口@RequestBody 前端 data : 名称，以json格式传输
    // 接口没有注解 ， 前端 params: 名称
    data: queryDto, //其他参数
  })
}

//角色添加
export const SaveSysRole = (sysRole) =>{
  return request({
    // ``模板字符串
    url: `${base_api}/saveSysRole`, //路径
    method: 'post', //提交方式
    data: sysRole, //其他参数
  })
}

//角色修改
export const UpdateSysRole = (sysRole) =>{
  return request({
    // ``模板字符串
    url: `${base_api}/updateSysRole`, //路径
    method: 'put', //提交方式
    data: sysRole, //其他参数
  })
}

//角色删除
export const DeleteSysRole = (roleId) =>{
  return request({
    // ``模板字符串
    url: `${base_api}/deleteById/${roleId}`, //路径
    method: 'delete' //提交方式
  })
}

// 查询所有的角色数据
export const GetAllRoleList = (userId) => {
  return request({
      url: `/admin/system/sysRole/findAllRoles/${userId}`,
      method: 'get'
  })
}

// 查询指定角色所对应的菜单id
export const GetSysRoleMenuIds = (roleId) => {
  return request({
      url: "/admin/system/sysRoleMenu/findSysRoleMenuByRoleId/"+ roleId,
      method: 'get'
  })
}

// 根据角色分配菜单请求方法
export const DoAssignMenuIdToSysRole = (assignMenuDto) => {
  return request({
      url: "/admin/system/sysRoleMenu/doAssign",
      method: 'post',
      data: assignMenuDto
  })
}