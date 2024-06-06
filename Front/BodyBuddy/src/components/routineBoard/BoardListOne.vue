<template>
    <div class="timetable">
        <TimeTable
            v-if="exercises && exercises.length > 0"
            :exercises="exercises"
        />
    </div>
    <div class="col">
        <p class="contents">
            <!-- <span>
                {{ boardOne.routineId }}
            </span>            -->
            <span class="rTitle">
                <RouterLink :to="`/board/${boardOne.routineId}`">{{
                    boardOne.routineTitle
                }}</RouterLink>
            </span>
            <span class="rWriter">{{ boardOne.nickname }}</span>
            <span class="rDate">{{ boardOne.date }}</span>
            <span class="rReview"></span>
        </p>
        <span class="heart" @click="checkWish(boardOne.routineId)">
            <!-- 찜 목록에 있으면 파란 하트, 없으면 흰 하트 -->
            <span v-if="isWished">💙</span>
            <span v-else>🤍</span>
        </span>
    </div>
</template>

<script setup>
import TimeTable from "@/components/routineBoard/TimeTable.vue";
import { useBoardStore } from "@/stores/board";
import { useUserStore } from "@/stores/user";
import { useWishStore } from "@/stores/wish";
import { computed, onMounted, ref } from "vue";

const store = useBoardStore();
const wishStore = useWishStore();
const userStore = useUserStore();

const { boardOne } = defineProps({
    boardOne: Object,
});

const isWished = ref(false);

const exercises = ref([]);
const isLoaded = ref(false);

// 컴포넌트가 마운트될 때 현재 찜 상태를 확인
onMounted(async () => {
    await store.getExerciseList(boardOne.routineId);

    exercises.value = store.exerciseList;

    isLoaded.value = true;

    isWished.value = wishStore.wishList.some(
        (item) =>
            item.routineId === boardOne.routineId &&
            item.userId === userStore.loginInfo.userId
    );
});

// 클릭 이벤트 핸들러
const checkWish = (routineId) => {
    
    // 현재 찜 상태를 바탕으로 조건을 체크하고 찜 상태를 변경
    if (isWished.value) {
        wishStore.delWish(routineId);
        isWished.value = false; // 상태 업데이트
    } else {
        wishStore.addWish(routineId);
        isWished.value = true; // 상태 업데이트
    }
};
</script>

<style scoped>
* {
    font-family: "LINESeedKR-Rg";
}

.timetable {
    width: 480px;
    margin: 0 auto;
    font-weight: 600;
    margin-bottom: 10px;
}
.col {
    display: flex;
    flex-direction: row;
    margin-left: 5px;
    margin-right: 10px;
}
.contents {
    display: flex;
    flex-direction: column;
    width: 90%;
    margin: 0;
}

.contents span {
    margin-bottom: 10px;
}
.contents a {
    text-decoration: none;

    color: #324b4f;
}
.contents a:hover {
    text-decoration: underline;
    color: #7fabb2;
}
.rTitle {
    font-family: 'LINESeedKR-Bd';
    font-size: 1.3em;
}
.rWriter {
    color: gray;
}
.rDate {
    font-size: 0.8em;
    color: gray;
}

.heart {
    width: 10%;
    font-size: 1.2em;
    text-align: right;
}
.heart:hover {
    cursor: pointer;
}
</style>
