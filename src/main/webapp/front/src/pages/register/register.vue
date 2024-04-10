<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231101/dbc26ad962fa4660b3db1cd4303cf1a4.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"width":"690px","padding":"20px","margin":"0","borderRadius":"10px","background":"#fff","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"width":"100%","margin":"0 0 10px 0","lineHeight":"44px","fontSize":"30px","color":"#000000","textAlign":"center"}'>校园社团管理系统注册</p></div>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuzhanghao">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
				<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="mima">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="yonghuxingming">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
				<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="touxiang">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('touxiang')?'required':''">头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="yonghutouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="shoujihao">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('shoujihao')?'required':''">手机号：</div>
				<el-input v-model="registerForm.shoujihao"  placeholder="请输入手机号" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="xingbie">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('xingbie')?'required':''">性别：</div>
                <el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
                  <el-option
                      v-for="(item,index) in yonghuxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='yonghu'" prop="xuefen">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('xuefen')?'required':''">学分：</div>
				<el-input v-model.number="registerForm.xuefen" readonly placeholder="请输入学分" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="shezhangzhanghao">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('shezhangzhanghao')?'required':''">社长账号：</div>
				<el-input v-model="registerForm.shezhangzhanghao"  placeholder="请输入社长账号" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="mima">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('mima')?'required':''">密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="mima">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('mima')?'required':''">确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="shetuantupian">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('shetuantupian')?'required':''">社团图片：</div>
                <file-upload
					tip="点击上传社团图片"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.shetuantupian?registerForm.shetuantupian:''"
					@change="shetuanshetuantupianUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="shetuanmingcheng">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('shetuanmingcheng')?'required':''">社团名称：</div>
				<el-input v-model="registerForm.shetuanmingcheng"  placeholder="请输入社团名称" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="fuzeren">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('fuzeren')?'required':''">负责人：</div>
				<el-input v-model="registerForm.fuzeren"  placeholder="请输入负责人" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="lianxidianhua">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('lianxidianhua')?'required':''">联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-form-item :style='{"width":"70%","padding":"0","margin":"0 auto 15px","height":"auto"}' v-if="tableName=='shetuan'" prop="shetuanjieshao">
				<div v-if="true" :style='{"width":"114px","lineHeight":"44px","fontSize":"14px","color":"#8B9AAB"}' :class="changeRules('shetuanjieshao')?'required':''">社团介绍：</div>
			    <editor
			        :style='{"width":"100%","color":"#fff","background":"#AEBED1","height":"auto"}'
			        v-model="registerForm.shetuanjieshao" 
			        class="editor" 
			        action="file/upload">
			    </editor>
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","outline":"none","color":"#fff","borderRadius":"0","background":"#005FBA","display":"block","width":"70%","fontSize":"18px","height":"44px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 6px rgba(64, 158, 255, .5)","margin":"20px auto 5px","color":"#fff","display":"none","outline":"none","borderRadius":"8px","background":"rgba(64, 158, 255, 1)","width":"80%","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","margin":"20px auto","color":"rgba(159, 159, 159, 1)","textAlign":"center","display":"block","width":"65%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
			<div class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"40px"}'></div>
			<div class="idea2" :style='{"width":"100%","background":"blue","display":"none","height":"40px"}'></div>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					touxiang: '',
					shoujihao: '',
					xingbie: '',
					xuefen: '0',
				}
			}
			if(this.tableName=='shetuan'){
				this.registerForm = {
					shezhangzhanghao: '',
					mima: '',
					shetuantupian: '',
					shetuanmingcheng: '',
					fuzeren: '',
					lianxidianhua: '',
					shetuanjieshao: '',
					sfsh: '',
					shhf: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('shetuan' == this.tableName) {
				this.requiredRules.shezhangzhanghao = [{ required: true, message: '请输入社长账号', trigger: 'blur' }]
			}
			if ('shetuan' == this.tableName) {
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('shetuan' == this.tableName) {
				this.requiredRules.shetuanmingcheng = [{ required: true, message: '请输入社团名称', trigger: 'blur' }]
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
		if(this.$route.query.pageFlag=='register'){
		  if ('yonghu' == this.tableName) {
			this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
		  }
		  if ('yonghu' == this.tableName) {
			this.rules.shoujihao = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
			this.yonghuxingbieOptions = "男,女".split(',');
		  if ('yonghu' == this.tableName) {
			this.rules.xuefen = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
		  }
		  if ('shetuan' == this.tableName) {
			this.rules.shezhangzhanghao = [{ required: true, message: '请输入社长账号', trigger: 'blur' }];
		  }
		  if ('shetuan' == this.tableName) {
			this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
		  }
		  if ('shetuan' == this.tableName) {
			this.rules.shetuanmingcheng = [{ required: true, message: '请输入社团名称', trigger: 'blur' }];
		  }
		  if ('shetuan' == this.tableName) {
			this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
		  }
		}
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      yonghutouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      shetuanshetuantupianUploadChange(fileUrls) {
          this.registerForm.shetuantupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
				if((!this.registerForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$message.error(`用户账号不能为空`);
					return
				}
               if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `yonghu` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$message.error(`用户姓名不能为空`);
					return
				}
					if(`yonghu` == this.tableName && this.registerForm.shoujihao &&(!this.$validate.isMobile2(this.registerForm.shoujihao))){
						this.$message.error(`手机号应输入手机格式`);
						return
					}
				if(`yonghu` == this.tableName && this.registerForm.xuefen &&(!this.$validate.isIntNumer2(this.registerForm.xuefen))){
					this.$message.error(`学分应输入整数`);
					return
				}
			  if(this.tableName=='shetuan'){
				  this.registerForm.sfsh = '待审核'
			  }
				if((!this.registerForm.shezhangzhanghao) && `shetuan` == this.tableName){
					this.$message.error(`社长账号不能为空`);
					return
				}
               if(`shetuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
				if((!this.registerForm.mima) && `shetuan` == this.tableName){
					this.$message.error(`密码不能为空`);
					return
				}
				if((!this.registerForm.shetuanmingcheng) && `shetuan` == this.tableName){
					this.$message.error(`社团名称不能为空`);
					return
				}
					if(`shetuan` == this.tableName && this.registerForm.lianxidianhua &&(!this.$validate.isMobile2(this.registerForm.lianxidianhua))){
						this.$message.error(`联系电话应输入手机格式`);
						return
					}
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20231101/dbc26ad962fa4660b3db1cd4303cf1a4.png);
		
		.el-input {
		  width: auto;
		}
		
		.el-date-editor.el-input {
			width: auto;
		}
		
		.el-form-item /deep/ .el-form-item__content {
						display: flex;
					}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 4px solid #FFFFFF;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: inset 10px 10px 5px 0px rgba(0,0,0,0.302);
						outline: none;
						color: #fff;
						background: #AEBED1;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 4px solid #FFFFFF;
						border-radius: 0;
						padding: 0 10px;
						box-shadow: inset 10px 10px 5px 0px rgba(0,0,0,0.302);
						outline: none;
						color: #fff;
						background: #AEBED1;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 4px solid #FFFFFF;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: inset 10px 10px 5px 0px rgba(0,0,0,0.302);
						outline: none;
						color: #fff;
						background: #AEBED1;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 4px solid #FFFFFF;
						border-radius: 0;
						padding: 0 10px 0 30px;
						box-shadow: inset 10px 10px 5px 0px rgba(0,0,0,0.302);
						outline: none;
						color: #fff;
						background: #AEBED1;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 4px solid #FFFFFf;
		  		  cursor: pointer;
		  		  border-radius: 0;
		  		  box-shadow: inset 10px 10px 5px 0px rgba(0,0,0,0.302);
		  		  color: #fff;
		  		  background: #AEBED1;
		  		  width: 80px;
		  		  font-size: 20px;
		  		  line-height: 44px;
		  		  text-align: center;
		  		  height: 44px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 4px solid #FFFFFf;
		  		  cursor: pointer;
		  		  border-radius: 0;
		  		  box-shadow: inset 10px 10px 5px 0px rgba(0,0,0,0.302);
		  		  color: #fff;
		  		  background: #AEBED1;
		  		  width: 80px;
		  		  font-size: 20px;
		  		  line-height: 44px;
		  		  text-align: center;
		  		  height: 44px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 4px solid #FFFFFf;
		  		  cursor: pointer;
		  		  border-radius: 0;
		  		  box-shadow: inset 10px 10px 5px 0px rgba(0,0,0,0.302);
		  		  color: #fff;
		  		  background: #AEBED1;
		  		  width: 80px;
		  		  font-size: 20px;
		  		  line-height: 44px;
		  		  text-align: center;
		  		  height: 44px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				left: -10px;
				position: absolute;
				content: "*";
			}
</style>
