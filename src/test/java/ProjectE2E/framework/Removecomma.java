package ProjectE2E.framework;

import org.testng.Assert;

public class Removecomma {

	public static void main(String[] args) {
		

		String price= "50,000";
		String finalPrice= price.replaceAll(",","");
		
		System.out.println(finalPrice);
		int pri = Integer.parseInt(finalPrice);
		if(pri>10000)
		{
			Assert.assertTrue(true);
		}

	}

}
