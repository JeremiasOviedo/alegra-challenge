
<template>
  <body>
    <div class="container main bg-white">
      <h1 class="display-4 text-center">Cocina</h1>
      <div class="container-fluid d-flex bg-primary align-items-center">
        <p class="text-center text-white fs-4">
          En la cocina puedes ver el estado actual de las ordenes de platos. Por motivos de
          personal, solo se pueden preparar 10 platos en simultaneo, por lo que los restantes
          estaran en una lista de espera. Puedes consultar el estado de cada plato en la tabla de
          ordenes.
        </p>
      </div>
      <div class="container-fluid text-center">
        <div class="container d-flex flex-column">
    <ul class="nav nav-pills mb-3 align-self-center" id="pills-tab" role="tablist">
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="pills-preparing-tab" data-bs-toggle="pill" data-bs-target="#pills-preparing" type="button" role="tab" aria-controls="pills-preparing" aria-selected="true" >Preparandose</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="pills-waiting-tab" data-bs-toggle="pill" data-bs-target="#pills-waiting" type="button" role="tab" aria-controls="pills-waiting" aria-selected="false" >En espera</button>
      </li>
      <li class="nav-item" role="presentation">
        <button class="nav-link" id="pills-finished-tab" data-bs-toggle="pill" data-bs-target="#pills-finished" type="button" role="tab" aria-controls="pills-finished" aria-selected="false">Terminados</button>
      </li>
    </ul>
    <div class="btn btn-primary col-3 align-self-end" @click="updateTables">Actualizar</div>
    <div class="tab-content" id="pills-tabContent">
      <div class="tab-pane fade show active" id="pills-preparing" role="tabpanel" aria-labelledby="pills-home-tab">
        <DishTableComp :filter=preparing :key="componentKey" />
      </div>
      <div class="tab-pane fade" id="pills-waiting" role="tabpanel" aria-labelledby="pills-waiting-tab">
        <DishTableComp :filter=waiting :key="componentKey" />
      </div>
      <div class="tab-pane fade" id="pills-finished" role="tabpanel" aria-labelledby="pills-finished-tab">
        <DishTableComp :filter=finished :key="componentKey"/>
      </div>
    </div>
  </div>
      </div>
    </div>
  </body>
</template>


<script>
import DishTableComp from  '../components/DishTableComp.vue'

export default {
  name: 'KitchenView',
  components: { DishTableComp },
  data() {
    return {
      preparing: "preparing",
      waiting: "waiting",
      finished: "finished",
      componentKey: 0    
    }
  },
  methods: {

    updateTables() {
        this.componentKey = this.componentKey + 1;
    },
  }
}
      </script>

<style scoped>
body {
  background-color: #008880;
  margin: 0;
  padding: 0;
  min-height: 100vh;
}

.main {
  padding-top: 10vh;
  padding-left: 0;
  padding-right: 0;
  height: 100%;
}
.container-fluid {
  margin-top: 5vh;
  min-height: 30vh;
  margin-left: 0;
}
.container {
  margin-top: 5vh;
}
</style>
