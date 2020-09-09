package com.qy.pojo;

import lombok.Data;

import java.util.Date;

/*
wwh
2020/9/9
 */
@Data
public class Company {
    // 公司id
    private Integer company_id;
    // 公司名
    private String company_name;
    // 公司名简称
    private String company_shortname;
    // 公司简介
    private String company_profile;
    // 公司地址
    private String company_address;
    // 公司老板
    private String company_boss;
    // 注册资本
    private String company_registered_capital;
    // 公司成立时间
    private Date company_date;
    // 公司头像
    private String company_img;
    // 统一信用代码
    private String company_code;
    // 经营范围
    private String company_business_scope;
    // 经营状态，默认为1（1正常/0异常）
    private Integer company_status;
    // 公司视频简介
    private String company_vcr;
    //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
    private Integer company_scale;
    //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
    private Integer company_financing;
}
