import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import('@/features/Auth/views/loginView.vue'),
    },
    {
      path: '/GestionPanel',
      name: 'GestionPanel',
      component: () => import('@/features/Centers/views/gestionPanelView.vue'),
    },
    {
      path: '/CreateCenter',
      name: 'CreateCenter',
      component: () => import('@/features/Centers/views/NewCenterView.vue'),
    },
    {
      path: '/Register',
      name: 'Register',
      component: () => import('@/features/Auth/views/registerView.vue'),
    },
    {
      path: '/center/:id',
      name: 'InfoCenter',
      component: () => import('@/features/Centers/views/infoCenterView.vue'),
    },
    {
      path: '/:pathMatch(.*)*',
      redirect: '/login'
    }
  ],
})

export default router
