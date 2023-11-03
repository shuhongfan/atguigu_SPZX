import request from '@/utils/request'

const api_name = '/admin/order/orderInfo'

// 订单统计
export const GetOrderStatisticsData = searchObj => {
  return request({
    url: `${api_name}/getOrderStatisticsData`,
    method: 'get',
    params: searchObj,
  })
}