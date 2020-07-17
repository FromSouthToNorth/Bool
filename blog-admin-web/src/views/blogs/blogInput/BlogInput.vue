<template>
  <div class="m-padded-tb-big">
    <div class="ui container">
      <form id="blog-form" action="#" method="post" class="ui form">
        <input type="hidden" name="published">
        <input type="hidden" name="id">
        <div class="required field">
          <div class="ui left labeled input">
            <div class="ui selection compact teal basic dropdown label">
              <input type="hidden" value="原创" name="flag">
              <i class="dropdown icon"></i>
              <div class="text">{{ flag || 'FLAG' }}</div>
              <div class="menu">
                <div class="item" @click="setFlag('原创')">原创</div>
                <div class="item" @click="setFlag('转载')">转载</div>
                <div class="item" @click="setFlag('翻译')">翻译</div>
              </div>
            </div>
            <input type="text" v-model="title" name="title" placeholder="标题">
          </div>
        </div>
        <div class="required field">
          <div id="md-content" style="z-index: 1 !important;">
            <mavon-editor
            v-model="content"
            ref="md"
            style="z-index: 1 !important;"
            ></mavon-editor>
          </div>
        </div>
        <div class="two fields">
          <div class="required field">
            <div class="ui left labeled action input">
              <label class="ui compact teal basic label">分类</label>
              <div class="ui fluid selection dropdown">
                <input type="hidden" name="typeId">
                <i class="dropdown icon"></i>
                <div class="default text">{{ typeName || '分类' }}</div>
                <div class="menu">
                  <div class="item"
                       v-if="typeList"
                       v-for="item in typeList"
                       :key="item.id"
                       @click="setTypeId(item.id)">
                    {{ item.name }}
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="field">
            <div class="ui left labeled action input">
              <label class="ui compact teal basic label">标签</label>
              <div class="ui fluid selection multiple search dropdown">
                <input type="hidden" name="tagIds" :value="tagIds">
                <i class="dropdown icon"></i>
                <div class="default text">标签</div>
                <div class="menu">
                  <div class="item"
                       v-if="tagList"
                       v-for="item in tagList"
                       :key="item.id"
                  >
                    {{ item.name }}
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="required field">
          <div class="ui left labeled input">
            <label class="ui teal basic label">首图</label>
            <input type="text" name="firstPicture" placeholder="首图引用地址" v-model="firstPicture">
          </div>
        </div>
        <div class="required field">
          <textarea name="description" v-model="description" placeholder="博客描述" maxlength="200"></textarea>
        </div>
        <div class="inline fields">
          <div class="field">
            <div class="ui checkbox">
              <input type="checkbox" id="recommend" name="recommend" :checked="recommend" class="hidden">
              <label @click="setData('recommend')" for="recommend">推荐</label>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <input type="checkbox" :checked="shareStatement" id="shareStatement" name="shareStatement" class="hidden">
              <label @click="setData('shareStatement')" for="shareStatement">转载声明</label>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <input type="checkbox" :checked="appreciation" id="appreciation" name="appreciation" class="hidden">
              <label @click="setData('appreciation')" for="appreciation">赞赏</label>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <input type="checkbox" :checked="commentabled" id="commentabled" name="commentabled" class="hidden">
              <label @click="setData('commentabled')" for="commentabled">评论</label>
            </div>
          </div>
        </div>
        <div class="ui error message"></div>
        <div class="ui right aligned container">
          <button type="button" class="ui button" onclick="window.history.go(-1)">返回</button>
          <button type="button" id="save-btn" class="ui secondary button">保存</button>
          <button type="button" id="publish-btn" class="ui teal button">发布</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "BlogInput",
    data() {
      return {
        content: "", //内容
        id: "", //修改时的id
        flag: "", //原创/转载/翻译
        title: "", //博客标题
        published: "", //是否发布 false/true
        typeId: "", //类型id
        tagIds: "", //标签组合 1,2,3,4
        firstPicture: "", //封面地址
        description: "", //描述
        recommend: false, //是否推荐
        shareStatement: false, //是否展示转载声明
        appreciation: false, //是否开启赞赏
        commentabled: false, //是否允许评论
        typeName: '',
        typeList: [],
        tagList: [],
        getBlog: {}
      }
    },
    activated() {
      $.get({
        url: 'types',
        success: res => {
          this.typeList = res
        }
      })
      $.get({
        url: 'tags',
        success: res => {
          this.tagList = res
        }
      })
      if (this.$route.query.blogId) {
        this.getOneBlog(this.$route.query.blogId)
      } else {

      }
    },
    mounted() {
      $(".ui.dropdown").dropdown({
        on: "hover"
      })
      $("#tagIds").change(() => {
        this.data.tagIds = $("#tagIds").val();
        console.log(this.data.tagIds);
      })
    },
    methods: {
      getOneBlog(blogId) {
        $.post({
          url: 'blog',
          data: { 'blogId': blogId },
          success: res => {
            this.id = res.id
            this.content = res.content
            this.flag = res.flag
            this.title = res.title
            this.typeId = res.typeId
            this.published = res.published
            this.tagIds = res.tagIds
            this.firstPicture = res.firstPicture
            this.description = res.description
            this.recommend = res.recommend
            this.shareStatement = res.shareStatement
            this.appreciation = res.appreciation
            this.commentabled = res.commentabled
            this.typeName = res.type.name
          }
        })
      },
      setFlag(flag) {
        this.flag = flag
      },
      setTypeId(id) {
        this.typeId = id
      },
      setData(key) {
        this.key = !this.key
      }
    },
  }
</script>

<style scoped>
  .ui.form textarea:not([rows]) {
    height: inherit;
    max-height: inherit;
  }
  .v-note-wrapper .v-note-panel > div {
    max-height: 1000px;
  }
  .v-note-wrapper .v-note-panel {
    overflow: auto;
  }
</style>