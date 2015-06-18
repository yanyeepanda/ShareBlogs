package util;
import java.security.MessageDigest;
/**
 * 字符串加密MD5
 * @author zhangm
 *
 */
public class Encode {
	
	/***
	 * 
	 * @param str
	 * @param algorithm
	 * @return 加密后的字符串对象
	 */
	public String encode(String str, String algorithm) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();								//声明并实例化StringBuilder类的对象
		try {
			MessageDigest code = MessageDigest.getInstance(algorithm);		//创建使用MD5加密算法的对象
			code.update(str.getBytes());									//将要加密信息中的所有字节提供给该对象
			byte[] bs = code.digest();										//调用digest方法完成消息摘要的计算，并以字节数组的形式返回消息摘要
			//将加密后的字节数组转换成十六进制的字符串，形成最终的密文
			for (int i = 0; i < bs.length; i++) {
				int v = bs[i] & 0xFF;
				if (v < 16) {
					sb.append(0);
				}
				sb.append(Integer.toHexString(v));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();									//将加密后的字符串中的英文字母转换为大写
	}
	
	public String encodeByMD5(String str){
		return encode(str,"MD5");
	}
}
