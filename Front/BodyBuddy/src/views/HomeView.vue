<template>
    <div class="bigContainer">
        <!-- 메인 배너 -->
        <div class="mainBanner">
            <img src="@/assets/img/main4.jpg" />
            <div class="mainText">
                <span class="mainT"> Manage your routine </span>
                <span class="mainD">
                    규칙적인 운동 루틴을 <br>
                    보다 편하게 관리하고 싶으신가요?
                </span>
                <RouterLink :to="{ name: 'myRoutineList' }">
                <button class="mainBtn">
                        함께하기
                    </button>
                </RouterLink>
            </div>
        </div>

        <!-- 메인 소개 -->
        <div class="mainMy">
            <div class="mainMyL">
                <span class="mainMyT">나만의 운동 루틴</span>
                <span class="mainMyD">
                    개인의 운동 목표에 맞춘 루틴을 쉽게 설정하고,<br>
                    시간표로 관리하며 함께 습관을 만들어가요!<br />
                    <button class="mainMyBtn" @click="confirmAddRoutine">
                        루틴 만들기
                    </button>
                </span>
            </div>
            <div class="mainMyR">
                <img src="@/assets/img/ex1.png" />
                <img class="hiddenImg" src="@/assets/img/ex2.png">
            </div>
        </div>

        <!-- 운동 루틴 보여주기 -->
        <div class="mainRec">
            <span class="mainRecHead">운동 루틴 추천</span>
            <carouselItem />
        </div>


        <!-- 라이브러리 -->
        
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { useMyPageStore } from "@/stores/myPage";
import { useBoardStore } from "@/stores/board";
import { onMounted, computed } from "vue";
import { useRouter } from "vue-router";
import carouselItem from '@/components/main/carouselItem.vue'

const store = useUserStore();
const myPageStore = useMyPageStore();
const boardStore = useBoardStore();

const router = useRouter();

const confirmAddRoutine = () => {
    router.push(`/mypage/regist`);
};


onMounted(() => {
    boardStore.getBoardList();
    // console.log(boardStore.boardList);
});

</script>

<style scoped>

* {
    font-family: "LINESeedKR-Rg";
}

.bigContainer .mainBanner {
    /* border: 1px solid lightgray; */
    height: 450px;
    text-align: center;
}
.mainBanner img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;
}
.mainBanner {
    position: relative;
    width: 100%;
    height: auto;
}

.mainText {
    position: absolute;
    top: 50%;
    left: 25%;
    transform: translate(-50%, -50%);
    text-align: left;
    background-color: #eefeff;
    padding: 35px 20px;
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    width: 360px;
    height: 60%;
}

.mainT {
    color: #7fabb2;
    font-weight: 700;
    font-size: 1.8em;
}

.mainBtn {
    background-color: #7fabb2;
    border: none;
    width: 140px;
    height: 40px;
    color: white;
    font-size: 0.9em;
    border-radius: 5px;
}

.mainBtn a {
    text-decoration: none;
    color: white;
}

/* mainMy */
.mainMy {
    /* border: 1px solid lightgray;   */
    height: 400px;
    display: flex;
    flex-direction: row;
}
.mainMy .mainMyL {
    /* border: 1px solid lightgray; */
    width: 35%;
    text-align: left;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    padding: 60px 0;
    padding-left: 80px;
    padding-right: 15px;
}
.mainMyT {
    font-weight: 700;
    font-size: 1.3em;
}
.mainMyD {
    text-align: left;
    font-size: 15px;
}

.mainMy .mainMyR {
    /* border: 1px solid lightgray; */
    width: 60%;
    padding-left: 20px;
    padding-top: 30px;
    display: flex;
    flex-flow: row wrap;
    justify-content: center;
    align-items: center;
    padding-bottom: 30px;
}

.mainMyR img {
    width: 400px;
    height: 240px;
    margin-right: 10px;
}

.mainMyBtn {
    background-color: #7fabb2;
    border: none;
    width: 140px;
    height: 40px;
    color: white;
    font-size: 0.9em;
    margin-top: 20px;
    border-radius: 5px;
}

.mainMyBtn:hover, .mainBtn:hover {
    background-color: #A9DDDE;
    transition: background-color 0.3s;
}

/* mainRec */
.mainRec {
    /* border: 1px solid lightgray; */
    height: 350px;
    background-color: #eefeff;
    padding-top: 30px;
    text-align: center;
}

.mainRec .mainRecHead {
    font-weight: bold;
    font-size: 1.2em;
}

@media (max-width: 1390px) {
    .hiddenImg {
        visibility: hidden;
    }
    .mainMyR {
        margin-top: 50px;
    }
}
</style>
