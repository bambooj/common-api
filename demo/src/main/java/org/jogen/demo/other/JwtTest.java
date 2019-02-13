package org.jogen.demo.other;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt
 */
public class JwtTest {

    public static String createToken(){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] secretBytes = DatatypeConverter.parseBase64Binary("JWT-TOKEN");
        Key signingKey = new SecretKeySpec(secretBytes, signatureAlgorithm.getJcaName());
        Map<String, Object> claims = new HashMap<String,Object>();
        claims.put("username", "token");
        claims.put("role", "admin");
        JwtBuilder builder = Jwts.builder().setClaims(claims)
                .setId("tokenId")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10*60*1000))
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    public static Claims parseToken(String token){
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("JWT-TOKEN"))
                .parseClaimsJws(token).getBody();
    }

    public static void main(String[] args) {
        System.out.println("jwt");
        String token = createToken();
        System.out.println(token);
        Map<String,Object> claims = parseToken(token);
        System.out.println(JSON.toJSONString(claims));

    }

}
