<template>
    <div>
        <div class="myR" v-if="myLoaded">
            <!-- {{ store.myRoutine.routine.routineTitle }} -->
            <div class="timetable">
                <TimeTable :exercises="exercises" />
            </div>
            <div class="info">
                <span class="rTitle">
                    {{ store.myRoutine.routine.routineTitle }}
                </span>
                <span class="rDesc">{{
                    store.myRoutine.routine.description
                }}</span>
                <span class="rDate">{{ store.myRoutine.routine.date }}</span>
                <!-- 나중에 type 수정하기 -->
                <div class="btns">
                    <button
                        class="btn btn-sm updateBtn"
                        type="button"
                        @click="updateRoutine(route.params.routineId)"
                    >
                        수정
                    </button>
                    <button
                        class="btn btn-sm deleteBtn"
                        type="button"
                        @click="deleteSelection"
                    >
                        삭제
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import TimeTable from "@/components/routineBoard/TimeTable.vue";
import { useMyPageStore } from "@/stores/myPage";
import { onMounted, ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import Swal from 'sweetalert2'

const store = useMyPageStore();

const route = useRoute();

const myLoaded = ref(false);

const routine = ref({});

const exercises = ref([]);

const router = useRouter();

// const rId = ref('')

onMounted(async () => {
    await loadRoutineData(route.params.routineId);
});

const loadRoutineData = async (routineId) => {
    myLoaded.value = false; // 데이터 로딩 시작
    await store.getMyRoutine(routineId);
    routine.value = store.myRoutine.routine;

    exercises.value = store.myRoutine.exList;

    myLoaded.value = true; // 데이터 로딩 완료
};

// 라우트 파라미터 변경 감지
watch(
    () => route.params.routineId,
    async (newRoutineId, oldRoutineId) => {
        if (newRoutineId !== oldRoutineId) {
            await loadRoutineData(newRoutineId);
        }
    },
    { immediate: true }
);

const updateRoutine = function (routineId) {
    router.push({ path: `/mypage/update/${routineId}` });
};

const deleteSelection = function() {
    Swal.fire({
        title: "삭제하시겠습니까?",
        showCancelButton: true,
        confirmButtonText: "확인",
        showCancelButtonText: "취소",
        icon: "warning",
        confirmButtonColor: "#7fabb2",
        width: 450
    })
    .then((result) => {
        if (result.isConfirmed) {
            store.deleteRoutine(route.params.routineId)
        } 
    });
}
</script>

<style scoped>
* {
    /* font-family: "TheJamsil3Regular"; */
    font-family: "LINESeedKR-Rg";
    /* font-weight: 500; */
}
.timetable {
    /* border: 1px solid skyblue; */
    width: 90%;
    margin: 10px auto;
}

.myR .info {
    /* border: 1px solid skyblue; */
    width: 90%;
    height: auto;
    margin: 15px auto;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    padding-left: 10px;
}

.myR .info span {
    margin-bottom: 5px;
}

.myR .info .rTitle {
    font-size: 1.3em;
    font-family: "LINESeedKR-Bd";
}

.myR .info .rDate {
    font-size: 0.8em;
    color: gray;
    /* font-family:"TheJamsil2Light" */
}
.myR .info .rDesc {
    font-size: 1.1em;
    /* font-family:"TheJamsil2Light" */
}
.myR .info .btns {
    align-self: flex-end; 
    margin-left: auto;
    margin-top: 10px;
    margin-right: 10px;
}
.myR .info .btns .updateBtn {
    background-color: #7fabb2;
    color: white;
    margin-right: 10px;
}
.myR .info .btns .deleteBtn {
    background-color: #a9ddde;
    color: white;
}

@media (max-width: 600px) {
  .timetable, .myR .info {
    width: 100%;
  }

  .myR .info {
    flex-direction: column; 
  }
}


</style>
