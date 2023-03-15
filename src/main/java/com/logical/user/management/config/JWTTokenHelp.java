//package com.logical.user.management.config;
//
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JWTTokenHelp {
//    public static final long jwt_token_validate=5*60*60;
//    private String secreteKey="jwtTokenKey";
//
//    public String getUserNameFromToken(String token){
//        return getClaimFromToken(token,Claims::getSubject);
//    }
//    private Date getExpirationDateFromAccessToken(String token){
//        return getClaimFromToken(token,Claims::getExpiration);
//    }
//
//    private String getClaimFromToken(String token, Object o) {
//    }
//
//}
