<script>
import NavComp from './components/NavComp.vue'
import HomeView from './views/HomeView.vue';
import KitchenView from './views/KitchenView.vue'
import WarehouseView from './views/WarehouseView.vue';

const routes = {
  '/': HomeView,
  '/kitchen': KitchenView,
  '/warehouse': WarehouseView
}

export default {
  name: 'App',
  components: {
    NavComp,
    HomeView,
    KitchenView,
    WarehouseView
  },
  data() {
    return {
      currentPath: window.location.hash
    }
  },
  computed: {
    currentView() {
      return routes[this.currentPath.slice(1) || '/'] || NotFound
    }
  },
  mounted() {
    window.addEventListener('hashchange', () => {
		  this.currentPath = window.location.hash
		})
  }
}


</script>

<template>
  <body>
<NavComp/>
  <router-view/>
  <component :is="currentView" />
  </body>
</template>

