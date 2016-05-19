insert into t_model_oneandloancategory  (onecategory_name,onecategory_id,loancategory_name,loancategory_id ) 


SELECT  kk.one  AS onecategory_name  ,kk.oneid  AS  onecategory_id,kk.two  AS loancategory_name,kk.twoid AS  loancategory_id  FROM   (

SELECT YY.*, TT.DICTID AS  twoid
  FROM (
        
        SELECT UU.ONE, OO.DICTID AS ONEID, UU.TWO
          FROM (
                 
                 SELECT T.FIRST_CLASS AS ONE, T.CREDIT_TYPE AS TWO
                   FROM T_GENERALPROCESS_CDTYPE T
                  GROUP BY T.FIRST_CLASS, T.CREDIT_TYPE) UU
          LEFT JOIN (
                     
                     SELECT T.DICTID, T.DICTNAME
                       FROM EOS_DICT_ENTRY T
                      WHERE T.DICTTYPEID = 'PROCESS_onecategory'
                     
                     ) OO
            ON UU.ONE = OO.DICTNAME) YY

  LEFT JOIN (
             
             SELECT T.DICTID, T.DICTNAME
               FROM EOS_DICT_ENTRY T
              WHERE T.DICTTYPEID = 'PROCESS_credit_type'
             
             ) TT
             
                 ON YY.TWO = TT.DICTNAME )  kk  WHERE kk.oneid  IS NOT  NULL  AND   kk.twoid  IS NOT  NULL
             

    ;
    
    
    
    


create trigger tib_t_model_oneandloancategory before insert
on t_model_oneandloancategory for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "Activity_id" uses sequence 11111111111222233333333333
    select t_model_oneandloancategory_seq.NEXTVAL INTO :new.d_id from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/

    
   drop trigger tib_t_model_oneandloancategory  
    
    
    
    