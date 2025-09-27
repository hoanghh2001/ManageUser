package org.example.user.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Gender {
    MALE("M"),FEMALE("F"),UNKNOWN("U");
    private final String code;
    private static final Map<String,Gender> CODE_TO_GENDER;
    static {
        Map<String,Gender> m = new HashMap<>();
        for (Gender g : values()){
            m.put(g.code,g);
            m.put(g.name(),g);
        }
        m.put("NAM",MALE);
        m.put("NU",FEMALE);
        CODE_TO_GENDER = Collections.unmodifiableMap(m);
    }
    Gender(String code) {
        this.code = code;
    }
    public String getCode(){
        return code;
    }
    public static Gender from(String s){
        if (s==null) return UNKNOWN;
        String t = s.trim().toUpperCase();
        switch (t){
            case "M","NAM","MALE"-> {return MALE;}
            case "N","NU","FEMALE","NỮ"-> {return FEMALE;}
            default -> {
                try {
                    return valueOf(t);
                }catch (Exception e){
                    return UNKNOWN;
                }
            }
        }
    }
}






