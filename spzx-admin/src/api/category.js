import request from '@/utils/request'

const api_name = '/admin/product/category'

// 根据parentId获取下级节点
export const FindCategoryByParentId = id => {
  return request({
    url: `${api_name}/findCategoryList/${id}`,
    method: 'get',
  })
}

// 导出方法
export const ExportCategoryData = () => {
    return request({
      url: `${api_name}/exportData`,
      method: 'get',
      responseType: 'blob'  // // 这里指定响应类型为blob类型,二进制数据类型，用于表示大量的二进制数据
    })
  }