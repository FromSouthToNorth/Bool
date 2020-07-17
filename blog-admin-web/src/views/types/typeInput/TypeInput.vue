<template>
  <div class="m-container-small m-padded-tb-big" style="margin-bottom: 60px">
    <div class="ui container">
      <form action="#" method="post" class="ui form">
        <input type="hidden" name="id">
        <div class="required field">
          <div class="ui left labeled input">
            <label class="ui teal basic label">名称</label>
            <input type="text" v-model="name" placeholder="分类名称">
            {{ name }}
          </div>
        </div>
        <div class="ui error message"></div>
        <div class="ui right aligned container">
          <button type="button" class="ui button" onclick="window.history.go(-1)">返回</button>
          <button type="button" @click="clean" class="ui red button">清空</button>
          <button type="button" @click="postType" class="ui teal button">提交</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "TypeInput",
    data() {
      return {
        id: '',
        name: ''
      }
    },
    mounted() {
      if (this.$route.query.typeId) {
        this.id = this.$route.query.typeId
        this.getTypeById()
      } else {
        this.id = null
      }
    },
    methods: {
      getTypeById() {
        $.get({
          url: 'type',
          data: { 'id': this.id },
          success: res => {
            this.id = res.id
            this.name = res.name
          }
        })
      },
      clean() {
        this.name = ''
      },
      postType() {
        $.post({
          url: 'types',
          data: { 'id': this.id, 'name': this.name },
          success: res => {
            if (res === 0) {
              this.$router.push('/types/list')
              this.clean()
            }
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>