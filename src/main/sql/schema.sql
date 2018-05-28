CREATE DATABASE seckill;
use seckill;
CREATE TABLE seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` varchar(100) NOT NULL  COMMENT ' 商品名称',
`number` int not null  COMMENT '商品库存数量',
`start_time` timestamp not null COMMENT '秒杀开始时间',
`end_time`  timestamp not null COMMENT  '秒杀结束时间',
`create_time` timestamp not null default current_timestamp COMMENT '秒杀成功时间创建时间',
  PRIMARY KEY (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=UTF8 ;

  -- 初始化数据
insert into seckill(name,number,start_time,end_time)
values
('1元秒杀ipad',10,'2017-6-3 00:00:00', '2017-6-4 00:00:00'),
('1元秒杀iphone',20,'2017-6-3 00:00:00', '2017-6-4 00:00:00'),
('1元秒杀AppleWatch',30,'2017-6-3 00:00:00', '2017-6-4 00:00:00'),
('1元秒杀ipod',50,'2017-6-3 00:00:00', '2017-6-4 00:00:00');
 CREATE  TABLE  SuccessKill(
  `seckill_id` bigint NOT NULL  COMMENT '秒杀商品id',
  `user_phone` int NOT NULL  COMMENT '秒杀者手机号',
  `status` INT NOT NULL DEFAULT -1 COMMENT '设置为状态标识 -1为未中
   0为秒杀成功',
  `create_time` int NOT NULL  COMMENT '秒杀成功事件创建时间',
  PRIMARY KEY (seckill_id,user_phone),
  KEY  idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 ;