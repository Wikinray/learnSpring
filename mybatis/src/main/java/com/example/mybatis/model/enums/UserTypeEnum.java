package com.example.mybatis.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UserTypeEnum {

    BOSS("boss",""),
    OFFLINE("offline",""),
    MANAGER("manager",""),
    ;
    private String name;
    private String value;


    public static UserTypeEnum getEnumByName(String name){
        for(UserTypeEnum userTypeEnum:UserTypeEnum.values()){
            if(userTypeEnum.getName().equals(name)){
                return userTypeEnum;
            }
        }
        return null;
    }
}
