package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import PagesObjects.HomepageObjects;
import UtilityMethods.BaseClass;


public class Homepage extends BaseClass{

	 HomepageObjects Hp=new HomepageObjects(driver);
	
	 @Test
	 @Parameters({"ExpectedTitle"})

	public void VerifyTitleOfHomepage(String ExpectedTitle){
		
		 String ActualTitle=Hp.GetTitle();
		 System.out.println(ActualTitle);
		 Assert.assertEquals(ActualTitle,ExpectedTitle);
	}

}
