package com.leonard.study.jishi;

/**
 * @author leonard
 * @date 2018/8/9 13:03
 */
public class Test04 {

    public static void main(String[] args) {
        System.out.println(method(153));
    }
    public static boolean method(int a){
        boolean flag = false;
        int a1 = a/100%10;
        int a2 = a%100/10;
        int a3 = a%100%10;
        System.out.println(a1+" "+a2+" "+a3);
        if(a== a1*a1*a1+a2*a2*a2+a3*a3*a3){
            flag = true;
        }
        return flag;
    }


}
