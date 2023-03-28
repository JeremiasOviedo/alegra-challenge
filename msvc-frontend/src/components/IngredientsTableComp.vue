<template>
  <div>
    <div class="table-responsive">
      <table class="table">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Cantidad en Stock</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="ingredient in ingredients" :key="ingredient.idingredient" class="table">
            <td>{{ ingredient.idIngredient }}</td>
            <td>{{ ingredient.name }}</td>
            <td>{{ ingredient.quantityInStock }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'IngredientsTableComponent',
  data() {
    return {
      ingredients: []
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    async getData() {
      const endpoint = `http://164.90.185.14:8000/stock`
      axios
        .get(endpoint)
        .then((response) => {
          this.ingredients = response.data
          console.log(this.ingredients)
        })
        .catch((error) => {
          console.error(error)
        })
    }
  },
  watch: {
    filter(newVal) {
      this.getData()
    }
  }
}
</script>

<style scoped>
.table {
  margin-top: 2vh;
  margin-bottom: 0;
}

.container {
  margin-top: 2vh;
}
</style>
