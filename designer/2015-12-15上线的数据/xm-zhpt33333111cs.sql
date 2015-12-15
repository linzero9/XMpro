-------------------------------------------------
-- Export file for user ZHPTCS                 --
-- Created by WUJIAJUN on 2015/12/15, 19:41:05 --
-------------------------------------------------

set define off
spool xm-zhpt33333111cs.log

prompt
prompt Creating table ABF_T_JGFJXXB
prompt ============================
prompt
create table ZHPTCS.ABF_T_JGFJXXB
(
  orgid        NUMBER(10) not null,
  manaposition NUMBER(10),
  managerid    NUMBER(10),
  orgmanager   VARCHAR2(128),
  weburl       VARCHAR2(512),
  createtime   DATE,
  startdate    DATE,
  enddate      DATE,
  linkman      VARCHAR2(30),
  linktel      VARCHAR2(20),
  orgaddr      VARCHAR2(256),
  zipcode      VARCHAR2(10),
  email        VARCHAR2(128),
  reserve1     VARCHAR2(100),
  reserve2     VARCHAR2(100),
  reserve3     VARCHAR2(100),
  reserve4     VARCHAR2(100),
  reserve5     VARCHAR2(100),
  reserve6     VARCHAR2(100),
  reserve7     VARCHAR2(100),
  reserve8     VARCHAR2(100),
  reserve9     VARCHAR2(100),
  orglevel     NUMBER(2)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.ABF_T_JGFJXXB
  is '机构附加信息表';
comment on column ZHPTCS.ABF_T_JGFJXXB.orgid
  is '机构ID';
comment on column ZHPTCS.ABF_T_JGFJXXB.manaposition
  is '机构主管岗位';
comment on column ZHPTCS.ABF_T_JGFJXXB.managerid
  is '机构主管人员';
comment on column ZHPTCS.ABF_T_JGFJXXB.orgmanager
  is '机构管理员';
comment on column ZHPTCS.ABF_T_JGFJXXB.weburl
  is '网站地址';
comment on column ZHPTCS.ABF_T_JGFJXXB.createtime
  is '创建时间';
comment on column ZHPTCS.ABF_T_JGFJXXB.startdate
  is '生效日期';
comment on column ZHPTCS.ABF_T_JGFJXXB.enddate
  is '失效日期';
comment on column ZHPTCS.ABF_T_JGFJXXB.linkman
  is '联系人';
comment on column ZHPTCS.ABF_T_JGFJXXB.linktel
  is '联系电话';
comment on column ZHPTCS.ABF_T_JGFJXXB.orgaddr
  is '地址';
comment on column ZHPTCS.ABF_T_JGFJXXB.zipcode
  is '邮政编码';
comment on column ZHPTCS.ABF_T_JGFJXXB.email
  is '电子邮件';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve1
  is '预留字段1';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve2
  is '预留字段2';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve3
  is '预留字段3';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve4
  is '预留字段4';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve5
  is '预留字段5';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve6
  is '预留字段6';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve7
  is '预留字段7';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve8
  is '预留字段8';
comment on column ZHPTCS.ABF_T_JGFJXXB.reserve9
  is '预留字段9';
comment on column ZHPTCS.ABF_T_JGFJXXB.orglevel
  is '机构层次';
alter table ZHPTCS.ABF_T_JGFJXXB
  add constraint PK_ABF_T_JGFJXXB primary key (ORGID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ABF_T_RYKGLJG
prompt ============================
prompt
create table ZHPTCS.ABF_T_RYKGLJG
(
  id           NUMBER(10) not null,
  empid        NUMBER(18),
  orgid        NUMBER(10),
  remark       VARCHAR2(300),
  orgcode      VARCHAR2(10),
  orgname      VARCHAR2(100),
  userid       VARCHAR2(64),
  operatorname VARCHAR2(64)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 512K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.ABF_T_RYKGLJG
  is '人员可管理机构';
comment on column ZHPTCS.ABF_T_RYKGLJG.id
  is '编号';
comment on column ZHPTCS.ABF_T_RYKGLJG.empid
  is '员工ID';
comment on column ZHPTCS.ABF_T_RYKGLJG.orgid
  is '可管理机构ID';
comment on column ZHPTCS.ABF_T_RYKGLJG.remark
  is '备注';
comment on column ZHPTCS.ABF_T_RYKGLJG.orgcode
  is '机构编号';
comment on column ZHPTCS.ABF_T_RYKGLJG.orgname
  is '机构名称';
comment on column ZHPTCS.ABF_T_RYKGLJG.userid
  is '人员系统账号';
comment on column ZHPTCS.ABF_T_RYKGLJG.operatorname
  is '人员';
create index ZHPTCS.ABF_T_RYKGLJG_EMPID on ZHPTCS.ABF_T_RYKGLJG (EMPID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.ABF_T_RYKGLJG
  add constraint PK_ABF_T_RYKGLJG primary key (ID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ABF_T_YGFJXXB
prompt ============================
prompt
create table ZHPTCS.ABF_T_YGFJXXB
(
  empid        NUMBER(10) not null,
  birthdate    DATE,
  otel         VARCHAR2(20),
  oaddress     VARCHAR2(255),
  ozipcode     VARCHAR2(10),
  oemail       VARCHAR2(128),
  faxno        VARCHAR2(14),
  mobileno     VARCHAR2(14),
  mobshow      CHAR(1),
  msn          VARCHAR2(16),
  htel         VARCHAR2(20),
  htshow       CHAR(1),
  haddress     VARCHAR2(128),
  hzipcode     VARCHAR2(10),
  pemail       VARCHAR2(128),
  party        VARCHAR2(255),
  major        NUMBER(10),
  workexp      VARCHAR2(512),
  regdate      DATE,
  createtime   TIMESTAMP(6),
  lastmodytime TIMESTAMP(6),
  remark       VARCHAR2(512),
  displayorder VARCHAR2(20),
  reserve1     VARCHAR2(100),
  reserve2     VARCHAR2(100),
  reserve3     VARCHAR2(100),
  reserve4     VARCHAR2(100),
  reserve5     VARCHAR2(100),
  reserve6     VARCHAR2(100),
  reserve7     VARCHAR2(100),
  reserve8     VARCHAR2(100),
  reserve9     VARCHAR2(100)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 256K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.ABF_T_YGFJXXB
  is '员工附加信息表';
comment on column ZHPTCS.ABF_T_YGFJXXB.empid
  is '员工ID';
comment on column ZHPTCS.ABF_T_YGFJXXB.birthdate
  is '出生日期';
comment on column ZHPTCS.ABF_T_YGFJXXB.otel
  is '办公电话';
comment on column ZHPTCS.ABF_T_YGFJXXB.oaddress
  is '办公地址';
comment on column ZHPTCS.ABF_T_YGFJXXB.ozipcode
  is '办公邮编';
comment on column ZHPTCS.ABF_T_YGFJXXB.oemail
  is '办公邮件';
comment on column ZHPTCS.ABF_T_YGFJXXB.faxno
  is '传真号码';
comment on column ZHPTCS.ABF_T_YGFJXXB.mobileno
  is '手机号码';
comment on column ZHPTCS.ABF_T_YGFJXXB.mobshow
  is '是否显示';
comment on column ZHPTCS.ABF_T_YGFJXXB.msn
  is 'MSN号码';
comment on column ZHPTCS.ABF_T_YGFJXXB.htel
  is '家庭电话';
comment on column ZHPTCS.ABF_T_YGFJXXB.htshow
  is '是否显示家庭电话';
comment on column ZHPTCS.ABF_T_YGFJXXB.haddress
  is '家庭地址';
comment on column ZHPTCS.ABF_T_YGFJXXB.hzipcode
  is '家庭邮编';
comment on column ZHPTCS.ABF_T_YGFJXXB.pemail
  is '私人电子邮箱';
comment on column ZHPTCS.ABF_T_YGFJXXB.party
  is '政治面貌';
comment on column ZHPTCS.ABF_T_YGFJXXB.major
  is '直接主管';
comment on column ZHPTCS.ABF_T_YGFJXXB.workexp
  is '工作描述';
comment on column ZHPTCS.ABF_T_YGFJXXB.regdate
  is '注册日期';
comment on column ZHPTCS.ABF_T_YGFJXXB.createtime
  is '创建时间';
comment on column ZHPTCS.ABF_T_YGFJXXB.lastmodytime
  is '最新更新时间';
comment on column ZHPTCS.ABF_T_YGFJXXB.remark
  is '备注';
comment on column ZHPTCS.ABF_T_YGFJXXB.displayorder
  is '显示顺序';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve1
  is '预留字段1';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve2
  is '预留字段2';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve3
  is '预留字段3';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve4
  is '预留字段4';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve5
  is '预留字段5';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve6
  is '预留字段6';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve7
  is '预留字段7';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve8
  is '预留字段8';
comment on column ZHPTCS.ABF_T_YGFJXXB.reserve9
  is '预留字段9';
alter table ZHPTCS.ABF_T_YGFJXXB
  add constraint PK_ABF_T_YGFJXXB primary key (EMPID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 320K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ABF_T_ZZJGGXSB
prompt =============================
prompt
create table ZHPTCS.ABF_T_ZZJGGXSB
(
  id            NUMBER(10) not null,
  orgid         NUMBER(10),
  orgcode       VARCHAR2(10),
  orgname       VARCHAR2(64),
  orgaliasname  VARCHAR2(64),
  parentid      NUMBER(10),
  parentorgid   NUMBER(10),
  parentorgcode VARCHAR2(10),
  orgtype       NUMBER(1),
  displayorder  VARCHAR2(20),
  mappid        VARCHAR2(10),
  topid         NUMBER(10),
  orgdegree     VARCHAR2(25),
  sourceorgtype VARCHAR2(12),
  jgsx          NUMBER
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 2M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.ABF_T_ZZJGGXSB
  is '组织机构关系树表';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.id
  is '组织机构树ID';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.orgid
  is '机构ID';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.orgcode
  is '机构编号';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.orgname
  is '机构名称';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.orgaliasname
  is '机构显示名称';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.parentid
  is '上级ID';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.parentorgid
  is '上级机构ID';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.parentorgcode
  is '上级机构编号';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.orgtype
  is '上级机构类型';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.displayorder
  is '显示顺序';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.mappid
  is '映射ID';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.topid
  is '所属机构树ID';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.orgdegree
  is '机构等级';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.sourceorgtype
  is '1、直属/2、实体/3、内设/4、区域';
comment on column ZHPTCS.ABF_T_ZZJGGXSB.jgsx
  is '机构属性    1、银行/2、邮政';
create index ZHPTCS.ZZJGGXSB_PARENTID on ZHPTCS.ABF_T_ZZJGGXSB (TOPID, PARENTID, SOURCEORGTYPE)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 448K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.ZZJGGXSB_PARENTORGID on ZHPTCS.ABF_T_ZZJGGXSB (PARENTORGID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 256K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.ABF_T_ZZJGGXSB
  add constraint PK_ABF_T_ZZJGGXSB primary key (ID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.ABF_T_ZZJGGXSB
  add constraint ZZJGGXSB_U unique (ORGCODE, ORGID, TOPID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 448K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ABF_T_ZZJGSB
prompt ===========================
prompt
create table ZHPTCS.ABF_T_ZZJGSB
(
  id      NUMBER(10) not null,
  zzjgsmc VARCHAR2(64),
  gnsm    VARCHAR2(512),
  sxfl    NUMBER
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.ABF_T_ZZJGSB
  is '组织机构树表';
comment on column ZHPTCS.ABF_T_ZZJGSB.id
  is '组织机构树ID';
comment on column ZHPTCS.ABF_T_ZZJGSB.zzjgsmc
  is '组织机构树名称';
comment on column ZHPTCS.ABF_T_ZZJGSB.gnsm
  is '功能说明';
comment on column ZHPTCS.ABF_T_ZZJGSB.sxfl
  is '属性分类';
alter table ZHPTCS.ABF_T_ZZJGSB
  add constraint PK_ABF_T_ZZJGSB primary key (ID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_APPLICATION
prompt =============================
prompt
create table ZHPTCS.AC_APPLICATION
(
  appid        NUMBER(10) not null,
  appcode      VARCHAR2(10),
  appname      VARCHAR2(50),
  apptype      VARCHAR2(255),
  isopen       CHAR(1),
  opendate     DATE,
  url          VARCHAR2(256),
  appdesc      VARCHAR2(512),
  maintenance  NUMBER(10),
  manarole     VARCHAR2(512),
  demo         VARCHAR2(512),
  iniwp        CHAR(1),
  intaskcenter CHAR(1),
  ipaddr       VARCHAR2(50),
  ipport       VARCHAR2(10),
  islock       CHAR(1),
  issyn        CHAR(1),
  sso_mode     CHAR(2),
  para_count   NUMBER(2),
  para_code1   VARCHAR2(20),
  para_name1   VARCHAR2(20),
  para_code2   VARCHAR2(20),
  para_name2   VARCHAR2(20),
  para_code3   VARCHAR2(20),
  para_name3   VARCHAR2(20),
  para_code4   VARCHAR2(20),
  para_name4   VARCHAR2(20),
  para_code5   VARCHAR2(20),
  para_name5   VARCHAR2(20),
  app_icon     VARCHAR2(100)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_APPLICATION
  is '应用系统注册表';
comment on column ZHPTCS.AC_APPLICATION.appid
  is '系统编号';
comment on column ZHPTCS.AC_APPLICATION.appcode
  is '应用代码';
comment on column ZHPTCS.AC_APPLICATION.appname
  is '系统名称';
comment on column ZHPTCS.AC_APPLICATION.apptype
  is '应用类型';
comment on column ZHPTCS.AC_APPLICATION.isopen
  is '是否开通';
comment on column ZHPTCS.AC_APPLICATION.opendate
  is '开通日期';
comment on column ZHPTCS.AC_APPLICATION.url
  is '访问地址';
comment on column ZHPTCS.AC_APPLICATION.appdesc
  is '应用描述';
comment on column ZHPTCS.AC_APPLICATION.maintenance
  is '管理维护人员';
comment on column ZHPTCS.AC_APPLICATION.manarole
  is '应用管理角色';
comment on column ZHPTCS.AC_APPLICATION.demo
  is '备注';
comment on column ZHPTCS.AC_APPLICATION.iniwp
  is '0:否,1:是';
comment on column ZHPTCS.AC_APPLICATION.intaskcenter
  is '0:否,1:是';
comment on column ZHPTCS.AC_APPLICATION.ipaddr
  is 'IP';
comment on column ZHPTCS.AC_APPLICATION.ipport
  is '端口';
comment on column ZHPTCS.AC_APPLICATION.islock
  is '是否锁定';
comment on column ZHPTCS.AC_APPLICATION.issyn
  is '是否同步';
comment on column ZHPTCS.AC_APPLICATION.sso_mode
  is '单点模式 00:cas;01:form';
comment on column ZHPTCS.AC_APPLICATION.para_count
  is '参数数量';
comment on column ZHPTCS.AC_APPLICATION.para_code1
  is '参数代码1';
comment on column ZHPTCS.AC_APPLICATION.para_name1
  is '参数名称1';
comment on column ZHPTCS.AC_APPLICATION.para_code2
  is '参数代码2';
comment on column ZHPTCS.AC_APPLICATION.para_name2
  is '参数名称2';
comment on column ZHPTCS.AC_APPLICATION.para_code3
  is '参数代码3';
comment on column ZHPTCS.AC_APPLICATION.para_name3
  is '参数名称3';
comment on column ZHPTCS.AC_APPLICATION.para_code4
  is '参数代码4';
comment on column ZHPTCS.AC_APPLICATION.para_name4
  is '参数名称4';
comment on column ZHPTCS.AC_APPLICATION.para_code5
  is '参数代码5';
comment on column ZHPTCS.AC_APPLICATION.para_name5
  is '参数名称5';
comment on column ZHPTCS.AC_APPLICATION.app_icon
  is '系统图标';
alter table ZHPTCS.AC_APPLICATION
  add constraint PK_AC_APPLICATION primary key (APPID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_ENTITYFIELDROLE
prompt =================================
prompt
create table ZHPTCS.AC_ENTITYFIELDROLE
(
  fieldid  NUMBER(10) not null,
  roleid   VARCHAR2(64) not null,
  ismodify CHAR(1),
  isview   CHAR(1),
  column_5 CHAR(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_ENTITYFIELDROLE
  is '角色与实体字段（属性）的对应关系';
comment on column ZHPTCS.AC_ENTITYFIELDROLE.fieldid
  is 'FIELDID';
comment on column ZHPTCS.AC_ENTITYFIELDROLE.roleid
  is 'ROLEID';
comment on column ZHPTCS.AC_ENTITYFIELDROLE.ismodify
  is 'ISMODIFY';
comment on column ZHPTCS.AC_ENTITYFIELDROLE.isview
  is 'Y/N';
comment on column ZHPTCS.AC_ENTITYFIELDROLE.column_5
  is 'Column_5';
alter table ZHPTCS.AC_ENTITYFIELDROLE
  add constraint PK_AC_ENTITYFIELDROLE primary key (FIELDID, ROLEID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_ENTITYROLE
prompt ============================
prompt
create table ZHPTCS.AC_ENTITYROLE
(
  entityid NUMBER(10) not null,
  roleid   VARCHAR2(64) not null,
  isadd    CHAR(1),
  isdel    CHAR(1),
  ismodify CHAR(1),
  isview   CHAR(1)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_ENTITYROLE
  is '角色与数据实体的对应关系';
comment on column ZHPTCS.AC_ENTITYROLE.entityid
  is 'ENTITYID';
comment on column ZHPTCS.AC_ENTITYROLE.roleid
  is 'ROLEID';
comment on column ZHPTCS.AC_ENTITYROLE.isadd
  is 'Y/N';
comment on column ZHPTCS.AC_ENTITYROLE.isdel
  is 'Y/N';
comment on column ZHPTCS.AC_ENTITYROLE.ismodify
  is 'Y/N';
comment on column ZHPTCS.AC_ENTITYROLE.isview
  is 'Y/N';
alter table ZHPTCS.AC_ENTITYROLE
  add constraint PK_AC_ENTITYROLE primary key (ENTITYID, ROLEID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_FUNCGROUP
prompt ===========================
prompt
create table ZHPTCS.AC_FUNCGROUP
(
  funcgroupid   NUMBER(10) not null,
  funcgroupname VARCHAR2(40),
  grouplevel    NUMBER(38),
  funcgroupseq  VARCHAR2(256),
  isleaf        CHAR(1),
  subcount      NUMBER(10),
  islock        CHAR(1),
  displayorder  VARCHAR2(20),
  groupaction   VARCHAR2(556),
  groupicon     VARCHAR2(100),
  type          NUMBER(1),
  parentgroup   NUMBER(10),
  appid         NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_FUNCGROUP
  is '功能组可以理解为功能模块或者构件包，是指一类相关功能的集合。定义功能组主要是为了对系统的功能进行归类管理功能组隶属于某个应用功能组支持层次';
comment on column ZHPTCS.AC_FUNCGROUP.funcgroupid
  is '功能组编号';
comment on column ZHPTCS.AC_FUNCGROUP.funcgroupname
  is '功能组名称';
comment on column ZHPTCS.AC_FUNCGROUP.grouplevel
  is '节点层次';
comment on column ZHPTCS.AC_FUNCGROUP.funcgroupseq
  is '功能组路径序列';
comment on column ZHPTCS.AC_FUNCGROUP.isleaf
  is '是否叶子节点';
comment on column ZHPTCS.AC_FUNCGROUP.subcount
  is '子节点数';
comment on column ZHPTCS.AC_FUNCGROUP.islock
  is '是否锁定';
comment on column ZHPTCS.AC_FUNCGROUP.displayorder
  is '显示顺序';
comment on column ZHPTCS.AC_FUNCGROUP.groupaction
  is '功能组入口';
comment on column ZHPTCS.AC_FUNCGROUP.groupicon
  is '功能组图标';
alter table ZHPTCS.AC_FUNCGROUP
  add constraint PK_AC_FUNCGROUP primary key (FUNCGROUPID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_FUNCTION
prompt ==========================
prompt
create table ZHPTCS.AC_FUNCTION
(
  funccode     VARCHAR2(40) not null,
  funcgroupid  NUMBER(10),
  funcname     VARCHAR2(128),
  funcdesc     VARCHAR2(512),
  funcaction   VARCHAR2(556) not null,
  parainfo     VARCHAR2(256),
  ischeck      CHAR(1),
  functype     VARCHAR2(255),
  ismenu       CHAR(1),
  islock       CHAR(1),
  displayorder VARCHAR2(200),
  funicon      VARCHAR2(100)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_FUNCTION
  is '功能定义表，每个功能属于一个功能点，隶属于某个应用系统，同时也隶属于某个功能组';
comment on column ZHPTCS.AC_FUNCTION.funccode
  is '功能编号';
comment on column ZHPTCS.AC_FUNCTION.funcgroupid
  is '功能组编号';
comment on column ZHPTCS.AC_FUNCTION.funcname
  is '功能名称';
comment on column ZHPTCS.AC_FUNCTION.funcdesc
  is '功能描述';
comment on column ZHPTCS.AC_FUNCTION.funcaction
  is '功能调用入口';
comment on column ZHPTCS.AC_FUNCTION.parainfo
  is '需要定义参数规范';
comment on column ZHPTCS.AC_FUNCTION.ischeck
  is '是否验证权限';
comment on column ZHPTCS.AC_FUNCTION.functype
  is '前台功能、后台服务、报表功能...';
comment on column ZHPTCS.AC_FUNCTION.ismenu
  is '该功能是否可以作为菜单入口';
comment on column ZHPTCS.AC_FUNCTION.islock
  is '是否锁定';
comment on column ZHPTCS.AC_FUNCTION.displayorder
  is '显示顺序';
comment on column ZHPTCS.AC_FUNCTION.funicon
  is '功能图标';
alter table ZHPTCS.AC_FUNCTION
  add constraint PK_AC_FUNCTION primary key (FUNCCODE)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_OPERATOR
prompt ==========================
prompt
create table ZHPTCS.AC_OPERATOR
(
  operatorid   NUMBER(18),
  userid       VARCHAR2(64) not null,
  password     VARCHAR2(100),
  invaldate    DATE,
  operatorname VARCHAR2(64),
  authmode     VARCHAR2(255),
  status       VARCHAR2(255),
  unlocktime   TIMESTAMP(6),
  menutype     VARCHAR2(255),
  lastlogin    TIMESTAMP(6),
  errcount     NUMBER(10),
  startdate    DATE,
  enddate      DATE,
  validtime    VARCHAR2(256),
  maccode      VARCHAR2(128),
  ipaddress    VARCHAR2(128),
  email        VARCHAR2(255),
  empid        NUMBER(10),
  headpicicon  VARCHAR2(255),
  layoutmode   CHAR(2) default '00'
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 2M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_OPERATOR
  is '系统登录用户表';
comment on column ZHPTCS.AC_OPERATOR.operatorid
  is '操作员编号';
comment on column ZHPTCS.AC_OPERATOR.userid
  is '登录用户名';
comment on column ZHPTCS.AC_OPERATOR.password
  is '密码';
comment on column ZHPTCS.AC_OPERATOR.invaldate
  is '密码失效日期';
comment on column ZHPTCS.AC_OPERATOR.operatorname
  is '操作员名称';
comment on column ZHPTCS.AC_OPERATOR.authmode
  is '本地密码认证、LDAP认证、等';
comment on column ZHPTCS.AC_OPERATOR.status
  is '正常，挂起，注销，锁定...';
comment on column ZHPTCS.AC_OPERATOR.unlocktime
  is '当状态为锁定时，解锁的时间';
comment on column ZHPTCS.AC_OPERATOR.menutype
  is '用户登录后菜单的风格';
comment on column ZHPTCS.AC_OPERATOR.lastlogin
  is '最近登录时间';
comment on column ZHPTCS.AC_OPERATOR.errcount
  is '最新登录错误次数';
comment on column ZHPTCS.AC_OPERATOR.startdate
  is '有效开始日期';
comment on column ZHPTCS.AC_OPERATOR.enddate
  is '有效截止日期';
comment on column ZHPTCS.AC_OPERATOR.validtime
  is '定义一个规则表达式，表示允许操作的有效时间范围';
comment on column ZHPTCS.AC_OPERATOR.maccode
  is '允许设置多个MAC';
comment on column ZHPTCS.AC_OPERATOR.ipaddress
  is '允许设置多个IP地址';
comment on column ZHPTCS.AC_OPERATOR.email
  is '邮箱地址';
comment on column ZHPTCS.AC_OPERATOR.empid
  is '员工编号';
comment on column ZHPTCS.AC_OPERATOR.headpicicon
  is '头像';
comment on column ZHPTCS.AC_OPERATOR.layoutmode
  is '首页版面模式';
create unique index ZHPTCS.AC_OPERATOR_INDEX on ZHPTCS.AC_OPERATOR (OPERATORID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 384K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.AC_OPERATOR
  add constraint PK_AC_OPERATOR primary key (USERID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 576K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_OPERATORROLE
prompt ==============================
prompt
create table ZHPTCS.AC_OPERATORROLE
(
  operatorid NUMBER(18) not null,
  roleid     VARCHAR2(64) not null,
  auth       VARCHAR2(255),
  agency     NUMBER default 0
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_OPERATORROLE
  is '操作员角色';
comment on column ZHPTCS.AC_OPERATORROLE.operatorid
  is '操作员编号';
comment on column ZHPTCS.AC_OPERATORROLE.roleid
  is '角色编号';
comment on column ZHPTCS.AC_OPERATORROLE.auth
  is '预留字段';
comment on column ZHPTCS.AC_OPERATORROLE.agency
  is '角色类型';
create unique index ZHPTCS.AC_OPERATORROLE_INDEX on ZHPTCS.AC_OPERATORROLE (OPERATORID, ROLEID, AGENCY)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.AC_OPERATORROLE
  add constraint PK_AC_OPERATORROLE2 primary key (OPERATORID, ROLEID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_ROLE
prompt ======================
prompt
create table ZHPTCS.AC_ROLE
(
  roleid        VARCHAR2(64) not null,
  rolename      VARCHAR2(64),
  roletype      VARCHAR2(255),
  roledesc      VARCHAR2(256),
  appid         NUMBER(10),
  auto          VARCHAR2(64),
  roletypefield NUMBER
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_ROLE
  is '权限集（角色）定义表';
comment on column ZHPTCS.AC_ROLE.roleid
  is '角色编号';
comment on column ZHPTCS.AC_ROLE.rolename
  is '角色名称';
comment on column ZHPTCS.AC_ROLE.roletype
  is '全局型角色、应用级角色';
comment on column ZHPTCS.AC_ROLE.roledesc
  is '角色描述';
comment on column ZHPTCS.AC_ROLE.appid
  is '应用编号';
comment on column ZHPTCS.AC_ROLE.auto
  is '是否为自动角色';
comment on column ZHPTCS.AC_ROLE.roletypefield
  is '角色性质   1 、自营2、代理';
alter table ZHPTCS.AC_ROLE
  add constraint PK_AC_ROLE primary key (ROLEID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_ROLEDATAPRIV
prompt ==============================
prompt
create table ZHPTCS.AC_ROLEDATAPRIV
(
  roleid      VARCHAR2(64) not null,
  privilegeid NUMBER(10) not null
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_ROLEDATAPRIV
  is '配置角色具有的数据权限';
comment on column ZHPTCS.AC_ROLEDATAPRIV.roleid
  is '角色ID';
comment on column ZHPTCS.AC_ROLEDATAPRIV.privilegeid
  is '数据ID';
alter table ZHPTCS.AC_ROLEDATAPRIV
  add constraint PK_AC_ROLEDATAPRIV primary key (ROLEID, PRIVILEGEID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_ROLEFUNC
prompt ==========================
prompt
create table ZHPTCS.AC_ROLEFUNC
(
  roleid      VARCHAR2(64) not null,
  funccode    VARCHAR2(40) not null,
  appid       NUMBER(10),
  funcgroupid NUMBER(10),
  islock      CHAR(18),
  type        NUMBER(1) default 0
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_ROLEFUNC
  is '角色所包含的功能清单';
comment on column ZHPTCS.AC_ROLEFUNC.roleid
  is '角色编号';
comment on column ZHPTCS.AC_ROLEFUNC.funccode
  is '功能编号';
comment on column ZHPTCS.AC_ROLEFUNC.appid
  is '冗余字段';
comment on column ZHPTCS.AC_ROLEFUNC.funcgroupid
  is '冗余字段';
comment on column ZHPTCS.AC_ROLEFUNC.islock
  is '是否被锁定';
alter table ZHPTCS.AC_ROLEFUNC
  add constraint PK_AC_ROLEFUNC primary key (ROLEID, FUNCCODE)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table AC_ROLEFUNCLOCK
prompt ==============================
prompt
create table ZHPTCS.AC_ROLEFUNCLOCK
(
  roleid      VARCHAR2(64) not null,
  appid       NUMBER(10) not null,
  islock      CHAR(1),
  funccode    VARCHAR2(40),
  funcgroupid NUMBER(10) not null
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.AC_ROLEFUNCLOCK
  is '选中锁定';
comment on column ZHPTCS.AC_ROLEFUNCLOCK.roleid
  is '角色编号';
comment on column ZHPTCS.AC_ROLEFUNCLOCK.appid
  is '应用编号';
comment on column ZHPTCS.AC_ROLEFUNCLOCK.islock
  is '是否被锁定';
comment on column ZHPTCS.AC_ROLEFUNCLOCK.funccode
  is '功能编号';
comment on column ZHPTCS.AC_ROLEFUNCLOCK.funcgroupid
  is '功能组编号';

prompt
prompt Creating table EOS_DICT_ENTRY
prompt =============================
prompt
create table ZHPTCS.EOS_DICT_ENTRY
(
  dicttypeid VARCHAR2(128) not null,
  dictid     VARCHAR2(128) not null,
  dictname   VARCHAR2(255),
  status     NUMBER(10),
  sortno     NUMBER(10),
  rank       NUMBER(10),
  parentid   VARCHAR2(255),
  seqno      VARCHAR2(255),
  filter1    VARCHAR2(255),
  filter2    VARCHAR2(255)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.EOS_DICT_ENTRY
  is '数据字典项';
comment on column ZHPTCS.EOS_DICT_ENTRY.dicttypeid
  is '类型编号';
comment on column ZHPTCS.EOS_DICT_ENTRY.dictid
  is '项编号';
comment on column ZHPTCS.EOS_DICT_ENTRY.dictname
  is '项名称';
comment on column ZHPTCS.EOS_DICT_ENTRY.status
  is '状态';
comment on column ZHPTCS.EOS_DICT_ENTRY.sortno
  is '排序';
comment on column ZHPTCS.EOS_DICT_ENTRY.rank
  is '备注';
comment on column ZHPTCS.EOS_DICT_ENTRY.parentid
  is '上级项编号';
comment on column ZHPTCS.EOS_DICT_ENTRY.seqno
  is '项序列';
comment on column ZHPTCS.EOS_DICT_ENTRY.filter1
  is '字段1';
comment on column ZHPTCS.EOS_DICT_ENTRY.filter2
  is '字段2';
alter table ZHPTCS.EOS_DICT_ENTRY
  add constraint PK_EOS_DICT_ENTRY primary key (DICTTYPEID, DICTID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table EOS_DICT_TYPE
prompt ============================
prompt
create table ZHPTCS.EOS_DICT_TYPE
(
  dicttypeid   VARCHAR2(128) not null,
  dicttypename VARCHAR2(255),
  rank         NUMBER(10),
  parentid     VARCHAR2(255),
  seqno        VARCHAR2(255)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.EOS_DICT_TYPE
  is '数据字典类型';
comment on column ZHPTCS.EOS_DICT_TYPE.dicttypeid
  is '类型编号';
comment on column ZHPTCS.EOS_DICT_TYPE.dicttypename
  is '类型名称';
comment on column ZHPTCS.EOS_DICT_TYPE.rank
  is '备注';
comment on column ZHPTCS.EOS_DICT_TYPE.parentid
  is '上级类型编号';
comment on column ZHPTCS.EOS_DICT_TYPE.seqno
  is '类型序列';
alter table ZHPTCS.EOS_DICT_TYPE
  add constraint PK_EOS_DICT_TYPE primary key (DICTTYPEID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table IMP_LOG
prompt ======================
prompt
create table ZHPTCS.IMP_LOG
(
  lid          NUMBER(10),
  mcode        VARCHAR2(20),
  imp_empid    NUMBER(10),
  imp_time     VARCHAR2(14),
  success_rows NUMBER(10),
  fail_rows    NUMBER(10),
  error_excel  VARCHAR2(300),
  error_info   VARCHAR2(1024),
  imp_org      VARCHAR2(9),
  status       CHAR(1)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.IMP_LOG
  is '导入EXCEL日志表';
comment on column ZHPTCS.IMP_LOG.lid
  is '流水ID';
comment on column ZHPTCS.IMP_LOG.mcode
  is '对应导入的功能';
comment on column ZHPTCS.IMP_LOG.imp_empid
  is '导入人员';
comment on column ZHPTCS.IMP_LOG.imp_time
  is '导入日期';
comment on column ZHPTCS.IMP_LOG.success_rows
  is '成功导入行';
comment on column ZHPTCS.IMP_LOG.fail_rows
  is '失败的行数';
comment on column ZHPTCS.IMP_LOG.error_excel
  is '失败附件路径';
comment on column ZHPTCS.IMP_LOG.error_info
  is '失败信息';
comment on column ZHPTCS.IMP_LOG.imp_org
  is '导入人员机构';
comment on column ZHPTCS.IMP_LOG.status
  is '状态（B，开始，E，结束）';
alter table ZHPTCS.IMP_LOG
  add constraint AK_KEY_1_IMP_LOG unique (LID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table IMP_MODEL_CONFIG
prompt ===============================
prompt
create table ZHPTCS.IMP_MODEL_CONFIG
(
  mcode       VARCHAR2(20) not null,
  import_name VARCHAR2(100),
  import_type CHAR(1),
  run_type    CHAR(1)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.IMP_MODEL_CONFIG
  is 'EXCEL导入功能定义表';
comment on column ZHPTCS.IMP_MODEL_CONFIG.mcode
  is '主键编码';
comment on column ZHPTCS.IMP_MODEL_CONFIG.import_name
  is '功能名称';
comment on column ZHPTCS.IMP_MODEL_CONFIG.import_type
  is 'CMMS_IMP_TYPE 导入类型（1增量、2按个人全量，先删除个人导入的所有数据，再执行导入、3按月、4全量，整个先备份，再删除）';
comment on column ZHPTCS.IMP_MODEL_CONFIG.run_type
  is 'CMMS_IMP_RUN_TYPE 执行方式（1同步执行（小数据量）、2异步线程执行（大数据量））';
alter table ZHPTCS.IMP_MODEL_CONFIG
  add constraint PK_IMP_MODEL_CONFIG primary key (MCODE)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table IMP_TABLE_COLUMNS
prompt ================================
prompt
create table ZHPTCS.IMP_TABLE_COLUMNS
(
  cid                NUMBER(10),
  target_table_id    NUMBER(8),
  column_code        VARCHAR2(30),
  column_type        CHAR(10),
  column_param       VARCHAR2(500),
  is_show            CHAR(1),
  show_name          VARCHAR2(30),
  check_type         VARCHAR2(2),
  check_error_info   VARCHAR2(500),
  process_expression VARCHAR2(100)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.IMP_TABLE_COLUMNS
  is 'EXCEL导入对应表的列的定义表';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.cid
  is '本表的流水ID';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.target_table_id
  is '对应的IMP_TARGET_TABLE目标表的TID，表示这个列是哪个表的';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.column_code
  is '表中的列';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.column_type
  is '数据来源类型，
COLUMN_TYPE和COLUMN_PARAM的定义
COLUMN_TYPE的值为1、2、3、4、5分别代表的意思：
  (
    (1)、EXCEL对应列的数据【COLUMN_PARAM的值为EXCEL列中的序号，0、1、2、3、4】、
    (2)、ORACLE能解析的表达式【COLUMN_PARAM的值为sysdate、to_char(sysdate,''yyyymmdd'')、XXX_SEQ.NEXTVAL等，或者某些常量如,字符串''01'',数值1】、
    (3)、SESSION中MUOUserSession的某个属性【COLUMN_PARAM的值为orgid,orgcode，empid等.区分大小写】
    (4)、执行对应的SQL语句返回结果【COLUMN_PARAM的值为对应的SqlNameId(参数名1：对应EXCEL列ID1，参数名2：对应EXCEL列ID2....参数名X：对应EXCEL列IDX)
  如：取这个身份证+姓名对应的客户号
com.gotop.cmms.customermanager.customerinfoquery.custforquery.querycustidbysfzno(custname:0,sfzno:1)
  对应的custforquery .namingsqlx文件中定义名为querycustidbysfzno 的SQL语句为
          select cust_id from t_cust_paper_map where paper_type=''01'' and cust_name=#custname# and paper_no= #sfzno#
custname:0中的custname对应SQL中的参数名，0表示这个值去EXCEL中的第1列。注:只能返回一个字段和最多一行记录，否则该列数据不予插入。  】

    (5)、从页面传入的参数MAP对应的KEY值
          COLUMN_PARAM的值为页面定义的表单paramMap 中的KEY值。
如  页面有个<h:text property="paramMap/MONTH"/>,则配置COLUMN_PARAM的值为 MONTH
  )
';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.column_param
  is '来源数据值详见COLUMN_TYPE';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.is_show
  is '是否显示 1是，2否 暂时不用，将来如果做一个通用的查询页面使用';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.show_name
  is '列的中文名称';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.check_type
  is 'CHECK_TYPE校验类型。
0,不校验
1 非空
2 数值';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.check_error_info
  is '校验不合法数据的提示信息 ,如 身份证不允许为空';
comment on column ZHPTCS.IMP_TABLE_COLUMNS.process_expression
  is '采用ORACLE表达式，对该列的最终值进行加工。变量用英文的?号代替.表达式中暂时只支持出现单个?号。常用的如：substr(?,2,10),decode(?,''是'',1.0)';
alter table ZHPTCS.IMP_TABLE_COLUMNS
  add constraint AK_KEY_1_IMP_TABL unique (TARGET_TABLE_ID, COLUMN_CODE)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table IMP_TARGET_TABLE
prompt ===============================
prompt
create table ZHPTCS.IMP_TARGET_TABLE
(
  tid             NUMBER(8),
  mcode           VARCHAR2(20),
  table_name      VARCHAR2(50),
  table_show_name VARCHAR2(50),
  key_column      VARCHAR2(50),
  sno             NUMBER(2)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.IMP_TARGET_TABLE
  is 'Excel导入目标表定义';
comment on column ZHPTCS.IMP_TARGET_TABLE.tid
  is '主键序列';
comment on column ZHPTCS.IMP_TARGET_TABLE.mcode
  is 'IMP_MODEL_CONFIG表的MCODE,一个导入功能，可能导入到多张表';
comment on column ZHPTCS.IMP_TARGET_TABLE.table_name
  is '目标表英文名';
comment on column ZHPTCS.IMP_TARGET_TABLE.table_show_name
  is '目标表中文名';
comment on column ZHPTCS.IMP_TARGET_TABLE.key_column
  is '唯一索引列名称';
comment on column ZHPTCS.IMP_TARGET_TABLE.sno
  is '排序';
alter table ZHPTCS.IMP_TARGET_TABLE
  add constraint AK_KEY_1_IMP_TARG unique (TID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JBPM4_DEPLOYMENT
prompt ===============================
prompt
create table ZHPTCS.JBPM4_DEPLOYMENT
(
  dbid_      NUMBER(19) not null,
  name_      CLOB,
  timestamp_ NUMBER(19),
  state_     VARCHAR2(255 CHAR)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_DEPLOYMENT
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JBPM4_DEPLOYPROP
prompt ===============================
prompt
create table ZHPTCS.JBPM4_DEPLOYPROP
(
  dbid_       NUMBER(19) not null,
  deployment_ NUMBER(19),
  objname_    VARCHAR2(255 CHAR),
  key_        VARCHAR2(255 CHAR),
  stringval_  VARCHAR2(255 CHAR),
  longval_    NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_DEPLPROP_DEPL on ZHPTCS.JBPM4_DEPLOYPROP (DEPLOYMENT_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_DEPLOYPROP
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_DEPLOYPROP
  add constraint FK_DEPLPROP_DEPL foreign key (DEPLOYMENT_)
  references ZHPTCS.JBPM4_DEPLOYMENT (DBID_);

prompt
prompt Creating table JBPM4_EXECUTION
prompt ==============================
prompt
create table ZHPTCS.JBPM4_EXECUTION
(
  dbid_          NUMBER(19) not null,
  class_         VARCHAR2(255 CHAR) not null,
  dbversion_     NUMBER(10) not null,
  activityname_  VARCHAR2(255 CHAR),
  procdefid_     VARCHAR2(255 CHAR),
  hasvars_       NUMBER(1),
  name_          VARCHAR2(255 CHAR),
  key_           VARCHAR2(255 CHAR),
  id_            VARCHAR2(255 CHAR),
  state_         VARCHAR2(255 CHAR),
  susphiststate_ VARCHAR2(255 CHAR),
  priority_      NUMBER(10),
  hisactinst_    NUMBER(19),
  parent_        NUMBER(19),
  instance_      NUMBER(19),
  superexec_     NUMBER(19),
  subprocinst_   NUMBER(19),
  parent_idx_    NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_EXEC_INSTANCE on ZHPTCS.JBPM4_EXECUTION (INSTANCE_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_EXEC_PARENT on ZHPTCS.JBPM4_EXECUTION (PARENT_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_EXEC_SUBPI on ZHPTCS.JBPM4_EXECUTION (SUBPROCINST_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_EXEC_SUPEREXEC on ZHPTCS.JBPM4_EXECUTION (SUPEREXEC_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_EXECUTION
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_EXECUTION
  add unique (ID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_EXECUTION
  add constraint FK_EXEC_INSTANCE foreign key (INSTANCE_)
  references ZHPTCS.JBPM4_EXECUTION (DBID_);
alter table ZHPTCS.JBPM4_EXECUTION
  add constraint FK_EXEC_PARENT foreign key (PARENT_)
  references ZHPTCS.JBPM4_EXECUTION (DBID_);
alter table ZHPTCS.JBPM4_EXECUTION
  add constraint FK_EXEC_SUBPI foreign key (SUBPROCINST_)
  references ZHPTCS.JBPM4_EXECUTION (DBID_);
alter table ZHPTCS.JBPM4_EXECUTION
  add constraint FK_EXEC_SUPEREXEC foreign key (SUPEREXEC_)
  references ZHPTCS.JBPM4_EXECUTION (DBID_);

prompt
prompt Creating table JBPM4_HIST_PROCINST
prompt ==================================
prompt
create table ZHPTCS.JBPM4_HIST_PROCINST
(
  dbid_        NUMBER(19) not null,
  dbversion_   NUMBER(10) not null,
  id_          VARCHAR2(255 CHAR),
  procdefid_   VARCHAR2(255 CHAR),
  key_         VARCHAR2(255 CHAR),
  start_       TIMESTAMP(6),
  end_         TIMESTAMP(6),
  duration_    NUMBER(19),
  state_       VARCHAR2(255 CHAR),
  endactivity_ VARCHAR2(255 CHAR),
  nextidx_     NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 8K
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.JBPM4_HIST_PROCINST_IDX on ZHPTCS.JBPM4_HIST_PROCINST (ID_)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.JBPM4_HIST_PROCINST_IDX1 on ZHPTCS.JBPM4_HIST_PROCINST (PROCDEFID_)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_PROCINST
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JBPM4_HIST_TASK
prompt ==============================
prompt
create table ZHPTCS.JBPM4_HIST_TASK
(
  dbid_      NUMBER(19) not null,
  dbversion_ NUMBER(10) not null,
  execution_ VARCHAR2(255 CHAR),
  outcome_   VARCHAR2(255 CHAR),
  assignee_  VARCHAR2(255 CHAR),
  priority_  NUMBER(10),
  state_     VARCHAR2(255 CHAR),
  create_    TIMESTAMP(6),
  end_       TIMESTAMP(6),
  duration_  NUMBER(19),
  nextidx_   NUMBER(10),
  supertask_ NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 448K
    next 8K
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HSUPERT_SUB on ZHPTCS.JBPM4_HIST_TASK (SUPERTASK_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HSUPERT_SUB1 on ZHPTCS.JBPM4_HIST_TASK (ASSIGNEE_)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_TASK
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_TASK
  add constraint FK_HSUPERT_SUB foreign key (SUPERTASK_)
  references ZHPTCS.JBPM4_HIST_TASK (DBID_);

prompt
prompt Creating table JBPM4_HIST_ACTINST
prompt =================================
prompt
create table ZHPTCS.JBPM4_HIST_ACTINST
(
  dbid_          NUMBER(19) not null,
  class_         VARCHAR2(255 CHAR) not null,
  dbversion_     NUMBER(10) not null,
  hproci_        NUMBER(19),
  type_          VARCHAR2(255 CHAR),
  execution_     VARCHAR2(255 CHAR),
  activity_name_ VARCHAR2(255 CHAR),
  start_         TIMESTAMP(6),
  end_           TIMESTAMP(6),
  duration_      NUMBER(19),
  transition_    VARCHAR2(255 CHAR),
  nextidx_       NUMBER(10),
  htask_         NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 576K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HACTI_HPROCI on ZHPTCS.JBPM4_HIST_ACTINST (HPROCI_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HTI_HTASK on ZHPTCS.JBPM4_HIST_ACTINST (HTASK_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_ACTINST
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_ACTINST
  add constraint FK_HACTI_HPROCI foreign key (HPROCI_)
  references ZHPTCS.JBPM4_HIST_PROCINST (DBID_);
alter table ZHPTCS.JBPM4_HIST_ACTINST
  add constraint FK_HTI_HTASK foreign key (HTASK_)
  references ZHPTCS.JBPM4_HIST_TASK (DBID_);

prompt
prompt Creating table JBPM4_HIST_VAR
prompt =============================
prompt
create table ZHPTCS.JBPM4_HIST_VAR
(
  dbid_        NUMBER(19) not null,
  dbversion_   NUMBER(10) not null,
  procinstid_  VARCHAR2(255 CHAR),
  executionid_ VARCHAR2(255 CHAR),
  varname_     VARCHAR2(255 CHAR),
  value_       VARCHAR2(255 CHAR),
  hproci_      NUMBER(19),
  htask_       NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HVAR_HPROCI on ZHPTCS.JBPM4_HIST_VAR (HPROCI_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HVAR_HTASK on ZHPTCS.JBPM4_HIST_VAR (HTASK_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_VAR
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_VAR
  add constraint FK_HVAR_HPROCI foreign key (HPROCI_)
  references ZHPTCS.JBPM4_HIST_PROCINST (DBID_);
alter table ZHPTCS.JBPM4_HIST_VAR
  add constraint FK_HVAR_HTASK foreign key (HTASK_)
  references ZHPTCS.JBPM4_HIST_TASK (DBID_);

prompt
prompt Creating table JBPM4_HIST_DETAIL
prompt ================================
prompt
create table ZHPTCS.JBPM4_HIST_DETAIL
(
  dbid_       NUMBER(19) not null,
  class_      VARCHAR2(255 CHAR) not null,
  dbversion_  NUMBER(10) not null,
  userid_     VARCHAR2(255 CHAR),
  time_       TIMESTAMP(6),
  hproci_     NUMBER(19),
  hprociidx_  NUMBER(10),
  hacti_      NUMBER(19),
  hactiidx_   NUMBER(10),
  htask_      NUMBER(19),
  htaskidx_   NUMBER(10),
  hvar_       NUMBER(19),
  hvaridx_    NUMBER(10),
  message_    CLOB,
  old_str_    VARCHAR2(255 CHAR),
  new_str_    VARCHAR2(255 CHAR),
  old_int_    NUMBER(10),
  new_int_    NUMBER(10),
  old_time_   TIMESTAMP(6),
  new_time_   TIMESTAMP(6),
  parent_     NUMBER(19),
  parent_idx_ NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HDET_HACTI on ZHPTCS.JBPM4_HIST_DETAIL (HACTI_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HDET_HPROCI on ZHPTCS.JBPM4_HIST_DETAIL (HPROCI_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HDET_HTASK on ZHPTCS.JBPM4_HIST_DETAIL (HTASK_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_HDET_HVAR on ZHPTCS.JBPM4_HIST_DETAIL (HVAR_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_DETAIL
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_HIST_DETAIL
  add constraint FK_HDETAIL_HACTI foreign key (HACTI_)
  references ZHPTCS.JBPM4_HIST_ACTINST (DBID_);
alter table ZHPTCS.JBPM4_HIST_DETAIL
  add constraint FK_HDETAIL_HPROCI foreign key (HPROCI_)
  references ZHPTCS.JBPM4_HIST_PROCINST (DBID_);
alter table ZHPTCS.JBPM4_HIST_DETAIL
  add constraint FK_HDETAIL_HTASK foreign key (HTASK_)
  references ZHPTCS.JBPM4_HIST_TASK (DBID_);
alter table ZHPTCS.JBPM4_HIST_DETAIL
  add constraint FK_HDETAIL_HVAR foreign key (HVAR_)
  references ZHPTCS.JBPM4_HIST_VAR (DBID_);

prompt
prompt Creating table JBPM4_ID_GROUP
prompt =============================
prompt
create table ZHPTCS.JBPM4_ID_GROUP
(
  dbid_      NUMBER(19) not null,
  dbversion_ NUMBER(10) not null,
  id_        VARCHAR2(255 CHAR),
  name_      VARCHAR2(255 CHAR),
  type_      VARCHAR2(255 CHAR),
  parent_    NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_GROUP_PARENT on ZHPTCS.JBPM4_ID_GROUP (PARENT_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_ID_GROUP
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_ID_GROUP
  add constraint FK_GROUP_PARENT foreign key (PARENT_)
  references ZHPTCS.JBPM4_ID_GROUP (DBID_);

prompt
prompt Creating table JBPM4_ID_USER
prompt ============================
prompt
create table ZHPTCS.JBPM4_ID_USER
(
  dbid_          NUMBER(19) not null,
  dbversion_     NUMBER(10) not null,
  id_            VARCHAR2(255 CHAR),
  password_      VARCHAR2(255 CHAR),
  givenname_     VARCHAR2(255 CHAR),
  familyname_    VARCHAR2(255 CHAR),
  businessemail_ VARCHAR2(255 CHAR)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_ID_USER
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JBPM4_ID_MEMBERSHIP
prompt ==================================
prompt
create table ZHPTCS.JBPM4_ID_MEMBERSHIP
(
  dbid_      NUMBER(19) not null,
  dbversion_ NUMBER(10) not null,
  user_      NUMBER(19),
  group_     NUMBER(19),
  name_      VARCHAR2(255 CHAR)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_MEM_GROUP on ZHPTCS.JBPM4_ID_MEMBERSHIP (GROUP_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_MEM_USER on ZHPTCS.JBPM4_ID_MEMBERSHIP (USER_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_ID_MEMBERSHIP
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_ID_MEMBERSHIP
  add constraint FK_MEM_GROUP foreign key (GROUP_)
  references ZHPTCS.JBPM4_ID_GROUP (DBID_);
alter table ZHPTCS.JBPM4_ID_MEMBERSHIP
  add constraint FK_MEM_USER foreign key (USER_)
  references ZHPTCS.JBPM4_ID_USER (DBID_);

prompt
prompt Creating table JBPM4_LOB
prompt ========================
prompt
create table ZHPTCS.JBPM4_LOB
(
  dbid_       NUMBER(19) not null,
  dbversion_  NUMBER(10) not null,
  blob_value_ BLOB,
  deployment_ NUMBER(19),
  name_       CLOB
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 256K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_LOB_DEPLOYMENT on ZHPTCS.JBPM4_LOB (DEPLOYMENT_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_LOB
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_LOB
  add constraint FK_LOB_DEPLOYMENT foreign key (DEPLOYMENT_)
  references ZHPTCS.JBPM4_DEPLOYMENT (DBID_);

prompt
prompt Creating table JBPM4_JOB
prompt ========================
prompt
create table ZHPTCS.JBPM4_JOB
(
  dbid_            NUMBER(19) not null,
  class_           VARCHAR2(255 CHAR) not null,
  dbversion_       NUMBER(10) not null,
  duedate_         TIMESTAMP(6),
  state_           VARCHAR2(255 CHAR),
  isexclusive_     NUMBER(1),
  lockowner_       VARCHAR2(255 CHAR),
  lockexptime_     TIMESTAMP(6),
  exception_       CLOB,
  retries_         NUMBER(10),
  processinstance_ NUMBER(19),
  execution_       NUMBER(19),
  cfg_             NUMBER(19),
  signal_          VARCHAR2(255 CHAR),
  event_           VARCHAR2(255 CHAR),
  repeat_          VARCHAR2(255 CHAR)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_JOBDUEDATE on ZHPTCS.JBPM4_JOB (DUEDATE_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_JOBLOCKEXP on ZHPTCS.JBPM4_JOB (LOCKEXPTIME_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_JOBRETRIES on ZHPTCS.JBPM4_JOB (RETRIES_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_JOB_CFG on ZHPTCS.JBPM4_JOB (CFG_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_JOB_EXE on ZHPTCS.JBPM4_JOB (EXECUTION_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_JOB_PRINST on ZHPTCS.JBPM4_JOB (PROCESSINSTANCE_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_JOB
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_JOB
  add constraint FK_JOB_CFG foreign key (CFG_)
  references ZHPTCS.JBPM4_LOB (DBID_);

prompt
prompt Creating table JBPM4_SWIMLANE
prompt =============================
prompt
create table ZHPTCS.JBPM4_SWIMLANE
(
  dbid_      NUMBER(19) not null,
  dbversion_ NUMBER(10) not null,
  name_      VARCHAR2(255 CHAR),
  assignee_  VARCHAR2(255 CHAR),
  execution_ NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_SWIMLANE_EXEC on ZHPTCS.JBPM4_SWIMLANE (EXECUTION_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_SWIMLANE
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_SWIMLANE
  add constraint FK_SWIMLANE_EXEC foreign key (EXECUTION_)
  references ZHPTCS.JBPM4_EXECUTION (DBID_);

prompt
prompt Creating table JBPM4_TASK
prompt =========================
prompt
create table ZHPTCS.JBPM4_TASK
(
  dbid_          NUMBER(19) not null,
  class_         CHAR(1 CHAR) not null,
  dbversion_     NUMBER(10) not null,
  name_          VARCHAR2(255 CHAR),
  descr_         CLOB,
  state_         VARCHAR2(255 CHAR),
  susphiststate_ VARCHAR2(255 CHAR),
  assignee_      VARCHAR2(255 CHAR),
  form_          VARCHAR2(255 CHAR),
  priority_      NUMBER(10),
  create_        TIMESTAMP(6),
  duedate_       TIMESTAMP(6),
  progress_      NUMBER(10),
  signalling_    NUMBER(1),
  execution_id_  VARCHAR2(255 CHAR),
  activity_name_ VARCHAR2(255 CHAR),
  hasvars_       NUMBER(1),
  supertask_     NUMBER(19),
  execution_     NUMBER(19),
  procinst_      NUMBER(19),
  swimlane_      NUMBER(19),
  taskdefname_   VARCHAR2(255 CHAR)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_TASK_SUPERTASK on ZHPTCS.JBPM4_TASK (SUPERTASK_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.JBPM4_TASK_IDX1 on ZHPTCS.JBPM4_TASK (EXECUTION_ID_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.JBPM4_TASK_IDX2 on ZHPTCS.JBPM4_TASK (STATE_, EXECUTION_ID_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_TASK
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_TASK
  add constraint FK_TASK_SUPERTASK foreign key (SUPERTASK_)
  references ZHPTCS.JBPM4_TASK (DBID_);
alter table ZHPTCS.JBPM4_TASK
  add constraint FK_TASK_SWIML foreign key (SWIMLANE_)
  references ZHPTCS.JBPM4_SWIMLANE (DBID_);

prompt
prompt Creating table JBPM4_PARTICIPATION
prompt ==================================
prompt
create table ZHPTCS.JBPM4_PARTICIPATION
(
  dbid_      NUMBER(19) not null,
  dbversion_ NUMBER(10) not null,
  groupid_   VARCHAR2(255 CHAR),
  userid_    VARCHAR2(255 CHAR),
  type_      VARCHAR2(255 CHAR),
  task_      NUMBER(19),
  swimlane_  NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_PART_TASK on ZHPTCS.JBPM4_PARTICIPATION (TASK_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_PARTICIPATION
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_PARTICIPATION
  add constraint FK_PART_SWIMLANE foreign key (SWIMLANE_)
  references ZHPTCS.JBPM4_SWIMLANE (DBID_);
alter table ZHPTCS.JBPM4_PARTICIPATION
  add constraint FK_PART_TASK foreign key (TASK_)
  references ZHPTCS.JBPM4_TASK (DBID_);

prompt
prompt Creating table JBPM4_PROPERTY
prompt =============================
prompt
create table ZHPTCS.JBPM4_PROPERTY
(
  key_     VARCHAR2(255 CHAR) not null,
  version_ NUMBER(10) not null,
  value_   VARCHAR2(255 CHAR)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_PROPERTY
  add primary key (KEY_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JBPM4_VARIABLE
prompt =============================
prompt
create table ZHPTCS.JBPM4_VARIABLE
(
  dbid_         NUMBER(19) not null,
  class_        VARCHAR2(255 CHAR) not null,
  dbversion_    NUMBER(10) not null,
  key_          VARCHAR2(255 CHAR),
  converter_    VARCHAR2(255 CHAR),
  hist_         NUMBER(1),
  execution_    NUMBER(19),
  task_         NUMBER(19),
  lob_          NUMBER(19),
  date_value_   TIMESTAMP(6),
  double_value_ FLOAT,
  classname_    VARCHAR2(255 CHAR),
  long_value_   NUMBER(19),
  string_value_ VARCHAR2(255 CHAR),
  text_value_   CLOB,
  exesys_       NUMBER(19)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_VAR_EXECUTION on ZHPTCS.JBPM4_VARIABLE (EXECUTION_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_VAR_EXESYS on ZHPTCS.JBPM4_VARIABLE (EXESYS_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_VAR_LOB on ZHPTCS.JBPM4_VARIABLE (LOB_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.IDX_VAR_TASK on ZHPTCS.JBPM4_VARIABLE (TASK_)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_VARIABLE
  add primary key (DBID_)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.JBPM4_VARIABLE
  add constraint FK_VAR_EXECUTION foreign key (EXECUTION_)
  references ZHPTCS.JBPM4_EXECUTION (DBID_);
alter table ZHPTCS.JBPM4_VARIABLE
  add constraint FK_VAR_EXESYS foreign key (EXESYS_)
  references ZHPTCS.JBPM4_EXECUTION (DBID_);
alter table ZHPTCS.JBPM4_VARIABLE
  add constraint FK_VAR_LOB foreign key (LOB_)
  references ZHPTCS.JBPM4_LOB (DBID_);
alter table ZHPTCS.JBPM4_VARIABLE
  add constraint FK_VAR_TASK foreign key (TASK_)
  references ZHPTCS.JBPM4_TASK (DBID_);

prompt
prompt Creating table OM_EMPGROUP
prompt ==========================
prompt
create table ZHPTCS.OM_EMPGROUP
(
  groupid NUMBER(10) not null,
  empid   NUMBER(10) not null
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_EMPGROUP
  is '定义工作组包含的人员';
comment on column ZHPTCS.OM_EMPGROUP.groupid
  is '群组编号';
comment on column ZHPTCS.OM_EMPGROUP.empid
  is '员工编号';
alter table ZHPTCS.OM_EMPGROUP
  add constraint PK_OM_EMPGROUP primary key (GROUPID, EMPID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_EMPLOYEE
prompt ==========================
prompt
create table ZHPTCS.OM_EMPLOYEE
(
  empid        NUMBER(10) not null,
  empcode      VARCHAR2(30),
  operatorid   NUMBER(18),
  userid       VARCHAR2(30),
  empname      VARCHAR2(50),
  realname     VARCHAR2(50),
  gender       VARCHAR2(10),
  birthdate    DATE,
  position     NUMBER(10),
  empstatus    VARCHAR2(255),
  cardtype     VARCHAR2(255),
  cardno       VARCHAR2(20),
  indate       DATE,
  outdate      DATE,
  degree       VARCHAR2(255),
  regdate      DATE default sysdate,
  createtime   DATE,
  lastmodytime DATE,
  displayorder VARCHAR2(10),
  expnote      CHAR(1),
  emergnote    CHAR(1),
  gennote      CHAR(1),
  updator      NUMBER(10),
  remark       VARCHAR2(500),
  specialty    VARCHAR2(1024),
  orgid        NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 2M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_EMPLOYEE
  is '人员信息表';
comment on column ZHPTCS.OM_EMPLOYEE.empid
  is '员工编号';
comment on column ZHPTCS.OM_EMPLOYEE.empcode
  is '员工代码';
comment on column ZHPTCS.OM_EMPLOYEE.operatorid
  is '对应操作员表的操作员编号，允许为空';
comment on column ZHPTCS.OM_EMPLOYEE.userid
  is '对应操作员表的操作员登录号，允许为空（冗余字段）';
comment on column ZHPTCS.OM_EMPLOYEE.empname
  is '员工姓名';
comment on column ZHPTCS.OM_EMPLOYEE.realname
  is '姓名简称';
comment on column ZHPTCS.OM_EMPLOYEE.gender
  is '性别';
comment on column ZHPTCS.OM_EMPLOYEE.birthdate
  is '出生日期';
comment on column ZHPTCS.OM_EMPLOYEE.position
  is '岗位';
comment on column ZHPTCS.OM_EMPLOYEE.empstatus
  is '人员状态';
comment on column ZHPTCS.OM_EMPLOYEE.cardtype
  is '证件类型';
comment on column ZHPTCS.OM_EMPLOYEE.cardno
  is '证件号码';
comment on column ZHPTCS.OM_EMPLOYEE.indate
  is '入职日期';
comment on column ZHPTCS.OM_EMPLOYEE.outdate
  is '离职日期';
comment on column ZHPTCS.OM_EMPLOYEE.degree
  is '职务';
comment on column ZHPTCS.OM_EMPLOYEE.regdate
  is '注册日期';
comment on column ZHPTCS.OM_EMPLOYEE.createtime
  is '创建时间';
comment on column ZHPTCS.OM_EMPLOYEE.lastmodytime
  is '修改时间';
comment on column ZHPTCS.OM_EMPLOYEE.displayorder
  is '显示顺序';
comment on column ZHPTCS.OM_EMPLOYEE.expnote
  is '特急信息';
comment on column ZHPTCS.OM_EMPLOYEE.emergnote
  is '紧急信息';
comment on column ZHPTCS.OM_EMPLOYEE.gennote
  is '一般信息';
comment on column ZHPTCS.OM_EMPLOYEE.updator
  is '修改人编号';
comment on column ZHPTCS.OM_EMPLOYEE.remark
  is '备注';
comment on column ZHPTCS.OM_EMPLOYEE.specialty
  is '序号';
comment on column ZHPTCS.OM_EMPLOYEE.orgid
  is '机构编号';
alter table ZHPTCS.OM_EMPLOYEE
  add constraint PK_OM_EMPLOYEE primary key (EMPID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 320K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_EMPLOYEE_201501
prompt =================================
prompt
create table ZHPTCS.OM_EMPLOYEE_201501
(
  empid        NUMBER(10) not null,
  empcode      VARCHAR2(30),
  operatorid   NUMBER(18),
  userid       VARCHAR2(30),
  empname      VARCHAR2(50),
  realname     VARCHAR2(50),
  gender       VARCHAR2(10),
  birthdate    DATE,
  position     NUMBER(10),
  empstatus    VARCHAR2(255),
  cardtype     VARCHAR2(255),
  cardno       VARCHAR2(20),
  indate       DATE,
  outdate      DATE,
  degree       VARCHAR2(255),
  regdate      DATE,
  createtime   DATE,
  lastmodytime DATE,
  displayorder VARCHAR2(10),
  expnote      CHAR(1),
  emergnote    CHAR(1),
  gennote      CHAR(1),
  updator      NUMBER(10),
  remark       VARCHAR2(500),
  specialty    VARCHAR2(1024),
  orgid        NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_EMPLOYEE_SRC
prompt ==============================
prompt
create table ZHPTCS.OM_EMPLOYEE_SRC
(
  empcode VARCHAR2(50),
  empname VARCHAR2(50),
  cardno  VARCHAR2(50)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_EMPORG
prompt ========================
prompt
create table ZHPTCS.OM_EMPORG
(
  empid      NUMBER(10) not null,
  orgid      NUMBER(10) not null,
  ismain     CHAR(1) not null,
  modflag    CHAR(1),
  lastupdate DATE,
  datasource CHAR(1)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 448K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_EMPORG
  is '定义人员和机构的关系表';
comment on column ZHPTCS.OM_EMPORG.empid
  is '员工编号';
comment on column ZHPTCS.OM_EMPORG.orgid
  is '机构编号';
comment on column ZHPTCS.OM_EMPORG.ismain
  is '是否主机构';
comment on column ZHPTCS.OM_EMPORG.modflag
  is '修改标志';
comment on column ZHPTCS.OM_EMPORG.lastupdate
  is '修改时间';
comment on column ZHPTCS.OM_EMPORG.datasource
  is '数据来源';
create index ZHPTCS.OM_EMPORG_EMPIDMAIN on ZHPTCS.OM_EMPORG (EMPID, ISMAIN)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 448K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.OM_EMPORG
  add constraint PK_OM_EMPORG primary key (EMPID, ORGID, ISMAIN)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 512K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_EMPORG_201501
prompt ===============================
prompt
create table ZHPTCS.OM_EMPORG_201501
(
  empid      NUMBER(10) not null,
  orgid      NUMBER(10) not null,
  ismain     CHAR(1) not null,
  modflag    CHAR(1),
  lastupdate DATE,
  datasource CHAR(1)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_EMPPOSITION
prompt =============================
prompt
create table ZHPTCS.OM_EMPPOSITION
(
  positionid NUMBER(10) not null,
  empid      NUMBER(10) not null,
  ismain     CHAR(1)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_EMPPOSITION
  is '定义人员和岗位的对应关系，需要注明，一个人员可以设定一个基本岗位';
comment on column ZHPTCS.OM_EMPPOSITION.positionid
  is '岗位编号';
comment on column ZHPTCS.OM_EMPPOSITION.empid
  is '员工编号';
comment on column ZHPTCS.OM_EMPPOSITION.ismain
  is '是否主岗位';
alter table ZHPTCS.OM_EMPPOSITION
  add constraint PK_OM_EMPPOSITION primary key (POSITIONID, EMPID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_GROUP
prompt =======================
prompt
create table ZHPTCS.OM_GROUP
(
  groupid      NUMBER(10) not null,
  orgid        NUMBER(10),
  grouplevel   NUMBER(38),
  groupname    VARCHAR2(50),
  groupdesc    VARCHAR2(512),
  grouptype    VARCHAR2(255),
  groupseq     VARCHAR2(256),
  startdate    DATE,
  enddate      DATE,
  groupstatus  VARCHAR2(255),
  manager      VARCHAR2(30),
  createtime   TIMESTAMP(6),
  lastupdate   TIMESTAMP(6),
  updator      NUMBER(10),
  isleaf       CHAR(1),
  subcount     NUMBER(10),
  createuserid VARCHAR2(200),
  empid        NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_GROUP
  is '工作组定义表，用于定义临时组、虚拟组，跨部门的项目组等';
comment on column ZHPTCS.OM_GROUP.groupid
  is '工作组编号';
comment on column ZHPTCS.OM_GROUP.orgid
  is '隶属机构编号';
comment on column ZHPTCS.OM_GROUP.grouplevel
  is '工作组层次';
comment on column ZHPTCS.OM_GROUP.groupname
  is '工作组名称';
comment on column ZHPTCS.OM_GROUP.groupdesc
  is '工作组描述';
comment on column ZHPTCS.OM_GROUP.grouptype
  is '工作组类型';
comment on column ZHPTCS.OM_GROUP.groupseq
  is '工作组路径序列';
comment on column ZHPTCS.OM_GROUP.startdate
  is '工作组有效开始时间';
comment on column ZHPTCS.OM_GROUP.enddate
  is '工作组有效截止时间';
comment on column ZHPTCS.OM_GROUP.groupstatus
  is '工作组状态';
comment on column ZHPTCS.OM_GROUP.manager
  is '负责人';
comment on column ZHPTCS.OM_GROUP.createtime
  is '创建时间';
comment on column ZHPTCS.OM_GROUP.lastupdate
  is '修改时间';
comment on column ZHPTCS.OM_GROUP.updator
  is '修改人编号';
comment on column ZHPTCS.OM_GROUP.isleaf
  is '是否叶子节点';
comment on column ZHPTCS.OM_GROUP.subcount
  is '子节点数';
comment on column ZHPTCS.OM_GROUP.createuserid
  is '公私标志';
comment on column ZHPTCS.OM_GROUP.empid
  is '创建人';
alter table ZHPTCS.OM_GROUP
  add constraint PK_OM_GROUP primary key (GROUPID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_GROUPMEMBER
prompt =============================
prompt
create table ZHPTCS.OM_GROUPMEMBER
(
  groupid  NUMBER(10) not null,
  memberid VARCHAR2(64) not null,
  flag     CHAR(1) not null
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_GROUPMEMBER
  is '工作组成员';
comment on column ZHPTCS.OM_GROUPMEMBER.groupid
  is '工作组编号';
comment on column ZHPTCS.OM_GROUPMEMBER.memberid
  is '成员编号';
comment on column ZHPTCS.OM_GROUPMEMBER.flag
  is '属性';
alter table ZHPTCS.OM_GROUPMEMBER
  add constraint PK_OM_GROUPMEMBER primary key (GROUPID, MEMBERID, FLAG)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_GROUPPOSI
prompt ===========================
prompt
create table ZHPTCS.OM_GROUPPOSI
(
  groupid    NUMBER(10) not null,
  positionid NUMBER(10) not null
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_GROUPPOSI
  is '工作组岗位列表:一个工作组允许定义多个岗位，岗位之间允许存在层次关系';
comment on column ZHPTCS.OM_GROUPPOSI.groupid
  is '工作组编号';
comment on column ZHPTCS.OM_GROUPPOSI.positionid
  is '岗位编号';
alter table ZHPTCS.OM_GROUPPOSI
  add constraint PK_OM_GROUPPOSI primary key (GROUPID, POSITIONID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_GROUPRANGE
prompt ============================
prompt
create table ZHPTCS.OM_GROUPRANGE
(
  groupid  NUMBER(10) not null,
  grangeid VARCHAR2(64) not null,
  flag     CHAR(1) not null
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_GROUPRANGE
  is '工作组范围';
comment on column ZHPTCS.OM_GROUPRANGE.groupid
  is '工作组编号';
comment on column ZHPTCS.OM_GROUPRANGE.grangeid
  is '范围编号';
comment on column ZHPTCS.OM_GROUPRANGE.flag
  is '属性';
alter table ZHPTCS.OM_GROUPRANGE
  add constraint PK_OM_GROUPRANGE primary key (GROUPID, GRANGEID, FLAG)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_ORGANIZATION
prompt ==============================
prompt
create table ZHPTCS.OM_ORGANIZATION
(
  orgid        NUMBER(10) not null,
  orgcode      VARCHAR2(10),
  orgname      VARCHAR2(64),
  orglevel     NUMBER(2),
  orgdegree    VARCHAR2(25),
  parentorgid  NUMBER(10),
  orgseq       VARCHAR2(512),
  orgtype      VARCHAR2(12),
  orgaddr      VARCHAR2(256),
  zipcode      VARCHAR2(10),
  manaposition NUMBER(10),
  managerid    NUMBER(10),
  orgmanager   VARCHAR2(128),
  linkman      VARCHAR2(30),
  linktel      VARCHAR2(20),
  email        VARCHAR2(128),
  weburl       VARCHAR2(512),
  startdate    DATE,
  enddate      DATE,
  status       VARCHAR2(255),
  area         VARCHAR2(30),
  createtime   DATE,
  lastupdate   DATE,
  updator      NUMBER(10),
  sortno       NUMBER(38),
  isleaf       CHAR(1),
  subcount     NUMBER(10),
  remark       VARCHAR2(512),
  orgtypefield NUMBER,
  realname     VARCHAR2(64),
  displayorder VARCHAR2(20),
  orgysjgid    VARCHAR2(10),
  snbz         VARCHAR2(12),
  whry         VARCHAR2(30),
  whsj         DATE,
  jgsx         NUMBER,
  ysjgbh       VARCHAR2(9),
  zhjb         NUMBER,
  areatype     NUMBER(2),
  comments     VARCHAR2(200),
  issyn        CHAR(1) default '1'
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 576K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_ORGANIZATION
  is '机构部门表
允许定义多个平行机构';
comment on column ZHPTCS.OM_ORGANIZATION.orgid
  is '机构编号';
comment on column ZHPTCS.OM_ORGANIZATION.orgcode
  is '机构代码';
comment on column ZHPTCS.OM_ORGANIZATION.orgname
  is '机构名称';
comment on column ZHPTCS.OM_ORGANIZATION.orglevel
  is '机构层次';
comment on column ZHPTCS.OM_ORGANIZATION.orgdegree
  is '机构等级';
comment on column ZHPTCS.OM_ORGANIZATION.parentorgid
  is '上级机构编号';
comment on column ZHPTCS.OM_ORGANIZATION.orgseq
  is '机构序列';
comment on column ZHPTCS.OM_ORGANIZATION.orgtype
  is '机构类型';
comment on column ZHPTCS.OM_ORGANIZATION.orgmanager
  is '机构管理员能够给本机构的人员进行授权，多个机构管理员之间用,分隔';
comment on column ZHPTCS.OM_ORGANIZATION.status
  is '机构状态';
comment on column ZHPTCS.OM_ORGANIZATION.area
  is '地域属性';
comment on column ZHPTCS.OM_ORGANIZATION.createtime
  is '创建时间';
comment on column ZHPTCS.OM_ORGANIZATION.lastupdate
  is '最后修改时间';
comment on column ZHPTCS.OM_ORGANIZATION.updator
  is '修改人编号';
comment on column ZHPTCS.OM_ORGANIZATION.sortno
  is '排序编号';
comment on column ZHPTCS.OM_ORGANIZATION.isleaf
  is '是否叶子节点';
comment on column ZHPTCS.OM_ORGANIZATION.subcount
  is '子节点数';
comment on column ZHPTCS.OM_ORGANIZATION.remark
  is '机构简称';
comment on column ZHPTCS.OM_ORGANIZATION.orgtypefield
  is '机构分类字段';
comment on column ZHPTCS.OM_ORGANIZATION.realname
  is '机构简拼';
comment on column ZHPTCS.OM_ORGANIZATION.displayorder
  is '显示顺序';
comment on column ZHPTCS.OM_ORGANIZATION.orgysjgid
  is '映射机构ID';
comment on column ZHPTCS.OM_ORGANIZATION.snbz
  is '三农标识';
comment on column ZHPTCS.OM_ORGANIZATION.whry
  is '维护人';
comment on column ZHPTCS.OM_ORGANIZATION.whsj
  is '维护时间';
comment on column ZHPTCS.OM_ORGANIZATION.jgsx
  is '机构属性    1、银行/2、邮政';
comment on column ZHPTCS.OM_ORGANIZATION.ysjgbh
  is '映射机构编号';
comment on column ZHPTCS.OM_ORGANIZATION.zhjb
  is '支行级别  支行级别：针对网点分类，填1、一级支行/2
、二级支行/3
、代理网点
';
comment on column ZHPTCS.OM_ORGANIZATION.areatype
  is '区域属性   1、城市/2、县市/3、农村';
comment on column ZHPTCS.OM_ORGANIZATION.comments
  is '备份';
comment on column ZHPTCS.OM_ORGANIZATION.issyn
  is '是否同步0否1是';
create index ZHPTCS.OM_ORGANIZATION_IDX2 on ZHPTCS.OM_ORGANIZATION (ORGCODE)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.OM_ORGANIZATION_IDX3 on ZHPTCS.OM_ORGANIZATION (PARENTORGID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.OM_ORGANIZATION
  add constraint OM_ORGANIZATION_IDX1 primary key (ORGID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_ORGANIZATION_SRC
prompt ==================================
prompt
create table ZHPTCS.OM_ORGANIZATION_SRC
(
  orgname VARCHAR2(64),
  orgcode VARCHAR2(64)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_PARTYROLE
prompt ===========================
prompt
create table ZHPTCS.OM_PARTYROLE
(
  roleid    VARCHAR2(64) not null,
  partytype VARCHAR2(255) not null,
  partyid   NUMBER(10) not null,
  appid     NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_PARTYROLE
  is '机构角色';
comment on column ZHPTCS.OM_PARTYROLE.roleid
  is '角色编号';
comment on column ZHPTCS.OM_PARTYROLE.partytype
  is '组织对象类型';
comment on column ZHPTCS.OM_PARTYROLE.partyid
  is '组织对象编号';
comment on column ZHPTCS.OM_PARTYROLE.appid
  is '应用编号';
alter table ZHPTCS.OM_PARTYROLE
  add constraint PK_OM_PARTYROLE primary key (ROLEID, PARTYTYPE, PARTYID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table OM_POSITION
prompt ==========================
prompt
create table ZHPTCS.OM_POSITION
(
  positionid  NUMBER(10) not null,
  posicode    VARCHAR2(20),
  posiname    VARCHAR2(128),
  posilevel   NUMBER(2),
  dutyid      NUMBER(10),
  orgid       NUMBER(10),
  positionseq VARCHAR2(512),
  positype    VARCHAR2(255),
  createtime  TIMESTAMP(6),
  lastupdate  TIMESTAMP(6),
  updator     NUMBER(10),
  startdate   DATE,
  enddate     DATE,
  status      VARCHAR2(255),
  isleaf      CHAR(1),
  subcount    NUMBER(10),
  posidesc    VARCHAR2(255),
  posisort    CHAR(1),
  sortlevel   VARCHAR2(2)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.OM_POSITION
  is '岗位定义表';
comment on column ZHPTCS.OM_POSITION.positionid
  is '岗位编号';
comment on column ZHPTCS.OM_POSITION.posicode
  is '岗位代码';
comment on column ZHPTCS.OM_POSITION.posiname
  is '岗位名称';
comment on column ZHPTCS.OM_POSITION.posilevel
  is '岗位层次';
comment on column ZHPTCS.OM_POSITION.dutyid
  is 'DUTYID';
comment on column ZHPTCS.OM_POSITION.orgid
  is '如果是机构岗位，则填写机构编号，如果是工作组岗位，填写工作组编号';
comment on column ZHPTCS.OM_POSITION.positionseq
  is 'POSITIONSEQ';
comment on column ZHPTCS.OM_POSITION.positype
  is '机构岗位，工作组岗位';
comment on column ZHPTCS.OM_POSITION.createtime
  is 'CREATETIME';
comment on column ZHPTCS.OM_POSITION.lastupdate
  is 'LASTUPDATE';
comment on column ZHPTCS.OM_POSITION.updator
  is 'UPDATOR';
comment on column ZHPTCS.OM_POSITION.startdate
  is 'STARTDATE';
comment on column ZHPTCS.OM_POSITION.enddate
  is 'ENDDATE';
comment on column ZHPTCS.OM_POSITION.status
  is 'STATUS';
comment on column ZHPTCS.OM_POSITION.isleaf
  is 'ISLEAF';
comment on column ZHPTCS.OM_POSITION.subcount
  is 'SUBCOUNT';
comment on column ZHPTCS.OM_POSITION.posidesc
  is 'POSIDESC';
comment on column ZHPTCS.OM_POSITION.posisort
  is 'POSISORT';
comment on column ZHPTCS.OM_POSITION.sortlevel
  is 'SORTLEVEL';
alter table ZHPTCS.OM_POSITION
  add constraint PK_OM_POSITION primary key (POSITIONID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_APPLY_DATA
prompt ===========================
prompt
create table ZHPTCS.T_APPLY_DATA
(
  da_id       NUMBER(12) not null,
  emp_id      NUMBER(10),
  e_org_id    NUMBER(10),
  flow_id     VARCHAR2(128),
  da_title    VARCHAR2(128),
  phone_no    VARCHAR2(20),
  da_content  VARCHAR2(1024),
  da_matter   VARCHAR2(1024),
  da_reason   VARCHAR2(1024),
  da_tlimit   VARCHAR2(8),
  da_freq     VARCHAR2(2),
  da_req      VARCHAR2(128),
  da_range    VARCHAR2(1024),
  is_sdata    VARCHAR2(2),
  org_id      NUMBER(10),
  e_emp_id    NUMBER(10),
  use_tlimit  VARCHAR2(8),
  create_time VARCHAR2(8),
  create_date VARCHAR2(10),
  risk        VARCHAR2(1024),
  da_fetch    VARCHAR2(1024),
  data_user   VARCHAR2(1024),
  username    VARCHAR2(1024),
  r_emp_id    NUMBER(10),
  d_emp_id    NUMBER(10),
  rleader     VARCHAR2(16),
  ropin       VARCHAR2(1024),
  dleader     VARCHAR2(16),
  dopin       VARCHAR2(1024),
  freqtype    VARCHAR2(2),
  freqno      VARCHAR2(4)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 192K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_APPLY_DATA
  is '数据申请表';
comment on column ZHPTCS.T_APPLY_DATA.da_id
  is '主键编号';
comment on column ZHPTCS.T_APPLY_DATA.emp_id
  is '申请人编号';
comment on column ZHPTCS.T_APPLY_DATA.e_org_id
  is '使用数据主管部门';
comment on column ZHPTCS.T_APPLY_DATA.flow_id
  is '流程实例编号';
comment on column ZHPTCS.T_APPLY_DATA.da_title
  is '申请标题';
comment on column ZHPTCS.T_APPLY_DATA.phone_no
  is '联系电话';
comment on column ZHPTCS.T_APPLY_DATA.da_content
  is '申请内容';
comment on column ZHPTCS.T_APPLY_DATA.da_matter
  is '申请事项';
comment on column ZHPTCS.T_APPLY_DATA.da_reason
  is '申请原因';
comment on column ZHPTCS.T_APPLY_DATA.da_tlimit
  is '提取时限';
comment on column ZHPTCS.T_APPLY_DATA.da_freq
  is '01:一次性;02:周期性';
comment on column ZHPTCS.T_APPLY_DATA.da_req
  is '提取要求';
comment on column ZHPTCS.T_APPLY_DATA.da_range
  is '提取范围';
comment on column ZHPTCS.T_APPLY_DATA.is_sdata
  is '01:涉及;02:未涉及';
comment on column ZHPTCS.T_APPLY_DATA.org_id
  is '申请人所在机构';
comment on column ZHPTCS.T_APPLY_DATA.e_emp_id
  is '使用数据主管人员';
comment on column ZHPTCS.T_APPLY_DATA.use_tlimit
  is '数据使用时限';
comment on column ZHPTCS.T_APPLY_DATA.create_time
  is '创建申请时间';
comment on column ZHPTCS.T_APPLY_DATA.create_date
  is '创建申请日期';
comment on column ZHPTCS.T_APPLY_DATA.risk
  is '风险评估';
comment on column ZHPTCS.T_APPLY_DATA.da_fetch
  is '提取可行性分析';
comment on column ZHPTCS.T_APPLY_DATA.data_user
  is '数据使用人员编号';
comment on column ZHPTCS.T_APPLY_DATA.username
  is '数据使用人员姓名';
comment on column ZHPTCS.T_APPLY_DATA.r_emp_id
  is '风险评估人';
comment on column ZHPTCS.T_APPLY_DATA.d_emp_id
  is '提取可行性分析人';
comment on column ZHPTCS.T_APPLY_DATA.rleader
  is '风险管理部领导';
comment on column ZHPTCS.T_APPLY_DATA.ropin
  is '风险管理部部门领导意见';
comment on column ZHPTCS.T_APPLY_DATA.dleader
  is '信息科技部领导';
comment on column ZHPTCS.T_APPLY_DATA.dopin
  is '信息科技部领导意见';
comment on column ZHPTCS.T_APPLY_DATA.freqtype
  is '频度类型';
comment on column ZHPTCS.T_APPLY_DATA.freqno
  is '频度';
create index ZHPTCS.T_APPLY_DATA_IDX_2 on ZHPTCS.T_APPLY_DATA (EMP_ID, ORG_ID, E_EMP_ID, E_ORG_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_APPLY_DATA_IDX_3 on ZHPTCS.T_APPLY_DATA (R_EMP_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_APPLY_DATA_IDX_4 on ZHPTCS.T_APPLY_DATA (D_EMP_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_APPLY_DATA_IDX_5 on ZHPTCS.T_APPLY_DATA (FLOW_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_APPLY_DATA
  add constraint PK_T_APPLY_DATA_IDX_1 primary key (DA_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_APPLY_EUIP
prompt ===========================
prompt
create table ZHPTCS.T_APPLY_EUIP
(
  ep_id       NUMBER(12) not null,
  emp_id      NUMBER(10) not null,
  flow_id     VARCHAR2(255),
  phone_no    VARCHAR2(20),
  ep_title    VARCHAR2(128) not null,
  ep_matter   VARCHAR2(128),
  ep_type     VARCHAR2(2),
  ep_number   NUMBER(12),
  ep_budget   NUMBER(12,2),
  ep_reason   VARCHAR2(1024) not null,
  create_time VARCHAR2(8),
  create_date VARCHAR2(10),
  orgid       NUMBER(10),
  apply_time  VARCHAR2(14)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_APPLY_EUIP
  is '设备申请表';
comment on column ZHPTCS.T_APPLY_EUIP.ep_id
  is '主键';
comment on column ZHPTCS.T_APPLY_EUIP.emp_id
  is '申请人编号';
comment on column ZHPTCS.T_APPLY_EUIP.flow_id
  is '流程编号';
comment on column ZHPTCS.T_APPLY_EUIP.phone_no
  is '联系电话';
comment on column ZHPTCS.T_APPLY_EUIP.ep_title
  is '标题';
comment on column ZHPTCS.T_APPLY_EUIP.ep_matter
  is '事项';
comment on column ZHPTCS.T_APPLY_EUIP.ep_type
  is '类型';
comment on column ZHPTCS.T_APPLY_EUIP.ep_number
  is '数量';
comment on column ZHPTCS.T_APPLY_EUIP.ep_budget
  is '预算金额';
comment on column ZHPTCS.T_APPLY_EUIP.ep_reason
  is '原因';
comment on column ZHPTCS.T_APPLY_EUIP.create_time
  is '创建时间';
comment on column ZHPTCS.T_APPLY_EUIP.create_date
  is '创建日期';
comment on column ZHPTCS.T_APPLY_EUIP.orgid
  is '归属机构编号';
comment on column ZHPTCS.T_APPLY_EUIP.apply_time
  is '申请时间';
create index ZHPTCS.T_APPLY_EQUIP_IDX_2 on ZHPTCS.T_APPLY_EUIP (EMP_ID, ORGID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_APPLY_EQUIP_IDX_3 on ZHPTCS.T_APPLY_EUIP (FLOW_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_APPLY_EUIP
  add constraint PK_T_APPLY_EUIP primary key (EP_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_APPLY_LEAVE
prompt ============================
prompt
create table ZHPTCS.T_APPLY_LEAVE
(
  lv_id       NUMBER(12) not null,
  emp_id      NUMBER(10) not null,
  lv_title    VARCHAR2(128) not null,
  phone_no    VARCHAR2(20),
  lv_type     VARCHAR2(2) not null,
  lv_reason   VARCHAR2(1024) not null,
  lv_start    VARCHAR2(8) not null,
  create_date VARCHAR2(10) not null,
  flow_id     VARCHAR2(128),
  lv_end      VARCHAR2(8) not null,
  create_time VARCHAR2(8),
  org_id      NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_APPLY_LEAVE
  is '请假表';
comment on column ZHPTCS.T_APPLY_LEAVE.lv_id
  is '请假编号';
comment on column ZHPTCS.T_APPLY_LEAVE.emp_id
  is '操作人员ID';
comment on column ZHPTCS.T_APPLY_LEAVE.lv_title
  is '请假标题';
comment on column ZHPTCS.T_APPLY_LEAVE.phone_no
  is '请假人联系电话';
comment on column ZHPTCS.T_APPLY_LEAVE.lv_type
  is '请假类型';
comment on column ZHPTCS.T_APPLY_LEAVE.lv_reason
  is '请假原因';
comment on column ZHPTCS.T_APPLY_LEAVE.lv_start
  is '开始请假时间';
comment on column ZHPTCS.T_APPLY_LEAVE.create_date
  is '申请日期';
comment on column ZHPTCS.T_APPLY_LEAVE.flow_id
  is '流程id';
comment on column ZHPTCS.T_APPLY_LEAVE.lv_end
  is '请假结束时间';
comment on column ZHPTCS.T_APPLY_LEAVE.create_time
  is '创建时间';
comment on column ZHPTCS.T_APPLY_LEAVE.org_id
  is '申请人机构Id';
create index ZHPTCS.T_APPLY_LEAVE_IDX_2 on ZHPTCS.T_APPLY_LEAVE (EMP_ID, ORG_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_APPLY_LEAVE_IDX_3 on ZHPTCS.T_APPLY_LEAVE (FLOW_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_APPLY_LEAVE
  add constraint PK_T_APPLY_LEAVE_1 primary key (LV_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_APPROVE_OPNINION
prompt =================================
prompt
create table ZHPTCS.T_APPROVE_OPNINION
(
  rec_id           NUMBER(14) not null,
  resource_id      NUMBER(12),
  resource_type    VARCHAR2(2),
  opninion_content VARCHAR2(512),
  operator_type    VARCHAR2(2),
  operator         NUMBER(10),
  operater_date    VARCHAR2(10),
  operater_time    VARCHAR2(6),
  node_id          VARCHAR2(32),
  node_name        VARCHAR2(64),
  orgid            NUMBER(10),
  next_opr_name    VARCHAR2(256),
  next_org_name    VARCHAR2(256)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 512K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_APPROVE_OPNINION
  is '审核意见表';
comment on column ZHPTCS.T_APPROVE_OPNINION.rec_id
  is '意见编号';
comment on column ZHPTCS.T_APPROVE_OPNINION.resource_id
  is '来源ID';
comment on column ZHPTCS.T_APPROVE_OPNINION.resource_type
  is '01：信息发布02：督办单管理 03：工作月报 04：会议申请 05：数据申请流程 06：数据下发流程 07:社保申请流程 08：员工请假流程';
comment on column ZHPTCS.T_APPROVE_OPNINION.opninion_content
  is '意见内容';
comment on column ZHPTCS.T_APPROVE_OPNINION.operator_type
  is '01:审核通过  02：退回';
comment on column ZHPTCS.T_APPROVE_OPNINION.operator
  is '操作员';
comment on column ZHPTCS.T_APPROVE_OPNINION.operater_date
  is '操作日期';
comment on column ZHPTCS.T_APPROVE_OPNINION.operater_time
  is '操作时间';
comment on column ZHPTCS.T_APPROVE_OPNINION.node_id
  is '节点编号';
comment on column ZHPTCS.T_APPROVE_OPNINION.node_name
  is '节点名称';
comment on column ZHPTCS.T_APPROVE_OPNINION.orgid
  is '操作人机构编号';
comment on column ZHPTCS.T_APPROVE_OPNINION.next_opr_name
  is '下个节点操作人。';
comment on column ZHPTCS.T_APPROVE_OPNINION.next_org_name
  is '下一节点办理人所在机构';
create index ZHPTCS.T_APPROVE_OPNINION_INDEX2 on ZHPTCS.T_APPROVE_OPNINION (RESOURCE_ID, RESOURCE_TYPE)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_APPROVE_OPNINION
  add constraint PK_T_APPROVE_OPNINION_INDEX1 primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_APPROVE_OPNINION_GP
prompt ====================================
prompt
create table ZHPTCS.T_APPROVE_OPNINION_GP
(
  rec_id           NUMBER(14) not null,
  flow_id          VARCHAR2(256),
  resource_type    VARCHAR2(2),
  opninion_content VARCHAR2(2048),
  operator_type    VARCHAR2(255),
  operator         NUMBER(10),
  operater_date    VARCHAR2(10),
  operater_time    VARCHAR2(6),
  node_id          VARCHAR2(32),
  node_name        VARCHAR2(64),
  orgid            NUMBER(10),
  next_opr_name    VARCHAR2(256),
  next_org_name    VARCHAR2(256)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_APPROVE_OPNINION_GP
  is '通用流程的审核意见表';

prompt
prompt Creating table T_ATTACHMENT_INFO
prompt ================================
prompt
create table ZHPTCS.T_ATTACHMENT_INFO
(
  attachment_info_id   NUMBER(8),
  attachment_src_id    NUMBER(8),
  attachment_src_cd    VARCHAR2(8),
  attachment_name      VARCHAR2(500),
  storage_path         VARCHAR2(128),
  space_size           NUMBER(12),
  attachment_status_cd VARCHAR2(2),
  create_time          DATE,
  update_time          DATE
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_ATTACHMENT_INFO
  is '附件信息表';
comment on column ZHPTCS.T_ATTACHMENT_INFO.attachment_info_id
  is '附件信息记录编号';
comment on column ZHPTCS.T_ATTACHMENT_INFO.attachment_src_id
  is '附件源记录编号';
comment on column ZHPTCS.T_ATTACHMENT_INFO.attachment_src_cd
  is '附件来源模块编号';
comment on column ZHPTCS.T_ATTACHMENT_INFO.attachment_name
  is '附件名称';
comment on column ZHPTCS.T_ATTACHMENT_INFO.storage_path
  is '附件所在路径';
comment on column ZHPTCS.T_ATTACHMENT_INFO.space_size
  is '占用空间';
comment on column ZHPTCS.T_ATTACHMENT_INFO.attachment_status_cd
  is '附件状态';
comment on column ZHPTCS.T_ATTACHMENT_INFO.create_time
  is '创建时间';
comment on column ZHPTCS.T_ATTACHMENT_INFO.update_time
  is '更新时间';
create unique index ZHPTCS.ATTACHMENT_INDEX on ZHPTCS.T_ATTACHMENT_INFO (ATTACHMENT_INFO_ID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.ATTACHMENT_QUERY_INDEX on ZHPTCS.T_ATTACHMENT_INFO (ATTACHMENT_SRC_ID, ATTACHMENT_SRC_CD)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_COMMON_PROCESS
prompt ===============================
prompt
create table ZHPTCS.T_COMMON_PROCESS
(
  rec_id         NUMBER(12) not null,
  emp_id         NUMBER(10) not null,
  org_id         NUMBER(10) not null,
  flow_id        VARCHAR2(255),
  phone_no       VARCHAR2(20),
  com_title      VARCHAR2(128),
  com_content    VARCHAR2(1024),
  create_date    VARCHAR2(10),
  create_time    VARCHAR2(8),
  apply_time     VARCHAR2(14),
  bussiness_type VARCHAR2(2),
  spare_col      VARCHAR2(1024),
  maintitle      VARCHAR2(64)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_COMMON_PROCESS
  is '通用流程表';
comment on column ZHPTCS.T_COMMON_PROCESS.rec_id
  is '主键';
comment on column ZHPTCS.T_COMMON_PROCESS.emp_id
  is '申请人编号';
comment on column ZHPTCS.T_COMMON_PROCESS.org_id
  is '申请人所属机构编号';
comment on column ZHPTCS.T_COMMON_PROCESS.flow_id
  is '流程编号';
comment on column ZHPTCS.T_COMMON_PROCESS.phone_no
  is '电话号码';
comment on column ZHPTCS.T_COMMON_PROCESS.com_title
  is '标题';
comment on column ZHPTCS.T_COMMON_PROCESS.com_content
  is '内容';
comment on column ZHPTCS.T_COMMON_PROCESS.create_date
  is '创建日期';
comment on column ZHPTCS.T_COMMON_PROCESS.create_time
  is '创建时间';
comment on column ZHPTCS.T_COMMON_PROCESS.apply_time
  is '申请时间';
comment on column ZHPTCS.T_COMMON_PROCESS.bussiness_type
  is '工作事项类型';
comment on column ZHPTCS.T_COMMON_PROCESS.spare_col
  is '备用字段';
comment on column ZHPTCS.T_COMMON_PROCESS.maintitle
  is '主标题';
create index ZHPTCS.T_COMMON_PROCESS_IDX_2 on ZHPTCS.T_COMMON_PROCESS (EMP_ID, ORG_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_COMMON_PROCESS_IDX_3 on ZHPTCS.T_COMMON_PROCESS (FLOW_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_COMMON_PROCESS
  add constraint PK_T_COMMON_PROCESS_IDX_1 primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_DEFAULT_OPINION
prompt ================================
prompt
create table ZHPTCS.T_DEFAULT_OPINION
(
  rec_id  NUMBER(12) not null,
  emp_id  NUMBER(12),
  opinion VARCHAR2(1024)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_DEFAULT_OPINION
  is '默认意见表';
comment on column ZHPTCS.T_DEFAULT_OPINION.rec_id
  is '主键';
comment on column ZHPTCS.T_DEFAULT_OPINION.emp_id
  is '员工编号';
comment on column ZHPTCS.T_DEFAULT_OPINION.opinion
  is '默认意见';
create index ZHPTCS.T_DEFAULT_OPINION_IDX_2 on ZHPTCS.T_DEFAULT_OPINION (EMP_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_DEFAULT_OPINION
  add constraint PK_T_DEFAULT_OPINION_1 primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_FILE_RESOURCE_TABLE
prompt ====================================
prompt
create table ZHPTCS.T_FILE_RESOURCE_TABLE
(
  file_id       NUMBER(12) not null,
  resource_id   NUMBER(12),
  resource_type VARCHAR2(2),
  file_name     VARCHAR2(128),
  file_path     VARCHAR2(300),
  file_type     VARCHAR2(2),
  node_id       VARCHAR2(255),
  node_name     VARCHAR2(64),
  creator       NUMBER(10),
  create_date   VARCHAR2(10),
  create_time   VARCHAR2(6),
  file_re_name  VARCHAR2(128)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 448K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_FILE_RESOURCE_TABLE
  is '文件资源表';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.file_id
  is '文件编号';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.resource_id
  is '来源编号';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.resource_type
  is '01：信息发布02：督办单管理 03：工作月报 04：会议申请 05：数据申请流程 06：数据下发流程 07:社保申请流程 08：员工请假流程';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.file_name
  is '文件名称';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.file_path
  is '文件路径';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.file_type
  is '文件类型 0 :普通 1：本晕 2：上月';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.node_id
  is '节点编号';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.node_name
  is '节点名称';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.creator
  is '上传人员';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.create_date
  is '上传日期';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.create_time
  is '上传时间';
comment on column ZHPTCS.T_FILE_RESOURCE_TABLE.file_re_name
  is '新文件名称（uuid）防止文件相重。';
create index ZHPTCS.T_FILE_RESOURCE_TABLE_INDEX2 on ZHPTCS.T_FILE_RESOURCE_TABLE (RESOURCE_ID, RESOURCE_TYPE)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_FILE_RESOURCE_TABLE
  add constraint PK_T_FILE_RESOURCE_INDEX1 primary key (FILE_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_CDTYPE
prompt ======================================
prompt
create table ZHPTCS.T_GENERALPROCESS_CDTYPE
(
  cdtypeid     NUMBER(38) not null,
  process_name VARCHAR2(255),
  first_class  VARCHAR2(255),
  credit_type  VARCHAR2(255),
  limit_time   VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_CDTYPE
  is '通用流程-贷款流程分类表';
comment on column ZHPTCS.T_GENERALPROCESS_CDTYPE.cdtypeid
  is '模式2主键';
comment on column ZHPTCS.T_GENERALPROCESS_CDTYPE.process_name
  is '流程名称';
comment on column ZHPTCS.T_GENERALPROCESS_CDTYPE.first_class
  is '一级分类';
comment on column ZHPTCS.T_GENERALPROCESS_CDTYPE.credit_type
  is '贷种分类';
comment on column ZHPTCS.T_GENERALPROCESS_CDTYPE.limit_time
  is '时限参数列表';
alter table ZHPTCS.T_GENERALPROCESS_CDTYPE
  add primary key (CDTYPEID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MAIN
prompt ====================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MAIN
(
  mainid      NUMBER(38) not null,
  template_id VARCHAR2(255),
  rules       VARCHAR2(500),
  name        VARCHAR2(100),
  business_id VARCHAR2(255),
  ids         VARCHAR2(255),
  begin_empid NUMBER(38),
  begin_orgid NUMBER(38)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MAIN
  is '通用流程-节点-MAIN主表';
comment on column ZHPTCS.T_GENERALPROCESS_MAIN.mainid
  is '主键';
comment on column ZHPTCS.T_GENERALPROCESS_MAIN.template_id
  is '模板id（这个业务属于哪个流程模板）';
comment on column ZHPTCS.T_GENERALPROCESS_MAIN.rules
  is '规则，用来存储实体类，用,隔开';
comment on column ZHPTCS.T_GENERALPROCESS_MAIN.business_id
  is '业务流程id';
comment on column ZHPTCS.T_GENERALPROCESS_MAIN.ids
  is '存放业务主键的id，用,隔开';
alter table ZHPTCS.T_GENERALPROCESS_MAIN
  add primary key (MAINID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MISTAKE
prompt =======================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MISTAKE
(
  mistakeid           NUMBER(38) not null,
  flow_id             VARCHAR2(255),
  mistake_content     VARCHAR2(255),
  punish_bal          VARCHAR2(255),
  empid               NUMBER(10),
  taskname            VARCHAR2(255),
  processmodelid_four NUMBER(38),
  add_time            VARCHAR2(14)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MISTAKE
  is '通用流程-差错表';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.mistakeid
  is '差错主键';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.flow_id
  is '流程业务的  id';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.mistake_content
  is '差错情况';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.punish_bal
  is '惩罚金额';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.empid
  is '添加人';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.taskname
  is '节点名称';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.processmodelid_four
  is '模式四主键';
comment on column ZHPTCS.T_GENERALPROCESS_MISTAKE.add_time
  is '添加时间';

prompt
prompt Creating table T_GENERALPROCESS_MODELEIGHT
prompt ==========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELEIGHT
(
  processmodelid   NUMBER(38) not null,
  flow_id          VARCHAR2(255),
  opninion_content VARCHAR2(2048),
  tjgjjsj          VARCHAR2(255),
  gjjzxspsj        VARCHAR2(255),
  taskname         VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MODELEIGHT
  is '通用流程-节点模式八表';
comment on column ZHPTCS.T_GENERALPROCESS_MODELEIGHT.processmodelid
  is '模式8主键';
comment on column ZHPTCS.T_GENERALPROCESS_MODELEIGHT.flow_id
  is '流程业务的  id';
comment on column ZHPTCS.T_GENERALPROCESS_MODELEIGHT.opninion_content
  is '处理意见';
comment on column ZHPTCS.T_GENERALPROCESS_MODELEIGHT.tjgjjsj
  is '提交公积金中心时间';
comment on column ZHPTCS.T_GENERALPROCESS_MODELEIGHT.gjjzxspsj
  is '公积金中心审批时间';
comment on column ZHPTCS.T_GENERALPROCESS_MODELEIGHT.taskname
  is '节点名称';
alter table ZHPTCS.T_GENERALPROCESS_MODELEIGHT
  add primary key (PROCESSMODELID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MODELFIVE
prompt =========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELFIVE
(
  processmodelid NUMBER(38) not null,
  app_way        VARCHAR2(2),
  pol_no         VARCHAR2(255),
  meeting_count  VARCHAR2(255),
  vote_no        VARCHAR2(255),
  app_time       VARCHAR2(8),
  con_matter     VARCHAR2(255),
  sx_app_time    VARCHAR2(8),
  yq_app_time    VARCHAR2(8),
  dy_app         VARCHAR2(255),
  de_app         VARCHAR2(255),
  hy_zr_name     VARCHAR2(255),
  hy_wy_one      VARCHAR2(255),
  hy_wy_two      VARCHAR2(255),
  ds_ms_one      VARCHAR2(255),
  ds_ms_two      VARCHAR2(255),
  sh_addr        VARCHAR2(255),
  fx_type        VARCHAR2(2),
  sp_type        VARCHAR2(2),
  ybj_num        VARCHAR2(255),
  hy_sy_jl       VARCHAR2(2),
  pj_jl          VARCHAR2(255),
  fx_bb          VARCHAR2(2),
  fx_ed          VARCHAR2(255),
  sx_bb          VARCHAR2(2),
  sx_ed          VARCHAR2(255),
  yw_bb          VARCHAR2(2),
  yw_ed          VARCHAR2(255),
  flow_id        VARCHAR2(255),
  taskname       VARCHAR2(255),
  option_new     VARCHAR2(2048)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MODELFIVE
  is '通用流程-节点模式五';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.processmodelid
  is '模式五主键';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.app_way
  is '审批方式,1-当签,2-双签,3-会议';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.pol_no
  is '决策单编号';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.meeting_count
  is '会议期数';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.vote_no
  is '表决表编号';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.app_time
  is '审批岗审结时间,格式YYYYMMDD';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.con_matter
  is '审议事项（可多选）,01-评级,02-授信额度,03-单笔业务';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.sx_app_time
  is '授信部负责人签批时间,格式YYYYMMDD';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.yq_app_time
  is '有权审批人签批时间,格式YYYYMMDD';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.dy_app
  is '第一审批人（会议审批委员）';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.de_app
  is '第二审批人（会议审批委员）';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.hy_zr_name
  is '会议审批主任委员';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.hy_wy_one
  is '会议审批委员1';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.hy_wy_two
  is '会议审批委员2';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.ds_ms_one
  is '贷审会秘书一';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.ds_ms_two
  is '贷审会秘书二';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.sh_addr
  is '上会地点';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.fx_type
  is '风险类型,01-低风险,02-非低风险';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.sp_type
  is '审批类型,01-首次,02-复议,03-变更';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.ybj_num
  is '有表决权人数';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.hy_sy_jl
  is '会议审议结论,01-同意,02-有条件同意,03-续议,04-不同意,05-退回';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.pj_jl
  is '评级结论';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.fx_bb
  is '风险币别';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.fx_ed
  is '风险额度,单位万元';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.sx_bb
  is '授信币别';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.sx_ed
  is '授信额度,单位万元';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.yw_bb
  is '业务币别';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.yw_ed
  is '业务额度,单位万元';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.flow_id
  is '流程实例id';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.taskname
  is '节点名称';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFIVE.option_new
  is '处理意见';
alter table ZHPTCS.T_GENERALPROCESS_MODELFIVE
  add primary key (PROCESSMODELID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MODELFOUR
prompt =========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELFOUR
(
  processmodelid   NUMBER(38) not null,
  flow_id          VARCHAR2(255),
  opninion_content VARCHAR2(2048),
  taskname         VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MODELFOUR
  is '通用流程-节点模式四';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFOUR.processmodelid
  is '模式四主键';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFOUR.flow_id
  is '流程业务的  id';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFOUR.opninion_content
  is '处理意见';
comment on column ZHPTCS.T_GENERALPROCESS_MODELFOUR.taskname
  is '节点名称';
alter table ZHPTCS.T_GENERALPROCESS_MODELFOUR
  add primary key (PROCESSMODELID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MODELONE
prompt ========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELONE
(
  processmodelid NUMBER(38) not null,
  flow_id        VARCHAR2(255),
  orgcodeone     VARCHAR2(30),
  orgcodetwo     VARCHAR2(30),
  creator        VARCHAR2(30),
  fdxdy          VARCHAR2(30),
  yxzg           VARCHAR2(30),
  yxry           VARCHAR2(30),
  currency       VARCHAR2(30),
  apply_bal      VARCHAR2(30),
  onecategory    VARCHAR2(255),
  loancategory   VARCHAR2(255),
  dywx_name      VARCHAR2(30),
  coorganization VARCHAR2(30),
  survey_time    VARCHAR2(30),
  content        VARCHAR2(30),
  cust_name      VARCHAR2(30),
  create_date    VARCHAR2(30),
  create_time    VARCHAR2(30),
  create_name    VARCHAR2(30),
  last_up_date   VARCHAR2(30),
  last_up_time   VARCHAR2(30),
  last_up_name   VARCHAR2(30),
  taskname       VARCHAR2(255),
  hanldoption    VARCHAR2(2048)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MODELONE
  is '通用流程-节点模式一';
comment on column ZHPTCS.T_GENERALPROCESS_MODELONE.flow_id
  is '流程业务的  id';
comment on column ZHPTCS.T_GENERALPROCESS_MODELONE.taskname
  is '节点名称';
alter table ZHPTCS.T_GENERALPROCESS_MODELONE
  add primary key (PROCESSMODELID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MODELSEVEN
prompt ==========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELSEVEN
(
  processmodelid NUMBER(38) not null,
  flow_id        VARCHAR2(255),
  taskname       VARCHAR2(255),
  handle_opn     VARCHAR2(2),
  sp_bb          VARCHAR2(2),
  sp_je          VARCHAR2(255),
  option_new     VARCHAR2(2048)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MODELSEVEN
  is '通用流程-节点模式七表';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSEVEN.processmodelid
  is '模式七主键';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSEVEN.flow_id
  is '流程实例id';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSEVEN.taskname
  is '节点名称';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSEVEN.handle_opn
  is '审批意见,01-同意,02-有条件同意,03-退回,04-拒绝';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSEVEN.sp_bb
  is '审批币别';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSEVEN.sp_je
  is '审批金额';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSEVEN.option_new
  is '处理意见';
alter table ZHPTCS.T_GENERALPROCESS_MODELSEVEN
  add primary key (PROCESSMODELID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MODELSIX
prompt ========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELSIX
(
  processmodelid     NUMBER(38),
  flow_id            VARCHAR2(255),
  taskname           VARCHAR2(255),
  opinion            VARCHAR2(255),
  mortgage_time      VARCHAR2(255),
  receive_time       VARCHAR2(255),
  application_time   VARCHAR2(255),
  issued_time        VARCHAR2(255),
  support_category   VARCHAR2(255),
  support_money      VARCHAR2(255),
  risk               VARCHAR2(255),
  processing_opinion VARCHAR2(2048),
  cust_name          VARCHAR2(255),
  support_moneytype  VARCHAR2(255),
  onecategory        VARCHAR2(255),
  loancategory       VARCHAR2(255),
  yesornotrisk       VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.processmodelid
  is '主键';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.flow_id
  is '流程id';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.taskname
  is '流程名称';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.opinion
  is '通用处理意见';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.mortgage_time
  is '抵押送件时间';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.receive_time
  is '收到他项时间';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.application_time
  is '公积金中心申请时间';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.issued_time
  is '公积金中心下达放款指标时间';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.support_category
  is '支用类别';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.support_money
  is '支用金额';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.risk
  is '是否风险额度重检';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.processing_opinion
  is '处理意见';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.cust_name
  is '客户姓名';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.support_moneytype
  is '支用金额币别';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.onecategory
  is '一级分类';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.loancategory
  is '贷总分类';
comment on column ZHPTCS.T_GENERALPROCESS_MODELSIX.yesornotrisk
  is '是否抵押';

prompt
prompt Creating table T_GENERALPROCESS_MODELTHREE
prompt ==========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELTHREE
(
  processmodelid   NUMBER(38) not null,
  flow_id          VARCHAR2(255),
  isurgent         VARCHAR2(255),
  opninion_content VARCHAR2(2048),
  taskname         VARCHAR2(255),
  reporttime       VARCHAR2(255),
  reportcnt        VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MODELTHREE
  is '通用流程-节点模式三';
alter table ZHPTCS.T_GENERALPROCESS_MODELTHREE
  add primary key (PROCESSMODELID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_MODELTWO
prompt ========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_MODELTWO
(
  processmodelid   NUMBER(38) not null,
  flow_id          VARCHAR2(255),
  opninion_content VARCHAR2(2048),
  taskname         VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_GENERALPROCESS_MODELTWO
  is '通用流程-节点模式二
';
alter table ZHPTCS.T_GENERALPROCESS_MODELTWO
  add primary key (PROCESSMODELID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GENERALPROCESS_SIXCONFIG
prompt =========================================
prompt
create table ZHPTCS.T_GENERALPROCESS_SIXCONFIG
(
  id          VARCHAR2(99) not null,
  processname VARCHAR2(99),
  dicname     VARCHAR2(99),
  dickid_id   VARCHAR2(99)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column ZHPTCS.T_GENERALPROCESS_SIXCONFIG.id
  is '主键';
comment on column ZHPTCS.T_GENERALPROCESS_SIXCONFIG.processname
  is '流程名称';
comment on column ZHPTCS.T_GENERALPROCESS_SIXCONFIG.dicname
  is '字典名字';
comment on column ZHPTCS.T_GENERALPROCESS_SIXCONFIG.dickid_id
  is '字典的id';
alter table ZHPTCS.T_GENERALPROCESS_SIXCONFIG
  add primary key (ID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GROUP
prompt ======================
prompt
create table ZHPTCS.T_GROUP
(
  rec_id        NUMBER(12) not null,
  group_name    VARCHAR2(128),
  group_detail  VARCHAR2(255),
  group_creator NUMBER(10),
  create_role   VARCHAR2(16),
  is_wholebank  VARCHAR2(2)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column ZHPTCS.T_GROUP.rec_id
  is '主键';
comment on column ZHPTCS.T_GROUP.group_name
  is '群组名称';
comment on column ZHPTCS.T_GROUP.group_detail
  is '群组描述';
comment on column ZHPTCS.T_GROUP.group_creator
  is '群组创建者empid';
comment on column ZHPTCS.T_GROUP.create_role
  is '群组创建者所属角色';
comment on column ZHPTCS.T_GROUP.is_wholebank
  is '是否全行，0-不是，1-是';
alter table ZHPTCS.T_GROUP
  add constraint PK_T_GROUP primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_GROUPMEMBER
prompt ============================
prompt
create table ZHPTCS.T_GROUPMEMBER
(
  groupid  NUMBER(10) not null,
  memberid NUMBER(10) not null,
  flag     VARCHAR2(1)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column ZHPTCS.T_GROUPMEMBER.groupid
  is '群组编号';
comment on column ZHPTCS.T_GROUPMEMBER.memberid
  is '成员编号（empid）';
alter table ZHPTCS.T_GROUPMEMBER
  add constraint PK_T_GROUPMEMBER primary key (GROUPID, MEMBERID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_MESSAGE_PUBLISH
prompt ================================
prompt
create table ZHPTCS.T_MESSAGE_PUBLISH
(
  message_id    NUMBER(12) not null,
  flow_id       VARCHAR2(255),
  message_title VARCHAR2(128),
  message_type  VARCHAR2(3),
  content       VARCHAR2(2048),
  publish_type  VARCHAR2(2),
  publish_range VARCHAR2(1024),
  obj_orgcode   VARCHAR2(1024),
  create_empid  NUMBER(10),
  create_date   VARCHAR2(10),
  create_time   VARCHAR2(8),
  objname       VARCHAR2(1024),
  orgid         NUMBER(10),
  exists_file   CHAR(1) default 0
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_MESSAGE_PUBLISH
  is '信息发布表';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.flow_id
  is '流程ID';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.message_title
  is '信息标题';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.message_type
  is '信息类型';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.content
  is '消息内容';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.publish_type
  is '1:机构发布 2：人员发布 3：角色发布';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.publish_range
  is '发布范围';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.obj_orgcode
  is '用于角色发布时，选择发布机构下的某角色。';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.create_empid
  is '创建人';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.create_date
  is '创建日期';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.create_time
  is '创建时间';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.objname
  is '用于存放发布范围名称';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.orgid
  is '归属机构编号';
comment on column ZHPTCS.T_MESSAGE_PUBLISH.exists_file
  is '0:不存在 1：存在';
create index ZHPTCS.T_MESSAGE_PUBLISH_IDX1 on ZHPTCS.T_MESSAGE_PUBLISH (MESSAGE_ID, FLOW_ID, PUBLISH_TYPE)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_MESSAGE_PUBLISH
  add constraint PK_T_MESSAGE_PUBLISH primary key (MESSAGE_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_MESSAGE_RECEIVE
prompt ================================
prompt
create table ZHPTCS.T_MESSAGE_RECEIVE
(
  rec_id         NUMBER(12) not null,
  message_id     NUMBER(12),
  type           VARCHAR2(2),
  receive_object VARCHAR2(12),
  obj_orgcode    VARCHAR2(9),
  receive_status VARCHAR2(2),
  receive_date   VARCHAR2(10),
  receive_time   VARCHAR2(6),
  submit_emp     NUMBER(10),
  submit_time    VARCHAR2(14),
  submit_date    VARCHAR2(8)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_MESSAGE_RECEIVE
  is '信息接收表';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.rec_id
  is '接收编号';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.message_id
  is '信息编号';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.type
  is '0:接收1：转发';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.receive_object
  is '接收对象（人员、机构、角色）';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.obj_orgcode
  is '用于选择角色发布时，指定发送给机构下某些角色。';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.receive_status
  is '0：未接受
1：已接收';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.receive_date
  is 'YYYY-MM-DD';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.submit_emp
  is '提交人';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.submit_time
  is '提交时间';
comment on column ZHPTCS.T_MESSAGE_RECEIVE.submit_date
  is '提交日期';
create index ZHPTCS.T_MESSAGE_RECEIVE_INDEX2 on ZHPTCS.T_MESSAGE_RECEIVE (MESSAGE_ID, TYPE)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_MESSAGE_RECEIVE
  add constraint PK_T_MESSAGE_RECEIVE_INDEX1 primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_MESSAGE_RED_PER
prompt ================================
prompt
create table ZHPTCS.T_MESSAGE_RED_PER
(
  rec_id     NUMBER(12) not null,
  message_id NUMBER(12) not null,
  empid      NUMBER(10) not null
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_MESSAGE_RED_PER
  is '信息阅读人员表';
comment on column ZHPTCS.T_MESSAGE_RED_PER.rec_id
  is '流水号';
comment on column ZHPTCS.T_MESSAGE_RED_PER.message_id
  is '信息编号';
comment on column ZHPTCS.T_MESSAGE_RED_PER.empid
  is '人员编号';
create unique index ZHPTCS.T_MESSAGE_RED_PER_IDEX2 on ZHPTCS.T_MESSAGE_RED_PER (EMPID, MESSAGE_ID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_MESSAGE_RED_PER
  add constraint PK_T_MESSAGE_RED_PER_INDEX1 primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_METTING_APPLY
prompt ==============================
prompt
create table ZHPTCS.T_METTING_APPLY
(
  metting_id     NUMBER(12) not null,
  flow_id        VARCHAR2(255),
  title          VARCHAR2(128),
  content        VARCHAR2(1024),
  type           VARCHAR2(2),
  metting_time   VARCHAR2(20),
  join_emp       VARCHAR2(1024),
  create_date    VARCHAR2(10),
  create_time    VARCHAR2(6),
  creator        NUMBER(10),
  orgid          NUMBER(10),
  join_empname   VARCHAR2(1024),
  mname          VARCHAR2(128),
  joinleader     VARCHAR2(128),
  joinleadername VARCHAR2(128)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_METTING_APPLY
  is '会议申请表';
comment on column ZHPTCS.T_METTING_APPLY.metting_id
  is '会议编号';
comment on column ZHPTCS.T_METTING_APPLY.flow_id
  is '流程ID';
comment on column ZHPTCS.T_METTING_APPLY.title
  is '会议标题';
comment on column ZHPTCS.T_METTING_APPLY.content
  is '内容';
comment on column ZHPTCS.T_METTING_APPLY.type
  is '会议类型';
comment on column ZHPTCS.T_METTING_APPLY.metting_time
  is '会议时间';
comment on column ZHPTCS.T_METTING_APPLY.join_emp
  is '参会人员';
comment on column ZHPTCS.T_METTING_APPLY.create_date
  is '创建日期';
comment on column ZHPTCS.T_METTING_APPLY.create_time
  is '创建时间';
comment on column ZHPTCS.T_METTING_APPLY.creator
  is '创建人';
comment on column ZHPTCS.T_METTING_APPLY.orgid
  is '归属机构编号';
comment on column ZHPTCS.T_METTING_APPLY.join_empname
  is '参会人员姓名';
comment on column ZHPTCS.T_METTING_APPLY.mname
  is '会议室名称';
comment on column ZHPTCS.T_METTING_APPLY.joinleader
  is '参会领导id';
comment on column ZHPTCS.T_METTING_APPLY.joinleadername
  is '参会领导姓名';
alter table ZHPTCS.T_METTING_APPLY
  add constraint PK_T_METTING_APPLY_INDEX1 primary key (METTING_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_METTING_RECEIVE
prompt ================================
prompt
create table ZHPTCS.T_METTING_RECEIVE
(
  rec_id     NUMBER(12) not null,
  metting_id NUMBER(12),
  rec_emp    NUMBER(10),
  status     VARCHAR2(2),
  rec_date   VARCHAR2(10),
  rec_time   VARCHAR2(6)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_METTING_RECEIVE
  is '参会人员接收表';
comment on column ZHPTCS.T_METTING_RECEIVE.rec_id
  is '接收编号';
comment on column ZHPTCS.T_METTING_RECEIVE.metting_id
  is '会议编号';
comment on column ZHPTCS.T_METTING_RECEIVE.rec_emp
  is '接收人';
comment on column ZHPTCS.T_METTING_RECEIVE.status
  is '接收状态';
comment on column ZHPTCS.T_METTING_RECEIVE.rec_date
  is '接收日期';
comment on column ZHPTCS.T_METTING_RECEIVE.rec_time
  is '接收时间';
create index ZHPTCS.T_METTING_RECEIVE_INDEX2 on ZHPTCS.T_METTING_RECEIVE (METTING_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_METTING_RECEIVE_INDEX3 on ZHPTCS.T_METTING_RECEIVE (REC_EMP)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_METTING_RECEIVE
  add constraint PK_T_METTING_RECEIVE_INDEX1 primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_NEW_DEVICEMANAGEMENT
prompt =====================================
prompt
create table ZHPTCS.T_NEW_DEVICEMANAGEMENT
(
  deviceid              NUMBER not null,
  devicename            VARCHAR2(255),
  devicemodel           VARCHAR2(255),
  ipadress              VARCHAR2(255),
  productionmachinename VARCHAR2(255),
  cpucode               VARCHAR2(255),
  memory                NUMBER,
  harddisk              NUMBER,
  osversion             VARCHAR2(255),
  softwareversion       VARCHAR2(255),
  ieversion             VARCHAR2(255),
  useful                VARCHAR2(255),
  terminalnumber        VARCHAR2(255),
  plugin                VARCHAR2(255),
  peripheral            VARCHAR2(255),
  otherattribute_1      VARCHAR2(255),
  remarks_1             VARCHAR2(255),
  users                 VARCHAR2(255),
  orgcode               VARCHAR2(10),
  otherinfo_1           VARCHAR2(255),
  device_state          CHAR(1),
  otherattribute_2      VARCHAR2(255),
  otherattribute_3      VARCHAR2(255),
  otherattribute_4      VARCHAR2(255),
  otherattribute_5      VARCHAR2(255),
  otherinfo_2           VARCHAR2(255),
  otherinfo_3           VARCHAR2(255),
  otherinfo_4           VARCHAR2(255),
  otherinfo_5           VARCHAR2(255),
  remarks_2             VARCHAR2(255),
  remarks_3             VARCHAR2(255),
  remarks_4             VARCHAR2(255),
  remarks_5             VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_NEW_DEVICEMANAGEMENT
  is '设备表';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.deviceid
  is '主键';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.devicename
  is '设备名称';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.devicemodel
  is '设备型号';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.ipadress
  is 'ip地址';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.productionmachinename
  is '生产机器名称';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.cpucode
  is 'cpu型号';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.memory
  is '内存容量';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.harddisk
  is '硬盘容量';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.osversion
  is '操作系统版本';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.softwareversion
  is '内置软件版本';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.ieversion
  is 'ie版本';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.useful
  is '用途';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.terminalnumber
  is '终端号';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.plugin
  is '安装的插件（多个）';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.peripheral
  is '对应的外设';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherattribute_1
  is '其他属性1';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.remarks_1
  is '备注1';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.users
  is '使用人';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.orgcode
  is '机构/部门 代码';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherinfo_1
  is '其他信息1';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.device_state
  is '设备状态（0:可用，1:报废）';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherattribute_2
  is '其他属性2';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherattribute_3
  is '其他属性3';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherattribute_4
  is '其他属性4';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherattribute_5
  is '其他属性5';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherinfo_2
  is '其他信息2';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherinfo_3
  is '其他信息3';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherinfo_4
  is '其他信息4';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.otherinfo_5
  is '其他信息5';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.remarks_2
  is '备注2';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.remarks_3
  is '备注3';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.remarks_4
  is '备注4';
comment on column ZHPTCS.T_NEW_DEVICEMANAGEMENT.remarks_5
  is '备注5';
alter table ZHPTCS.T_NEW_DEVICEMANAGEMENT
  add constraint PK_T_NEW_DEVICEMANAGEMENT primary key (DEVICEID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_NEW_DEVICEMANDETAIL
prompt ====================================
prompt
create table ZHPTCS.T_NEW_DEVICEMANDETAIL
(
  detailid              NUMBER not null,
  deviceid              NUMBER,
  operateempid          NUMBER(10),
  operatetime           DATE,
  devicename            VARCHAR2(255),
  devicemodel           VARCHAR2(255),
  ipadress              VARCHAR2(255),
  productionmachinename VARCHAR2(255),
  cpucode               VARCHAR2(255),
  memory                NUMBER,
  harddisk              NUMBER,
  osversion             VARCHAR2(255),
  softwareversion       VARCHAR2(255),
  ieversion             VARCHAR2(255),
  useful                VARCHAR2(255),
  terminalnumber        VARCHAR2(255),
  plugin                VARCHAR2(255),
  peripheral            VARCHAR2(255),
  otherattribute_1      VARCHAR2(255),
  otherinfo_1           VARCHAR2(255),
  remarks_1             VARCHAR2(255),
  users                 VARCHAR2(255),
  orgcode               VARCHAR2(10),
  device_state          CHAR(1),
  otherattribute_2      VARCHAR2(255),
  otherattribute_3      VARCHAR2(255),
  otherattribute_4      VARCHAR2(255),
  otherattribute_5      VARCHAR2(255),
  otherinfo_2           VARCHAR2(255),
  otherinfo_3           VARCHAR2(255),
  otherinfo_4           VARCHAR2(255),
  otherinfo_5           VARCHAR2(255),
  remarks_2             VARCHAR2(255),
  remarks_3             VARCHAR2(255),
  remarks_4             VARCHAR2(255),
  remarks_5             VARCHAR2(255)
)
tablespace ZHPTDATACS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_NEW_DEVICEMANDETAIL
  is '设备明细表';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.detailid
  is '明细ID';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.deviceid
  is '设备ID';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.operateempid
  is '操作员工ID';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.operatetime
  is '操作时间';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.devicename
  is '本次 设备名称';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.devicemodel
  is '本次 设备型号';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.ipadress
  is '本次 ip地址';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.productionmachinename
  is '本次 生产机器名称';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.cpucode
  is '本次 cpu型号';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.memory
  is '本次 内存容量';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.harddisk
  is '本次 硬盘容量';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.osversion
  is '本次 操作系统版本';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.softwareversion
  is '本次 内置软件版本';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.ieversion
  is '本次 ie版本';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.useful
  is '本次 用途';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.terminalnumber
  is '本次 终端号';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.plugin
  is '本次 安装的插件（多个）';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.peripheral
  is '本次 对应的外设';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherattribute_1
  is '本次 其他属性1';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherinfo_1
  is '本次 其他信息1';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.remarks_1
  is '本次 备注1';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.users
  is '本次 使用人';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.orgcode
  is '本次 机构/部门 代码';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.device_state
  is '本次 设备状态（0:可用，1:报废）';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherattribute_2
  is '本次 其他属性2';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherattribute_3
  is '本次 其他属性3';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherattribute_4
  is '本次 其他属性4';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherattribute_5
  is '本次 其他属性5';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherinfo_2
  is '本次 其他信息2';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherinfo_3
  is '本次 其他信息3';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherinfo_4
  is '本次 其他信息4';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.otherinfo_5
  is '本次 其他信息5';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.remarks_2
  is '本次 备注2';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.remarks_3
  is '本次 备注3';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.remarks_4
  is '本次 备注4';
comment on column ZHPTCS.T_NEW_DEVICEMANDETAIL.remarks_5
  is '本次 备注5';
alter table ZHPTCS.T_NEW_DEVICEMANDETAIL
  add constraint PK_T_NEW_DEVICEMANDETAIL primary key (DETAILID)
  using index 
  tablespace ZHPTDATACS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESS_BUSINESS
prompt =================================
prompt
create table ZHPTCS.T_PROCESS_BUSINESS
(
  id             NUMBER(12) not null,
  business_type  VARCHAR2(2),
  business_key   NUMBER(12),
  business_title VARCHAR2(255),
  execution_id   VARCHAR2(255),
  submit_time    VARCHAR2(14),
  submit_id      NUMBER(12)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 192K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_PROCESS_BUSINESS
  is '流程业务表';
comment on column ZHPTCS.T_PROCESS_BUSINESS.id
  is '主键';
comment on column ZHPTCS.T_PROCESS_BUSINESS.business_type
  is '业务类型';
comment on column ZHPTCS.T_PROCESS_BUSINESS.business_key
  is '业务主键';
comment on column ZHPTCS.T_PROCESS_BUSINESS.business_title
  is '业务标题';
comment on column ZHPTCS.T_PROCESS_BUSINESS.execution_id
  is '流程实例id';
comment on column ZHPTCS.T_PROCESS_BUSINESS.submit_time
  is '起草人提交时间';
comment on column ZHPTCS.T_PROCESS_BUSINESS.submit_id
  is '起草人id';
create index ZHPTCS.T_PROCESS_BUSINESS_IDX on ZHPTCS.T_PROCESS_BUSINESS (EXECUTION_ID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_PROCESS_BUSINESS
  add constraint PK_T_PROCESS_BUSINESS primary key (ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESS_BUSINESS_CONFIG
prompt ========================================
prompt
create table ZHPTCS.T_PROCESS_BUSINESS_CONFIG
(
  id              NUMBER(12) not null,
  business_type   VARCHAR2(2),
  business_column VARCHAR2(255),
  business_table  VARCHAR2(255)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_PROCESS_BUSINESS_CONFIG
  is '流程业务配置表';
comment on column ZHPTCS.T_PROCESS_BUSINESS_CONFIG.id
  is '主键';
comment on column ZHPTCS.T_PROCESS_BUSINESS_CONFIG.business_type
  is '业务类型';
comment on column ZHPTCS.T_PROCESS_BUSINESS_CONFIG.business_column
  is '业务字段';
comment on column ZHPTCS.T_PROCESS_BUSINESS_CONFIG.business_table
  is '业务表';
alter table ZHPTCS.T_PROCESS_BUSINESS_CONFIG
  add constraint PK_T_PROCESS_BUSINESS_CONFIG primary key (ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESS_CONFIG
prompt ===============================
prompt
create table ZHPTCS.T_PROCESS_CONFIG
(
  id                NUMBER(12) not null,
  definition_id     VARCHAR2(255),
  user_id           NUMBER(12),
  upload_org        NUMBER(12),
  upload_time       VARCHAR2(14),
  state             VARCHAR2(2),
  role_org_person   VARCHAR2(2),
  process_name      VARCHAR2(255),
  business_type     CHAR(2),
  order_no          VARCHAR2(255),
  process_use_state VARCHAR2(2) default 01,
  file_ids          VARCHAR2(255)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_PROCESS_CONFIG
  is '流程配置表';
comment on column ZHPTCS.T_PROCESS_CONFIG.id
  is '主键';
comment on column ZHPTCS.T_PROCESS_CONFIG.definition_id
  is '流程定义id';
comment on column ZHPTCS.T_PROCESS_CONFIG.user_id
  is '上传用户id';
comment on column ZHPTCS.T_PROCESS_CONFIG.upload_org
  is '上传机构';
comment on column ZHPTCS.T_PROCESS_CONFIG.upload_time
  is '上传时间';
comment on column ZHPTCS.T_PROCESS_CONFIG.state
  is '流程状态';
comment on column ZHPTCS.T_PROCESS_CONFIG.role_org_person
  is '01-角色/02-人员/03-机构/04-岗位';
comment on column ZHPTCS.T_PROCESS_CONFIG.process_name
  is '流程名称';
comment on column ZHPTCS.T_PROCESS_CONFIG.business_type
  is '流程归属业务类型';
comment on column ZHPTCS.T_PROCESS_CONFIG.order_no
  is '序号';
comment on column ZHPTCS.T_PROCESS_CONFIG.process_use_state
  is '01-使用/02-隐藏';
comment on column ZHPTCS.T_PROCESS_CONFIG.file_ids
  is '模板文件ID';
create index ZHPTCS.T_PROCESS_CONFIG_IDX on ZHPTCS.T_PROCESS_CONFIG (DEFINITION_ID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_PROCESS_CONFIG
  add constraint PK_PROCESS_CONFIG primary key (ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESS_CONFIG_0919
prompt ====================================
prompt
create table ZHPTCS.T_PROCESS_CONFIG_0919
(
  id                NUMBER(12) not null,
  definition_id     VARCHAR2(255),
  user_id           NUMBER(12),
  upload_org        NUMBER(12),
  upload_time       VARCHAR2(14),
  state             VARCHAR2(2),
  role_org_person   VARCHAR2(2),
  process_name      VARCHAR2(255),
  business_type     CHAR(2),
  order_no          VARCHAR2(255),
  process_use_state VARCHAR2(2)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESS_CONFIG_PERSON
prompt ======================================
prompt
create table ZHPTCS.T_PROCESS_CONFIG_PERSON
(
  id                NUMBER(12) not null,
  process_config_id NUMBER(12),
  relation_id       VARCHAR2(64)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_PROCESS_CONFIG_PERSON
  is '流程配置人员关系表';
alter table ZHPTCS.T_PROCESS_CONFIG_PERSON
  add constraint PK_PROCESS_CONFIG_PERSON primary key (ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_PROCESS_CONFIG_PERSON
  add constraint FK_PROCESS_CONFIG_PERSON foreign key (PROCESS_CONFIG_ID)
  references ZHPTCS.T_PROCESS_CONFIG (ID);

prompt
prompt Creating table T_PROCESS_CONFIG_PERSON_0919
prompt ===========================================
prompt
create table ZHPTCS.T_PROCESS_CONFIG_PERSON_0919
(
  id                NUMBER(12) not null,
  process_config_id NUMBER(12),
  relation_id       VARCHAR2(64)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESS_TASK_ASSIGNEE
prompt ======================================
prompt
create table ZHPTCS.T_PROCESS_TASK_ASSIGNEE
(
  id                 NUMBER(12) not null,
  execution_id       VARCHAR2(255),
  pre_task_id        VARCHAR2(255),
  pre_task_assingee  NUMBER(12),
  pre_task_org       NUMBER(12),
  pre_task_time      VARCHAR2(14),
  next_task_id       VARCHAR2(255),
  task_id            VARCHAR2(255),
  business_key       NUMBER(12),
  business_type      VARCHAR2(2),
  next_activity_name VARCHAR2(255),
  next_assingee_name VARCHAR2(255),
  task_exe_config_id NUMBER(12)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 448K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_PROCESS_TASK_ASSIGNEE
  is '流程节点办理表';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.id
  is '主键';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.execution_id
  is '流程实例id';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.pre_task_id
  is '上个节点id';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.pre_task_assingee
  is '提交人id';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.pre_task_org
  is '提交结构';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.pre_task_time
  is '提交时间';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.next_task_id
  is '下个节点id';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.task_id
  is '节点id';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.business_key
  is '业务主键';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.business_type
  is '业务类型';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.next_activity_name
  is '下个节点名称';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.next_assingee_name
  is '下个节点办理人';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE.task_exe_config_id
  is '节点执行对象主键ID';
create index ZHPTCS.T_PROCESS_TASK_1 on ZHPTCS.T_PROCESS_TASK_ASSIGNEE (EXECUTION_ID, PRE_TASK_ID, PRE_TASK_ASSINGEE, NEXT_TASK_ID, TASK_ID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 384K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_PROCESS_TASK_ASSIGNEE_IDX_2 on ZHPTCS.T_PROCESS_TASK_ASSIGNEE (TASK_EXE_CONFIG_ID, EXECUTION_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 256K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_PROCESS_TASK_ASSIGNEE
  add constraint PK_PROCESS_TASK_ASSIGNEE primary key (ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROCESS_TASK_ASSIGNEE_PERSON
prompt =============================================
prompt
create table ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON
(
  id                       NUMBER(12) not null,
  process_task_assignee_id NUMBER(12),
  execution_id             VARCHAR2(255),
  task_id                  VARCHAR2(255),
  task_assignee_id         VARCHAR2(64),
  task_assignee_state      VARCHAR2(2) default 0,
  parent_id                NUMBER(12) default 0,
  ischild                  VARCHAR2(2) default 0
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 256K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON
  is '流程节点办理人员关系表';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.id
  is '主键';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.process_task_assignee_id
  is '流程节点办理主键';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.execution_id
  is '流程实例id';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.task_id
  is '节点id';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.task_assignee_id
  is '节点办理人';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.task_assignee_state
  is '节点办理状态,0-未完成，1-已完成';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.parent_id
  is '父节点';
comment on column ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON.ischild
  is '0:不是子节点 1：是子节点';
create index ZHPTCS.TASK_ASSIGNEE_PERSON1 on ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON (TASK_ASSIGNEE_ID, TASK_ID, EXECUTION_ID)
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 256K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_PROC_TASK_IG_PERSON_IDX1 on ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON (EXECUTION_ID, TASK_ASSIGNEE_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 256K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_PROC_TASK_IG_PERSON_IDX2 on ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON (TASK_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON
  add constraint PK_PROCESS_TASK_PERSON primary key (ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_PROCESS_TASK_ASSIGNEE_PERSON
  add constraint FK_PROCESS_TASK_PERSON foreign key (PROCESS_TASK_ASSIGNEE_ID)
  references ZHPTCS.T_PROCESS_TASK_ASSIGNEE (ID);

prompt
prompt Creating table T_PROCESS_TASK_EXE_CONFIG
prompt ========================================
prompt
create table ZHPTCS.T_PROCESS_TASK_EXE_CONFIG
(
  id               NUMBER(12) not null,
  definition_id    VARCHAR2(255),
  activity_name    VARCHAR2(255),
  task_ass_id      VARCHAR2(255),
  task_ass_type    VARCHAR2(2),
  act_show_name    VARCHAR2(255),
  act_show_flag    VARCHAR2(2),
  before_name      VARCHAR2(255),
  is_record_submit VARCHAR2(2)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_PROCESS_TASK_EXE_CONFIG
  is '流程节点执行人配置表';
comment on column ZHPTCS.T_PROCESS_TASK_EXE_CONFIG.id
  is '主键';
comment on column ZHPTCS.T_PROCESS_TASK_EXE_CONFIG.definition_id
  is '流程定义id';
comment on column ZHPTCS.T_PROCESS_TASK_EXE_CONFIG.activity_name
  is '活动名称';
comment on column ZHPTCS.T_PROCESS_TASK_EXE_CONFIG.task_ass_id
  is '办理对象id';
comment on column ZHPTCS.T_PROCESS_TASK_EXE_CONFIG.task_ass_type
  is '办理对象类型01-指定岗位/02-动态机构/03-指定部门/04-起草人所属机构部门领导/05-起草人';
comment on column ZHPTCS.T_PROCESS_TASK_EXE_CONFIG.act_show_name
  is '节点选择展示名称';
comment on column ZHPTCS.T_PROCESS_TASK_EXE_CONFIG.is_record_submit
  is '是否记录提交人，1-记录';
alter table ZHPTCS.T_PROCESS_TASK_EXE_CONFIG
  add constraint PK_PROCESS_TASK_EXE_CONFIG primary key (ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_RANGE_USER
prompt ===========================
prompt
create table ZHPTCS.T_RANGE_USER
(
  user_id       NUMBER(12) not null,
  resource_id   NUMBER(12),
  emp_id        NUMBER(10) not null,
  resource_type VARCHAR2(2),
  des_id        NUMBER(10),
  des_time      VARCHAR2(10),
  des_date      VARCHAR2(10),
  isdes         VARCHAR2(2) default '00',
  orgname       VARCHAR2(30),
  send_id       NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_RANGE_USER
  is '数据使用人员表';
comment on column ZHPTCS.T_RANGE_USER.user_id
  is '主键';
comment on column ZHPTCS.T_RANGE_USER.resource_id
  is '来源表编号';
comment on column ZHPTCS.T_RANGE_USER.emp_id
  is '使用人员编号';
comment on column ZHPTCS.T_RANGE_USER.resource_type
  is '来源表类型';
comment on column ZHPTCS.T_RANGE_USER.des_id
  is '销毁人id';
comment on column ZHPTCS.T_RANGE_USER.des_time
  is '销毁时间';
comment on column ZHPTCS.T_RANGE_USER.des_date
  is '销毁日期';
comment on column ZHPTCS.T_RANGE_USER.isdes
  is '是否销毁数据';
comment on column ZHPTCS.T_RANGE_USER.orgname
  is '所在部门';
create index ZHPTCS.T_RANGE_USE_IDX_2 on ZHPTCS.T_RANGE_USER (EMP_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_RANGE_USE_IDX_3 on ZHPTCS.T_RANGE_USER (RESOURCE_ID, RESOURCE_TYPE)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_RANGE_USER
  add constraint PK_T_TYPE_USE primary key (USER_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SEND_DATA
prompt ==========================
prompt
create table ZHPTCS.T_SEND_DATA
(
  ds_id       NUMBER(12) not null,
  s_emp_id    NUMBER(10),
  flow_id     VARCHAR2(128),
  data_source VARCHAR2(2),
  da_pro      VARCHAR2(1024),
  data_type   VARCHAR2(2),
  rv_type     VARCHAR2(2),
  ds_title    VARCHAR2(128),
  ds_expl     VARCHAR2(1024),
  time_limit  VARCHAR2(8),
  create_date VARCHAR2(10),
  create_time VARCHAR2(8),
  data_user   VARCHAR2(1024),
  username    VARCHAR2(1024),
  org_id      NUMBER(10)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_SEND_DATA
  is '数据下发表';
comment on column ZHPTCS.T_SEND_DATA.ds_id
  is '下发表编号';
comment on column ZHPTCS.T_SEND_DATA.s_emp_id
  is '下发人编号';
comment on column ZHPTCS.T_SEND_DATA.flow_id
  is '流程id';
comment on column ZHPTCS.T_SEND_DATA.data_source
  is '数据来源';
comment on column ZHPTCS.T_SEND_DATA.da_pro
  is '数据申请流程';
comment on column ZHPTCS.T_SEND_DATA.data_type
  is '数据类型';
comment on column ZHPTCS.T_SEND_DATA.rv_type
  is '数据接收类型';
comment on column ZHPTCS.T_SEND_DATA.ds_title
  is '数据下发标题';
comment on column ZHPTCS.T_SEND_DATA.ds_expl
  is '数据下发说明';
comment on column ZHPTCS.T_SEND_DATA.time_limit
  is '数据使用时限';
comment on column ZHPTCS.T_SEND_DATA.create_date
  is '提交日期';
comment on column ZHPTCS.T_SEND_DATA.create_time
  is '提交时间';
comment on column ZHPTCS.T_SEND_DATA.data_user
  is '数据使用人员编号';
comment on column ZHPTCS.T_SEND_DATA.username
  is '数据使用人员姓名';
comment on column ZHPTCS.T_SEND_DATA.org_id
  is '下发人所在机构编号';
create index ZHPTCS.T_SEND_DATA_IDX_2 on ZHPTCS.T_SEND_DATA (S_EMP_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_SEND_DATA
  add constraint PK_T_SEND_DATA primary key (DS_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SUPERVICE_RECEIVE
prompt ==================================
prompt
create table ZHPTCS.T_SUPERVICE_RECEIVE
(
  rec_id       NUMBER(12) not null,
  supervise_id NUMBER(12),
  receive_emp  VARCHAR2(14),
  content      VARCHAR2(1024),
  status       VARCHAR2(2),
  receive_date VARCHAR2(10),
  receive_time VARCHAR2(6),
  node_id      VARCHAR2(255),
  node_name    VARCHAR2(128)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_SUPERVICE_RECEIVE
  is '督办接收单';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.rec_id
  is '接收编号';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.supervise_id
  is '督办单编号';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.receive_emp
  is '接收人';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.content
  is '反馈信息';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.status
  is '接收状态 0:未读 1：已读';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.receive_date
  is '接受日期';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.receive_time
  is '接收时间';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.node_id
  is '节点';
comment on column ZHPTCS.T_SUPERVICE_RECEIVE.node_name
  is '节点名称';
create index ZHPTCS.T_SUPERVICE_RECEIVE_INDEX2 on ZHPTCS.T_SUPERVICE_RECEIVE (SUPERVISE_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index ZHPTCS.T_SUPERVICE_RECEVICE_INDEX3 on ZHPTCS.T_SUPERVICE_RECEIVE (RECEIVE_EMP)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_SUPERVICE_RECEIVE
  add constraint PK_T_SUPERVICE_RECEIVE_INDEX1 primary key (REC_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SUPERVISE_TABLE
prompt ================================
prompt
create table ZHPTCS.T_SUPERVISE_TABLE
(
  supervise_id   NUMBER(12) not null,
  flow_id        VARCHAR2(255),
  supervise_item VARCHAR2(128),
  content        VARCHAR2(1024),
  imp_unit       VARCHAR2(128),
  co_unit        VARCHAR2(128),
  complete_date  VARCHAR2(14),
  createor       VARCHAR2(14),
  create_date    VARCHAR2(14),
  linker_phone   VARCHAR2(20),
  imp_unitname   VARCHAR2(128),
  co_unitname    VARCHAR2(512),
  create_time    VARCHAR2(8),
  orgid          NUMBER(10),
  imp_orgid      VARCHAR2(255),
  co_orgid       VARCHAR2(255),
  remind_id      VARCHAR2(255)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_SUPERVISE_TABLE
  is '督办单';
comment on column ZHPTCS.T_SUPERVISE_TABLE.supervise_id
  is '督办单编号';
comment on column ZHPTCS.T_SUPERVISE_TABLE.flow_id
  is '流程ID';
comment on column ZHPTCS.T_SUPERVISE_TABLE.supervise_item
  is '督办事项';
comment on column ZHPTCS.T_SUPERVISE_TABLE.content
  is '内容';
comment on column ZHPTCS.T_SUPERVISE_TABLE.imp_unit
  is '主办单位';
comment on column ZHPTCS.T_SUPERVISE_TABLE.co_unit
  is '协办单位';
comment on column ZHPTCS.T_SUPERVISE_TABLE.complete_date
  is '完成日期';
comment on column ZHPTCS.T_SUPERVISE_TABLE.createor
  is '创建人';
comment on column ZHPTCS.T_SUPERVISE_TABLE.create_date
  is '创建日期';
comment on column ZHPTCS.T_SUPERVISE_TABLE.linker_phone
  is '联系电话';
comment on column ZHPTCS.T_SUPERVISE_TABLE.imp_unitname
  is '主办单位';
comment on column ZHPTCS.T_SUPERVISE_TABLE.co_unitname
  is '协办单位名称';
comment on column ZHPTCS.T_SUPERVISE_TABLE.create_time
  is '创建时间';
comment on column ZHPTCS.T_SUPERVISE_TABLE.orgid
  is '归属机构编号';
comment on column ZHPTCS.T_SUPERVISE_TABLE.imp_orgid
  is '主办机构编号';
comment on column ZHPTCS.T_SUPERVISE_TABLE.co_orgid
  is '辅办机构编号';
comment on column ZHPTCS.T_SUPERVISE_TABLE.remind_id
  is '提醒行领导,填写empid';
create index ZHPTCS.T_SUPERVISE_TABLE_IDX1 on ZHPTCS.T_SUPERVISE_TABLE (FLOW_ID)
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ZHPTCS.T_SUPERVISE_TABLE
  add constraint PK_T_SUPERVISE_TABLE_INDEX1 primary key (SUPERVISE_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYN_LOG_ID
prompt ===========================
prompt
create table ZHPTCS.T_SYN_LOG_ID
(
  logid NUMBER
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYN_LOG_ID_20131213
prompt ====================================
prompt
create table ZHPTCS.T_SYN_LOG_ID_20131213
(
  logid NUMBER
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SYS_LOGINLOG
prompt =============================
prompt
create table ZHPTCS.T_SYS_LOGINLOG
(
  recid      NUMBER(10) not null,
  userid     VARCHAR2(20),
  empname    VARCHAR2(20),
  login_ip   VARCHAR2(15),
  login_time CHAR(14),
  login_flag CHAR(2)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 384K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_SYS_LOGINLOG
  is '登录日志';
comment on column ZHPTCS.T_SYS_LOGINLOG.recid
  is '编号';
comment on column ZHPTCS.T_SYS_LOGINLOG.userid
  is '登录用户代码';
comment on column ZHPTCS.T_SYS_LOGINLOG.empname
  is '登录用户名';
comment on column ZHPTCS.T_SYS_LOGINLOG.login_ip
  is '登录IP';
comment on column ZHPTCS.T_SYS_LOGINLOG.login_time
  is '登录时间';
comment on column ZHPTCS.T_SYS_LOGINLOG.login_flag
  is '登录标志';
alter table ZHPTCS.T_SYS_LOGINLOG
  add constraint PK_T_SYS_LOGINLOG primary key (RECID)
  using index 
  tablespace ZHPTINDEX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_WORK_MONTH_REPORTS
prompt ===================================
prompt
create table ZHPTCS.T_WORK_MONTH_REPORTS
(
  report_id    NUMBER(12) not null,
  flow_id      VARCHAR2(255),
  report_title VARCHAR2(128),
  content      VARCHAR2(1024),
  creator      VARCHAR2(14),
  create_date  VARCHAR2(10),
  create_time  VARCHAR2(6),
  create_name  VARCHAR2(32),
  orgid        NUMBER(10),
  report_month VARCHAR2(6)
)
tablespace ZHPTDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ZHPTCS.T_WORK_MONTH_REPORTS
  is '工作月报表';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.report_id
  is '月报编号';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.flow_id
  is '流程ID';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.report_title
  is '月报标题';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.content
  is '月报内容';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.creator
  is '创建人';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.create_date
  is '创建日期';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.create_time
  is '创建时间';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.create_name
  is '创建人姓名';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.orgid
  is '归属机构';
comment on column ZHPTCS.T_WORK_MONTH_REPORTS.report_month
  is '月报月份格式为yyyyMM';
alter table ZHPTCS.T_WORK_MONTH_REPORTS
  add constraint PK_T_WORK_MONTH_REPORTS_INDEX1 primary key (REPORT_ID)
  using index 
  tablespace ZHPTDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence ABF_T_RYKGLJG_SEQ
prompt ===================================
prompt
create sequence ZHPTCS.ABF_T_RYKGLJG_SEQ
minvalue 1
maxvalue 9999999999999
start with 16896
increment by 1
cache 5;

prompt
prompt Creating sequence ABF_T_ZZJGGXSB_SEQ
prompt ====================================
prompt
create sequence ZHPTCS.ABF_T_ZZJGGXSB_SEQ
minvalue 1
maxvalue 9999999999999
start with 9697
increment by 1
cache 5;

prompt
prompt Creating sequence AC_APPLICATION_SEQ
prompt ====================================
prompt
create sequence ZHPTCS.AC_APPLICATION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence AC_FUNCGROUP_SEQ
prompt ==================================
prompt
create sequence ZHPTCS.AC_FUNCGROUP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence IMP_LOG_SEQ
prompt =============================
prompt
create sequence ZHPTCS.IMP_LOG_SEQ
minvalue 1
maxvalue 999999999999
start with 281
increment by 1
cache 20;

prompt
prompt Creating sequence OM_EMPLOYEE_SEQ
prompt =================================
prompt
create sequence ZHPTCS.OM_EMPLOYEE_SEQ
minvalue 1
maxvalue 9999999999999
start with 424569
increment by 1
cache 5;

prompt
prompt Creating sequence OM_ORGANIZATION_SEQ
prompt =====================================
prompt
create sequence ZHPTCS.OM_ORGANIZATION_SEQ
minvalue 1
maxvalue 9999999999999
start with 5507
increment by 1
cache 5;

prompt
prompt Creating sequence OM_POSITION_SEQ
prompt =================================
prompt
create sequence ZHPTCS.OM_POSITION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_ABF_SYS
prompt =============================
prompt
create sequence ZHPTCS.SEQ_ABF_SYS
minvalue 1
maxvalue 999999999999999999999999999
start with 442583
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_AC_FUNCGROUP
prompt ==================================
prompt
create sequence ZHPTCS.SEQ_AC_FUNCGROUP
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_GENERALPROCESS_MISTAKE
prompt ============================================
prompt
create sequence ZHPTCS.SEQ_GENERALPROCESS_MISTAKE
minvalue 1
maxvalue 999999999999999999999999999
start with 121
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_OM_POSITION
prompt =================================
prompt
create sequence ZHPTCS.SEQ_OM_POSITION
minvalue 1
maxvalue 9999999999
start with 162
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_APPROVE_OPNINION_GP
prompt ===========================================
prompt
create sequence ZHPTCS.SEQ_T_APPROVE_OPNINION_GP
minvalue 1
maxvalue 999999999999999999999999999
start with 781
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELEIG
prompt ===============================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELEIG
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELFIVE
prompt ================================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELFIVE
minvalue 1
maxvalue 999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELFOUR
prompt ================================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELFOUR
minvalue 1
maxvalue 999999999999999999999999999
start with 161
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELONE
prompt ===============================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELONE
minvalue 1
maxvalue 999999999999999999999999999
start with 190
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELSEV
prompt ===============================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELSEV
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELSIX
prompt ===============================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELSIX
minvalue 1
maxvalue 999999999999999999999999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELTHR
prompt ===============================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELTHR
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_GENERALPROCESS_MODELTWO
prompt ===============================================
prompt
create sequence ZHPTCS.SEQ_T_GENERALPROCESS_MODELTWO
minvalue 1
maxvalue 999999999999999999999999999
start with 241
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_NEW_DEVICEMANAGEMENT
prompt ============================================
prompt
create sequence ZHPTCS.SEQ_T_NEW_DEVICEMANAGEMENT
minvalue 1
maxvalue 99999999999
start with 93
increment by 1
nocache
order;

prompt
prompt Creating sequence SEQ_T_NEW_DEVICEMANDETAIL
prompt ===========================================
prompt
create sequence ZHPTCS.SEQ_T_NEW_DEVICEMANDETAIL
minvalue 1
maxvalue 99999999999
start with 109
increment by 1
nocache
order;

prompt
prompt Creating sequence SET_T_GENERALPROCESS_MAIN
prompt ===========================================
prompt
create sequence ZHPTCS.SET_T_GENERALPROCESS_MAIN
minvalue 1
maxvalue 999999999999999999999999999
start with 181
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_T_APPLY_DATA_1
prompt ===================================
prompt
create sequence ZHPTCS.SQ_T_APPLY_DATA_1
minvalue 1
maxvalue 999999999999999999999999999
start with 1023
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_T_APPLY_LEAVE_ID_1
prompt =======================================
prompt
create sequence ZHPTCS.SQ_T_APPLY_LEAVE_ID_1
minvalue 1
maxvalue 999999999999999999999999999
start with 1587
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_T_RANGE_USER_1
prompt ===================================
prompt
create sequence ZHPTCS.SQ_T_RANGE_USER_1
minvalue 1
maxvalue 999999999999999999999999999
start with 1305
increment by 1
cache 20;

prompt
prompt Creating sequence SQ_T_SEND_DATA_1
prompt ==================================
prompt
create sequence ZHPTCS.SQ_T_SEND_DATA_1
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence T_APPLY_EUIP_SEQ
prompt ==================================
prompt
create sequence ZHPTCS.T_APPLY_EUIP_SEQ
minvalue 1
maxvalue 999999999999
start with 466
increment by 1
cache 20;

prompt
prompt Creating sequence T_APPROVE_OPNINION_SEQ
prompt ========================================
prompt
create sequence ZHPTCS.T_APPROVE_OPNINION_SEQ
minvalue 1
maxvalue 999999999999
start with 6865
increment by 1
cache 20;

prompt
prompt Creating sequence T_AUDIT_SCORE_SEQ
prompt ===================================
prompt
create sequence ZHPTCS.T_AUDIT_SCORE_SEQ
minvalue 1
maxvalue 9999999999
start with 3073
increment by 1
cache 64;

prompt
prompt Creating sequence T_COMMON_PROCESS_SEQ
prompt ======================================
prompt
create sequence ZHPTCS.T_COMMON_PROCESS_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 621
increment by 1
cache 20;

prompt
prompt Creating sequence T_DEFAULT_OPINION_SEQ
prompt =======================================
prompt
create sequence ZHPTCS.T_DEFAULT_OPINION_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 860
increment by 1
cache 20;

prompt
prompt Creating sequence T_FILE_RESOURCE_TABLE_SEQ
prompt ===========================================
prompt
create sequence ZHPTCS.T_FILE_RESOURCE_TABLE_SEQ
minvalue 1
maxvalue 999999999999
start with 2977
increment by 1
cache 20;

prompt
prompt Creating sequence T_GOTOUT_QUETION_SEQ
prompt ======================================
prompt
create sequence ZHPTCS.T_GOTOUT_QUETION_SEQ
minvalue 1
maxvalue 9999999999
start with 17477
increment by 1
cache 64;

prompt
prompt Creating sequence T_GROUP_SEQ
prompt =============================
prompt
create sequence ZHPTCS.T_GROUP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence T_IMPORT_BATCH_SEQ
prompt ====================================
prompt
create sequence ZHPTCS.T_IMPORT_BATCH_SEQ
minvalue 1
maxvalue 9999999999
start with 139
increment by 1
cache 64;

prompt
prompt Creating sequence T_INTE_CORDON_SEQ
prompt ===================================
prompt
create sequence ZHPTCS.T_INTE_CORDON_SEQ
minvalue 1
maxvalue 999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence T_MACHINE_ACCOUNT_SEQ
prompt =======================================
prompt
create sequence ZHPTCS.T_MACHINE_ACCOUNT_SEQ
minvalue 1
maxvalue 9999999999
start with 257
increment by 1
cache 64;

prompt
prompt Creating sequence T_MESSAGE_PUBLISH_SEQ
prompt =======================================
prompt
create sequence ZHPTCS.T_MESSAGE_PUBLISH_SEQ
minvalue 1
maxvalue 999999999999
start with 1245
increment by 1
cache 20;

prompt
prompt Creating sequence T_MESSAGE_RECEIVE_SEQ
prompt =======================================
prompt
create sequence ZHPTCS.T_MESSAGE_RECEIVE_SEQ
minvalue 1
maxvalue 999999999999
start with 1857
increment by 1
cache 20;

prompt
prompt Creating sequence T_MESSAGE_RED_PER_SEQ
prompt =======================================
prompt
create sequence ZHPTCS.T_MESSAGE_RED_PER_SEQ
minvalue 1
maxvalue 999999999999
start with 1528
increment by 1
cache 20;

prompt
prompt Creating sequence T_METTING_APPLY_SEQ
prompt =====================================
prompt
create sequence ZHPTCS.T_METTING_APPLY_SEQ
minvalue 1
maxvalue 999999999999
start with 249
increment by 1
cache 20;

prompt
prompt Creating sequence T_METTING_RECEIVE_SEQ
prompt =======================================
prompt
create sequence ZHPTCS.T_METTING_RECEIVE_SEQ
minvalue 1
maxvalue 999999999999
start with 317
increment by 1
cache 20;

prompt
prompt Creating sequence T_OPERATER_LOG_INFO_SEQ
prompt =========================================
prompt
create sequence ZHPTCS.T_OPERATER_LOG_INFO_SEQ
minvalue 1
maxvalue 999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence T_OPERATER_PATH_REMARK_SEQ
prompt ============================================
prompt
create sequence ZHPTCS.T_OPERATER_PATH_REMARK_SEQ
minvalue 1
maxvalue 999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence T_ORG_LINE_INFO_SEQ
prompt =====================================
prompt
create sequence ZHPTCS.T_ORG_LINE_INFO_SEQ
minvalue 1
maxvalue 999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence T_PROCESS_BUSINESS_SEQ
prompt ========================================
prompt
create sequence ZHPTCS.T_PROCESS_BUSINESS_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 2411
increment by 1
cache 20;

prompt
prompt Creating sequence T_PROCESS_CONFIG_PERSON_SEQ
prompt =============================================
prompt
create sequence ZHPTCS.T_PROCESS_CONFIG_PERSON_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 791
increment by 1
cache 20;

prompt
prompt Creating sequence T_PROCESS_CONFIG_SEQ
prompt ======================================
prompt
create sequence ZHPTCS.T_PROCESS_CONFIG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 502
increment by 1
cache 20;

prompt
prompt Creating sequence T_PROCESS_TASK_ASSIGNEEP_SEQ
prompt ==============================================
prompt
create sequence ZHPTCS.T_PROCESS_TASK_ASSIGNEEP_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 6354
increment by 1
cache 20;

prompt
prompt Creating sequence T_PROCESS_TASK_ASSIGNEE_SEQ
prompt =============================================
prompt
create sequence ZHPTCS.T_PROCESS_TASK_ASSIGNEE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 6591
increment by 1
cache 20;

prompt
prompt Creating sequence T_PROCESS_TASK_EXE_CONFIG_SEQ
prompt ===============================================
prompt
create sequence ZHPTCS.T_PROCESS_TASK_EXE_CONFIG_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1397
increment by 1
cache 20;

prompt
prompt Creating sequence T_QUESTION_SCORE_MANAGE_SEQ
prompt =============================================
prompt
create sequence ZHPTCS.T_QUESTION_SCORE_MANAGE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence T_QUESTION_SCORE_SEQ
prompt ======================================
prompt
create sequence ZHPTCS.T_QUESTION_SCORE_SEQ
minvalue 1
maxvalue 9999999999
start with 335861
increment by 1
cache 20;

prompt
prompt Creating sequence T_SUPERVICE_RECEIVE_SEQ
prompt =========================================
prompt
create sequence ZHPTCS.T_SUPERVICE_RECEIVE_SEQ
minvalue 1
maxvalue 999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence T_SUPERVISE_TABLE_SEQ
prompt =======================================
prompt
create sequence ZHPTCS.T_SUPERVISE_TABLE_SEQ
minvalue 1
maxvalue 999999999999
start with 334
increment by 1
cache 20;

prompt
prompt Creating sequence T_SYS_LOGINLOG_SEQ
prompt ====================================
prompt
create sequence ZHPTCS.T_SYS_LOGINLOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 11705
increment by 1
cache 20;

prompt
prompt Creating sequence T_WORK_MONTH_REPORTS_SEQ
prompt ==========================================
prompt
create sequence ZHPTCS.T_WORK_MONTH_REPORTS_SEQ
minvalue 1
maxvalue 999999999999
start with 729
increment by 1
cache 20;

prompt
prompt Creating view V_APP_CONDITION
prompt =============================
prompt
create or replace force view zhptcs.v_app_condition as
select t2.execution_id,
      max( decode(activity_name_, '审查一',t3.empname,null)) as sc1,
      max( decode(activity_name_, '审查二',t3.empname,null)) as sc2,
      max( decode(activity_name_, '审批一',t3.empname,null)) as sp1,
      max( decode(activity_name_, '审批二',t3.empname,null)) as sp2
  from jbpm4_hist_actinst t1, T_PROCESS_TASK_ASSIGNEE t2, om_employee t3
 where t1.htask_ = t2.pre_task_id
   and t3.empid = t2.pre_task_assingee
   and t1.activity_name_ in ('审查一', '审查二' , '审批一', '审批二')
group by t2.execution_id;

prompt
prompt Creating view V_GENERALPROCESS_XD
prompt =================================
prompt
create or replace force view zhptcs.v_generalprocess_xd as
select gm.business_id as flow_id,
       gm.begin_empid,
       gm.begin_orgid,
       decode(g1.cust_name,null,g6.cust_name,g1.cust_name) as cust_name,
       decode(g1.currency,null,g6.support_moneytype,g1.currency) as currency,
        decode(g1.apply_bal,null,g6.support_money,g1.apply_bal) as apply_bal,
       g1.onecategory,
       g1.loancategory,
       o.orgname,e.empname,g1.orgcodeone,g1.orgcodetwo,e2.empname as creator,g3.reporttime,
       g6.support_category
  from t_generalprocess_main gm, t_generalprocess_modelone g1,om_employee e,om_organization o,om_employee e2,t_generalprocess_modelthree g3,t_generalprocess_modelsix g6
 where gm.business_id = g1.flow_id(+)
 and gm.business_id=g6.flow_id(+)
 and e.empid(+)=gm.begin_empid
 and e2.empid(+)=g1.creator
 and o.orgid(+)=gm.begin_orgid
  and gm.business_id=g3.flow_id(+);

prompt
prompt Creating function SPLITARRAYLENGTH
prompt ==================================
prompt
CREATE OR REPLACE FUNCTION ZHPTCS.splitArrayLength (v_source IN VARCHAR2, v_delimiter IN VARCHAR2)
  RETURN INT IS
  j    INT := 0;
  i    INT := 1;
  len  INT := 0;
  delim_len INT := 0;
  cnt INT := 0;
BEGIN
  len  := length(v_source);
  delim_len := length(v_delimiter);
  WHILE j < len LOOP
    j := instr(v_source, v_delimiter, i);
    IF j = 0 THEN
      j := len;
      cnt := cnt+1;
      IF i >= len THEN
        EXIT;
      END IF;
    ELSE
      i := j + delim_len;
      cnt := cnt+1;
    END IF;
  END LOOP;
  RETURN cnt;
END splitArrayLength;
/

prompt
prompt Creating procedure P_SYN_ORG_EMP
prompt ================================
prompt
CREATE OR REPLACE PROCEDURE ZHPTCS.P_SYN_ORG_EMP AS
  P_CURRID  NUMBER;
  P_MAXID   NUMBER;
  N_ORG_LOG NUMBER;
  N_EMP_LOG NUMBER;
  N_AC_LOG  NUMBER;
  N_ABF_LOG NUMBER;
  N_EO_LOG  NUMBER;
BEGIN
  SELECT LOGID INTO P_CURRID FROM T_SYN_LOG_ID;
  SELECT MAX(LOGID) INTO P_MAXID FROM DDDLXT.T_SYN_LOG;
  SELECT COUNT(1)
    INTO N_ORG_LOG
    FROM DDDLXT.OM_ORGANIZATION A,
         (SELECT OPERID, TABLENAME, OPERTYPE
            FROM DDDLXT.T_SYN_LOG
           WHERE LOGID > P_CURRID
             AND LOGID <= P_MAXID
             AND TABLENAME = 'OM_ORGANIZATION') B
   WHERE A.ISSYN = '1'
     AND A.ORGID = B.OPERID;
  SELECT COUNT(1)
    INTO N_EMP_LOG
    FROM DDDLXT.OM_EMPLOYEE A,
         (SELECT OPERID, TABLENAME, OPERTYPE
            FROM DDDLXT.T_SYN_LOG
           WHERE LOGID > P_CURRID
             AND LOGID <= P_MAXID
             AND TABLENAME = 'OM_EMPLOYEE') B
   WHERE A.ISSYN = '1'
     AND A.EMPID = B.OPERID;
  SELECT COUNT(1)
    INTO N_AC_LOG
    FROM DDDLXT.OM_EMPLOYEE A,
         (SELECT OPERID, TABLENAME, OPERTYPE
            FROM DDDLXT.T_SYN_LOG
           WHERE LOGID > P_CURRID
             AND LOGID <= P_MAXID
             AND TABLENAME = 'AC_OPERATOR') B
   WHERE A.ISSYN = '1'
     AND A.EMPID = B.OPERID;
  SELECT COUNT(1)
    INTO N_ABF_LOG
    FROM DDDLXT.OM_EMPLOYEE A,
         (SELECT OPERID, TABLENAME, OPERTYPE
            FROM DDDLXT.T_SYN_LOG
           WHERE LOGID > P_CURRID
             AND LOGID <= P_MAXID
             AND TABLENAME = 'ABF_T_YGFJXXB') B
   WHERE A.ISSYN = '1'
     AND A.EMPID = B.OPERID;
  SELECT COUNT(1)
    INTO N_EO_LOG
    FROM DDDLXT.OM_EMPLOYEE A,
         (SELECT OPERID, TABLENAME, OPERTYPE
            FROM DDDLXT.T_SYN_LOG
           WHERE LOGID > P_CURRID
             AND LOGID <= P_MAXID
             AND TABLENAME = 'OM_EMPORG') B
   WHERE A.ISSYN = '1'
     AND A.EMPID = B.OPERID;
  IF P_MAXID > P_CURRID AND N_ORG_LOG > 0 THEN

    DELETE FROM OM_ORGANIZATION
     WHERE ORGID IN (SELECT ORGID
                       FROM DDDLXT.OM_ORGANIZATION A,
                            (SELECT OPERID, TABLENAME, OPERTYPE
                               FROM DDDLXT.T_SYN_LOG
                              WHERE LOGID > P_CURRID
                                AND LOGID <= P_MAXID
                                AND TABLENAME = 'OM_ORGANIZATION') B
                      WHERE A.ISSYN = '1'
                        AND A.ORGID = B.OPERID);
            commit;
    INSERT INTO OM_ORGANIZATION
      (ORGID,
       ORGCODE,
       ORGNAME,
       ORGLEVEL,
       ORGDEGREE,
       PARENTORGID,
       ORGSEQ,
       ORGTYPE,
       ORGADDR,
       ZIPCODE,
       MANAPOSITION,
       MANAGERID,
       ORGMANAGER,
       LINKMAN,
       LINKTEL,
       EMAIL,
       WEBURL,
       STARTDATE,
       ENDDATE,
       STATUS,
       AREA,
       CREATETIME,
       LASTUPDATE,
       UPDATOR,
       SORTNO,
       ISLEAF,
       SUBCOUNT,
       REMARK,
       ORGTYPEFIELD,
       REALNAME,
       DISPLAYORDER,
       ORGYSJGID,
       SNBZ,
       WHRY,
       WHSJ,
       JGSX,
       YSJGBH,
       ZHJB,
       AREATYPE,
       COMMENTS)
      SELECT ORGID,
             ORGCODE,
             ORGNAME,
             ORGLEVEL,
             ORGDEGREE,
             PARENTORGID,
             ORGSEQ,
             ORGTYPE,
             ORGADDR,
             ZIPCODE,
             MANAPOSITION,
             MANAGERID,
             ORGMANAGER,
             LINKMAN,
             LINKTEL,
             EMAIL,
             WEBURL,
             STARTDATE,
             ENDDATE,
             STATUS,
             AREA,
             CREATETIME,
             LASTUPDATE,
             UPDATOR,
             SORTNO,
             ISLEAF,
             SUBCOUNT,
             REMARK,
             ORGTYPEFIELD,
             REALNAME,
             DISPLAYORDER,
             ORGYSJGID,
             SNBZ,
             WHRY,
             WHSJ,
             JGSX,
             YSJGBH,
             ZHJB,
             AREATYPE,
             COMMENTS
        FROM DDDLXT.OM_ORGANIZATION
       WHERE ORGID IN (SELECT ORGID
                         FROM DDDLXT.OM_ORGANIZATION A,
                              (SELECT OPERID, TABLENAME, OPERTYPE
                                 FROM DDDLXT.T_SYN_LOG
                                WHERE LOGID > P_CURRID
                                  AND LOGID <= P_MAXID
                                  AND TABLENAME = 'OM_ORGANIZATION') B
                        WHERE A.ISSYN = '1'
                          AND A.ORGID = B.OPERID);
                          commit;
  END IF;
  IF P_MAXID > P_CURRID AND N_EMP_LOG > 0 THEN
    DELETE FROM OM_EMPLOYEE
     WHERE EMPID IN (SELECT EMPID
                       FROM DDDLXT.OM_EMPLOYEE A,
                            (SELECT OPERID, TABLENAME, OPERTYPE
                               FROM DDDLXT.T_SYN_LOG
                              WHERE LOGID > P_CURRID
                                AND LOGID <= P_MAXID
                                AND TABLENAME = 'OM_EMPLOYEE') B
                      WHERE A.ISSYN = '1'
                        AND A.EMPID = B.OPERID);
                         commit;
    INSERT INTO OM_EMPLOYEE
      (EMPID,
       EMPCODE,
       OPERATORID,
       USERID,
       EMPNAME,
       REALNAME,
       GENDER,
       BIRTHDATE,
       POSITION,
       EMPSTATUS,
       CARDTYPE,
       CARDNO,
       INDATE,
       OUTDATE,
       DEGREE,
       REGDATE,
       CREATETIME,
       LASTMODYTIME,
       REMARK,
       DISPLAYORDER,
       EXPNOTE,
       EMERGNOTE,
       GENNOTE,
       UPDATOR)
      SELECT EMPID,
             EMPCODE,
             OPERATORID,
             USERID,
             EMPNAME,
             REALNAME,
             GENDER,
             BIRTHDATE,
             POSITION,
             EMPSTATUS,
             CARDTYPE,
             CARDNO,
             INDATE,
             OUTDATE,
             DEGREE,
             REGDATE,
             CREATETIME,
             LASTMODYTIME,
             REMARK,
             DISPLAYORDER,
             EXPNOTE,
             EMERGNOTE,
             GENNOTE,
             UPDATOR
        FROM DDDLXT.OM_EMPLOYEE
       WHERE EMPID IN (SELECT EMPID
                         FROM DDDLXT.OM_EMPLOYEE A,
                              (SELECT OPERID, TABLENAME, OPERTYPE
                                 FROM DDDLXT.T_SYN_LOG
                                WHERE LOGID > P_CURRID
                                  AND LOGID <= P_MAXID
                                  AND TABLENAME = 'OM_EMPLOYEE') B
                        WHERE A.ISSYN = '1'
                          AND A.EMPID = B.OPERID);
                           commit;
  END IF;
  IF P_MAXID > P_CURRID AND N_AC_LOG > 0 THEN
    DELETE FROM AC_OPERATOR
     WHERE EMPID IN (SELECT EMPID
                       FROM DDDLXT.OM_EMPLOYEE A,
                            (SELECT OPERID, TABLENAME, OPERTYPE
                               FROM DDDLXT.T_SYN_LOG
                              WHERE LOGID > P_CURRID
                                AND LOGID <= P_MAXID
                                AND TABLENAME = 'AC_OPERATOR') B
                      WHERE A.ISSYN = '1'
                        AND A.EMPID = B.OPERID);
                         commit;
    INSERT INTO AC_OPERATOR
      (OPERATORID,
       USERID,
       PASSWORD,
       INVALDATE,
       OPERATORNAME,
       AUTHMODE,
       STATUS,
       UNLOCKTIME,
       MENUTYPE,
       LASTLOGIN,
       ERRCOUNT,
       STARTDATE,
       ENDDATE,
       VALIDTIME,
       MACCODE,
       IPADDRESS,
       EMAIL,
       EMPID,
       HEADPICICON,
       LAYOUTMODE)
      SELECT OPERATORID,
             USERID,
             PASSWORD,
             INVALDATE,
             OPERATORNAME,
             AUTHMODE,
             STATUS,
             UNLOCKTIME,
             MENUTYPE,
             LASTLOGIN,
             ERRCOUNT,
             STARTDATE,
             ENDDATE,
             VALIDTIME,
             MACCODE,
             IPADDRESS,
             EMAIL,
             EMPID,
             HEADPICICON,
             LAYOUTMODE
        FROM DDDLXT.AC_OPERATOR
       WHERE EMPID IN (SELECT EMPID
                         FROM DDDLXT.OM_EMPLOYEE A,
                              (SELECT OPERID, TABLENAME, OPERTYPE
                                 FROM DDDLXT.T_SYN_LOG
                                WHERE LOGID > P_CURRID
                                  AND LOGID <= P_MAXID
                                  AND TABLENAME = 'AC_OPERATOR') B
                        WHERE A.ISSYN = '1'
                          AND A.EMPID = B.OPERID);
                           commit;
  END IF;
  IF P_MAXID > P_CURRID AND N_ABF_LOG > 0 THEN
    DELETE FROM ABF_T_YGFJXXB
     WHERE EMPID IN (SELECT EMPID
                       FROM DDDLXT.OM_EMPLOYEE A,
                            (SELECT OPERID, TABLENAME, OPERTYPE
                               FROM DDDLXT.T_SYN_LOG
                              WHERE LOGID > P_CURRID
                                AND LOGID <= P_MAXID
                                AND TABLENAME = 'ABF_T_YGFJXXB') B
                      WHERE A.ISSYN = '1'
                        AND A.EMPID = B.OPERID);
                         commit;
    INSERT INTO ABF_T_YGFJXXB
      (EMPID,
       BIRTHDATE,
       OTEL,
       OADDRESS,
       OZIPCODE,
       OEMAIL,
       FAXNO,
       MOBILENO,
       MOBSHOW,
       MSN,
       HTEL,
       HTSHOW,
       HADDRESS,
       HZIPCODE,
       PEMAIL,
       PARTY,
       MAJOR,
       WORKEXP,
       REGDATE,
       CREATETIME,
       LASTMODYTIME,
       REMARK,
       DISPLAYORDER)
      SELECT EMPID,
             BIRTHDATE,
             OTEL,
             OADDRESS,
             OZIPCODE,
             OEMAIL,
             FAXNO,
             MOBILENO,
             MOBSHOW,
             MSN,
             HTEL,
             HTSHOW,
             HADDRESS,
             HZIPCODE,
             PEMAIL,
             PARTY,
             MAJOR,
             WORKEXP,
             REGDATE,
             CREATETIME,
             LASTMODYTIME,
             REMARK,
             DISPLAYORDER
        FROM DDDLXT.ABF_T_YGFJXXB
       WHERE EMPID IN (SELECT EMPID
                         FROM DDDLXT.OM_EMPLOYEE A,
                              (SELECT OPERID, TABLENAME, OPERTYPE
                                 FROM DDDLXT.T_SYN_LOG
                                WHERE LOGID > P_CURRID
                                  AND LOGID <= P_MAXID
                                  AND TABLENAME = 'ABF_T_YGFJXXB') B
                        WHERE A.ISSYN = '1'
                          AND A.EMPID = B.OPERID);
                           commit;
  END IF;
  IF P_MAXID > P_CURRID AND N_EO_LOG > 0 THEN
    DELETE FROM OM_EMPORG
     WHERE EMPID IN (SELECT EMPID
                       FROM DDDLXT.OM_EMPLOYEE A,
                            (SELECT OPERID, TABLENAME, OPERTYPE
                               FROM DDDLXT.T_SYN_LOG
                              WHERE LOGID > P_CURRID
                                AND LOGID <= P_MAXID
                                AND TABLENAME = 'OM_EMPORG') B
                      WHERE A.ISSYN = '1'
                        AND A.EMPID = B.OPERID);
                         commit;
    INSERT INTO OM_EMPORG
      (EMPID, ORGID, ISMAIN)
      SELECT EMPID, ORGID, ISMAIN
        FROM DDDLXT.OM_EMPORG
       WHERE EMPID IN (SELECT EMPID
                         FROM DDDLXT.OM_EMPLOYEE A,
                              (SELECT OPERID, TABLENAME, OPERTYPE
                                 FROM DDDLXT.T_SYN_LOG
                                WHERE LOGID > P_CURRID
                                  AND LOGID <= P_MAXID
                                  AND TABLENAME = 'OM_EMPORG') B
                        WHERE A.ISSYN = '1'
                          AND A.EMPID = B.OPERID);
                           commit;
  END IF;
  UPDATE T_SYN_LOG_ID SET LOGID = P_MAXID;
  COMMIT;
END;
/

prompt
prompt Creating trigger OMORG_BEFORE_UPDATE
prompt ====================================
prompt
CREATE OR REPLACE TRIGGER ZHPTCS.omorg_before_update
  before update on om_organization
  for each row
declare
  -- local variables here
  Pragma autonomous_transaction;
begin
  update ABF_T_ZZJGGXSB a set a.ORGCODE = :new.orgcode,
                            a.ORGNAME = :new.ORGNAME,
                            a.ORGDEGREE = :new.ORGDEGREE,
                            a.orgtype = :new.orgtype,
                            a.Jgsx = :new.jgsx,
                            a.PARENTORGID =:new.Parentorgid,
                            a.Parentorgcode = (SELECT orgcode FROM om_organization b WHERE b.orgid=:new.Parentorgid AND rownum=1),
                            a.Parentid = (SELECT id FROM abf_t_zzjggxsb c WHERE c.orgid = :new.Parentorgid  AND a.topid = c.topid)
                        where orgid = :new.orgid;
                        COMMIT;
end omorg_change_trig;
/


spool off
