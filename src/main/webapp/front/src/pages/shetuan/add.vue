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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社长账号" prop="shezhangzhanghao">
            <el-input  v-model="ruleForm.shezhangzhanghao" 
                placeholder="社长账号" clearable :readonly=" false  ||ro.shezhangzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="密码" prop="mima">
            <el-input  v-model="ruleForm.mima" 
                placeholder="密码" clearable :readonly=" false  ||ro.mima"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团图片" v-if="type!='cross' || (type=='cross' && !ro.shetuantupian)" prop="shetuantupian">
            <file-upload
            tip="点击上传社团图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.shetuantupian?ruleForm.shetuantupian:''"
            @change="shetuantupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' class="upload" v-else label="社团图片" prop="shetuantupian">
                <img v-if="ruleForm.shetuantupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shetuantupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shetuantupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团名称" prop="shetuanmingcheng">
            <el-input  v-model="ruleForm.shetuanmingcheng" 
                placeholder="社团名称" clearable :readonly=" false  ||ro.shetuanmingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="负责人" prop="fuzeren">
            <el-input  v-model="ruleForm.fuzeren" 
                placeholder="负责人" clearable :readonly=" false  ||ro.fuzeren"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="联系电话" prop="lianxidianhua">
            <el-input  v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable :readonly=" false  ||ro.lianxidianhua"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团介绍" prop="shetuanjieshao">
            <editor 
                :style='{"border":"1px solid #000000","padding":"0","boxShadow":"7px 4px 0px 0px #005FBA","margin":"0","backgroundColor":"#fff","borderRadius":"0","width":"100%","height":"auto"}'
                v-model="ruleForm.shetuanjieshao" 
                class="editor" 
                action="file/upload">
            </editor>
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
        baseUrl: '',
        ro:{
            shezhangzhanghao : false,
            mima : false,
            shetuantupian : false,
            shetuanmingcheng : false,
            fuzeren : false,
            lianxidianhua : false,
            shetuanjieshao : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          shezhangzhanghao: '',
          mima: '',
          shetuantupian: '',
          shetuanmingcheng: '',
          fuzeren: '',
          lianxidianhua: '',
          shetuanjieshao: '',
        },


        rules: {
          shezhangzhanghao: [
            { required: true, message: '社长账号不能为空', trigger: 'blur' },
          ],
          mima: [
            { required: true, message: '密码不能为空', trigger: 'blur' },
          ],
          shetuantupian: [
          ],
          shetuanmingcheng: [
            { required: true, message: '社团名称不能为空', trigger: 'blur' },
          ],
          fuzeren: [
          ],
          lianxidianhua: [
            { validator: this.$validate.isMobile, trigger: 'blur' },
          ],
          shetuanjieshao: [
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
            if(o=='shezhangzhanghao'){
              this.ruleForm.shezhangzhanghao = obj[o];
              this.ro.shezhangzhanghao = true;
              continue;
            }
            if(o=='mima'){
              this.ruleForm.mima = obj[o];
              this.ro.mima = true;
              continue;
            }
            if(o=='shetuantupian'){
              this.ruleForm.shetuantupian = obj[o].split(",")[0];
              this.ro.shetuantupian = true;
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
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='shetuanjieshao'){
              this.ruleForm.shetuanjieshao = obj[o];
              this.ro.shetuanjieshao = true;
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
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`shetuan/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
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
                 this.$http.get('shetuan/list', {
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


                          this.$http.post(`shetuan/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                              if (res.data.code == 0) {
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


                  this.$http.post(`shetuan/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                     if (res.data.code == 0) {
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
      shetuantupianUploadChange(fileUrls) {
          this.ruleForm.shetuantupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
