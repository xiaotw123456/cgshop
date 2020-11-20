package com.example.cgcommon;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: V1.0
 * @author: Administrator
 * @className: JwtTest
 * @packageName: com.example.cgcommon
 * @description: 这是用户类
 * @data: 2020/10/27 20:03
 **/
public class JwtTest {


    /****
     * 创建Jwt令牌
     */
    @Test
    public void testCreateJwt(){
        JwtBuilder builder= Jwts.builder()
                .setId("888")             //设置唯一编号
                .setSubject("小白")       //设置主题  可以是JSON数据
                .setIssuedAt(new Date())  //设置签发日期
                .setExpiration(new Date())//用于设置过期时间 ，参数为Date类型数据
                .signWith(SignatureAlgorithm.HS256,"itcast");//设置签名 使用HS256算法，并设置SecretKey(字符串)
        //自定义数据
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("name","王五");
        map.put("age","22");
        builder.addClaims(map);
        //构建 并返回一个字符串
        System.out.println( builder.compact() );
    }
    /***
     * 解析Jwt令牌数据
     */
    @Test
    public void testParseJwt(){
        String compactJwt="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiLlsI_nmb0iLCJpYXQiOjE2MDM4MDA0NzUsImV4cCI6MTYwMzgwMDQ3NX0.X2AIkn-OEw5RXgDsLsr6lfarf7jfn8hXcZHJJRxHW6U";
        Claims claims = Jwts.parser().
                setSigningKey("itcast").
                parseClaimsJws(compactJwt).
                getBody();
        System.out.println(claims);
    }

}
