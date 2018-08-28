package com.cjq.accounts.entity;

import com.cjq.publics.entity.Page;

import java.util.ArrayList;
import java.util.List;

public class SettleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public SettleExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMonthDateIsNull() {
            addCriterion("month_date is null");
            return (Criteria) this;
        }

        public Criteria andMonthDateIsNotNull() {
            addCriterion("month_date is not null");
            return (Criteria) this;
        }

        public Criteria andMonthDateEqualTo(String value) {
            addCriterion("month_date =", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateNotEqualTo(String value) {
            addCriterion("month_date <>", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateGreaterThan(String value) {
            addCriterion("month_date >", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateGreaterThanOrEqualTo(String value) {
            addCriterion("month_date >=", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateLessThan(String value) {
            addCriterion("month_date <", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateLessThanOrEqualTo(String value) {
            addCriterion("month_date <=", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateLike(String value) {
            addCriterion("month_date like", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateNotLike(String value) {
            addCriterion("month_date not like", value, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateIn(List<String> values) {
            addCriterion("month_date in", values, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateNotIn(List<String> values) {
            addCriterion("month_date not in", values, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateBetween(String value1, String value2) {
            addCriterion("month_date between", value1, value2, "monthDate");
            return (Criteria) this;
        }

        public Criteria andMonthDateNotBetween(String value1, String value2) {
            addCriterion("month_date not between", value1, value2, "monthDate");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFoodSumIsNull() {
            addCriterion("food_sum is null");
            return (Criteria) this;
        }

        public Criteria andFoodSumIsNotNull() {
            addCriterion("food_sum is not null");
            return (Criteria) this;
        }

        public Criteria andFoodSumEqualTo(Float value) {
            addCriterion("food_sum =", value, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumNotEqualTo(Float value) {
            addCriterion("food_sum <>", value, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumGreaterThan(Float value) {
            addCriterion("food_sum >", value, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumGreaterThanOrEqualTo(Float value) {
            addCriterion("food_sum >=", value, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumLessThan(Float value) {
            addCriterion("food_sum <", value, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumLessThanOrEqualTo(Float value) {
            addCriterion("food_sum <=", value, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumIn(List<Float> values) {
            addCriterion("food_sum in", values, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumNotIn(List<Float> values) {
            addCriterion("food_sum not in", values, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumBetween(Float value1, Float value2) {
            addCriterion("food_sum between", value1, value2, "foodSum");
            return (Criteria) this;
        }

        public Criteria andFoodSumNotBetween(Float value1, Float value2) {
            addCriterion("food_sum not between", value1, value2, "foodSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumIsNull() {
            addCriterion("before_sum is null");
            return (Criteria) this;
        }

        public Criteria andBeforeSumIsNotNull() {
            addCriterion("before_sum is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeSumEqualTo(Float value) {
            addCriterion("before_sum =", value, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumNotEqualTo(Float value) {
            addCriterion("before_sum <>", value, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumGreaterThan(Float value) {
            addCriterion("before_sum >", value, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumGreaterThanOrEqualTo(Float value) {
            addCriterion("before_sum >=", value, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumLessThan(Float value) {
            addCriterion("before_sum <", value, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumLessThanOrEqualTo(Float value) {
            addCriterion("before_sum <=", value, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumIn(List<Float> values) {
            addCriterion("before_sum in", values, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumNotIn(List<Float> values) {
            addCriterion("before_sum not in", values, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumBetween(Float value1, Float value2) {
            addCriterion("before_sum between", value1, value2, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andBeforeSumNotBetween(Float value1, Float value2) {
            addCriterion("before_sum not between", value1, value2, "beforeSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumIsNull() {
            addCriterion("after_sum is null");
            return (Criteria) this;
        }

        public Criteria andAfterSumIsNotNull() {
            addCriterion("after_sum is not null");
            return (Criteria) this;
        }

        public Criteria andAfterSumEqualTo(Float value) {
            addCriterion("after_sum =", value, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumNotEqualTo(Float value) {
            addCriterion("after_sum <>", value, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumGreaterThan(Float value) {
            addCriterion("after_sum >", value, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumGreaterThanOrEqualTo(Float value) {
            addCriterion("after_sum >=", value, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumLessThan(Float value) {
            addCriterion("after_sum <", value, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumLessThanOrEqualTo(Float value) {
            addCriterion("after_sum <=", value, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumIn(List<Float> values) {
            addCriterion("after_sum in", values, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumNotIn(List<Float> values) {
            addCriterion("after_sum not in", values, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumBetween(Float value1, Float value2) {
            addCriterion("after_sum between", value1, value2, "afterSum");
            return (Criteria) this;
        }

        public Criteria andAfterSumNotBetween(Float value1, Float value2) {
            addCriterion("after_sum not between", value1, value2, "afterSum");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqIsNull() {
            addCriterion("wqx_to_cjq is null");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqIsNotNull() {
            addCriterion("wqx_to_cjq is not null");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqEqualTo(Float value) {
            addCriterion("wqx_to_cjq =", value, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqNotEqualTo(Float value) {
            addCriterion("wqx_to_cjq <>", value, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqGreaterThan(Float value) {
            addCriterion("wqx_to_cjq >", value, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqGreaterThanOrEqualTo(Float value) {
            addCriterion("wqx_to_cjq >=", value, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqLessThan(Float value) {
            addCriterion("wqx_to_cjq <", value, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqLessThanOrEqualTo(Float value) {
            addCriterion("wqx_to_cjq <=", value, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqIn(List<Float> values) {
            addCriterion("wqx_to_cjq in", values, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqNotIn(List<Float> values) {
            addCriterion("wqx_to_cjq not in", values, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqBetween(Float value1, Float value2) {
            addCriterion("wqx_to_cjq between", value1, value2, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andWqxToCjqNotBetween(Float value1, Float value2) {
            addCriterion("wqx_to_cjq not between", value1, value2, "wqxToCjq");
            return (Criteria) this;
        }

        public Criteria andNeedSumIsNull() {
            addCriterion("need_sum is null");
            return (Criteria) this;
        }

        public Criteria andNeedSumIsNotNull() {
            addCriterion("need_sum is not null");
            return (Criteria) this;
        }

        public Criteria andNeedSumEqualTo(Float value) {
            addCriterion("need_sum =", value, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumNotEqualTo(Float value) {
            addCriterion("need_sum <>", value, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumGreaterThan(Float value) {
            addCriterion("need_sum >", value, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumGreaterThanOrEqualTo(Float value) {
            addCriterion("need_sum >=", value, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumLessThan(Float value) {
            addCriterion("need_sum <", value, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumLessThanOrEqualTo(Float value) {
            addCriterion("need_sum <=", value, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumIn(List<Float> values) {
            addCriterion("need_sum in", values, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumNotIn(List<Float> values) {
            addCriterion("need_sum not in", values, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumBetween(Float value1, Float value2) {
            addCriterion("need_sum between", value1, value2, "needSum");
            return (Criteria) this;
        }

        public Criteria andNeedSumNotBetween(Float value1, Float value2) {
            addCriterion("need_sum not between", value1, value2, "needSum");
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