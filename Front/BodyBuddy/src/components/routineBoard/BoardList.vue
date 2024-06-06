<template>
    <div>
        <div id="container">
            <transition-group name="fade" tag="div" class="tgroup">
                <div
                    class="boardBox"
                    v-for="(routine, index) in paginatedBoardList"
                    :key="routine.routineId"
                >
                    <BoardListOne :board-one="routine" />
                </div>
            </transition-group>
        </div>

        <div class="pagination">
            <button
                @click="prevPage"
                :style="{
                    visibility: store.currentPage === 0 ? 'hidden' : 'visible',
                }"
                class="btn btn-primary"
            >
                Prev
            </button>
            <button
                v-for="pageNumber in totalPages"
                :key="pageNumber"
                @click="gotoPage(pageNumber - 1)"
                :class="{ active: store.currentPage === pageNumber - 1 }"
                class="btn btn-primary"
            >
                {{ pageNumber }}
            </button>
            <button
                @click="nextPage"
                :style="{
                    visibility:
                        store.currentPage === totalPages - 1 || totalPages === 0
                            ? 'hidden'
                            : 'visible',
                }"
                class="btn btn-primary"
            >
                Next
            </button>
        </div>
    </div>
</template>

<script setup>
import BoardListOne from "@/components/routineBoard/BoardListOne.vue";
import { useBoardStore } from "@/stores/board";
import { onMounted, ref, computed } from "vue";


const store = useBoardStore();
const pageSize = 4;

const paginatedBoardList = computed(() => {
    const start = store.currentPage * pageSize;
    const end = start + pageSize;
    return store.boardList.slice(start, end);
});

const totalPages = computed(() => Math.ceil(store.boardList.length / pageSize));

onMounted(() => {
    store.getBoardList();
});

const prevPage = () => {
    if (store.currentPage > 0) {
        store.currentPage--;
    }
};

const nextPage = () => {
    if (store.currentPage < totalPages.value - 1) {
        store.currentPage++;
    }
};

// const firstPage = () => {
//     currentPage.value = 0;
// };

// const lastPage = () => {
//     currentPage.value = totalPages.value - 1;
// };

const gotoPage = (page) => {
    store.currentPage = page;
};


</script>

<style scoped>
* {
    font-family: "SUITE-Regular";
}

#container {
    width: 80%;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-around;
    margin-top: 40px;
}

.boardBox {
    /* background-color: #f0f6f6; */
    border: 1px solid #7fabb2;
    border-radius: 7px;
    width: 520px;
    display: flex;
    flex-direction: column;
    margin: 20px auto;
    padding: 10px 20px;
}

.pagination {
    margin-top: 20px;
    margin-bottom: 20px;
    display: flex;
    justify-content: center;
}

.pagination button {
    margin: 0 5px;
    color: black;
    background-color: #eefeff;
    transition: background-color 0.3s;
    border: none;
}

.pagination button.active {
    color: white;
    background-color: #7fabb2;
    transition: background-color 0.3s;
    border: none;
}

.pagination button:active,
button:hover {
    color: white;
    background-color: #7fabb2;
    transition: background-color 0.3s;
    border: none;
}

/* 트랜지션 클래스 */
.fade-enter-active {
    transition: opacity 0.5s ease;
}

.fade-enter-from {
    opacity: 0;
}

#container .tgroup {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}

</style>
