package classes.lampdatamigration;

import java.util.Properties;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.Value;

import org.apache.jackrabbit.commons.JcrUtils;
import com.arsin.ArsinSeleniumAPI;


public class RetrieveNode {
	ArsinSeleniumAPI oASelFW;
	
	public RetrieveNode(){
		
	}
	
	public RetrieveNode(ArsinSeleniumAPI oASelFW){
		this.oASelFW=oASelFW;
	}
	
	public static void main(String[] args) throws RepositoryException {
		
		Properties prop = new Properties();
		
		try {

			prop.load(RetrieveNode.class.getClassLoader().getResourceAsStream("sharath_poc//config.properties"));
			
			String name = prop.getProperty("Username");
			String pwd = prop.getProperty("Password");
			
			String REPO = "http://aem-test-auth-1.vmware.com/crx/server";
	        String WORKSPACE = "crx.default";
	 
	        Repository repository = JcrUtils.getRepository(REPO);
	        Session session = repository.login(new SimpleCredentials(name, pwd.toCharArray()), WORKSPACE);
	        
	        Node root = session.getRootNode(); 
	        
	        // Retrieve content
	       // Node node = root.getNode("content/VMware/en-US/vmglobalheaddata/jcr:content/parsys/utilitybar");
	        Node node = root.getNode("content/vmware/en-US/vmglobalheaddata/jcr:content/parsys/utilitybar");
	        
	        
	        try{
	        	PropertyIterator i1 = node.getProperties();
	        	while(i1.hasNext()){
	        		Property p1 = i1.nextProperty();
	        		if(p1.isMultiple()){
	        			System.out.println("This prop:" +p1.getName()+ " has multiple values. So, printing it below:");
	        			Value[] a1 =  p1.getValues();
	        			for (int j=0;j<a1.length;j++){
	        				 System.out.println(a1[j].getString()); 
	        			 }
	        			System.out.println("-------------------If Closed-------------------");
	        		}
	        		else{
	        			System.out.println("prop name:"+ p1.getName());
		        		System.out.println("prop value:"+ p1.getValue().getString());
		        		System.out.println("------------------Else Closed--------------------");
	        		}
	        			
	        	}
	        	
	        	System.out.println("********************End of File*******************");
	        	
	        }
	        catch (RepositoryException e1){
	        	e1.printStackTrace();
	        }
	        session.logout();
			
			}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
				
	}

}