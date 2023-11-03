<template>
    <div class="search-div">
    <el-form label-width="70px" size="small">
      <el-row>
        <el-col :span="12">
          <el-form-item label="品牌">
            <el-select
              class="m-2"
              v-model="queryDto.brandId"
              placeholder="选择品牌"
              size="small"
              style="width: 100%"
            >
              <el-option
                v-for="item in brandList"
                :key="item.id"
                :label="item.name"
                :value="item.id"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="分类">
            <el-cascader
              :props="categoryProps"
              style="width: 100%"
              v-model="searchCategoryIdList"
            />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row style="display:flex">
        <el-button type="primary" size="small" @click="fetchData">
          搜索
        </el-button>
        <el-button size="small" @click="resetData">重置</el-button>
      </el-row>
    </el-form>
  </div>

    <div class="tools-div">
        <el-button type="success" size="small" @click="addShow">添 加</el-button>
    </div>

    <el-table :data="list" style="width: 100%">
        <el-table-column
            prop="sliderUrls"
            label="轮播图"
            #default="scope"
            width="200"
        >
            <div style="height: 50px;float: left;">
                <img
                    v-for="(item, index) in scope.row.sliderUrls"
                    :key="index"
                    :src="item"
                    width="50"
                />
            </div>
        </el-table-column>
        <el-table-column prop="name" label="商品名称" width="160" />
        <el-table-column prop="brandName" label="品牌" />
        <el-table-column prop="category1Name" label="一级分类" />
        <el-table-column prop="category2Name" label="二级分类" />
        <el-table-column prop="category3Name" label="三级分类" />
        <el-table-column prop="unitName" label="计量单位" />
        <el-table-column prop="status" label="状态" #default="scope">
            {{
                scope.row.status == 0
                ? '未上架'
                : scope.row.status == 1
                ? '上架'
                : '下架'
            }}
        </el-table-column>
        <el-table-column prop="auditStatus" label="审核状态" #default="scope">
            {{
                scope.row.auditStatus == 0
                ? '未审核'
                : scope.row.auditStatus == 1
                ? '通过'
                : '驳回'
            }}
        </el-table-column>
        <el-table-column label="操作" align="center" width="200" #default="scope" >
            <el-button type="primary" size="small" @click="editShow(scope.row)" style="padding: 5px; margin-left: 5px;">
                修改
            </el-button>
            <el-button type="danger" size="small" @click="remove(scope.row.id)" style="padding: 5px; margin-left: 5px;">
                删除
            </el-button>
            <el-button
              v-if="scope.row.auditStatus == 0 || scope.row.auditStatus == -1"
              type="success"
              size="small"
              @click="audit(scope.row.id)"
              style="padding: 5px; margin-left: 5px;"
            >
              审批
      </el-button>
        <el-button
          v-if=" scope.row.auditStatus == 1 && (scope.row.status == 0 || scope.row.status == -1)
          && scope.row.status == 0 "
          type="warning"
          size="small"
          @click="updateStatus(scope.row.id, 1)"
          style="padding: 5px; margin-left: 5px;"
        >
          上架
        </el-button>
        <el-button
          v-if="
            scope.row.auditStatus == 1 &&
              (scope.row.status == 0 || scope.row.status == 1) && scope.row.status == 1 
          "
          type="warning"
          plain
          size="small"
          @click="updateStatus(scope.row.id, -1)"
          style="padding: 5px; margin-left: 5px;"
        >
          下架
        </el-button>
        </el-table-column>
    </el-table>

    <el-pagination
        v-model:current-page="pageParams.page"
        v-model:page-size="pageParams.limit"
        :page-sizes="[10, 20, 50, 100]"
        layout="total, sizes, prev, pager, next"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />

    <el-dialog v-model="dialogVisible" title="添加或修改" width="80%">
        <el-form label-width="120px" style="margin-top: 10px;" :label-position="labelPosition">
            <el-collapse v-model="activeNames">
                <el-collapse-item title="商品基本信息" name="productBaseInfo">
                    <el-form-item label="商品名称">
                        <el-input v-model="product.name"/>
                    </el-form-item>
                    <el-form-item label="分类">
                        <el-cascader
                            style="width: 100%;"
                            :props="categoryProps"
                            v-model="categoryIdList"
                            @change="categoryChange"
                        />
                    </el-form-item>
                    <el-form-item label="品牌">
                        <el-select class="m-2" placeholder="选择品牌" v-model="product.brandId" style="width: 100%;">
                            <el-option 
                                v-for="item in categoryBrandList"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id"
                            />
                        </el-select>
                    </el-form-item>
                    <el-form-item label="商品单元">
                        <el-select
                            v-model="product.unitName"
                            style="width: 100%;"
                            class="m-2"
                            placeholder="商品单元"
                        >
                        <el-option 
                            v-for="item in unitList"
                            :key="item.id"
                            :label="item.name"
                            :value="item.name"
                        />
                        </el-select>
                    </el-form-item>

                    <el-form-item label="轮播图">
                        <el-upload
                            v-model:file-list="fileList"
                            action="http://localhost:8501/admin/system/fileUpload"
                            list-type="picture-card"
                            multiple
                            :on-success="handleSliderSuccess"
                            :on-remove="handleRemove"
                            :headers="headers"
                        >
                        <el-icon><Plus /></el-icon>
                        </el-upload>
                    </el-form-item>
                </el-collapse-item>

                <el-collapse-item title="商品SKU信息" name="skuInfo">
                    <el-form-item label="选择规格">
                        <el-select
                            :disabled="product.id != '' && product.id != undefined "
                            v-model="product.specValue"
                            style="width: 100%;" 
                            class="m-2"
                            placeholder="选择规格"
                            size="default"
                            @change="changeSpecValueList"
                        >
                        <el-option 
                            v-for="item in specList"
                            :key="item.specValue"
                            :label="item.specName"
                            :value="item.specValue"
                        />
                        </el-select>
                    </el-form-item>
 
                    <div class="specValue" v-for="(item , index) in specValueList" :key="index">
                      <span class="tag-group__title">{{item.key}}</span>
                      <el-tag class="tag-group__title" type="success" effect="dark" v-for="(specValue , index) in item.valueList" :key="index">
                        {{specValue}}
                      </el-tag>
                    </div>
                    
                    <el-form-item label="商品SKU">
                    <el-table :data="product.productSkuList" border style="width: 100%">
                        <el-table-column prop="skuSpec" label="规格" width="180" />
                        <el-table-column label="图片" #default="scope" width="80">
                          <el-upload
                            class="avatar-uploader"
                            action="http://localhost:8501/admin/system/fileUpload"
                            :show-file-list="false"
                            :on-success="
                              (response, uploadFile, fileList) => handleSkuSuccess(response, uploadFile, fileList, scope.row)
                            "
                            :headers="headers"
                          >
                            <img
                              v-if="scope.row.thumbImg"
                              :src="scope.row.thumbImg"
                              class="avatar"
                            />
                            <el-icon v-else class="avatar-uploader-icon"><Plus /></el-icon>
                          </el-upload>
                        </el-table-column>
                        <el-table-column label="售价" #default="scope">
                            <el-input v-model="scope.row.salePrice" />
                        </el-table-column>
                        <el-table-column label="市场价" #default="scope">
                            <el-input v-model="scope.row.marketPrice" />
                        </el-table-column>
                        <el-table-column label="成本价" #default="scope">
                            <el-input v-model="scope.row.costPrice" />
                        </el-table-column>
                        <el-table-column label="库存数" #default="scope">
                            <el-input v-model="scope.row.stockNum" />
                        </el-table-column>
                        <el-table-column label="重量" #default="scope">
                            <el-input v-model="scope.row.weight" />
                        </el-table-column>
                        <el-table-column label="体积" #default="scope">
                            <el-input v-model="scope.row.volume" />
                        </el-table-column>
                    </el-table>
                </el-form-item>


                </el-collapse-item>
                <el-collapse-item title="商品详情信息" name="productDetails">
                    <el-form-item label="详情图片">
                        <el-upload
                          v-model:file-list="detailsFileList"
                          action="http://localhost:8501/admin/system/fileUpload"
                          list-type="picture-card"
                          multiple
                          :on-success="handleDetailsSuccess"
                          :on-remove="handleDetailsRemove"
                          :headers="headers"
                        >
                        <el-icon><Plus /></el-icon>
                        </el-upload>
                    </el-form-item>
                   
                </el-collapse-item>
                <el-collapse-item title="保存修改数据" name="submit" :disabled="true">
                    <el-form-item>
                        <el-button type="primary" @click="saveOrUpdate">提交</el-button>
                        <el-button @click="dialogVisible = false">取消</el-button>
                    </el-form-item> 
                </el-collapse-item>  
            </el-collapse>
        </el-form>
    </el-dialog>

    <el-dialog v-model="dialogAuditVisible" title="审批" width="80%">
    <el-form :model="product" label-width="120px" style="margin-top: 10px;">
      <el-divider />
      <span style="margin-bottom: 5px;">商品基本信息</span>
      <el-row>
        <el-col :span="12">
          <el-form-item label="商品名称">
            {{ product.name }}
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="分类">
            {{ product.category1Name }} => {{ product.category2Name }} =>
            {{ product.category3Name }}
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="品牌">
            {{ product.brandName }}
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="计量单位">
            {{ product.unitName }}
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <el-form-item label="创建时间">
            {{ product.createTime }}
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="状态">
            {{
              product.auditStatus == 0
                ? '未审核'
                : product.auditStatus == 1
                ? '通过'
                : '驳回'
            }}
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <el-form-item label="轮播图">
            <img
              v-for="(item, index) in sliderUrlList"
              :key="index"
              :src="item"
              style="width: 50px;"
            />
          </el-form-item>
        </el-col>
      </el-row>

      <el-divider />
      <span style="margin-bottom: 5px;">商品SKU信息</span>
      <el-form-item label="商品SKU">
        <el-table :data="product.productSkuList" border style="width: 100%">
          <el-table-column prop="skuSpec" label="规格" width="180" />
          <el-table-column label="图片" #default="scope" width="80">
            <img :src="scope.row.thumbImg" style="width: 80px;" />
          </el-table-column>
          <el-table-column label="售价" prop="salePrice" />
          <el-table-column label="市场价" prop="marketPrice" />
          <el-table-column label="成本价" prop="costPrice" />
          <el-table-column label="库存数" prop="stockNum" />
          <el-table-column label="重量" prop="weight" />
          <el-table-column label="体积" prop="volume" />
        </el-table>
      </el-form-item>

      <el-divider />
      <span style="margin-bottom: 5px;">商品详情信息</span>
      <el-form-item label="详情图片">
        <img
          v-for="(item, index) in detailsImageUrlList"
          :key="index"
          :src="item"
          style="width: 80px;"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="success"
          size="large"
          @click="updateAuditStatus(product.id, 1)"
        >
          通过
        </el-button>
        <el-button
          type="success"
          size="large"
          plain
          @click="updateAuditStatus(product.id, -1)"
        >
          驳回
        </el-button>
        <el-button size="large" @click="dialogAuditVisible = false">
          取消
        </el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

</template>

<script setup>
import { ref , onMounted } from 'vue'
import { FindAllBrand } from '@/api/brand.js'
import { FindCategoryByParentId } from '@/api/category.js'
import { GetProductPageList, SaveProduct , UpdateProductById , GetProductById , DeleteProductById , UpdateProductStatus , UpdateProductAuditStatus } from '@/api/product.js'
import { FindBrandByCategoryId } from '@/api/categoryBrand.js'
import { FindAllProductUnit } from '@/api/productUnit.js'
import { FindAllProductSpec } from '@/api/productSpec.js'
import { useApp } from '@/pinia/modules/app'
import { ElMessage, ElMessageBox } from 'element-plus'

// ----------------------------------------------------分页列表查询 start --------------------------------------------------------------------------
// 品牌列表数据模型
const brandList = ref([])

// 分类列表
const props = {
  lazy: true,
  value: 'id',
  label: 'name',
  leaf: 'leaf',
  checkStrictly: true ,
  async lazyLoad(node, resolve) {   // 加载数据的方法
    if (typeof node.value == 'undefined') node.value = 0
    const { data } = await FindCategoryByParentId(node.value)
    data.forEach(function(item) {       //hasChildren判断是否有子节点
      item.leaf = !item.hasChildren
    })
    resolve(data)  // 返回数据  
  }
};
const categoryProps = ref(props)

// 选中的数据模型
const queryDto = ref({ brandId: '', category1Id: '' , category2Id: '', category3Id: ''})
const searchCategoryIdList = ref([])

//分页数据
const pageParamsForm = {
  page: 1, // 页码
  limit: 10, // 每页记录数
}
const pageParams = ref(pageParamsForm)

// 表格数据模型
const list = ref([])

// 总记录数数据模型
const total = ref(0)

// 钩子函数
onMounted(async () => {
    const { data } = await FindAllBrand() 
    brandList.value = data
    fetchData()
})

//页面变化
const handleSizeChange = size => {
  pageParams.value.limit = size
  fetchData()
}
const handleCurrentChange = number => {
  pageParams.value.page = number
  fetchData()
}

//重置
const resetData = () => {
  queryDto.value = {}
  searchCategoryIdList.value = []
  fetchData()
}

// 分页列表查询方法
const fetchData = async () => {

  // 处理三级分类的id
  if(searchCategoryIdList.value.length == 1) {
    queryDto.value.category1Id = searchCategoryIdList.value[0]
  }

  if(searchCategoryIdList.value.length == 2) {
    queryDto.value.category1Id = searchCategoryIdList.value[0]
    queryDto.value.category2Id = searchCategoryIdList.value[1]
  }

  if(searchCategoryIdList.value.length == 3) {
    queryDto.value.category1Id = searchCategoryIdList.value[0]
    queryDto.value.category2Id = searchCategoryIdList.value[1]
    queryDto.value.category3Id = searchCategoryIdList.value[2]
  }

  // 请求后端接口
  const { data } = await GetProductPageList( pageParams.value.page, pageParams.value.limit,queryDto.value)
  data.list.forEach(item => {
    item.sliderUrls = item.sliderUrls.split(',')
  })

  // 将响应结果数据设置给对应的属性模型
  list.value = data.list
  total.value = data.total
}

// 控制对话框是否展示的数据模型
const dialogVisible = ref(false)

// 表单label对其方式
const labelPosition = ref('top')

// 对话框激活的面板
const activeNames = ref(['productBaseInfo' , 'skuInfo' , 'productDetails' , 'submit'])

// 表单数据模型
const defaultForm = {
    id: '',
    name: '',
    brandId: '',
    category1Id: '',
    category2Id: '',
    category3Id: '',
    unitName: '',
    sliderUrls: '',
    specValue: '',
    productSkuList: [],
    detailsImageUrls: '',
}
const product = ref(defaultForm)


//进入添加
const addShow = () => {
  props.checkStrictly = false 
  dialogVisible.value = true
  //清空
  fileList.value = []
  categoryIdList.value = []
  detailsFileList.value = []
  sliderUrlList.value = []
  specValueList.value = []
  product.value = {}
  fetchProductUnit()
  fetchProductSpect()
}

// 分类级联选择器选中数据以后的数据模型
const categoryIdList = ref([])

// 分类级联选择器数据发送改变以后的事件处理函数
const categoryChange = async () => {
    if (categoryIdList.value.length == 3) {
      product.value.category1Id = categoryIdList.value[0]
      product.value.category2Id = categoryIdList.value[1]
      product.value.category3Id = categoryIdList.value[2]
      const { data } = await FindBrandByCategoryId(categoryIdList.value[2])
      categoryBrandList.value = data
      if(product.value.id) {
        product.value.brandId = ''
      }
    }
}

// 定义品牌的数据模型
const categoryBrandList = ref([])

// 商品单元的数据模型
const unitList = ref([])

// 查询所有的商品单元
const fetchProductUnit = async () => {
   const { data } = await FindAllProductUnit()
   unitList.value = data 
}


// 商品规格数据数据模型
const specList = ref([])

// 查询产品规格数据
const fetchProductSpect = async () => {
    const { data } = await FindAllProductSpec()
    specList.value = data
}


const saveOrUpdate = () => {

  console.log('submit!' + product.value)
  product.value.sliderUrls = sliderUrlList.value.join(',')
  product.value.detailsImageUrls = detailsImageUrlList.value.join(',')
  if (!product.value.id) {
    saveData()
  } else {
    updateData()
  }
}

// 新增
const saveData = async () => {
  await SaveProduct(product.value)
  dialogVisible.value = false
  ElMessage.success('操作成功')
  fetchData()
}

// 修改
const updateData = async () => {
  console.log(product.value)
  await UpdateProductById(product.value)
  dialogVisible.value = false
  ElMessage.success('操作成功')
  fetchData()
}

// 展示选择的规则数据
const specValueList = ref([])
const changeSpecValueList = () => {
  specValueList.value = JSON.parse(product.value.specValue)
  const specValueArr = [] 
  specValueList.value.forEach((item , index) => {
    specValueArr.push(item.valueList)
  })


  // last为上次运算的结果，current为数组中的当前元素
  var result = specValueArr.reduce((last, current) => {
        const array = [];
        last.forEach(par1 => {
            current.forEach(par2 => {
                array.push(par1 + " + " + par2);
            });
        });
        return array;
  });

  console.log(result)
  product.value.productSkuList = []
  result.forEach(function(item) {
    product.value.productSkuList.push({
      skuSpec: item,
      price: 0,
    })
  })

}

// 上传商品轮播图图片
const sliderUrlList = ref([])
const headers = {
  token: useApp().authorization.token     // 从pinia中获取token，在进行文件上传的时候将token设置到请求头中
}
const handleRemove = (uploadFile, uploadFiles) => {
  sliderUrlList.value.splice(sliderUrlList.value.indexOf(uploadFile.url), 1)
}
const fileList = ref([])
const handleSliderSuccess = (response, uploadFile) => {
  sliderUrlList.value.push(response.data)
}


//sku图片
const handleSkuSuccess = (response, uploadFile, fileList, row) => {
  row.thumbImg = response.data
}


// 上传商品详情图片
const detailsFileList = ref([])
const handleDetailsRemove = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
  detailsImageUrlList.value.splice( detailsImageUrlList.value.indexOf(uploadFile.url),1)
  console.log(sliderUrlList.value)
}
const detailsImageUrlList = ref([])
const handleDetailsSuccess = (response, uploadFile) => {
  console.log(response)
  detailsImageUrlList.value.push(response.data)
  console.log(detailsImageUrlList.value)
}


//进入修改
const editShow = row => {
  getById(row.id)
  props.checkStrictly = false 
  dialogVisible.value = true
}

const getById = async id => {
  const { data } = await GetProductById(id)
  product.value = data
  // eslint-disable-next-line no-debugger
  console.log(product.value)

  //分类赋值
  categoryIdList.value = [ product.value.category1Id, product.value.category2Id, product.value.category3Id]

  //处理图片
  fileList.value = []
  sliderUrlList.value = product.value.sliderUrls.split(',')
  sliderUrlList.value.forEach(url => {
    fileList.value.push({ url: url })
  })

  // 处理规格数据
  specValueList.value = JSON.parse(product.value.specValue)

  //处理sku
  // product.value.productSkuList.forEach(sku => {
  //   sku.skuSpec = sku.skuSpec.split(',').join(' * ')
  //   sku.skuSpecList = sku.skuSpec.split(',')
  // })

  //处理详情图片
  detailsFileList.value = []
  detailsImageUrlList.value = product.value.detailsImageUrls.split(',')
  detailsImageUrlList.value.forEach(url => {
    detailsFileList.value.push({ url: url })
  })

  //加载分类品牌
  getBrand() 
  fetchProductUnit()
  fetchProductSpect()
}

const getBrand = async () => {
  const { data } = await FindBrandByCategoryId(categoryIdList.value[2])
  categoryBrandList.value = data
}

//删除
const remove = async id => {
  console.log('removeDataById:' + id)
  ElMessageBox.confirm('此操作将永久删除该记录, 是否继续?', 'Warning', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  })
    .then(async () => {
      await DeleteProductById(id)
      ElMessage.success('删除成功')
      fetchData()
    })
    .catch(() => {
      ElMessage.info('取消删除')
    })
}

const dialogAuditVisible = ref(false)
const audit = async id => {
  const { data } = await GetProductById(id)
  product.value = data

  //分类赋值
  categoryIdList.value = [ product.value.category1Id, product.value.category2Id, product.value.category3Id]

  //处理图片
  fileList.value = []
  sliderUrlList.value = product.value.sliderUrls.split(',')
  sliderUrlList.value.forEach(url => {
    fileList.value.push({ url: url })
  })

  // 处理规格数据
  specValueList.value = JSON.parse(product.value.specValue)

  //处理详情图片
  detailsFileList.value = []
  detailsImageUrlList.value = product.value.detailsImageUrls.split(',')
  detailsImageUrlList.value.forEach(url => {
    detailsFileList.value.push({ url: url })
  })

  //加载分类品牌
  getBrand() 
  fetchProductUnit()
  fetchProductSpect()

  dialogAuditVisible.value = true
}

const updateAuditStatus = async (id, auditStatus) => {
  await UpdateProductAuditStatus(id, auditStatus)
  dialogAuditVisible.value = false
  ElMessage.success('操作成功')
  fetchData()
}

//上下架
const updateStatus = async (id, status) => {
  await UpdateProductStatus(id, status)
  dialogAuditVisible.value = false
  ElMessage.success('操作成功')
  fetchData()
}

</script>

<style scoped>

.search-div {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ebeef5;
  border-radius: 3px;
  background-color: #fff;
}

.tools-div {
  margin: 10px 0;
  padding: 10px;
  border: 1px solid #ebeef5;
  border-radius: 3px;
  background-color: #fff;
}

.tag-group__title {
  margin-right: 10px; /* 调整元素之间的水平间距 */
}

.specValue {
  margin-bottom: 10px;
  margin-top: 10px;
  font-size: 14px;
}

.avatar-uploader .avatar {
  width: 50px;
  height: 50px;
  display: block;
}

.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 50px;
  height: 50px;
  text-align: center;
}

</style>