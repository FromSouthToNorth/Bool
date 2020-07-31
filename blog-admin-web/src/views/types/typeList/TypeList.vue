<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <table class="ui teal table">
        <thead>
        <tr>
          <th></th>
          <th>名称</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-if="pageType"
            v-for="item in pageType.list"
            :key="item.id"
        >
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>
            <a @click="editorType(item.id)" class="ui mini teal basic button">编辑</a>
            <a @click="deleteType(item.id)" class="ui mini red basic button">删除</a>
          </td>
        </tr>
        </tbody>
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
  export default {
    name: "TypeList",
    data() {
      return {
        pageNum: 0,
        pageType: {}
      }
    },
    mounted() {
      this.getPageType()
    },
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
      editorType(id) {
        this.$router.push({
          path: '/types/input',
          query: {
            typeId: id
          }
        })
      },
      addBtn() {
        this.$router.push('/types/input')
      },
      deleteType(id) {
        let meg = confirm('确认删除编号：'+ id + '吗？')
        if (meg) {
          $.post({
            url: 'deleteType',
            data: { 'id': id },
            success: res => {
              if (res === 1) {
                this.getPageType()
              }
            }
          })
        }
      }
    },
  }
</script>

<style scoped>

</style>
