package com.example.mybatis.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * EnumTypeHandler: 整数下标转换
 *
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum  SexEnum {

    UNKNOWN(0,"未知"),
    MALE(1,"男"),
    FEMALE(2,"女"),
    ;

    private int name;
    private String value;
}
