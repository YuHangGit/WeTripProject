package cn.ekgc.bocaiman.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * <b>基础架构-主键生成器</b>
 * <p>
 *     数据库所有数据不再使用主键自增长策略，而是通过本生成器生成主键进行插入
 * </p>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("idGenerator")
public class IdGenerator {
	private static final String KEY_MD5 = "MD5";
	/**
	 * <b>生成主键</b>
	 * <p>
	 *     通过获得当前时间戳后，使用MD5 对其进行加密，<br/>
	 *     该方法属于线程同步的(synchronized)
	 *     当多个浏览器访问的时候，线程安全会让浏览器排队进行访问
	 * </p>
	 */
	public synchronized String nextId() throws Exception{
		//获得当前时间毫秒数
		Long currentTimeMillis = System.currentTimeMillis();
		//对当前时间毫秒数使用MD5加密
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			byte[] inputData = String.valueOf(currentTimeMillis).getBytes("UTF-8");
			byte[] encryptionData = md.digest(inputData);
			for (int i = 0; i < encryptionData.length; i++) {
				int value = ((int) encryptionData[i]) & 0xff;
				if (value < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}
}
