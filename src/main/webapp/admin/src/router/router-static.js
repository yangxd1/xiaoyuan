import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import discussshetuanxinwen from '@/views/modules/discussshetuanxinwen/list'
    import aboutus from '@/views/modules/aboutus/list'
    import shetuanhuodong from '@/views/modules/shetuanhuodong/list'
    import shetuancaiwu from '@/views/modules/shetuancaiwu/list'
    import discussshetuanxinxi from '@/views/modules/discussshetuanxinxi/list'
    import shetuanxinxi from '@/views/modules/shetuanxinxi/list'
    import users from '@/views/modules/users/list'
    import forum from '@/views/modules/forum/list'
    import shetuanleixing from '@/views/modules/shetuanleixing/list'
    import shetuanxinwen from '@/views/modules/shetuanxinwen/list'
    import tuichushetuan from '@/views/modules/tuichushetuan/list'
    import shetuan from '@/views/modules/shetuan/list'
    import shetuanjiaru from '@/views/modules/shetuanjiaru/list'
    import systemintro from '@/views/modules/systemintro/list'
    import yonghu from '@/views/modules/yonghu/list'
    import huodongbaoming from '@/views/modules/huodongbaoming/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/discussshetuanxinwen',
        name: '社团新闻评论',
        component: discussshetuanxinwen
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/shetuanhuodong',
        name: '社团活动',
        component: shetuanhuodong
      }
      ,{
	path: '/shetuancaiwu',
        name: '社团财务',
        component: shetuancaiwu
      }
      ,{
	path: '/discussshetuanxinxi',
        name: '社团信息评论',
        component: discussshetuanxinxi
      }
      ,{
	path: '/shetuanxinxi',
        name: '社团信息',
        component: shetuanxinxi
      }
      ,{
	path: '/users',
        name: '管理员',
        component: users
      }
      ,{
	path: '/forum',
        name: '留言交流',
        component: forum
      }
      ,{
	path: '/shetuanleixing',
        name: '社团类型',
        component: shetuanleixing
      }
      ,{
	path: '/shetuanxinwen',
        name: '社团新闻',
        component: shetuanxinwen
      }
      ,{
	path: '/tuichushetuan',
        name: '退出社团',
        component: tuichushetuan
      }
      ,{
	path: '/shetuan',
        name: '社团',
        component: shetuan
      }
      ,{
	path: '/shetuanjiaru',
        name: '社团加入',
        component: shetuanjiaru
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/huodongbaoming',
        name: '活动报名',
        component: huodongbaoming
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '公告信息分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
