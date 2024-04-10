<template>
	<div class="main-containers">
		<div class="body-containers" :style='{"minHeight":"100vh","padding":"130px 0 0 0","margin":"0","position":"relative","background":"#f4f4f4","zIndex":"1002"}'>
		<div class="top-container" :style='{"padding":"0 250px","top":"780px","alignItems":"center","left":"0","backgroundImage":"url(http://codegen.caihongy.cn/20231101/6d0584b697a948c9b1994445bd429f44.png)","display":"flex","width":"100%","backgroundSize":"100% 100%","position":"absolute","justifyContent":"end","height":"83px","zIndex":"1001"}'>
			<!-- info -->
			<div :style='{"padding":"0 50px","top":"0","left":"0","display":"block","width":"38%","position":"fixed","zIndex":"11","height":"75px"}'>
			  <span :style='{"padding":"0","overflow":"hidden","color":"#000000","alignItems":"center","display":"flex","width":"35%","lineHeight":"1","fontSize":"32px","position":"fixed","float":"left","height":"75px"}'>校园社团管理系统</span>
			</div>
			
			<div v-if="false" :style='{"color":"#666","margin":"0 10px","fontSize":"14px"}'>0753-1234567</div>
			
			<div id="search" class="search" :style='{"margin":"0 10px","overflow":"hidden","borderRadius":"60px","flexWrap":"wrap","left":"380px","background":"#fff","display":"flex","position":"absolute","height":"auto"}'>
				<div :style='{"margin":"0 10px 0 0"}' class="select">
					<el-select v-model="queryIndex">
						<el-option v-for="(item,index) in queryList" :key="index" :label="item.queryName" :value="index"></el-option>
					</el-select>
				</div>
				<div :style='{}' class="input" v-if="queryIndex==0">
					<el-input v-model="shetuanxinxishetuanmingcheng" placeholder="社团名称"></el-input>
				</div>
				<div :style='{"margin":"0"}' class="btn" v-if="queryIndex==0">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"50px","background":"#005FBA","width":"auto","lineHeight":"50px","fontSize":"14px","height":"50px"}' type="primary" @click="search('shetuanxinxi')">
						<span class="icon iconfont icon-fangdajing07" :style='{"color":"rgba(255, 255, 255, 1)","margin":"0 4px 0 0","fontSize":"14px"}'></span>
						搜索
					</el-button>
				</div>
			</div>
			<img v-if="headportrait&&Token" :style='{"width":"40px","margin":"0 12px","borderRadius":"50%","height":"40px"}' :src="headportrait?baseUrl + headportrait:require('@/assets/avator.png')">
			<div v-if="Token" :style='{"padding":"0 12px","fontSize":"14px","lineHeight":"32px","color":"#fff","height":"32px"}'>{{username}}</div>
			<div v-if="Token && notAdmin" :style='{"padding":"0 12px","fontSize":"14px","lineHeight":"32px","color":"#fff","height":"32px"}' @click="goMenu('/index/center')">个人中心</div>
			<el-button v-if="!Token" @click="toLogin()" :style='{"border":"0","padding":"0 12px","margin":"0 10px","color":"#fff","borderRadius":"2px","background":"#000","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>登录/注册</el-button>
			<el-button v-if="Token" @click="logout" :style='{"border":"0","padding":"0 12px","margin":"0 10px","color":"#fff","borderRadius":"2px","background":"#000","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>退出</el-button>
		</div>


			<div class="menu-preview" :style='{"padding":"0 0 0 700px","borderColor":"#efefef","margin":"0px","top":"0","borderWidth":"0","background":"#fff","width":"calc(100% - 0px)","position":"fixed","borderStyle":"solid","height":"auto","zIndex":"100"}'>
			<el-scrollbar wrap-class="scrollbar-wrapper-horizontal">
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0 0 0 120px","listStyle":"none","margin":"0","alignItems":"center","backgroundImage":"url(http://codegen.caihongy.cn/20231101/f43ef82f454648269b7f610ea5dc2c8a.png)","display":"flex","width":"100%","backgroundSize":"100% 100%","position":"relative","height":"130px"}' :default-active="activeMenu" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<div class="userinfo" :style='{"width":"84px","padding":"6px 10px 0","display":"none","height":"auto"}'>
					  <el-image :style='{"width":"100%","objectFit":"cover","borderRadius":"20px","display":"block","height":"32px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					  <div :style='{"fontSize":"12px","lineHeight":"1.5","color":"#333","textAlign":"center"}'>nickname</div>
					</div>
					<el-menu-item class="home" index="/index/home" @click.native="goMenu('/index/home')">
						<span :style='{"width":"14px","fontSize":"18px","lineHeight":"1.5","color":"inherit","height":"auto"}' class="icon iconfont icon-shouye-zhihui"></span>
						<span :style='{"color":"inherit","fontSize":"18px","lineHeight":"1.5"}'>系统首页</span>
					</el-menu-item>
					<el-menu-item class="item" v-for="(menu, index) in menuList" :index="menu.url" :key="index" @click.native="goMenu(menu.url)">
						<i :style='{"width":"14px","margin":"0","fontSize":"18px","lineHeight":"1.5","color":"inherit","height":"auto"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"1.5","fontSize":"18px","color":"inherit","height":"auto"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item class="user" index="/index/center" v-if="Token && notAdmin" @click.native="goMenu('/index/center')">
						<span :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"56px","fontSize":"14px","height":"56px"}' class="icon iconfont icon-shouye-zhihui"></span>
						<span :style='{"padding":"0 10px","lineHeight":"56px","fontSize":"14px","color":"inherit","height":"56px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</el-scrollbar>
			</div>


			<div class="banner-preview" :style='{"width":"100%","height":"600px","order":"0"}'>
				<el-carousel :style='{"width":"100%","margin":"0 auto","height":"600px"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="600px" :autoplay="true" :interval="3000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"0","width":"100%","height":"600px"}' v-for="item in carouselList" :key="item.id">
						<el-image @click="carouselClick(item.url)" :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>


			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"width":"100%","height":"auto"}'>
				<div :style='{"padding":"20px","overflow":"hidden","color":"#fff","textAlign":"center","background":"#304156","width":"100%","height":"auto"}'><div v-html="bottomContent"></div></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
import Swiper from "swiper";
import axios from 'axios'

export default {
    data() {
		return {
		queryList:[
		  {
			  queryName:"社团名称",
		  },
		],
		queryIndex: 0,
		shetuanxinxishetuanmingcheng: '',
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除","审核"],"menu":"社团","menuJump":"列表","tableName":"shetuan"}],"menu":"社团管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除"],"menu":"社团类型","menuJump":"列表","tableName":"shetuanleixing"}],"menu":"社团类型管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论","加入申请","申请退出"],"appFrontIcon":"cuIcon-addressbook","buttons":["新增","查看","修改","删除","审核","查看评论"],"menu":"社团信息","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-similar","buttons":["查看","审核"],"menu":"社团加入","menuJump":"列表","tableName":"shetuanjiaru"}],"menu":"社团加入管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-brand","buttons":["查看","审核"],"menu":"退出社团","menuJump":"列表","tableName":"tuichushetuan"}],"menu":"退出社团管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","报名活动"],"appFrontIcon":"cuIcon-similar","buttons":["查看","审核"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-explore","buttons":["查看","审核"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论"],"appFrontIcon":"cuIcon-skin","buttons":["查看","审核","查看评论"],"menu":"社团新闻","menuJump":"列表","tableName":"shetuanxinwen"}],"menu":"社团新闻管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"社团财务","menuJump":"列表","tableName":"shetuancaiwu"}],"menu":"社团财务管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-group","buttons":["新增","查看","修改","删除"],"menu":"留言交流","tableName":"forum"}],"menu":"留言交流"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-phone","buttons":["新增","查看","修改","删除"],"menu":"管理员","tableName":"users"}],"menu":"管理员管理"},{"child":[{"allButtons":["查看","修改"],"appFrontIcon":"cuIcon-form","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"allButtons":["查看","修改"],"appFrontIcon":"cuIcon-shop","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"},{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息分类","tableName":"newstype"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论","加入申请","申请退出"],"appFrontIcon":"cuIcon-full","buttons":["查看","查看评论","加入申请","申请退出"],"menu":"社团信息列表","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息模块"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","报名活动"],"appFrontIcon":"cuIcon-medal","buttons":["查看","报名活动"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论"],"appFrontIcon":"cuIcon-shop","buttons":["查看","查看评论"],"menu":"社团新闻列表","menuJump":"列表","tableName":"shetuanxinwen"}],"menu":"社团新闻模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"社团加入","menuJump":"列表","tableName":"shetuanjiaru"}],"menu":"社团加入管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-brand","buttons":["查看"],"menu":"退出社团","menuJump":"列表","tableName":"tuichushetuan"}],"menu":"退出社团管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-explore","buttons":["查看"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"}],"frontMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论","加入申请","申请退出"],"appFrontIcon":"cuIcon-full","buttons":["查看","查看评论","加入申请","申请退出"],"menu":"社团信息列表","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息模块"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","报名活动"],"appFrontIcon":"cuIcon-medal","buttons":["查看","报名活动"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论"],"appFrontIcon":"cuIcon-shop","buttons":["查看","查看评论"],"menu":"社团新闻列表","menuJump":"列表","tableName":"shetuanxinwen"}],"menu":"社团新闻模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论","加入申请","申请退出"],"appFrontIcon":"cuIcon-addressbook","buttons":["新增","查看","修改","删除","查看评论"],"menu":"社团信息","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-similar","buttons":["查看","审核","删除"],"menu":"社团加入","menuJump":"列表","tableName":"shetuanjiaru"}],"menu":"社团加入管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-brand","buttons":["查看","审核","删除"],"menu":"退出社团","menuJump":"列表","tableName":"tuichushetuan"}],"menu":"退出社团管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","报名活动"],"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"社团活动","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核"],"appFrontIcon":"cuIcon-explore","buttons":["查看","审核"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论"],"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除","查看评论"],"menu":"社团新闻","menuJump":"列表","tableName":"shetuanxinwen"}],"menu":"社团新闻管理"},{"child":[{"allButtons":["新增","查看","修改","删除"],"appFrontIcon":"cuIcon-time","buttons":["新增","查看","修改","删除"],"menu":"社团财务","menuJump":"列表","tableName":"shetuancaiwu"}],"menu":"社团财务管理"}],"frontMenu":[{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论","加入申请","申请退出"],"appFrontIcon":"cuIcon-full","buttons":["查看","查看评论","加入申请","申请退出"],"menu":"社团信息列表","menuJump":"列表","tableName":"shetuanxinxi"}],"menu":"社团信息模块"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","报名活动"],"appFrontIcon":"cuIcon-medal","buttons":["查看","报名活动"],"menu":"社团活动列表","menuJump":"列表","tableName":"shetuanhuodong"}],"menu":"社团活动模块"},{"child":[{"allButtons":["新增","查看","修改","删除","审核","查看评论"],"appFrontIcon":"cuIcon-shop","buttons":["查看","查看评论"],"menu":"社团新闻列表","menuJump":"列表","tableName":"shetuanxinwen"}],"menu":"社团新闻模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"社团","tableName":"shetuan"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			headportrait: localStorage.getItem('headportrait')?localStorage.getItem('headportrait'):'',
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],
			bottomContent: '',
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
        if(localStorage.getItem('Token') && localStorage.getItem('Token')!=null) {
			this.getSession()
        }
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';



    },
    computed: {
		activeMenu() {
			const route = this.$route
			const {
				meta,
				path
			} = route
			// if st path, the sidebar will highlight the path you sete
			if (meta.activeMenu) {
				return meta.activeMenu
			}
			return path
		},
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
            // window.scrollTo( 0, 100 )
        },
		headportrait(){
			this.$forceUpdate()
		},
    },
    methods: {
      search(tablename) {
        if (this.queryIndex == 0 && this.shetuanxinxishetuanmingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.shetuanxinxishetuanmingcheng}});
        }
      },

		getSession() {
			this.$http.get(`${localStorage.getItem('UserTableName')}/session`, {emulateJSON: true}).then(res => {
				if (res.data.code == 0) {
					localStorage.setItem('sessionForm',JSON.stringify(res.data.data))
					localStorage.setItem('userid', res.data.data.id);
					if(res.data.data.vip) {
						localStorage.setItem('vip', res.data.data.vip);
					}
					if(res.data.data.touxiang) {
						this.headportrait = res.data.data.touxiang
						localStorage.setItem('headportrait', res.data.data.touxiang);
					} else if(res.data.data.headportrait) {
						this.headportrait = res.data.data.headportrait
						localStorage.setItem('headportrait', res.data.data.headportrait);
					}
				}
			});
		},
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		// 轮播图跳转
		carouselClick(url) {
			if (url) {
				if (url.indexOf('https') != -1) {
					window.open(url)
				} else {
					this.$router.push(url)
				}
			}
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            this.$router.push(path);
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	  
	    & /deep/ .scrollbar-wrapper-vertical {
	      overflow-x: hidden;
	    }
	  
	    & /deep/ .scrollbar-wrapper-horizontal {
	      overflow-y: hidden;
	  
	      .el-scrollbar__view {
	        white-space: nowrap;
	      }
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.home {
				cursor: pointer;
				border: 0;
				padding: 10px 20px;
				margin: 0 5px;
				color: #333;
				white-space: nowrap;
				display: flex;
				font-size: 14px;
				border-radius: 50px;
				flex-direction: column;
				background: #fff;
				justify-content: center;
				align-items: center;
				position: relative;
				list-style: none;
				height: auto;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.home:hover {
				color: #fff;
				background: rgba(255,255,255,.3);
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.home.is-active {
				color: #fff;
				background: rgba(255,255,255,.3);
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.user {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.user:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.user.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.service {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.service:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.service.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.shop {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.shop:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.shop.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.back {
				cursor: pointer;
				border: 0;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				display: none;
				font-size: 14px;
				line-height: 56px;
				background: #fff;
				align-items: center;
				position: relative;
				list-style: none;
				height: 56px;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.back:hover {
				color: #fff;
				background: red;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.back.is-active {
				color: #fff;
				background: blue;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.item {
				cursor: pointer;
				border: 0;
				padding: 10px 20px;
				margin: 0 5px;
				color: #fff;
				white-space: nowrap;
				display: flex;
				font-size: 14px;
				border-radius: 50px;
				flex-direction: column;
				background: #005FBA;
				justify-content: center;
				align-items: center;
				position: relative;
				list-style: none;
				height: auto;
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.item:hover {
				color: #fff;
				background: rgba(255,255,255,.3);
			}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.item.is-active {
				color: #fff;
				background: rgba(255,255,255,.3);
			}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #4d8fcf;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #4d8fcf;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
        padding-bottom: 20px;
        width: 100%;
        margin-bottom: 10px;
        max-height: 300px;
        height: 300px;
        overflow-y: scroll;
        border: 1px solid #eeeeee;
        background: #fff;

        .left-content {
            float: left;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }

        .right-content {
            float: right;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }
    }

    .clear-float {
        clear: both;
    }


	
	// -------- search --------
	.main-containers .search .select /deep/ .el-input__inner {
				border-radius: 0;
				padding: 0px 30px;
				outline: none;
				color: #000;
				width: 150px;
				font-size: 14px;
				border-color: #000;
				border-width: 0 2px 0 0;
				border-style: #000;
				height: 50px;
			}
	
	.main-containers .search .input /deep/ .el-input__inner {
				border: 0;
				border-radius: 4px;
				padding: 0 10px;
				outline: none;
				color: #000;
				width: 180px;
				font-size: 14px;
				height: 50px;
			}
	// -------- search --------
	
	.main-containers .btn-service {
				border: 0;
				padding: 0 8px;
				margin: 0 10px;
				color: #fff;
				background: #000;
				width: auto;
				font-size: 14px;
				line-height: 32px;
				height: 32px;
			}
	
	.main-containers .btn-service:hover {
				color: #000;
				background: #eee;
			}
	
	.main-containers .btn-shop {
				border: 0;
				padding: 0 8px;
				margin: 0 10px;
				color: #fff;
				background: #000;
				width: auto;
				font-size: 14px;
				line-height: 32px;
				height: 32px;
			}
	
	.main-containers .btn-shop:hover {
				color: #000;
				background: #eee;
			}
</style>
