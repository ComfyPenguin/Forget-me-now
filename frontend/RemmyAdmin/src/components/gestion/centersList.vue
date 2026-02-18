<template>
  <div class="overflow-x-auto mx-auto max-w-5xl">
  <table class="min-w-full divide-y divide-gray-200 dark:divide-gray-700 bg-white dark:bg-gray-800 shadow-sm rounded-xl overflow-hidden">
    <thead class="bg-gray-50 dark:bg-gray-700">
      <tr>
        <th scope="col" class="px-6 py-4 text-left text-sm font-semibold text-gray-900 dark:text-gray-100 uppercase tracking-wider">
          Center Name
        </th>
        <th scope="col" class="px-6 py-4 text-left text-sm font-semibold text-gray-900 dark:text-gray-100 uppercase tracking-wider">
          Location
        </th>
        <th scope="col" class="px-6 py-4 text-left text-sm font-semibold text-gray-900 dark:text-gray-100 uppercase tracking-wider">
          Actions
        </th>
      </tr>
    </thead>
    <tbody class="divide-y divide-gray-200 dark:divide-gray-700 bg-white dark:bg-gray-800">
      <tr
        v-for="center in centers"
        :key="center.id"
        class="hover:bg-gray-50 dark:hover:bg-gray-700/50 transition-colors duration-150"
      >
        <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900 dark:text-gray-100">
          {{ center.name }}
        </td>
        <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500 dark:text-gray-400">
          {{ center.location }}
        </td>
        <td class="px-6 py-4 whitespace-nowrap text-sm font-medium">
          <!-- Descomenta cuando lo necesites -->
          <!--
          <button
            @click="editCenter(center.id)"
            class="text-indigo-600 dark:text-indigo-400 hover:text-indigo-900 dark:hover:text-indigo-300 mr-4 transition"
          >
            Edit
          </button>
          <button
            @click="deleteCenter(center.id)"
            class="text-red-600 dark:text-red-400 hover:text-red-900 dark:hover:text-red-300 transition"
          >
            Delete
          </button>
          -->
          <span class="text-gray-400 dark:text-gray-500 italic">Actions coming soon</span>
        </td>
      </tr>
    </tbody>
  </table>

  <!-- Mensaje si no hay datos -->
  <div v-if="!centers?.length" class="text-center py-12 text-gray-500 dark:text-gray-400">
    No centers found.
  </div>
</div>
</template>

<script setup lang="ts">

const centers = [
  { id: 1, name: 'Center A', location: 'Location A' },
  { id: 2, name: 'Center B', location: 'Location B' },
  { id: 3, name: 'Center C', location: 'Location C' },
];

</script>
