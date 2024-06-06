<template>

    <!-- ======예림 수정 (css)======== -->
    <div id="headerBox">
        <header>
            <div id="logo">
                <RouterLink :to="{ name: 'home'}">
                    <img src="@/assets/img/logo4.png">
                </RouterLink>
            </div>
            <div id="nav">
                <RouterLink :to="{ name: 'home'}">Home</RouterLink> 
                <RouterLink :to="{ name: 'routineList'}">Routines</RouterLink>
                <RouterLink :to="{ name: 'Library'}">Library</RouterLink>
            </div>
            <div id="user">
                <!-- 재현 수정 
                    로그인 상태에서 로그아웃, 마이페이지
                    로그아웃 상태에서 로그인, 회원가입이 보이게 함 -->
                <RouterLink v-if="(store.loginInfo.userId.length==0)" :to="{ name: 'login' }" >Login</RouterLink>
                <RouterLink v-else :to="{ name: 'myRoutineList'}" >{{ store.loginInfo.nickname }} 님</RouterLink> |
                <RouterLink v-if="(store.loginInfo.userId.length==0)" :to="{ name: 'join' }">Sign Up</RouterLink>
                <RouterLink v-else id="logoutBtn" @click="store.logout()" :to="{ name: 'home' }">Logout</RouterLink> 
            </div>
        </header>
    </div>

  </template>
  
  <script setup>
//  import { ref, onMounted } from 'vue'
    import { useUserStore } from '@/stores/user'
    import { useRouter } from 'vue-router'

    const store = useUserStore()
    const router = useRouter()


  </script>
  
  <style scoped>

    * {
        font-family: 'SUITE-Regular';
        font-weight: 600;
    }
        /* ========= 예림 수정 ========== */

        #headerBox {
            width: 100%;
            height: 50px;
            /* border: 1px solid lightgray; */
            display: flex;
            /* justify-content: space-between; */
            align-items: center;
        }
        header {
            width: 100%;
            display: flex;
            flex-direction: row;
        }
        header #logo {
            margin-left: 10px;
        }
        /* ==========예림 수정===========*/
        #logo img {
            width: 150px;
        }

        header #nav {
            /* border: 1px solid blue; */
            width: 30%;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            text-align: center;
            align-items: center;
            margin: 0 auto;
            font-size: 0.9em;
        }
        header #nav .router-link-exact-active {
            color: #7FABB2;
            font-weight: 700;
        }
        header #user {
            width: 160px;
            margin-right: 10px;
            font-size: 0.9em;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }
        /* ========= 재현 수정 ========== */
        a {
            text-decoration-line: none;
            color: black;
            cursor: pointer;    
        }

  </style>
  