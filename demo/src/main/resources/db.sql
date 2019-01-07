create table acceptance_order
(
	id bigint not null
		primary key,
	mblnr varchar(50) null comment '物料凭证编号',
	mjahr varchar(50) null comment '物料凭证年度',
	budat varchar(50) null comment '凭证中的过帐日期',
	lifnr varchar(50) null comment '供应商帐户号',
	name1 varchar(50) null comment '名称1',
	zeile varchar(50) null comment '物料凭证中的项目',
	matnr varchar(50) null comment '物料编号',
	maktx varchar(50) null comment '物料描述',
	charg varchar(50) null comment '批号',
	menge varchar(50) null comment '采购订单数量',
	meins varchar(50) null comment '订单单位',
	werks varchar(50) null comment '工厂',
	lgort varchar(50) null comment '库存地点',
	bwart varchar(50) null comment '移动类型(库存管理)',
	is_deleted tinyint(1) null,
	status int null
)
comment '验收单' engine=InnoDB
;

create table city
(
	id bigint null,
	province_id bigint null,
	city_name varchar(30) null,
	description varchar(30) null
)
engine=InnoDB charset=latin1
;

create table invoice_info
(
	id bigint not null
		primary key,
	mandt varchar(50) null comment '集团',
	bukrs varchar(50) null comment '公司代码',
	belnr varchar(50) null comment '会计凭证号码',
	buzei int null comment '会计凭证中的行项目数',
	gjahr int null comment '财年',
	zuonr varchar(50) null comment '分配编号',
	wrbtr double null comment '金额',
	waers varchar(50) null comment '货币码'
)
comment '发票信息' engine=InnoDB
;

create table material_info
(
	id bigint not null
		primary key,
	mandt varchar(50) null comment '集团',
	bukrs varchar(50) null comment '公司代码',
	belnr varchar(50) null comment '会计凭证号码',
	buzei int null comment '会计凭证中的行项目数',
	gjahr int null comment '财年',
	matnr varchar(50) null comment '物料编号'
)
comment '物料信息' engine=InnoDB
;

create table purchase_info
(
	id bigint not null
		primary key,
	lifnr varchar(20) null,
	name1 varchar(50) null comment '名称',
	matnr varchar(20) null,
	maktx varchar(8) null,
	kschl varchar(20) null,
	vtext varchar(30) null,
	kbetr decimal(11,2) null,
	konwa decimal(11) null,
	datab datetime null,
	datbi datetime null,
	kzust varchar(10) null,
	vtext1 varchar(50) null,
	is_deleted int null,
	status int null
)
engine=InnoDB
;

create table return_voucher
(
	id bigint not null
		primary key,
	mblnr varchar(50) null comment '物料凭证编号',
	mjahr int(8) null comment '物料凭证年度',
	budat datetime null comment '凭证中的过帐日期',
	lifnr varchar(50) null comment '供应商帐户号',
	name1 varchar(50) null comment '名称1',
	matnr varchar(50) null comment '物料编号',
	zeile int null comment '物料凭证中的项目',
	maktx varchar(50) null comment '物料描述',
	charg varchar(50) null comment '批号',
	enmng varchar(50) null comment '提货数',
	meins varchar(50) null comment '订单单位',
	werks varchar(8) null comment '工厂',
	lgort varchar(50) null comment '库存地点',
	bwart varchar(10) null comment '移动类型(库存管理)',
	erdat varchar(50) null comment '记录创建日期'
)
comment '退货凭证' engine=InnoDB
;

-- 供应商
CREATE TABLE supplier(
  id bigint NOT NULL PRIMARY KEY ,
  name VARCHAR(30) null COMMENT '供应商名称',
  account VARCHAR(30) NULL COMMENT '供应商账号',
  address VARCHAR(100) NULL COMMENT '供应商地址',
  created_at DATETIME COMMENT '创建日期',
  updated_at DATETIME COMMENT '修改日期',
  is_deleted TINYINT COMMENT '是否删除;0:未删除,1:已删除',
  status INT(4) COMMENT '状态'
) comment '供应商' engine=InnoDB;


-- 应付账款
CREATE TABLE payable(
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  supplier_name VARCHAR(50) COMMENT '供应商名称',
  supplier_account VARCHAR(50) COMMENT '供应商账号',
  invoice_quantity INT COMMENT '发票数量',
  financing_amount DECIMAL(10,2) COMMENT '融资金额',
  created_at DATETIME COMMENT '创建日期',
  updated_at DATETIME COMMENT '修改日期',
  is_deleted TINYINT COMMENT '是否删除;0:未删除,1:已删除',
  status INT(4) COMMENT '状态'
) COMMENT '应付账款' ENGINE =InnoDB;