# 尚品甑选API接口文档


**简介**:尚品甑选API接口文档


**HOST**:http://localhost:8504


**联系人**:atguigu


**Version**:1.0


**接口路径**:/v3/api-docs/web-api


[TOC]






# 用户地址接口


## 修改用户地址


**接口地址**:`/api/user/userAddress/auth/updateById`


**请求方式**:`PUT`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "id": 0,
  "createTime": "",
  "updateTime": "",
  "isDeleted": 0,
  "userId": 0,
  "name": "",
  "phone": "",
  "tagName": "",
  "provinceCode": "",
  "cityCode": "",
  "districtCode": "",
  "address": "",
  "fullAddress": "",
  "isDefault": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userAddress|用户地址参数|body|true|UserAddress|UserAddress|
|&emsp;&emsp;id|唯一标识||false|integer(int64)||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;updateTime|修改时间||false|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;userId|用户ID||false|integer(int64)||
|&emsp;&emsp;name|name||true|string||
|&emsp;&emsp;phone|电话||true|string||
|&emsp;&emsp;tagName|标签名称||true|string||
|&emsp;&emsp;provinceCode|provinceCode||true|string||
|&emsp;&emsp;cityCode|cityCode||true|string||
|&emsp;&emsp;districtCode|districtCode||true|string||
|&emsp;&emsp;address|详细地址||true|string||
|&emsp;&emsp;fullAddress|完整地址||false|string||
|&emsp;&emsp;isDefault|是否默认地址（0：否 1：是）||true|integer(int32)||


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


## 新增用户地址


**接口地址**:`/api/user/userAddress/auth/save`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "id": 0,
  "createTime": "",
  "updateTime": "",
  "isDeleted": 0,
  "userId": 0,
  "name": "",
  "phone": "",
  "tagName": "",
  "provinceCode": "",
  "cityCode": "",
  "districtCode": "",
  "address": "",
  "fullAddress": "",
  "isDefault": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userAddress|用户地址参数|body|true|UserAddress|UserAddress|
|&emsp;&emsp;id|唯一标识||false|integer(int64)||
|&emsp;&emsp;createTime|创建时间||false|string(date-time)||
|&emsp;&emsp;updateTime|修改时间||false|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除||false|integer(int32)||
|&emsp;&emsp;userId|用户ID||false|integer(int64)||
|&emsp;&emsp;name|name||true|string||
|&emsp;&emsp;phone|电话||true|string||
|&emsp;&emsp;tagName|标签名称||true|string||
|&emsp;&emsp;provinceCode|provinceCode||true|string||
|&emsp;&emsp;cityCode|cityCode||true|string||
|&emsp;&emsp;districtCode|districtCode||true|string||
|&emsp;&emsp;address|详细地址||true|string||
|&emsp;&emsp;fullAddress|完整地址||false|string||
|&emsp;&emsp;isDefault|是否默认地址（0：否 1：是）||true|integer(int32)||


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


## 获取用户地址列表


**接口地址**:`/api/user/userAddress/auth/findUserAddressList`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListUserAddress|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|array|UserAddress|
|&emsp;&emsp;id|唯一标识|integer(int64)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;updateTime|修改时间|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;userId|用户ID|integer(int64)||
|&emsp;&emsp;name|name|string||
|&emsp;&emsp;phone|电话|string||
|&emsp;&emsp;tagName|标签名称|string||
|&emsp;&emsp;provinceCode|provinceCode|string||
|&emsp;&emsp;cityCode|cityCode|string||
|&emsp;&emsp;districtCode|districtCode|string||
|&emsp;&emsp;address|详细地址|string||
|&emsp;&emsp;fullAddress|完整地址|string||
|&emsp;&emsp;isDefault|是否默认地址（0：否 1：是）|integer(int32)||


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
			"name": "",
			"phone": "",
			"tagName": "",
			"provinceCode": "",
			"cityCode": "",
			"districtCode": "",
			"address": "",
			"fullAddress": "",
			"isDefault": 0
		}
	]
}
```


## 删除用户地址


**接口地址**:`/api/user/userAddress/auth/removeById/{id}`


**请求方式**:`DELETE`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|用户地址id|path|true|integer(int64)||


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


# 会员用户接口


## 会员注册


**接口地址**:`/api/user/userInfo/register`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "username": "",
  "password": "",
  "nickName": "",
  "code": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userRegisterDto|注册对象|body|true|UserRegisterDto|UserRegisterDto|
|&emsp;&emsp;username|用户名||true|string||
|&emsp;&emsp;password|密码||true|string||
|&emsp;&emsp;nickName|昵称||true|string||
|&emsp;&emsp;code|手机验证码||true|string||


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


## 会员登录


**接口地址**:`/api/user/userInfo/login`


**请求方式**:`POST`


**请求数据类型**:`application/x-www-form-urlencoded,application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "username": "",
  "password": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userLoginDto|用户登录请求参数|body|true|UserLoginDto|UserLoginDto|
|&emsp;&emsp;username|用户名||false|string||
|&emsp;&emsp;password|密码||false|string||


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


## 当前用户是否收藏商品


**接口地址**:`/api/user/userInfo/isCollect/{skuId}`


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
|200|OK|ResultBoolean|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": true
}
```


## 获取当前登录用户信息


**接口地址**:`/api/user/userInfo/auth/getCurrentUserInfo`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultUserInfoVo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||UserInfoVo|UserInfoVo|
|&emsp;&emsp;nickName|昵称|string||
|&emsp;&emsp;avatar|头像|string||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": {
		"nickName": "",
		"avatar": ""
	}
}
```


## 获取用户收藏分页列表


**接口地址**:`/api/user/userInfo/auth/findUserCollectPage/{page}/{limit}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|当前页码|path|true|integer(int32)||
|limit|每页记录数|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultPageInfoUserCollectVo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||PageInfoUserCollectVo|PageInfoUserCollectVo|
|&emsp;&emsp;total||integer(int64)||
|&emsp;&emsp;list|用户收藏|array|UserCollectVo|
|&emsp;&emsp;&emsp;&emsp;skuId|skuID|integer||
|&emsp;&emsp;&emsp;&emsp;skuName|商品标题|string||
|&emsp;&emsp;&emsp;&emsp;createTime|创建时间|string||
|&emsp;&emsp;&emsp;&emsp;thumbImg|图片|string||
|&emsp;&emsp;&emsp;&emsp;salePrice|售价|number||
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
				"skuId": 0,
				"skuName": "",
				"createTime": "",
				"thumbImg": "",
				"salePrice": 0
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


## 获取用户浏览历史分页列表


**接口地址**:`/api/user/userInfo/auth/findUserBrowseHistoryPage/{page}/{limit}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|page|当前页码|path|true|integer(int32)||
|limit|每页记录数|path|true|integer(int32)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultPageInfoUserBrowseHistoryVo|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data||PageInfoUserBrowseHistoryVo|PageInfoUserBrowseHistoryVo|
|&emsp;&emsp;total||integer(int64)||
|&emsp;&emsp;list|用户浏览历史|array|UserBrowseHistoryVo|
|&emsp;&emsp;&emsp;&emsp;skuId|skuID|integer||
|&emsp;&emsp;&emsp;&emsp;skuName|商品标题|string||
|&emsp;&emsp;&emsp;&emsp;updateTime|更新时间|string||
|&emsp;&emsp;&emsp;&emsp;thumbImg|图片|string||
|&emsp;&emsp;&emsp;&emsp;salePrice|售价|number||
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
				"skuId": 0,
				"skuName": "",
				"updateTime": "",
				"thumbImg": "",
				"salePrice": 0
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


## 当前用户收藏商品


**接口地址**:`/api/user/userInfo/auth/collect/{skuId}`


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
|200|OK|ResultBoolean|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|boolean||


**响应示例**:
```javascript
{
	"code": 0,
	"message": "",
	"data": true
}
```


# 短信接口


## 获取短信验证码


**接口地址**:`/api/user/sms/sendCode/{phone}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|phone|手机|path|true|string||


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


# 地区信息接口


## 根据parentCode获取下级节点


**接口地址**:`/api/user/region/findByParentCode/{parentCode}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|parentCode|上级code|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|ResultListRegion|


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|code|业务状态码|integer(int32)|integer(int32)|
|message|响应消息|string||
|data|业务数据|array|Region|
|&emsp;&emsp;id|唯一标识|integer(int64)||
|&emsp;&emsp;createTime|创建时间|string(date-time)||
|&emsp;&emsp;updateTime|修改时间|string(date-time)||
|&emsp;&emsp;isDeleted|是否删除|integer(int32)||
|&emsp;&emsp;code|区域编码|string||
|&emsp;&emsp;parentCode|父区域编码|integer(int64)||
|&emsp;&emsp;name|父区名称|string||
|&emsp;&emsp;level|地区级别：1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县|integer(int32)||


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
			"code": "",
			"parentCode": 0,
			"name": "",
			"level": 0
		}
	]
}
```