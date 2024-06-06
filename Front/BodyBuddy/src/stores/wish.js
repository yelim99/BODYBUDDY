import { ref, onMounted,computed, reactive } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'
import { useUserStore } from './user'

const REST_WISH_API = `http://localhost:8080/routine/wish`

export const useWishStore = defineStore('wish', () => {


    const wishList = ref([])

    const getwishList = (() => {
        axios.get(`${REST_WISH_API}/wishList`)
            .then((response) => {
                wishList.value = response.data
            })
    })

    const addWish = ((routineId) => {
        axios.get(`${REST_WISH_API}/add-heart/${routineId}`)
            .then((response) => {
                const userStore = useUserStore()
                wishList.value.push({userId: userStore.loginInfo.userId, routineId: routineId})
            })
    })

    const delWish = ((routineId) => {
        axios.delete(`${REST_WISH_API}/delete-heart/${routineId}`)
            .then((response) => {
                const index = wishList.value.findIndex(item => item.routineId === routineId);
                if (index !== -1) {
                    wishList.value.splice(index, 1);
                }
            })
    })

    return {
        addWish,
        wishList,
        getwishList,
        delWish,
    }
    
},
{
  persist: true
}
)