package data_storage;

import java.util.Arrays;

public class Integers {
	static String[] arr= {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	static String[] shu= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	// ��������ʮ����ת������
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
        String str = String.format("%1$032d",Integer.valueOf(c)); 	// 0 ����ǰ�油��0 ֻ�ܲ�0 ���ܲ��������,��������ǰ�油�ո�;32 ������Ϊ32;d �������Ϊ������
//        char b[] = str.toCharArray();	// ���ַ���ת��Ϊ����
        return str;
	}
	// ��������ʮ����ת������
	public static String nchange2(int negative) {
		negative=-negative;	// �Ѹ���ȥ��
		String c = "";	// �ȵõ���������
        while (negative != 0) {
            int b = negative % 2;
            negative = negative / 2;
            c = b + c;
        }
        String str = String.format("%1$032d",Integer.valueOf(c)); // �Ѷ��������Ϊ32λ
        char[] ch = str.toCharArray();	// ���ַ���ת��Ϊ����
      
        //������λ������λ��λȡ��������
        for (int i = 1; i < ch.length; i++) {   
            if(ch[i]=='0'){
                ch[i]='1';
            }
            else if(ch[i]=='1'){
                ch[i]='0';
            }
        }
        
      //�����������1����=����
        if(ch[31]=='0'){           //���һλ��0��ֱ�Ӽ�1
            ch[31]='1';
        }
        else{                     //���һλ�����1
            ch[31]='0';
            for (int i =ch.length-2; i>0; i--) {
                //�ӵ�λ����λ�������ҵ���һ��Ϊ0�������Ѹ�λ��1���ٰѸ�λ��30λ����30������ȫ��ȡ0
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
        if(ch[0]=='0') {	// �ѷ���λ��Ϊ1
        	ch[0]='1';
        }
        String str2 = String.valueOf(ch); // ����ת�ַ���
		return str2;	
	}
	
	// ������תʮ������
	public static String pchange6(int positive6) {
		String str;
		if(positive6>=0) {
			str=pchange2(positive6);
		}else {
			str=nchange2(positive6);
		}
		String[] fin = new String[8];
		//ÿ�ĸ��ַ�Ϊһ�飬�ÿո�ֿ�
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
		String str2 = String.join("", fin); // ����ת�ַ���
		return str2;
	}
}
