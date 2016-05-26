DELETE  FROM   t_process_business t WHERE   t.execution_id  IN(

SELECT  flow_id FROM  (

SELECT 

flow_id,

MAX(Z.UPTIME) AS UPTIME,
               MAX(Z.LOOKTIME) AS LOOKTIME,
               MAX(Z.REPORTTIME) AS REPORTTIME,
               MAX(Z.ISURGENT) AS ISURGENT,
               MAX(Z.CUST_NAME) AS CUST_NAME,
               MAX(Z.OLD_CUST) AS OLD_CUST,
               MAX(Z.ONECATEGORY) AS ONECATEGORY,
               MAX(Z.LOANCATEGORY) AS LOANCATEGORY,
               MAX(Z.CURRENCY) AS CURRENCY,
               MAX(Z.APPLY_BAL) AS APPLY_BAL,
               MAX(Z.ORGNAMEONE) AS ORGNAMEONE,
               MAX(Z.YXRY) AS YXRY,
               MAX(Z.YXRYJG) AS YXRYJG,
               MAX(Z.NEXT_OPR_NAME) AS NEXT_OPR_NAME,
               MAX(Z.FDXDY) AS FDXDY,
               MAX(Z.APP_WAY) AS APP_WAY,
               MAX(Z.SURVEY_TIME) AS SURVEY_TIME,
               MAX(Z.POL_NO) AS POL_NO,
               MAX(Z.MEETING_COUNT) AS MEETING_COUNT,
               MAX(Z.VOTE_NO) AS VOTE_NO,
               MAX(Z.APP_TIME) AS APP_TIME,
               MAX(Z.CON_MATTER) AS CON_MATTER,
               MAX(Z.DS_MS_ONE) AS DS_MS_ONE,
               MAX(Z.DS_MS_TWO) AS DS_MS_TWO,
               MAX(Z.DY_APP) AS DY_APP,
               MAX(Z.DE_APP) AS DE_APP,
               MAX(Z.TITLE) AS TITLE,
               MAX(Z.HY_ZR_NAME) AS HY_ZR_NAME,
               MAX(Z.HY_WY_ONE) AS HY_WY_ONE,
               MAX(Z.SH_ADDR) AS SH_ADDR,
               MAX(Z.FX_TYPE) AS FX_TYPE,
               MAX(Z.SP_TYPE) AS SP_TYPE,
               MAX(Z.YBJ_NUM) AS YBJ_NUM,
               MAX(Z.HY_SY_JL) AS HY_SY_JL,
               MAX(Z.PJ_JL) AS PJ_JL,
               MAX(Z.FX_ED) AS FX_ED,
               MAX(Z.SX_ED) AS SX_ED,
               MAX(Z.YW_ED) AS YW_ED,
               MAX(Z.NEXTORGNAME) AS NEXTORGNAME,
               MAX(Z.ORGNAMETWO) AS ORGNAMETWO,
               MAX(Z.APPROVALTIME) AS APPROVALTIME,
               MAX(Z.CHECKTIME) AS CHECKTIME,
               MAX(Z.REPLYTIME) AS REPLYTIME,
               MAX(Z.CHECKONE) AS CHECKONE,
               MAX(Z.CHECKTWO) AS CHECKTWO,
               MAX(Z.RECEIVETIME) AS RECEIVETIME,
               MAX(Z.RETURNTIME) AS RETURNTIME,
               MAX(Z.REPORTEDTIME) AS REPORTEDTIME
          FROM (SELECT A7.UPTIME,
                       A8.LOOKTIME,
                       Z.REPORTTIME,
                       Z.ISURGENT,
                       Z.CUST_NAME,
                       Z.OLD_CUST,
                       Z.ONECATEGORY,
                       Z.LOANCATEGORY,
                       Z.CURRENCY,
                       Z.APPLY_BAL,
                       Z.ORGNAMEONE,
                       Z.FLOW_ID,
                       Z.YXRY,
                       Z.YXRYJG,
                       Z.NEXT_OPR_NAME,
                       Z.FDXDY,
                       Z.APP_WAY,
                       Z.SURVEY_TIME,
                       Z.POL_NO,
                       Z.MEETING_COUNT,
                       Z.VOTE_NO,
                       TO_CHAR(TO_DATE(Z.APP_TIME, 'YYYY-mm-DD'),
                               'YYYY-mm-DD') AS APP_TIME,
                       Z.CON_MATTER,
                       Z.DS_MS_ONE,
                       Z.DS_MS_TWO,
                       (CASE
                         WHEN Z.DY_APP IS NULL THEN
                          D1.DYAPP1
                         ELSE
                          Z.DY_APP
                       END) AS DY_APP,
                       (CASE
                         WHEN Z.DE_APP IS NULL THEN
                          D2.DEAPP1
                         ELSE
                          Z.DE_APP
                       END) AS DE_APP,
                       D3.BUSINESS_TITLE AS TITLE,
                       Z.HY_ZR_NAME,
                       Z.HY_WY_ONE,
                       Z.SH_ADDR,
                       Z.FX_TYPE,
                       Z.SP_TYPE,
                       Z.YBJ_NUM,
                       Z.HY_SY_JL,
                       Z.PJ_JL,
                       Z.FX_ED,
                       Z.SX_ED,
                       Z.YW_ED,
                       Z.NEXTORGNAME,
                       O1.ORGNAMETWO,
                       A1.APPROVALTIME,
                       A2.CHECKTIME,
                       A3.REPLYTIME,
                       A4.CHECKONE,
                       A5.CHECKTWO,
                       A6.RECEIVETIME,
                       A9.RETURNTIME,
                       A10.REPORTEDTIME
                  FROM (SELECT REPORTTIME,
                               ISURGENT,
                               CUST_NAME,
                               OLD_CUST,
                               ONECATEGORY,
                               LOANCATEGORY,
                               CURRENCY,
                               APPLY_BAL,
                               ORGNAMEONE,
                               EXECUTION_ID AS FLOW_ID,
                               YXRY,
                               YXRYJG,
                               NEXT_OPR_NAME,
                               FDXDY,
                               SURVEY_TIME,
                               APP_WAY,
                               POL_NO,
                               MEETING_COUNT,
                               VOTE_NO,
                               APP_TIME,
                               CON_MATTER,
                               DS_MS_ONE,
                               DS_MS_TWO,
                               DY_APP,
                               DE_APP,
                               HY_ZR_NAME,
                               HY_WY_ONE,
                               SH_ADDR,
                               FX_TYPE,
                               SP_TYPE,
                               YBJ_NUM,
                               HY_SY_JL,
                               PJ_JL,
                               FX_ED,
                               SX_ED,
                               YW_ED,
                               NEXTORGNAME
                          FROM (SELECT LL.*, JJ.EXECUTION_ID
                                  FROM (SELECT T1.EXECUTION_ID
                                          FROM T_PROCESS_CONFIG    T,
                                               T_PROCESS_BUSINESS  T1,
                                               JBPM4_HIST_PROCINST T2
                                         WHERE T.DEFINITION_ID = T2.PROCDEFID_
                                           AND T2.ID_ = T1.EXECUTION_ID
                                           AND T1.BUSINESS_TYPE = '88'
                                           AND T.STATE = '01') JJ
                                  LEFT JOIN (SELECT T.REPORTTIME,
                                                   T.ISURGENT,
                                                   O.CUST_NAME,
                                                   O.OLD_CUST,
                                                   O.ONECATEGORY,
                                                   O.LOANCATEGORY,
                                                   O.CURRENCY,
                                                   TRUNC(O.APPLY_BAL / 10000, 2) AS APPLY_BAL,
                                                   N.ORGNAME AS ORGNAMEONE,
                                                   O.FLOW_ID,
                                                   O.YXRY,
                                                   O.YXRYJG,
                                                   P.EMPNAME AS NEXT_OPR_NAME,
                                                   O.FDXDY,
                                                   O.SURVEY_TIME,
                                                   I.APP_WAY,
                                                   I.POL_NO,
                                                   I.MEETING_COUNT,
                                                   I.VOTE_NO,
                                                   I.APP_TIME,
                                                   I.CON_MATTER,
                                                   I.DS_MS_ONE,
                                                   I.DS_MS_TWO,
                                                   I.DY_APP,
                                                   I.DE_APP,
                                                   I.HY_ZR_NAME,
                                                   I.HY_WY_ONE,
                                                   I.SH_ADDR,
                                                   I.FX_TYPE,
                                                   I.SP_TYPE,
                                                   I.YBJ_NUM,
                                                   I.HY_SY_JL,
                                                   I.PJ_JL,
                                                   I.FX_ED,
                                                   I.SX_ED,
                                                   I.YW_ED,
                                                   O2.NEXTORGNAME
                                              FROM T_GENERALPROCESS_MODELONE O
                                              LEFT JOIN T_GENERALPROCESS_MODELTHREE T
                                                ON O.FLOW_ID = T.FLOW_ID
                                              LEFT JOIN T_GENERALPROCESS_MODELFIVE I
                                                ON O.FLOW_ID = I.FLOW_ID
                                              LEFT JOIN OM_EMPLOYEE P
                                                ON O.CREATOR = P.EMPID
                                              LEFT JOIN OM_ORGANIZATION N
                                                ON N.ORGCODE = O.ORGCODEONE
                                              LEFT JOIN (SELECT O.ORGNAME AS NEXTORGNAME,
                                                               T.FLOW_ID
                                                          FROM T_GENERALPROCESS_MODELONE T,
                                                               OM_ORGANIZATION           O
                                                         WHERE O.ORGCODE =
                                                               T.ORGCODEONE) O2
                                                ON O2.FLOW_ID = O.FLOW_ID） LL ON
                                             JJ.EXECUTION_ID = LL.FLOW_ID)) Z
                          LEFT JOIN (SELECT O.ORGNAME AS ORGNAMETWO, T.FLOW_ID
                                      FROM T_GENERALPROCESS_MODELONE T,
                                           OM_ORGANIZATION           O
                                     WHERE O.ORGCODE = T.ORGCODETWO) O1
                            ON O1.FLOW_ID = Z.FLOW_ID
                          LEFT JOIN (SELECT Q.EXECUTION_,
                                           TO_CHAR(MAX(Q.END_),
                                                   'yyyy-mm-dd hh24:mi:ss ') AS APPROVALTIME
                                      FROM JBPM4_HIST_ACTINST Q
                                     WHERE Q.ACTIVITY_NAME_ = '发起合同预审'
                                     GROUP BY Q.EXECUTION_) A1
                            ON A1.EXECUTION_ = Z.FLOW_ID
                          LEFT JOIN (SELECT T1.EXECUTION_,
                                           (CASE
                                             WHEN T1.CHECKTIME1 IS NULL THEN
                                              T2.CHECKTIME2
                                             ELSE
                                              T1.CHECKTIME1
                                           END) AS CHECKTIME
                                      FROM (SELECT T.EXECUTION_,
                                                   TO_CHAR(MIN(T.END_),
                                                           'yyyy-mm-dd') AS CHECKTIME1
                                              FROM (SELECT *
                                                      FROM JBPM4_HIST_TASK K
                                                     WHERE K.OUTCOME_ = '提交审批一'
                                                     ORDER BY K.EXECUTION_,
                                                              K.END_) T
                                             GROUP BY T.EXECUTION_) T1
                                      LEFT JOIN (SELECT T.EXECUTION_,
                                                       TO_CHAR(MIN(T.END_),
                                                               'yyyy-mm-dd') AS CHECKTIME2
                                                  FROM (SELECT *
                                                          FROM JBPM4_HIST_TASK K
                                                         WHERE K.OUTCOME_ =
                                                               '提交审批安排'
                                                         ORDER BY K.EXECUTION_,
                                                                  K.END_) T
                                                 GROUP BY T.EXECUTION_) T2
                                        ON T1.EXECUTION_ = T2.EXECUTION_) A2
                            ON A2.EXECUTION_ = Z.FLOW_ID
                          LEFT JOIN (SELECT *
                                      FROM (SELECT A.EXECUTION_,
                                                   (CASE
                                                     WHEN T.YQ_APP_TIME IS NULL THEN
                                                      A.REPLYTIME
                                                     ELSE
                                                      TO_CHAR(TO_DATE(T.YQ_APP_TIME,
                                                                      'yyyy/MM/dd hh24:mi:ss'),
                                                              'yyyy-mm-dd hh24:mi:ss')
                                                   END) AS REPLYTIME
                                              FROM T_GENERALPROCESS_MODELFIVE T,
                                                   (SELECT T.OUTCOME_,
                                                           TO_CHAR(Q.END_,
                                                                   'yyyy-mm-dd hh24:mi:ss ') AS REPLYTIME,
                                                           T.EXECUTION_
                                                      FROM JBPM4_HIST_TASK T，JBPM4_HIST_ACTINST Q
                                                     WHERE T.OUTCOME_ =
                                                           '提交发起合同预审'
                                                       AND Q.HTASK_ = T.DBID_) A) A
                                     GROUP BY A.EXECUTION_, A.REPLYTIME) A3
                            ON A3.EXECUTION_ = Z.FLOW_ID
                          LEFT JOIN （SELECT MIN(Q.START_), T.EXECUTION_, O.OPERATORNAME AS CHECKONE
                          FROM JBPM4_HIST_ACTINST Q,
                               JBPM4_HIST_TASK    T,
                               AC_OPERATOR        O
                         WHERE Q.ACTIVITY_NAME_ = '审查一'
                           AND Q.HTASK_ = T.DBID_
                           AND T.ASSIGNEE_ = O.OPERATORID
                         GROUP BY T.EXECUTION_, O.OPERATORNAME) A4
                    ON A4.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT MIN(Q.START_),
                                   T.EXECUTION_,
                                   O.OPERATORNAME AS CHECKTWO
                              FROM JBPM4_HIST_ACTINST Q,
                                   JBPM4_HIST_TASK    T,
                                   AC_OPERATOR        O
                             WHERE Q.ACTIVITY_NAME_ = '审查二'
                               AND Q.HTASK_ = T.DBID_
                               AND T.ASSIGNEE_ = O.OPERATORID
                             GROUP BY T.EXECUTION_, O.OPERATORNAME) A5
                    ON A5.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT A.EXECUTION_, MAX(R) AS RECEIVETIME
                              FROM (SELECT T.EXECUTION_,
                                           WM_CONCAT(TO_CHAR(T.END_,
                                                             'yyyy-mm-dd hh24:mi:ss')) OVER(PARTITION BY T.EXECUTION_ ORDER BY T.END_) R
                                      FROM (SELECT *
                                              FROM JBPM4_HIST_TASK K
                                             WHERE K.OUTCOME_ = '提交审查一'
                                             ORDER BY K.EXECUTION_, K.END_ ASC) T) A
                             GROUP BY A.EXECUTION_) A6
                    ON A6.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT EXECUTION_,
                                   TO_CHAR(MIN(T.START_), 'yyyy-mm-dd') UPTIME
                              FROM JBPM4_HIST_ACTINST T
                             WHERE T.ACTIVITY_NAME_ = '收单派单'
                             GROUP BY T.EXECUTION_) A7
                    ON A7.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT EXECUTION_,
                                   TO_CHAR(MIN(T.START_), 'yyyy-mm-dd') LOOKTIME
                              FROM JBPM4_HIST_ACTINST T
                             WHERE T.ACTIVITY_NAME_ = '发起合同预审'
                             GROUP BY T.EXECUTION_) A8
                    ON A8.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT A.EXECUTION_, MAX(R) AS RETURNTIME
                              FROM (SELECT T.EXECUTION_,
                                           WM_CONCAT(TO_CHAR(T.END_,
                                                             'yyyy-mm-dd hh24:mi:ss')) OVER(PARTITION BY T.EXECUTION_ ORDER BY T.END_) R
                                      FROM (SELECT *
                                              FROM JBPM4_HIST_TASK K
                                             WHERE K.OUTCOME_ = '退回收单派单'
                                             ORDER BY K.EXECUTION_, K.END_ ASC) T) A
                             GROUP BY A.EXECUTION_) A9
                    ON A9.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT A.EXECUTION_, MAX(R) AS REPORTEDTIME
                              FROM (SELECT T.EXECUTION_,
                                           WM_CONCAT(TO_CHAR(T.END_,
                                                             'yyyy-mm-dd hh24:mi:ss')) OVER(PARTITION BY T.EXECUTION_ ORDER BY T.END_) R
                                      FROM (SELECT *
                                              FROM JBPM4_HIST_TASK K
                                             WHERE K.OUTCOME_ = '提交收单派单'
                                             ORDER BY K.EXECUTION_, K.END_ ASC) T) A
                             GROUP BY A.EXECUTION_) A10
                    ON A10.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT MIN(Q.START_),
                                   T.EXECUTION_,
                                   O.OPERATORNAME AS DYAPP1
                              FROM JBPM4_HIST_ACTINST Q,
                                   JBPM4_HIST_TASK    T,
                                   AC_OPERATOR        O
                             WHERE Q.ACTIVITY_NAME_ = '审批一'
                               AND Q.HTASK_ = T.DBID_
                               AND T.ASSIGNEE_ = O.OPERATORID
                             GROUP BY T.EXECUTION_, O.OPERATORNAME) D1
                    ON D1.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN (SELECT MIN(Q.START_),
                                   T.EXECUTION_,
                                   O.OPERATORNAME AS DEAPP1
                              FROM JBPM4_HIST_ACTINST Q,
                                   JBPM4_HIST_TASK    T,
                                   AC_OPERATOR        O
                             WHERE Q.ACTIVITY_NAME_ = '审批二'
                               AND Q.HTASK_ = T.DBID_
                               AND T.ASSIGNEE_ = O.OPERATORID
                             GROUP BY T.EXECUTION_, O.OPERATORNAME) D2
                    ON D2.EXECUTION_ = Z.FLOW_ID
                  LEFT JOIN T_PROCESS_BUSINESS D3
                    ON D3.EXECUTION_ID = Z.FLOW_ID
                 WHERE 1 = 1) Z
         GROUP BY Z.FLOW_ID)   uui   WHERE uui.cust_name  IS  NULL)
