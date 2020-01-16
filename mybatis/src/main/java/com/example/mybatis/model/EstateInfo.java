package com.example.mybatis.model;

import com.example.mybatis.model.enums.CityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstateInfo extends BaseModel{

    //城市
    private CityEnum city;

    //地产名称
    private String estateName;

    //logo图片
    private String logoImg;

    //vip图片
    private String vipLogoImg;
}
