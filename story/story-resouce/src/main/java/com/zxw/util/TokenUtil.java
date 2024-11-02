package com.zxw.util;

import java.util.Random;

public class TokenUtil {

    public static String createToken(){
        String[] arr=new String[]{
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N"
                ,"O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n"
                ,"o","p","q","r","s","t","u","v","w","x","y","z",
                "0","1","2","3","4","5","6","7","8","9"
        };

        Random random = new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<32;i++){
            int n = random.nextInt(61);
            sb.append(arr[n]);
        }
        return sb.toString();
    }

}
