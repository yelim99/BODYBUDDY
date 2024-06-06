import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

axios.defaults.withCredentials = true;
const REST_REVIEW_API = `http://localhost:8080/routine/board/review`

export const useReviewStore = defineStore('review', () => {

  const reviewList = ref([])  
  
  const getReviewList = function (routineId) {
    axios.get(`${REST_REVIEW_API}/${routineId}`)
        .then((response) => {
            reviewList.value = response.data
        })
  }

  const reviewRegist = function (review, routineId) {
    return axios.post(`${REST_REVIEW_API}/${routineId}/regist`, review)
        .then((response) => {
            return response.data
        })
        .catch(() => {
        })
  }

  const reviewUpdate = function (reviewId, content) {
    return axios.put(`${REST_REVIEW_API}/update`, null, {
        params: {
          reviewId: reviewId,
          content: content
        }
      })
        .then((response) => {
            return response.data;
        })
        .catch(() => {});
  };

  const reviewDelete = function (reviewId) {
    return axios.delete(`${REST_REVIEW_API}/delete`, {
        params: {
          reviewId: reviewId
        }
      })
        .then((response) => {
            return response.data;
        })
        .catch(() => {});
  };

  return { 
    reviewList,
    getReviewList,
    reviewRegist,
    reviewUpdate,
    reviewDelete
  }
},
{
  persist: true
}
)
