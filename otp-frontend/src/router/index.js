import Vue from 'vue'
import Router from 'vue-router'
import App from '@/App'
import Home from '@business/home'
import Login from '@user/login'
import Register from '@user/register'
import Uhome from '@user/uhome'
import PersonInfo from '@user/personInfo'
import UserInfo from '@user/userInfo'
import AddressInfo from '@user/address'
import SafeInfo from '@user/userSafe'
import GoodHome from '@product/goodHome'
import GoodList from '@product/goodList'
import GoodDetail from '@product/goodDetail'
import AdminHome from '@admin/adminHome'
import Category from '@admin/category'
import Product from '@admin/product'
Vue.use(Router)
export default new Router({
  mode: 'history',
  routes: [
    {
      path:'/otp',
      // redirect: '/',
      component: App,
    },
    {
      path:'/',
      redirect: '/home'
    },
    
    {
      path: '/home',
      name: 'Home',
      component: Home,
      redirect: '/home/good-home',
      children: [
        {
          path: '/home/good-home',
          name: 'goodHome',
          component: GoodHome
        },
        {
          path: '/home/good-list',
          name: 'goodList',
          component: GoodList
        },
        {
          path: '/home/good-detail',
          name: 'goodDetail',
          component: GoodDetail
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: Login,

    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/uhome',
      name: 'uhome',
      component: Uhome,
      redirect: '/uhome/person-info',
      children: [
        {
          path: '/uhome/person-info',
          name: 'personInfo',
          component: PersonInfo
        },
        {
          path: '/uhome/user-info',
          name: 'userInfo',
          component: UserInfo
        },
        {
          path: '/uhome/address-info',
          name: 'addressInfo',
          component: AddressInfo
        },
        {
          path: '/uhome/safe-info',
          name: 'safeInfo',
          component: SafeInfo
        }
      ]
    },
    {
      path:'/admin',
      name: 'administrate',
      component: AdminHome,
      redirect:"/admin/category",
      children: [
        {
          path: '/admin/category',
          name: 'category',
          component: Category
        },
        {
          path: '/admin/product',
          name: 'product',
          component: Product
        }
      ]
    },
  ]
})
