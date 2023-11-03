# 尚品甑选API接口文档


**简介**:尚品甑选API接口文档


**HOST**:http://localhost:8502


**联系人**:atguigu


**Version**:1.0


**接口路径**:/v3/api-docs/web-api


[TOC]






# 商品列表管理


## 分页查询


**接口地址**:`/api/product/{page}/{limit}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|当前页码|path|true|integer(int32)||
|limit|每页记录数|path|true|integer(int32)||
|productSkuDto|商品列表搜索条件实体类|query|true|ProductSkuDto|ProductSkuDto|
|&emsp;&emsp;keyword|关键字||false|string||
|&emsp;&emsp;brandId|品牌id||false|integer(int64)||
|&emsp;&emsp;category1Id|一级分类id||false|integer(int64)||
|&emsp;&emsp;category2Id|二级分类id||false|integer(int64)||
|&emsp;&emsp;category3Id|三级分类id||false|integer(int64)||
|&emsp;&emsp;order|排序（销量:1 价格升序:2 价格降序:3）||false|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultPageInfoProductSku|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||PageInfoProductSku|PageInfoProductSku|
|&emsp;&emsp;total||integer(int64)||
|&emsp;&emsp;list|ProductSku|array|ProductSku|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;skuCode|商品编号|string||
|&emsp;&emsp;&emsp;&emsp;skuName|skuName|string||
|&emsp;&emsp;&emsp;&emsp;productId|商品ID|integer||
|&emsp;&emsp;&emsp;&emsp;thumbImg|缩略图路径|string||
|&emsp;&emsp;&emsp;&emsp;salePrice|售价|number||
|&emsp;&emsp;&emsp;&emsp;marketPrice|市场价|number||
|&emsp;&emsp;&emsp;&emsp;costPrice|成本价|number||
|&emsp;&emsp;&emsp;&emsp;stockNum|库存数|integer||
|&emsp;&emsp;&emsp;&emsp;saleNum|销量|integer||
|&emsp;&emsp;&emsp;&emsp;skuSpec|sku规格信息json|string||
|&emsp;&emsp;&emsp;&emsp;weight|重量|string||
|&emsp;&emsp;&emsp;&emsp;volume|体积|string||
|&emsp;&emsp;&emsp;&emsp;status|线上状态：0-初始值，1-上架，-1-自主下架|integer||
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
				"skuCode": "",
				"skuName": "",
				"productId": 0,
				"thumbImg": "",
				"salePrice": 0,
				"marketPrice": 0,
				"costPrice": 0,
				"stockNum": 0,
				"saleNum": 0,
				"skuSpec": "",
				"weight": "",
				"volume": "",
				"status": 0
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


## 商品详情


**接口地址**:`/api/product/item/{skuId}`


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
|200|OK|ResultProductItemVo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||ProductItemVo|ProductItemVo|
|&emsp;&emsp;productSku|ProductSku|ProductSku|ProductSku|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;skuCode|商品编号|string||
|&emsp;&emsp;&emsp;&emsp;skuName|skuName|string||
|&emsp;&emsp;&emsp;&emsp;productId|商品ID|integer||
|&emsp;&emsp;&emsp;&emsp;thumbImg|缩略图路径|string||
|&emsp;&emsp;&emsp;&emsp;salePrice|售价|number||
|&emsp;&emsp;&emsp;&emsp;marketPrice|市场价|number||
|&emsp;&emsp;&emsp;&emsp;costPrice|成本价|number||
|&emsp;&emsp;&emsp;&emsp;stockNum|库存数|integer||
|&emsp;&emsp;&emsp;&emsp;saleNum|销量|integer||
|&emsp;&emsp;&emsp;&emsp;skuSpec|sku规格信息json|string||
|&emsp;&emsp;&emsp;&emsp;weight|重量|string||
|&emsp;&emsp;&emsp;&emsp;volume|体积|string||
|&emsp;&emsp;&emsp;&emsp;status|线上状态：0-初始值，1-上架，-1-自主下架|integer||
|&emsp;&emsp;product|商品实体类|Product|Product|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;name|商品名称|string||
|&emsp;&emsp;&emsp;&emsp;brandId|品牌id|integer||
|&emsp;&emsp;&emsp;&emsp;category1Id|一级分类id|integer||
|&emsp;&emsp;&emsp;&emsp;category2Id|二级分类id|integer||
|&emsp;&emsp;&emsp;&emsp;category3Id|三级分类id|integer||
|&emsp;&emsp;&emsp;&emsp;unitName|计量单位|string||
|&emsp;&emsp;&emsp;&emsp;sliderUrls|轮播图url|string||
|&emsp;&emsp;&emsp;&emsp;specValue|商品规格值json串|string||
|&emsp;&emsp;&emsp;&emsp;status|线上状态：0-初始值，1-上架，-1-自主下架|integer||
|&emsp;&emsp;&emsp;&emsp;auditStatus|审核状态|integer||
|&emsp;&emsp;&emsp;&emsp;auditMessage|审核信息|string||
|&emsp;&emsp;&emsp;&emsp;brandName|品牌名称|string||
|&emsp;&emsp;&emsp;&emsp;category1Name|一级分类名称|string||
|&emsp;&emsp;&emsp;&emsp;category2Name|二级分类名称|string||
|&emsp;&emsp;&emsp;&emsp;category3Name|三级分类名称|string||
|&emsp;&emsp;&emsp;&emsp;productSkuList|ProductSku|array|ProductSku|
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;skuCode|商品编号|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;skuName|skuName|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;productId|商品ID|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;thumbImg|缩略图路径|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;salePrice|售价|number||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;marketPrice|市场价|number||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;costPrice|成本价|number||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;stockNum|库存数|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;saleNum|销量|integer||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;skuSpec|sku规格信息json|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;weight|重量|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;volume|体积|string||
|&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;status|线上状态：0-初始值，1-上架，-1-自主下架|integer||
|&emsp;&emsp;&emsp;&emsp;detailsImageUrls|图片详情列表|string||
|&emsp;&emsp;sliderUrlList|商品轮播图列表|array|string|
|&emsp;&emsp;detailsImageUrlList|商品详情图片列表|array|string|
|&emsp;&emsp;specValueList|商品规格信息|array|object|
|&emsp;&emsp;skuSpecValueMap|商品规格对应商品skuId信息|object||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"productSku": {
			"id": 0,
			"createTime": "",
			"updateTime": "",
			"isDeleted": 0,
			"skuCode": "",
			"skuName": "",
			"productId": 0,
			"thumbImg": "",
			"salePrice": 0,
			"marketPrice": 0,
			"costPrice": 0,
			"stockNum": 0,
			"saleNum": 0,
			"skuSpec": "",
			"weight": "",
			"volume": "",
			"status": 0
		},
		"product": {
			"id": 0,
			"createTime": "",
			"updateTime": "",
			"isDeleted": 0,
			"name": "",
			"brandId": 0,
			"category1Id": 0,
			"category2Id": 0,
			"category3Id": 0,
			"unitName": "",
			"sliderUrls": "",
			"specValue": "",
			"status": 0,
			"auditStatus": 0,
			"auditMessage": "",
			"brandName": "",
			"category1Name": "",
			"category2Name": "",
			"category3Name": "",
			"productSkuList": [
				{
					"id": 0,
					"createTime": "",
					"updateTime": "",
					"isDeleted": 0,
					"skuCode": "",
					"skuName": "",
					"productId": 0,
					"thumbImg": "",
					"salePrice": 0,
					"marketPrice": 0,
					"costPrice": 0,
					"stockNum": 0,
					"saleNum": 0,
					"skuSpec": "",
					"weight": "",
					"volume": "",
					"status": 0
				}
			],
			"detailsImageUrls": ""
		},
		"sliderUrlList": [],
		"detailsImageUrlList": [],
		"specValueList": [],
		"skuSpecValueMap": {}
	}
}
```


# 首页接口管理


## 获取首页数据


**接口地址**:`/api/product/index`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultIndexVo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||IndexVo|IndexVo|
|&emsp;&emsp;categoryList|分类实体类|array|Category|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;name|分类名称|string||
|&emsp;&emsp;&emsp;&emsp;imageUrl|分类图片url|string||
|&emsp;&emsp;&emsp;&emsp;parentId|父节点id|integer||
|&emsp;&emsp;&emsp;&emsp;status|分类状态: 是否显示[0-不显示，1显示]|integer||
|&emsp;&emsp;&emsp;&emsp;orderNum|排序字段|integer||
|&emsp;&emsp;&emsp;&emsp;hasChildren|是否存在子节点|boolean||
|&emsp;&emsp;&emsp;&emsp;children|子节点List集合|array|Category|
|&emsp;&emsp;productSkuList|ProductSku|array|ProductSku|
|&emsp;&emsp;&emsp;&emsp;id|唯一标识|integer||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|修改时间|string||
|&emsp;&emsp;&emsp;&emsp;isDeleted|是否删除|integer||
|&emsp;&emsp;&emsp;&emsp;skuCode|商品编号|string||
|&emsp;&emsp;&emsp;&emsp;skuName|skuName|string||
|&emsp;&emsp;&emsp;&emsp;productId|商品ID|integer||
|&emsp;&emsp;&emsp;&emsp;thumbImg|缩略图路径|string||
|&emsp;&emsp;&emsp;&emsp;salePrice|售价|number||
|&emsp;&emsp;&emsp;&emsp;marketPrice|市场价|number||
|&emsp;&emsp;&emsp;&emsp;costPrice|成本价|number||
|&emsp;&emsp;&emsp;&emsp;stockNum|库存数|integer||
|&emsp;&emsp;&emsp;&emsp;saleNum|销量|integer||
|&emsp;&emsp;&emsp;&emsp;skuSpec|sku规格信息json|string||
|&emsp;&emsp;&emsp;&emsp;weight|重量|string||
|&emsp;&emsp;&emsp;&emsp;volume|体积|string||
|&emsp;&emsp;&emsp;&emsp;status|线上状态：0-初始值，1-上架，-1-自主下架|integer||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"categoryList": [
			{
				"id": 0,
				"createTime": "",
				"updateTime": "",
				"isDeleted": 0,
				"name": "",
				"imageUrl": "",
				"parentId": 0,
				"status": 0,
				"orderNum": 0,
				"hasChildren": true,
				"children": [
					{
						"id": 0,
						"createTime": "",
						"updateTime": "",
						"isDeleted": 0,
						"name": "",
						"imageUrl": "",
						"parentId": 0,
						"status": 0,
						"orderNum": 0,
						"hasChildren": true,
						"children": [
							{}
						]
					}
				]
			}
		],
		"productSkuList": [
			{
				"id": 0,
				"createTime": "",
				"updateTime": "",
				"isDeleted": 0,
				"skuCode": "",
				"skuName": "",
				"productId": 0,
				"thumbImg": "",
				"salePrice": 0,
				"marketPrice": 0,
				"costPrice": 0,
				"stockNum": 0,
				"saleNum": 0,
				"skuSpec": "",
				"weight": "",
				"volume": "",
				"status": 0
			}
		]
	}
}
```


# 分类接口管理


## 获取分类树形数据


**接口地址**:`/api/product/category/findCategoryTree`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListCategory|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|array|Category|
|&emsp;&emsp;id|唯一标识|integer(int64)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;updateTime|修改时间|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;name|分类名称|string||
|&emsp;&emsp;imageUrl|分类图片url|string||
|&emsp;&emsp;parentId|父节点id|integer(int64)||
|&emsp;&emsp;status|分类状态: 是否显示[0-不显示，1显示]|integer(int32)||
|&emsp;&emsp;orderNum|排序字段|integer(int32)||
|&emsp;&emsp;hasChildren|是否存在子节点|boolean||
|&emsp;&emsp;children|子节点List集合|array|Category|


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
			"name": "",
			"imageUrl": "",
			"parentId": 0,
			"status": 0,
			"orderNum": 0,
			"hasChildren": true,
			"children": [
				{
					"id": 0,
					"createTime": "",
					"updateTime": "",
					"isDeleted": 0,
					"name": "",
					"imageUrl": "",
					"parentId": 0,
					"status": 0,
					"orderNum": 0,
					"hasChildren": true,
					"children": [
						{}
					]
				}
			]
		}
	]
}
```


# 品牌管理


## 获取全部品牌


**接口地址**:`/api/product/brand/findAll`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListBrand|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|array|Brand|
|&emsp;&emsp;id|唯一标识|integer(int64)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;updateTime|修改时间|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;name|品牌名称|string||
|&emsp;&emsp;logo|品牌logo|string||


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
			"name": "",
			"logo": ""
		}
	]
}
```