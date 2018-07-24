package classes.utilities;



import com.arsin.ArsinSeleniumAPI;

/**
* This class has methods for actions performed on EMS Login page.
* @author John 
*/

public class OpenURLs {

	ArsinSeleniumAPI oASelFW;

	  public OpenURLs(ArsinSeleniumAPI oASelFW)
	  {
	    this.oASelFW = oASelFW;
	  }
	  
	  
	  /**
	   * This methods Opens another URL in between script like if you want to navigate Other portal
	   * @param url
	   * @param instance
	   */
	  public void openUrl(String url, String instance){
		  String actualUrl=oASelFW.getURL(url,instance);
		  System.out.println("URL*********:"+actualUrl);
		  oASelFW.effecta("openURL",actualUrl);
	  }  
	  /**
	   * @author sharath_dhava
	   * @throws Exception
	   * This method will close the Browser
	   */
	  public void Close_Browser() throws Exception
	  {
		  oASelFW.driver.close();
	  }
	
	  
	  public void shiftToNewWindow(){
		  String s[]=oASelFW.effectaArray("getAllWindowNames");
		  oASelFW.effecta("selectWindow",s[1]);
	  }
	 /* public void openRSURL(String localeURL) throws InterruptedException{
		  oASelFW.effecta("waitForElementPresent","link=VMware Store","200");
		  Thread.sleep(5000);
		  Thread.sleep(5000);
		  UtilityMethods utility = new UtilityMethods(oASelFW);
		  localeURL=utility.getValidationMsg("constant", localeURL);
		  oASelFW.driver.get(localeURL);
	  }*/
}
