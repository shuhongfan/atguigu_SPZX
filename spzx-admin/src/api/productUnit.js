import request from '@/utils/request'

const api_name = '/admin/product/productUnit'

// 获取全部信息
export const FindAllProductUnit = () => {
    return request({
      url: `${api_name}/findAll`,
      method: 'get',
    })
}