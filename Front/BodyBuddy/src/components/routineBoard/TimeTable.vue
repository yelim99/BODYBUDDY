<template>
  <table class="table">
    <tr>
      <th></th>
      <th>월</th>
      <th>화</th>
      <th>수</th>
      <th>목</th>
      <th>금</th>
      <th>토</th>
      <th>일</th>
    </tr>
    <tbody>
      <tr>
        <td>오전</td>
        <td>
          <div
            v-if="mon1 && mon1.length > 0"
            :class="{
              isExist: isExist(
                mon1[0].dayOfTheWeek,
                mon1[0].time,
                '월',
                '오전'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                mon1[0].dayOfTheWeek,
                mon1[0].time,
                '월',
                '오전'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalMon1">{{
              mon1[0].exerciseName
            }}</span>
            <Modal :my-ex="mon1[0]" modal-id="modalMon1" />
          </div>
        </td>
        <td>
          <div
            v-if="tue1 && tue1.length > 0"
            :class="{
              isExist: isExist(
                tue1[0].dayOfTheWeek,
                tue1[0].time,
                '화',
                '오전'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                tue1[0].dayOfTheWeek,
                tue1[0].time,
                '화',
                '오전'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalTue1">{{
              tue1[0].exerciseName
            }}</span>
            <Modal :my-ex="tue1[0]" modal-id="modalTue1" />
          </div>
        </td>
        <td>
          <div
            v-if="wed1 && wed1.length > 0"
            :class="{
              isExist: isExist(
                wed1[0].dayOfTheWeek,
                wed1[0].time,
                '수',
                '오전'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                wed1[0].dayOfTheWeek,
                wed1[0].time,
                '수',
                '오전'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalWed1">{{
              wed1[0].exerciseName
            }}</span>
            <Modal :my-ex="wed1[0]" modal-id="modalWed1" />
          </div>
        </td>
        <td>
          <div
            v-if="thu1 && thu1.length > 0"
            :class="{
              isExist: isExist(
                thu1[0].dayOfTheWeek,
                thu1[0].time,
                '목',
                '오전'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                thu1[0].dayOfTheWeek,
                thu1[0].time,
                '목',
                '오전'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalThu1">{{
              thu1[0].exerciseName
            }}</span>
            <Modal :my-ex="thu1[0]" modal-id="modalThu1" />
          </div>
        </td>
        <td>
          <div
            v-if="fri1 && fri1.length > 0"
            :class="{
              isExist: isExist(
                fri1[0].dayOfTheWeek,
                fri1[0].time,
                '금',
                '오전'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                fri1[0].dayOfTheWeek,
                fri1[0].time,
                '금',
                '오전'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalFri1">{{
              fri1[0].exerciseName
            }}</span>
            <Modal :my-ex="fri1[0]" modal-id="modalFri1" />
          </div>
        </td>
        <td>
          <div
            v-if="sat1 && sat1.length > 0"
            :class="{
              isExist: isExist(
                sat1[0].dayOfTheWeek,
                sat1[0].time,
                '토',
                '오전'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                sat1[0].dayOfTheWeek,
                sat1[0].time,
                '토',
                '오전'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalSat1">{{
              sat1[0].exerciseName
            }}</span>
            <Modal :my-ex="sat1[0]" modal-id="modalSat1" />
          </div>
        </td>
        <td>
          <div
            v-if="sun1 && sun1.length > 0"
            :class="{
              isExist: isExist(
                sun1[0].dayOfTheWeek,
                sun1[0].time,
                '일',
                '오전'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                sun1[0].dayOfTheWeek,
                sun1[0].time,
                '일',
                '오전'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalSun1">{{
              sun1[0].exerciseName
            }}</span>
            <Modal :my-ex="sun1[0]" modal-id="modalSun1" />
          </div>
        </td>
      </tr>
      <tr>
        <td>오후</td>
        <td>
          <div
            v-if="mon2 && mon2.length > 0"
            :class="{
              isExist: isExist(
                mon2[0].dayOfTheWeek,
                mon2[0].time,
                '월',
                '오후'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                mon2[0].dayOfTheWeek,
                mon2[0].time,
                '월',
                '오후'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalMon2">{{
              mon2[0].exerciseName
            }}</span>
            <Modal :my-ex="mon2[0]" modal-id="modalMon2" />
          </div>
        </td>
        <td>
          <div
            v-if="tue2 && tue2.length > 0"
            :class="{
              isExist: isExist(
                tue2[0].dayOfTheWeek,
                tue2[0].time,
                '화',
                '오후'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                tue2[0].dayOfTheWeek,
                tue2[0].time,
                '화',
                '오후'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalTue2">{{
              tue2[0].exerciseName
            }}</span>
            <Modal :my-ex="tue2[0]" modal-id="modalTue2" />
          </div>
        </td>
        <td>
          <div
            v-if="wed2 && wed2.length > 0"
            :class="{
              isExist: isExist(
                wed2[0].dayOfTheWeek,
                wed2[0].time,
                '수',
                '오후'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                wed2[0].dayOfTheWeek,
                wed2[0].time,
                '수',
                '오후'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalWed2">{{
              wed2[0].exerciseName
            }}</span>
            <Modal :my-ex="wed2[0]" modal-id="modalWed2" />
          </div>
        </td>
        <td>
          <div
            v-if="thu2 && thu2.length > 0"
            :class="{
              isExist: isExist(
                thu2[0].dayOfTheWeek,
                thu2[0].time,
                '목',
                '오후'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                thu2[0].dayOfTheWeek,
                thu2[0].time,
                '목',
                '오후'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalThu2">{{
              thu2[0].exerciseName
            }}</span>
            <Modal :my-ex="thu2[0]" modal-id="modalThu2" />
          </div>
        </td>
        <td>
          <div
            v-if="fri2 && fri2.length > 0"
            :class="{
              isExist: isExist(
                fri2[0].dayOfTheWeek,
                fri2[0].time,
                '금',
                '오후'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                fri2[0].dayOfTheWeek,
                fri2[0].time,
                '금',
                '오후'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalFri2">{{
              fri2[0].exerciseName
            }}</span>
            <Modal :my-ex="fri2[0]" modal-id="modalFri2" />
          </div>
        </td>
        <td>
          <div
            v-if="sat2 && sat2.length > 0"
            :class="{
              isExist: isExist(
                sat2[0].dayOfTheWeek,
                sat2[0].time,
                '토',
                '오후'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                sat2[0].dayOfTheWeek,
                sat2[0].time,
                '토',
                '오후'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalSat2">{{
              sat2[0].exerciseName
            }}</span>
            <Modal :my-ex="sat2[0]" modal-id="modalSat2" />
          </div>
        </td>
        <td>
          <div
            v-if="sun2 && sun2.length > 0"
            :class="{
              isExist: isExist(
                sun2[0].dayOfTheWeek,
                sun2[0].time,
                '일',
                '오후'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                sun2[0].dayOfTheWeek,
                sun2[0].time,
                '일',
                '오후'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalSun2">{{
              sun2[0].exerciseName
            }}</span>
            <Modal :my-ex="sun2[0]" modal-id="modalSun2" />
          </div>
        </td>
      </tr>
      <tr>
        <td>저녁</td>
        <td>
          <div
            v-if="mon3 && mon3.length > 0"
            :class="{
              isExist: isExist(
                mon3[0].dayOfTheWeek,
                mon3[0].time,
                '월',
                '저녁'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                mon3[0].dayOfTheWeek,
                mon3[0].time,
                '월',
                '저녁'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalMon3">{{
              mon3[0].exerciseName
            }}</span>
            <Modal :my-ex="mon3[0]" modal-id="modalMon3" />
          </div>
        </td>
        <td>
          <div
            v-if="tue3 && tue3.length > 0"
            :class="{
              isExist: isExist(
                tue3[0].dayOfTheWeek,
                tue3[0].time,
                '화',
                '저녁'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                tue3[0].dayOfTheWeek,
                tue3[0].time,
                '화',
                '저녁'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalTue3">{{
              tue3[0].exerciseName
            }}</span>
            <Modal :my-ex="tue3[0]" modal-id="modalTue3" />
          </div>
        </td>
        <td>
          <div
            v-if="wed3 && wed3.length > 0"
            :class="{
              isExist: isExist(
                wed3[0].dayOfTheWeek,
                wed3[0].time,
                '수',
                '저녁'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                wed3[0].dayOfTheWeek,
                wed3[0].time,
                '수',
                '저녁'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalWed3">{{
              wed3[0].exerciseName
            }}</span>
            <Modal :my-ex="wed3[0]" modal-id="modalWed3" />
          </div>
        </td>
        <td>
          <div
            v-if="thu3 && thu3.length > 0"
            :class="{
              isExist: isExist(
                thu3[0].dayOfTheWeek,
                thu3[0].time,
                '목',
                '저녁'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                thu3[0].dayOfTheWeek,
                thu3[0].time,
                '목',
                '저녁'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalThu3">{{
              thu3[0].exerciseName
            }}</span>
            <Modal :my-ex="thu3[0]" modal-id="modalThu3" />
          </div>
        </td>
        <td>
          <div
            v-if="fri3 && fri3.length > 0"
            :class="{
              isExist: isExist(
                fri3[0].dayOfTheWeek,
                fri3[0].time,
                '금',
                '저녁'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                fri3[0].dayOfTheWeek,
                fri3[0].time,
                '금',
                '저녁'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalFri3">{{
              fri3[0].exerciseName
            }}</span>
            <Modal :my-ex="fri3[0]" modal-id="modalFri3" />
          </div>
        </td>
        <td>
          <div
            v-if="sat3 && sat3.length > 0"
            :class="{
              isExist: isExist(
                sat3[0].dayOfTheWeek,
                sat3[0].time,
                '토',
                '저녁'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                sat3[0].dayOfTheWeek,
                sat3[0].time,
                '토',
                '저녁'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalSat3">{{
              sat3[0].exerciseName
            }}</span>
            <Modal :my-ex="sat3[0]" modal-id="modalSat3" />
          </div>
        </td>
        <td>
          <div
            v-if="sun3 && sun3.length > 0"
            :class="{
              isExist: isExist(
                sun3[0].dayOfTheWeek,
                sun3[0].time,
                '일',
                '저녁'
              ),
            }"
            :style="{
              backgroundColor: isExist(
                sun3[0].dayOfTheWeek,
                sun3[0].time,
                '일',
                '저녁'
              )
                ? randomBrightColor()
                : '',
            }"
          >
            <span data-bs-toggle="modal" data-bs-target="#modalSun3">{{
              sun3[0].exerciseName
            }}</span>
            <Modal :my-ex="sun3[0]" modal-id="modalSun3" />
          </div>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import Modal from "@/components/routineBoard/Modal.vue";

// Props 선언
const props = defineProps({
  exercises: Array,
});

const isExist = (day, time, targetDay, targetTime) => {
  return day.includes(targetDay) && time === targetTime;
};

let randomBrightColor = () => {
  let color_r = Math.floor(Math.random() * 127 + 128).toString(16);
  let color_g = Math.floor(Math.random() * 127 + 128).toString(16);
  let color_b = Math.floor(Math.random() * 127 + 128).toString(16);
  return `#${color_r + color_g + color_b}`;
};

const mon1 = ref({});
const mon2 = ref({});
const mon3 = ref({});

const tue1 = ref({});
const tue2 = ref({});
const tue3 = ref({});

const wed1 = ref({});
const wed2 = ref({});
const wed3 = ref({});

const thu1 = ref({});
const thu2 = ref({});
const thu3 = ref({});

const fri1 = ref({});
const fri2 = ref({});
const fri3 = ref({});

const sat1 = ref({});
const sat2 = ref({});
const sat3 = ref({});

const sun1 = ref({});
const sun2 = ref({});
const sun3 = ref({});

onMounted(async () => {
  await updateExerciseData();
  console.log(fri1.value)
});

const updateExerciseData = () => {
  mon1.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "월", "오전");
  });
  mon2.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "월", "오후");
  });
  mon3.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "월", "저녁");
  });

  tue1.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "화", "오전");
  });
  tue2.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "화", "오후");
  });
  tue3.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "화", "저녁");
  });

  wed1.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "수", "오전");
  });
  wed2.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "수", "오후");
  });
  wed3.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "수", "저녁");
  });

  thu1.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "목", "오전");
  });
  thu2.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "목", "오후");
  });
  thu3.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "목", "저녁");
  });

  fri1.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "금", "오전");
  });
  fri2.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "금", "오후");
  });
  fri3.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "금", "저녁");
  });

  sat1.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "토", "오전");
  });
  sat2.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "토", "오후");
  });
  sat3.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "토", "저녁");
  });

  sun1.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "일", "오전");
  });
  sun2.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "일", "오후");
  });
  sun3.value = props.exercises.filter((ex) => {
    return isExist(ex.dayOfTheWeek, ex.time, "일", "저녁");
  });
};


</script>

<style scoped>
*{
  font-family: "LINESeedKR-Rg";
}
.table {
  /* background: transparent !important; */
  --bs-table-bg: none;
}
table {
  width: 95%;
  height: 250px;
  font-family: "LINESeedKR-Rg";
  margin: 10px auto;
}
table th {
  text-align: center;
  border: 1px solid lightgray;
}

table td {
  height: 40px;
  padding: 0;
  vertical-align: middle;
  text-align: center;
  font-size: 0.9em;
  width: 12%;
  border: 1px solid lightgray;
}

table td:first-child {
    width: 9.5%;
}

td div {
  width: 100%;
  height: 100%;
  font-weight: 500;
}

.isExist {
  width: 100%;
  height: 100%;
  font-size: 0.95em;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 1px;
  /* background-color: #e7f0ff; */
}

.isExist span:hover {
  cursor: pointer;
  text-decoration: underline;
}

</style>
