create table student(
	studentId varchar2(50) primary key --학생 아이디
	,name varchar2(50) not null --학생 이름
	,gradeLevel number(38) not null --학생 학년
	,balance number(38) not null --등록금 잔액
);

create table student_courses(
	Id varchar2(50) primary key
	,courses varchar2(50) not null --과목
);

create sequence studentId_seq
start with 1
increment by 1
nocache;

drop sequence studentId_seq;
drop sequence studentId2_seq;

create sequence studentId2_seq
start with 1
increment by 1
nocache;

select studentId_seq.nextval from dual;

select studentId2_seq.nextval from dual;

select * from student order by studentId;

select * from student_courses order by Id;

