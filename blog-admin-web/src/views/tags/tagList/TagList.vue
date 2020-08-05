<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <table class="ui teal table">
        <el-table
                :data="pageTag.list"
                style="width: 100%">
          <el-table-column
                  label="id"
                  width="180">
            <template slot-scope="scope">
              <span>{{ scope.row.id }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  label="名称"
                  width="180">
            <template slot-scope="scope">
              <span>{{ scope.row.name }}</span>
            </template>
          </el-table-column>
          <el-table-column
                  label="色彩"
                  width="180">
            <template slot-scope="scope">
              <el-tag :style="{'color': scope.row.tagColour, 'border-color': scope.row.tagColour }">
                {{ scope.row.tagColour }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button
                      size="mini"
                      icon="el-icon-edit"
                      @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
              <el-button
                      size="mini"
                      type="danger"
                      icon="el-icon-delete"
                      plain
                      @click="messageBox(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <tfoot>
        <tr>
          <th colspan="6">
            <div class="block">
              <el-pagination
                  layout="prev, pager, next"
                  :page-size=pageTag.pageSize
                  :page-count="4"
                  background
                  @current-change="pageTo"
                  :total=pageTag.total>
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
  export default {
    name: "TagList",
    data() {
      return {
        pageTag: {  },
        pageNum: 0
      }
    },
    activated() {  },
    mounted() {
      this.getPageTag()
    },
    methods: {
      getPageTag() {
        $.get({
          url: 'pagetags',
          data: { 'pageNum': this.pageNum },
          success: res => {
            this.pageTag = res
          }
        })
      },
      handleEdit(index, row) {
        this.$router.push({
          path: '/tags/input',
          query: {
            tagId: row.id
          }
        })
      },
      handleDelete(index, row) {
        $.post({
          url: 'deleteTag',
          data: { 'id': row.id },
          success: res => {
            if (res === 0){
              this.getPageTag()
              this.open("删除")
            } else {
              this.openError("删除")
            }
          }
        })
      },
      addBtn() {
        this.$router.push('/tags/input')
      },
      pageTo(pageNum) {
        this.pageNum = pageNum
        this.getPageTag()
      },
      open(msg) {
        this.$message({
          message: msg + '标签成功。',
          type: 'success'
        });
      },
      openError(msg) {
        this.$message.error(msg + '标签失败！');
      },
      messageBox(index, row) {
        this.$confirm('此操作将永久删除该标签, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.handleDelete(index, row)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      }
    }
  }
</script>

<style scoped>

</style>
