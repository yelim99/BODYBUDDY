import { ref, reactive } from 'vue'
import { defineStore } from 'pinia'
import { useMyPageStore } from '@/stores/myPage'
import axios from 'axios'
import router from '@/router'
import { useWishStore } from './wish'
import Swal from 'sweetalert2'

axios.defaults.withCredentials = true;
const REST_USER_API = `http://localhost:8080/users`

export const useUserStore = defineStore('user', () => {
  
  const joinInfo = reactive({
    nickname: '',
    userId: '',
  })

  const loginInfo = reactive({
    nickname: '',
    userId: '',
  })

  const join = function (user) {
    axios({
      url: `${REST_USER_API}/join`,
      method: 'POST',
      data: user
    })
    .then(() => {
      Swal.fire({
        position: "center",
        icon: "success",
        title: "회원가입이 완료되었습니다.",
        confirmButtonColor: "#7fabb2",
        timer: 1500,
        backdrop: 'rgba(0,0,0,0.75)',
        width: 450
      });
      router.push({name: 'login'})
    })
    .catch(() => {})
  }

  const edit = function (user) {
    axios.put(`${REST_USER_API}/edit`, user)
    .then(() => {
      sessionStorage.setItem('nickname', user.nickname)
      loginInfo.nickname = user.nickname
      joinInfo.nickname = ''
      joinInfo.userId = ''
      router.push({name: 'home'})
      Swal.fire({
        position: "center",
        icon: "success",
        title: "회원 정보가 수정되었습니다.",
        confirmButtonColor: "#7fabb2",
        timer: 1500,
        backdrop: 'rgba(0,0,0,0.75)',
        width: 450
      });
    })
    .catch(() => {
      joinInfo.nickname = ''
      joinInfo.userId = ''
    })
  }

  const login = (async (user) => {
    await axios({
      url: `${REST_USER_API}/login`,
      method: 'POST',
      data: user
    })
    .then((response) => {
      sessionStorage.setItem('userId', response.data.userId)
      sessionStorage.setItem('nickname', response.data.nickname)
      
      loginInfo.userId = response.data.userId;
      loginInfo.nickname = response.data.nickname;

      const myPageStore = useMyPageStore();
      myPageStore.myRoutineList = myPageStore.getMyRoutines()
      // myPageStore.myRoutine = myPageStore.getMyRoutine()

      const wishStore = useWishStore();
      wishStore.wishList = wishStore.getwishList()

      router.push({name: 'home'})
    })
    .catch(() => {
      Swal.fire({
        position: "center",
        icon: "error",
        title: "아이디 또는 비밀번호가 일치하지 않습니다.",
        confirmButtonColor: "#7fabb2",
        timer: 1500,
        backdrop: 'rgba(0,0,0,0.75)',
        width: 450
      });
    })
  })

  const logout = (async () => {
    await axios({
      url: `${REST_USER_API}/logout`,
      method: 'POST'
    })
    .then(() => {
      sessionStorage.removeItem("nickname");
      sessionStorage.removeItem("userId");

      loginInfo.userId = ''
      loginInfo.nickname = ''

      const myPageStore = useMyPageStore();
      myPageStore.myRoutineList = {};
      myPageStore.myRoutine = []

      const wishStore = useWishStore()
      wishStore.wishList = [];

      router.push({name: 'home'})
    })
    .catch(() => {
      loginInfo.userId = ''
      loginInfo.nickname = ''
      router.push({name: 'home'})
    })
  })

  const checkDuplicateUserId = function(userId){
    return axios({
      url: `${REST_USER_API}/check-duplicate-id`,
      method: 'POST',
      params: {userId: userId}
    })
    .then((response) => {
      return response.data
      
    })
    .catch(() => {})
  }

  const checkDuplicateNickname = function(nickname){
    return axios({
      url: `${REST_USER_API}/check-duplicate-nickname`,
      method: 'POST',
      params: {nickname: nickname}
    })
    .then((response) => {
      return response.data
    })
    .catch(() => {})
  }

  const storeNickname = function(nickname){
    joinInfo.nickname = nickname
  }

  const storeUserId = function(userId){
    joinInfo.userId = userId
  }

  return { 
    joinInfo,
    loginInfo,
    join, 
    edit,
    login, 
    logout,
    checkDuplicateUserId, 
    checkDuplicateNickname,
    storeNickname,
    storeUserId,
  }
},
{
  persist: true
}
)
