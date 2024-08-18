drop table if exists user;
create table user(
  `id` int auto_increment comment '用户编号',
  `user_name` varchar(50) not null comment '用户名',
  `password` varchar(10) comment '密码',
  `true_name` varchar(50) comment '真实姓名',
  `telephone` varchar(11) comment '手机号',
  `email` varchar(50)  comment '邮箱',
  `valid` int default 1 comment '激活状态',
  `register_date` DATETIME default CURRENT_TIMESTAMP comment '注册日期',
  primary key (`id`)
);
insert into user (user_name,true_name,telephone,email) values('user01','用户01','10000000001','00000000001@nk.com');
insert into user (user_name,true_name,telephone,email) values('user02','用户02','10000000002','00000000002@nk.com');
insert into user (user_name,true_name,telephone,email) values('user03','用户03','10000000003','00000000003@nk.com');
insert into user (user_name,true_name,telephone,email) values('user04','用户04','10000000004','00000000004@nk.com');
insert into user (user_name,true_name,telephone,email) values('user05','用户05','10000000005','00000000005@nk.com');
insert into user (user_name,true_name,telephone,email) values('user06','用户06','10000000006','00000000006@nk.com');
insert into user (user_name,true_name,telephone,email) values('user07','用户07','10000000007','00000000007@nk.com');
insert into user (user_name,true_name,telephone,email) values('user08','用户08','10000000008','00000000008@nk.com');
insert into user (user_name,true_name,telephone,email) values('user09','用户09','10000000009','00000000009@nk.com');
insert into user (user_name,true_name,telephone,email) values('user10','用户10','10000000010','00000000010@nk.com');
insert into user (user_name,true_name,telephone,email) values('user11','用户11','10000000011','00000000011@nk.com');
insert into user (user_name,true_name,telephone,email) values('user12','用户12','10000000012','00000000012@nk.com');
insert into user (user_name,true_name,telephone,email) values('user13','用户13','10000000013','00000000013@nk.com');
insert into user (user_name,true_name,telephone,email) values('user14','用户14','10000000014','00000000014@nk.com');
insert into user (user_name,true_name,telephone,email) values('user15','用户15','10000000015','00000000015@nk.com');
insert into user (user_name,true_name,telephone,email) values('user16','用户16','10000000016','00000000016@nk.com');
insert into user (user_name,true_name,telephone,email) values('user17','用户17','10000000017','00000000017@nk.com');
insert into user (user_name,true_name,telephone,email) values('user18','用户18','10000000018','00000000018@nk.com');
insert into user (user_name,true_name,telephone,email) values('user19','用户19','10000000019','00000000019@nk.com');
insert into user (user_name,true_name,telephone,email) values('user20','用户20','10000000020','00000000020@nk.com');
insert into user (user_name,true_name,telephone,email) values('user21','用户21','10000000021','00000000021@nk.com');
insert into user (user_name,true_name,telephone,email) values('user22','用户22','10000000022','00000000022@nk.com');
insert into user (user_name,true_name,telephone,email) values('user23','用户23','10000000023','00000000023@nk.com');
insert into user (user_name,true_name,telephone,email) values('user24','用户24','10000000024','00000000024@nk.com');
insert into user (user_name,true_name,telephone,email) values('user25','用户25','10000000025','00000000025@nk.com');
insert into user (user_name,true_name,telephone,email) values('user26','用户26','10000000026','00000000026@nk.com');
insert into user (user_name,true_name,telephone,email) values('user27','用户27','10000000027','00000000027@nk.com');
insert into user (user_name,true_name,telephone,email) values('user28','用户28','10000000028','00000000028@nk.com');
insert into user (user_name,true_name,telephone,email) values('user29','用户29','10000000029','00000000029@nk.com');
insert into user (user_name,true_name,telephone,email) values('user30','用户30','10000000030','00000000030@nk.com');
insert into user (user_name,true_name,telephone,email) values('user31','用户31','10000000031','00000000031@nk.com');
insert into user (user_name,true_name,telephone,email) values('user32','用户32','10000000032','00000000032@nk.com');
insert into user (user_name,true_name,telephone,email) values('user33','用户33','10000000033','00000000033@nk.com');
insert into user (user_name,true_name,telephone,email) values('user34','用户34','10000000034','00000000034@nk.com');
insert into user (user_name,true_name,telephone,email) values('user35','用户35','10000000035','00000000035@nk.com');
insert into user (user_name,true_name,telephone,email) values('user36','用户36','10000000036','00000000036@nk.com');
insert into user (user_name,true_name,telephone,email) values('user37','用户37','10000000037','00000000037@nk.com');
insert into user (user_name,true_name,telephone,email) values('user38','用户38','10000000038','00000000038@nk.com');
insert into user (user_name,true_name,telephone,email) values('user39','用户39','10000000039','00000000039@nk.com');
insert into user (user_name,true_name,telephone,email) values('user40','用户40','10000000040','00000000040@nk.com');
insert into user (user_name,true_name,telephone,email) values('user41','用户41','10000000041','00000000041@nk.com');
insert into user (user_name,true_name,telephone,email) values('user42','用户42','10000000042','00000000042@nk.com');
insert into user (user_name,true_name,telephone,email) values('user43','用户43','10000000043','00000000043@nk.com');
insert into user (user_name,true_name,telephone,email) values('user44','用户44','10000000044','00000000044@nk.com');
insert into user (user_name,true_name,telephone,email) values('user45','用户45','10000000045','00000000045@nk.com');
insert into user (user_name,true_name,telephone,email) values('user46','用户46','10000000046','00000000046@nk.com');
insert into user (user_name,true_name,telephone,email) values('user47','用户47','10000000047','00000000047@nk.com');
insert into user (user_name,true_name,telephone,email) values('user48','用户48','10000000048','00000000048@nk.com');
insert into user (user_name,true_name,telephone,email) values('user49','用户49','10000000049','00000000049@nk.com');
insert into user (user_name,true_name,telephone,email) values('user50','用户50','10000000050','00000000050@nk.com');
