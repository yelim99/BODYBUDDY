import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from "axios";
import router from "@/router";
import Swal from 'sweetalert2';

const REST_MYPAGE_API = `http://localhost:8080/mypage`;

export const useMyPageStore = defineStore(
    "myPage",
    () => {
        const myRoutineList = ref([]);

        const getMyRoutines = function () {
            axios.get(`${REST_MYPAGE_API}/my-routine`).then((response) => {
                myRoutineList.value = response.data;
            });
        };

        const myRoutine = ref({});

        const getMyRoutine = async (routineId) => {
            myRoutine.value = {}; // 초기화
            await axios
                .get(`${REST_MYPAGE_API}/my-routine/${routineId}`)
                .then((response) => {
                    myRoutine.value = response.data;
                });
        };

        const addRoutine = function (exercises, routineTitle, description) {
            axios
                .post(`${REST_MYPAGE_API}/my-routine/regist`)
                .then((response) => {
                    const routineId = response.data;
                    addExercises(
                        routineId,
                        exercises,
                        routineTitle,
                        description
                    );
                    router.push(`/mypage`);
                })
                .catch(() => {
                });
        };

        const updateRoutine = function (
            exercises,
            routineTitle,
            description,
            routineId
        ) {
            axios
                .put(
                    `${REST_MYPAGE_API}/my-routine/update/${routineId}`,
                    exercises,
                    {
                        params: {
                            routineTitle: routineTitle,
                            description: description,
                        },
                    }
                )
                .then(() => {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "루틴 수정이 완료되었습니다.",
                        confirmButtonColor: "#7fabb2",
                        timer: 1500,
                        backdrop: 'rgba(0,0,0,0.75)',
                        width: 450
                    });
                    router.push(`/my-routine`);
                })
                .catch(() => {
                    router.push(`/my-routine`);
                });
        };

        const deleteRoutine = async (routineId) => {
            await axios
                .delete(`${REST_MYPAGE_API}/my-routine/${routineId}`)
                .then(() => {
                    Swal.fire({
                        title: "삭제되었습니다.",
                        timer: 1500,
                        icon: "success",
                        confirmButtonColor: "#7fabb2",
                        width: 450
                    });
                    getMyRoutines();
                    router.push(`{ name: "myRoutineList" }`);
                })
                .catch((error) => {
                    console.error(error);
                });
        };

        const addExercises = function (
            routineId,
            exercises,
            routineTitle,
            description
        ) {
            axios
                .post(
                    `${REST_MYPAGE_API}/my-routine/regist/${routineId}`,
                    exercises
                )
                .then(() => {
                    updateText(routineId, routineTitle, description);
                })
                .catch(() => {
                });
        };

        // null 빼면 데이터 똑바로 안 감
        const updateText = function (routineId, routineTitle, description) {
            axios
                .put(
                    `${REST_MYPAGE_API}/my-routine/update-text/${routineId}`,
                    null,
                    {
                        params: {
                            routineTitle: routineTitle,
                            description: description,
                        },
                    }
                )
                .then(() => {
                    Swal.fire({
                        position: "center",
                        icon: "success",
                        title: "루틴 등록이 완료되었습니다.",
                        confirmButtonColor: "#7fabb2",
                        timer: 1500,
                        backdrop: 'rgba(0,0,0,0.75)',
                        width: 450
                    });
                    router.push(`/my-routine`);
                })
                .catch(() => {
                });
        };

        return {
            myRoutineList,
            getMyRoutines,
            myRoutine,
            getMyRoutine,
            addRoutine,
            updateRoutine,
            deleteRoutine,
            addExercises,
            updateText,
        };
    },
    {
        persist: true,
    }
);
