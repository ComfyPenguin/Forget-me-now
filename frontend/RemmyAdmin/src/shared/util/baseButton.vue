<template>
    <button
        :class="[
            'px-6 py-3 rounded-lg font-semibold transition-all duration-200 ease-out',
            animationEnabled ? 'shadow-md hover:shadow-lg' : 'shadow-md',
            animationEnabled ? 'transform hover:-translate-y-0.5 active:translate-y-0.5' : '',
            'focus:outline-none focus:ring-4 focus:ring-offset-2',
            'disabled:opacity-50 disabled:cursor-not-allowed disabled:hover:shadow-md disabled:hover:translate-y-0',
            variantClasses,
        ]"
        :disabled="disabled"
        @click="handleClick"
    >
        <slot>{{ label }}</slot>
    </button>
</template>

<script setup lang="ts">
import { computed } from 'vue';

const props = defineProps<{
    label?: string;
    variant?: 'primary' | 'secondary' | 'danger';
    disabled?: boolean;
    animationEnabled?: boolean;
}>();

const emit = defineEmits<{
    click: [];
}>();

const animationEnabled = computed(() => props.animationEnabled !== false);

const variantClasses = computed(() => {
    const variant = props.variant || 'primary';
    
    switch (variant) {
        case 'primary':
            return 'bg-blue-600 hover:bg-blue-700 text-white focus:ring-blue-500';
        case 'secondary':
            return 'bg-gray-200 hover:bg-gray-300 text-gray-800 focus:ring-gray-400 border border-gray-300';
        case 'danger':
            return 'bg-red-600 hover:bg-red-700 text-white focus:ring-red-500';
        default:
            return 'bg-blue-600 hover:bg-blue-700 text-white focus:ring-blue-500';
    }
});

const handleClick = () => {
    emit('click');
};
</script>