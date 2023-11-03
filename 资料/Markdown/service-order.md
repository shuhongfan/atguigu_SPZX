# 尚品甑选API接口文档


**简介**:尚品甑选API接口文档


**HOST**:http://localhost:8503


**联系人**:atguigu


**Version**:1.0


**接口路径**:/v3/api-docs/web-api


[TOC]






# 订单管理


## 提交订单


**接口地址**:`/api/order/orderInfo/auth/submitOrder`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "userAddressId": 0,
  "feightFee": 0,
  "remark": "",
  "orderItemList": [
    {
      "id": 0,
      "createTime": "",
      "updateTime": "",
      "isDeleted": 0,
      "orderId": 0,
      "skuId": 0,
      "skuName": "",
      "thumbImg": "",
      "skuPrice": 0,
      "skuNum": 0
    }
  ]
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orderInfoDto|请求参数实体类|body|true|OrderInfoDto|OrderInfoDto|
|&emsp;&emsp;userAddressId|送货地址id||true|integer(int64)||
|&emsp;&emsp;feightFee|运费||true|number||
|&emsp;&emsp;remark|备注||false|string||
|&emsp;&emsp;orderItemList|订单项实体类||true|array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识||false|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间||false|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间||false|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除||false|integer||
|&emsp;&emsp;&emsp;&emsp;orderId|订单id||false|integer||
|&emsp;&emsp;&emsp;&emsp;skuId|商品sku编号||true|integer||
|&emsp;&emsp;&emsp;&emsp;skuName|商品sku名字||true|string||
|&emsp;&emsp;&emsp;&emsp;thumbImg|商品sku图片||true|string||
|&emsp;&emsp;&emsp;&emsp;skuPrice|商品sku价格||true|number||
|&emsp;&emsp;&emsp;&emsp;skuNum|商品购买的数量||true|integer||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultLong|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|订单id|integer(int64)|integer(int64)|


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": 0
}
```


## 获取订单分页列表


**接口地址**:`/api/order/orderInfo/auth/{page}/{limit}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|当前页码|path|true|integer(int32)||
|limit|每页记录数|path|true|integer(int32)||
|orderStatus|订单状态|query|false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultPageInfoOrderInfo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||PageInfoOrderInfo|PageInfoOrderInfo|
|&emsp;&emsp;total||integer(int64)||
|&emsp;&emsp;list|OrderInfo|array|OrderInfo|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;userId|会员_id|integer||
|&emsp;&emsp;&emsp;&emsp;nickName|昵称|string||
|&emsp;&emsp;&emsp;&emsp;orderNo|订单号|string||
|&emsp;&emsp;&emsp;&emsp;couponId|使用的优惠券|integer||
|&emsp;&emsp;&emsp;&emsp;totalAmount|订单总额|number||
|&emsp;&emsp;&emsp;&emsp;couponAmount|优惠券|number||
|&emsp;&emsp;&emsp;&emsp;originalTotalAmount|原价金额|number||
|&emsp;&emsp;&emsp;&emsp;feightFee|运费|number||
|&emsp;&emsp;&emsp;&emsp;payType|支付方式【1->微信】|integer||
|&emsp;&emsp;&emsp;&emsp;orderStatus|订单状态【0->待付款；1->待发货；2->已发货；3->待用户收货，已完成；-1->已取消】|integer||
|&emsp;&emsp;&emsp;&emsp;receiverName|收货人姓名|string||
|&emsp;&emsp;&emsp;&emsp;receiverPhone|收货人电话|string||
|&emsp;&emsp;&emsp;&emsp;receiverTagName|收货人地址标签|string||
|&emsp;&emsp;&emsp;&emsp;receiverProvince|省份/直辖市|string||
|&emsp;&emsp;&emsp;&emsp;receiverCity|城市|string||
|&emsp;&emsp;&emsp;&emsp;receiverDistrict|区|string||
|&emsp;&emsp;&emsp;&emsp;receiverAddress|详细地址|string||
|&emsp;&emsp;&emsp;&emsp;paymentTime|支付时间|string||
|&emsp;&emsp;&emsp;&emsp;deliveryTime|发货时间|string||
|&emsp;&emsp;&emsp;&emsp;receiveTime|确认收货时间|string||
|&emsp;&emsp;&emsp;&emsp;remark|订单备注|string||
|&emsp;&emsp;&emsp;&emsp;cancelTime|取消订单时间|string||
|&emsp;&emsp;&emsp;&emsp;cancelReason|取消订单原因|string||
|&emsp;&emsp;&emsp;&emsp;orderItemList|订单项实体类|array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;orderId|订单id|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;skuId|商品sku编号|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;skuName|商品sku名字|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;thumbImg|商品sku图片|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;skuPrice|商品sku价格|number||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;skuNum|商品购买的数量|integer||
|&emsp;&emsp;pageNum||integer(int32)||
|&emsp;&emsp;pageSize||integer(int32)||
|&emsp;&emsp;size||integer(int32)||
|&emsp;&emsp;startRow||integer(int64)||
|&emsp;&emsp;endRow||integer(int64)||
|&emsp;&emsp;pages||integer(int32)||
|&emsp;&emsp;prePage||integer(int32)||
|&emsp;&emsp;nextPage||integer(int32)||
|&emsp;&emsp;isFirstPage||boolean||
|&emsp;&emsp;isLastPage||boolean||
|&emsp;&emsp;hasPreviousPage||boolean||
|&emsp;&emsp;hasNextPage||boolean||
|&emsp;&emsp;navigatePages||integer(int32)||
|&emsp;&emsp;navigatepageNums||array|integer(int32)|
|&emsp;&emsp;navigateFirstPage||integer(int32)||
|&emsp;&emsp;navigateLastPage||integer(int32)||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"total": 0,
		"list": [
			{
				"id": 0,
				"createTime": "",
				"updateTime": "",
				"isDeleted": 0,
				"userId": 0,
				"nickName": "",
				"orderNo": "",
				"couponId": 0,
				"totalAmount": 0,
				"couponAmount": 0,
				"originalTotalAmount": 0,
				"feightFee": 0,
				"payType": 0,
				"orderStatus": 0,
				"receiverName": "",
				"receiverPhone": "",
				"receiverTagName": "",
				"receiverProvince": "",
				"receiverCity": "",
				"receiverDistrict": "",
				"receiverAddress": "",
				"paymentTime": "",
				"deliveryTime": "",
				"receiveTime": "",
				"remark": "",
				"cancelTime": "",
				"cancelReason": "",
				"orderItemList": [
					{
						"id": 0,
						"createTime": "",
						"updateTime": "",
						"isDeleted": 0,
						"orderId": 0,
						"skuId": 0,
						"skuName": "",
						"thumbImg": "",
						"skuPrice": 0,
						"skuNum": 0
					}
				]
			}
		],
		"pageNum": 0,
		"pageSize": 0,
		"size": 0,
		"startRow": 0,
		"endRow": 0,
		"pages": 0,
		"prePage": 0,
		"nextPage": 0,
		"isFirstPage": true,
		"isLastPage": true,
		"hasPreviousPage": true,
		"hasNextPage": true,
		"navigatePages": 0,
		"navigatepageNums": [],
		"navigateFirstPage": 0,
		"navigateLastPage": 0
	}
}
```


## 获取订单信息


**接口地址**:`/api/order/orderInfo/auth/{orderId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orderId|订单id|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultOrderInfo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||OrderInfo|OrderInfo|
|&emsp;&emsp;id|唯一标识|integer(int64)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;updateTime|修改时间|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;userId|会员_id|integer(int64)||
|&emsp;&emsp;nickName|昵称|string||
|&emsp;&emsp;orderNo|订单号|string||
|&emsp;&emsp;couponId|使用的优惠券|integer(int64)||
|&emsp;&emsp;totalAmount|订单总额|number||
|&emsp;&emsp;couponAmount|优惠券|number||
|&emsp;&emsp;originalTotalAmount|原价金额|number||
|&emsp;&emsp;feightFee|运费|number||
|&emsp;&emsp;payType|支付方式【1->微信】|integer(int32)||
|&emsp;&emsp;orderStatus|订单状态【0->待付款；1->待发货；2->已发货；3->待用户收货，已完成；-1->已取消】|integer(int32)||
|&emsp;&emsp;receiverName|收货人姓名|string||
|&emsp;&emsp;receiverPhone|收货人电话|string||
|&emsp;&emsp;receiverTagName|收货人地址标签|string||
|&emsp;&emsp;receiverProvince|省份/直辖市|string||
|&emsp;&emsp;receiverCity|城市|string||
|&emsp;&emsp;receiverDistrict|区|string||
|&emsp;&emsp;receiverAddress|详细地址|string||
|&emsp;&emsp;paymentTime|支付时间|string(date-time)||
|&emsp;&emsp;deliveryTime|发货时间|string(date-time)||
|&emsp;&emsp;receiveTime|确认收货时间|string(date-time)||
|&emsp;&emsp;remark|订单备注|string||
|&emsp;&emsp;cancelTime|取消订单时间|string(date-time)||
|&emsp;&emsp;cancelReason|取消订单原因|string||
|&emsp;&emsp;orderItemList|订单项实体类|array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;orderId|订单id|integer||
|&emsp;&emsp;&emsp;&emsp;skuId|商品sku编号|integer||
|&emsp;&emsp;&emsp;&emsp;skuName|商品sku名字|string||
|&emsp;&emsp;&emsp;&emsp;thumbImg|商品sku图片|string||
|&emsp;&emsp;&emsp;&emsp;skuPrice|商品sku价格|number||
|&emsp;&emsp;&emsp;&emsp;skuNum|商品购买的数量|integer||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"id": 0,
		"createTime": "",
		"updateTime": "",
		"isDeleted": 0,
		"userId": 0,
		"nickName": "",
		"orderNo": "",
		"couponId": 0,
		"totalAmount": 0,
		"couponAmount": 0,
		"originalTotalAmount": 0,
		"feightFee": 0,
		"payType": 0,
		"orderStatus": 0,
		"receiverName": "",
		"receiverPhone": "",
		"receiverTagName": "",
		"receiverProvince": "",
		"receiverCity": "",
		"receiverDistrict": "",
		"receiverAddress": "",
		"paymentTime": "",
		"deliveryTime": "",
		"receiveTime": "",
		"remark": "",
		"cancelTime": "",
		"cancelReason": "",
		"orderItemList": [
			{
				"id": 0,
				"createTime": "",
				"updateTime": "",
				"isDeleted": 0,
				"orderId": 0,
				"skuId": 0,
				"skuName": "",
				"thumbImg": "",
				"skuPrice": 0,
				"skuNum": 0
			}
		]
	}
}
```


## 确认下单


**接口地址**:`/api/order/orderInfo/auth/trade`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultTradeVo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||TradeVo|TradeVo|
|&emsp;&emsp;totalAmount|结算总金额|number||
|&emsp;&emsp;orderItemList|订单项实体类|array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;orderId|订单id|integer||
|&emsp;&emsp;&emsp;&emsp;skuId|商品sku编号|integer||
|&emsp;&emsp;&emsp;&emsp;skuName|商品sku名字|string||
|&emsp;&emsp;&emsp;&emsp;thumbImg|商品sku图片|string||
|&emsp;&emsp;&emsp;&emsp;skuPrice|商品sku价格|number||
|&emsp;&emsp;&emsp;&emsp;skuNum|商品购买的数量|integer||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"totalAmount": 0,
		"orderItemList": [
			{
				"id": 0,
				"createTime": "",
				"updateTime": "",
				"isDeleted": 0,
				"orderId": 0,
				"skuId": 0,
				"skuName": "",
				"thumbImg": "",
				"skuPrice": 0,
				"skuNum": 0
			}
		]
	}
}
```


## 立即购买


**接口地址**:`/api/order/orderInfo/auth/buy/{skuId}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|skuId|商品skuId|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultTradeVo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||TradeVo|TradeVo|
|&emsp;&emsp;totalAmount|结算总金额|number||
|&emsp;&emsp;orderItemList|订单项实体类|array|OrderItem|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;orderId|订单id|integer||
|&emsp;&emsp;&emsp;&emsp;skuId|商品sku编号|integer||
|&emsp;&emsp;&emsp;&emsp;skuName|商品sku名字|string||
|&emsp;&emsp;&emsp;&emsp;thumbImg|商品sku图片|string||
|&emsp;&emsp;&emsp;&emsp;skuPrice|商品sku价格|number||
|&emsp;&emsp;&emsp;&emsp;skuNum|商品购买的数量|integer||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"totalAmount": 0,
		"orderItemList": [
			{
				"id": 0,
				"createTime": "",
				"updateTime": "",
				"isDeleted": 0,
				"orderId": 0,
				"skuId": 0,
				"skuName": "",
				"thumbImg": "",
				"skuPrice": 0,
				"skuNum": 0
			}
		]
	}
}
```


# 支付宝接口


## 支付宝异步回调


**接口地址**:`/api/order/alipay/callback/notify`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|paramMap||query|true|object||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## 支付宝下单


**接口地址**:`/api/order/alipay/submitAlipay/{orderNo}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|orderNo|订单号|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Result|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|object||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {}
}
```


## 支付宝同步回调


**接口地址**:`/api/order/alipay/callback/return`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK||


**响应参数**:


暂无


**响应示例**:
```javascript

```


# 购物车接口


## 清空购物车


**接口地址**:`/api/order/cart/auth/clearCart`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Result|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|object||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {}
}
```


## 更新购物车商品选中状态


**接口地址**:`/api/order/cart/auth/checkCart/{skuId}/{isChecked}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|skuId|商品skuId|path|true|integer(int64)||
|isChecked|是否选中 1:选中 0:取消选中|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Result|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|object||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {}
}
```


## 查询购物车


**接口地址**:`/api/order/cart/auth/cartList`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|ResultListCartInfo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|array|CartInfo|
|&emsp;&emsp;id|唯一标识|integer(int64)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;updateTime|修改时间|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;userId|用户id|integer(int64)||
|&emsp;&emsp;skuId|skuid|integer(int64)||
|&emsp;&emsp;cartPrice|放入购物车时价格|number||
|&emsp;&emsp;skuNum|数量|integer(int32)||
|&emsp;&emsp;imgUrl|图片文件|string||
|&emsp;&emsp;skuName|sku名称 (冗余)|string||
|&emsp;&emsp;isChecked|isChecked|integer(int32)||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": [
		{
			"id": 0,
			"createTime": "",
			"updateTime": "",
			"isDeleted": 0,
			"userId": 0,
			"skuId": 0,
			"cartPrice": 0,
			"skuNum": 0,
			"imgUrl": "",
			"skuName": "",
			"isChecked": 0
		}
	]
}
```


## 更新购物车商品全部选中状态


**接口地址**:`/api/order/cart/auth/allCheckCart/{isChecked}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|isChecked|是否选中 1:选中 0:取消选中|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Result|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|object||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {}
}
```


## 添加购物车


**接口地址**:`/api/order/cart/auth/addToCart/{skuId}/{skuNum}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|skuId|商品skuId|path|true|integer(int64)||
|skuNum|数量|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Result|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|object||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {}
}
```


## 删除购物车商品


**接口地址**:`/api/order/cart/auth/deleteCart/{skuId}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|skuId|商品skuId|path|true|integer(int64)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- |
|200|OK|Result|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|object||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {}
}
```