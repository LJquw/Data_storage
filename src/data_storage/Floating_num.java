package data_storage;

public class Floating_num {
	static String[] arr= {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	static String[] shu= {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	// 单精度浮点数转二进制
	
	// 整数部分转二进制
	public static String zschange2(int zhengshu) {
		String c = "";
        while (zhengshu != 0) {
            int b = zhengshu % 2;
            zhengshu = zhengshu / 2;
            c = b + c;
        }
        return c;
	}
	
	// 获取float的IEEE754存储格式
	public static String floatToIEEE754(float value) {
		//符号位
		String sflag = value > 0 ? "0" : "1";
		if(value<0) {
			value=-value;
		}
		if(value>1) {	// 浮点数大于1时
			//整数部分
			int zs = (int) Math.floor(value);	// 取整
			//整数部分二进制
			String zsb = zschange2(zs);
			//小数部分，格式： 0.02
			String valueStr = String.valueOf(value);	// String.valueOf(float f) : 将 float 变量 f 转换成字符串 
			// indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置	
			// str.substring(int startIndex);截取掉str从首字母起长度为startIndex的字符串，将剩余字符串赋值给str
			String fxStr = "0" + valueStr.substring(valueStr.indexOf("."));	// 小数部分
			float fx = Float.parseFloat(fxStr);
			String fxb = toBin(fx);	//小数部分二进制
			String e = zschange2(127 + zsb.length() - 1);	// 计算阶码的二进制
			e = String.format("%1$08d",Integer.valueOf(e));	// 如果阶码不满8位，则在前面加0，满足8位，则不变；
			String m = zsb.substring(1) + fxb;	// //尾数位
			// 尾数需要加1的情况
			char[] ch = m.toCharArray();	// 将字符串转化为数组
			if(ch[23]=='1') {
				if(ch[22]=='0'){           //最后一位是0，直接加1
		            ch[22]='1';
		        }
		        else{                     //最后一位如果是1
		            ch[22]='0';
		            for (int i =21; i>0; i--) {
		                //从低位往高位遍历，找到第一个为0的数，把该位加1，再把该位到21位（含21）的数全部取0
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
			m = String.valueOf(ch); // 数组转字符串
			String result = sflag + e + m;	// 把符号位，阶码，位数拼接起来
			// 取32位，不够32位后面+0，超过32位截取0-31
			while (result.length() < 32) {
				result += "0";
			}
			if (result.length() > 32) {
				result = result.substring(0, 32);
			}
			return result;
		}
		else {	// 浮点数小于1时或大于-1时
			//小数部分，格式： 0.02
			//  小于1时可直接进行转换二进制
			String fxb1 = toBin(value);	//小数部分二进制
			String fixStr1="0."+fxb1;
			int count=(int) fixStr1.indexOf("1");
			String e = zschange2(127-(count-1));	// 计算阶码的二进制
			e = String.format("%1$08d",Integer.valueOf(e));	// 如果阶码不满8位，则在前面加0，满足8位，则不变；
			String m = fixStr1.substring(fixStr1.indexOf("1")+1);	// //尾数位：获取第一个1的位置，+1后截取后面的字符串作为尾数
			String result = sflag + e + m;	// 把符号位，阶码，位数拼接起来
			// 取32位，不够32位后面+0，超过32位截取0-31
			while (result.length() < 32) {
				result += "0";
			}
			if (result.length() > 32) {
				result = result.substring(0, 32);
			}
			return result;
		}
		
	}
 
	// 小数部分取二进制
	private static String toBin(float f) {
//		StringBuilder 对字符串的操作是直接改变字符串对象本身，而不是生成新的对象	使用字符串拼接的时候可以用StringBuilder	StringBuilder对象会自动生成一个16位的字符数组
		StringBuilder stringBuilder = new StringBuilder();
		int count = 32; // 限制小数部分位数最多为32位，如果超过32则停止
        float num = 0;
        while (f > 0.0000000001) {	// 浮点数存储精度范围为0.0000000001
            count--;
            if (count == 0) {
               break;
            }
            num = f * 2;
            if (num >= 1) {
                stringBuilder.append(1);	// builder.append():作用->追加数据
                f = num - 1;	// +1之后要减去1继续下面的运算
            } else {
                stringBuilder.append(0);
                f = num;	// 小于1时追加0，这时num继续下次运算
            }
        }
        String result=String.valueOf(stringBuilder);	// 强转为字符串
        return result;
	}
	
	// 浮点数转16进制
	// 二进制转十六进制
	public static String fdchange6(float positive6) {
		String str;
		str=floatToIEEE754(positive6);
		
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
