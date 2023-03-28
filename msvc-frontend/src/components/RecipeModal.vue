
<template>
  <div class="modal fade"  :id="modalId" tabindex="-1" role="dialog" v-if="showModal">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">{{ selectedRecipe.name }}</h5>
          <button
            type="button"
            class="close"
            data-dismiss="modal"
            aria-label="Close"
            @click="closeModal"
          >
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <ul>
            <li v-for="ingredient in selectedRecipe.ingredients" :key="ingredient.id">
              {{ ingredient.name }}
            </li>
          </ul>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal" @click="closeModal">
            Cerrar
          </button>
        </div>
      </div>
    </div>
  </div>


</template>

<script>
export default {
    props: ['recipe', 'show','modalId'],
  data() {
    return {
      showModal: false
    };
  },
  methods: {
    closeModal() {
      this.showModal = false;
      this.$emit('close');
    }
  }
};
</script>
