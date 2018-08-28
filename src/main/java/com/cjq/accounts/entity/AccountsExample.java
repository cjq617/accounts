package com.cjq.accounts.entity;

import com.cjq.publics.entity.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AccountsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public AccountsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBreakfastIsNull() {
            addCriterion("breakfast is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastIsNotNull() {
            addCriterion("breakfast is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastEqualTo(Float value) {
            addCriterion("breakfast =", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotEqualTo(Float value) {
            addCriterion("breakfast <>", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastGreaterThan(Float value) {
            addCriterion("breakfast >", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastGreaterThanOrEqualTo(Float value) {
            addCriterion("breakfast >=", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastLessThan(Float value) {
            addCriterion("breakfast <", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastLessThanOrEqualTo(Float value) {
            addCriterion("breakfast <=", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastIn(List<Float> values) {
            addCriterion("breakfast in", values, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotIn(List<Float> values) {
            addCriterion("breakfast not in", values, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastBetween(Float value1, Float value2) {
            addCriterion("breakfast between", value1, value2, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotBetween(Float value1, Float value2) {
            addCriterion("breakfast not between", value1, value2, "breakfast");
            return (Criteria) this;
        }

        public Criteria andLunchIsNull() {
            addCriterion("lunch is null");
            return (Criteria) this;
        }

        public Criteria andLunchIsNotNull() {
            addCriterion("lunch is not null");
            return (Criteria) this;
        }

        public Criteria andLunchEqualTo(Float value) {
            addCriterion("lunch =", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotEqualTo(Float value) {
            addCriterion("lunch <>", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchGreaterThan(Float value) {
            addCriterion("lunch >", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchGreaterThanOrEqualTo(Float value) {
            addCriterion("lunch >=", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchLessThan(Float value) {
            addCriterion("lunch <", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchLessThanOrEqualTo(Float value) {
            addCriterion("lunch <=", value, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchIn(List<Float> values) {
            addCriterion("lunch in", values, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotIn(List<Float> values) {
            addCriterion("lunch not in", values, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchBetween(Float value1, Float value2) {
            addCriterion("lunch between", value1, value2, "lunch");
            return (Criteria) this;
        }

        public Criteria andLunchNotBetween(Float value1, Float value2) {
            addCriterion("lunch not between", value1, value2, "lunch");
            return (Criteria) this;
        }

        public Criteria andSupperIsNull() {
            addCriterion("supper is null");
            return (Criteria) this;
        }

        public Criteria andSupperIsNotNull() {
            addCriterion("supper is not null");
            return (Criteria) this;
        }

        public Criteria andSupperEqualTo(Float value) {
            addCriterion("supper =", value, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperNotEqualTo(Float value) {
            addCriterion("supper <>", value, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperGreaterThan(Float value) {
            addCriterion("supper >", value, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperGreaterThanOrEqualTo(Float value) {
            addCriterion("supper >=", value, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperLessThan(Float value) {
            addCriterion("supper <", value, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperLessThanOrEqualTo(Float value) {
            addCriterion("supper <=", value, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperIn(List<Float> values) {
            addCriterion("supper in", values, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperNotIn(List<Float> values) {
            addCriterion("supper not in", values, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperBetween(Float value1, Float value2) {
            addCriterion("supper between", value1, value2, "supper");
            return (Criteria) this;
        }

        public Criteria andSupperNotBetween(Float value1, Float value2) {
            addCriterion("supper not between", value1, value2, "supper");
            return (Criteria) this;
        }

        public Criteria andEggIsNull() {
            addCriterion("egg is null");
            return (Criteria) this;
        }

        public Criteria andEggIsNotNull() {
            addCriterion("egg is not null");
            return (Criteria) this;
        }

        public Criteria andEggEqualTo(Float value) {
            addCriterion("egg =", value, "egg");
            return (Criteria) this;
        }

        public Criteria andEggNotEqualTo(Float value) {
            addCriterion("egg <>", value, "egg");
            return (Criteria) this;
        }

        public Criteria andEggGreaterThan(Float value) {
            addCriterion("egg >", value, "egg");
            return (Criteria) this;
        }

        public Criteria andEggGreaterThanOrEqualTo(Float value) {
            addCriterion("egg >=", value, "egg");
            return (Criteria) this;
        }

        public Criteria andEggLessThan(Float value) {
            addCriterion("egg <", value, "egg");
            return (Criteria) this;
        }

        public Criteria andEggLessThanOrEqualTo(Float value) {
            addCriterion("egg <=", value, "egg");
            return (Criteria) this;
        }

        public Criteria andEggIn(List<Float> values) {
            addCriterion("egg in", values, "egg");
            return (Criteria) this;
        }

        public Criteria andEggNotIn(List<Float> values) {
            addCriterion("egg not in", values, "egg");
            return (Criteria) this;
        }

        public Criteria andEggBetween(Float value1, Float value2) {
            addCriterion("egg between", value1, value2, "egg");
            return (Criteria) this;
        }

        public Criteria andEggNotBetween(Float value1, Float value2) {
            addCriterion("egg not between", value1, value2, "egg");
            return (Criteria) this;
        }

        public Criteria andFruitIsNull() {
            addCriterion("fruit is null");
            return (Criteria) this;
        }

        public Criteria andFruitIsNotNull() {
            addCriterion("fruit is not null");
            return (Criteria) this;
        }

        public Criteria andFruitEqualTo(Float value) {
            addCriterion("fruit =", value, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitNotEqualTo(Float value) {
            addCriterion("fruit <>", value, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitGreaterThan(Float value) {
            addCriterion("fruit >", value, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitGreaterThanOrEqualTo(Float value) {
            addCriterion("fruit >=", value, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitLessThan(Float value) {
            addCriterion("fruit <", value, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitLessThanOrEqualTo(Float value) {
            addCriterion("fruit <=", value, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitIn(List<Float> values) {
            addCriterion("fruit in", values, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitNotIn(List<Float> values) {
            addCriterion("fruit not in", values, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitBetween(Float value1, Float value2) {
            addCriterion("fruit between", value1, value2, "fruit");
            return (Criteria) this;
        }

        public Criteria andFruitNotBetween(Float value1, Float value2) {
            addCriterion("fruit not between", value1, value2, "fruit");
            return (Criteria) this;
        }

        public Criteria andDrinkIsNull() {
            addCriterion("drink is null");
            return (Criteria) this;
        }

        public Criteria andDrinkIsNotNull() {
            addCriterion("drink is not null");
            return (Criteria) this;
        }

        public Criteria andDrinkEqualTo(Float value) {
            addCriterion("drink =", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkNotEqualTo(Float value) {
            addCriterion("drink <>", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkGreaterThan(Float value) {
            addCriterion("drink >", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkGreaterThanOrEqualTo(Float value) {
            addCriterion("drink >=", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkLessThan(Float value) {
            addCriterion("drink <", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkLessThanOrEqualTo(Float value) {
            addCriterion("drink <=", value, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkIn(List<Float> values) {
            addCriterion("drink in", values, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkNotIn(List<Float> values) {
            addCriterion("drink not in", values, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkBetween(Float value1, Float value2) {
            addCriterion("drink between", value1, value2, "drink");
            return (Criteria) this;
        }

        public Criteria andDrinkNotBetween(Float value1, Float value2) {
            addCriterion("drink not between", value1, value2, "drink");
            return (Criteria) this;
        }

        public Criteria andFoodIsNull() {
            addCriterion("food is null");
            return (Criteria) this;
        }

        public Criteria andFoodIsNotNull() {
            addCriterion("food is not null");
            return (Criteria) this;
        }

        public Criteria andFoodEqualTo(Float value) {
            addCriterion("food =", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotEqualTo(Float value) {
            addCriterion("food <>", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodGreaterThan(Float value) {
            addCriterion("food >", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodGreaterThanOrEqualTo(Float value) {
            addCriterion("food >=", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLessThan(Float value) {
            addCriterion("food <", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLessThanOrEqualTo(Float value) {
            addCriterion("food <=", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodIn(List<Float> values) {
            addCriterion("food in", values, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotIn(List<Float> values) {
            addCriterion("food not in", values, "food");
            return (Criteria) this;
        }

        public Criteria andFoodBetween(Float value1, Float value2) {
            addCriterion("food between", value1, value2, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotBetween(Float value1, Float value2) {
            addCriterion("food not between", value1, value2, "food");
            return (Criteria) this;
        }

        public Criteria andRiceIsNull() {
            addCriterion("rice is null");
            return (Criteria) this;
        }

        public Criteria andRiceIsNotNull() {
            addCriterion("rice is not null");
            return (Criteria) this;
        }

        public Criteria andRiceEqualTo(Float value) {
            addCriterion("rice =", value, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceNotEqualTo(Float value) {
            addCriterion("rice <>", value, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceGreaterThan(Float value) {
            addCriterion("rice >", value, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceGreaterThanOrEqualTo(Float value) {
            addCriterion("rice >=", value, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceLessThan(Float value) {
            addCriterion("rice <", value, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceLessThanOrEqualTo(Float value) {
            addCriterion("rice <=", value, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceIn(List<Float> values) {
            addCriterion("rice in", values, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceNotIn(List<Float> values) {
            addCriterion("rice not in", values, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceBetween(Float value1, Float value2) {
            addCriterion("rice between", value1, value2, "rice");
            return (Criteria) this;
        }

        public Criteria andRiceNotBetween(Float value1, Float value2) {
            addCriterion("rice not between", value1, value2, "rice");
            return (Criteria) this;
        }

        public Criteria andCakeIsNull() {
            addCriterion("cake is null");
            return (Criteria) this;
        }

        public Criteria andCakeIsNotNull() {
            addCriterion("cake is not null");
            return (Criteria) this;
        }

        public Criteria andCakeEqualTo(Float value) {
            addCriterion("cake =", value, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeNotEqualTo(Float value) {
            addCriterion("cake <>", value, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeGreaterThan(Float value) {
            addCriterion("cake >", value, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeGreaterThanOrEqualTo(Float value) {
            addCriterion("cake >=", value, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeLessThan(Float value) {
            addCriterion("cake <", value, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeLessThanOrEqualTo(Float value) {
            addCriterion("cake <=", value, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeIn(List<Float> values) {
            addCriterion("cake in", values, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeNotIn(List<Float> values) {
            addCriterion("cake not in", values, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeBetween(Float value1, Float value2) {
            addCriterion("cake between", value1, value2, "cake");
            return (Criteria) this;
        }

        public Criteria andCakeNotBetween(Float value1, Float value2) {
            addCriterion("cake not between", value1, value2, "cake");
            return (Criteria) this;
        }

        public Criteria andSupermarketIsNull() {
            addCriterion("supermarket is null");
            return (Criteria) this;
        }

        public Criteria andSupermarketIsNotNull() {
            addCriterion("supermarket is not null");
            return (Criteria) this;
        }

        public Criteria andSupermarketEqualTo(Float value) {
            addCriterion("supermarket =", value, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketNotEqualTo(Float value) {
            addCriterion("supermarket <>", value, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketGreaterThan(Float value) {
            addCriterion("supermarket >", value, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketGreaterThanOrEqualTo(Float value) {
            addCriterion("supermarket >=", value, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketLessThan(Float value) {
            addCriterion("supermarket <", value, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketLessThanOrEqualTo(Float value) {
            addCriterion("supermarket <=", value, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketIn(List<Float> values) {
            addCriterion("supermarket in", values, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketNotIn(List<Float> values) {
            addCriterion("supermarket not in", values, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketBetween(Float value1, Float value2) {
            addCriterion("supermarket between", value1, value2, "supermarket");
            return (Criteria) this;
        }

        public Criteria andSupermarketNotBetween(Float value1, Float value2) {
            addCriterion("supermarket not between", value1, value2, "supermarket");
            return (Criteria) this;
        }

        public Criteria andTrafficIsNull() {
            addCriterion("traffic is null");
            return (Criteria) this;
        }

        public Criteria andTrafficIsNotNull() {
            addCriterion("traffic is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficEqualTo(Float value) {
            addCriterion("traffic =", value, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficNotEqualTo(Float value) {
            addCriterion("traffic <>", value, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficGreaterThan(Float value) {
            addCriterion("traffic >", value, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficGreaterThanOrEqualTo(Float value) {
            addCriterion("traffic >=", value, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficLessThan(Float value) {
            addCriterion("traffic <", value, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficLessThanOrEqualTo(Float value) {
            addCriterion("traffic <=", value, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficIn(List<Float> values) {
            addCriterion("traffic in", values, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficNotIn(List<Float> values) {
            addCriterion("traffic not in", values, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficBetween(Float value1, Float value2) {
            addCriterion("traffic between", value1, value2, "traffic");
            return (Criteria) this;
        }

        public Criteria andTrafficNotBetween(Float value1, Float value2) {
            addCriterion("traffic not between", value1, value2, "traffic");
            return (Criteria) this;
        }

        public Criteria andSoyIsNull() {
            addCriterion("soy is null");
            return (Criteria) this;
        }

        public Criteria andSoyIsNotNull() {
            addCriterion("soy is not null");
            return (Criteria) this;
        }

        public Criteria andSoyEqualTo(Float value) {
            addCriterion("soy =", value, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyNotEqualTo(Float value) {
            addCriterion("soy <>", value, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyGreaterThan(Float value) {
            addCriterion("soy >", value, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyGreaterThanOrEqualTo(Float value) {
            addCriterion("soy >=", value, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyLessThan(Float value) {
            addCriterion("soy <", value, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyLessThanOrEqualTo(Float value) {
            addCriterion("soy <=", value, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyIn(List<Float> values) {
            addCriterion("soy in", values, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyNotIn(List<Float> values) {
            addCriterion("soy not in", values, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyBetween(Float value1, Float value2) {
            addCriterion("soy between", value1, value2, "soy");
            return (Criteria) this;
        }

        public Criteria andSoyNotBetween(Float value1, Float value2) {
            addCriterion("soy not between", value1, value2, "soy");
            return (Criteria) this;
        }

        public Criteria andGassIsNull() {
            addCriterion("gass is null");
            return (Criteria) this;
        }

        public Criteria andGassIsNotNull() {
            addCriterion("gass is not null");
            return (Criteria) this;
        }

        public Criteria andGassEqualTo(Float value) {
            addCriterion("gass =", value, "gass");
            return (Criteria) this;
        }

        public Criteria andGassNotEqualTo(Float value) {
            addCriterion("gass <>", value, "gass");
            return (Criteria) this;
        }

        public Criteria andGassGreaterThan(Float value) {
            addCriterion("gass >", value, "gass");
            return (Criteria) this;
        }

        public Criteria andGassGreaterThanOrEqualTo(Float value) {
            addCriterion("gass >=", value, "gass");
            return (Criteria) this;
        }

        public Criteria andGassLessThan(Float value) {
            addCriterion("gass <", value, "gass");
            return (Criteria) this;
        }

        public Criteria andGassLessThanOrEqualTo(Float value) {
            addCriterion("gass <=", value, "gass");
            return (Criteria) this;
        }

        public Criteria andGassIn(List<Float> values) {
            addCriterion("gass in", values, "gass");
            return (Criteria) this;
        }

        public Criteria andGassNotIn(List<Float> values) {
            addCriterion("gass not in", values, "gass");
            return (Criteria) this;
        }

        public Criteria andGassBetween(Float value1, Float value2) {
            addCriterion("gass between", value1, value2, "gass");
            return (Criteria) this;
        }

        public Criteria andGassNotBetween(Float value1, Float value2) {
            addCriterion("gass not between", value1, value2, "gass");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(Float value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(Float value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(Float value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(Float value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(Float value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(Float value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<Float> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<Float> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(Float value1, Float value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(Float value1, Float value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRentIsNull() {
            addCriterion("rent is null");
            return (Criteria) this;
        }

        public Criteria andRentIsNotNull() {
            addCriterion("rent is not null");
            return (Criteria) this;
        }

        public Criteria andRentEqualTo(Float value) {
            addCriterion("rent =", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotEqualTo(Float value) {
            addCriterion("rent <>", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThan(Float value) {
            addCriterion("rent >", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThanOrEqualTo(Float value) {
            addCriterion("rent >=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThan(Float value) {
            addCriterion("rent <", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThanOrEqualTo(Float value) {
            addCriterion("rent <=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentIn(List<Float> values) {
            addCriterion("rent in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotIn(List<Float> values) {
            addCriterion("rent not in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentBetween(Float value1, Float value2) {
            addCriterion("rent between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotBetween(Float value1, Float value2) {
            addCriterion("rent not between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andOtherIsNull() {
            addCriterion("other is null");
            return (Criteria) this;
        }

        public Criteria andOtherIsNotNull() {
            addCriterion("other is not null");
            return (Criteria) this;
        }

        public Criteria andOtherEqualTo(String value) {
            addCriterion("other =", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotEqualTo(String value) {
            addCriterion("other <>", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThan(String value) {
            addCriterion("other >", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherGreaterThanOrEqualTo(String value) {
            addCriterion("other >=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThan(String value) {
            addCriterion("other <", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLessThanOrEqualTo(String value) {
            addCriterion("other <=", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherLike(String value) {
            addCriterion("other like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotLike(String value) {
            addCriterion("other not like", value, "other");
            return (Criteria) this;
        }

        public Criteria andOtherIn(List<String> values) {
            addCriterion("other in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotIn(List<String> values) {
            addCriterion("other not in", values, "other");
            return (Criteria) this;
        }

        public Criteria andOtherBetween(String value1, String value2) {
            addCriterion("other between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOtherNotBetween(String value1, String value2) {
            addCriterion("other not between", value1, value2, "other");
            return (Criteria) this;
        }

        public Criteria andOpriceIsNull() {
            addCriterion("oprice is null");
            return (Criteria) this;
        }

        public Criteria andOpriceIsNotNull() {
            addCriterion("oprice is not null");
            return (Criteria) this;
        }

        public Criteria andOpriceEqualTo(String value) {
            addCriterion("oprice =", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotEqualTo(String value) {
            addCriterion("oprice <>", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceGreaterThan(String value) {
            addCriterion("oprice >", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceGreaterThanOrEqualTo(String value) {
            addCriterion("oprice >=", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceLessThan(String value) {
            addCriterion("oprice <", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceLessThanOrEqualTo(String value) {
            addCriterion("oprice <=", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceLike(String value) {
            addCriterion("oprice like", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotLike(String value) {
            addCriterion("oprice not like", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceIn(List<String> values) {
            addCriterion("oprice in", values, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotIn(List<String> values) {
            addCriterion("oprice not in", values, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceBetween(String value1, String value2) {
            addCriterion("oprice between", value1, value2, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotBetween(String value1, String value2) {
            addCriterion("oprice not between", value1, value2, "oprice");
            return (Criteria) this;
        }

        public Criteria andTotalFoodIsNull() {
            addCriterion("total_food is null");
            return (Criteria) this;
        }

        public Criteria andTotalFoodIsNotNull() {
            addCriterion("total_food is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFoodEqualTo(Float value) {
            addCriterion("total_food =", value, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodNotEqualTo(Float value) {
            addCriterion("total_food <>", value, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodGreaterThan(Float value) {
            addCriterion("total_food >", value, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodGreaterThanOrEqualTo(Float value) {
            addCriterion("total_food >=", value, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodLessThan(Float value) {
            addCriterion("total_food <", value, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodLessThanOrEqualTo(Float value) {
            addCriterion("total_food <=", value, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodIn(List<Float> values) {
            addCriterion("total_food in", values, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodNotIn(List<Float> values) {
            addCriterion("total_food not in", values, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodBetween(Float value1, Float value2) {
            addCriterion("total_food between", value1, value2, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalFoodNotBetween(Float value1, Float value2) {
            addCriterion("total_food not between", value1, value2, "totalFood");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Float value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Float value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Float value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Float value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Float value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Float> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Float> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Float value1, Float value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Float value1, Float value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("add_date is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("add_date is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(Date value) {
            addCriterionForJDBCDate("add_date =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("add_date <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(Date value) {
            addCriterionForJDBCDate("add_date >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_date >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(Date value) {
            addCriterionForJDBCDate("add_date <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("add_date <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<Date> values) {
            addCriterionForJDBCDate("add_date in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("add_date not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_date between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("add_date not between", value1, value2, "addDate");
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

        public Criteria andNeedsumIsNull() {
            addCriterion("needSum is null");
            return (Criteria) this;
        }

        public Criteria andNeedsumIsNotNull() {
            addCriterion("needSum is not null");
            return (Criteria) this;
        }

        public Criteria andNeedsumEqualTo(Float value) {
            addCriterion("needSum =", value, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumNotEqualTo(Float value) {
            addCriterion("needSum <>", value, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumGreaterThan(Float value) {
            addCriterion("needSum >", value, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumGreaterThanOrEqualTo(Float value) {
            addCriterion("needSum >=", value, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumLessThan(Float value) {
            addCriterion("needSum <", value, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumLessThanOrEqualTo(Float value) {
            addCriterion("needSum <=", value, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumIn(List<Float> values) {
            addCriterion("needSum in", values, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumNotIn(List<Float> values) {
            addCriterion("needSum not in", values, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumBetween(Float value1, Float value2) {
            addCriterion("needSum between", value1, value2, "needsum");
            return (Criteria) this;
        }

        public Criteria andNeedsumNotBetween(Float value1, Float value2) {
            addCriterion("needSum not between", value1, value2, "needsum");
            return (Criteria) this;
        }

        public Criteria andFootballIsNull() {
            addCriterion("football is null");
            return (Criteria) this;
        }

        public Criteria andFootballIsNotNull() {
            addCriterion("football is not null");
            return (Criteria) this;
        }

        public Criteria andFootballEqualTo(Float value) {
            addCriterion("football =", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballNotEqualTo(Float value) {
            addCriterion("football <>", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballGreaterThan(Float value) {
            addCriterion("football >", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballGreaterThanOrEqualTo(Float value) {
            addCriterion("football >=", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballLessThan(Float value) {
            addCriterion("football <", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballLessThanOrEqualTo(Float value) {
            addCriterion("football <=", value, "football");
            return (Criteria) this;
        }

        public Criteria andFootballIn(List<Float> values) {
            addCriterion("football in", values, "football");
            return (Criteria) this;
        }

        public Criteria andFootballNotIn(List<Float> values) {
            addCriterion("football not in", values, "football");
            return (Criteria) this;
        }

        public Criteria andFootballBetween(Float value1, Float value2) {
            addCriterion("football between", value1, value2, "football");
            return (Criteria) this;
        }

        public Criteria andFootballNotBetween(Float value1, Float value2) {
            addCriterion("football not between", value1, value2, "football");
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