package data_storage;

import java.util.Scanner;
import org.openjdk.jol.vm.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("请输入数值：");
        String num = input.next();	// 输入
        String regex = "(.{4})";	// 将字符串分成4个字符一组，空格分割
        String regex1 = "(.{2})";	// 将字符串分成2个字符一组，空格分割
        
        if (num != null && num.matches("^\\d+$"))  {// 包含0
            System.out.println("输入是正整数！");
            System.out.println("我的转换：");
            int num1=Integer.valueOf(num).intValue();
            // 输出二进制
            String string1=Integers.pchange2(num1);         
            string1 = string1.replaceAll(regex, "$1 ").trim();
            System.out.println(num+"的二进制是: "+string1+"B");
            // 输出十六进制
            String string12=Integers.pchange6(num1);
            string12 = string12.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是: 0x"+string12);
            // 实际输出
            System.out.println("实际输出：");
            String address1=Integer.toHexString((int) VM.current().addressOf(num1));
            address1=address1.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的内存地址是: 0x"+address1);
            String arr1=Integer.toHexString(num1);
            String str1 = String.format("%1$08d",Integer.valueOf(arr1));
            str1=str1.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是: 0x"+str1);
        } else if(num.matches("^-[0-9]*[1-9][0-9]*$")) {
        	System.out.println("输入是负整数！");
        	System.out.println("我的转换：");
        	int num2=Integer.valueOf(num).intValue();	// intValue():输出int数据	valueOf() 方法用于返回给定参数的原生 Number 对象值
        	// 输出二进制
        	String string2=Integers.nchange2(num2);
            string2 = string2.replaceAll(regex, "$1 ").trim();
            System.out.println(num+"的二进制是: "+string2+"B");
            // 输出十六进制
            String string21=Integers.pchange6(num2);
            string21 = string21.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是： 0x"+string21);
            // 实际输出
            System.out.println("实际输出：");
            String address2=Integer.toHexString((int) VM.current().addressOf(num2));
            address2=address2.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的内存地址是: 0x"+address2);
            String arr2=Integer.toHexString(num2);
            arr2=arr2.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是: 0x"+arr2);
        } else if(num.matches("^\\d+(\\.\\d+)?$")) {	
        	System.out.println("输入是正浮点数！");
        	System.out.println("我的转换：");
        	Float float1=Float.parseFloat(num);
        	// 输出二进制
        	String string31=Floating_num.floatToIEEE754(float1);
            string31 = string31.replaceAll(regex, "$1 ").trim();
        	System.out.println(num+"的二进制是: "+string31+"B");
        	// 输出十六进制
        	String string32=Floating_num.fdchange6(float1);
        	string32 = string32.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是： 0x"+string32);
            // 实际输出
            System.out.println("实际输出：");
            String address3=Integer.toHexString((int) VM.current().addressOf(Float.floatToIntBits(float1)));
            address3=address3.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的内存地址是: 0x"+address3);
            String arr3=Integer.toHexString(Float.floatToIntBits(float1));
            arr3=arr3.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是: 0x"+arr3);
        } else if(num.matches("^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$")) {
        	System.out.println("输入是负浮点数！");
        	System.out.println("我的转换：");
        	Float float2=Float.parseFloat(num);
        	// 输出二进制
        	String string41=Floating_num.floatToIEEE754(float2);
        	string41 = string41.replaceAll(regex, "$1 ").trim();
        	System.out.println(num+"的二进制是: "+string41+"B");
        	// 输出十六进制
        	String string42=Floating_num.fdchange6(float2);
        	string42 = string42.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是： 0x"+string42);
            // 实际输出
            System.out.println("实际输出：");
            String address4=Integer.toHexString((int) VM.current().addressOf(Float.floatToIntBits(float2)));
            address4=address4.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的内存地址是: 0x"+address4);
            String arr4=Integer.toHexString(Float.floatToIntBits(float2));
            arr4=arr4.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是: 0x"+arr4);
        }else {
            System.out.println("输入值为字符！");
            System.out.println("我的转换：");
            num = num.replace("\"", ""); // 去除双引号
            num = num.replace("\'", ""); // 去除单引号
            char aum=num.charAt(0);	// 把字符串转为字符
            int asill=aum;	// 获取asill码
            // 输出二进制
            String string51=Integers.pchange2(asill);
            string51 = string51.replaceAll(regex, "$1 ").trim();
            System.out.println(num+"的二进制是: "+string51+"B");
            // 输出十六进制
            String string52=Integers.pchange6(asill);
            string52 = string52.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是: 0x"+string52);
            // 实际输出
            System.out.println("实际输出：");
            String address5=Integer.toHexString((int) VM.current().addressOf(asill));
            address5=address5.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的内存地址是: 0x"+address5);
            String arr5=Integer.toHexString(asill);
            String str2 = String.format("%1$08d",Integer.valueOf(arr5));
            str2=str2.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"的十六进制是: 0x"+str2);
            
        }
	}
}
