<!--<template>-->
<!--  <div class="m-container-small m-padded-tb-big" style="max-width: 1127px !important;">-->
<!--    <div class="ui container">-->
<!--      <div id="table-container">-->
<!--        <table class="ui compact teal table">-->
<!--          <thead>-->
<!--          <tr>-->
<!--            <th>url</th>-->
<!--            <th>ip</th>-->
<!--            <th>方法</th>-->
<!--            <th>访问时间</th>-->
<!--            <th>操作</th>-->
<!--          </tr>-->
<!--          </thead>-->
<!--          <tbody>-->
<!--          <tr v-if="pageLog"-->
<!--              v-for="item in pageLog.list"-->
<!--              :key="item.id"-->
<!--          >-->
<!--            <td>{{ item.url }}</td>-->
<!--            <td>{{ item.ip }}</td>-->
<!--            <td>{{ item.classMethod }}</td>-->
<!--            <td>{{ ChangeDateFormat(item.accessTime) }}</td>-->
<!--            <td>-->
<!--              <a @click="deleteLog(item.id)" class="ui mini red basic button">删除</a>-->
<!--            </td>-->
<!--          </tr>-->
<!--          </tbody>-->
<!--          <tfoot>-->
<!--          <tr>-->
<!--            <th colspan="5">-->
<!--              <div class="ui mini pagination menu">-->
<!--                <a @click="pageClick(1)"-->
<!--                   v-show="!pageLog.isFirstPage"-->
<!--                   :class="{active: pageLog.firstPage === pageNum}"-->
<!--                   class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">-->
<!--                  首页-->
<!--                </font></font></a>-->
<!--                <a @click="pageClick(pageLog.prePage)"-->
<!--                   v-show="pageLog.hasPreviousPage "-->
<!--                   class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">-->
<!--                  <i class="angle double left icon"></i>-->
<!--                </font></font></a>-->
<!--                <a @click="pageClick(item)"-->
<!--                   :class="{active: item === pageNum}"-->
<!--                   class="item"-->
<!--                   v-if="pageLog.navigatepageNums"-->
<!--                   :key="item"-->
<!--                   v-for="item in pageLog.navigatepageNums"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">-->
<!--                  {{item}}-->
<!--                </font></font></a>-->
<!--                <a @click="pageClick(pageLog.pageNum + 1)"-->
<!--                   v-show="pageLog.hasNextPage "-->
<!--                   class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">-->
<!--                  <i class="angle double right icon"></i>-->
<!--                </font></font></a>-->
<!--                <a @click="pageClick(pageLog.pages)"-->
<!--                   v-show="!pageLog.isLastPage"-->
<!--                   :class="{active: pageLog.pages === pageNum}"-->
<!--                   class="item"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">-->
<!--                  尾页-->
<!--                </font></font></a>-->
<!--              </div>-->
<!--            </th>-->
<!--          </tr>-->
<!--          </tfoot>-->
<!--        </table>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->

<!--  import ChangeDateFormat from "../../utils/ChangeDateFormat";-->

<!--  export default {-->
<!--    name: "Log",-->
<!--    data() {-->
<!--      return {-->
<!--        pageLog: {  },-->
<!--        pageNum: 0-->
<!--      }-->
<!--    },-->
<!--    mounted() {-->
<!--      this.getPageLog()-->
<!--    },-->
<!--    methods: {-->
<!--      getPageLog() {-->
<!--        $.get({-->
<!--          url: 'logs',-->
<!--          data: { 'pageNum': this.pageNum },-->
<!--          success: res => {-->
<!--            this.pageLog = res-->
<!--          }-->
<!--        })-->
<!--      },-->
<!--      ChangeDateFormat(date) {-->
<!--        return ChangeDateFormat(date)-->
<!--      },-->
<!--      pageClick(pageNum) {-->
<!--        this.pageNum = pageNum-->
<!--        this.getPageLog()-->
<!--      },-->
<!--      deleteLog(id) {-->
<!--        $.post({-->
<!--          url: 'deletelog',-->
<!--          data: { 'id': id },-->
<!--          success: res => {-->
<!--            if (res === 1) {-->
<!--              this.getPageLog()-->
<!--            }-->
<!--          }-->
<!--        })-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->