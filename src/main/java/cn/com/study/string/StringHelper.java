package cn.com.study.string;

public class StringHelper {
	
	/**
	 * 字符串逆序输出
	 * @param str
	 * @return
	 */
	public static final String reverseStr(String str) {
		String word = "";
		for(int index=str.length()-1; index>=0; --index) {
			System.out.print(str.charAt(index));
			word += str.charAt(index);
		}
		return word;
	}
	
	public static void main(String[] args) {
		StringHelper.reverseStr("LHY");
	}
}