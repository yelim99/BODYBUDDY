<template>
  <hr class="footerhr">
  <div class="footerBox">
    <div class="leftBox">
      <span class="name">
        <RouterLink :to="{ name: 'home'}">
            <img src="@/assets/img/logo4.png">
        </RouterLink></span>
      <p class="description">
        서울시 강남구 테헤란로 212<br/>
        BODYBUDDY<br/>
        예림, 재현
      </p>
    </div>

    <div class="rightBox">
      <span class="links">Links</span>
      <p class="category">
        <RouterLink :to="{ name: 'home'}">Home</RouterLink> 
        <RouterLink :to="{ name: 'routineList'}">Routines</RouterLink>
        <RouterLink :to="{ name: 'Library'}">Library</RouterLink>
      </p>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
*{
  font-family: "LINESeedKR-Rg";
}
.footerhr {
  margin-top: 150px;
}
.footerBox {
  margin-top: 40px;
  display: flex;
  flex-direction: row;
  margin-bottom: 50px;
}

.footerBox .leftBox {
  display: flex;
  flex-direction: column;
  margin-left: 50px;
  /* border: 1px solid gray; */
  width: 330px;
}

.footerBox .leftBox .name {
  font-weight: bold;
  font-size: 1.2em;
}

.name img {
    width: 160px;
}

.footerBox .leftBox p, .footerBox .rightBox p {
  margin: 0;
}

.footerBox .leftBox .description {
  color: gray;
  font-size: 0.9em;
  margin-top: 30px;
}


.footerBox .rightBox {
  /* border: 1px solid gray; */
  width: 400px;
  margin-top: 10px;
}

.footerBox .rightBox .links {
  color: gray;
  font-size: 0.9em;
}

.footerBox .rightBox .category {
  margin-top: 50px;
}

.footerBox .rightBox .category a {
  color: black;
  text-decoration: none;
  font-weight: bold;
  margin-right: 30px;
}

.footerBox .rightBox .category a:hover {
  text-decoration: underline;
}

</style>
