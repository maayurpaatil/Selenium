package TestClasses;

import org.testng.annotations.Test;

import PagesObjects.HomepageObjects;
import UtilityMethods.BaseClass;

public class Homepage extends BaseClass{

	
	
	 @Test
	public void main12(){
		 HomepageObjects Hp=new HomepageObjects(driver);
		 Hp.GetTitle();
	}

}
