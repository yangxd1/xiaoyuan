<template>
<div class="center-preview" :style='{"width":"1200px","margin":"150px auto 20px","position":"relative","flexWrap":"wrap","background":"#f4f4f4","display":"flex"}'>
	<div class="title" :style='{"width":"100%","margin":"10px 0","fontSize":"20px","lineHeight":"40px","color":"#005fba","textAlign":"center"}'>{{ title }}</div>
	
	<div class="info" :style='{"padding":"20px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","margin":"50px 10px 20px 0","borderRadius":"0","background":"#ffffff","width":"30%","height":"auto"}'>
		<div :style='{"borderColor":"#efefef","color":"#333","borderWidth":"0 0 1px 0","width":"100%","lineHeight":"44px","fontSize":"15px","borderStyle":"solid","height":"44px"}'>个人信息</div>
		<div :style='{"width":"100%","borderColor":"#efefef","fontSize":0,"borderStyle":"solid","borderWidth":"0 0 1px 0","height":"auto"}' v-if="userTableName=='yonghu'">
			<el-image :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"80px","borderStyle":"solid","height":"80px"}' :src="sessionForm.touxiang?baseUrl + sessionForm.touxiang:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"width":"100%","borderColor":"#efefef","fontSize":0,"borderStyle":"solid","borderWidth":"0 0 1px 0","height":"auto"}' v-if="userTableName=='shetuan'">
			<el-image :style='{"margin":"10px auto","borderColor":"#efefef","objectFit":"cover","borderRadius":"100%","borderWidth":"0 0 1px 0","display":"block","width":"80px","borderStyle":"solid","height":"80px"}' :src="sessionForm.shetuantupian?baseUrl + sessionForm.shetuantupian:require('@/assets/avator.png')" fit="cover"></el-image>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>用户账号</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.yonghuzhanghao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>用户姓名</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.yonghuxingming}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>手机号</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.shoujihao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>性别</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.xingbie}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='yonghu'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>学分</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.xuefen}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='shetuan'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>社长账号</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.shezhangzhanghao}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='shetuan'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>社团名称</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.shetuanmingcheng}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='shetuan'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>负责人</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.fuzeren}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='shetuan'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>联系电话</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.lianxidianhua}}</div>
		</div>
		<div :style='{"padding":"0 20px","borderColor":"#efefef","borderWidth":"0 0 1px 0","display":"flex","width":"100%","lineHeight":"40px","borderStyle":"solid","height":"auto"}' v-if="userTableName=='shetuan'">
			<span class="icon iconfont icon-shouye-zhihui" :style='{"color":"#333","padding":"0 5px","fontSize":"14px"}'></span>
			<div :style='{"color":"#333","fontSize":"14px"}'>是否审核</div>
			<div :style='{"fontSize":"14px","color":"#333","textAlign":"right","flex":1}'>{{sessionForm.sfsh}}</div>
		</div>
		
	</div>
	
    <el-tabs tab-position="left" :style='{"width":"65%","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3)","margin":"50px 0 0 0","position":"relative","background":"#fff"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="100px">
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="sessionForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="用户姓名" prop="yonghuxingming">
            <el-input v-model="sessionForm.yonghuxingming" placeholder="用户姓名" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="头像">
			<file-upload
			tip="点击上传头像"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.touxiang?sessionForm.touxiang:''"
			@change="yonghutouxiangHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="手机号" prop="shoujihao">
            <el-input v-model="sessionForm.shoujihao" placeholder="手机号" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="性别">
            <el-select v-model="sessionForm.xingbie" placeholder="请选择性别" >
              <el-option v-for="(item, index) in dynamicProp.xingbie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='yonghu'" label="学分" prop="xuefen">
            <el-input v-model="sessionForm.xuefen" placeholder="学分" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='shetuan'" label="社长账号" prop="shezhangzhanghao">
            <el-input v-model="sessionForm.shezhangzhanghao" placeholder="社长账号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='shetuan'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='shetuan'" label="社团图片">
			<file-upload
			tip="点击上传社团图片"
			action="file/upload"
			:limit="1"
			:multiple="true"
			:fileUrls="sessionForm.shetuantupian?sessionForm.shetuantupian:''"
			@change="shetuanshetuantupianHandleAvatarSuccess"
			></file-upload>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='shetuan'" label="社团名称" prop="shetuanmingcheng">
            <el-input v-model="sessionForm.shetuanmingcheng" placeholder="社团名称" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='shetuan'" label="负责人" prop="fuzeren">
            <el-input v-model="sessionForm.fuzeren" placeholder="负责人" ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='shetuan'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
		  <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 10px"}' v-if="userTableName=='shetuan'" label="社团介绍">
		    <editor
		        :style='{"minHeight":"400px","border":"1px solid #000000","boxShadow":"7px 4px 0px 0px #005FBA","outline":"none","color":"#000","borderRadius":"4px","width":"100%","lineHeight":"32px","fontSize":"14px"}'
		        v-model="sessionForm.shetuanjieshao" 
		        class="editor" 
		        action="file/upload">
		    </editor>
		  </el-form-item>
          <el-form-item :style='{"padding":"0","margin":"0"}'>
            <el-button :style='{"border":"1px solid #000000","cursor":"pointer","padding":"0","boxShadow":"7px 4px 0px 0px #005FBA","margin":"0 20px 0 0","color":"rgba(255, 255, 255, 1)","outline":"none","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"1px solid #000000","cursor":"pointer","padding":"0","boxShadow":"7px 4px 0px 0px #005FBA","margin":"0","color":"rgba(64, 158, 255, 1)","outline":"none","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
		<el-tab-pane v-for="(item,index) in menuList" :key="index" v-if="hasBack(item.menu)" :label="item.child[0].menu" :name="item.child[0].tableName"></el-tab-pane>
	  
      <el-tab-pane label="我的发布"></el-tab-pane>
      <el-tab-pane label="我的地址" name="MyAddress">
        <router-view></router-view>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import menu from '@/config/menu'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
		menuList: [],
        disabled: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {},
      }
    },
    created() {
		let menus = menu.list()
		for(let x in menus){
			if(menus[x].tableName == this.userTableName){
				this.menuList = menus[x].backMenu
			}
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuzhanghao', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'yonghuxingming', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'touxiang', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'shoujihao', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xingbie', null);
		}
		if ('yonghu' == this.userTableName) {
			this.$set(this.sessionForm, 'xuefen', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'shezhangzhanghao', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'mima', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'shetuantupian', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'shetuanmingcheng', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'fuzeren', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'lianxidianhua', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'shetuanjieshao', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'sfsh', null);
		}
		if ('shetuan' == this.userTableName) {
			this.$set(this.sessionForm, 'shhf', null);
		}

      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'yonghuzhanghao', [{ required: true, message: '请输入用户账号', trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'yonghuxingming', [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]);
      }
			if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'shoujihao', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
			if ('yonghu' == this.userTableName) {
        this.$set(this.rules, 'xuefen', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
      if ('shetuan' == this.userTableName) {
        this.$set(this.rules, 'shezhangzhanghao', [{ required: true, message: '请输入社长账号', trigger: 'blur' }]);
      }
      if ('shetuan' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
      if ('shetuan' == this.userTableName) {
        this.$set(this.rules, 'shetuanmingcheng', [{ required: true, message: '请输入社团名称', trigger: 'blur' }]);
      }
			if ('shetuan' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }

      this.init();
      this.sessionForm = JSON.parse(localStorage.getItem('sessionForm'))
    },
    //方法集合
    methods: {
      init() {
        if ('yonghu' == this.userTableName) {
          this.dynamicProp.xingbie = '男,女'.split(',');
        }
      },
	  setSession(){
		  localStorage.setItem('sessionForm',JSON.stringify(this.sessionForm))
	  },
      onSubmit(formName) {
		if(`yonghu` == this.userTableName && this.sessionForm.touxiang!=null){
			this.sessionForm.touxiang = this.sessionForm.touxiang.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
		if(`shetuan` == this.userTableName && this.sessionForm.shetuantupian!=null){
			this.sessionForm.shetuantupian = this.sessionForm.shetuantupian.replace(new RegExp(this.$config.baseUrl,"g"),"");
		}
        this.$refs[formName].validate((valid) => {
			if (valid) {
				this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
					if (res.data.code == 0) {
						this.setSession()
						this.$message({
							message: '更新成功',
							type: 'success',
							duration: 1500
						});
					}
				});
			} else {
				return false;
			}
        });
      },
      yonghutouxiangHandleAvatarSuccess(fileUrls) {
        this.sessionForm.touxiang = fileUrls;
      },
      shetuanshetuantupianHandleAvatarSuccess(fileUrls) {
        this.sessionForm.shetuantupian = fileUrls;
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '我的发布':
            tab.$router.push('/index/myForumList');
            break;
          case '我的地址':
            tab.$router.push('/index/shop-address/list');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
		  default:
		  	tab.$router.push(`/index/${tab.name}?centerType=1`);
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      },
	  hasBack(name){
		  switch(name){
			case '我的收藏管理':
				return false
				break;
			default:
				return true
		  }
	  }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
		.el-tabs__nav{
			overflow: auto;
		}
		::-webkit-scrollbar {
		  -webkit-appearance: none;
		  width: 6px;
		  height: 6px;
		}
		::-webkit-scrollbar-track {
		  background: rgba(0, 0, 0, 0.1);
		  border-radius: 0;
		}
		::-webkit-scrollbar-thumb {
		  cursor: pointer;
		  border-radius: 5px;
		  background: rgba(0, 0, 0, 0.15);
		  transition: color 0.2s ease;
		}
		::-webkit-scrollbar-thumb:hover {
		  background: rgba(0, 0, 0, 0.3);
		}
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	top: 10px;
	background: #E4F2FF;
	display: flex;
	width: auto;
	border-color: #eee;
	border-width: 0;
	position: absolute;
	right: 0;
	border-style: solid;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	padding: 0 10px;
  	color: #000;
  	background: #E4F2FF;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	padding: 0 10px;
  	color: #005fba;
  	background: #E4F2FF;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	position: relative;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	padding: 0 10px;
  	color: #005fba;
  	background: #e4f2ff;
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: center;
  	height: 40px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	padding: 10px;
  	background: #fff;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 100px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 100px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
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
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
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
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
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
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
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
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #000000;
  	border-radius: 0;
  	padding: 0 12px;
  	box-shadow: 0px 4px 0px 0px #005FBA;
  	outline: none;
  	color: #000;
  	display: inline-block;
  	width: 100%;
  	font-size: 14px;
  	height: 40px;
  }
</style>
