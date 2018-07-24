package classes.utilities;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UTF8 {
	 public static void main(String[] args) {
	    
		  String sss =""+""+""+"";
		  System.out.println(sss.length());
		 String s="http://aem-test-auth-1.vmware.com:8080/assets.html/content/dam/digitalmarketing/vmware/en/pdf";
	     String path[]=s.split("content/");
	     String[] ss= path[1].split("/", 2);
	     System.out.println(ss[1]);
		 String utf8tweet = "";
	        try {
	            byte[] utf8Bytes = "#Hello twitter NTTコミュニケーションズ株式会社  How are you?".getBytes("UTF-8");

	            utf8tweet = new String(utf8Bytes, "UTF-8");

	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	        Pattern unicodeOutliers = Pattern.compile("[^\\x00-\\x7F]",
	                Pattern.UNICODE_CASE | Pattern.CANON_EQ
	                        | Pattern.CASE_INSENSITIVE);
	        Matcher unicodeOutlierMatcher = unicodeOutliers.matcher(utf8tweet);

	        System.out.println("Before: " + utf8tweet);
	        utf8tweet = unicodeOutlierMatcher.replaceAll(" ");
	        System.out.println("After: " + utf8tweet);
		 
		 /*String s="3.0";
		 
		 int i=Integer.parseInt(s);*/
		 
		/* int i=3.0;
		 String s=String.valueOf(i);
		 
		 System.out.println("&&&&&&&&&&&&&&"+i);
				 */
		 
	    }

}
