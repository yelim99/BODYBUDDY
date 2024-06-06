<template>
    <div :id="modalId" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">{{ myEx.exerciseName }}</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <span id="eName">🏃‍♂️ 운동 이름 : {{ myEx.exerciseName }} 🏃‍♂️ </span>
                    <span id="ePart">운동 부위 : {{ myEx.exercisePart }}</span>
                    <span id="eSet">{{ myEx.setCnt }} 세트</span>
                    <span id="eRep">{{ myEx.repetitions }} 회(시간)</span>
                    <span id="eWeight">{{ myEx.weight }} kg</span>
                    <span id="eTime">{{ myEx.dayOfTheWeek }} - {{ myEx.time }}</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
const props = defineProps({
    myEx: Object,
    modalId: String
})

</script>

<style scoped>
    * {
        font-family: "LINESeedKR-Rg";
    }
    .modal-body {
        display: flex;
        flex-direction: column;
        text-align: center;
    }

    .modal-body span {
        margin-bottom: 5px;
    }
    #eName {
        font-size: 1.5em;
        font-weight: bold;
    }

    #ePart, #eSet, #eRep, #eWeight, #eTime {
        font-size: 1.2em;
    }
</style>
