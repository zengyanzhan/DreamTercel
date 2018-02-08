/***************************
create tablespace JinRong
logging
datafile 'd:\JinRong.ora' size 6M
extent  management local segment space management auto

--赋值dba(数据库管理员)角色权限给sunny用户
grant dba to "";**/







--1.用户表
select * from users;
drop table users;
create table users(
    user_code varchar2(50) primary key,     --主键 用户ID U0001
    user_name varchar2(50) not null,        --不为空 用户名
    user_pwd  varchar2(50) not null,        --不为空 密码 123456
    user_create_date date not null,         --不为空 创建日期 用户注册的日期
    role_code varchar2(50) not null,        --不为空，外键 用户角色Id 引用用户角色表的ID
    user_flag number not null,              --不为空 用户状态 1代表启动  0代表未启用
    user_desc varchar2(50) default null     --备注字段
);
--插入用户表数据
insert into users values('YH001','admin','123456',to_date('2017-11-10','yyyy-MM-dd'),'JS001',1,'..');
insert into users values('YH002','xiaoming','123456',to_date('2017-11-10','yyyy-MM-dd'),'JS002',0,'..');




--2.角色表
select * from role;
drop table role;
create table role(
  role_code varchar2(50) primary key,--主键 角色ID JS001
  role_name varchar2(50) not null,--不为空  角色名 管理员
  role_depict varchar2(50) not null,--不为空  角色描述 拥有所有权限
  role_flag number not null,--不为空  角色状态 角色是否在用 1 在用 0停用
  role_desc varchar2(50) default null
);

--插入角色表数据
insert into role values('JS001','admin','管理员',1,'...');
insert into role values('JS002','xiaoming','总经理',1,'...');




---3.功能表
select * from right;
drop table right;
create table right(
  right_code varchar2(50) primary key,--主键 功能编号 L0101
  right_parent_code varchar2(50),--可为空 父功能编号 L01
  right_type varchar2(50) not null,--不为空 功能类别 一般为'Folder',功能节点为'Document'
  right_text varchar2(50) not null,--不为空 功能名称 功能的名称
  right_url varchar2(200),--可为空 功能对应菜单链接的路径 功能对应菜单链接的路径   网址路径
  right_icon varchar2(200)--可为空 功能图标名
);
--插入功能表数据
insert into right values('L01','','Folder','业务参数','','');
insert into right values('L0109','','Document','托管人设置','jsp/trustee.jsp','');
insert into right values('L0110','','Document','管理人设置','jsp/custodian.jsp','');
insert into right values('L0101','L01','Document','基金设置','jsp/fund.jsp','');
insert into right values('L0102','L01','Document','券商设置','jsp/broker.jsp','');
insert into right values('L0103','L01','Document','交易席位设置','jsp/seat.jsp','');
insert into right values('L0104','L01','Document','交易所品种费率','jsp/exchangeRate.jsp','');
insert into right values('L0105','L01','Document','证券信息设置','jsp/security.jsp','');
insert into right values('L0106','L01','Document','债券信息设置','jsp/bond.jsp','');
insert into right values('L0107','L01','Document','股票板块设置','jsp/stockPlate.jsp','');
insert into right values('L0108','L01','Document','现金账户设置','jsp/cashAccount.jsp','');
insert into right values('L02','','Folder','业务数据','','');
insert into right values('L0201','L02','Document','交易数据','jsp/tradeData.jsp','');
insert into right values('L0202','L02','Document','权益数据','jsp/equityData.jsp','');
insert into right values('L0203','L02','Document','存款业务','jsp/bankSaving.jsp','');
insert into right values('L0204','L02','Document','行情数据','jsp/priceData.jsp','');
insert into right values('L0205','L02','Document','证券应收应付','jsp/securityApar.jsp','');
insert into right values('L0206','L02','Document','现金应收应付','jsp/cashArap.jsp','');
insert into right values('L03','','Folder','现金管理','','');
insert into right values('L0301','L03','Document','资金调拨','jsp/moneyAllot.jsp','');
insert into right values('L0302','L03','Document','划款指令','jsp/appropriationOrder.jsp','');
insert into right values('L04','','Folder','TA管理','','');
insert into right values('L0401','L04','Document','TA交易数据','jsp/taTradeData.jsp','');
insert into right values('L05','','Folder','业务处理','','');
insert into right values('L0501','L05','Document','交易结算','jsp/tradeSettle.jsp','');
insert into right values('L0502','L05','Document','TA交易结算','jsp/taTradeSettle.jsp','');
insert into right values('L0503','L05','Document','权益处理','jsp/equityHandle.jsp','');
insert into right values('L06','','Folder','日终处理','','');
insert into right values('L0601','L06','Document','库存统计','jsp/stock.jsp','');
insert into right values('L0602','L06','Document','收益计提','jsp/incomeAccrue.jsp','');
insert into right values('L0603','L06','Document','收益支付','jsp/incomePay.jsp','');
insert into right values('L0604','L06','Document','资产估值','jsp/assetValuation.jsp','');
insert into right values('L0605','L06','Document','净值统计','jsp/netValueStatistics.jsp','');
insert into right values('L07','','Folder','库存管理','','');
insert into right values('L0701','L07','Document','证券库存','jsp/securityStock.jsp','');
insert into right values('L0702','L07','Document','现金库存','jsp/moneyStock.jsp','');
insert into right values('L0703','L07','Document','证券应收应付库存','jsp/securityArapStock.jsp','');
insert into right values('L0704','L07','Document','现金应收应付库存','jsp/moneyArapStock.jsp','');
insert into right values('L0705','L07','Document','TA库存','jsp/TaStock.jsp','');
insert into right values('L08','','Folder','报表管理','','');
insert into right values('L0801','L08','Document','成交清算日报表','jsp/','');
insert into right values('L0802','L08','Document','成交清算轧差表','jsp/','');
insert into right values('L0803','L08','Document','可用现金头寸表','jsp/','');
insert into right values('L0804','L08','Document','证券市场变动表','jsp/','');
insert into right values('L0805','L08','Document','股票价格波动表','jsp/','');
insert into right values('L0806','L08','Document','股票权益信息表','jsp/','');
insert into right values('L0807','L08','Document','席位交易量统计表','jsp/','');
insert into right values('L0808','L08','Document','席位成交量明细表','jsp/','');
insert into right values('L0809','L08','Document','基金投资组合表','jsp/','');
insert into right values('L0810','L08','Document','基金投资板块表','jsp/','');
insert into right values('L09','','Folder','系统管理','','');
insert into right values('L0901','L09','Document','日志管理','jsp/logManage.jsp','');
insert into right values('L0902','L09','Document','用户管理','jsp/user.jsp','');
insert into right values('L0903','L09','Document','角色管理','jsp/role.jsp','');
insert into right values('L0904','L09','Document','模块管理','jsp/right.jsp','');
insert into right values('L0905','L09','Document','节假日管理','jsp/holiday.jsp','');

commit;


--4.角色权限管理  表名：role_right   角色权限的设置
--创建一个序列
create sequence role_right_code increment by 1 start with 1 maxvalue 9999;
select * from role_right;
drop table role_right;
create table role_right(
  role_right_code number primary key,--主键 角色权限流水编号 自动增长
  role_id varchar2(50) not null,--不为空，外键 角色ID 引用角色ID
  right_code varchar2(20 )not null,--不为空，外键 功能编号(外键) 引用功能表的功能编号
  role_right_insert number ,--可为空 增加功能按钮  1 有该功能  0 没有
  role_right_update number ,--可为空 修改功能按钮  1 有该功能  0 没有
  role_right_delete number --可为空 删除功能按钮  1 有该功能  0 没有
);
--插入角色权限管理表的数据 
insert into role_right values(role_right_code.nextval,'JS001','L01',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0101',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0102',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0103',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0104',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0105',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0106',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0107',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0108',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0109',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0110',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L02',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0201',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0202',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0203',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0204',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0205',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0206',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L03',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0301',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0302',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L04',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0401',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0402',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L05',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0501',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0502',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L06',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0601',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0602',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0603',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0604',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0605',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L07',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0701',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0702',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0703',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0704',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0705',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L08',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0801',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0802',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0803',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0804',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0805',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0806',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0807',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0808',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0809',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0810',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L09',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0901',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0902',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0903',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0904',1,1,1);
insert into role_right values(role_right_code.nextval,'JS001','L0905',1,1,1);




--5.日志表
select * from daily_record;
drop table daily_record;
create table daily_record(
  daily_code varchar2(50) primary key,--主键 日志编号 RZXX201609010001
  user_code varchar2(50),--用户操作编号  用户表的主键
  daily_table  varchar2(50) not null,--不为空 操作的表名
  daily_type  varchar2(50) not null,--不为空 操作的类型
  daily_date date not null,--不为空 操作的时间
  daily_ip varchar2(50) not null,--外键 用户名 引用用户表t_user中的主键类 userId
  right_desc varchar2(50) default null
);
--插入日志表数据
insert into daily_record values
('RZ20171107111213001','YH001','用户','用户查询',to_date('2017-11-10','yyyy-MM-dd'),'YH001','...');
insert into daily_record values
('RZ20171107111213002','YH002','用户','用户删除',to_date('2017-11-10','yyyy-MM-dd'),'YH002','...');






--6.证券库存表
select * from security_stock;
drop table security_stock;
create table security_stock (
    security_stock_code varchar2(50) primary key  not null,--证券库存的编号 主键(ZJKC20171107001)
    security_code varchar2(50) not null,--外键（证券表） 证券Id 证券Id
    fund_code varchar2(50) not null,--引用基金信息表的主键fund_code
    cash_account_code varchar(50) not null,--不为空，外键 现金账户Id 
    security_name varchar2(50) not null ,--证券名称
    security_type number(1) not null,--证券类型（1为股票，2为债券）
    security_util_cost number(14,2) not null,--单位成本
    security_quantity number(14) default 0 ,--证券数量
    security_total_money number(14,2) default 0 ,--总成本（总金额）
    security_statistics_date date not null ,--统计日期
    security_period_flag number not null,--不为空	期初标志	是否从其他系统导入的期初数据  1：不是  2：是
    security_stock_desc varchar2(200) default null --备注
);
--插入证券库存数据
 insert into security_stock values
 ('ZJKC20171109001','123456','600029','XJZK001','南方航空',2,9.01,1000,9010,systimestamp,1,'');
 insert into security_stock values
 ('ZJKC20171109002','123890','600030','XJZK002','中国石油',2,5.54,1000,5540,systimestamp,1,'');





--7.创建现金库存表
select * from cash_stock;
drop table cash_stock;
create table cash_stock(
  cash_stock_code varchar2(50) primary key,--现金库存编号
  fund_code varchar2(50) not null,--基金代码 外键 引用基金表的ID
  cash_blance number(14,2) not null,--不为空 现金余额 目前账户的现金余额
  cash_account_code varchar2(50) not null,--不为空，外键（现金账户表） 账户code 引用现金账户表的账户code
  cash_statistic_date date not null,--统计日期
  cash_period_flag number(14,2) not null,--不为空	期初标志	是否从其他系统导入的期初数据  1：不是  2：是
  cash_stock varchar2(200) default null --可为空 备注 备注详情
);
--插入现金库存表的数据
insert into cash_stock values
('XJKC20171109001','JJDM20171109001',1000.00,'XJZH20171109001',systimestamp,2,'haha');
insert into cash_stock values
('XJKC20171109002','JJDM20171109002',1000.00,'XJZH20171109002',systimestamp,1,'haha');




--8.存款业务
select * from saveing_business;
drop table saveing_business;
create table saveing_business(
   saveing_business_code varchar2(50)	 primary key not null,--每一笔存款数据的Code(主键)(CKSJ20171107001)		交易的单子号
   fund_code	varchar2(50)	not null,--基金代码（外键）	not null	引用基金表的基金代码fundCode
   out_cash_account_code	varchar2(50)	not null ,--REFERENCES   cash_account (cash_account_code),-- 流出现金账户Code（外键）引用现金账户表 的 现金账户表的Code
   in_cash_account_code	varchar2(50)not null ,--REFERENCES   cash_account (cash_account_code),--流入现金账户Code（外键）引用现金账户表  的 现金账户表的Code
   business_date	date	not null,--业务时间	not null	--开始存款业务的时间
   business_type	number(14,2)	not null,--业务类型	not null	 --1定期三天，2定期7天
   saving_money	number(14,2)	default 0	,--存款金额	default 0	,--存款的金额数目
   saving_interest	number(14,2)	default 0	,--所含利息	default 0	--存款业务所得的利息
   saving_end_date	date not null,--到期时间	not null	--存款业务到期的时间
   saving_flag	number(14,2) not null,--到期办理标志	not null	  --1未到期办理    2  已到期办理
   saveing_business_desc	varchar2(200)	null--备注		
);
--插入存款业务的数据
insert into saveing_business values
('CKYW20171110001','JJDM20171110001','XJZH20171110001','XJZH20171110001',systimestamp,1,10000.00,23.33,systimestamp,1,'the animal is so true');


select max(exchange_code) from exchange_breed_rate;
--9.交易所品种费率表
select * from exchange_breed_rate;
drop table exchange_breed_rate;
create table exchange_breed_rate(
	exchange_code varchar2(50) primary key,	--交易所id (JYSPZFL001)
	exchange_name number(14,4) not null,	--交易所名称,上海交易所为1，深圳交易所为2
	exchange_type number(14,4) not null,	--费率类型  股票为1 ,债券为2
	stamp_duty number(14,4) not null,	--印花税
	transfer_fee number(14,4) not null,	--过户费
	management_fee number(14,4) not null,--征管费
	brokerage_fee number(14,4) not null,	--经手费
	exchange_breed_rate_desc varchar2(200)	--交易所品种费率表的备用字段
);
--插入交易所品种费率数据
insert into exchange_breed_rate
(exchange_code,exchange_name,exchange_type,stamp_duty,transfer_fee,management_fee,brokerage_fee,exchange_breed_rate_desc) 
values('JYSPZFL0001',1,1,0.005,0.004,0.003,0.002,'');

insert into exchange_breed_rate 
(exchange_code,exchange_name,exchange_type,stamp_duty,transfer_fee,management_fee,brokerage_fee,exchange_breed_rate_desc)
values('JYSPZFL0002',1,2,0.005,0.004,0.003,0.002,'');

insert into exchange_breed_rate 
values('JYSPZFL0003',2,1,0.005,0.004,0.003,0.002,'');

insert into exchange_breed_rate 
values('JYSPZFL0004',2,2,0.005,0.004,0.003,0.002,'');


--10.券商表
select * from broker;
drop table broker;
create table broker(
	broker_code varchar2(50) primary key,	--券商id(QS001)
	broker_name varchar2(50) not null,	--券商名称
	broker_explain varchar2(50) not null,	--券商的说明
	broker_desc varchar2(200)		--券商表的备用字段
);
--插入券商数据
insert into broker(broker_code,broker_name,broker_explain,broker_desc) 
values('QS0001','方正证券公司','股市有风险，投资需谨慎！','');
insert into broker(broker_code,broker_name,broker_explain,broker_desc)  
values('QS0002','广发证券公司','股市有风险，投资需谨慎！','');
insert into broker(broker_code,broker_name,broker_explain,broker_desc)  
values('QS0003','财富证券公司','股市有风险，投资需谨慎！','');





--11.交易席位信息表
select * from trade_seat;
drop table trade_seat;
create table trade_seat(
 trade_seat_code varchar2(50) primary key,	--交易席位的唯一ID
 broker_code varchar2(50) not null ,		--引用券商表broker的broker_code  
 seat_name varchar2(50) not null,		--席位名称
 seat_address varchar2(50) not null,		--席位地点 上海/深圳
 seat_type number(1) not null,			-- 1=普通，2=贵宾
 commission_rate number(5,3) not null,		--佣金利率
 trade_seat_desc varchar2(50)			--交易席位信息表的备用字段
);
--插入交易席位信息表数据
insert into trade_seat
(trade_seat_code,broker_code,seat_name,seat_address,seat_type,commission_rate,trade_seat_desc)
values('A13202','QS0001','南方证券公司上海分公司浦建西路营业部','上海',1,0.05,'');

insert into trade_seat
(trade_seat_code,broker_code,seat_name,seat_address,seat_type,commission_rate,trade_seat_desc)
values('A13203','QS0002','南方证券公司上海分公司新闸路营业部','上海',1,0.05,'');







--12.交易数据表
select * from trade_seat;
drop table trade_seat;
CREATE TABLE deal_data	(
		deal_data_code	    varchar2(50)	 primary key not null    ,--交易的单子号(主键)(JYSJ20171107001)		主键 通过这个Code来查的数据
		fund_code	        varchar2(50)	,-- REFERENCES   fund (fund_code)   ,--基金代码（外键）	null	引用基金表的基金代码  说明你交易的是哪个基金 外键（基金设置表）
		security_code	    varchar2(50)	,-- REFERENCES   security (security_code)   ,--证券表的Code（外键）	null	外键（证券表的Code） 你引入证券表的Code
		deal_date    	    date	         not null , --成交日期	not null	 交易成交的日期
		set_account_date	date	         not null ,--结算日期	not null	交易结算的日期
		user_code	        varchar2(50)	not null ,--投资经理	null	 引用投资y用户表的编号Code userCode
		broker_code  	    varchar2(50)	not null ,--券商Code	null	引用券商表的券商Code
		trade_seat_code	    varchar2(50)	,-- REFERENCES   trade_seat (trade_seat_code)   ,--交易席位Code	null	引用交易席位表的该券商已有的交易席位Code
		deal_type	        number(14,2)	not null ,--交易方式	not null	1买入、2卖出，3分红，4送股
		deal_flag	        number(14,2)	not null ,--交易标识	not null	1流入，-1流出
		cash_account_code	varchar2(50)	,-- REFERENCES   cash_account (cash_account_code)   ,--账户Code号	null	  引用现金账户表 t_cashAccount 的Code
		deal_price	        number(14,2)	default 0,--交易价格(单价)	default 0	交易一份的钱
		deal_quantity	    number(14,2)	default 0,--交易数量	default 0	此次交易的数量
		deal_total_price	number(14,2)	default 0,--交易金额（总的）	default 0	交易金额（总的）
		stamp_duty	        number(14,2)	null,--印花税	null	上交国家的税
		management_fee	    number(14,2)	null,--征管费	null	上交国家的税
		transfer_fee	    number(14,2)	default 0,--过户费（交易所）	default 0	交易所收的钱
		commission_fee	    number(14,2)	default 0,--佣金费用（券商）	default 0	卷商收的钱
		brokerage_fee	    number(14,2)	default 0,--经手费（交易所）	default 0	交易所收的钱
		real_collect_fee	number(14,2)	default 0,--实收金额 	default 0	总交易金额+总费用
		security_interest	number(14,2)	default 0,--证券利息	default 0	
		deal_status	        number(14,2)	default 0,--交易状态	default 0	已经结算为1，未结算为2
		deal_data_desc	    varchar2(200)	--备注	null	
);
--插入交易数据表数据
insert into deal_data values
('JYSJ20171107001','660006','600291',to_date('2017-11-6','yyyy-MM-dd'),to_date('2017-11-7','yyyy-MM-dd'),'TZ001','JS001','JYXW001',1,1,'XJZH001',2,1000,2000,60,60,20,20,20,2080,0,2,'');
insert into deal_data values
('JYSJ20171107002','660006','600291',to_date('2017-11-6','yyyy-MM-dd'),to_date('2017-11-7','yyyy-MM-dd'),'TZ001','JS001','JYXW001',1,1,'XJZH001',2,1000,2000,60,60,20,20,20,2080,0,2,'');




--13.托管人表
select * from trustee;
drop table trustee;
create table trustee(
       trustee_code varchar2(50),--主键 托管人的ID(TGR001)
       trustee_name varchar2(50),--托管人名字
       trustee_addres varchar2(100),--托管人地址
       trustee_company varchar2(50) ,--托管公司
       trustee_phone varchar2(50),--电话
       trustee_fee number(14,2),--托管费率
       trustee_Desc varchar2(50)--备注
);
--插入托管人表数据
insert into trustee values('TGR001','建材基金','北京市西城区金融大街25号','中国建设银行','010-66215533',0.2,'');





--14.管理人表
select * from manager;
drop table manager;
create table manager(
      manager_code varchar2(50)  primary key,--主键 管理人的ID （GLR001）
      manager_name varchar2(50),-- 管理人的姓名
      manager_age varchar2(50) ,-- 管理人的年龄
      manager_sex char(2),-- 管理人的性别
      manager_company varchar2(50) ,--所在公司
      manager_phone varchar2(50) ,--管理人的电话
      manager_fee number(14,2) ,--管理费
      manager_desc varchar2(50) --备注
);
insert into manager values('GLR001','易文奇','20','男','国泰基金有限公司','18882342124',0.02,'');






--15.基金信息表
select * from fund;
drop table fund;
create table fund(
  fund_code varchar2(50) primary key,	--基金代码,基金发行之后都有一个唯一的代码
  fund_name varchar2(50) not null,	--基金名称
  cash_account_code varchar2(50) not null,--外键引用,现金账户表的cash_account_code 
  fund_type number(14,2) not null,	--1=开放式；2=封闭式
  trustee_code varchar2(50) not null,	--基金托管人(引用trustee托管银行的trustee_code)
  manager_code varchar2(50) not null,	--基金管理人(引用manager管理人的manager_code)
  init_fund_value number(14,4) not null,--初期基金净值
  fund_scale number(14,4) not null,	--基金规模
  manage_rate number(14,4) not null,	--管理人费率：0.33%
  trustee_rate number(14,4) not null,	--托管人费率：0.10%
  fee_period_day number(14,4) not null,	--两费计提天数    1=360天；2=365天；3=366天
  establish_date date not null,		--成立时间  2014-05-26
  fund_desc varchar2(200)		--基金信息表的备用字段
);
--插入基金信息数据
insert into fund values
('000363','国泰聚信价优势混合C','XJZH0001',1,'中信银行股份有限公司','曲波',209627608.30,209553943.00,0.33,0.10,1,To_date('2014-05-26','yyyy-mm-dd'),'');

insert into fund values
('001542','华夏货币市场基金B','XJZH002',2,'招商银行股份有限公司','周飞',159621618.30,109353943.00,0.33,0.10,1,To_date('2012-12-10','yyyy-mm-dd'),'');






--16.现金账户表
select * from cash_account;
drop table cash_account;
create table cash_account(
	cash_account_code varchar2(50) primary key,	        --现金账户表ID（XJZK001）
	cash_account_bank_card varchar2(50) not null,	    --银行卡号  为19位 
	cash_account_name varchar2(50) not null,		    --账户名称,以公司的名义开户
	cash_account_bank_name varchar2(50) not null,		--银行名称  中国建设银行
	cash_account_deposit_type number(14,2) not null,	--存款类型  活期为1 ,定期为 2
	cash_account_card_rate number(14,2) not null,		--卡号利率
	cash_account_interest_period number(14,2) not null,	--计息期间,1为360,2为365,3为366，
	cash_account_start_time date  not null,		--开户时间
	cash_account_end_time date not null,		--结束时间
	cash_account_desc varchar2(200)			            --现金账户表的备用字段
);
--插入现金账户数据
insert into cash_account(cash_account_code,cash_account_bank_card,cash_account_name,cash_account_bank_name,cash_account_deposit_type,
cash_account_card_rate,cash_account_interest_period,cash_account_start_time,cash_account_end_time,cash_account_desc)
values('XJZH001','6212262201023557228','XXX农业银行账户','中国农业银行',
1,0.03,2,To_date('2017-8-10','yyyy-mm-dd'),To_date('2018-12-10','yyyy-mm-dd'),'');
insert into cash_account(cash_account_code,cash_account_bank_card,cash_account_name,cash_account_bank_name,cash_account_deposit_type,
cash_account_card_rate,cash_account_interest_period,cash_account_start_time,cash_account_end_time,cash_account_desc)
values('XJZH002','4367420160000852007','XXX建设银行账户','中国建设银行VISA龙卡借记卡',
2,0.05,3,To_date('2017-11-08','yyyy-mm-dd'),To_date('2018-4-07','yyyy-mm-dd'),'');


--17.证券应收应付库存
select * from security_arap_stock;
drop table security_arap_stock;
create table security_arap_stock(
    security_arap_stock_code varchar2(50)   PRIMARY KEY not null,	-- 主键(ZJYSYFKC20171107001)证券应收应付库存编号(以每一笔记)
    cash_account_code	     varchar2(50)	not null,	--引用现金账户表Code   	外键
    fund_code		         varchar2(50)	not null,	--引用基金表的基金代码 	外键
    security_code			 varchar2(50)	 not null,--外键 证券代码	not null	 引用证券表 证券公司上市唯一代码
    business_type		     number		    not null,	--业务类型(1估值增值 ,2清算款,3存款计息)
    total_money		         number		    default 0,	--总金额 默认为0
    period_flag		         number		    not null,	--期初标志(1导入数据,2不导入)
    business_status		     number		    not null,	--业务状态(1代表应收，-1代表应付)
    business_date             date  		 not null,	
    security_arap_stock_desc varchar2(50)              --备注可扩展
);
--插入证券应收应付库存
insert into security_arap_stock values('ZJYSYFKC20171110001','XJZK001','000363','019508',3,0,1,1,To_date('2017-11-10','yyyy-mm-dd'),'');
insert into security_arap_stock values('ZJYSYFKC20171110002','XJZK002','001542','600030',1,0,1,1,To_date('2017-11-17','yyyy-mm-dd'),'');

commit;





---18.资金调拨表
select * from fund_allot;
drop table fund_allot;
create table fund_allot(
	fund_allot_code varchar2(50) primary key, --资金调拨编号(ZJDB20171107001)
	fund_code varchar2(50) not null, --基金编号
	fund_allot_money number(14,2) not null,--调拨资金数额
	cash_account_code varchar2(50) not null,--现金账户（引用现金账户表ID）
	fund_allot_direction number(2) not null,--资金调拨方向(1代表流入，-1代表流出)
	fund_allot_Date date  not null,--调拨日期
	business_date date not null,--业务日期 (资金到账日)
	business_code varchar2(50) not null,--业务标号 （申购、赎回等业务对应的业务ID）
	fund_allot_type number(2) ,--可为空 调拨类型 1=存款利息 2=申购赎回清算款 3=买卖交易清算款
	fund_allot_desc varchar2(200) --可为空 备注 备注详情
);
--插入资金调拨表数据
insert into  fund_allot values
('ZJDB20171107001',1400000,'000363','XJZH001',1,to_date('2017-11-10','yyyy-MM-dd'),to_date('20171112','yyyy-MM-dd'),'TAJYSJ20171107001',2,'');

insert into  fund_allot values
('ZJDB20171107002',100000  ,'000363','XJZH001',1,to_date('2017-11-10','yyyy-MM-dd'),to_date('20171112','yyyy-MM-dd'),'TAJYSJ20171107002',3,'');








--19.证券应收应付表
select * from security_arap;
drop table security_arap;
create table security_arap(
        security_arap_code	varchar2(50)	primary key not null,--证券应收应付唯一标识符(主键)(ZJYSYF20171107001)		 每一笔证券应收应付数据的编号：ZQSF201608310001
		cash_account_code	varchar2(50)	 not null,--外键 账户Code号 	not null	引用现金账户表 t_cashAccount 的现金账户表的Code
		fund_code	    varchar2(50)	 not null,--外键 基金代码 	not null	引用基金表的基金代码fundCode
		security_code	varchar2(50)	 not null,--外键 证券代码	not null	 引用证券表 证券公司上市唯一代码
		security_arap_type	number(14,2) not null,--证券应收应付类型 	not null	1估值增值，2证券清算款，3债券利息
		money_direction	number(14,2) not null,--资金流动方向 	not null	1流入，-1流出
		money	number(14,2)		default 0 ,--金额 	default 0	流动金额的数目
		business_date	date	not null,--业务日期 	not null	资金流动发生的日期
		security_arap_desc	varchar2(200) null	--备注	null	备注
);
--插入证券应收应付数据
insert into security_arap
values('ZJYSYF20171107001','XJZH001','000363','600030',1,1,10000,to_date('2017-11-10','yyyy-mm-dd'),NULL);







--20.现金应收应付表
select * from cash_arap;
drop table cash_arap;
CREATE TABLE cash_arap(
        cash_arap_code	varchar2(50)	 primary key not null ,--现金应收应付编号 (主键)(XJYSYF20171107001)		字符串 如:XJSF201609010001
		cash_account_code	varchar2(50)	not null,--银行卡号 	not null	引用现金账户表t_cashAccount表中的主键列cashAccountCode
		fund_code	varchar2(50)	not null,--基金编号 	not null	引用基金信息表t_fund中的主键列fundCode
		cash_arap_type	number(14,2)	not null,--默认值为1 证券应收应付业务类型 	not null	1=资金管理费 2=托管费 3=存款利息  4 申购赎回款
		money_direction	number(14,2)	not null,--默认值为1 资金流向 	not null	1=流入 -1=流出
		money	number(14,2)	default 0 ,--金额	default 0	金额
		business_date	date	not null,--业务日期	not null	业务日期
		cash_arap_desc	varchar2(200)	--备注	null	备注
);
--插入现金应收应付数据
insert into cash_arap
values('XJYSYF20171107001','XJZH001','000363',1,1,10000,to_date('2017-11-10','yyyy-mm-dd'),NULL);
insert into cash_arap
values('XJYSYF20171107002','XJZH002','001547',1,1,10000,to_date('2017-11-10','yyyy-mm-dd'),NULL);




--21.证券信息设置表
select * from security;
drop table security;
create table security(
     security_code varchar2(50) primary key,--证券上市唯一代码
     security_name varchar2(50) not null,	--券商名称
     publish_date date not null,		--发行日期
     delay_date date not null,		--延迟日期
     security_type number(1) not null,	--1=股票  2=债券
     exchange_name number(1) not null,	--引用交易所品种费率表交易所名称1=上交所;2深交所 外键引用
     stock_plate_code varchar2(50),		--引用板块信息表中的板块stock_block_code,可以为空
     security_desc varchar2(50)		--证券信息备注
);
--插入证券信息设置数据
insert into security
(security_code,security_name,publish_date,delay_date,security_type,exchange_name,stock_plate_code,security_desc) 
values('600030','中信证券',To_date('2003-01-06','yyyy-mm-dd'),To_date('2003-01-06','yyyy-mm-dd'),1,1,'P01','');





--22.股票板块信息设置表
select * from stock_block;
drop table stock_block;
create table stock_block(
     stock_block_code varchar2(50) primary key,--股票板块的ID
     --父板块Id引用股票板块信息表的板Id(自己引用自己的主键)	
     stock_block_father_code varchar2(50) not null,				
     stock_block_name varchar2(50) not null,--股票板块名称
     stock_block_desc varchar2(200)--股票板块信息备注字段
);
--插入股票板块数据
insert into stock_block values('P01','p','制造业','');
insert into stock_block values('P0101','P01','华宝兴业制造业板块','制造业所属');
insert into stock_block values('P0102','P01','飞机制造业板块','制造业所属');
insert into stock_block values('P02','p','中国石油','');
insert into stock_block values('P0201','P02','中国石化','中国石油所属');
insert into stock_block values('P0202','P02','上海石化','中国石油所属');





--23.债券表
select * from bond;
drop table bond;
create table bond(
     bond_code varchar2(50) primary key,--债券的代码 唯一id
     bond_name varchar2(50) not null,--债券名称 
     interest_star_date date not null,--计息起始日
     interest_end_date date not null,--计息结束日	结束日期
     bond_type  number(1) not null,----债券的类型   银行间为1 , 非银行间 为2
     coupon_rate number(12,4) not null,-- 票面利率   年利率计算
     bond_interest number(12,4) not null,--债券利息 一般为%
     coupon_money number(12,4) not null,--票面金额  一开始为100，一般可增可减
     payment_count number(1) not null,--付息次数 1为一年一次，2为一年两次
     bond_desc varchar2(200)--备用字段
);

--数据
insert into bond(bond_code,bond_name,interest_star_date,interest_end_date,bond_type,coupon_rate,bond_interest,coupon_money,payment_count,bond_desc)
values('019508','15国债08',to_date('2017-11-10','yyyy-mm-dd'),to_date('2020-11-10','yyyy-mm-dd'),1,0.05,0.03,98,1,'');
insert into bond(bond_code,bond_name,interest_star_date,interest_end_date,bond_type,coupon_rate,bond_interest,coupon_money,payment_count,bond_desc)
values('019424','14国债24',to_date('2016-3-18','yyyy-mm-dd'),to_date('2018-3-18','yyyy-mm-dd'),1,0.06,0.03,99.33,1,'');





--24.TA库存
select * from ta_stock;
drop table ta_stock;
create table ta_stock(
  ta_stock_code varchar2(50) primary key not null,--TA库存Code 主键(TAKC20171107001)
  fund_code varchar2(50) not null,--引用外键 引用基金表的主键基金编号
  ta_stock_quantity number not null,--TA申购赎回的数量
  ta_stock_money number(14,2) not null,--TA交易的金额
  statistic_date date not null,--统计日期
  period_flag number not null,--是否从其他系统导入期初数据(1是;2不是)
  ta_stock_desc varchar2(200) default null--备注
);
--插入TA库存数据
insert into ta_stock values('TAKC20171107001','000363',6200,10000.00,to_date('2017-11-7','yy-MM-dd'),1,'');
insert into ta_stock values('TAKC20171206001','001542',5000,12000.00,to_date('2017-12-6','yy-MM-dd'),1,'');




--25.TA交易数据表
select * from ta_trad_data;
drop table ta_trad_data;
CREATE TABLE ta_trad_data(
        ta_trad_data_code	    varchar2(50)	primary key not null    ,	--交易的单子号(主键)(TAJYSJ20171107001)	(主键) 通过这个Code来差寻交易的数据
		fund_code	    varchar2(50)   ,-- REFERENCES   fund (fund_code)   ,	--基金代码（外键）		引用基金表的基金代码  说明你交易的是哪个基金 外键（基金设置表）
		ta_trad_quality  	number(14,2)    default 0   ,               --基金的数量	default 0	你交易的基金数量
		cash_account_code	varchar2(50)	,--REFERENCES  cash_account (cash_account_code)   ,--账号Code（外键）		外键（现金账户表） 你交易的金钱的来往账号
		ta_total_money	number(14,2)	default 0   ,               --总金额	default 0	你应该交易多少钱？？？
		ta_real_money	number(14,2)   default 0   ,	            --实际交易的金额	default 0	可能还少给我了一些钱  实际上你给了我多少钱
		ta_trade_date	date	        not null    ,               --交易的日期	not null	你哪天交易我的？？？
		settle_date	date	    not null    ,               --结算的日期	not null	清算金额的日期
		ta_unit_money	number(14,2)    default 0   ,	            --单价	default 0	一份多少钱？？？
		fee	        number(14,2)   default 0   ,               --	费用	default 0	额外的费用 如佣金 手续费呀
		agencies	    varchar2(50)   ,--REFERENCES  broker (broker_code),--代销的机构的Code（外键）		1建行2农行3工行
		ta_rade_type	number(14,2)   not null    ,               --	你交易的类型	not null	1如认购 2如申购 3 赎回
		ta_trade_status	number(14,2)    not null    ,               --	你交易的状态	not null	1结算 2未结算
		ta_trad_data_desc	    varchar2(200)	null                        --备注	null	
);
--插入TA交易数据表数据
insert into ta_trad_data values
('TAJYSJ20171107001','660006',100,'XJZH001',200000,203000,to_date('2017-11-6','yy-MM-dd'),to_date('2017-11-7','yy-MM-dd'),2000,3000,1,1,1,'');
insert into ta_trad_data values
('TAJYSJ20171107002','660007',200,'XJZH002',400000,203000,to_date('2017-11-6','yy-MM-dd'),to_date('2017-11-7','yy-MM-dd'),2000,3000,1,1,1,'');





--26.创建现金应收应付库存表
select * from cash_arap_stock;
drop table cash_arap_stock;
create table cash_arap_stock(
   cash_arap_stock_code varchar2(50) primary key,--现金应收应付库存编号(以每一笔记)
   cash_account_code varchar2(50) not null,--外键 引用现金账户表的ID
   fund_code varchar2(20) not null,--外键 引用基金表的基金代码
   business_type number(14,2) not null,--业务类型(1管理费,2托管费,3存款利息,4申购赎回费)
   total_money number(14,2) not null,--总金额
   status number not null,--不为空 业务状态 1代表应收，-1代表应付
   business_date varchar2(50) not null,--不为空 业务日期 日期
   period_flag number not null,--不为空 期初标志 是否从其他系统导入的期初数据  1：不是  2：是
   cash_arap_stock_desc varchar2(50) default null --备注可扩展
);
--插入现金应收应付库存表数据
insert into cash_arap_stock values('XJYSYFKC20171110001','XJZK001','000363',1,1000,1,to_date('2017-11-10','yy-MM-dd'),1,'');
insert into cash_arap_stock values('XJYSYFKC20171110002','XJZK002','001542',2,1000,-1,to_date('2017-11-11','yy-MM-dd'),1,'');




--27.净值统计表
select * from net_value;
drop table net_value;
create table net_value(
      net_value_code varchar2(50) primary key,--主键 净值统计表的编号 编号  JZTJ201608310001

      fund_code varchar2(50) ,--外键 基金编号 引用基金表 t_fund中的主键列fundId
      project_name varchar2(50) ,--不为空 项目名称 股票
      project_code varchar2(50) ,--不为空 项目编号
      quantity number(14,2) ,--quantity varchar2(50),--不为空 数量  股数/票面数
      price number(14,2) ,--不为空 行情价格 行情价格
      costing number(14,2),--不为空 成本 成本
      market_value number(14,2),--不为空 市值 市值
      statistic_date Date,--不为空 统计日期 统计日期
      value_add number(14,2) ,--不为空 估值增值 估值增值
      tree_code varchar2(50),--不为空 树形ID 树形ID
      tree_father_code varchar2(50)--不为空 树形Class 树形Class
);
insert into net_value values
('JZTJ20171118001','001542','证券','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ01','F');
insert into net_value values
('JZTJ20171118002','001542','股票','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0101','JZTJ01');
insert into net_value values
('JZTJ20171118003','001542','**股票','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0101001','JZTJ0101');
insert into net_value values
('JZTJ20171118004','001542','***股票','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0101002','JZTJ0101');
insert into net_value values
('JZTJ20171118005','000363','债券','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0102','JZTJ01');
insert into net_value values
('JZTJ20171118006','000363','**债券','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0102001','JZTJ0102');
insert into net_value values
('JZTJ20171118007','000363','***债券','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0102002','JZTJ0102');
insert into net_value values
('JZTJ20171118008','001542','现金','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ02','F');
insert into net_value values
('JZTJ20171118009','001542','**账户','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0201','JZTJ02');
insert into net_value values
('JZTJ201711180010','001542','存款利息','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,
'JZTJ0201001','JZTJ0201');
insert into net_value values
('JZTJ201711180011','001542','托管费','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0201002','JZTJ0201');
insert into net_value values
('JZTJ201711180012','001542','管理费','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0201003','JZTJ0201');
insert into net_value values
('JZTJ201711180013','001542','***账户','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,
'JZTJ0202','JZTJ02');
insert into net_value values
('JZTJ201711180014','001542','存款利息','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,
'JZTJ0202001','JZTJ0202');
insert into net_value values
('JZTJ201711180015','001542','托管费','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0202002','JZTJ0202');
insert into net_value values
('JZTJ201711180016','001542','管理费','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0202003','JZTJ0202');
insert into net_value values
('JZTJ201711180017','001542','合计','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ03','F');
insert into net_value values
('JZTJ201711180018','001542','负债','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0301','JZTJ03');
insert into net_value values
('JZTJ201711180019','001542','总资产','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,'
JZTJ0302','JZTJ03');
insert into net_value values
('JZTJ201711180020','001542','资产净值','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,
'JZTJ0303','JZTJ03');
insert into net_value values
('JZTJ201711180021','001542','估值增值','',0,0,0,0,to_date('2017-11-18','yyyy-MM-dd'),0,
'JZTJ0304','JZTJ03');



--28.权益数据
select * from equity_data;
drop table equity_data;
CREATE TABLE equity_data	(
        equity_data_code	        varchar2(50)     primary key not null    ,	--交易的单子号(主键)（QYSJ20171107001）		主键 通过这个Code来查的数据
		cash_account_code 	varchar2(50)   ,--  REFERENCES  cash_account (cash_account_code)    ,	--账号Code（外键）		外键（现金账户表） 你交易的金钱的来往账号
		security_code	    varchar2(50)	,-- REFERENCES   security (security_code)   ,--证券表的Code		外键（证券表的Code） 你引入证券表的Code
		register_day	    date		     not null ,  	-- 权益登记日 登记获得权益的日子
		ex_day	        date	 	     not null	 ,  --权益除权日    真正分红送股的日子
		send_stock_scale	number(14,2)		     not null	 ,  --送股比例
		share_qut_bonus_scale	number(14,2)		 not null ,  	--   权益类型 1为分红，2为送股
		to_account_date	date		     not null, --	 到账日期 钱到账的日期
        equity_data varchar2(200)
);







----29.权益处理
select * from interests;
drop table interests;
create table interests(
	interests_code varchar2(20) primary key ,--权益处理编号
	fund_code varchar2(20) not null,---基金编号
	cash_account_code varchar2(20) not null, --现金账户(引用现金用户表编号)
	security_code varchar2(20) not null ,--证券编号（引用证券编号）
	interests_register Date not null,---权益登记日
	interests_ex_rights Date not null,---除权日
	stock_distribution number(5,3) not null,--送股比例
	share_qut_bonus_scale number not null,--分红比例  分红比例
	equity_type number(2) not null,--权益类型  1为分红，2为送股
	toAccountDate varchar2(50) not null,--到账日期
	interests_desc varchar2(100) --备注
);


--30  priceData	行情数据表
select * from priceData;
CREATE TABLE priceData(
        pd_priceDataCode	varchar2(50)	 primary key not null,--行情数据Code(主键)(HXSJ20171107001)		
		pd_securityCode	varchar2(50)	not null,--证券代码外键	not null	
		pd_enteringDate	Date	not null,--录入日期	not null	 行情数据录入日期 日期 如:2016-08-31
		pd_openingPrice	number(14,2)	not null,--开盘价格	not null	(股票开盘价格)
		pd_closingPrice	number(14,2)	not null,--收盘价格	not null	(股市收盘价格)
		pd_Desc	varchar2(200)	--备注	null	
)
insert into priceData(pd_priceDataCode,pd_securityCode, pd_enteringDate, pd_openingPrice , pd_closingPrice,pd_Desc)
values('HXSJ20171107001','600291',to_date('2017-11-10','yy-MM-dd'),6.65,6.99,NULL);
insert into priceData(pd_priceDataCode,pd_securityCode, pd_enteringDate, pd_openingPrice , pd_closingPrice,pd_Desc)
values('HXSJ20171107002','600294',to_date('2017-11-10','yy-MM-dd'),9.65,8.99,NULL);


--31.节假日存储表


create or replace package pk_select 
is 
--创建一个游标类型
    type c_resultset is ref cursor;
--创建一个按条件分页查询的存储过程
    procedure sp_select_pagination(
                            p_tableName varchar2,--表名
                            p_qualification varchar2 ,--条件
                            p_page in out  int ,--当前显示的页数
                            p_rows in out  int ,--当前显示的行数
                            p_pageTotal out int,--总页数
                            p_rowsTotal out int ,--总行数
                            p_orderColumn  varchar2,   --排序的列
                            p_orderStyle  varchar2,   --排序方式
                            p_cursor out c_resultset -- 查询得到的数据
    );

end;


create or replace package body  pk_select 
is 

--创建一个按条件分页查询的存储过程
    procedure sp_select_pagination(
                            p_tableName varchar2,--表名
                            p_qualification varchar2 ,--条件
                            p_page in out  int  ,--当前显示的页数
                            p_rows in out  int ,--当前每页显示的行数
                            p_pageTotal out int,--总页数
                            p_rowsTotal out int ,--总行数
                            p_orderColumn  varchar2,   --排序的列
                            p_orderStyle  varchar2,   --排序方式
                            p_cursor out c_resultset -- 查询得到的数据
    )
    is
        
        v_sql varchar2(1000);--动态SQL语句
    begin

        ---得到总行数的sql语句
        v_sql:='select count(*)  from '||p_tableName || ' where 1 = 1 ' ;
        --判断条件是否为空
        if p_qualification is not null or p_qualification<>'' then
        --拼接条件
                v_sql:=v_sql||p_qualification;
        end if;
        --得到总行数
        execute immediate v_sql into  p_rowsTotal;
        DBMS_OUTPUT.PUT_LINE('总行数'|| p_rowsTotal);
        --每页显示的行数不能为负
        if p_rows < 0 then 
            raise_application_error(-20001,'每页显示的数不能为负');
        end if;
        --得到总页数
        if  mod(p_rowsTotal,p_rows) =0 then 
            p_pageTotal:= trunc(p_rowsTotal/p_rows);
        else 
            p_pageTotal:= trunc(p_rowsTotal/p_rows)+1;
        end if;
        --当前显示的页数验证
        if p_page <1 then 
            p_page:=1;
        end if;
        if p_page>p_pageTotal then 
            p_page:=p_pageTotal;
        end if;
        --查询
        --表名判断
        if p_tableName is not null or p_tableName <>'' then 
            v_sql := 'select * from (  select e.*,rownum rs from ( select * from '
            ||p_tableName ||'  where 1=1 ';
        else
            raise_application_error(-20002,'请输入表名！');
        end if;
        --条件判断
        if p_qualification  is not  null or p_qualification<> '' then
            v_sql:=v_sql||p_qualification ;
        else
            null;
        end if;
        --排序判断
        if p_orderColumn is not null or p_orderColumn<> '' then 
            v_sql:=v_sql||' order by  '||p_orderColumn ;
            --排序方式判断

            if p_orderStyle is not null or p_orderStyle<> ''  then
                v_sql:=v_sql ||' '||p_orderStyle;
            end if;
        else
            null;
        end if;
        v_sql:=v_sql||' ) e)  where rs>'||(p_page-1)*p_rows||
        ' and '||' rs <='|| (p_page)*p_rows;
        --打印sql语句
        DBMS_OUTPUT.PUT_LINE(v_sql);
        open p_cursor for v_sql;
    exception 
        when others then 
             DBMS_OUTPUT.PUT_LINE(sqlerrm);

    end sp_select_pagination;

end;

commit;
