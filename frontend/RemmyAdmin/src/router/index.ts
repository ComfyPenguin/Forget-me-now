import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/loginView.vue'
import GestionPanelView from '@/views/gestionPanelView.vue'
import NewCenterView from '@/views/NewCenterView.vue'
import RegisterView from '@/views/registerView.vue'
import ComponentsTestView from '@/views/componentsTestView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component:LoginView,
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
      path: '/Register',
      name: 'Register',
      component: RegisterView,
    },
    {
      path: '/test',
      name: 'test',
      component: ComponentsTestView,
    },
    {
      path: '/:pathMatch(.*)*',
      redirect: '/login'
    }
  ],
})

export default router
