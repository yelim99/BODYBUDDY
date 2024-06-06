<template>
    <div class="likeContainer">
        <p class="noWish" v-if="store.wishList.length == 0">찜한 목록이 없습니다.</p>
        <!-- <h4>찜 목록</h4> -->
        <div v-if="isLoading">
           
            <div class="likeBox" v-for="wish in wRoutines" :key="wish.wishId">
                <BoardListOne :board-one="wish.boardInfo" />
                <button class="addBtn" data-bs-toggle="modal" data-bs-target="#addToMineModal">내 루틴에 추가</button>
                <addModal :my-rid="wish.boardInfo.routineId" modal-id="addToMineModal" />
            </div>
        </div>
    </div>
</template>

<script setup>
    import addModal from '@/components/routineBoard/addModal.vue'
    import BoardListOne from '@/components/routineBoard/BoardListOne.vue'
    import { useBoardStore } from '@/stores/board';
    import { useWishStore } from '@/stores/wish';
    import { onMounted, ref, computed } from 'vue'


    const store = useWishStore()
    const boardStore = useBoardStore()

    const wRoutines = ref([])
    const isLoading = ref(false);

    // 찜한 루틴 정보를 가져오기
    const isWish = (async () => {
        wRoutines.value = store.wishList.map(wish => {
            const boardInfo = boardStore.boardList.find(board => board.routineId === wish.routineId);
            return {
                ...wish,
                boardInfo: boardInfo
            };
        }).filter(wish => wish.boardInfo);
    });

    onMounted(async () => {
        await boardStore.getBoardList();
        await isWish();
        isLoading.value = true; 
    });


</script>

<style scoped>
    .likeContainer {
        /* border: 1px solid gray; */
        width: 720px;
        margin: 60px auto;
    }

    .noWish {
        text-align: center;
        margin-top: 15px;
    }

    .likeBox {
        /* border: 1px solid lightblue; */
        width: 530px;
        margin: 20px auto;
        padding: 20px 20px;
        background-color: #F0F6F6;
    }
    
    .likeBox .addBtn {
        width: 110px;
        height: 30px;
        border: 1px solid #7FABB2;
        background-color: #7FABB2;
        color: white;
        border-radius: 5px;
        font-size: 0.8em;
        font-weight: 500;
        margin-left: 5px;
    }

    @media (max-width: 900px) {
        .likeContainer {
            margin-top: 30px;
        }
    }
</style>