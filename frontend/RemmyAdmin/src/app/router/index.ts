import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // AUTH
    {
      path: '/login',
      name: 'login',
      component: () => import('@/features/Auth/views/loginView.vue'),
    },
    {
      path: '/Register',
      name: 'Register',
      component: () => import('@/features/Auth/views/registerView.vue'),
    },

    // SideBar
    {
      path: '/',
      component: () => import('@/app/layouts/appLayout.vue'),
      children: [
        {
          path: 'GestionPanel',
          name: 'GestionPanel',
          component: () => import('@/features/Centers/views/gestionPanelView.vue'),
        },
        {
          path: 'CreateCenter',
          name: 'CreateCenter',
          component: () => import('@/features/Centers/views/NewCenterView.vue'),
        },
        {
          path: 'center/:id',
          name: 'InfoCenter',
          component: () => import('@/features/Centers/views/infoCenterView.vue'),
        }
      ]
    },
  ],
})

export default router
