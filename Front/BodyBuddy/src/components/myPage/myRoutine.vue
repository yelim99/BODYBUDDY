<template>
    <main>
      <div class="bar" v-if="store.myRoutineList.length > 0">
        <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-inner">
            <div 
              class="carousel-item" 
              v-for="(group, index) in groupedRoutines" 
              :class="{ active: index === 0 }"
              :key="index"
            >
              <div v-for="myRoutine in group" :key="myRoutine.routineId">
                <router-link :to="`/my-routine/${myRoutine.routineId}`">
                  {{ myRoutine.routineTitle }}
                </router-link>
                &nbsp;
              </div>
            </div>
          </div>
          <button v-if="store.myRoutineList.length > 4" class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button v-if="store.myRoutineList.length > 4" class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
        <div class="btn-class">
          <button @click="confirmAddRoutine" type="button" class="regBtn">
            루틴 등록하기
          </button>
        </div>
      </div>
      <div class="bar noRoutine" v-else>
        <div class="btn-class">
          <button type="button" @click="confirmAddRoutine" class="regBtn">
            루틴 등록하기
          </button>
        </div>
        <hr />
        내 루틴이 없습니다.
      </div>
      <hr>
      <div class="myBox">
        <router-view />
      </div>
    </main>
  </template>
  
  <script setup>
  import { computed, onMounted, nextTick } from 'vue';
  import { useRouter } from 'vue-router';
  import { useMyPageStore } from "@/stores/myPage";
  
  const store = useMyPageStore();
  const router = useRouter();
  
  onMounted(() => {
    store.getMyRoutines();
    if (store.myRoutineList.length > 0) {
      nextTick(() => {
        router.push(`/my-routine/${store.myRoutineList[0].routineId}`);
      });
    }
  });
  
  const groupedRoutines = computed(() => {
    const groupSize = 4;
    return store.myRoutineList.reduce((acc, item, index) => {
      const groupIndex = Math.floor(index / groupSize);
      if (!acc[groupIndex]) {
        acc[groupIndex] = [];
      }
      acc[groupIndex].push(item);
      return acc;
    }, []);
  });
  
  const confirmAddRoutine = () => {
    router.push(`/mypage/regist`);
  };


  var mql = window.matchMedia("screen and (max-width: 900px)");

if (mql.matches) {
	
}

  </script>


<style scoped>
* {
  font-family: "LINESeedKR-Rg";
}
main {
  width: 75%;
  margin-top: 40px;
}
main .bar {
  /* border: 1px solid lightgray; */
  width: 600px;
  margin: 10px auto;
  display: flex;
  flex-direction: row;
  align-items: center;
}

main hr {
  width: 600px;
  margin: 0 auto;
}

main .noRoutine {
  width: 70%;
  margin: 10px auto;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  /* border: 1px solid gray; */
  height: 100px;
  align-items: center;
}

main .noRoutine hr {
  width: 100%;
}

main .bar a {
  color: #9f9f9f;
  text-decoration: none;
  margin-right: 7px;
}

main .bar a.router-link-exact-active {
  color: #324b4f;
  font-weight: 700;
}

.myBox {
  /* border: 1px solid lightgray; */
  width: 550px;
  margin: 20px auto;
}
.bar .btn-class {
  margin-left: auto;
  /* border: 1px solid gray; */
}
.bar .regBtn {
  width: 110px;
  height: 30px;
  background-color: #7fabb2;
  border: 1px solid #7fabb2;
  border-radius: 5px;
  font-size: 0.8em;
  /* font-family: "TheJamsil2Light"; */
  color: white;
  margin-top: 5px;
}

.carousel-inner {
    /* border: 1px solid gray; */
    width: 480px;
    font-size: 0.9em;
}

.carousel-item.active, .carousel-item-start, .carousel-item-end {
    display: flex;
    flex-direction: row;
    justify-content: center;
}

.carousel-control-prev, .carousel-control-next {
    filter: invert(100%); 
    width: 20px;
}

#carouselExample {
  position: relative;
}

.carousel-control-prev, .carousel-control-next {
    position: absolute;
    top: 50%;
    transform: translateY(-50%); 
}

.carousel-control-prev {
    left: 10px; 
}

.carousel-control-next {
    right: 10px; 
}


@media (max-width: 900px) {
  main {
    margin: 30px  auto;
  }

  main .bar {
    flex-direction: row; 
    width: 100%; 
  }

  .carousel-inner {
    width: 480px;

  }

}

</style>
  