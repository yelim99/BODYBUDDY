<template>
    <div class="routine-container">
        <h2>루틴 등록하기</h2>
        <div class="searchBar">
            <label id="searchLabel" for="searchInput">운동이름 검색</label>
            <input
                id="searchInput"
                type="text"
                v-model="search"
                placeholder="Search"
                class="search"
                @keyup.enter="search"
            />
            <button class="searchBtn" @click="search">검색</button>
        </div>
        <div class="partBtns">
            <button
                v-for="part in parts"
                :key="part"
                @click="selectedPart = part"
                :class="{ active: selectedPart === part }"
                class="partBtn"
            >
                {{ part }}
            </button>
        </div>
        <hr />
        <div class="ex-container">
            <div
                class="ex-col"
                v-for="exercise in filteredExercises"
                :key="exercise.id"
            >
                <input
                    type="checkbox"
                    :id="exercise.id"
                    @change="toggleExercise(exercise)"
                    :checked="
                        selectedExercises.some((e) => e.id === exercise.id)
                    "
                    class="ex-check"
                />
                <label :for="exercise.id" class="ex-label">{{
                    exercise.exerciseName
                }}</label>
            </div>
        </div>
        <transition-group name="fade" tag="div">
            <div
                v-for="(exerciseOne, index) in selectedExercises"
                :key="'selected-' + exerciseOne.id"
                class="ex-block"
            >
            <MyRoutineRegistDetail :exercise-one="exerciseOne" :index="index" @delete-exercise="removeExercise"/>
            </div>
        </transition-group>

        <transition-group name="fade" tag="div">
        <div v-if="isFormValid" class="ex-block">
            <div class="text">
                <div class="input-group">
                    <input
                        type="text"
                        id="inputTitle"
                        v-model="text.routineTitle"
                        class="form-control"
                        placeholder="제목을 입력해주세요."
                    />
                </div>
                <div class="input-group">
                    <textarea
                        id="inputDescription"
                        v-model="text.description"
                        class="form-control"
                        placeholder="설명을 입력해주세요."
                    />
                </div>
            </div>
            <div>
                <button
                    type="button"
                    id="registBtn"
                    class="btn btn-primary"
                    @click="submitExercises()"
                >
                    등록하기
                </button>
            </div>
        </div>
    </transition-group>
    </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { exercises } from "@/data/exercises.js";
import { useMyPageStore } from "@/stores/myPage";
import MyRoutineRegistDetail from '@/components/myPage/MyRoutineRegistDetail.vue'

const store = useMyPageStore();

const search = ref("");
const selectedPart = ref("");

const parts = ["하체", "가슴", "등", "어깨", "팔", "복근", "유산소"];

const filteredExercises = computed(() => {
    return exercises.filter(
        (exercise) =>
            exercise.exercisePart === selectedPart.value &&
            exercise.exerciseName.includes(search.value)
    );
});
const selectedExercises = ref([]);
const isFormValid = computed(() => {
    return (
        selectedExercises.value.length > 0 &&
        selectedExercises.value.every(
            (exercise) =>
                exercise.dayOfTheWeek.length > 0 && exercise.time !== ""
        )
    );
});

const addExercise = (exercise) => {
    if (!selectedExercises.value.some((e) => e.id === exercise.id)) {
        selectedExercises.value.push({
            ...exercise,
            dayOfTheWeek: [],
            setCnt: 0,
            weight: 0,
            repetitions: 0,
            time: "",
        });
    }
};

const removeExercise = (id) => {
    selectedExercises.value = selectedExercises.value.filter(
        (exercise) => exercise.id !== id
    );
}

const toggleExercise = (exercise) => {
    const index = selectedExercises.value.findIndex(
        (e) => e.id === exercise.id
    );
    if (index === -1) {
        addExercise(exercise);
    } else {
        removeExercise(exercise.id);
    }
};

const text = ref({
    routineTitle: "",
    description: "",
});

const submitExercises = () => {
    const formattedExercises = selectedExercises.value.map((exercise) => ({
        ...exercise,
        dayOfTheWeek: exercise.dayOfTheWeek.join(","),
    }));
    store.addRoutine(
        formattedExercises,
        text.value.routineTitle,
        text.value.description
    );
};
</script>

<style scoped>
.routine-container {
    max-width: 800px;
    width: 570px;
    margin: 20px auto;
    text-align: center;
    margin-top: 50px;
}

h2 {
    color: #333;
    font-size: 24px;
    margin-bottom: 30px;
}

.searchBar .search {
    margin-right: 10px;
    width: 40%;
    padding: 3px 10px;
    font-size: 0.9em;
    border-radius: 5px;
    border: 1px solid lightgray;
    margin-bottom: 20px;
}

.searchBtn {
    background-color: #7fabb2;
    color: white;
    border: none;
    cursor: pointer;
    width: 50px;
    height: 30px;
    font-size: 0.9em;
    border-radius: 5px;
}

#searchLabel {
    font-size: 0.8em;
    margin-right: 20px;
}

button:hover {
    background-color: #a9ddde;
}

.partBtns {
    margin: 20px 0;
}

.partBtn {
    font-size: 0.9em;
    padding: 5px;
    margin-left: 5px;
    margin-right: 5px;
    color: #324b4f;
    background-color: #ffffff;
    border-radius: 15px;
    cursor: pointer;
    width: 12%;
}

.partBtn.active,
.partBtn:hover {
    background-color: #324b4f;
    transition: background-color 0.3s;
    color: #ffffff;
}

.ex-container {
    display: flex;
    flex-wrap: wrap;
    margin: 20px 0;
}

.ex-col {
    width: 50%;
    padding: 5px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin-bottom: 7px;
}

.ex-check {
    margin-right: 5px;
    width: 17px;
    height: 17px;
    border: 2px solid #7fabb2;
    border-radius: 5px;
    accent-color: #324b4f;
}

.ex-label {
    font-size: 14px;
    color: #666;
}

.ex-block {
    background-color: white;
    border: 1px solid #324b4f;
    padding: 15px;
    margin-bottom: 10px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

#registBtn {
    background-color: #7fabb2;
    color: white;
    border: none;
    cursor: pointer;
    margin-top: 20px;
}

#registBtn:disabled {
    cursor: not-allowed;
    opacity: 0.5;
}

#registBtn:hover {
    background-color: #a9ddde;
}

.input-group {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
}

.input-group label {
    margin-right: 10px;
}

#inputDescription {
    height: 200px;
}

.fade-enter-active,
.fade-leave-active {
    transition: opacity 0.5s;
}

.fade-enter-from,
.fade-leave-to {
    opacity: 0;
}

.fade-enter-to,
.fade-leave-from {
    opacity: 1;
}
</style>