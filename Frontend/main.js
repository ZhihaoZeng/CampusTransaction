import Vue from 'vue'
import App from './App'
import store from './store/index.js'
import api from '@/utils/api.js'
import mpopup from '@/components/xuan-popup/xuan-popup.vue'
import loading from '@/components/basics/loading.vue'

// const http = new Request()

Vue.config.productionTip = false
Vue.component('mpopup',mpopup)
Vue.component('loading',loading)

Vue.prototype.$store = store
Vue.prototype.$api = api

App.mpType = 'app'

const app = new Vue({
	store,
	...App
})
app.$mount()
