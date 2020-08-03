<template>
  <div class="m-container-small m-padded-tb-big" style="margin-bottom: 60px">
    <div class="ui container">
      <form action="#" method="post" class="ui form">
        <input type="hidden" name="id">
        <div class="required field">
          <div class="ui left labeled input">
            <label class="ui teal basic label">名称</label>
            <input type="text" v-model="name" placeholder="标签名称">
          </div>
        </div>
        <div class="field">
          <div class="ui left labeled input">
            <label class="ui teal basic label">颜色</label>
            <input type="text" v-model="color" placeholder="分类颜色" />
          </div>
        </div>
        <div class="ui right aligned container">
          <button type="button" class="ui button" onclick="window.history.go(-1)">返回</button>
          <button type="button" @click="clean" class="ui red button">清空</button>
          <button type="button" @click="randomColor()" class="ui orange button">随机颜色</button>
          <button type="button" @click="postTag" class="ui teal button">提交</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>

  import { randomColor } from "../../../utils/randomColor";

  export default {
    name: "TagInput",
    data() {
      return {
        id: '',
        name: '',
        color: ''
      }
    },
    mounted() {
      if (this.$route.query.tagId) {
        this.id = this.$route.query.tagId
        this.getByIdTag()
      } else {
        this.id = null
      }
    },
    methods: {
      // 随机颜色
      randomColor() {
        this.color = randomColor(256)
      },
      getByIdTag() {
        $.get({
          url: 'tag',
          data: { 'id': this.id },
          success: res => {
            this.id = res.id
            this.color = res.tagColour
            this.name = res.name
          }
        })
      },
      clean() {
        this.name = ''
        this.color = ''
      },
      postTag() {
        $.post({
          url: 'tags',
          data: { 'id': this.id, 'name': this.name, 'tagColour': this.color },
          success: res => {
            if (res === 0) {
              this.open()
              this.clean()
              this.id = null
              this.$router.push('/tags/list')
            } else {
              this.openError('编辑')
            }
          }
        })
      },
      openError(msg) {
        this.$message.error(msg + '失败！');
      },
      open() {
        this.$message({
          message: '编辑标签成功。',
          type: 'success'
        });
      }
    }
  }
</script>

<style scoped>

</style>
