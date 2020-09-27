package com.example.javaclockbackend.controller.utils;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {
    public static String hashPassword(String password) {
        String ret = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            ret = DatatypeConverter.printHexBinary(digest).toUpperCase();
            return ret;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ret; // why?
    }
}
