package com.example.demo;

public class Url {
    private int id;
    private String original;
    private String hashed;
    
    // constructor: 
    public Url(int internal_id, String original, String hashed){  
        this.id = internal_id;
        this.original = original;
        this.hashed = hashed;
    };  

    public Url(){  
        this.id = -1;
        this.original = "default url";
        this.hashed = "default url";
    };

    public String getHashed(){
        return this.hashed;
    }
    public String getOriginal(){
        return this.original;
    }





}
