# 유저

insert into users
values ('yelim123', 'yelim123', '민예림', 'yelim', 'yelim12@naver.com');

insert into users
values ('jaehyun12', 'jaehyun12', '김재현', 'Spiral', 'kimjaehyun158@gmail.com');

insert into users
values ('wngud1225', 'wngud1225', '홍주형', '레전드홍쪽이', 'wngud1225@gmail.com');

insert into users
values ('sh123456', 'sh123456', '신승호', '엠티무새', 'sh123456@gmail.com');

# 루틴 1

insert into routines (user_id, routine_title, description)
values ('yelim123', '헬스 초보 루틴', '뉴비에용');

# 운동 1

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (1, '스쿼트', '하체', '10', '80', '20', ('월,수,금'), '오전');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (1, '벤치프레스', '가슴', '5', '100', '20', ('화,목,토'), '오후');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (1, '데드리프트', '하체', '20', '120', '10', ('월,수,금'), '저녁');

# 리뷰 1

insert into reviews (routine_id, user_id, nickname, content)
values ('1', 'jaehyun12', 'Spiral', '너무 좋아요');

insert into reviews (routine_id, user_id, nickname, content)
values ('1', 'wngud1225', '레전드홍쪽이', '운동 그렇게 하는 거 아닌데...');

# 루틴 2
        
insert into routines (user_id, routine_title, description)
values ('jaehyun12', '3분할', '하체는 안 한다는 마인드~');

# 운동 2

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (2, '랫풀다운', '등', '5', '30', '20', ('월,목'), '오전');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (2, '벤치프레스', '가슴', '10', '30', '12', ('화,금'), '오전');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (2, '덤벨 숄더 프레스', '어깨', '10', '40', '12', ('수,토'), '오전');

# 리뷰 2

insert into reviews (routine_id, user_id, nickname, content)
values ('2', 'yelim123', 'yelim', '하체도 해야겠지?');

insert into reviews (routine_id, user_id, nickname, content)
values ('2', 'wngud1225', '레전드홍쪽이', '밸런스도 신경 쓰셔야합니다.');

# 루틴 3

insert into routines (user_id, routine_title, description)
values ('yelim123', '강력한 예림이 만들기', '강력한 예림이 프로젝트');

# 운동 3

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (3, '푸시업', '가슴', '5', '0', '20', ('월,수,금'), '저녁');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (3, '스쿼트', '하체', '10', '10', '12', ('화,목,토'), '저녁');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (3, '달리기', '유산소', '0', '0', '60', ('토,일'), '오후');

# 리뷰 3

insert into reviews (routine_id, user_id, nickname, content)
values ('3', 'wngud1225', '레전드홍쪽이', '강력한 예일리');

insert into reviews (routine_id, user_id, nickname, content)
values ('3', 'jaehyun12', 'Spiral', '가보자~ 가보자~');


# 루틴 4

insert into routines (user_id, routine_title, description)
values ('jaehyun12', '맨몸 조지기', '맨몸운동만 해요');

# 운동 4

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (4, '에어 바이크', '복근', '10', '0', '20', ('월,수,금'), '오전');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (4, '푸시업', '상체', '5', '0', '20', ('월,수,금'), '저녁');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (4, '플랭크', '복근', '3', '0', '60', ('화,목'), '오후');

# 리뷰 4

insert into reviews (routine_id, user_id, nickname, content)
values ('4', 'wngud1225', '레전드홍쪽이', '너무 좋은데?');

insert into reviews (routine_id, user_id, nickname, content)
values ('4', 'yelim123', 'yelim', '초보자도 따라할 만 해요');
        
# 루틴 5

insert into routines (user_id, routine_title, description)
values ('yelim123', '무분할', '한 주에 2번 무분할 운동 ㄱㄱ');

# 운동 5

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (5, '덤벨 컬', '팔', '10', '10', '20', ('화,목'), '오전');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (5, '인클라인 벤치프레스', '가슴', '10', '30', '20', ('화,목'), '오후');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (5, '원암 덤벨 로우', '등', '10', '20', '20', ('화,목'), '저녁');

# 리뷰 5

insert into reviews (routine_id, user_id, nickname, content)
values ('5', 'jaehyun12', 'Spiral', '잘 보고 갑니다~');

insert into reviews (routine_id, user_id, nickname, content)
values ('5', 'wngud1225', '레전드홍쪽이', '루틴 그대로 따라했더니 몸짱됐어요~');

# 루틴 6

insert into routines (user_id, routine_title, description)
values ('jaehyun12', '다이어트용', '유산소만 한가득');

# 운동 6

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (6, '계단 오르기', '유산소', '0', '0', '30', ('토'), '오후');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (6, '줄넘기', '유산소', '1', '0', '2000', ('월,수,금'), '저녁');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (6, '러닝 머신', '유산소', '0', '0', '50', ('일'), '오전');

# 리뷰 6

insert into reviews (routine_id, user_id, nickname, content)
values ('6', 'wngud1225', '레전드홍쪽이', '살 한 번 빼보자!');

insert into reviews (routine_id, user_id, nickname, content)
values ('6', 'yelim123', 'yelim', '가즈아~');


# 루틴 7
insert into routines (user_id, routine_title, description)
values ('sh123456', '운동 시러', '운동은 싫지만 운동을 해야겠죠....ㅜ');

# 운동 7
insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (7, '크런치', '복근', '10', 0, '20', ('월,수'), '오후');

insert into exercises (routine_id, exercise_name, exercise_part, 
					set_cnt, weight, repetitions, day_of_the_week, time)
values (7, '레그 프레스', '하체', '10', '100', '20', ('목,금'), '저녁');


select * from users;
select * from routines;				
select * from exercises;