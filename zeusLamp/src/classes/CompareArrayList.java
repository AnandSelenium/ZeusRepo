package classes;

import java.util.ArrayList;
import java.util.Collections;

public class CompareArrayList {

	public static void main(String[] args) {
		/*ArrayList<String> ar1 = new ArrayList<String>();
		ar1.add("sd");
		ar1.add("dd");
		ArrayList<String> ar2= new ArrayList<String>();
		ar2.add("sd");
		ar2.add("dd");
		//ar2.add(" ");
		System.out.println(ar2.containsAll(ar1));*/
		/*if(!Collections.disjoint(ar2, ar1))
		{
			System.out.println("Pass");
		}*/

		
		String s1="English NorAm Vmware vSphere with Operations Management Software-Defined Data Center Business Decision-Maker Awareness PDF United States Brochure";
		String s2="english_noram_vsphere-with-operations-management_Software-Defined_Data_Center_business-decision-maker_awareness_PDF_united-states_brochure";
		
		System.out.println(s1=s1.replaceAll("[^A-Za-z0-9]+", "").toLowerCase());
		System.out.println(s2=s2.replaceAll("[^A-Za-z0-9]+", "").toLowerCase());
		String s3=s1.replaceAll("vmware","").trim();
		System.out.println(s3);
		if(s1.equalsIgnoreCase(s2))
		{
			System.out.println("true");
		}
		else if(s3.replaceAll(" ","").equalsIgnoreCase(s2.replaceAll(" ","")))
		{
			System.out.println("true");
		}
	}

}
