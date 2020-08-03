<template>
  <div class="m-padded-tb-big">
    <div class="ui container home">
      <el-row style="margin-bottom: 20px">
        <el-col :span="6" class="m-padded10">
          <admin :isRes="isRes"></admin>
        </el-col>
        <el-col :span="18" class="m-padded10">
          <el-row :gutter="20">
            <el-col :span="8">
              <div class="el-card">
                <div class="grid-content grid-con-1">
                  <i class="grid-con-icon el-icon-location-outline"></i>
                  <div class="grid-cont-right">
                    <div class="grid-num">{{ total.typeTotal }}</div>
                    <div>分类数量</div>
                  </div>
                </div>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="el-card">
                <div class="grid-content grid-con-2">
                  <i class="grid-con-icon el-icon-price-tag"></i>
                  <div class="grid-cont-right">
                    <div class="grid-num">{{ total.tagTotal }}</div>
                    <div>标签数量</div>
                  </div>
                </div>
              </div>
            </el-col>
            <el-col :span="8">
              <div class="el-card">
                <div class="grid-content grid-con-3">
                  <i class="grid-con-icon el-icon-reading"></i>
                  <div class="grid-cont-right">
                    <div class="grid-num">{{ total.blogTotal }}</div>
                    <div>博客数量</div>
                  </div>
                </div>
              </div>
            </el-col>
          </el-row>
          <el-row style="margin-top: 40px;">
            <el-col :span="12">
              <type-bar></type-bar>
            </el-col>
            <el-col :span="12">
              <type-pie></type-pie>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import TypeBar from "@/views/typeBar/TypeBar";
import TypePie from "@/views/tagPie/TagPie";
import Admin from "@/views/admin/Admin";
export default {
name: "Home",
  components: { Admin, TypePie, TypeBar },
  data() {
   return {
     total: {
       blogTotal: '',
       tagTotal: '',
       typeTotal: ''
     },
     isRes: null,
   }
  },
  activated() {
    this.getTotal()
  },
  methods: {
    getTotal() {
      $.get({
        url: 'ttbtotal',
        success: res => {
          this.total = res
        }
      })
    }
  }
}
</script>

<style>
.home {
  margin-bottom: 80px;
}
 .grid-content {
   display: -webkit-box;
   display: -ms-flexbox;
   display: flex;
   -webkit-box-align: center;
   -ms-flex-align: center;
   align-items: center;
   height: 100px;
 }
 .grid-cont-right {
   -webkit-box-flex: 1;
   -ms-flex: 1;
   flex: 1;
   text-align: center;
   font-size: 14px;
   color: #999
 }
 .grid-num {
   color: #00B5AD;
   font-size: 26px;
   font-weight: 600;
 }
 .grid-con-icon {
   font-size: 30px;
   width: 100px;
   height: 100px;
   text-align: center;
   line-height: 100px;
   color: #fff;
 }
 .grid-con-1 .grid-con-icon {
   background: #8cc5ff;
 }
 .grid-con-2 .grid-con-icon {
   background: #e1f3d8;
 }
 .grid-con-3 .grid-con-icon {
   background: #faecd8;
 }
</style>
