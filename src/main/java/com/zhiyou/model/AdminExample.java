package com.zhiyou.model;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAccountsIsNull() {
            addCriterion("accounts is null");
            return (Criteria) this;
        }

        public Criteria andAccountsIsNotNull() {
            addCriterion("accounts is not null");
            return (Criteria) this;
        }

        public Criteria andAccountsEqualTo(String value) {
            addCriterion("accounts =", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotEqualTo(String value) {
            addCriterion("accounts <>", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsGreaterThan(String value) {
            addCriterion("accounts >", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsGreaterThanOrEqualTo(String value) {
            addCriterion("accounts >=", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsLessThan(String value) {
            addCriterion("accounts <", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsLessThanOrEqualTo(String value) {
            addCriterion("accounts <=", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsLike(String value) {
            addCriterion("accounts like", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotLike(String value) {
            addCriterion("accounts not like", value, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsIn(List<String> values) {
            addCriterion("accounts in", values, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotIn(List<String> values) {
            addCriterion("accounts not in", values, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsBetween(String value1, String value2) {
            addCriterion("accounts between", value1, value2, "accounts");
            return (Criteria) this;
        }

        public Criteria andAccountsNotBetween(String value1, String value2) {
            addCriterion("accounts not between", value1, value2, "accounts");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkIsNull() {
            addCriterion("admin_remark is null");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkIsNotNull() {
            addCriterion("admin_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkEqualTo(String value) {
            addCriterion("admin_remark =", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkNotEqualTo(String value) {
            addCriterion("admin_remark <>", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkGreaterThan(String value) {
            addCriterion("admin_remark >", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("admin_remark >=", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkLessThan(String value) {
            addCriterion("admin_remark <", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkLessThanOrEqualTo(String value) {
            addCriterion("admin_remark <=", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkLike(String value) {
            addCriterion("admin_remark like", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkNotLike(String value) {
            addCriterion("admin_remark not like", value, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkIn(List<String> values) {
            addCriterion("admin_remark in", values, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkNotIn(List<String> values) {
            addCriterion("admin_remark not in", values, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkBetween(String value1, String value2) {
            addCriterion("admin_remark between", value1, value2, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminRemarkNotBetween(String value1, String value2) {
            addCriterion("admin_remark not between", value1, value2, "adminRemark");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperIsNull() {
            addCriterion("admin_is_super is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperIsNotNull() {
            addCriterion("admin_is_super is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperEqualTo(Integer value) {
            addCriterion("admin_is_super =", value, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperNotEqualTo(Integer value) {
            addCriterion("admin_is_super <>", value, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperGreaterThan(Integer value) {
            addCriterion("admin_is_super >", value, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_is_super >=", value, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperLessThan(Integer value) {
            addCriterion("admin_is_super <", value, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperLessThanOrEqualTo(Integer value) {
            addCriterion("admin_is_super <=", value, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperIn(List<Integer> values) {
            addCriterion("admin_is_super in", values, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperNotIn(List<Integer> values) {
            addCriterion("admin_is_super not in", values, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperBetween(Integer value1, Integer value2) {
            addCriterion("admin_is_super between", value1, value2, "adminIsSuper");
            return (Criteria) this;
        }

        public Criteria andAdminIsSuperNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_is_super not between", value1, value2, "adminIsSuper");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}