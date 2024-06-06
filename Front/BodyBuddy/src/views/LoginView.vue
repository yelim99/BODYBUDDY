<template>
    <div class="loginHeader">
        <img src="@/assets/img/banner4.jpg" />
        <div class="category">
            <img src="@/assets/img/symbol2.png" />
            <span class="categoryA">Login</span>
            <span class="categoryB">Home &nbsp; > &nbsp; Login</span>
        </div>
    </div>
    <div class="loginContainer">
        <h4>로그인</h4>
        <div class="innerLogin">
            <div class="form-floating mb-3">
                <input
                    type="text"
                    id="userId"
                    class="form-control"
                    v-model="user.userId"
                />
                <label for="userId">ID</label>
            </div>
            <div class="form-floating mb-3">
                <input
                    type="password"
                    id="password"
                    class="form-control"
                    v-model="user.password"
                    @keyup.enter="login"
                />
                <label for="password">Password</label>
            </div>
            <br />
            <div>
                <button type="button" @click="login">로그인</button>
            </div>
            <br />
            <div>
                <p>아직 회원이 아닌가요?</p>
                <RouterLink :to="{ name: 'join' }" class="regBtn"
                    >회원가입</RouterLink
                >
            </div>
        </div>
    </div>
</template>

<script setup>
import { useUserStore } from "@/stores/user";
import { ref } from "vue";

const store = useUserStore();

const user = ref({
    userId: "",
    password: "",
});

const login = function () {
    store.login(user.value);
};
</script>

<style scoped>
* {
    font-family: "LINESeedKR-Rg";
}

h4 {
    margin-top: 20px;
    margin-bottom: 40px;
}

.loginHeader {
    width: 100%;
    height: 250px;
    text-align: center;
    font-weight: 700;
    position: relative;
}
.loginHeader img {
    width: 100%;
    height: 100%;
    object-fit: cover;
    display: block;
}
.loginHeader .category {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    flex-direction: column;
}

.loginHeader .category img {
  width: 25px;
  margin: 0 auto;
}

.loginHeader .category .categoryA {
    font-size: 2em;
}

.loginHeader .category .categoryB {
    font-size: 0.8em;
}

.loginContainer {
    text-align: center;
    border-radius: 10px; /* 모서리를 둥글게 만듭니다. */
    padding: 20px; /* 내부 여백을 추가하여 내용이 모서리에 가깝게 표시되지 않도록 합니다. */
    border: 1px solid #7fabb2; /* 테두리를 생성하고 색상을 지정합니다. */
    margin: 50px auto;
    width: 540px;
}

button,
.regBtn {
    display: inline-block;
    padding: 5px 10px;
    border-radius: 5px;
    background-color: #7fabb2;
    color: white;
    border: none;
    cursor: pointer;
    text-decoration: none;
    width: 100%;
}

.regBtn {
    background-color: #a9ddde;
    margin-bottom: 30px;
}

button:hover {
    background-color: #a9ddde;
    transition: background-color 0.3s;
}

.regBtn:hover {
    transition: background-color 0.3s;
    background-color: #7fabb2;
}

.loginContainer div p {
    margin-bottom: 5px;
}

.innerLogin {
    width: 80%;
    margin: auto;
}

p {
    color: #9f9f9f;
    font-size: 0.9em;
}
</style>
