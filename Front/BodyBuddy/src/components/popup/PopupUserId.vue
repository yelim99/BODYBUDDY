<template>
    <div class="item">
        <div>
            <p>아이디는 알파벳 소문자, 숫자 6~12자로 입력해주세요.</p>
            <div class="form-floating mb-3">
                <input
                    type="text"
                    class="form-control"
                    id="userId"
                    @input="userIdValid(user.userId)"
                    v-model="user.userId"
                    placeholder="알파벳 소문자, 숫자 6~12자"
                />
                <label for="userId">ID</label>
            </div>
        </div>
        <div v-if="userIdFlag === 0">
            <small>&nbsp;</small>
        </div>
        <div v-else-if="userIdFlag === 1">
            <small class="color-green">형식에 맞는 아이디입니다.</small>
        </div>
        <div v-else-if="userIdFlag === 2">
            <small class="color-red">아이디를 입력해주세요.</small>
        </div>
        <div v-else-if="userIdFlag === 3">
            <small class="color-red"
                >아이디는 알파벳 소문자, 숫자 6~12자로 입력해주세요.</small
            >
        </div>
        <div v-else-if="userIdFlag === 4">
            <small class="color-red">이미 사용 중인 아이디입니다.</small>
        </div>
        <div v-else-if="userIdFlag === 5">
            <div>
                <small class="color-green">사용 가능한 아이디입니다.</small>
            </div>
            <button id="useBtn" @click="closeWindow(user.userId)">
                사용하기
            </button>
        </div>
        <button
            @click="checkUserIdValid(user.userId)"
            :disabled="userIdFlag !== 1"
            :hidden="userIdFlag === 5"
        >
            중복 확인
        </button>
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { ref } from "vue";

const store = useUserStore();

const user = ref({
    userId: "",
});

const userIdFlag = ref(0);
const userIdValid = function (userId) {
    if (/^[a-zA-Z0-9]{6,12}$/.test(userId)) {
        userIdFlag.value = 1;
    } else if (!userId) {
        userIdFlag.value = 2;
    } else {
        userIdFlag.value = 3;
    }
};

const checkUserIdValid = function (userId) {
    store
        .checkDuplicateUserId(userId)
        .then((isNotDuplicate) => {
            if (isNotDuplicate) {
                userIdFlag.value = 5;
            } else {
                userIdFlag.value = 4;
            }
        })
        .catch(() => {});
};

const closeWindow = function (userId) {
    store.storeUserId(userId);
    window.opener.postMessage({ type: "userIdUpdate", userId: userId }, "*");
    window.close(); // 현재 창 닫기
};
</script>

<style scoped>
* {
    font-family: "SUITE-Regular";
}

.item {
    text-align: center;
    width: 60%;
    margin: 20px auto;
}

button {
    margin-left: 10px;
    margin-top: 10px;
    padding: 5px 10px;
    border-radius: 5px;
    background-color: #a9ddde;
    color: white;
    border: none;
    cursor: pointer;
}

button:disabled {
    cursor: not-allowed;
}

#useBtn {
    background-color: #7fabb2;
}

.color-red {
    color: red;
}

.color-green {
    color: green;
}

.color-black {
    color: black;
}
</style>
