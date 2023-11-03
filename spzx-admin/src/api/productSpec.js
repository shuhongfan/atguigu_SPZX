import request from '@/utils/request'

const api_name = '/admin/product/productSpec'

// 分页列表
export const GetProductSpecPageList = (page, limit) => {
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get'
    })
}

// 保存信息
export const SaveProductSpec = productSpec => {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: productSpec,
    })
}

// 修改信息
export const UpdateProductSpecById = productSpec => {
    return request({
        url: `${api_name}/updateById`,
        method: 'put',
        data: productSpec,
    })
}

// 根据id删除数据
export const DeleteProductSpecById = id => {
    return request({
      url: `${api_name}/deleteById/${id}`,
      method: 'delete',
    })
}

// 查询所有的产品规格数据
export const FindAllProductSpec = () => {
  return request({
    url: `${api_name}/findAll`,
    method: 'get',
  })
}