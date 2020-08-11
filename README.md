## 简介：

此项目是一个基于个人的一个小博客，前台的个人博客展示，及后台博客数据管理，初步实现了前端与后端可以独立运行。 对于初学者，可以练练手。

- 在线预览：[博客](https://hyzt.vip) 

### 博客基本功能：

![img](https://202007002.oss-cn-chengdu.aliyuncs.com/images/blog%E9%A1%B9%E7%9B%AE-%E5%8D%9A%E5%AE%A2%E5%9B%BE%E7%89%87/%E5%8D%9A%E5%AE%A2%E5%8A%9F%E8%83%BD%E4%BB%8B%E7%BB%8D.png)

### 技术组合：

- 后端：[SpringBoot](https://spring.io/projects/spring-boot) + [MyBatis](https://mybatis.org/mybatis-3/zh/index.html) + [Maven](https://maven.apache.org/)
- 数据库：[MySQL](https://www.mysql.com/)
- 前端：[Vue](https://vuejs.org/) + [webpack](https://webpack.js.org/)

### 开发工具：

-  [IntelliJ IDEA](https://www.jetbrains.com/idea/)
-  [WebStorm](https://www.jetbrains.com/idea/)

### 集成插件：

- [PageHelper](https://pagehelper.github.io/)
- [commonmark-java](https://github.com/atlassian/commonmark-java)
- [druid](https://github.com/alibaba/druid)
- [vue-router](https://router.vuejs.org/zh/)
- [ajax](https://api.jquery.com/jquery.ajax/)
- [semantic-ui](https://semantic-ui.com/introduction/getting-started.html)
- [element](https://element.eleme.io/#/zh-CN)
- [mavon-editor](https://github.com/hinesboy/mavonEditor)
- [highlight](https://highlightjs.org/)
- [echarts](https://echarts.apache.org/zh/index.html)

## 网站后台

### 首页

集成 **echarts** 进行数据统计的渲染

![img](https://202007002.oss-cn-chengdu.aliyuncs.com/images/blog%E9%A1%B9%E7%9B%AE-%E5%8D%9A%E5%AE%A2%E5%9B%BE%E7%89%87/%E5%90%8E%E5%8F%B0%E9%A6%96%E9%A1%B5.png)

### 博客编辑发布页面

集成 **mavon-editor**  Markdown 编辑

![img](https://202007002.oss-cn-chengdu.aliyuncs.com/images/blog%E9%A1%B9%E7%9B%AE-%E5%8D%9A%E5%AE%A2%E5%9B%BE%E7%89%87/%E5%8D%9A%E5%AE%A2%E7%BC%96%E8%BE%91%E5%8F%91%E5%B8%83%E9%A1%B5%E9%9D%A2.png)

### 图片上传

**mavon-editor** 图片上传于对象储存 **[OSS](https://help.aliyun.com/document_detail/31817.html?spm=a2c4g.11174283.2.5.45eb7da2i9VrUH)** 

- **mavon-editor** 标签添加 `@imgAdd=""` 

~~~html
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
~~~

- 在 **methods** 中指定 `$imgAdd`方法
- 参数  `$file` --> 上传的文件信息

~~~javascript
// 图片上传
$imgAdd(pos, $file) {
  XMLHttpRequest.setRequestHeader
  const client = new OSS.Wrapper({
    region: oos.region,						// 创建Bucket时会选择不同地区，根据自己的选择填入对应名称
    accessKeyId: oos.accessKeyId,			// 填入你的accessKeyId
    accessKeySecret: oos.accessKeySecret,	// 填入你的accessKeySecret
    bucket: oos.bucket						// 填入你的bucket名
   })
   const name = $file._name
   const suffix = name.substr(name.indexOf('.'))                 // 文件后缀
   const filename = Date.parse(new Date()) + suffix              // 组成新的文件名称
   client.multipartUpload(filename, $file).then(res => {         // 上传
     this.open('上传')
     console.log('上传成功：', res)
     let url = 'http://'+ oos.bucket +'.oss-cn-chengdu.aliyuncs.com/' + filename // 拼接回显url
     this.$refs.md.$img2Url(pos, url)
   }).catch(err => {
     this.openError('上传')
     console.log('上传失败：', err)
   })
}
~~~

![img](https://202007002.oss-cn-chengdu.aliyuncs.com/images/blog%E9%A1%B9%E7%9B%AE-%E5%8D%9A%E5%AE%A2%E5%9B%BE%E7%89%87/updateimg.png)

## 服务器架构

### 主机：

[阿里云轻型服务器](https://www.aliyun.com/daily-act/ecs/s6_sales?spm=5176.14145661.J_3598540520.ace-channel-latest-activity-card.3b7018757v7ktZ)

操作系统： ![img](https://gw.alicdn.com/mt/TB18bPMa8USMeJjSszeXXcKgpXa-60-60.png)CentOS 7.3

服务器环境：

- JDK8.+*
- Git
- MySQL
- Node

### 后端部署

Spring Boot 内置 Tomcat 我选择把后端项目打成`jar`包传到服务，idea 右上角选中Maven，可以打开终端通过命令打包。

![img](https://202007002.oss-cn-chengdu.aliyuncs.com/images/blog%E9%A1%B9%E7%9B%AE-%E5%8D%9A%E5%AE%A2%E5%9B%BE%E7%89%87/%E9%A1%B9%E7%9B%AE%E6%89%93%E5%8C%85.png)

jar包上传至服务器，在项目目录执行 `java-jar` 命令 + 项目名称 运行部署

![img](https://202007002.oss-cn-chengdu.aliyuncs.com/images/blog%E9%A1%B9%E7%9B%AE-%E5%8D%9A%E5%AE%A2%E5%9B%BE%E7%89%87/%E5%90%8E%E7%AB%AF%E9%A1%B9%E7%9B%AE%E9%83%A8%E7%BD%B2.png)

### 前端部署

在本地将项目上传`github`，再在服务器通过`git`拉取项目。

在前端项目目录下， 执行**npm install** 命令初始化。再执行 **npm run serve** 命令运行



