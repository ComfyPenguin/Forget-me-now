import '@/assets/styles/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from '@/app/router/index'
import '@/assets/styles/global.css' 

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')
