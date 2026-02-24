import '@/assets/styles/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from '@/app/router/index'
import '@/assets/styles/global.css' 

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core'

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

import {
  faPhone,
  faMobile,
  faShareNodes,
  faLocationDot,
  faListCheck,
  faCircleInfo
} from '@fortawesome/free-solid-svg-icons';

library.add(  faPhone,
  faMobile,
  faShareNodes,
  faLocationDot,
  faListCheck,
  faCircleInfo)

const app = createApp(App)

app.component('font-awesome-icon', FontAwesomeIcon)

app.use(createPinia())
app.use(router)

app.mount('#app')
