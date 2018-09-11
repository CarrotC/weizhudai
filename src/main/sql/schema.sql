--数据库初始化脚本

--创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;

-- 创建秒杀库存表
CREATE TABLE seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存Id',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`start_time` timestamp NOT NULL COMMENT '秒杀开启时间',
`end_time` timestamp NOT NULL COMMENT '秒杀结束时间',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY(seckill_id),
key IDX_START_TIME(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- 初始化数据
insert into seckill (name,number,start_time,end_time)
VALUES
('1000元秒杀iPhone6',100,'2018-07-30 00:00:00','2018-07-31 00:00:00'),
('300元秒杀小米8',200,'2018-07-30 00:00:00','2018-07-31 00:00:00'),
('500元秒杀iPad mini',800,'2018-07-30 00:00:00','2018-07-31 00:00:00'),
('1500元秒杀iPhoneX',500,'2018-07-30 00:00:00','2018-07-31 00:00:00');

-- 秒杀成功明细表
-- 用户登陆认证相关信息
create TABLE success_killed(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存Id',
`user_phone` bigint NOT NULL COMMENT '用户手机号',
`state` tinyint NOT NULL DEFAULT -1 COMMENT '状态标识：-1：无效，0成功，1：已付款',
`create_time` timestamp NOT NULL  COMMENT '创建时间',
PRIMARY KEY(seckill_id,user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- 连接数据库控制台
mysql -uroot -p123456