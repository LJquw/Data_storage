package data_storage;

import java.util.Arrays;

public class Integers {
	static String[] arr= {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	static String[] shu= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	// 正整数的十进制转二进制
	public static String pchange2(int positive) {
		String c = "";
      if(positive==0) {
    	c="0";
    }
        while (positive != 0) {
            int b = positive % 2;
            positive = positive / 2;
            c = b + c;
        }
        String str = String.format("%1$032d",Integer.valueOf(c)); 	// 0 代表前面补充0 只能补0 不能补别的数字,否则会出现前面补空格;32 代表长度为32;d 代表参数为正数型
//        char b[] = str.toCharArray();	// 将字符串转化为数组
        return str;
	}
	// 负整数的十进制转二进制
	public static String nchange2(int negative) {
		negative=-negative;	// 把负号去掉
		String c = "";	// 先得到二进制数
        while (negative != 0) {
            int b = negative % 2;
            negative = negative / 2;
            c = b + c;
        }
        String str = String.format("%1$032d",Integer.valueOf(c)); // 把二进制填充为32位
        char[] ch = str.toCharArray();	// 将字符串转化为数组
      
        //除符号位，其它位按位取反，求反码
        for (int i = 1; i < ch.length; i++) {   
            if(ch[i]=='0'){
                ch[i]='1';
            }
            else if(ch[i]=='1'){
                ch[i]='0';
            }
        }
        
      //这里做反码加1操作=补码
        if(ch[31]=='0'){           //最后一位是0，直接加1
            ch[31]='1';
        }
        else{                     //最后一位如果是1
            ch[31]='0';
            for (int i =ch.length-2; i>0; i--) {
                //从低位往高位遍历，找到第一个为0的数，把该位加1，再把该位到30位（含30）的数全部取0
                if(ch[i]=='0'){
                    int a=i;
                    ch[a]='1';
                    for (int j=ch.length-2; j > a; j--) {
                        ch[j]='0';
                    }
                    break;
                }
            }
        }
        if(ch[0]=='0') {	// 把符号位置为1
        	ch[0]='1';
        }
        String str2 = String.valueOf(ch); // 数组转字符串
		return str2;	
	}
	
	// 二进制转十六进制
	public static String pchange6(int positive6) {
		String str;
		if(positive6>=0) {
			str=pchange2(positive6);
		}else {
			str=nchange2(positive6);
		}
		String[] fin = new String[8];
		//每四个字符为一组，用空格分开
		String regex = "(.{4})";
		str = str.replaceAll(regex, "$1 ").trim();
		String [] result = str.split(" ");
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(result[i].equals(arr[j])) {
					fin[i]=shu[j];
				}
			}
		}
		String str2 = String.join("", fin); // 数组转字符串
		return str2;
	}
}
