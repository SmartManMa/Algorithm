package onlincoding;

/** 
  * @description ReplaceSpace.java
  * @author Administrator
  * @date 2017/11/19
  * @version
  */
public class ReplaceSpace {
	private static String str = "We    are Help.";
	public static void main(String[] args) {
		String strWithoutSpace = replace(null);
		System.out.println(strWithoutSpace);
	}
	/** 
	  * replace TODO :
	  * @param str2
	  * @return
	  * @author zhiman
	  * @date 2017/11/19 обнГ9:54:26 
	  */
	private static String replace(String str) {
		if (null == str) {
			throw new NullPointerException();
		}
		return  str.replaceAll("\\s+", "%20");
	}

}
