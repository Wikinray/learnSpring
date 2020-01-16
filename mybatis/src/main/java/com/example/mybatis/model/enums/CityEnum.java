package com.example.mybatis.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  EnumTypeHandler: 根据名称转换
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum CityEnum {

    TaiYuan("TaiYuan","太原"),
    QinDao("QinDao","青岛"),
    ;

    private String name;
    private String value;
}
