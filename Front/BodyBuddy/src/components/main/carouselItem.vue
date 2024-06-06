<template>
    <div
        id="carouselExample"
        class="carousel slide"
        data-bs-ride="carousel"
    >
        <div class="carousel-inner">
            <div class="carousel-item active">
                <p v-if="boardStore.boardList.length==0">운동 루틴이 없습니다.</p>
                <div class="mainRecBox" v-if="boardStore.boardList.length >= 1">
                    <RouterLink :to="`/board/${boardStore.boardList[0].routineId}`">
                        <img src="@/assets/img/view1.jpg" alt="Routine 1" />
                    </RouterLink>
                    <div class="info">
                        <p class="rTitle">
                            <RouterLink :to="`/board/${boardStore.boardList[0].routineId}`">
                                {{ boardStore.boardList[0].routineTitle }}
                            </RouterLink>
                        </p>
                        <p class="rWriter">
                            {{ boardStore.boardList[0].nickname }}
                        </p>
                    </div>
                </div>
                <div class="mainRecBox" v-if="boardStore.boardList.length >= 2">
                    <RouterLink :to="`/board/${boardStore.boardList[1].routineId}`">
                        <img src="@/assets/img/view2.jpg" alt="Routine 2" />
                    </RouterLink>
                    <div class="info">
                        <p class="rTitle">
                            <RouterLink :to="`/board/${boardStore.boardList[1].routineId}`">
                                {{ boardStore.boardList[1].routineTitle }}
                            </RouterLink>
                        </p>
                        <p class="rWriter">
                            {{ boardStore.boardList[1].nickname }}
                        </p>
                    </div>
                </div>
                <div class="mainRecBox" v-if="boardStore.boardList.length >= 3">
                    <RouterLink :to="`/board/${boardStore.boardList[2].routineId}`">
                        <img src="@/assets/img/view3.jpg" alt="Routine 3" />
                    </RouterLink>
                    <div class="info">
                        <p class="rTitle">
                            <RouterLink :to="`/board/${boardStore.boardList[2].routineId}`">
                                {{ boardStore.boardList[2].routineTitle }}
                            </RouterLink>
                        </p>
                        <p class="rWriter">
                            {{ boardStore.boardList[2].nickname }}
                        </p>
                    </div>
                </div>
            </div>
            <div class="carousel-item" v-if="boardStore.boardList.length >= 4">
                <div class="mainRecBox" v-if="boardStore.boardList.length >= 4">
                    <RouterLink :to="`/board/${boardStore.boardList[3].routineId}`">
                        <img src="@/assets/img/view4.jpg" alt="Routine 1" />
                    </RouterLink>
                    <div class="info">
                        <p class="rTitle">
                            <RouterLink :to="`/board/${boardStore.boardList[3].routineId}`">
                                {{ boardStore.boardList[3].routineTitle }}
                            </RouterLink>
                        </p>
                        <p class="rWriter">
                            {{ boardStore.boardList[3].nickname }}
                        </p>
                    </div>
                </div>
                <div class="mainRecBox" v-if="boardStore.boardList.length >= 5">
                    <RouterLink :to="`/board/${boardStore.boardList[4].routineId}`">
                        <img src="@/assets/img/view5.jpg" alt="Routine 2" />
                    </RouterLink>
                    <div class="info">
                        <p class="rTitle">
                            <RouterLink :to="`/board/${boardStore.boardList[4].routineId}`">
                                {{ boardStore.boardList[4].routineTitle }}
                            </RouterLink>
                        </p>
                        <p class="rWriter">
                            {{ boardStore.boardList[4].nickname }}
                        </p>
                    </div>
                </div>
                <div class="mainRecBox" v-if="boardStore.boardList.length >= 6">
                    <RouterLink :to="`/board/${boardStore.boardList[5].routineId}`">
                        <img src="@/assets/img/view6.jpg" alt="Routine 3" />
                    </RouterLink>
                    <div class="info">
                        <p class="rTitle">
                            <RouterLink :to="`/board/${boardStore.boardList[5].routineId}`">
                                {{ boardStore.boardList[5].routineTitle }}
                            </RouterLink>
                        </p>
                        <p class="rWriter">
                            {{ boardStore.boardList[5].nickname }}
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide="prev"
            v-if="boardStore.boardList.length >= 4"
        >
            <span class="carousel-control-prev-icon"aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide="next"
            v-if="boardStore.boardList.length >= 4" 
        >
            <span class="carousel-control-next-icon"aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</template>

<script setup>

import { useBoardStore } from "@/stores/board";
import { onMounted } from "vue";

const boardStore = useBoardStore();

onMounted(() => {
    boardStore.getBoardList();
});

</script>

<style scoped>

*{
    font-family: "LINESeedKR-Rg";
}

/* carousel */
.carousel-inner {
    display: flex;
    /* border: 1px solid gray; */
}
#carouselExample {
    margin-top: 30px;
}

.carousel-item {
    transition: transform 0.6s ease-in-out; /* 기본값은 0.6s인 경우가 많으나, 'ease-in-out'을 추가하여 더 부드러운 전환 효과를 줄 수 있음 */
}

    .carousel-item.active, .carousel-item-start, .carousel-item-end {
        /* width: 1050px; */
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: row;
        /* margin: 0 auto; */
        /* border: 1px solid gray; */
    }



    .carousel-item img {
        width: 100%; 
        height: auto;
    }
    .mainRecBox {
        /* border: 1px solid blue; */
        margin: 5px 25px;
        height: 200px;
        text-align: center;
        width: 250px; 
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    .mainRecBox img {
        width: 100%; 
        height: 150px;
    }

.mainRecBox p {
    margin: 0;
}

.mainRecBox .info {
    /* border: 1px solid gray; */
    text-align: left;
    padding-top: 10px;
}

.mainRecBox .info .rTitle a {
    color: black;
    text-decoration: none;
    font-size: 1.1em;
}

.mainRecBox .info .rTitle a:hover {
    text-decoration: underline;
    color: #7fabb2;
}

.mainRecBox .info .rWriter {
    font-size: 0.9em;
    color: #9f9f9f;
}

.carousel-control-prev,
.carousel-control-next {
    filter: invert(100%);
}

</style>