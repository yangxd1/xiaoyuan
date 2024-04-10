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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团名称" prop="shetuanmingcheng">
            <el-select  @change="shetuanmingchengChange" v-model="ruleForm.shetuanmingcheng" placeholder="请选择社团名称">
              <el-option
                  v-for="(item,index) in shetuanmingchengOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团类型" prop="shetuanleixing">
            <el-input  v-model="ruleForm.shetuanleixing" 
                placeholder="社团类型" clearable :readonly=" false  ||ro.shetuanleixing"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团收入" prop="shetuanshouru">
            <el-input type="number" v-model.number="ruleForm.shetuanshouru" 
                placeholder="社团收入" clearable :readonly=" false  ||ro.shetuanshouru"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社团支出" prop="shetuanzhichu">
            <el-input type="number" v-model.number="ruleForm.shetuanzhichu" 
                placeholder="社团支出" clearable :readonly=" false  ||ro.shetuanzhichu"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="剩余金额" prop="shengyujine">
              <el-input v-model="shengyujine" placeholder="剩余金额" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="日期" prop="riqi">
              <el-date-picker
				  :disabled=" false  ||ro.riqi"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.riqi" 
                  type="datetime"
                  placeholder="日期">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="社长账号" prop="shezhangzhanghao">
            <el-input  v-model="ruleForm.shezhangzhanghao" 
                placeholder="社长账号" clearable :readonly=" false  ||ro.shezhangzhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"#fff"}' label="负责人" prop="fuzeren">
            <el-input  v-model="ruleForm.fuzeren" 
                placeholder="负责人" clearable :readonly=" false  ||ro.fuzeren"></el-input>
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
            shetuanmingcheng : false,
            shetuanleixing : false,
            shetuanshouru : false,
            shetuanzhichu : false,
            shengyujine : false,
            riqi : false,
            shezhangzhanghao : false,
            fuzeren : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          shetuanmingcheng: '',
          shetuanleixing: '',
          shetuanshouru: '',
          shetuanzhichu: '',
          shengyujine: '',
          riqi: '',
          shezhangzhanghao: '',
          fuzeren: '',
        },
        shetuanmingchengOptions: [],


        rules: {
          shetuanmingcheng: [
            { required: true, message: '社团名称不能为空', trigger: 'blur' },
          ],
          shetuanleixing: [
            { required: true, message: '社团类型不能为空', trigger: 'blur' },
          ],
          shetuanshouru: [
            { required: true, message: '社团收入不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          shetuanzhichu: [
            { required: true, message: '社团支出不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          shengyujine: [
            { required: true, message: '剩余金额不能为空', trigger: 'blur' },
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          riqi: [
          ],
          shezhangzhanghao: [
          ],
          fuzeren: [
          ],
        },
		centerType: false,
      };
    },
    computed: {
        shengyujine: {
            get: function () {
                return 0+parseFloat(this.ruleForm.shetuanshouru==""?0:this.ruleForm.shetuanshouru)-parseFloat(this.ruleForm.shetuanzhichu==""?0:this.ruleForm.shetuanzhichu) || 0
            }
        },



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
      this.ruleForm.riqi = this.getCurDateTime()
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
            if(o=='shetuanmingcheng'){
              this.ruleForm.shetuanmingcheng = obj[o];
              this.ro.shetuanmingcheng = true;
              continue;
            }
            if(o=='shetuanleixing'){
              this.ruleForm.shetuanleixing = obj[o];
              this.ro.shetuanleixing = true;
              continue;
            }
            if(o=='shetuanshouru'){
              this.ruleForm.shetuanshouru = obj[o];
              this.ro.shetuanshouru = true;
              continue;
            }
            if(o=='shetuanzhichu'){
              this.ruleForm.shetuanzhichu = obj[o];
              this.ro.shetuanzhichu = true;
              continue;
            }
            if(o=='shengyujine'){
              this.ruleForm.shengyujine = obj[o];
              this.ro.shengyujine = true;
              continue;
            }
            if(o=='riqi'){
              this.ruleForm.riqi = obj[o];
              this.ro.riqi = true;
              continue;
            }
            if(o=='shezhangzhanghao'){
              this.ruleForm.shezhangzhanghao = obj[o];
              this.ro.shezhangzhanghao = true;
              continue;
            }
            if(o=='fuzeren'){
              this.ruleForm.fuzeren = obj[o];
              this.ro.fuzeren = true;
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
            if((json.shezhangzhanghao!=''&&json.shezhangzhanghao) || json.shezhangzhanghao==0){
                this.ruleForm.shezhangzhanghao = json.shezhangzhanghao
            }
            if((json.fuzeren!=''&&json.fuzeren) || json.fuzeren==0){
                this.ruleForm.fuzeren = json.fuzeren
            }
          }
        });
        this.$http.get('option/shetuanxinxi/shetuanmingcheng', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.shetuanmingchengOptions = res.data.data;
          }
        });
      },
      // 下二随
      shetuanmingchengChange () {
        this.$http.get('follow/shetuanxinxi/shetuanmingcheng?columnValue=' + this.ruleForm.shetuanmingcheng, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.shetuanleixing){
              this.ruleForm.shetuanleixing = res.data.data.shetuanleixing
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`shetuancaiwu/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

          this.ruleForm.shengyujine = this.shengyujine
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
                 this.$http.get('shetuancaiwu/list', {
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


                          this.$http.post(`shetuancaiwu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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


                  this.$http.post(`shetuancaiwu/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
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
