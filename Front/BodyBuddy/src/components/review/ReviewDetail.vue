<template>
    <div>               
        <p><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
            </svg>
            &nbsp;{{ reviewOne.nickname }}
        </p>
        <div>
          <p v-if="!reviewUpdateFlag">{{ reviewOne.content }}</p>
          <input type="text" v-else class="form-control" v-model="reviewOne.content">
        </div>
        <span class="reviewDate">{{ reviewOne.date }}</span>&nbsp;
        <span id="editSpan" v-if="sameUser(reviewOne.userId)" @click="changeFlag(reviewOne.reviewId, reviewOne.routineId, reviewOne.content)">수정</span>&nbsp;
        <span id="deleteSpan" v-if="sameUser(reviewOne.userId)" @click="deleteReview(reviewOne.reviewId, reviewOne.routineId)">삭제</span>
    </div>
</template>

<script setup>
    import { ref } from 'vue';
    const { reviewOne } = defineProps(['reviewOne']);   

    import { useReviewStore } from '@/stores/review'
    const store = useReviewStore()

    const reviewUpdateFlag = ref(false)

    const sameUser = function(userId) {
        const sessionUser = sessionStorage.getItem('userId')
        if(sessionUser === userId) return true
        return false
    }

    const changeFlag = function(reviewId, routineId, content) {
      if(reviewUpdateFlag.value === true && content){
        store.reviewUpdate(reviewId, content)
         .then(() => {
          store.getReviewList(routineId)
         })
         .catch(() => {
         })
      }
      if(content) reviewUpdateFlag.value = !reviewUpdateFlag.value
    }

    const deleteReview = function(reviewId, routineId){
        store.reviewDelete(reviewId)
            .then(() => {
                // 갱신하기
                store.getReviewList(routineId)
            })
            .catch(() => {
            });
    }
    
</script>

<style scoped>
  .reviewDate {
    font-size: 0.8em;
    color: gray;
  }

  p, span {
    margin-bottom: 0.5em;
    font-size: 0.9em;
  }

  button:hover {
    background-color: #A9DDDE; /* 마우스 호버 시 배경색 변경 */
  }

  #deleteSpan, #editSpan {
    cursor: pointer;
    font-size: 0.8em;
    color: gray;
  }

  .form-control {
    width: 50%;
  }
</style>