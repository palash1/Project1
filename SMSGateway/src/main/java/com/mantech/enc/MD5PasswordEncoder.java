package com.mantech.enc;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MD5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        String encPass = "";
       try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(charSequence.toString().getBytes());
            encPass = DatatypeConverter.printHexBinary(digest).toUpperCase();
            
        }catch(Exception ex){
            
        }
       System.out.println(charSequence+"="+encPass);
        return encPass;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
