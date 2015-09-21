package com.aidai.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer mysqlOffset;

    private Integer mysqlLength;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    protected UserExample(UserExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
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

    public void setMysqlOffset(Integer mysqlOffset) {
        this.mysqlOffset = mysqlOffset;
    }

    public Integer getMysqlOffset() {
        return mysqlOffset;
    }

    public void setMysqlLength(Integer mysqlLength) {
        this.mysqlLength = mysqlLength;
    }

    public Integer getMysqlLength() {
        return mysqlLength;
    }

    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public void setCriteriaWithoutValue(List<String> criteriaWithoutValue) {
            this.criteriaWithoutValue = criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public void setCriteriaWithSingleValue(List<Map<String, Object>> criteriaWithSingleValue) {
            this.criteriaWithSingleValue = criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public void setCriteriaWithListValue(List<Map<String, Object>> criteriaWithListValue) {
            this.criteriaWithListValue = criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        public void setCriteriaWithBetweenValue(List<Map<String, Object>> criteriaWithBetweenValue) {
            this.criteriaWithBetweenValue = criteriaWithBetweenValue;
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
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNull() {
            addCriterion("user_code is null");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNotNull() {
            addCriterion("user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserCodeEqualTo(String value) {
            addCriterion("user_code =", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotEqualTo(String value) {
            addCriterion("user_code <>", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThan(String value) {
            addCriterion("user_code >", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_code >=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThan(String value) {
            addCriterion("user_code <", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("user_code <=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLike(String value) {
            addCriterion("user_code like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotLike(String value) {
            addCriterion("user_code not like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeIn(List<String> values) {
            addCriterion("user_code in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotIn(List<String> values) {
            addCriterion("user_code not in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeBetween(String value1, String value2) {
            addCriterion("user_code between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("user_code not between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("user_mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("user_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("user_mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("user_mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("user_mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("user_mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("user_mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("user_mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("user_mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("user_mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("user_mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("user_mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("user_mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("user_mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andBadminIsNull() {
            addCriterion("badmin is null");
            return (Criteria) this;
        }

        public Criteria andBadminIsNotNull() {
            addCriterion("badmin is not null");
            return (Criteria) this;
        }

        public Criteria andBadminEqualTo(Integer value) {
            addCriterion("badmin =", value, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminNotEqualTo(Integer value) {
            addCriterion("badmin <>", value, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminGreaterThan(Integer value) {
            addCriterion("badmin >", value, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminGreaterThanOrEqualTo(Integer value) {
            addCriterion("badmin >=", value, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminLessThan(Integer value) {
            addCriterion("badmin <", value, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminLessThanOrEqualTo(Integer value) {
            addCriterion("badmin <=", value, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminIn(List<Integer> values) {
            addCriterion("badmin in", values, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminNotIn(List<Integer> values) {
            addCriterion("badmin not in", values, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminBetween(Integer value1, Integer value2) {
            addCriterion("badmin between", value1, value2, "badmin");
            return (Criteria) this;
        }

        public Criteria andBadminNotBetween(Integer value1, Integer value2) {
            addCriterion("badmin not between", value1, value2, "badmin");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeIsNull() {
            addCriterion("introducer_type is null");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeIsNotNull() {
            addCriterion("introducer_type is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeEqualTo(String value) {
            addCriterion("introducer_type =", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeNotEqualTo(String value) {
            addCriterion("introducer_type <>", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeGreaterThan(String value) {
            addCriterion("introducer_type >", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("introducer_type >=", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeLessThan(String value) {
            addCriterion("introducer_type <", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeLessThanOrEqualTo(String value) {
            addCriterion("introducer_type <=", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeLike(String value) {
            addCriterion("introducer_type like", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeNotLike(String value) {
            addCriterion("introducer_type not like", value, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeIn(List<String> values) {
            addCriterion("introducer_type in", values, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeNotIn(List<String> values) {
            addCriterion("introducer_type not in", values, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeBetween(String value1, String value2) {
            addCriterion("introducer_type between", value1, value2, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerTypeNotBetween(String value1, String value2) {
            addCriterion("introducer_type not between", value1, value2, "introducerType");
            return (Criteria) this;
        }

        public Criteria andIntroducerIsNull() {
            addCriterion("introducer is null");
            return (Criteria) this;
        }

        public Criteria andIntroducerIsNotNull() {
            addCriterion("introducer is not null");
            return (Criteria) this;
        }

        public Criteria andIntroducerEqualTo(String value) {
            addCriterion("introducer =", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotEqualTo(String value) {
            addCriterion("introducer <>", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerGreaterThan(String value) {
            addCriterion("introducer >", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerGreaterThanOrEqualTo(String value) {
            addCriterion("introducer >=", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerLessThan(String value) {
            addCriterion("introducer <", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerLessThanOrEqualTo(String value) {
            addCriterion("introducer <=", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerLike(String value) {
            addCriterion("introducer like", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotLike(String value) {
            addCriterion("introducer not like", value, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerIn(List<String> values) {
            addCriterion("introducer in", values, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotIn(List<String> values) {
            addCriterion("introducer not in", values, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerBetween(String value1, String value2) {
            addCriterion("introducer between", value1, value2, "introducer");
            return (Criteria) this;
        }

        public Criteria andIntroducerNotBetween(String value1, String value2) {
            addCriterion("introducer not between", value1, value2, "introducer");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsIsNull() {
            addCriterion("total_assets is null");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsIsNotNull() {
            addCriterion("total_assets is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsEqualTo(String value) {
            addCriterion("total_assets =", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsNotEqualTo(String value) {
            addCriterion("total_assets <>", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsGreaterThan(String value) {
            addCriterion("total_assets >", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsGreaterThanOrEqualTo(String value) {
            addCriterion("total_assets >=", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsLessThan(String value) {
            addCriterion("total_assets <", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsLessThanOrEqualTo(String value) {
            addCriterion("total_assets <=", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsLike(String value) {
            addCriterion("total_assets like", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsNotLike(String value) {
            addCriterion("total_assets not like", value, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsIn(List<String> values) {
            addCriterion("total_assets in", values, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsNotIn(List<String> values) {
            addCriterion("total_assets not in", values, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsBetween(String value1, String value2) {
            addCriterion("total_assets between", value1, value2, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andTotalAssetsNotBetween(String value1, String value2) {
            addCriterion("total_assets not between", value1, value2, "totalAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsIsNull() {
            addCriterion("freeze_assets is null");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsIsNotNull() {
            addCriterion("freeze_assets is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsEqualTo(String value) {
            addCriterion("freeze_assets =", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsNotEqualTo(String value) {
            addCriterion("freeze_assets <>", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsGreaterThan(String value) {
            addCriterion("freeze_assets >", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsGreaterThanOrEqualTo(String value) {
            addCriterion("freeze_assets >=", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsLessThan(String value) {
            addCriterion("freeze_assets <", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsLessThanOrEqualTo(String value) {
            addCriterion("freeze_assets <=", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsLike(String value) {
            addCriterion("freeze_assets like", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsNotLike(String value) {
            addCriterion("freeze_assets not like", value, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsIn(List<String> values) {
            addCriterion("freeze_assets in", values, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsNotIn(List<String> values) {
            addCriterion("freeze_assets not in", values, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsBetween(String value1, String value2) {
            addCriterion("freeze_assets between", value1, value2, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andFreezeAssetsNotBetween(String value1, String value2) {
            addCriterion("freeze_assets not between", value1, value2, "freezeAssets");
            return (Criteria) this;
        }

        public Criteria andPureAssertsIsNull() {
            addCriterion("pure_asserts is null");
            return (Criteria) this;
        }

        public Criteria andPureAssertsIsNotNull() {
            addCriterion("pure_asserts is not null");
            return (Criteria) this;
        }

        public Criteria andPureAssertsEqualTo(String value) {
            addCriterion("pure_asserts =", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsNotEqualTo(String value) {
            addCriterion("pure_asserts <>", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsGreaterThan(String value) {
            addCriterion("pure_asserts >", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsGreaterThanOrEqualTo(String value) {
            addCriterion("pure_asserts >=", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsLessThan(String value) {
            addCriterion("pure_asserts <", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsLessThanOrEqualTo(String value) {
            addCriterion("pure_asserts <=", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsLike(String value) {
            addCriterion("pure_asserts like", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsNotLike(String value) {
            addCriterion("pure_asserts not like", value, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsIn(List<String> values) {
            addCriterion("pure_asserts in", values, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsNotIn(List<String> values) {
            addCriterion("pure_asserts not in", values, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsBetween(String value1, String value2) {
            addCriterion("pure_asserts between", value1, value2, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andPureAssertsNotBetween(String value1, String value2) {
            addCriterion("pure_asserts not between", value1, value2, "pureAsserts");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(String value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(String value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(String value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(String value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(String value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(String value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLike(String value) {
            addCriterion("interest like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotLike(String value) {
            addCriterion("interest not like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<String> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<String> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(String value1, String value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(String value1, String value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(String value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(String value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(String value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(String value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(String value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(String value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLike(String value) {
            addCriterion("balance like", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotLike(String value) {
            addCriterion("balance not like", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<String> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<String> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(String value1, String value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(String value1, String value2) {
            addCriterion("balance not between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNull() {
            addCriterion("user_level is null");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNotNull() {
            addCriterion("user_level is not null");
            return (Criteria) this;
        }

        public Criteria andUserLevelEqualTo(Integer value) {
            addCriterion("user_level =", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotEqualTo(Integer value) {
            addCriterion("user_level <>", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThan(Integer value) {
            addCriterion("user_level >", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_level >=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThan(Integer value) {
            addCriterion("user_level <", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThanOrEqualTo(Integer value) {
            addCriterion("user_level <=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelIn(List<Integer> values) {
            addCriterion("user_level in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotIn(List<Integer> values) {
            addCriterion("user_level not in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelBetween(Integer value1, Integer value2) {
            addCriterion("user_level between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("user_level not between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNull() {
            addCriterion("pay_password is null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNotNull() {
            addCriterion("pay_password is not null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordEqualTo(String value) {
            addCriterion("pay_password =", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotEqualTo(String value) {
            addCriterion("pay_password <>", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThan(String value) {
            addCriterion("pay_password >", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("pay_password >=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThan(String value) {
            addCriterion("pay_password <", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThanOrEqualTo(String value) {
            addCriterion("pay_password <=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLike(String value) {
            addCriterion("pay_password like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotLike(String value) {
            addCriterion("pay_password not like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIn(List<String> values) {
            addCriterion("pay_password in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotIn(List<String> values) {
            addCriterion("pay_password not in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordBetween(String value1, String value2) {
            addCriterion("pay_password between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotBetween(String value1, String value2) {
            addCriterion("pay_password not between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNull() {
            addCriterion("bank_card_no is null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIsNotNull() {
            addCriterion("bank_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankCardNoEqualTo(String value) {
            addCriterion("bank_card_no =", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotEqualTo(String value) {
            addCriterion("bank_card_no <>", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThan(String value) {
            addCriterion("bank_card_no >", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_card_no >=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThan(String value) {
            addCriterion("bank_card_no <", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLessThanOrEqualTo(String value) {
            addCriterion("bank_card_no <=", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoLike(String value) {
            addCriterion("bank_card_no like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotLike(String value) {
            addCriterion("bank_card_no not like", value, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoIn(List<String> values) {
            addCriterion("bank_card_no in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotIn(List<String> values) {
            addCriterion("bank_card_no not in", values, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoBetween(String value1, String value2) {
            addCriterion("bank_card_no between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andBankCardNoNotBetween(String value1, String value2) {
            addCriterion("bank_card_no not between", value1, value2, "bankCardNo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andBsingleIsNull() {
            addCriterion("bsingle is null");
            return (Criteria) this;
        }

        public Criteria andBsingleIsNotNull() {
            addCriterion("bsingle is not null");
            return (Criteria) this;
        }

        public Criteria andBsingleEqualTo(Integer value) {
            addCriterion("bsingle =", value, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleNotEqualTo(Integer value) {
            addCriterion("bsingle <>", value, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleGreaterThan(Integer value) {
            addCriterion("bsingle >", value, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleGreaterThanOrEqualTo(Integer value) {
            addCriterion("bsingle >=", value, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleLessThan(Integer value) {
            addCriterion("bsingle <", value, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleLessThanOrEqualTo(Integer value) {
            addCriterion("bsingle <=", value, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleIn(List<Integer> values) {
            addCriterion("bsingle in", values, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleNotIn(List<Integer> values) {
            addCriterion("bsingle not in", values, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleBetween(Integer value1, Integer value2) {
            addCriterion("bsingle between", value1, value2, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBsingleNotBetween(Integer value1, Integer value2) {
            addCriterion("bsingle not between", value1, value2, "bsingle");
            return (Criteria) this;
        }

        public Criteria andBdeleteIsNull() {
            addCriterion("bdelete is null");
            return (Criteria) this;
        }

        public Criteria andBdeleteIsNotNull() {
            addCriterion("bdelete is not null");
            return (Criteria) this;
        }

        public Criteria andBdeleteEqualTo(Integer value) {
            addCriterion("bdelete =", value, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteNotEqualTo(Integer value) {
            addCriterion("bdelete <>", value, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteGreaterThan(Integer value) {
            addCriterion("bdelete >", value, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("bdelete >=", value, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteLessThan(Integer value) {
            addCriterion("bdelete <", value, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("bdelete <=", value, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteIn(List<Integer> values) {
            addCriterion("bdelete in", values, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteNotIn(List<Integer> values) {
            addCriterion("bdelete not in", values, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteBetween(Integer value1, Integer value2) {
            addCriterion("bdelete between", value1, value2, "bdelete");
            return (Criteria) this;
        }

        public Criteria andBdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("bdelete not between", value1, value2, "bdelete");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIsNull() {
            addCriterion("modify_datetime is null");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIsNotNull() {
            addCriterion("modify_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeEqualTo(Date value) {
            addCriterion("modify_datetime =", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotEqualTo(Date value) {
            addCriterion("modify_datetime <>", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeGreaterThan(Date value) {
            addCriterion("modify_datetime >", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_datetime >=", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeLessThan(Date value) {
            addCriterion("modify_datetime <", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_datetime <=", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIn(List<Date> values) {
            addCriterion("modify_datetime in", values, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotIn(List<Date> values) {
            addCriterion("modify_datetime not in", values, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeBetween(Date value1, Date value2) {
            addCriterion("modify_datetime between", value1, value2, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_datetime not between", value1, value2, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNull() {
            addCriterion("modify_user is null");
            return (Criteria) this;
        }

        public Criteria andModifyUserIsNotNull() {
            addCriterion("modify_user is not null");
            return (Criteria) this;
        }

        public Criteria andModifyUserEqualTo(String value) {
            addCriterion("modify_user =", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotEqualTo(String value) {
            addCriterion("modify_user <>", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThan(String value) {
            addCriterion("modify_user >", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserGreaterThanOrEqualTo(String value) {
            addCriterion("modify_user >=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThan(String value) {
            addCriterion("modify_user <", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLessThanOrEqualTo(String value) {
            addCriterion("modify_user <=", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserLike(String value) {
            addCriterion("modify_user like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotLike(String value) {
            addCriterion("modify_user not like", value, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserIn(List<String> values) {
            addCriterion("modify_user in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotIn(List<String> values) {
            addCriterion("modify_user not in", values, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserBetween(String value1, String value2) {
            addCriterion("modify_user between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andModifyUserNotBetween(String value1, String value2) {
            addCriterion("modify_user not between", value1, value2, "modifyUser");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralIsNull() {
            addCriterion("total_integral is null");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralIsNotNull() {
            addCriterion("total_integral is not null");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralEqualTo(String value) {
            addCriterion("total_integral =", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralNotEqualTo(String value) {
            addCriterion("total_integral <>", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralGreaterThan(String value) {
            addCriterion("total_integral >", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralGreaterThanOrEqualTo(String value) {
            addCriterion("total_integral >=", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralLessThan(String value) {
            addCriterion("total_integral <", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralLessThanOrEqualTo(String value) {
            addCriterion("total_integral <=", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralLike(String value) {
            addCriterion("total_integral like", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralNotLike(String value) {
            addCriterion("total_integral not like", value, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralIn(List<String> values) {
            addCriterion("total_integral in", values, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralNotIn(List<String> values) {
            addCriterion("total_integral not in", values, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralBetween(String value1, String value2) {
            addCriterion("total_integral between", value1, value2, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andTotalIntegralNotBetween(String value1, String value2) {
            addCriterion("total_integral not between", value1, value2, "totalIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralIsNull() {
            addCriterion("current_integral is null");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralIsNotNull() {
            addCriterion("current_integral is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralEqualTo(String value) {
            addCriterion("current_integral =", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralNotEqualTo(String value) {
            addCriterion("current_integral <>", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralGreaterThan(String value) {
            addCriterion("current_integral >", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralGreaterThanOrEqualTo(String value) {
            addCriterion("current_integral >=", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralLessThan(String value) {
            addCriterion("current_integral <", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralLessThanOrEqualTo(String value) {
            addCriterion("current_integral <=", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralLike(String value) {
            addCriterion("current_integral like", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralNotLike(String value) {
            addCriterion("current_integral not like", value, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralIn(List<String> values) {
            addCriterion("current_integral in", values, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralNotIn(List<String> values) {
            addCriterion("current_integral not in", values, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralBetween(String value1, String value2) {
            addCriterion("current_integral between", value1, value2, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andCurrentIntegralNotBetween(String value1, String value2) {
            addCriterion("current_integral not between", value1, value2, "currentIntegral");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsIsNull() {
            addCriterion("waitting_received_assets is null");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsIsNotNull() {
            addCriterion("waitting_received_assets is not null");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsEqualTo(String value) {
            addCriterion("waitting_received_assets =", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsNotEqualTo(String value) {
            addCriterion("waitting_received_assets <>", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsGreaterThan(String value) {
            addCriterion("waitting_received_assets >", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsGreaterThanOrEqualTo(String value) {
            addCriterion("waitting_received_assets >=", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsLessThan(String value) {
            addCriterion("waitting_received_assets <", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsLessThanOrEqualTo(String value) {
            addCriterion("waitting_received_assets <=", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsLike(String value) {
            addCriterion("waitting_received_assets like", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsNotLike(String value) {
            addCriterion("waitting_received_assets not like", value, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsIn(List<String> values) {
            addCriterion("waitting_received_assets in", values, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsNotIn(List<String> values) {
            addCriterion("waitting_received_assets not in", values, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsBetween(String value1, String value2) {
            addCriterion("waitting_received_assets between", value1, value2, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedAssetsNotBetween(String value1, String value2) {
            addCriterion("waitting_received_assets not between", value1, value2, "waittingReceivedAssets");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsIsNull() {
            addCriterion("last_received_asserts is null");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsIsNotNull() {
            addCriterion("last_received_asserts is not null");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsEqualTo(String value) {
            addCriterion("last_received_asserts =", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsNotEqualTo(String value) {
            addCriterion("last_received_asserts <>", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsGreaterThan(String value) {
            addCriterion("last_received_asserts >", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsGreaterThanOrEqualTo(String value) {
            addCriterion("last_received_asserts >=", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsLessThan(String value) {
            addCriterion("last_received_asserts <", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsLessThanOrEqualTo(String value) {
            addCriterion("last_received_asserts <=", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsLike(String value) {
            addCriterion("last_received_asserts like", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsNotLike(String value) {
            addCriterion("last_received_asserts not like", value, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsIn(List<String> values) {
            addCriterion("last_received_asserts in", values, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsNotIn(List<String> values) {
            addCriterion("last_received_asserts not in", values, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsBetween(String value1, String value2) {
            addCriterion("last_received_asserts between", value1, value2, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastReceivedAssertsNotBetween(String value1, String value2) {
            addCriterion("last_received_asserts not between", value1, value2, "lastReceivedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestIsNull() {
            addCriterion("waitting_received_interest is null");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestIsNotNull() {
            addCriterion("waitting_received_interest is not null");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestEqualTo(String value) {
            addCriterion("waitting_received_interest =", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestNotEqualTo(String value) {
            addCriterion("waitting_received_interest <>", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestGreaterThan(String value) {
            addCriterion("waitting_received_interest >", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestGreaterThanOrEqualTo(String value) {
            addCriterion("waitting_received_interest >=", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestLessThan(String value) {
            addCriterion("waitting_received_interest <", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestLessThanOrEqualTo(String value) {
            addCriterion("waitting_received_interest <=", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestLike(String value) {
            addCriterion("waitting_received_interest like", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestNotLike(String value) {
            addCriterion("waitting_received_interest not like", value, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestIn(List<String> values) {
            addCriterion("waitting_received_interest in", values, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestNotIn(List<String> values) {
            addCriterion("waitting_received_interest not in", values, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestBetween(String value1, String value2) {
            addCriterion("waitting_received_interest between", value1, value2, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andWaittingReceivedInterestNotBetween(String value1, String value2) {
            addCriterion("waitting_received_interest not between", value1, value2, "waittingReceivedInterest");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeIsNull() {
            addCriterion("last_waitting_received_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeIsNotNull() {
            addCriterion("last_waitting_received_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeEqualTo(Date value) {
            addCriterion("last_waitting_received_datetime =", value, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeNotEqualTo(Date value) {
            addCriterion("last_waitting_received_datetime <>", value, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeGreaterThan(Date value) {
            addCriterion("last_waitting_received_datetime >", value, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_waitting_received_datetime >=", value, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeLessThan(Date value) {
            addCriterion("last_waitting_received_datetime <", value, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("last_waitting_received_datetime <=", value, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeIn(List<Date> values) {
            addCriterion("last_waitting_received_datetime in", values, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeNotIn(List<Date> values) {
            addCriterion("last_waitting_received_datetime not in", values, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeBetween(Date value1, Date value2) {
            addCriterion("last_waitting_received_datetime between", value1, value2, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingReceivedDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("last_waitting_received_datetime not between", value1, value2, "lastWaittingReceivedDatetime");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsIsNull() {
            addCriterion("waitting_earned_awards is null");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsIsNotNull() {
            addCriterion("waitting_earned_awards is not null");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsEqualTo(String value) {
            addCriterion("waitting_earned_awards =", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsNotEqualTo(String value) {
            addCriterion("waitting_earned_awards <>", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsGreaterThan(String value) {
            addCriterion("waitting_earned_awards >", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsGreaterThanOrEqualTo(String value) {
            addCriterion("waitting_earned_awards >=", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsLessThan(String value) {
            addCriterion("waitting_earned_awards <", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsLessThanOrEqualTo(String value) {
            addCriterion("waitting_earned_awards <=", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsLike(String value) {
            addCriterion("waitting_earned_awards like", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsNotLike(String value) {
            addCriterion("waitting_earned_awards not like", value, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsIn(List<String> values) {
            addCriterion("waitting_earned_awards in", values, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsNotIn(List<String> values) {
            addCriterion("waitting_earned_awards not in", values, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsBetween(String value1, String value2) {
            addCriterion("waitting_earned_awards between", value1, value2, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andWaittingEarnedAwardsNotBetween(String value1, String value2) {
            addCriterion("waitting_earned_awards not between", value1, value2, "waittingEarnedAwards");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsIsNull() {
            addCriterion("total_borrowed_asserts is null");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsIsNotNull() {
            addCriterion("total_borrowed_asserts is not null");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsEqualTo(String value) {
            addCriterion("total_borrowed_asserts =", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsNotEqualTo(String value) {
            addCriterion("total_borrowed_asserts <>", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsGreaterThan(String value) {
            addCriterion("total_borrowed_asserts >", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsGreaterThanOrEqualTo(String value) {
            addCriterion("total_borrowed_asserts >=", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsLessThan(String value) {
            addCriterion("total_borrowed_asserts <", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsLessThanOrEqualTo(String value) {
            addCriterion("total_borrowed_asserts <=", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsLike(String value) {
            addCriterion("total_borrowed_asserts like", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsNotLike(String value) {
            addCriterion("total_borrowed_asserts not like", value, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsIn(List<String> values) {
            addCriterion("total_borrowed_asserts in", values, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsNotIn(List<String> values) {
            addCriterion("total_borrowed_asserts not in", values, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsBetween(String value1, String value2) {
            addCriterion("total_borrowed_asserts between", value1, value2, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andTotalBorrowedAssertsNotBetween(String value1, String value2) {
            addCriterion("total_borrowed_asserts not between", value1, value2, "totalBorrowedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsIsNull() {
            addCriterion("waittting_payed_asserts is null");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsIsNotNull() {
            addCriterion("waittting_payed_asserts is not null");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsEqualTo(String value) {
            addCriterion("waittting_payed_asserts =", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsNotEqualTo(String value) {
            addCriterion("waittting_payed_asserts <>", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsGreaterThan(String value) {
            addCriterion("waittting_payed_asserts >", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsGreaterThanOrEqualTo(String value) {
            addCriterion("waittting_payed_asserts >=", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsLessThan(String value) {
            addCriterion("waittting_payed_asserts <", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsLessThanOrEqualTo(String value) {
            addCriterion("waittting_payed_asserts <=", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsLike(String value) {
            addCriterion("waittting_payed_asserts like", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsNotLike(String value) {
            addCriterion("waittting_payed_asserts not like", value, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsIn(List<String> values) {
            addCriterion("waittting_payed_asserts in", values, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsNotIn(List<String> values) {
            addCriterion("waittting_payed_asserts not in", values, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsBetween(String value1, String value2) {
            addCriterion("waittting_payed_asserts between", value1, value2, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andWaitttingPayedAssertsNotBetween(String value1, String value2) {
            addCriterion("waittting_payed_asserts not between", value1, value2, "waitttingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsIsNull() {
            addCriterion("last_waitting_payed_asserts is null");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsIsNotNull() {
            addCriterion("last_waitting_payed_asserts is not null");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsEqualTo(String value) {
            addCriterion("last_waitting_payed_asserts =", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsNotEqualTo(String value) {
            addCriterion("last_waitting_payed_asserts <>", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsGreaterThan(String value) {
            addCriterion("last_waitting_payed_asserts >", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsGreaterThanOrEqualTo(String value) {
            addCriterion("last_waitting_payed_asserts >=", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsLessThan(String value) {
            addCriterion("last_waitting_payed_asserts <", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsLessThanOrEqualTo(String value) {
            addCriterion("last_waitting_payed_asserts <=", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsLike(String value) {
            addCriterion("last_waitting_payed_asserts like", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsNotLike(String value) {
            addCriterion("last_waitting_payed_asserts not like", value, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsIn(List<String> values) {
            addCriterion("last_waitting_payed_asserts in", values, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsNotIn(List<String> values) {
            addCriterion("last_waitting_payed_asserts not in", values, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsBetween(String value1, String value2) {
            addCriterion("last_waitting_payed_asserts between", value1, value2, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedAssertsNotBetween(String value1, String value2) {
            addCriterion("last_waitting_payed_asserts not between", value1, value2, "lastWaittingPayedAsserts");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeIsNull() {
            addCriterion("last_waitting_payed_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeIsNotNull() {
            addCriterion("last_waitting_payed_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeEqualTo(Date value) {
            addCriterion("last_waitting_payed_datetime =", value, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeNotEqualTo(Date value) {
            addCriterion("last_waitting_payed_datetime <>", value, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeGreaterThan(Date value) {
            addCriterion("last_waitting_payed_datetime >", value, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_waitting_payed_datetime >=", value, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeLessThan(Date value) {
            addCriterion("last_waitting_payed_datetime <", value, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("last_waitting_payed_datetime <=", value, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeIn(List<Date> values) {
            addCriterion("last_waitting_payed_datetime in", values, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeNotIn(List<Date> values) {
            addCriterion("last_waitting_payed_datetime not in", values, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeBetween(Date value1, Date value2) {
            addCriterion("last_waitting_payed_datetime between", value1, value2, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }

        public Criteria andLastWaittingPayedDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("last_waitting_payed_datetime not between", value1, value2, "lastWaittingPayedDatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}