import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shetuanList from '../pages/shetuan/list'
import shetuanDetail from '../pages/shetuan/detail'
import shetuanAdd from '../pages/shetuan/add'
import shetuanleixingList from '../pages/shetuanleixing/list'
import shetuanleixingDetail from '../pages/shetuanleixing/detail'
import shetuanleixingAdd from '../pages/shetuanleixing/add'
import shetuanxinxiList from '../pages/shetuanxinxi/list'
import shetuanxinxiDetail from '../pages/shetuanxinxi/detail'
import shetuanxinxiAdd from '../pages/shetuanxinxi/add'
import shetuanjiaruList from '../pages/shetuanjiaru/list'
import shetuanjiaruDetail from '../pages/shetuanjiaru/detail'
import shetuanjiaruAdd from '../pages/shetuanjiaru/add'
import tuichushetuanList from '../pages/tuichushetuan/list'
import tuichushetuanDetail from '../pages/tuichushetuan/detail'
import tuichushetuanAdd from '../pages/tuichushetuan/add'
import shetuanhuodongList from '../pages/shetuanhuodong/list'
import shetuanhuodongDetail from '../pages/shetuanhuodong/detail'
import shetuanhuodongAdd from '../pages/shetuanhuodong/add'
import huodongbaomingList from '../pages/huodongbaoming/list'
import huodongbaomingDetail from '../pages/huodongbaoming/detail'
import huodongbaomingAdd from '../pages/huodongbaoming/add'
import shetuanxinwenList from '../pages/shetuanxinwen/list'
import shetuanxinwenDetail from '../pages/shetuanxinwen/detail'
import shetuanxinwenAdd from '../pages/shetuanxinwen/add'
import shetuancaiwuList from '../pages/shetuancaiwu/list'
import shetuancaiwuDetail from '../pages/shetuancaiwu/detail'
import shetuancaiwuAdd from '../pages/shetuancaiwu/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussshetuanxinxiList from '../pages/discussshetuanxinxi/list'
import discussshetuanxinxiDetail from '../pages/discussshetuanxinxi/detail'
import discussshetuanxinxiAdd from '../pages/discussshetuanxinxi/add'
import discussshetuanxinwenList from '../pages/discussshetuanxinwen/list'
import discussshetuanxinwenDetail from '../pages/discussshetuanxinwen/detail'
import discussshetuanxinwenAdd from '../pages/discussshetuanxinwen/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shetuan',
					component: shetuanList
				},
				{
					path: 'shetuanDetail',
					component: shetuanDetail
				},
				{
					path: 'shetuanAdd',
					component: shetuanAdd
				},
				{
					path: 'shetuanleixing',
					component: shetuanleixingList
				},
				{
					path: 'shetuanleixingDetail',
					component: shetuanleixingDetail
				},
				{
					path: 'shetuanleixingAdd',
					component: shetuanleixingAdd
				},
				{
					path: 'shetuanxinxi',
					component: shetuanxinxiList
				},
				{
					path: 'shetuanxinxiDetail',
					component: shetuanxinxiDetail
				},
				{
					path: 'shetuanxinxiAdd',
					component: shetuanxinxiAdd
				},
				{
					path: 'shetuanjiaru',
					component: shetuanjiaruList
				},
				{
					path: 'shetuanjiaruDetail',
					component: shetuanjiaruDetail
				},
				{
					path: 'shetuanjiaruAdd',
					component: shetuanjiaruAdd
				},
				{
					path: 'tuichushetuan',
					component: tuichushetuanList
				},
				{
					path: 'tuichushetuanDetail',
					component: tuichushetuanDetail
				},
				{
					path: 'tuichushetuanAdd',
					component: tuichushetuanAdd
				},
				{
					path: 'shetuanhuodong',
					component: shetuanhuodongList
				},
				{
					path: 'shetuanhuodongDetail',
					component: shetuanhuodongDetail
				},
				{
					path: 'shetuanhuodongAdd',
					component: shetuanhuodongAdd
				},
				{
					path: 'huodongbaoming',
					component: huodongbaomingList
				},
				{
					path: 'huodongbaomingDetail',
					component: huodongbaomingDetail
				},
				{
					path: 'huodongbaomingAdd',
					component: huodongbaomingAdd
				},
				{
					path: 'shetuanxinwen',
					component: shetuanxinwenList
				},
				{
					path: 'shetuanxinwenDetail',
					component: shetuanxinwenDetail
				},
				{
					path: 'shetuanxinwenAdd',
					component: shetuanxinwenAdd
				},
				{
					path: 'shetuancaiwu',
					component: shetuancaiwuList
				},
				{
					path: 'shetuancaiwuDetail',
					component: shetuancaiwuDetail
				},
				{
					path: 'shetuancaiwuAdd',
					component: shetuancaiwuAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discussshetuanxinxi',
					component: discussshetuanxinxiList
				},
				{
					path: 'discussshetuanxinxiDetail',
					component: discussshetuanxinxiDetail
				},
				{
					path: 'discussshetuanxinxiAdd',
					component: discussshetuanxinxiAdd
				},
				{
					path: 'discussshetuanxinwen',
					component: discussshetuanxinwenList
				},
				{
					path: 'discussshetuanxinwenDetail',
					component: discussshetuanxinwenDetail
				},
				{
					path: 'discussshetuanxinwenAdd',
					component: discussshetuanxinwenAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
