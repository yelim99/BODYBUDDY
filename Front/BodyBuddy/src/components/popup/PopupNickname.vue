<template>
  <div class="item">
    <div>
        <p>닉네임은 특수문자 제외 2~8자로 입력해주세요.</p>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="userNickname" @input="nicknameValid(user.nickname)" v-model="user.nickname" placeholder="특수문자 제외 2~8자">
            <label for="userNickname">nickname</label>
          </div>
        </div>
        <div v-if="nicknameFlag === 0">
          <small>&nbsp;</small>
        </div>
        <div v-else-if="nicknameFlag === 1">
          <small class="color-green">형식에 맞는 닉네임입니다.</small>
        </div>
        <div v-else-if="nicknameFlag === 2">
          <small class="color-red">닉네임을 입력해주세요.</small>
        </div>
        <div v-else-if="nicknameFlag === 3">
          <small class="color-red">닉네임은 특수문자 제외 2~8자로 입력해주세요.</small>
        </div>
        <div v-else-if="nicknameFlag === 4">
          <small class="color-red">이미 사용 중인 닉네임입니다.</small>
        </div>
        <div v-else-if="nicknameFlag === 5">
          <div>
            <small class="color-green">사용 가능한 닉네임입니다.</small>
          </div>
          <button id="useBtn" @click="closeWindow(user.nickname)">사용하기</button>
        </div>
        <button @click="checkNicknameValid(user.nickname)" :disabled="nicknameFlag !== 1" :hidden="nicknameFlag === 5">중복 확인</button>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user';
import { ref } from 'vue';

const store = useUserStore()

const user = ref({
  nickname: '',
})
const nicknameFlag = ref(0)
const nicknameValid = function(nickname){
  if (/^[가-힣a-zA-Z0-9]{2,8}$/.test(nickname)) {
    nicknameFlag.value = 1
  } 
  else if(!nickname){
    nicknameFlag.value = 2
  }
  else {
    nicknameFlag.value = 3
  }
}

const checkNicknameValid = function(nickname){
  store.checkDuplicateNickname(nickname)
    .then((isNotDuplicate) => {
      if (isNotDuplicate) {
        nicknameFlag.value = 5;
      } else {
        nicknameFlag.value = 4;
      }
    })
    .catch(() => {});
}

const closeWindow = function(nickname)  {
  store.storeNickname(nickname)
  window.opener.postMessage({ type: 'nicknameUpdate', nickname: nickname }, '*');
  window.close();
}

</script>

<style scoped>
* {
        font-family: 'SUITE-Regular';
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
  background-color: #A9DDDE;
  color: white;
  border: none;
  cursor: pointer;
}

button:disabled {
  cursor: not-allowed;
}

#useBtn {
  background-color: #7FABB2;
}

.color-red{
 color: red;
}

.color-green{
 color:green;
}

.color-black{
 color:black;
}
</style>