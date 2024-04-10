<template>
<div :style='{"width":"1200px","padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","margin":"150px auto 20px","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"width":"100%","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="100px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="活动名称" prop="huodongmingcheng">
            <el-input  v-model="ruleForm.huodongmingcheng" 
                placeholder="活动名称" clearable :readonly=" false  ||ro.huodongmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="封面" v-if="type!='cross' || (type=='cross' && !ro.fengmian)" prop="fengmian">
            <file-upload
            tip="点击上传封面"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.fengmian?ruleForm.fengmian:''"
            @change="fengmianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' class="upload" v-else label="封面" prop="fengmian">
                <img v-if="ruleForm.fengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fengmian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fengmian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="开始时间" prop="kaishishijian">
            <el-input  v-model="ruleForm.kaishishijian" 
                placeholder="开始时间" clearable :readonly=" false  ||ro.kaishishijian"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="结束时间" prop="jieshushijian">
            <el-input  v-model="ruleForm.jieshushijian" 
                placeholder="结束时间" clearable :readonly=" false  ||ro.jieshushijian"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="活动地点" prop="huodongdidian">
            <el-input  v-model="ruleForm.huodongdidian" 
                placeholder="活动地点" clearable :readonly=" false  ||ro.huodongdidian"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="获得学分" prop="xuefen">
            <el-input  v-model.number="ruleForm.xuefen" 
                placeholder="获得学分" clearable :readonly="true  ||ro.xuefen"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社长账号" prop="shezhangzhanghao">
            <el-input  v-model="ruleForm.shezhangzhanghao" 
                placeholder="社长账号" clearable :readonly=" false  ||ro.shezhangzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团名称" prop="shetuanmingcheng">
            <el-input  v-model="ruleForm.shetuanmingcheng" 
                placeholder="社团名称" clearable :readonly=" false  ||ro.shetuanmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="负责人" prop="fuzeren">
            <el-input  v-model="ruleForm.fuzeren" 
                placeholder="负责人" clearable :readonly=" false  ||ro.fuzeren"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="报名时间" prop="baomingshijian">
              <el-date-picker
				  :disabled=" false  ||ro.baomingshijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.baomingshijian" 
                  type="datetime"
                  placeholder="报名时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="用户账号" prop="yonghuzhanghao">
            <el-input  v-model="ruleForm.yonghuzhanghao" 
                placeholder="用户账号" clearable :readonly=" false  ||ro.yonghuzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="用户姓名" prop="yonghuxingming">
            <el-input  v-model="ruleForm.yonghuxingming" 
                placeholder="用户姓名" clearable :readonly=" false  ||ro.yonghuxingming"></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"1px solid #000000","cursor":"pointer","padding":"0","boxShadow":"7px 4px 0px 0px #005FBA","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","outline":"none","borderRadius":"4px","background":"#1BB7FF","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #000000","cursor":"pointer","padding":"0","boxShadow":"7px 4px 0px 0px #005FBA","margin":"0","color":"#000","outline":"none","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        uObject: null,
        baseUrl: '',
        ro:{
            huodongmingcheng : false,
            fengmian : false,
            kaishishijian : false,
            jieshushijian : false,
            huodongdidian : false,
            xuefen : false,
            shezhangzhanghao : false,
            shetuanmingcheng : false,
            fuzeren : false,
            baomingshijian : false,
            yonghuzhanghao : false,
            yonghuxingming : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          huodongmingcheng: '',
          fengmian: '',
          kaishishijian: '',
          jieshushijian: '',
          huodongdidian: '',
          xuefen: '',
          shezhangzhanghao: '',
          shetuanmingcheng: '',
          fuzeren: '',
          baomingshijian: '',
          yonghuzhanghao: '',
          yonghuxingming: '',
        },


        rules: {
          huodongmingcheng: [
          ],
          fengmian: [
          ],
          kaishishijian: [
          ],
          jieshushijian: [
          ],
          huodongdidian: [
          ],
          xuefen: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          shezhangzhanghao: [
          ],
          shetuanmingcheng: [
          ],
          fuzeren: [
          ],
          baomingshijian: [
          ],
          yonghuzhanghao: [
          ],
          yonghuxingming: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.baomingshijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='huodongmingcheng'){
              this.ruleForm.huodongmingcheng = obj[o];
              this.ro.huodongmingcheng = true;
              continue;
            }
            if(o=='fengmian'){
              this.ruleForm.fengmian = obj[o].split(",")[0];
              this.ro.fengmian = true;
              continue;
            }
            if(o=='kaishishijian'){
              this.ruleForm.kaishishijian = obj[o];
              this.ro.kaishishijian = true;
              continue;
            }
            if(o=='jieshushijian'){
              this.ruleForm.jieshushijian = obj[o];
              this.ro.jieshushijian = true;
              continue;
            }
            if(o=='huodongdidian'){
              this.ruleForm.huodongdidian = obj[o];
              this.ro.huodongdidian = true;
              continue;
            }
            if(o=='xuefen'){
              this.ruleForm.xuefen = obj[o];
              this.ro.xuefen = true;
              continue;
            }
            if(o=='shezhangzhanghao'){
              this.ruleForm.shezhangzhanghao = obj[o];
              this.ro.shezhangzhanghao = true;
              continue;
            }
            if(o=='shetuanmingcheng'){
              this.ruleForm.shetuanmingcheng = obj[o];
              this.ro.shetuanmingcheng = true;
              continue;
            }
            if(o=='fuzeren'){
              this.ruleForm.fuzeren = obj[o];
              this.ro.fuzeren = true;
              continue;
            }
            if(o=='baomingshijian'){
              this.ruleForm.baomingshijian = obj[o];
              this.ro.baomingshijian = true;
              continue;
            }
            if(o=='yonghuzhanghao'){
              this.ruleForm.yonghuzhanghao = obj[o];
              this.ro.yonghuzhanghao = true;
              continue;
            }
            if(o=='yonghuxingming'){
              this.ruleForm.yonghuxingming = obj[o];
              this.ro.yonghuxingming = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            this.uObject = res.data.data;
            if((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0){
                this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
            }
            if((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0){
                this.ruleForm.yonghuxingming = json.yonghuxingming
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`huodongbaoming/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('huodongbaoming/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post(`huodongbaoming/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  if(this.uObject.xuefen>=0){
                                      this.uObject.xuefen = parseFloat(this.uObject.xuefen) + parseFloat(this.ruleForm.xuefen)
                                      this.$http.post(this.userTableName+'/update', this.uObject).then(res => {});
									  localStorage.setItem('sessionForm',JSON.stringify(this.uObject))
                                  }
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post(`huodongbaoming/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          if(this.uObject.xuefen>=0){
                              this.uObject.xuefen = parseFloat(this.uObject.xuefen) + parseFloat(this.ruleForm.xuefen)
                              this.$http.post(this.userTableName+'/update', this.uObject).then(res => {});
							  localStorage.setItem('sessionForm',JSON.stringify(this.uObject))
                          }
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      fengmianUploadChange(fileUrls) {
          this.ruleForm.fengmian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 100px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 100px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #000000;
	  border-radius: 4px;
	  padding: 0 12px;
	  box-shadow: 7px 4px 0px 0px #005FBA;
	  outline: none;
	  color: #000;
	  width: 300px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #000000;
	  border-radius: 4px;
	  padding: 0 10px;
	  box-shadow: 7px 4px 0px 0px #005FBA;
	  outline: none;
	  color: #000;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #000000;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  box-shadow: 7px 4px 0px 0px #005FBA;
	  outline: none;
	  color: #000;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #000000;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: 7px 4px 0px 0px #005FBA;
	  color: #000;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #000000;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: 7px 4px 0px 0px #005FBA;
	  color: #000;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #000000;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: 7px 4px 0px 0px #005FBA;
	  color: #000;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #000000;
	  border-radius: 4px;
	  padding: 12px;
	  box-shadow: 7px 4px 0px 0px #005FBA;
	  outline: none;
	  color: #000;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
