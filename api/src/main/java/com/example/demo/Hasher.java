package com.example.demo;

import java.util.*;
import java.security.SecureRandom;

public class Hasher {

    static final String hashSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom random = new SecureRandom();
    private static Hasher instance = new Hasher();

    private Hasher(){}

    public static Hasher getInstance(){
        return instance;
    }


    public void FastQueryHash(Url url_obj){
        String random_hashed = null;
        /* hash function implementation */ 
        random_hashed = randomStringGenerator();
        url_obj.setHashed(smurlSmacker(random_hashed));
    }

    private String randomStringGenerator(){
        StringBuilder sb = new StringBuilder(5);
        for(int i = 0; i < 5; i++)
           sb.append(hashSet.charAt(random.nextInt(hashSet.length())));
        return sb.toString();
    }

    // put smurl.com to the beginning of hash val: smurl.com/xqVe2
    private String smurlSmacker(String hash){
        String res = null;
        res = "s.mrl/" + hash;
        return res;
    }
}