package com.example.user.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:admin
 * @Description:Provinces构建
 * @Date 2019/6/14 19:13
 *****/
@Data
@Table(name = "tb_provinces")
public class Provinces implements Serializable {

    @Id
    @Column(name = "provinceid")
    private String provinceid;//省份ID

    @Column(name = "province")
    private String province;//省份名称


}
