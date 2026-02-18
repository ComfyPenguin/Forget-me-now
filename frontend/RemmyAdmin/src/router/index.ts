import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '@/views/loginView.vue'
import GestionPanelView from '@/views/gestionPanelView.vue'
import NewCenterView from '@/views/NewCenterView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: LoginView,
    },
    {
      path: '/GestionPanel',
      name: 'GestionPanel',
      component: GestionPanelView,
    },
    {
      path: '/CreateCenter',
      name: 'CreateCenter',
      component: NewCenterView,
    },
    {
      path: '/:pathMatch(.*)*',
      redirect: '/login'
    }
  ],
})

export default router
