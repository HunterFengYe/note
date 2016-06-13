package utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
public class StringUtils {
	public static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 将对象转换为json
	 * 
	 * @param obj
	 *            对象
	 * @return 对象为null返回null，否则返回json
	 */
	public static String json(Object obj) {
		if (null != obj) {
			try {
				return MAPPER.writeValueAsString(obj);
			} catch (JsonProcessingException e) {
			}
		}
		return null;
	}
	/**
	 * 字符串转换为int型集合
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static List<Integer> intList(String str) {
		if (null != str && str.length() > 0) {
			List<Integer> list = new ArrayList<Integer>();
			for (String s : str.split(",")) {
				s = s.trim();
				if (!s.isEmpty()) {
					try {
						list.add(Integer.parseInt(s));
					} catch (NumberFormatException e) {
					}
				}
			}
			if (!list.isEmpty()) {
				return list;
			}
		}
		return null;
	}

	/**
	 * 字符串转换为int型数组
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static Integer[] intArr(String str) {
		if (null != str && str.length() > 0) {
			List<Integer> list = new ArrayList<Integer>();
			for (String s : str.split(",")) {
				s = s.trim();
				if (s.length() > 0) {
					try {
						list.add(Integer.parseInt(s));
					} catch (NumberFormatException e) {
					}
				}
			}
			if (!list.isEmpty()) {
				return list.toArray(new Integer[list.size()]);
			}
		}
		return null;
	}

	/**
	 * 字符串转换为long型集合
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static List<Long> longList(String str) {
		if (null != str && str.length() > 0) {
			List<Long> list = new ArrayList<Long>();
			for (String s : str.split(",")) {
				s = s.trim();
				if (!s.isEmpty()) {
					try {
						list.add(Long.parseLong(s));
					} catch (NumberFormatException e) {
					}
				}
			}
			if (!list.isEmpty()) {
				return list;
			}
		}
		return null;
	}

	/**
	 * 字符串转换为long型数组
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static Long[] longArr(String str) {
		if (null != str && str.length() > 0) {
			List<Long> list = new ArrayList<Long>();
			for (String s : str.split(",")) {
				s = s.trim();
				if (s.length() > 0) {
					try {
						list.add(Long.parseLong(s));
					} catch (NumberFormatException e) {
					}
				}
			}
			if (!list.isEmpty()) {
				return list.toArray(new Long[list.size()]);
			}
		}
		return null;
	}

	/**
	 * 字符串转换为String型数组
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static String[] strArr(String str) {
		if (null != str && str.length() > 0) {
			List<String> list = new ArrayList<String>();
			for (String s : str.split(",")) {
				s = s.trim();
				if (s.length() > 0) {
					try {
						list.add(s);
					} catch (Exception e) {
					}
				}
			}
			if (!list.isEmpty()) {
				return list.toArray(new String[list.size()]);
			}
		}
		return null;
	}
	public static String RandomMath(){
		String math="";
		Random ra=new Random();
		for(int i=0;i<8;i++){
			math+=ra.nextInt(10);
		}
		math="U"+math;
		return math;
	}
}
