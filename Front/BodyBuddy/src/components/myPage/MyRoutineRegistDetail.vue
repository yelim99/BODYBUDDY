<template>
    <div class="info">
                    <div>
                        <span style="color: #7fabb2">{{ index + 1 }}</span
                        >&nbsp; <span>{{ exerciseOne.exercisePart }}</span
                        >&nbsp; | &nbsp;
                        <span>{{ exerciseOne.exerciseName }}</span>
                    </div>
                    <div>
                        <button
                            @click="$emit('deleteExercise', exerciseOne.id)"
                            class="remove-button"
                        >
                            -
                        </button>
                    </div>
                </div>
                <div>
                    <div class="exInfo">
                        <div class="input-group">
                            <label>세트</label>
                            <input
                                type="number"
                                v-model="exerciseOne.setCnt"
                                class="numInput"
                                min="0"
                            />
                        </div>
                        <div class="input-group">
                            <label>무게</label>
                            <div class="weight-input-group">
                                <input
                                    type="number"
                                    v-model="exerciseOne.weight"
                                    class="numInput"
                                    min="0"
                                />
                                <span>kg</span>
                            </div>
                        </div>
                        <div class="input-group">
                            <label>횟수(시간)</label>
                            <input
                                type="number"
                                v-model="exerciseOne.repetitions"
                                class="numInput"
                                min="0"
                            />
                        </div>
                    </div>
                    <div class="input-group">
                        <label>요일</label>
                        <div class="days">
                            <label
                                v-for="day in allDays"
                                :key="day"
                                class="day-label"
                            >
                                <input
                                    type="checkbox"
                                    :value="day"
                                    @change="() => toggleDay(exerciseOne, day)"
                                    :checked="
                                        exerciseOne.dayOfTheWeek.includes(day)
                                    "
                                    class="dayCheck"
                                />
                                {{ day }}
                            </label>
                        </div>
                    </div>
                    <div class="input-group">
                        <label for="floatingSelectGrid"
                            >시간</label
                        >&nbsp;
                        <div class="selectBox">
                            <select
                                id="floatingSelectGrid"
                                class="timeInput"
                                v-model="exerciseOne.time"
                            >
                                <option value="">선택</option>
                                <option value="오전">오전</option>
                                <option value="오후">오후</option>
                                <option value="저녁">저녁</option>
                            </select>
                        </div>
                    </div>
                </div>     
</template>

<script setup>
    const { exerciseOne, index } = defineProps(['exerciseOne', 'index']);
    const emit = defineEmits(['deleteExercise']);

    const allDays = ["월", "화", "수", "목", "금", "토", "일"];

    const toggleDay = (exerciseOne, day) => {
        const index = exerciseOne.dayOfTheWeek.indexOf(day);
        if (index === -1) {
            exerciseOne.dayOfTheWeek.push(day);
        } else {
            exerciseOne.dayOfTheWeek.splice(index, 1);
        }
    };

</script>

<style scoped>
    .info {
        display: flex;
        justify-content: space-between;
        font-weight: bold;
        align-items: center;
        margin-bottom: 10px;
    }

    .exInfo {
        display: flex;
        justify-content: space-around;
    }

    .numInput,
    .timeInput {
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px !important;
        width: 90px;
        margin: 10px auto;
    }

    .weight-input-group {
        display: flex;
        align-items: center;
    }

    .weight-input-group span {
        margin-left: 5px;
    }

    .input-group {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
    }

    .input-group label {
        margin-right: 10px;
    }

    .day-label {
        margin-right: 10px;
        display: flex;
        flex-direction: row;
        justify-content: center;
    }

    .dayCheck {
        margin-left: 15px;
        margin-right: 7px;
        width: 17px;
        height: 17px;
        border: 2px solid #7fabb2;
        border-radius: 5px;
        accent-color: #324b4f;
        margin-top: 2px;
    }
    

    .days {
        display: flex;
        flex-wrap: wrap;
        align-items: center;
    }

    .remove-button {
        background-color: #ffffff;
        border: none;
        font-weight: bold;
        cursor: pointer;
        font-size: 20px;
    }

    .remove-button:hover {
        background-color: #ffffff;
    }
    
</style>