import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { fas } from '@fortawesome/free-solid-svg-icons'

import '@/assets/bootstrap.min.css'
import '@/assets/bootstrap.bundle.min.js'

library.add(fas)
createApp(App)
.component('font-awesome-icon', FontAwesomeIcon,router)
.mount('#app')
