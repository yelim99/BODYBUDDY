<template>
  <div class="myPageHeader">
    <img src="@/assets/img/banner4.jpg" />
    <div class="category">
      <img src="@/assets/img/symbol2.png" />
      <span class="categoryA">My Page</span>
      <span class="categoryB">Home &nbsp; > &nbsp; My Page</span>
    </div>
  </div>
  <div class="myPageContainer">
    <!-- 예림 추가 (사이드바) -->
    <div class="sideBar">
      <span class="cHead">Category</span>
      <span class="cName">
        <RouterLink :to="{ name: 'myRoutineList' }"> 내 루틴 관리 </RouterLink>
        <RouterLink :to="{ name: 'like' }">찜 목록</RouterLink>
        <RouterLink :to="{ name: 'userInfoEdit' }">회원 정보 수정</RouterLink>
      </span>
    </div>
    <RouterView />
  </div>
</template>

<script setup></script>

<style scoped>
* {
  font-family: "LINESeedKR-Rg";
}

.myPageHeader {
  /* border: 1px solid lightgray; */
  width: 100%;
  height: 250px;
  text-align: center;
  font-weight: 700;
  position: relative;
}
.myPageHeader img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
}
.myPageHeader .category {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  display: flex;
  flex-direction: column;
}

.myPageHeader .category img {
  width: 25px;
  margin: 0 auto;
}

.myPageHeader .category .categoryA {
  font-size: 2em;
}

.myPageHeader .category .categoryB {
  font-size: 0.8em;
}

.myPageHeader .bar span {
  margin-left: 70px;
  font-size: 0.8em;
  color: white;
  font-weight: 400;
}

.myPageContainer {
  display: flex;
  flex-direction: row;
  width: 100%;
}
.sideBar {
  /* border: 1px solid lightgray; */
  width: 15%;
  margin-left: 60px;
  display: flex;
  flex-direction: column;
  height: 200px;
  /* font-weight: bold; */
  margin-top: 70px;
  padding-left: 30px;
  font-weight: 600;
  font-style: normal;
}

.sideBar span {
  margin-bottom: 20px;
}

.sideBar .cHead {
  font-size: 1.4em;
  color: #7fabb2;
}
.sideBar .cName {
  display: flex;
  flex-direction: column;
}

.sideBar .cName a {
  font-size: 0.9em;
  color: #9f9f9f;
  text-decoration: none;
  margin-bottom: 20px;
}

.sideBar .cName a.router-link-active {
  color: #324b4f;
  font-weight: 700;
}

@media (max-width: 900px) {
  .myPageContainer {
    flex-direction: column; 
  }

  .sideBar {
    width: 100%;
    margin-left: 0; 
    margin-top: 50px;
    display: flex;
    flex-direction: row;
    height: 50px;
    justify-content: center;
    align-items: center;
  }

.sideBar .cHead {
  margin-bottom: 0px;
  margin-right: 30px;
}

.sideBar .cName {
  display: flex;
  flex-direction: row;
  margin-bottom: 0px;
}

.sideBar .cName a {
  font-size: 0.9em;
  color: #9f9f9f;
  text-decoration: none;
  margin-right: 30px;
  margin-bottom: 0px;
}

  .myPageContainer hr {
    width: 80%; 
  }
}

</style>
