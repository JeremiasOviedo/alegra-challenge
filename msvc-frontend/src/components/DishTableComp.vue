<template>
  <div>
    <div class="table-responsive">
      <table class="table">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>Receta</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="dish in dishes.content" :key="dish.idDish" class="table">
            <td>{{ dish.idDish }}</td>
            <td>{{ dish.recipe.name }}</td>
            <td>{{ dish.status }}</td>
          </tr>
        </tbody>
      </table>
      <div class="container d-flex justify-content-center">
        <nav aria-label="Page navigation example">
          <ul class="pagination">
            <li class="page-item" v-if="previous">
              <a class="page-link" href= "" @click.prevent="changePage(dishes.links.previous)">Prev</a>
            </li>
            <li class="page-item" v-if="next">
              <a class="page-link" href="" @click.prevent="changePage(dishes.links.next)">Next</a>
            </li>
          </ul>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'DishTableComponent',
  props: {
    filter: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      dishes: [],
      loading: true,
      previous: '',
      next: ''
    }
  },
  mounted() {
    this.obtenerDatos()
  },
  methods: {
    async obtenerDatos() {
      const endpoint = `http://164.90.185.14:8001/dishOrders?status=${this.filter}`
      axios
        .get(endpoint)
        .then((response) => {
          this.dishes = response.data
          console.log(this.dishes)
          this.previous = this.dishes.links.previous
          this.next = this.dishes.links.next
        })
        .catch((error) => {
          console.error(error)
        })
    },

    changePage(string) {
      const endpoint = 'http://164.90.185.14:8001' + string + `&status=${this.filter}`
      axios
        .get(endpoint)
        .then((response) => {
          this.dishes = response.data
          console.log(this.dishes)
          this.previous = this.dishes.links.previous
          this.next = this.dishes.links.next
        })
        .catch((error) => {
          console.error(error)
        })
    }
  },
  watch: {
    filter(newVal) {
      this.obtenerDatos()
    }
  }
}
</script>

<style scoped>
.table{
    margin-top: 2vh;
    margin-bottom:0;
}

.container{
    margin-top: 2vh;
}
</style>
