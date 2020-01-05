package com.tinker.algorithms.string_to_int;

public class StringToInt {

    public static void main(String[] args) {

        String number = "-111111111111111110";
        try {
//            int result = Integer.valueOf(number);
            int result = myAtoi(number);
            System.out.println(Integer.MIN_VALUE);
            System.out.println(result);

//            int num = Integer.valueOf(number);
//            int max = Integer.MAX_VALUE / 2 * 10;
//            System.out.println(max);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int myAtoi(String s) {
        if(s == null){
            return 0;
        }
        s = s.trim();
        if(s.length()==0){
            return 0;
        }
        boolean isNegative=false;
        char ch = s.charAt(0);
        int result =0 ;
        int length=s.length();
        int limit=Integer.MIN_VALUE;
        if(ch == '+'){
            if(length<=1||!isDigit(s.charAt(1))){
                return 0;
            }
        }else if(ch == '-'){
            if(length<=1||!isDigit(s.charAt(1))){
                return 0;
            }
            isNegative=true;
        }else if(isDigit(ch)){
            result = -(ch-'0');
        }else {
            return 0;
        }

        for(int i=1;i<s.length();i++){
            char temp=s.charAt(i);
            if(isDigit(temp)){
                if(result<limit/10){
                    result=limit;
                    break;
                }else if((result*10)+(temp-'0')>=limit){
                    result = result*10-(temp-'0');
                }else{
                    result = limit;
                    break;
                }
            }else{
                break;
            }
        }

        return isNegative ? result : -result;
    }

    private static boolean isDigit(char ch){
        return ch>='0'&&ch<='9';
    }





    private static int stringToInt(String data) throws Exception {
        if (data == null || data.length() == 0) {
            throw new Exception("error");
        }

        int result = 0;
        for (int i = data.length() - 1; i >= 0; i--) {
            char ch = data.charAt(i);
            if (i == 0) {
                if (ch == '-') {
                    result = -result;
                } else if (isLegal(ch)) {
                    result = result + getInt(ch, i);//需要检查是否越界
                }
            } else if (isLegal(ch)) {
                result = result + getInt(ch, data.length() - 1 - i);
            } else {
                throw new Exception();
            }
        }
        return result;
    }

    private static boolean isLegal(char ch) {
        if ((ch - '0') >= 0 && (ch - '0') <= 9) {
            return true;
        } else {
            return false;
        }

    }

    private static int getInt(char ch, int number) throws Exception {
        int power = 1;
        for (int i = 0; i < number; i++) {
            power = 10 * power;
        }
        if ((ch - '0') * power < Integer.MAX_VALUE) {
            return (ch - '0') * power;
        } else {
            throw new Exception("error");
        }

    }
}
