package com.gotop.timeMachine.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class TModelTimedayExample {
    /**
     * 
     * @abatorgenerated
     */
    protected Logger log = Logger.getLogger(TModelTimedayExample.class);

    /**
     * 排序字段.
     * @abatorgenerated
     */
    protected String orderByClause;

    /**
     * sql条件.
     * @abatorgenerated
     */
    protected List oredCriteria;

    /**
     * 分页查询的起始行数.
     * @abatorgenerated
     */
    private Integer oracleStart;

    /**
     * 分页查询结束行数.
     * @abatorgenerated
     */
    private Integer oracleEnd;

    /** * @abatorgenerated  */
    public TModelTimedayExample() {
        oredCriteria = new ArrayList();
    }

    /** * @abatorgenerated  */
    protected TModelTimedayExample(TModelTimedayExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.oracleStart = example.oracleStart;
        this.oracleEnd = example.oracleEnd;
    }

    /** * @abatorgenerated  */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** * @abatorgenerated  */
    /** * @abatorgenerated  */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** * @abatorgenerated  */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /** * @abatorgenerated  */
    public Integer getOracleStart() {
        return oracleStart;
    }

    /** * @abatorgenerated  */
    public void setOracleStart(Integer oracleStart) {
        this.oracleStart = oracleStart;
    }

    /** * @abatorgenerated  */
    public Integer getOracleEnd() {
        return oracleEnd;
    }

    /** * @abatorgenerated  */
    public void setOracleEnd(Integer oracleEnd) {
        this.oracleEnd = oracleEnd;
    }

    /**
     * 增加整个新查询条件(Criteria)，增加后以or方式查询.
     * @abatorgenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 创新新Criteria，如果为第一个则加入到Criteria列表。并且返回
     * @abatorgenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 仅创新新Criteria,并且返回
     * @abatorgenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清除查询条件
     * @abatorgenerated
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Abator for iBATIS.
     * This class corresponds to the database table T_MODEL_TIMEDAY
     *
     * @abatorgenerated 
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List values) {
            addCriterion("ID in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List values) {
            addCriterion("ID not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("TIME is null");
            return this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("TIME is not null");
            return this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("TIME =", value, "time");
            return this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("TIME <>", value, "time");
            return this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("TIME >", value, "time");
            return this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("TIME >=", value, "time");
            return this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("TIME <", value, "time");
            return this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("TIME <=", value, "time");
            return this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("TIME like", value, "time");
            return this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("TIME not like", value, "time");
            return this;
        }

        public Criteria andTimeIn(List values) {
            addCriterion("TIME in", values, "time");
            return this;
        }

        public Criteria andTimeNotIn(List values) {
            addCriterion("TIME not in", values, "time");
            return this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("TIME between", value1, value2, "time");
            return this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("TIME not between", value1, value2, "time");
            return this;
        }

        public Criteria andOrgcodeIsNull() {
            addCriterion("ORGCODE is null");
            return this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("ORGCODE is not null");
            return this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("ORGCODE =", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("ORGCODE <>", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("ORGCODE >", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGCODE >=", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("ORGCODE <", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("ORGCODE <=", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("ORGCODE like", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("ORGCODE not like", value, "orgcode");
            return this;
        }

        public Criteria andOrgcodeIn(List values) {
            addCriterion("ORGCODE in", values, "orgcode");
            return this;
        }

        public Criteria andOrgcodeNotIn(List values) {
            addCriterion("ORGCODE not in", values, "orgcode");
            return this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("ORGCODE between", value1, value2, "orgcode");
            return this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("ORGCODE not between", value1, value2, "orgcode");
            return this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("ROLE is null");
            return this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("ROLE is not null");
            return this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("ROLE =", value, "role");
            return this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("ROLE <>", value, "role");
            return this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("ROLE >", value, "role");
            return this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE >=", value, "role");
            return this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("ROLE <", value, "role");
            return this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("ROLE <=", value, "role");
            return this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("ROLE like", value, "role");
            return this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("ROLE not like", value, "role");
            return this;
        }

        public Criteria andRoleIn(List values) {
            addCriterion("ROLE in", values, "role");
            return this;
        }

        public Criteria andRoleNotIn(List values) {
            addCriterion("ROLE not in", values, "role");
            return this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("ROLE between", value1, value2, "role");
            return this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("ROLE not between", value1, value2, "role");
            return this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return this;
        }

        public Criteria andStatusIn(List values) {
            addCriterion("STATUS in", values, "status");
            return this;
        }

        public Criteria andStatusNotIn(List values) {
            addCriterion("STATUS not in", values, "status");
            return this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return this;
        }
    }
}