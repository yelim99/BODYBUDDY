<template>
    <div>
        <br>
        <p>리뷰 목록</p>
        <div class="review-list">
            <div
                v-for="review in store.reviewList"
                :key="review.reviewId"
            >
                <ReviewDetail :review-one="review" @delete-success="handleDeleteSuccess(routineId)"/>
                <span>&nbsp;</span>
            </div>
        </div>
        <span>&nbsp;</span>
        <div class="row">
            <div class="col-md-8">
                <input type="text" id="inputReview" v-model="review.content" class="form-control" placeholder="리뷰를 입력해주세요.">
            </div>
            <div class="col-md-4">
                <button type="button" @click="reviewRegist(review.content)" class="btn btn-primary">등록</button>
            </div>
        </div>
    </div>
</template>

<script setup>
    import ReviewDetail from '@/components/review/ReviewDetail.vue'
    import { useReviewStore } from '@/stores/review'
    import { onMounted, ref } from 'vue';
    import { useRoute, useRouter } from 'vue-router';
    import Swal from 'sweetalert2'

    const store = useReviewStore()
    const route = useRoute();
    const router = useRouter();
    
    const review = ref({
        routineId: '',
        userId: '',
        nickname: '',
        content: ''
    })

    const reviewRegist = function(content){
        const routineId = route.params.routineId
        if(content) {
            store.reviewRegist(review.value, routineId)
            .then(() => {
                // 리뷰 등록 후에 리뷰 목록을 다시 불러와서 화면 갱신
                store.getReviewList(routineId);
                review.value.content = '';
            })
        }
        else {
          if(sessionStorage.getItem("userId") && sessionStorage.getItem("nickname")){
            Swal.fire({
              title: "내용을 입력해주세요.",
              confirmButtonText: "확인",
              icon: "warning",
              confirmButtonColor: "#7fabb2",
              width: 450
            })
          }
          else {
            router.push({ name: 'login' })
          }
          
        }
        review.value.content = '';
    }

    onMounted(() => {
        const routineId = route.params.routineId
        store.getReviewList(routineId)
    })


</script>

<style scoped>

.review-list {
  max-height: 400px;
  overflow-y: auto;
  padding: 10px;
}

button {
  background-color: #7FABB2;
  color: white;
  border: none;
  cursor: pointer;
}

button:disabled {
    cursor: not-allowed;
}

button:hover {
  background-color: #A9DDDE;
}

@media (max-width: 1200px) {
  .review-list {
    max-height: 300px;
  }
}

@media (max-width: 992px) {
  .review-list {
    max-height: 250px;
  }
}

@media (max-width: 768px) {
  .review-list {
    max-height: 200px;
  }
}

@media (max-width: 576px) {
  .review-list {
    max-height: 150px;
  }
}
</style>