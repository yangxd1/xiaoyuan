<template>
<div class="home-preview" :style='{"width":"100%","margin":"100px auto 0","position":"relative","flexDirection":"column","display":"flex"}'>

	<!-- 搜索 -->
	<div id="search" class="search animate__animated" :style='{"padding":"30px","margin":"0 0 10px","flexWrap":"wrap","background":"#fff","display":"none","width":"100%","height":"auto"}'>
		<div :style='{"margin":"0 10px 0 0"}' class="select">
			<el-select v-model="queryIndex">
				<el-option
				  v-for="(item,index) in queryList"
				  :key="index"
				  :label="item.queryName"
				  :value="index"
				></el-option>
			</el-select>
		</div>
		<div :style='{"margin":"0 10px 0 0"}' class="input" v-if="queryIndex==0">
			<el-input v-model="shetuanxinxishetuanmingcheng" placeholder="社团名称"></el-input>
		</div>
		<div :style='{"margin":"0"}' class="btn" v-if="queryIndex==0">
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' type="primary" @click="search('shetuanxinxi')">
				<span class="icon iconfont icon-fangdajing07" :style='{"color":"rgba(255, 255, 255, 1)","margin":"0 4px 0 0","fontSize":"14px"}'></span>
				搜索
			</el-button>
		</div>
	</div>
	<!-- 搜索 -->


		<!-- 关于我们 -->
		<div id="about" class="animate__animated" :style='{"minHeight":"700px","padding":"60px 18%","boxShadow":"0 1px 6px rgba(255, 255, 255, .3)","margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative","height":"auto","order":"3"}'>
		  <div :style='{"transform":"translate(-50%,0)","color":"#005FBA","top":"25px","textAlign":"center","left":"50%","background":"#fff","display":"block","width":"300px","fontSize":"36px","position":"absolute","zIndex":"111","height":"40px"}'>{{aboutUsDetail.title}}</div>
		  <div :style='{"margin":"0 0 10px","color":"#999","textAlign":"center","display":"none","width":"100%","lineHeight":"1.5","fontSize":"20px"}'>{{aboutUsDetail.subtitle}}</div>
		  <div :style='{"padding":"0 0 0 50px","flexWrap":"wrap","bottom":"100px","display":"flex","width":"650px","position":"absolute","height":"350px","zIndex":"11"}'>
		    <img :style='{"width":"100%","objectFit":"cover","display":"block","height":"100%"}' :src="baseUrl + aboutUsDetail.picture1">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture2">
		    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture3">
		  </div>
		  <div :style='{"padding":"0","margin":"0 0 10px 0","overflow":"hidden","color":"#9E9E9E","bottom":"200px","width":"35%","lineHeight":"2","fontSize":"15px","position":"absolute","right":"10%","height":"180px"}' v-html="aboutUsDetail.content"></div>
		  <div :style='{"width":"590px","position":"absolute","background":"#005fba","bottom":"50px","display":"block","height":"500px"}' />
		  <div :style='{"border":"2px solid #D8D8D8","transform":"translate(-50%,0)","top":"50px","left":"50%","display":"block","width":"350px","position":"absolute","height":"80px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"0","margin":"10px auto","borderRadius":"20px","textAlign":"center","background":"#005FBA","bottom":"125px","display":"block","width":"120px","lineHeight":"40px","position":"absolute","right":"25%","height":"40px"}' @click="toDetail('aboutusDetail',aboutUsDetail)">
		    <span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		    <span class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"12px"}'></span>
		  </div>
		</div>
		<!-- 关于我们 -->

		<!-- 系统简介 -->
		<div id="system" class="animate__animated" :style='{"minHeight":"550px","padding":"60px 20%","boxShadow":"0 1px 6px rgba(255, 255, 255, .3)","margin":"0","background":"url(http://codegen.caihongy.cn/20231102/e2f3efcab461454ba0f6f3f2293b7499.png) 100% 100%","flexDirection":"column","display":"flex","width":"100%","order":"5"}'>
		  <div :style='{"width":"100%","lineHeight":"1.5","fontSize":"36px","color":"#FFFFFF","textAlign":"center"}'>{{systemIntroductionDetail.title}}</div>
		  <div :style='{"width":"100%","margin":"0 0 10px","lineHeight":"1.5","fontSize":"20px","color":"#999","textAlign":"center"}'>{{systemIntroductionDetail.subtitle}}</div>
		  <div :style='{"width":"100%","padding":"0 10px","flexWrap":"wrap","display":"flex","height":"auto","order":"1"}'>
		    <img :style='{"border":"5px solid #FFFFFF","margin":"0 10px 0 0","objectFit":"cover","flex":1,"display":"block","height":"250px"}' :src="baseUrl + systemIntroductionDetail.picture1">
		    <img :style='{"border":"5px solid #FFFFFF","margin":"0 10px","objectFit":"cover","flex":"3","display":"block","height":"250px"}' :src="baseUrl + systemIntroductionDetail.picture2">
		    <img :style='{"border":"5px solid #FFFFFF","margin":"0 10px","objectFit":"cover","flex":"4","display":"block","height":"250px"}' :src="baseUrl + systemIntroductionDetail.picture3">
		  </div>
		  <div :style='{"padding":"0","margin":"0 0 10px 0","color":"#FFFFFF","width":"100%","lineHeight":"30px","fontSize":"16px","height":"120px"}' v-html="systemIntroductionDetail.content"></div>
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"width":"285px","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
		  <div :style='{"border":"0","margin":"10px auto","textAlign":"center","background":"#409EFF","display":"none","width":"80px","lineHeight":"32px"}' @click="toDetail('systemintroDetail',systemIntroductionDetail)">
		    <span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		    <span class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"12px"}'></span>
		  </div>
		</div>
		<!-- 系统简介 -->
		
	<!-- 新闻资讯 -->
	<div id="animate_newsnews" class="news animate__animated" :style='{"margin":"0","background":"#fff","order":"4"}'>
		<div v-if="true" class="idea newsIdea" :style='{"width":"100%","padding":"0","backgroundSize":"100% 100%","position":"relative","backgroundImage":"url(http://codegen.caihongy.cn/20231102/b317f9b9ac5743bab23a0889d388aa47.png)","height":"300px"}'>
			<div class="box1" :style='{"transform":"translate(-50%,0)","top":"70px","left":"50%","background":"rgba(255,255,255,0.5)","width":"500px","position":"absolute","height":"160px"}'></div>
			<div class="box2" :style='{"border":"2px solid #fff","transform":"translate(-50%,0)","top":"110px","left":"50%","width":"350px","position":"absolute","height":"80px"}'></div>
			<div class="box3" :style='{"transform":"translate(-50%,0)","color":"#fff","textAlign":"center","left":"50%","background":"#8495a5","bottom":"96px","width":"200px","lineHeight":"30px","position":"absolute","height":"30px"}'>用户的需要，我们的追求</div>
			<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
			<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		</div>
		
		<div class="title" :style='{"transform":"translate(-50%,0)","top":"90px","textAlign":"center","left":"50%","background":"#8898a8","width":"220px","lineHeight":"40px","position":"absolute"}'>
			<span :style='{"color":"#FFFFFF","fontSize":"36px"}'>公告信息</span>
		</div>
		
			
			
			
			
			
			
			
			
			
			
		





		<div v-if="newsList.length" class="list list16 index-pv1" :style='{"padding":"50px 0","margin":"0 auto","background":"#fff","display":"flex","width":"65%","justifyContent":"space-around","height":"800px"}'>
		  <div :style='{"width":"32%","padding":"40px 30px","background":"#005FBA","height":"auto"}' v-for="item,index in [1,2,3]" :key="index">
		    <template v-for="(item1,index1) in newsList">
		    <div v-if="index1 >= index*6 && index1 < (index+1)*6" :style='{"padding":"10px","borderColor":"#005FBA","alignItems":"center","borderWidth":"0 0 1px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"center","height":"100px"}' @click="toDetail('newsDetail', item1)">
		      <div :style='{"color":"rgb(64, 158, 255)","textAlign":"center","background":"#E5F2FF","width":"90px","lineHeight":"70px","fontSize":"16px","fontWeight":"bold","height":"70px"}'>{{item1.addtime.split(" ")[0].split("-")[1] + '-' + item1.addtime.split(" ")[0].split("-")[2]}}</div>
		      <div :style='{"padding":"0 0 0 10px","overflow":"hidden","color":"#333","alignItems":"center","flex":"1","display":"flex","lineHeight":"30px","fontSize":"15px","height":"90px"}'>{{item1.title}}</div>
		    </div>
			</template>
		  </div>
		</div>






		<div @click="moreBtn('news')" :style='{"border":"0","margin":"0","borderRadius":"20px","top":"130px","textAlign":"center","background":"#FFFFFF","display":"block","width":"120px","lineHeight":"40px","position":"absolute","right":"20%"}'>
			<span :style='{"color":"#005fba","fontSize":"12px"}'>更多</span>
			<i :style='{"color":"#005fba","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
		</div>
		
		</div>
	<!-- 新闻资讯 -->


<!-- 商品推荐 -->
<div id="animate_recommendshetuanxinxi" class="recommend animate__animated" :style='{"padding":"50px 0","margin":"0","background":"#fff","order":"0"}'>
	<div v-if="true" class="idea recommendIdea" :style='{"padding":"20px"}'>
		<div class="box1" :style='{"border":"2px solid #eee","width":"350px","margin":"auto","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"200px","margin":"-10px auto 0","color":"#9E9E9E","textAlign":"center","background":"#fff","height":"30px"}'>用户的需要，我们的追求</div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"240px","margin":"-150px auto 100px","lineHeight":"54px","textAlign":"center","background":"#fff"}'>
		<span :style='{"color":"#005FBA","fontSize":"30px"}'>社团信息推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	







		<div v-if="shetuanxinxiRecommend.length" :style='{"margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"65%","justifyContent":"space-between","height":"auto"}' class="list list17 index-pv1">
		  <div v-for="item,index in shetuanxinxiRecommend" :key="index"  @click="toDetail('shetuanxinxiDetail', item)" :style='{"width":"32%","margin":"20px 0 0","overflow":"hidden","position":"relative","background":"#fff","height":"280px"}' class="item">
				<img class="image" v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
				<img class="image" v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
			<div class="content">
		      <div :style='{"padding":"0 10px","overflow":"hidden","color":"#fff","maxHeight":"60px","width":"100%","lineHeight":"20px","fontSize":"14px","order":"1"}'>{{item.shhf}}</div>

		      <div class="info">
				<div :style='{"margin":"0","overflow":"hidden","color":"#fff","width":"100%","lineHeight":"20px","fontSize":"14px","height":"20px"}' class="name ">{{item.shetuanmingcheng}}</div>
				<div :style='{"margin":"0","overflow":"hidden","color":"#fff","width":"100%","lineHeight":"20px","fontSize":"14px","height":"20px"}' class="name ">入团状态:{{item.rutuanzhuangtai}}</div>
				<div :style='{"padding":"0","margin":"0","order":"1"}'>
		          <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0"}'>
		          <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.shezhangzhanghao}}</span>
		        </div>
		        <div :style='{"padding":"0"}'>
		          <span class="icon iconfont icon-zan10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.thumbsupnum}}</span>
		        </div>
		        <div :style='{"padding":"0"}'>
		          <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0"}'>
		          <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.clicknum}}</span>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('shetuanxinxi')" :style='{"border":"0","margin":"10px auto","borderRadius":"20px","top":"70px","textAlign":"center","background":"#005FBA","display":"block","width":"120px","lineHeight":"40px","position":"absolute","right":"20%"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->

<!-- 商品推荐 -->
<div id="animate_recommendshetuanhuodong" class="recommend animate__animated" :style='{"padding":"50px 0","margin":"0","background":"#fff","order":"0"}'>
	<div v-if="true" class="idea recommendIdea" :style='{"padding":"20px"}'>
		<div class="box1" :style='{"border":"2px solid #eee","width":"350px","margin":"auto","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"200px","margin":"-10px auto 0","color":"#9E9E9E","textAlign":"center","background":"#fff","height":"30px"}'>用户的需要，我们的追求</div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"240px","margin":"-150px auto 100px","lineHeight":"54px","textAlign":"center","background":"#fff"}'>
		<span :style='{"color":"#005FBA","fontSize":"30px"}'>社团活动推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	







		<div v-if="shetuanhuodongRecommend.length" :style='{"margin":"0 auto","flexWrap":"wrap","background":"#fff","display":"flex","width":"65%","justifyContent":"space-between","height":"auto"}' class="list list17 index-pv1">
		  <div v-for="item,index in shetuanhuodongRecommend" :key="index"  @click="toDetail('shetuanhuodongDetail', item)" :style='{"width":"32%","margin":"20px 0 0","overflow":"hidden","position":"relative","background":"#fff","height":"280px"}' class="item">
				<img class="image" v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
				<img class="image" v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="content">
		      <div :style='{"padding":"0 10px","overflow":"hidden","color":"#fff","maxHeight":"60px","width":"100%","lineHeight":"20px","fontSize":"14px","order":"1"}'>{{item.shhf}}</div>

		      <div class="info">
				<div :style='{"margin":"0","overflow":"hidden","color":"#fff","width":"100%","lineHeight":"20px","fontSize":"14px","height":"20px"}' class="name ">{{item.huodongmingcheng}}</div>
				<div :style='{"margin":"0","overflow":"hidden","color":"#fff","width":"100%","lineHeight":"20px","fontSize":"14px","height":"20px"}' class="name ">{{item.shetuanmingcheng}}</div>
				<div :style='{"margin":"0","overflow":"hidden","color":"#fff","width":"100%","lineHeight":"20px","fontSize":"14px","height":"20px"}' class="name ">{{item.fuzeren}}</div>
				<div :style='{"padding":"0","margin":"0","order":"1"}'>
		          <span class="icon iconfont icon-shijian21" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.addtime}}</span>
		        </div>
		        <div :style='{"padding":"0"}'>
		          <span class="icon iconfont icon-geren16" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.shezhangzhanghao}}</span>
		        </div>
		        <div :style='{"padding":"0"}'>
		          <span class="icon iconfont icon-shoucang10" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.storeupnum}}</span>
		        </div>
		        <div :style='{"padding":"0"}'>
		          <span class="icon iconfont icon-chakan9" :style='{"margin":"0 2px 0 0","lineHeight":"1.5","fontSize":"12px","color":"#fff"}'></span>
		          <span :style='{"color":"#fff","lineHeight":"1.5","fontSize":"12px"}'>{{item.clicknum}}</span>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
	
	<div @click="moreBtn('shetuanhuodong')" :style='{"border":"0","margin":"10px auto","borderRadius":"20px","top":"70px","textAlign":"center","background":"#005FBA","display":"block","width":"120px","lineHeight":"40px","position":"absolute","right":"20%"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	
</div>
<!-- 商品推荐 -->


<!-- 特价商品 -->
<div id="animate_listshetuan" class="lists animate__animated" :style='{"minHeight":"800px","padding":"50px 0","margin":"0","background":"url(http://codegen.caihongy.cn/20231102/575764f19ff74596935cacffdbc1313e.png)"}'>
	<div v-if="true" class="idea" :style='{"padding":"20px"}'>
		<div class="box1" :style='{"border":"2px solid #fff","width":"350px","margin":"0 auto","height":"80px"}'></div>
		<div class="box2" :style='{"width":"180px","margin":"-10px auto 0","color":"#9E9E9E","textAlign":"center","background":"#163d61","height":"30px"}'>用户的需要，我们的追求</div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"220px","margin":"-150px auto 100px","lineHeight":"54px","textAlign":"center","background":"#163d61"}'>
	  <span :style='{"color":"#fff","fontSize":"30px"}'>社团展示</span>
	</div>
	
	
	
	
	
	
	
	
	
	


	<div v-if="shetuanList.length" class="list list11 index-pv1" :style='{"width":"65%","margin":"0 auto","display":"flex","height":"auto"}'>
	  <div class="list" :style='{"flexWrap":"wrap","flex":"1","display":"flex","height":"auto"}'>
	    <div :style='{"margin":"10px 1%","overflow":"hidden","borderRadius":"10px","background":"#fff","width":"31%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in shetuanList" :key="index" @click="toDetail('shetuanDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","display":"block","height":"180px"}' v-if="preHttp(item.shetuantupian)" :src="item.shetuantupian.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","display":"block","height":"180px"}' v-else :src="baseUrl + (item.shetuantupian?item.shetuantupian.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"0 10px","overflow":"hidden","color":"#9E9E9E","textAlign":"center","lineHeight":"60px","fontSize":"18px","height":"60px"}'>{{item.shetuanmingcheng}}</div>
	    </div>
	  </div>
	</div>




	
	
	<div @click="moreBtn('shetuan')" :style='{"border":"0","margin":"10px auto","borderRadius":"20px","top":"80px","textAlign":"center","background":"#005FBA","display":"block","width":"120px","lineHeight":"40px","position":"absolute","right":"20%"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	

</div>
<!-- 特价商品 -->

<!-- 特价商品 -->
<div id="animate_listshetuanxinxi" class="lists animate__animated" :style='{"minHeight":"800px","padding":"50px 0","margin":"0","background":"url(http://codegen.caihongy.cn/20231102/575764f19ff74596935cacffdbc1313e.png)"}'>
	<div v-if="true" class="idea" :style='{"padding":"20px"}'>
		<div class="box1" :style='{"border":"2px solid #fff","width":"350px","margin":"0 auto","height":"80px"}'></div>
		<div class="box2" :style='{"width":"180px","margin":"-10px auto 0","color":"#9E9E9E","textAlign":"center","background":"#163d61","height":"30px"}'>用户的需要，我们的追求</div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"220px","margin":"-150px auto 100px","lineHeight":"54px","textAlign":"center","background":"#163d61"}'>
	  <span :style='{"color":"#fff","fontSize":"30px"}'>社团信息展示</span>
	</div>
	
	
	
	
	
	
	
	
	
	


	<div v-if="shetuanxinxiList.length" class="list list11 index-pv1" :style='{"width":"65%","margin":"0 auto","display":"flex","height":"auto"}'>
	  <div class="tab" :style='{"padding":"15px 15px 15px 15px","margin":"0 20px 0 0","flexDirection":"column","background":"#005FBA","display":"flex","width":"200px","position":"relative","justifyContent":"center","height":"auto"}'>
		<template v-for="item,index in listList11shetuanxinxi">
	    <div v-if="index < 6" :style='{"cursor":"pointer","padding":"0 20px","margin":"0","borderColor":"#fff","borderWidth":"10px","background":"#005FBA","width":"100%","position":"relative","borderStyle":"solid","height":"60px","order":"1"}' class="item" @click="listIndexClick11(item, 'shetuanxinxi')">
	      <span class="icon iconfont icon-jinru" :style='{"margin":"0 5px 0 0","lineHeight":"40px","fontSize":"16px","position":"absolute","right":"0","color":"#fff"}'></span>
	      <img v-if="item.image" :style='{"width":"20px","margin":"0 5px 0 0","objectFit":"cover","display":"inline-block","height":"20px"}' :src="baseUrl + (item.image?item.image.split(',')[0]:'')">
		  <span :style='{"color":"#fff","lineHeight":"40px","fontSize":"16px"}'>{{item[listColumn11shetuanxinxi]}}</span>
	    </div>
		</template>
		<div :style='{"cursor":"pointer","padding":"0","margin":"0px 0 0 35px","borderColor":"#efefef","textAlign":"center","borderWidth":"0","width":"100px","borderStyle":"solid","height":"50px"}' class="more" @click="moreBtn('shetuanxinxi')">
		  <span class="icon iconfont " :style='{"margin":"0 5px 0 0","fontSize":"16px","lineHeight":"0","color":"#333","display":"none"}'></span>
		  <div :style='{"color":"#fff","fontSize":"24px","lineHeight":"50px"}'>更多</div>
		</div>
	  </div>
	  <div class="list" :style='{"flexWrap":"wrap","flex":"1","display":"flex","height":"auto"}'>
	    <div :style='{"margin":"10px 1%","overflow":"hidden","borderRadius":"10px","background":"#fff","width":"31%","position":"relative","height":"auto"}' class="item list-item animation-box" v-for="item,index in shetuanxinxiList" :key="index" @click="toDetail('shetuanxinxiDetail', item)">
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","display":"block","height":"180px"}' v-if="preHttp(item.tupian)" :src="item.tupian.split(',')[0]" alt="" />
			<img :name="item.id" :style='{"width":"100%","objectFit":"cover","display":"block","height":"180px"}' v-else :src="baseUrl + (item.tupian?item.tupian.split(',')[0]:'')" alt="" />
			<div class="line1" :style='{"padding":"0 10px","overflow":"hidden","color":"#9E9E9E","textAlign":"center","lineHeight":"60px","fontSize":"18px","height":"60px"}'>{{item.shetuanmingcheng}}</div>
			<div class="line1" :style='{"padding":"0 10px","overflow":"hidden","color":"#9E9E9E","textAlign":"center","lineHeight":"60px","fontSize":"18px","height":"60px"}'>入团状态:{{item.rutuanzhuangtai}}</div>
	    </div>
	  </div>
	</div>




	
	
	<div @click="moreBtn('shetuanxinxi')" :style='{"border":"0","margin":"10px auto","borderRadius":"20px","top":"80px","textAlign":"center","background":"#005FBA","display":"block","width":"120px","lineHeight":"40px","position":"absolute","right":"20%"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"12px"}'>更多</span>
		<i :style='{"color":"#f5f5f5","fontSize":"12px"}' class="icon iconfont icon-gengduo1"></i>
	</div>
	

</div>
<!-- 特价商品 -->
	
</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        systemIntroductionDetail: {},
        queryList:[
          {
              queryName:"社团名称",
          },
        ],
        queryIndex: 0,
        shetuanxinxishetuanmingcheng: '',
        newsList: [],
        shetuanxinxiRecommend: [],
        shetuanhuodongRecommend: [],

        shetuanList: [],
        shetuanxinxiList: [],



		listIndex11shetuanxinxi: 0,
		listList11shetuanxinxi: [],
		listColumn11shetuanxinxi: '',

      }
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.getNewsList();
		this.getAboutUs();
		this.getSystemIntroduction();
		this.getList();
		this.shetuanxinxiListCate()
    },
	mounted() {
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
		
		this.swiperChanges()
	},
	beforeDestroy() {
	  window.removeEventListener('scroll', this.handleScroll)
	},
    //方法集合
    methods: {
		swiperChanges() {












































































			setTimeout(()=>{






































			},250)
		},

		shetuanxinxiListCate(){
			this.$http.get('shetuanleixing/list',{}).then(res => {
			  if (res.data.code == 0) {
				this.listList11shetuanxinxi = res.data.data.list
			  }
			});
			this.listColumn11shetuanxinxi = 'shetuanleixing'
		},
		listIndexClick11(index, name) {
			this['listIndex11' + name] = index[this['listColumn11' + name]]
			this.getList()
		},

		handleScroll() {
			let arr = [
				{id:'search',css:'animate__bounce'},
				{id:'about',css:'animate__lightSpeedInLeft'},
				{id:'system',css:'animate__flipInY'},
				{id:'animate_listshetuan',css:'animate__rotateIn'},
				{id:'animate_recommendshetuanxinxi',css:'animate__zoomInUp'},
				{id:'animate_listshetuanxinxi',css:'animate__rotateIn'},
				{id:'animate_recommendshetuanhuodong',css:'animate__zoomInUp'},
				{id:'animate_newsnews',css:'animate__jackInTheBox'},
				{id:'msgs',css:'animate__lightSpeedInRight'},
				{id:'friendly',css:'animate__lightSpeedInLeft'}
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getAboutUs() {
          this.$http.get('aboutus/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.aboutUsDetail = res.data.data;
            }
          })
      },
      getSystemIntroduction() {
          this.$http.get('systemintro/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.systemIntroductionDetail = res.data.data;
            }
          })
      },
      search(tablename) {
        if (this.queryIndex == 0 && this.shetuanxinxishetuanmingcheng) {
          this.$router.push({path: '/index/' + tablename, query: {indexQueryCondition: this.shetuanxinxishetuanmingcheng}});
        }
      },
		getNewsList() {
			let data = {
				page: 1,
				limit: 18,
                sort: 'addtime',
				order: 'desc'
			}
			this.$http.get('news/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
			let autoSortUrl = "";
			let data = {}
          autoSortUrl = "shetuanxinxi/autoSort";
          if(localStorage.getItem('Token')) {
              autoSortUrl = "shetuanxinxi/autoSort2";
          }
			data = {
				page: 1,
				limit: 6,
			}
			data['sfsh'] = '是'
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.shetuanxinxiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "shetuanhuodong/autoSort";
			data = {
				page: 1,
				limit: 6,
			}
			data['sfsh'] = '是'
			this.$http.get(autoSortUrl, {params: data}).then(res => {
				if (res.data.code == 0) {
					this.shetuanhuodongRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			data = {
				page: 1,
				limit: 6,
			}
			data['sfsh']= '是'
			this.$http.get('shetuan/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.shetuanList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
			data = {
				page: 1,
				limit: 6,
			}
			data['sfsh']= '是'
			if(this.listIndex11shetuanxinxi){
				data.shetuanleixing = this.listIndex11shetuanxinxi
			}
			this.$http.get('shetuanxinxi/list', {params: data}).then(res => {
				if (res.data.code == 0) {
					this.shetuanxinxiList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {id: item.id}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		// -------- search --------
		.search .select /deep/ .el-input__inner {
			border: 0;
			border-radius: 4px;
			padding: 0 30px 0 10px;
			box-shadow: 0 0 6px rgba(64, 158, 255, .3);
			outline: none;
			color: rgba(64, 158, 255, 1);
			width: 180px;
			font-size: 14px;
			height: 44px;
		}
		
		.search .input /deep/ .el-input__inner {
			border: 0;
			border-radius: 4px;
			padding: 0 10px;
			box-shadow: 0 0 6px rgba(64, 158, 255, .3);
			outline: none;
			color: rgba(64, 158, 255, 1);
			width: 180px;
			font-size: 14px;
			height: 44px;
		}
		// -------- search --------
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1.1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 10px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
	








	.home-preview .recommend .list17 .item .image {
				object-fit: cover;
				display: block;
				width: 100%;
				transition: 0.3s;
				height: 100%;
			}

	.home-preview .recommend .list17 .item:hover .image {
				transform: scale(1.1);
			}
	
	.home-preview .recommend .list17 .item .content {
				padding: 10px;
				overflow: hidden;
				flex-direction: column;
				left: 0;
				bottom: -100%;
				background: rgba(5,45,83,0.9);
				display: flex;
				width: 100%;
				position: absolute;
				transition: 0.3s;
				height: 50%;
			}
	
	.home-preview .recommend .list17 .item:hover .content {
				bottom: 0;
			}


</style>
