<script>
import RecipeTableComp from '../components/RecipeTableComp.vue';
import axios from "axios";

export default {
  name: 'App',
  components: {
    RecipeTableComp
  },
methods: {
    async orderDish() {
      try {
        const response = await axios.post("http://localhost:8001/kitchen/orderDish");
        console.log(response.data);
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

<template>
  <body>
    <div class="container main bg-white">
      <h1 class="display-4 text-center">Bienvenido al Manager del restaurant</h1>
      <div class="container-fluid d-flex bg-primary align-items-center">
        <p class="text-center text-white fs-4">
          Aqui podras ordenar los platos para tus clientes, presiona el boton para enviar una orden
          a la cocina, la cocina elegira una receta al azar entre la lista de recetas y preparará tu
          plato.
        </p>
      </div>
      <div class="container d-flex flex-row justify-content-evenly">
        <button type="button" class="btn btn-primary btn-lg" @click="orderDish">Ordenar Plato</button>
        </div>
        <div class="container-fluid text-center">
          <h1 class="display-5">Recetas</h1>
          <RecipeTableComp/>
        </div>
      </div>
  </body>
</template>

<style scoped>
body {
  background-color: #008880;
  margin:0;
  padding: 0;
}

.main {
  padding-top: 10vh;
  padding-left: 0;
  padding-right: 0;
  margin-bottom: 0;
}

.container-fluid {
  margin-top: 5vh;
  min-height: 30vh;
  margin-left: 0;
  margin-bottom: 0;
}

.container {
  margin-top: 5vh;
}
</style>

