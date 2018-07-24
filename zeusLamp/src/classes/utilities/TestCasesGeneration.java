package classes.utilities;

import java.io.File;
import java.util.ArrayList;

public class TestCasesGeneration {

	public static void main(String ar[]){

		File folder = new File("U:\\ZeusLAMP\\src\\scripts\\sit\\search");
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> alist=new ArrayList<String>();
		//StringBuilder commaSepValueBuilder = new StringBuilder();


		for (File file : listOfFiles) {
			if (file.isFile()) {
			//	System.out.println(file.getName());
				alist.add(file.getName());
			}
		}

		/*for(int i=0;i<alist.size();i++){

			//alist.get(i);
			commaSepValueBuilder.append(alist.get(i).replaceAll(".java", ""));

			if ( i != alist.size()-1){
				commaSepValueBuilder.append(",");
			}
		}
		System.out.println("**************************");
		System.out.println("[\""+commaSepValueBuilder.toString()+"\"]");
		System.out.println("**************************");
	}*/
		String output="";
		for(int i = 0; i < alist.size(); i++){ 
			output+="\""+alist.get(i).replaceAll(".java", "")+"\"";
			 if (i < (alist.size() - 1))
			  {
				 output += ",";
			  }
		}
		
		System.out.println("OUTPUT:"+output);
	}

}
