package data_storage;

import java.util.Scanner;
import org.openjdk.jol.vm.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("��������ֵ��");
        String num = input.next();	// ����
        String regex = "(.{4})";	// ���ַ����ֳ�4���ַ�һ�飬�ո�ָ�
        String regex1 = "(.{2})";	// ���ַ����ֳ�2���ַ�һ�飬�ո�ָ�
        
        if (num != null && num.matches("^\\d+$"))  {// ����0
            System.out.println("��������������");
            System.out.println("�ҵ�ת����");
            int num1=Integer.valueOf(num).intValue();
            // ���������
            String string1=Integers.pchange2(num1);         
            string1 = string1.replaceAll(regex, "$1 ").trim();
            System.out.println(num+"�Ķ�������: "+string1+"B");
            // ���ʮ������
            String string12=Integers.pchange6(num1);
            string12 = string12.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ��������: 0x"+string12);
            // ʵ�����
            System.out.println("ʵ�������");
            String address1=Integer.toHexString((int) VM.current().addressOf(num1));
            address1=address1.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"���ڴ��ַ��: 0x"+address1);
            String arr1=Integer.toHexString(num1);
            String str1 = String.format("%1$08d",Integer.valueOf(arr1));
            str1=str1.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ��������: 0x"+str1);
        } else if(num.matches("^-[0-9]*[1-9][0-9]*$")) {
        	System.out.println("�����Ǹ�������");
        	System.out.println("�ҵ�ת����");
        	int num2=Integer.valueOf(num).intValue();	// intValue():���int����	valueOf() �������ڷ��ظ���������ԭ�� Number ����ֵ
        	// ���������
        	String string2=Integers.nchange2(num2);
            string2 = string2.replaceAll(regex, "$1 ").trim();
            System.out.println(num+"�Ķ�������: "+string2+"B");
            // ���ʮ������
            String string21=Integers.pchange6(num2);
            string21 = string21.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ�������ǣ� 0x"+string21);
            // ʵ�����
            System.out.println("ʵ�������");
            String address2=Integer.toHexString((int) VM.current().addressOf(num2));
            address2=address2.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"���ڴ��ַ��: 0x"+address2);
            String arr2=Integer.toHexString(num2);
            arr2=arr2.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ��������: 0x"+arr2);
        } else if(num.matches("^\\d+(\\.\\d+)?$")) {	
        	System.out.println("����������������");
        	System.out.println("�ҵ�ת����");
        	Float float1=Float.parseFloat(num);
        	// ���������
        	String string31=Floating_num.floatToIEEE754(float1);
            string31 = string31.replaceAll(regex, "$1 ").trim();
        	System.out.println(num+"�Ķ�������: "+string31+"B");
        	// ���ʮ������
        	String string32=Floating_num.fdchange6(float1);
        	string32 = string32.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ�������ǣ� 0x"+string32);
            // ʵ�����
            System.out.println("ʵ�������");
            String address3=Integer.toHexString((int) VM.current().addressOf(Float.floatToIntBits(float1)));
            address3=address3.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"���ڴ��ַ��: 0x"+address3);
            String arr3=Integer.toHexString(Float.floatToIntBits(float1));
            arr3=arr3.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ��������: 0x"+arr3);
        } else if(num.matches("^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$")) {
        	System.out.println("�����Ǹ���������");
        	System.out.println("�ҵ�ת����");
        	Float float2=Float.parseFloat(num);
        	// ���������
        	String string41=Floating_num.floatToIEEE754(float2);
        	string41 = string41.replaceAll(regex, "$1 ").trim();
        	System.out.println(num+"�Ķ�������: "+string41+"B");
        	// ���ʮ������
        	String string42=Floating_num.fdchange6(float2);
        	string42 = string42.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ�������ǣ� 0x"+string42);
            // ʵ�����
            System.out.println("ʵ�������");
            String address4=Integer.toHexString((int) VM.current().addressOf(Float.floatToIntBits(float2)));
            address4=address4.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"���ڴ��ַ��: 0x"+address4);
            String arr4=Integer.toHexString(Float.floatToIntBits(float2));
            arr4=arr4.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ��������: 0x"+arr4);
        }else {
            System.out.println("����ֵΪ�ַ���");
            System.out.println("�ҵ�ת����");
            num = num.replace("\"", ""); // ȥ��˫����
            num = num.replace("\'", ""); // ȥ��������
            char aum=num.charAt(0);	// ���ַ���תΪ�ַ�
            int asill=aum;	// ��ȡasill��
            // ���������
            String string51=Integers.pchange2(asill);
            string51 = string51.replaceAll(regex, "$1 ").trim();
            System.out.println(num+"�Ķ�������: "+string51+"B");
            // ���ʮ������
            String string52=Integers.pchange6(asill);
            string52 = string52.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ��������: 0x"+string52);
            // ʵ�����
            System.out.println("ʵ�������");
            String address5=Integer.toHexString((int) VM.current().addressOf(asill));
            address5=address5.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"���ڴ��ַ��: 0x"+address5);
            String arr5=Integer.toHexString(asill);
            String str2 = String.format("%1$08d",Integer.valueOf(arr5));
            str2=str2.replaceAll(regex1, "$1 ").trim();
            System.out.println(num+"��ʮ��������: 0x"+str2);
            
        }
	}
}
