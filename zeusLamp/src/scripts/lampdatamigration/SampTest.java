package scripts.lampdatamigration;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SampTest {


	public static void main(String ar[]){
		/*String value="<strong>VMware Virtual SAN Helps Adobe Realize Vision of Software-Defined Data Center</strong><br><br>As subscriptions to Adobe Marketing Cloud increased, the storage team had difficulties scaling the platform because of the legacy direct-attached storage (DAS) architecture. Since a traditional storage-area network (SAN) solution would be too expensive and complex and a physical overhaul of the storage infrastructure was out of the question, the team explored a virtual solution. After all, Adobe’s computing resources were already virtualized using VMware vSphere—why not do the same for storage? Adobe explored VMware Virtual SAN and determined it was exactly the kind of solution they needed. The results? Virtual SAN not only delivered a cost-effective solution, it also outperformed traditional SAN and DAS solutions. And since system administrators can operate Virtual SAN with no additional training, Adobe can devote their highly skilled storage experts to strategic projects and increase overall operations efficiency.";


		if(value.contains("<strong>")){
			value=value.replaceAll("<strong>", "");
		}

		if(value.contains("</strong>")){
			value=value.replaceAll("</strong>", "");
		}

		if(value.contains("<br>")){
			value=value.replaceAll("<br>", "");
		}

		if(value.contains(" ")){
			value=value.replaceAll(" ", "_");
		}

		 String nodePath = value.substring(0, 20);
		 nodePath=nodePath.toLowerCase();
			System.out.println(nodePath);*/



		//get yesterday date
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = cal.getTime();

		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");

		Date today = Calendar.getInstance().getTime();

		String reportDate = date.format(yesterday);

		String dateFortmat[]=reportDate.split(" ");

		String mondate[]=dateFortmat[0].split("-");

		String mon=mondate[1];
		String dd=mondate[2];

		Format formatter = new SimpleDateFormat("MMM");
		String sd1 = formatter.format(yesterday);
		System.out.println(sd1+" "+reportDate);

		
		// today date
		reportDate = date.format(today);

		String dateFortmat1[]=reportDate.split(" ");

		String mondate1[]=dateFortmat1[0].split("-");

		mon=mondate1[1];
		String dd1=mondate1[2];
		
		String sd2 = formatter.format(today);
		System.out.println(sd2+" "+reportDate);






	}
}
