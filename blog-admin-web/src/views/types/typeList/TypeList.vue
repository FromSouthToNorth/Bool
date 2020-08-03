<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
<!--      <div class="chart">-->
<!--        <type-bar></type-bar>-->
<!--      </div>-->
      <table class="ui teal table">
        <el-table
            :data="pageType.list"
            style="width: 100%">
          <el-table-column
              label="id"
              width="240">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.id }}</span>
            </template>
          </el-table-column>
          <el-table-column
              label="名称"
              width="280">
            <template slot-scope="scope">
              <el-tag size="medium">{{ scope.row.name }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column
              label="操作">
            <template slot-scope="scope">
              <el-button
                  size="mini"
                  icon="el-icon-edit"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button
                  size="mini"
                  type="danger"
                  icon="el-icon-delete"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <tfoot>
        <tr>
          <th colspan="6">
            <div class="block">
              <el-pagination
                  layout="prev, pager, next"
                  :page-size=pageType.pageSize
                  :page-count="4"
                  background
                  @current-change="pageTo"
                  :total=pageType.total>
              </el-pagination>
            </div>
            <a @click="addBtn" class="ui addType mini right floated teal basic button">新增</a>
          </th>
        </tr>
        </tfoot>
      </table>
    </div>
  </div>
</template>

<script>
  import TypeBar from "@/views/typeBar/TypeBar";
  export default {
    name: "TypeList",
    components: {TypeBar},
    data() {
      return {
        pageNum: 0,
        pageType: {}
      }
    },
    mounted() {
      this.getPageType()
      if (this.$route.query.typeMassage) {
        this.open("编辑")
      }
    },
    activated() {  },
    methods: {
      pageTo(pageNum) {
        this.pageNum = pageNum
        this.getPageType()
      },
      getPageType() {
        $.get({
          url: 'pagetypes',
          data: { 'pageNum': this.pageNum },
          success: res => {
            this.pageType = res
          }
        })
      },
      handleEdit(index, row) {
        this.$router.push({
          path: '/types/input',
          query: {
            typeId: row.id
          }
        })
      },
      addBtn() {
        this.$router.push('/types/input')
      },
      handleDelete(index, row) {
        let meg = confirm('确认删除：'+ row.name + ' 分类吗？')
        if (meg) {
          $.post({
            url: 'deleteType',
            data: { 'id': row.id },
            success: res => {
              if (res === 1) {
                this.getPageType()
                this.open("删除")
              } else {
                this.openError("删除")
              }
            }
          })
        }
      },
      open(msg) {
        this.$message({
          message: msg + '分类成功。',
          type: 'success'
        });
      },
      openError(msg) {
        this.$message.error(msg + '分类失败！');
      },
    }
  }
</script>

<style scoped>

</style>
