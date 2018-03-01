package com.imooc.gril.exception;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * 自定义异常类，当不同年龄返回不同的code，默认的异常只能自定义message
 * spring只对RuntimeException进行事务回滚
 *
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
