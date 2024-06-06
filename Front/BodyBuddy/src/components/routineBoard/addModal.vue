<template>
    <div id="addToMineModal" class="modal fade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">내 루틴에 추가</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label for="rTitle" class="form-label">루틴 제목</label>
                    <input type="text" id="rTitle" name="routineTitle" v-model="myRoutine.routineTitle" class="form-control" placeholder="제목을 입력하세요." required>
                    <label for="rDes" class="form-label">루틴 설명</label>
                    <textarea id="rDes" name="description" rows="3" v-model="myRoutine.description" class="form-control" placeholder="설명을 입력하세요." required></textarea>
                
                </div>
                <div class="modal-footer">
                    <button id="regBtn" class="btn btn-primary myAddBtn" @click="add" data-bs-dismiss="modal">내 루틴에 추가</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
    import { useBoardStore } from '@/stores/board';
    import { ref } from 'vue'


    const props = defineProps({
        myRid: Object
    })

    const myRoutine = ref({
        originRId: props.myRid,
        routineTitle: '',
        description: ''
    })

    const store = useBoardStore()

    const add = () => {
    store.addMyRoutine(myRoutine.value)
        .then(() => {
            myRoutine.value.routineTitle = '';
            myRoutine.value.description = '';
        })
        .catch(() => {})
};
</script>

<style scoped>
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
    
    .modal-body label {
        text-align: left;
        font-weight: bold;
    }
    .modal-body #rTitle {
        width: 70%;
        margin-bottom: 20px;
    }
    
    .btn {
        border: none;
    }

    #regBtn {
        background-color: #7fabb2;
        color: white;
        cursor: pointer;
    }

    #regBtn:hover {
        background-color: #a9ddde;
        transition: background-color 0.3s;
    }

</style>
