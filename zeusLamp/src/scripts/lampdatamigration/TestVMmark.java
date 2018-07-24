package scripts.lampdatamigration;


import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.jcr.LoginException;
import javax.jcr.NoSuchWorkspaceException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.collections.MultiMap;

import classes.lampdatamigration.BaseClass;
import classes.lampdatamigration.RetrieveNode;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestVMmark {

	public static void main(String[] args) throws LoginException, NoSuchWorkspaceException, IOException, RepositoryException, BiffException {
		
		Properties prop2 = new Properties();
		prop2.load(RetrieveNode.class.getClassLoader().getResourceAsStream("sharath_poc//config.properties"));
		String filePath1 = prop2.getProperty("FilePath");
		
		
		
		BaseClass bc1 = new BaseClass();
		Session s1 = bc1.getSession();
		String nodePath1 = bc1.getNodePath("");
		Node n3 = bc1.getRelativeNode(s1, nodePath1);
		MultiMap m3 = bc1.getPropertyMapa(n3);
		
		//Verification for sample property
		Workbook wb = Workbook.getWorkbook(new File(filePath1));
		String propName1  = wb.getSheet(0).getCell(2,2).getContents();
		String propVal1  = wb.getSheet(0).getCell(3,2).getContents();
		
		boolean b2 = bc1.validateProperty(m3, propName1, propVal1);
		System.out.println(b2);
		
	}

}