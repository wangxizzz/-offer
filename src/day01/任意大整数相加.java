package day01;
/**
 * 面试17 :拓展
 */
public class 任意大整数相加 {
	//注意输入可能有负数
	public static String bigIntegerSum(String num1, String num2) {
		char sign = '+';  
        char sign1 = num1.charAt(0);  
        char sign2 = num2.charAt(0);  
  
        String number1 = "";  
        String number2 = "";  
  
        // 去符号位操作  
        if (sign1 == '-' || sign1 == '+') {  
            number1 = num1.substring(1);  
        } else {  
            sign1 = '+';  
            number1 = num1;  
        }  
        // 去符号位操作  
        if (sign2 == '-' || sign2 == '+') {  
            number2 = num2.substring(1);  
        } else {  
            sign2 = '+';  
            number2 = num2;  
        }  
  
        boolean isDig1 = number1.matches("[1-9][0-9]*");  
        boolean isDig2 = number2.matches("[1-9][0-9]*");  
        if (!isDig1 || !isDig2) {  
            throw new NumberFormatException("输入的数据不是正确的格式的整数");  
        }  
  
        //两个数的长度  
        int length1 = number1.length();  
        int length2 = number2.length();  
        int len = length1>=length2? length1+1:length2+1;  
          
        StringBuffer number1Buffer = new StringBuffer();  
        StringBuffer number2Buffer = new StringBuffer();  
        //扩展数据的长度,使它们的长度一样  
        if(length1>length2){  
            for(int i=0; i<length1-length2; i++){  
                number2Buffer.append("0");  
            }  
        }else if(length1<length2){  
            for(int i=0; i<length2-length1; i++){  
                number1Buffer.append("0");  
            }  
        }  
          
        number1Buffer.append(number1);  
        number2Buffer.append(number2);  
          
        char[] chars1 = number1Buffer.reverse().toString().toCharArray();   
        char[] chars2 = number2Buffer.reverse().toString().toCharArray();   
        //存储每位相加的结果  
        int[] result = new int[len];  
        //同号相加  
        if(sign1==sign2){  
            sign = sign1;  
            for(int i=0; i<len-1; i++){  
                result[i] = (chars1[i]-'0')+(chars2[i]-'0');  
            }  
              
            // 处理进位  
            for (int i = 0; i < len; i++) {  
                if (result[i] >= 10) {  
                    result[i + 1] += result[i] / 10;  
                    result[i] = result[i] % 10;  
                }  
            }  
        }else {  
            // 拿大的数减去小的数  
            boolean lager = number1.compareTo(number2)>0 ? true : false;  
            if (lager) {  
                sign = sign1;  
                for (int i = 0; i < len-1; i++) {  
                    result[i] = (chars1[i] - '0') - (chars2[i] - '0');  
                }  
            } else {  
                sign = sign2;  
                for (int i = 0; i < len-1; i++) {  
                    result[i] = (chars2[i] - '0') - (chars1[i] - '0');  
                }  
            }  
              
            // 处理借位  
            for (int i = 0; i < len; i++) {  
                if (result[i] < 0) {  
                    result[i] += 10;  
                    result[i + 1]--;  
                }  
            }  
        }  
          
        // 结果没有进位时的0处理  
        boolean flag = true;  
        StringBuffer resultStr = new StringBuffer();  
  
        for (int i = result.length - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            }  
            flag = false;  
            resultStr.append(result[i]);  
        }  
  
        // 符号处理  
        if (sign == '-') {  
            return "-" + resultStr.toString();  
        } else {  
            return resultStr.toString();  
        } 
	}
	
	
	public static void main(String[] args) {
		System.out.println(bigIntegerSum("+1234434321561", "-45643513546546343413"));
	}
}
