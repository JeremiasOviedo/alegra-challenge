<template>
  <div>
    <div class="table-responsive">
      <table class="table">
        <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>Ingrediente</th>
            <th>Cantidad comprada</th>
            <th>Fecha</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="order in buyOrders.content" :key="order.idOrder" class="table">
            <td>{{ order.idOrder }}</td>
            <td>{{ order.ingredient }}</td>
            <td>{{ order.quantityBought }}</td>
            <td>{{ trimDate(order.creationDate) }}</td>
          </tr>
        </tbody>
      </table>
      <div class="container d-flex justify-content-center">
        <nav aria-label="Page navigation example">
          <ul class="pagination">
            <li class="page-item" v-if="previous">
              <a class="page-link" href="" @click.prevent="changePage(buyOrders.links.previous)"
                >Prev</a
              >
            </li>
            <li class="page-item" v-if="next">
              <a class="page-link" href="" @click.prevent="changePage(buyOrders.links.next)"
                >Next</a
              >
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
  name: 'BuyOrdersTableComp',
  data() {
    return {
      buyOrders: [],
      previous: '',
      next: ''
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    async getData() {
      const endpoint = `http://localhost:8000/buyOrders`
      axios
        .get(endpoint)
        .then((response) => {
          this.buyOrders = response.data
          console.log(this.buyOrders)
          this.previous = this.buyOrders.links.previous
          this.next = this.buyOrders.links.next
        })
        .catch((error) => {
          console.error(error)
        })
    },

    changePage(string) {
      const endpoint = 'http://localhost:8000' + string
      axios
        .get(endpoint)
        .then((response) => {
          this.buyOrders = response.data
          console.log(this.buyOrders)
          this.previous = this.buyOrders.links.previous
          this.next = this.buyOrders.links.next
        })
        .catch((error) => {
          console.error(error)
        })
    },
    trimDate(string) {
      const date = new Date(string)
      const options = {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'
      }
      const dateTrimmed = date.toLocaleString('es-AR', options)
      return dateTrimmed
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
.table {
margin-top: 2vh;
margin-bottom: 0;
}

.container {
  margin-top: 2vh;
}
</style>
