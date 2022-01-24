package data_storage;

public class Floating_num {
	static String[] arr= {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	static String[] shu= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	// �����ȸ�����ת������
	
	// ��������ת������
	public static String zschange2(int zhengshu) {
		String c = "";
        while (zhengshu != 0) {
            int b = zhengshu % 2;
            zhengshu = zhengshu / 2;
            c = b + c;
        }
        return c;
	}
	
	// ��ȡfloat��IEEE754�洢��ʽ
	public static String floatToIEEE754(float value) {
		//����λ
		String sflag = value > 0 ? "0" : "1";
		if(value<0) {
			value=-value;
		}
		if(value>1) {	// ����������1ʱ
			//��������
			int zs = (int) Math.floor(value);	// ȡ��
			//�������ֶ�����
			String zsb = zschange2(zs);
			//С�����֣���ʽ�� 0.02
			String valueStr = String.valueOf(value);	// String.valueOf(float f) : �� float ���� f ת�����ַ��� 
			// indexOf() �����ɷ���ĳ��ָ�����ַ���ֵ���ַ������״γ��ֵ�λ��	
			// str.substring(int startIndex);��ȡ��str������ĸ�𳤶�ΪstartIndex���ַ�������ʣ���ַ�����ֵ��str
			String fxStr = "0" + valueStr.substring(valueStr.indexOf("."));	// С������
			float fx = Float.parseFloat(fxStr);
			String fxb = toBin(fx);	//С�����ֶ�����
			String e = zschange2(127 + zsb.length() - 1);	// �������Ķ�����
			e = String.format("%1$08d",Integer.valueOf(e));	// ������벻��8λ������ǰ���0������8λ���򲻱䣻
			String m = zsb.substring(1) + fxb;	// //β��λ
			// β����Ҫ��1�����
			char[] ch = m.toCharArray();	// ���ַ���ת��Ϊ����
			if(ch[23]=='1') {
				if(ch[22]=='0'){           //���һλ��0��ֱ�Ӽ�1
		            ch[22]='1';
		        }
		        else{                     //���һλ�����1
		            ch[22]='0';
		            for (int i =21; i>0; i--) {
		                //�ӵ�λ����λ�������ҵ���һ��Ϊ0�������Ѹ�λ��1���ٰѸ�λ��21λ����21������ȫ��ȡ0
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
			}
			m = String.valueOf(ch); // ����ת�ַ���
			String result = sflag + e + m;	// �ѷ���λ�����룬λ��ƴ������
			// ȡ32λ������32λ����+0������32λ��ȡ0-31
			while (result.length() < 32) {
				result += "0";
			}
			if (result.length() > 32) {
				result = result.substring(0, 32);
			}
			return result;
		}
		else {	// ������С��1ʱ�����-1ʱ
			//С�����֣���ʽ�� 0.02
			//  С��1ʱ��ֱ�ӽ���ת��������
			String fxb1 = toBin(value);	//С�����ֶ�����
			String fixStr1="0."+fxb1;
			int count=(int) fixStr1.indexOf("1");
			String e = zschange2(127-(count-1));	// �������Ķ�����
			e = String.format("%1$08d",Integer.valueOf(e));	// ������벻��8λ������ǰ���0������8λ���򲻱䣻
			String m = fixStr1.substring(fixStr1.indexOf("1")+1);	// //β��λ����ȡ��һ��1��λ�ã�+1���ȡ������ַ�����Ϊβ��
			String result = sflag + e + m;	// �ѷ���λ�����룬λ��ƴ������
			// ȡ32λ������32λ����+0������32λ��ȡ0-31
			while (result.length() < 32) {
				result += "0";
			}
			if (result.length() > 32) {
				result = result.substring(0, 32);
			}
			return result;
		}
		
	}
 
	// С������ȡ������
	private static String toBin(float f) {
//		StringBuilder ���ַ����Ĳ�����ֱ�Ӹı��ַ��������������������µĶ���	ʹ���ַ���ƴ�ӵ�ʱ�������StringBuilder	StringBuilder������Զ�����һ��16λ���ַ�����
		StringBuilder stringBuilder = new StringBuilder();
		int count = 32; // ����С������λ�����Ϊ32λ���������32��ֹͣ
        float num = 0;
        while (f > 0.0000000001) {	// �������洢���ȷ�ΧΪ0.0000000001
            count--;
            if (count == 0) {
               break;
            }
            num = f * 2;
            if (num >= 1) {
                stringBuilder.append(1);	// builder.append():����->׷������
                f = num - 1;	// +1֮��Ҫ��ȥ1�������������
            } else {
                stringBuilder.append(0);
                f = num;	// С��1ʱ׷��0����ʱnum�����´�����
            }
        }
        String result=String.valueOf(stringBuilder);	// ǿתΪ�ַ���
        return result;
	}
	
	// ������ת16����
	// ������תʮ������
	public static String fdchange6(float positive6) {
		String str;
		str=floatToIEEE754(positive6);
		
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
