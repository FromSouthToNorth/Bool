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
            :ishljs="true"
            @imgAdd="$imgAdd"
            @imgDel="$imgDel"
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
                <input type="hidden" id="tagIds" :value="tagIds">
                <i class="dropdown icon"></i>
                <div class="default text">标签</div>
                <div class="menu">
                  <div class="item"
                       v-if="tagList"
                       v-for="item in tagList"
                       :key="item.id"
                       :data-value="item.id"
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
              <el-switch
                  v-model="recommend"
                  inactive-text="推荐">
              </el-switch>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <el-switch
                  v-model="shareStatement"
                  inactive-text="转载声明">
              </el-switch>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <el-switch
                  v-model="appreciation"
                  inactive-text="赞赏">
              </el-switch>
            </div>
          </div>
          <div class="field">
            <div class="ui checkbox">
              <el-switch
                  v-model="commentabled"
                  inactive-text="评论">
              </el-switch>
            </div>
          </div>
        </div>
        <div class="ui error message"></div>
        <div class="ui right aligned container">
          <button type="button" class="ui button" onclick="window.history.go(-1)">返回</button>
          <button type="button" @click="clean" class="ui red button">清空</button>
          <button type="button" id="save-btn" class="ui secondary button">保存</button>
          <button type="button" id="publish-btn" class="ui teal button">发布</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  import oos from "@/utils/oos";
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
        recommend: true, //是否推荐
        shareStatement: true, //是否展示转载声明
        appreciation: true, //是否开启赞赏
        commentabled: true, //是否允许评论
        typeName: '',
        typeList: [],
        tagList: { },
        getBlog: {},
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
        this.id = this.$route.query.blogId
      } else {
        this.id = null
        this.clean()
      }
    },
    mounted() {
      $(".ui.dropdown").dropdown({
        on: "hover"
      })
      $("#tagIds").change(() => {
        this.tagIds = $("#tagIds").val();
        console.log(this.tagIds);
      })
      // 保存
      $('#save-btn').click(() => {
        this.published = false
        this.postBlog()
      })
      // 发布
      $('#publish-btn').click(() => {
        this.published = true
        this.postBlog()
      })
    },
    methods: {
      // 上传博客
      postBlog() {
        $.post({
          url: 'blogs',
          data: {
            'id': this.id,
            'title': this.title,
            'content': this.content,
            'flag':  this.flag,
            'typeId': this.typeId,
            'published': this.published,
            'tagIds': this.tagIds,
            'firstPicture': this.firstPicture,
            'description': this.description,
            'recommend': this.recommend,
            'shareStatement': this.shareStatement,
            'appreciation': this.appreciation,
            'commentabled': this.commentabled
          },
          success: res => {
            if (res === 1) {
              this.$router.push({
                path: '/blogs/list',
                query: {
                  blogMassage: true
                }
              })
            } else {
              this.openError('编辑博客')
              console.log(res, 'blogsInput')
            }
          }
        })
      },
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
      clean() {
        this.content = '' // 内容
        this.flag = '' // 原创/转载/翻译
        this.title = '' // 博客标题
        this.published = '' // 是否发布 false/true
        this.typeId = '' // 类型id
        this.tagIds = '' // 标签组合 1,2,3,4
        this.firstPicture = '' // 封面地址
        this.description = ''
        this.typeName = ''
        this.recommend = true // 是否推荐
        this.shareStatement = true // 是否展示转载声明
        this.appreciation = true // 是否开启赞赏
        this.commentabled = true // 是否允许评论
      },
      openError(msg) {
        this.$message.error(msg + '失败！');
      },
      setFlag(flag) {
        this.flag = flag
      },
      setTypeId(id) {
        this.typeId = id
      },
      // 图片上传
      $imgAdd(pos, $file) {
        XMLHttpRequest.setRequestHeader
        const client = new OSS.Wrapper({
          region: oos.region,
          accessKeyId: oos.accessKeyId,
          accessKeySecret: oos.accessKeySecret,
          bucket: oos.bucket
        })
        const name = $file._name
        const suffix = name.substr(name.indexOf('.'))                 // 文件后缀
        const filename = Date.parse(new Date()) + suffix              // 组成新的文件名称
        client.multipartUpload(filename, $file).then(res => {          // 上传
          console.log('上传成功：', res)
          let url = 'http://'+ oos.bucket +'.oss-cn-chengdu.aliyuncs.com/' + filename // 拼接回显url
          this.$refs.md.$img2Url(pos, url)
        }).catch(err => {
          console.log('上传失败：', err)
        })
      }
    }
  }
</script>

<style>
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
