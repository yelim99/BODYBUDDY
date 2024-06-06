<template>
    <div>
        <div class="detailContainer">
            <div class="detailBox" v-if="boardLoaded">
                <div class="timetable">
                    <TimeTable :exercises="exercises" />
                </div>
                <div class="info">
                    <span class="rTitle">
                        {{ store.board.routine.routineTitle }}
                        <span class="heart" @click="checkWish(store.board.routine.routineId)">
                            <!-- 찜 목록에 있으면 파란 하트, 없으면 흰 하트 -->
                            <span v-if="isWished">💙</span>
                            <span v-else>🤍</span>
                        </span>
                    </span>
                    <span class="rWriter">{{ store.board.routine.nickname }}</span>
                    <span class="rDesc">{{ store.board.routine.description }}</span>
                    <button class="myAddBtn" data-bs-toggle="modal" data-bs-target="#addToMineModal">내 루틴에 추가</button>
                    <addModal :my-rid="store.board.routine.routineId" modal-id="addToMineModal" />
                    <!-- <button class="myAddBtn" @click="store.addMyRoutine(store.board.routine.routineId)">내 루틴에 추가</button> -->
                    <!-- 재현 추가 (리뷰 목록) -->
                    <ReviewList />
                </div>
            </div>
        </div>

    </div>

</template>

<script setup>
    import addModal from '@/components/routineBoard/addModal.vue'
    import TimeTable from '@/components/routineBoard/TimeTable.vue'
    import { useBoardStore } from '@/stores/board'
    import { useWishStore } from '@/stores/wish'
    import { onMounted, ref, computed } from 'vue'
    import { useRoute, useRouter } from 'vue-router'
    import axios from 'axios'

    /* 재현 추가 (리뷰 목록) */
    import ReviewList from '@/components/review/ReviewList.vue'
import { useUserStore } from '@/stores/user'

    const store = useBoardStore()
    const wishStore = useWishStore()
    const userStore = useUserStore()

    const boardLoaded = ref(false)

    const route = useRoute()


    // 클릭 이벤트 핸들러
    const checkWish = (routineId) => {
        // 현재 찜 상태를 바탕으로 조건을 체크하고 찜 상태를 변경
        if (isWished.value) {
            wishStore.delWish(routineId);
            isWished.value = false;  // 상태 업데이트
        } else {
            wishStore.addWish(routineId);
            isWished.value = true;  // 상태 업데이트
        }
    }

    const isWished = ref(false)

    const exercises = ref([])

    const rId = ref('')

    onMounted(async () => {
        await store.getBoard(route.params.routineId)
        boardLoaded.value = true

        isWished.value = wishStore.wishList.some(item =>
            item.routineId === store.board.routine.routineId && item.userId === userStore.loginInfo.userId
        );

        exercises.value = store.board.exList

        rId.value = store.board.routine.routineId;
    })
    

</script>

<style scoped>
    * {
        font-family: 'SUITE-Regular';
    }
    .detailBox {
        /* border: 1px solid lightgray; */
        width: 830px;
        margin: 10px auto;
        display: flex;
        flex-direction: row;
        padding: 10px;
        margin-bottom: 100px;
        margin-top: 40px;
    }

    .detailBox .timetable {
        /* border: 1px solid skyblue; */
        width: 50%;
        /* margin: auto 0; */
    }

    .detailBox .info {
        /* border: 1px solid orange; */
        display: flex;
        flex-direction: column;
        width: 45%;
        /* padding: 10px; */
        padding-left: 20px;
        margin-left: 30px;
    }

    .info span {
        margin-bottom: 5px;
    }

    .info .rTitle {
        font-size: 1.5em;
        font-weight: bold;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
    }

    
    .info .rWriter {
        font-size: 0.9em;

    }
    
    .info .myAddBtn {
        width: 110px;
        height: 30px;
        background-color: #A9DDDE;
        border: none;
        border-radius: 5px;
        font-size: 0.8em;
        font-weight: 500;
        color: white;
        margin-top: 5px;
    }

    .myAddBtn:hover {
        background-color: #7fabb2;
        transition: background-color 0.3s;
    }

    .heart:hover {
        cursor: pointer;
    }
</style>