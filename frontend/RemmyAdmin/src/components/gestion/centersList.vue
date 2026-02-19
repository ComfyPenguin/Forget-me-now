<template>
  <div div class="centers-list-wraper">
    <table>
      <thead class="thead-style extra-bold">
        <tr class="exo-font ">
          <th>Centro</th>
          <th>Ubicación</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="center in pagedCenters" :key="center.id">
          <td>{{ center.name }}</td>
          <td>{{ center.location }}</td>
          <td>
            <button class="action-btn" @click="editCenter(center.id)" aria-label="Editar centro">
              <svg class="action-icon" viewBox="0 0 24 24" aria-hidden="true">
                <path d="M3 17.25V21h3.75L17.8 9.94l-3.75-3.75L3 17.25Zm14.7-9.45a1 1 0 0 0 0-1.41l-1.59-1.59a1 1 0 0 0-1.41 0l-1.5 1.5 3.75 3.75 1.5-1.5Z"/>
              </svg>
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  <!-- Paginación de la tabla -->
  <div class='flex items-space justify-between mt-4 navbar'>
    <div class='navbar-text'>
      <p>Mostrando <strong>{{ showingEntries }}</strong> centros </p>
    </div>
    <div class="navbuttons-wrapper top-4">
    <button class="navbutton" @click="prevPage" :disabled="currentPage === 1">Anterior</button>
    <span>
      <button
        v-for="page in visiblePages"
        :key="page"
        @click="currentPage = page"
        :class="['navbutton', { active: currentPage === page }]"
      >
        {{ page }}
      </button>
    </span>
    <button class="navbutton" @click="nextPage" :disabled="currentPage === totalPages">Siguiente</button>
    </div>
  </div>
  </div>
</template>

<script setup lang="ts">
import { ref , computed} from 'vue'

class Center {
  constructor(
    public id: number,
    public name: string,
    public location: string
  ) {}
}

const centers = ref<Center[]>([
  new Center(1, 'Center A', 'Location A'),
  new Center(2, 'Center B', 'Location B'),
  new Center(3, 'Center C', 'Location C'),
  new Center(4, 'Center D', 'Location D'),
  new Center(5, 'Center E', 'Location E'),
  new Center(6, 'Center F', 'Location F'),
  new Center(7, 'Center G', 'Location G'),
  new Center(8, 'Center H', 'Location H'),
  new Center(9, 'Center I', 'Location I'),
  new Center(10, 'Center J', 'Location J'),
]);

const currentPage = ref(1);
const rowsPerPage = 3;
const totalPages = computed(() => Math.ceil(centers.value.length / rowsPerPage));
const visiblePages = computed(() => {
  const total = totalPages.value;
  if (total <= 3) return Array.from({ length: total }, (_, i) => i + 1);
  const start = Math.min(Math.max(currentPage.value - 1, 1), total - 2);
  return [start, start + 1, start + 2];
});

const showingEntries = computed(() => {
  return `${pagedCenters.value.length} de ${centers.value.length}`;
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
@import url('https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@0,100..900;1,100..900&display=swap');

.centers-list-wraper {
  border: 1px solid var(--neutral-light);
  border-radius: 8px;
  background-color: var(--background);
  overflow: hidden;
  overflow-x: auto;
}

.exo-font {
  font-family: 'Exo 2', sans-serif;
  font-weight: 800;

}

th, td {
  text-align: left;
  border-top: var(--neutral-light) 0.25px solid;
  padding: 12px 16px;
  padding: 8px;
}

table {
  margin: 0;
  width: 100%;
  border-collapse: collapse;
}

.thead-style {
  font-family: Exo 2, sans-serif;
  background-color: var(--neutral-light);
  font-weight: 600;
  color: var(--neutral-dark);

}

.navbar{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  padding: 0.75rem 1rem;
  margin-top: 0;
  background-color: var(--background-alt);
}

.navbar-text {
  font-family: Exo 2, sans-serif;
  font-weight: 500;
  color: var(--neutral-dark);
  text-align: left;
}

.navbuttons-wrapper {
  display: flex;
  justify-content: flex-end;
}

.navbutton.active {
  background: var(--primary);
  color: var(--background);
  border-color: var(--primary);
}

.navbutton:hover:not(:disabled) {
  background: var(--primary);
  color: var(--background);
  border-color: var(--primary);
}

.navbutton {
  background: transparent;
  color: var(--neutral-dark);
  border: 1px solid var(--neutral);
  border-radius: 8px;
  padding: 0.5rem 1rem;
  margin: 0 0.25rem;
  cursor: pointer;
  transition: background-color 0.2s, color 0.2s, border-color 0.2s;
}

.navbutton:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}

.action-btn {
  background: transparent;
  border: 1px solid var(--neutral);
  color: var(--neutral);
  border-radius: 8px;
  padding: 0.35rem 0.5rem;
  cursor: pointer;
  display: inline-flex;
  align-items: center;
  justify-content: center;
}

.action-btn:hover {
  border-color: var(--neutral-dark);
  color: var(--neutral-dark);
}

.action-icon {
  width: 18px;
  height: 18px;
  fill: currentColor;
}
</style>
