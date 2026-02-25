<template>
  <div class="w-full bg-white rounded-xl shadow-sm border border-slate-200 overflow-hidden flex flex-col h-full">
    <div class="overflow-x-auto flex-1">
      <table class="w-full text-left border-collapse whitespace-nowrap">
        <thead>
          <tr class="bg-slate-50 border-b border-slate-200 text-slate-500 text-xs uppercase tracking-wider font-bold">
            <th class="py-4 px-6">Centro</th>
            <th class="py-4 px-6">Ubicación</th>
            <th class="py-4 px-6 text-center">Acciones</th>
          </tr>
        </thead>
        <tbody class="divide-y divide-slate-100 text-slate-800">
          <tr v-for="center in pagedCenters" :key="center.id" class="hover:bg-blue-50/40 transition-colors group">
            <td class="py-4 px-6">
              <span class="font-bold text-slate-900 text-[15px] block">{{ center.name }}</span>
            </td>
            <td class="py-4 px-6 text-slate-500 font-medium text-[14px]">
              <div class="flex items-center">
                <svg class="w-4 h-4 text-slate-400 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z"></path>
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 11a3 3 0 11-6 0 3 3 0 016 0z"></path>
                </svg>
                {{ center.location }}
              </div>
            </td>
            <td class="py-4 px-6 text-center">
              <button 
                class="inline-flex items-center justify-center p-2 text-slate-400 hover:text-blue-600 hover:bg-blue-100/50 rounded-lg transition-all border border-transparent hover:border-blue-200" 
                @click="editCenter(center.id)" 
                aria-label="Editar centro"
              >
                <svg class="w-[18px] h-[18px]" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z"/>
                </svg>
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- Paginación de la tabla -->
    <div class="flex items-center justify-between px-6 py-[18px] bg-slate-50/50 border-t border-slate-200 mt-auto">
      <div class="text-[13px] text-slate-500">
        Mostrando <span class="font-bold text-slate-700">{{ showingEntries }}</span> centros
      </div>
      <div class="flex items-center space-x-2">
        <button 
          @click="prevPage" 
          :disabled="currentPage === 1"
          class="px-3.5 py-1.5 text-[13px] font-medium rounded-lg text-slate-600 bg-white border border-slate-200 hover:bg-slate-50 hover:text-slate-900 focus:z-10 focus:ring-2 focus:ring-blue-100 disabled:opacity-50 disabled:cursor-not-allowed transition-all"
        >
          Anterior
        </button>
        <div class="flex items-center space-x-1">
          <button
            v-for="page in visiblePages"
            :key="page"
            @click="currentPage = page"
            :class="[
              'w-[30px] h-[30px] flex items-center justify-center text-[13px] font-medium rounded-lg transition-all',
              currentPage === page 
                ? 'bg-blue-600 text-white shadow-md shadow-blue-500/20 border border-blue-600' 
                : 'text-slate-600 border border-slate-200 bg-white hover:bg-slate-50'
            ]"
          >
            {{ page }}
          </button>
        </div>
        <button 
          @click="nextPage" 
          :disabled="currentPage === totalPages"
          class="px-3.5 py-1.5 text-[13px] font-medium rounded-lg text-slate-600 bg-white border border-slate-200 hover:bg-slate-50 hover:text-slate-900 focus:z-10 focus:ring-2 focus:ring-blue-100 disabled:opacity-50 disabled:cursor-not-allowed transition-all"
        >
          Siguiente
        </button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'

class Center {
  constructor(
    public id: number,
    public name: string,
    public location: string
  ) {}
}

const centers = ref<Center[]>([
  new Center(1, 'Centro Esperanza', 'Madrid, ES'),
  new Center(2, 'Refugio San José', 'Barcelona, ES'),
  new Center(3, 'Apoyo Comunitario', 'Sevilla, ES'),
  new Center(4, 'Auxilio Temporal', 'Valencia, ES'),
  new Center(5, 'Casa de la Paz', 'Zaragoza, ES'),
  new Center(6, 'Esperanza Norte', 'Bilbao, ES'),
  new Center(7, 'Centro Solidario', 'Málaga, ES'),
  new Center(8, 'Refugio del Sol', 'Murcia, ES'),
  new Center(9, 'Mano Amiga', 'Palma, ES'),
  new Center(10, 'Luz y Esperanza', 'Las Palmas, ES'),
  new Center(11, 'Centro de Acogida', 'Alicante, ES'),
  new Center(12, 'Ayuda Pronta', 'Córdoba, ES'),
  new Center(13, 'Corazón Abierto', 'Valladolid, ES'),
  new Center(14, 'Centro de Ayuda Global', 'Vigo, ES'),
]);

const currentPage = ref(1);
const rowsPerPage = 6;
const totalPages = computed(() => Math.ceil(centers.value.length / rowsPerPage));
const visiblePages = computed(() => {
  const total = totalPages.value;
  if (total <= 3) return Array.from({ length: total }, (_, i) => i + 1);
  const start = Math.min(Math.max(currentPage.value - 1, 1), total - 2);
  return [start, start + 1, start + 2];
});

const showingEntries = computed(() => {
  const startEntry = (currentPage.value - 1) * rowsPerPage + 1;
  const endEntry = Math.min(currentPage.value * rowsPerPage, centers.value.length);
  return `${startEntry}-${endEntry} de ${centers.value.length}`;
});

const pagedCenters = computed(() => {
  const start = (currentPage.value - 1) * rowsPerPage;
  return centers.value.slice(start, start + rowsPerPage);
});

// Pagination methods
function prevPage() {
  if (currentPage.value > 1) currentPage.value--;
}
function nextPage() {
  if (currentPage.value < totalPages.value) currentPage.value++;
}

// Actions
function editCenter(id: number) {
  // TODO: route to edit page using center id
  console.info(`Edit center with id: ${id}`);
}
</script>

<style scoped>
/* No CSS needed, fully styled with Tailwind CSS */
</style>