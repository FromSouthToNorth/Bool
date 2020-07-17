<template>
  <div class="m-container-small m-padded-tb-big">
    <div class="ui container">
      <table class="ui teal table">
        <thead>
        <tr>
          <th></th>
          <th>名称</th>
          <th>颜色</th>
          <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr v-if="pageTag"
            v-for="item in pageTag.list"
            :key="item.id"
        >
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td :style="{'color': item.tagColour}">{{ item.tagColour }}</td>
          <td>
            <a @click="editorTag(item.id)" class="ui mini teal basic button">编辑</a>
            <a @click="deleteTag(item.id)" class="ui mini red basic button">删除</a>
          </td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
          <th colspan="6">
            <div class="ui mini pagination menu">
              <a @click="pageTo(pageTag.prePage)" v-if="!pageTag.isFirstPage"  class="item">上一页</a>
              <a @click="pageTo(pageTag.nextPage)" v-if="!pageTag.isLastPage" class="item">下一页</a>
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
      editorTag(id) {
        this.$router.push({
          path: '/tags/input',
          query: {
            tagId: id
          }
        })
      },
      deleteTag(id) {
        let msg = confirm('确认删除编号：'+ id + '吗？')
        if (msg) {
          $.post({
            url: 'deleteTag',
            data: { 'id': id },
            success: res => {
              if (res === 0){
                this.$router.push('/tags/list')
              }
            }
          })
        }
      },
      addBtn() {
        this.$router.push('/tags/input')
      },
      pageTo(pageNum) {
        this.pageNum = pageNum
        this.getPageTag()
      }
    }
  }
</script>

<style scoped>

</style>