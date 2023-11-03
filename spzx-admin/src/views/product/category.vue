<template>
    <div class="tools-div">
      <el-button type="success" size="small" @click="exportData">导出</el-button>
      <el-button type="primary" size="small" @click="importData">导入</el-button>
    </div>

    <el-dialog v-model="dialogImportVisible" title="导入" width="30%">
      <el-form label-width="120px">
          <el-form-item label="分类文件">
              <el-upload
                        class="upload-demo"
                        action="http://localhost:8501/admin/product/category/importData"
                        :on-success="onUploadSuccess"
                        :headers="headers"
                        >
                  <el-button type="primary">上传</el-button>
              </el-upload>
          </el-form-item>
      </el-form>
  </el-dialog>

    <!---懒加载的树形表格-->
    <el-table
        :data="list"
        style="width: 100%"
        row-key="id"
        border
        lazy
        :load="fetchData"
        :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
        <el-table-column prop="name" label="分类名称" />
        <el-table-column prop="imageUrl" label="图标" #default="scope">
            <img :src="scope.row.imageUrl" width="50" />
        </el-table-column>
        <el-table-column prop="orderNum" label="排序" />
        <el-table-column prop="status" label="状态" #default="scope">
        {{ scope.row.status == 1 ? '正常' : '停用' }}
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" />
    </el-table>
  
  </template>

<script setup>
import { ref , onMounted} from 'vue';
import { FindCategoryByParentId,ExportCategoryData } from '@/api/category.js'
import { ElMessage, ElMessageBox } from 'element-plus'

////////////////////////导入
import { useApp } from '@/pinia/modules/app'
    
// 文件上传相关变量以及方法定义
const dialogImportVisible = ref(false)
const headers = {
  token: useApp().authorization.token     // 从pinia中获取token，在进行文件上传的时候将token设置到请求头中
}
const importData = () => {
  dialogImportVisible.value = true
}

// 上传文件成功以后要执行方法
const onUploadSuccess = async (response, file) => {
  ElMessage.success('操作成功')
  dialogImportVisible.value = false
  const { data } = await FindCategoryByParentId(0)
  list.value = data ; 
}

///////////////////////////////////
// 定义list属性模型
const list = ref([])

// 页面初始化完毕以后请求后端接口查询数据
onMounted(async () => {
  const {code , data , message} = await FindCategoryByParentId(0)
  list.value = data ; 
})

// 加载数据的方法
const fetchData = async (row, treeNode, resolve) => {
    
    // 向后端发送请求获取数据
    const {code , data , message} = await FindCategoryByParentId(row.id)

    // 返回数据
    resolve(data)

}

const exportData = () => {
  // 调用 ExportCategoryData() 方法获取导出数据
  ExportCategoryData().then(res => {
      // 创建 Blob 对象，用于包含二进制数据
      const blob = new Blob([res]);             
      // 创建 a 标签元素，并将 Blob 对象转换成 URL
      const link = document.createElement('a'); 
      link.href = window.URL.createObjectURL(blob);
      // 设置下载文件的名称
      link.download = '分类数据.xlsx';
      // 模拟点击下载链接
      link.click();
  })  
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
</style>