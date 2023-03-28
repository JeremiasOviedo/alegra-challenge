<template>
  <body>
    <div class="container main bg-white">
      <h1 class="display-4 text-center">Bodega</h1>
      <div class="container-fluid d-flex bg-primary align-items-center">
        <p class="text-center text-white fs-4">
          En la bodega puedes consultar el stock de ingrendientes, asi como ver las ordenes de
          compra que se hacen al mercado de la ciudad.
        </p>
      </div>
      <div class="container-fluid text-center">
        <div class="container d-flex flex-column">
          <ul class="nav nav-pills mb-3 align-self-center" id="pills-tab" role="tablist">
            <li class="nav-item" role="presentation">
              <button
                class="nav-link"
                id="pills-stock-tab"
                data-bs-toggle="pill"
                data-bs-target="#pills-stock"
                type="button"
                role="tab"
                aria-controls="pills-stock"
                aria-selected="true"
              >
                Stock
              </button>
            </li>
            <li class="nav-item" role="presentation">
              <button
                class="nav-link"
                id="pills-buyorders-tab"
                data-bs-toggle="pill"
                data-bs-target="#pills-buyorders"
                type="button"
                role="tab"
                aria-controls="pills-buyorders"
                aria-selected="false"
              >
                Ordenes de compra
              </button>
            </li>
          </ul>
          <div class="btn btn-primary col-3 align-self-end" @click="updateTables">Actualizar</div>
          <div class="tab-content" id="pills-tabContent">
            <div
              class="tab-pane fade show active"
              id="pills-stock"
              role="tabpanel"
              aria-labelledby="pills-stock-tab"
            >
              <IngredientsTableComp :key="componentKey" />
            </div>
            <div
              class="tab-pane fade"
              id="pills-buyorders"
              role="tabpanel"
              aria-labelledby="pills-buyorders-tab"
            >
              <BuyOrdersTableComp :key="componentKey" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>

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

<script>
import IngredientsTableComp from '../components/IngredientsTableComp.vue'
import BuyOrdersTableComp from '../components/BuyOrdersTableComp.vue'

export default {
  name: 'WarehouseView',
  components: { IngredientsTableComp, BuyOrdersTableComp },
  data() {
    return {
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
