import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import('@/presentation/views/loginView.vue'),
    },
    {
      path: '/GestionPanel',
      name: 'GestionPanel',
      component: () => import('@/presentation/views/gestionPanelView.vue'),
    },
    {
      path: '/CreateCenter',
      name: 'CreateCenter',
      component: () => import('@/presentation/views/NewCenterView.vue'),
    },
    {
      path: '/Register',
      name: 'Register',
      component: () => import('@/presentation/views/registerView.vue'),
    },
    {
      path: '/center/:id',
      name: 'InfoCenter',
      component: () => import('@/presentation/views/infoCenterView.vue'),
    },
    {
      path: '/test',
      name: 'test',
      component: () => import('@/presentation/views/componentsTestView.vue'),
    },
    {
      path: '/:pathMatch(.*)*',
      redirect: '/login'
    }
  ],
})

export default router
