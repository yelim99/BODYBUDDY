<template>
    <div class="libraryHeader">
        <img src="@/assets/img/banner4.jpg">
        <div class="category">
            <img src="@/assets/img/symbol2.png">
            <span class="categoryA">Library</span>
            <span class="categoryB">Home &nbsp; > &nbsp; Library</span>
        </div>
    </div>
    <div class="searchBar">
        <input type="text" @input="updateSearch" placeholder="Search" class="search">
        <button class="searchBtn">검색</button>
    </div>
    <div class="container">
        <div class="partBtns">
            <button
                v-for="part in parts"
                :key="part"
                @click="selectedPart = part"
                :class="{ active: selectedPart === part }"
                class="partBtn">
            {{ part }}
            </button>
        </div>
        <div class="ex-container">
            <div class="ex-col" v-for="exercise in filteredExercises" :key="exercise.id">
                <span :for="exercise.id" class="ex-label">{{ exercise.exerciseName }}</span>
            </div>
        </div>
    </div>

</template>

<script setup>
import { ref, computed } from 'vue';
import { exercises } from '@/data/allExercises.js';

const search = ref('');
const selectedPart = ref('전체');
const parts = ['전체', '하체', '가슴', '등', '어깨', '팔', '복근', '유산소'];

const filteredExercises = computed(() => {
  return exercises.filter(exercise => (exercise.exercisePart === selectedPart.value || selectedPart.value === '전체') && exercise.exerciseName.includes(search.value));
});

const updateSearch = (event) => {
  search.value = event.target.value;
};

</script>

<style  scoped>
    * {
        font-family: "LINESeedKR-Rg";
    }

    .libraryHeader {
        /* border: 1px solid lightgray; */
        width: 100%;
        height: 250px;
        text-align: center;
        font-weight: 700;
        position: relative;
    }
    .libraryHeader img {
        width: 100%;
        height: 100%;
        object-fit: cover;
        display: block;
    }
    .libraryHeader .category {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        display: flex;
        flex-direction: column;
    }

    .libraryHeader .category img {
        width: 25px;
        margin: 0 auto;
    }

    .libraryHeader .category .categoryA {
        font-size: 2em;
    }

    .libraryHeader .category .categoryB {
        font-size: 0.8em;
    }

    .container {
        width: 690px;
        margin: 30px auto;
    }

    .searchBar {
        /* border: 1px solid lightblue; */
        background-color: #7FABB2;
        height: 60px;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
    }
    .searchBar .search {
        margin-right: 10px;
        width: 20%;
        padding: 3px 10px;
        font-size: 0.9em;
        border-radius: 5px;
        border: 1px solid lightgray;
    }
    .searchBar .searchBtn {
        background-color: #EEFEFF;
        border: 1px solid #EEFEFF;
        border-radius: 5px;
        font-size: 0.9em;
        width: 50px;
        height: 30px;
    }

    .partBtns {
        margin: 15px 0;
    }

    .partBtn {
        font-size: 1em;
        padding: 5px 10px;
        margin-left: 5px;
        color: #324B4F;
        background-color: #FFFFFF;
        border-radius: 20px;
        cursor: pointer;
        width: 11%;
    }

    .partBtn.active, .partBtn:hover {
        background-color: #324B4F;
        transition: background-color 0.3s;
        color: #FFFFFF;
    }

    .ex-container {
        display: flex;
        flex-wrap: wrap;
        margin: 20px auto;
    }

    .ex-col {
        width: 50%;
        padding: 5px;
    }

    .ex-label {
        font-size: 14px;
        color: #666;
    }
</style>