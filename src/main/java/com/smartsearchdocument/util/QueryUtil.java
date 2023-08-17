package com.smartsearchdocument.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 基于JdbcTemplate封装的查询工具
 *
 * @version 1.0
 */
@Slf4j
public class QueryUtil {

    private StringBuilder sqlBuilder;

    /**
     * 私有化构造方法，防止直接创建
     */
    private QueryUtil() {
    }

    public static QueryUtil of(String sql) {
        if (StrUtil.isBlank(sql)) {
            throw new RuntimeException("sql不能为空");
        }

        QueryUtil queryUtil = new QueryUtil();
        queryUtil.sqlBuilder = new StringBuilder(sql);
        return queryUtil;
    }

    /**
     * 返回单个对象
     *
     * @param jdbcTemplate
     * @param tClass
     * @return T
     * @author NotEdibleSalt
     */
    public <T> T singleForObject(JdbcTemplate jdbcTemplate, Class<T> tClass) {

        printSql();
        return jdbcTemplate.queryForObject(this.sqlBuilder.toString(), tClass);
    }


    /**
     * 返回单个对象
     *
     * @param jdbcTemplate
     * @param args
     * @param tClass
     * @return T
     * @author NotEdibleSalt
     */
    public <T> T singleForObject(JdbcTemplate jdbcTemplate, Object[] args, Class<T> tClass) {

        printSql();
        return jdbcTemplate.queryForObject(this.sqlBuilder.toString(), tClass, args);
    }

    /**
     * 返回单个对象
     *
     * @param jdbcTemplate
     * @param args
     * @param argTypes
     * @param tClass
     * @return T
     * @author NotEdibleSalt
     */
    public <T> T singleForObject(JdbcTemplate jdbcTemplate, Object[] args, int[] argTypes, Class<T> tClass) {

        printSql();
        return jdbcTemplate.queryForObject(this.sqlBuilder.toString(), args, argTypes, tClass);
    }

    /**
     * 返回一个map
     *
     * @param jdbcTemplate
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author NotEdibleSalt
     */
    public Map<String, Object> singleForMap(JdbcTemplate jdbcTemplate) {

        printSql();
        return jdbcTemplate.queryForMap(this.sqlBuilder.toString());
    }

    /**
     * 返回一个map
     *
     * @param jdbcTemplate
     * @param args
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author NotEdibleSalt
     */
    public Map<String, Object> singleForMap(JdbcTemplate jdbcTemplate, Object[] args) {

        printSql();
        return jdbcTemplate.queryForMap(this.sqlBuilder.toString(), args);
    }

    /**
     * 返回一个map
     *
     * @param jdbcTemplate
     * @param args
     * @param argTypes
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author NotEdibleSalt
     */
    public Map<String, Object> singleForMap(JdbcTemplate jdbcTemplate, Object[] args, int[] argTypes) {

        printSql();
        return jdbcTemplate.queryForMap(this.sqlBuilder.toString(), args, argTypes);
    }

    /**
     * 返回集合对象
     *
     * @param jdbcTemplate
     * @param tClass       查询结果对象类型
     * @return java.util.List<T>
     * @author NotEdibleSalt
     */
    public <T> List<T> list(JdbcTemplate jdbcTemplate, Class<T> tClass) {

        printSql();
        return jdbcTemplate.query(this.sqlBuilder.toString(), new BeanPropertyRowMapper<>(tClass));
    }

    /**
     * 返回集合对象
     *
     * @param jdbcTemplate
     * @param args         参数数组
     * @param tClass       查询结果对象类型
     * @return java.util.List<T>
     * @author NotEdibleSalt
     */
    public <T> List<T> list(JdbcTemplate jdbcTemplate, Object[] args, Class<T> tClass) {

        printSql();
        return jdbcTemplate.query(this.sqlBuilder.toString(), new BeanPropertyRowMapper<>(tClass), args);
    }

    /**
     * 返回分页对象
     *
     * @param jdbcTemplate
     * @param args         参数数组
     * @param pageable     分页参数
     * @param tClass       查询结果对象类型
     * @return org.springframework.data.domain.Page<T>
     * @author NotEdibleSalt
     */
    public <T> Page<T> page(JdbcTemplate jdbcTemplate, Object[] args, Pageable pageable, Class<T> tClass) {

        String sql = this.sqlBuilder.toString();
        String countSql = getSqlResultCount(sql);
        int totalSize = jdbcTemplate.queryForObject(countSql, args, Integer.class);
        if (totalSize == 0) {
            return new PageImpl<>(new ArrayList<>(), pageable, totalSize);
        }

        String sortStr = "";
        Sort sort = pageable.getSort();
        if (sort.isSorted()) {

            sortStr = sort.stream()
                          .map(order -> order.getProperty() + " " + order.getDirection())
                          .collect(Collectors.joining(" "));
        }
        if (StrUtil.isNotBlank(sortStr)) {
            int order = sql.toLowerCase()
                           .lastIndexOf("order");
            if (order >= 0) {
                sql = sql.substring(order) + "ORDER BY " + sortStr;
            }
        }

        int offset = (pageable.getPageNumber()) * pageable.getPageSize();
        int limit = pageable.getPageSize();
        sql = sql + " limit " + limit + " offset " + offset;

        printSql();
        List<T> content = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(tClass), args);
        return new PageImpl<>(content, pageable, totalSize);
    }


    /**
     * 返回分页对象
     *
     * @param jdbcTemplate
     * @param pageable     分页参数
     * @param tClass       查询结果对象类型
     * @return org.springframework.data.domain.Page<T>
     * @author NotEdibleSalt
     */
    public <T> Page<T> page(JdbcTemplate jdbcTemplate, Pageable pageable, Class<T> tClass) {

        String sql = this.sqlBuilder.toString();
        String countSql = getSqlResultCount(sql);
        int totalSize = jdbcTemplate.queryForObject(countSql, Integer.class);
        if (totalSize == 0) {
            return new PageImpl<>(new ArrayList<>(), pageable, totalSize);
        }

        int offset = (pageable.getPageNumber()) * pageable.getPageSize();
        int limit = pageable.getPageSize();
        sql = sql + " limit " + limit + " offset " + offset;

        printSql();
        List<T> content = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(tClass));
        return new PageImpl<>(content, pageable, totalSize);
    }

    /**
     * 动态追加查询条件
     *
     * @param condition 条件
     * @param value     条件值
     * @return cn.exrick.xboot.common.utils.PaginationUtil
     * @author NotEdibleSalt
     */
    public QueryUtil dynamicAppendCondition(String condition, String value) {

        if (StrUtil.isNotBlank(value)) {
            this.sqlBuilder.append(condition)
                           .append(" '")
                           .append(value)
                           .append("' ");
        }
        return this;
    }

    /**
     * 动态追加查询条件
     *
     * @param condition 条件
     * @param value     条件值
     * @return cn.exrick.xboot.common.utils.PaginationUtil
     * @author NotEdibleSalt
     */
    public QueryUtil dynamicAppendCondition(String condition, Number value) {

        if (ObjectUtil.isNotNull(value)) {
            this.sqlBuilder.append(condition)
                           .append(value);
        }
        return this;
    }

    /**
     * 动态追加查询条件
     *
     * @param condition 条件
     * @return cn.exrick.xboot.common.utils.PaginationUtil
     * @author NotEdibleSalt
     */
    public QueryUtil dynamicAppendCondition(String condition) {

        if (StrUtil.isNotBlank(condition)) {
            this.sqlBuilder.append(condition);
        }
        return this;
    }

    /**
     * 动态追加查询条件
     *
     * @param condition
     * @param rList
     * @return cn.exrick.xboot.common.utils.DynamicQueryUtil
     * @author NotEdibleSalt
     */
    public QueryUtil dynamicAppendStrIn(String condition, List<String> rList) {

        if (ObjectUtil.isNotEmpty(rList)) {
            String s1 = rList.stream()
                             .map(s -> " '" + s + "'")
                             .collect(Collectors.joining(","));
            this.sqlBuilder.append(condition)
                           .append(" ( ")
                           .append(s1)
                           .append(" ) ");
        }
        return this;
    }

    /**
     * 动态追加查询条件
     *
     * @param condition
     * @param rList
     * @return cn.exrick.xboot.common.utils.DynamicQueryUtil
     * @author NotEdibleSalt
     */
    public QueryUtil dynamicAppendNumIn(String condition, List<? extends Number> rList) {

        if (ObjectUtil.isNotEmpty(rList)) {
            String s1 = rList.stream()
                             .map(String::valueOf)
                             .collect(Collectors.joining(","));
            this.sqlBuilder.append(condition)
                           .append(" ( ")
                           .append(s1)
                           .append(" ) ");
        }
        return this;
    }

    public QueryUtil dynamicAppendLikeR(String condition, String str) {

        if (StrUtil.isNotBlank(str)) {
            this.sqlBuilder.append(" ")
                           .append(condition)
                           .append(" '")
                           .append(str)
                           .append("%' ");
        }
        return this;
    }

    /**
     * 追加倒叙排序条件
     *
     * @param field 排序字段
     * @return cn.exrick.xboot.common.utils.PaginationUtil
     * @author NotEdibleSalt
     */
    public QueryUtil appendOrderByDesc(String field) {

        if (StrUtil.isNotBlank(field)) {
            this.sqlBuilder.append(" ORDER BY ")
                           .append(field)
                           .append(" DESC ");
        }
        return this;
    }

    /**
     * 追加升序排序条件
     *
     * @param field 排序字段
     * @return cn.exrick.xboot.common.utils.PaginationUtil
     * @author NotEdibleSalt
     */
    public QueryUtil appendOrderByAsc(String field) {

        if (StrUtil.isNotBlank(field)) {
            this.sqlBuilder.append(" ORDER BY ")
                           .append(field)
                           .append(" ASC ");
        }

        return this;
    }


    /**
     * 获取统计总数的sql
     *
     * @param sql
     * @return java.lang.String
     * @author NotEdibleSalt
     */
    private String getSqlResultCount(String sql) {

        List<String> strList = Arrays.stream(sql.split(" "))
                                     .map(String::trim)
                                     .filter(StrUtil::isNotBlank)
                                     .collect(Collectors.toList());

        Stack<Integer> records = new Stack<>();
        records.push(0);
        long endIndex = 0;
        for (int i = 1; i < strList.size(); i++) {

            String str = strList.get(i);
            if ("from".equalsIgnoreCase(str)) {
                records.pop();
                if (records.empty()) {
                    endIndex = i;
                    break;
                }
            }

            if ("select".equalsIgnoreCase(str)) {
                records.push(i);
            }
        }

        String result = strList.stream()
                               .skip(endIndex)
                               .collect(Collectors.joining(" "));

        result = "SELECT COUNT(1) " + result;
        return result;
    }


    /**
     * 打印sql
     *
     * @author NotEdibleSalt
     */
    private void printSql() {

        try {

            StackTraceElement[] stackTrace = Thread.currentThread()
                                                   .getStackTrace();

            StackTraceElement stackTrac = stackTrace[3];
            String pos = stackTrac.getClassName() + "." + stackTrac.getMethodName() + ": " + stackTrac.getLineNumber();

            log.info("{} \n{}", pos, this.sqlBuilder.toString());

        } catch (Exception exception) {
            log.error("打印sql失败", exception);
        }
    }
}


