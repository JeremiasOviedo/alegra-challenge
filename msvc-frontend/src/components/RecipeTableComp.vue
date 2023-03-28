<template>
  <div>
    <table class="table">
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Tiempo de Cocción</th>
          <th>Ingredientes</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="recipe in recipes" :key="recipe.idRecipe">
          <td>{{ recipe.name }}</td>
          <td>{{ recipe.timeToCook }}</td>
          <td>
            <button
              type="button"
              class="btn btn-primary"
              data-bs-toggle="modal"
              data-bs-target="#exampleModal"
              @click.prevent="showIngredients(recipe)"
            >
              Ingredientes
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div
      class="modal fade"
      id="exampleModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">{{ selectedRecipe.name }}</h5>
          </div>
          <div class="modal-body">
            
            <div class ="table-responsive">
            <table class="table">
              <thead class="table-dark">
                <tr>
                  <th>Ingrediente</th>
                  <th>Cantidad</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="ingredient in selectedRecipe.ingredients" class="table">
                  <td>{{ ingredient.ingredientName }}</td>
                  <td>{{ ingredient.quantityNeeded }}</td>
                </tr>
              </tbody>
            </table>
          </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

const RECIPES_URL = 'http://164.90.185.14:8001/recipes'

export default {
  name: 'RecipeList',
  data() {
    return {
      recipes: [],
      selectedRecipe: {},
      showModal: false
    }
  },
  created() {
    this.fetchRecipes()
  },
  methods: {
    fetchRecipes() {
      axios.get(RECIPES_URL).then((response) => {
        this.recipes = response.data
        console.log(this.recipes)
      })
    },
    showIngredients(recipe) {
      this.selectedRecipe = recipe
      this.showModal = true
      console.log(this.selectedRecipe)
    },
    closeModal() {
      this.showModal = false
    }
  }
}
</script>

<style scoped>
.table{
  margin: 0;
}
</style>
