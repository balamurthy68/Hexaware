import org.testng.annotations.Test;

public class groupTest {
	  @Test(groups = { "functest", "checkintest" })
	  public void testMethod1() {
		  
		  System.out.println("In first method functional and checkin");
	  }
	 
	  @Test(groups = {"functest", "checkintest"} )
	  public void testMethod2() {
	  
		  System.out.println("In second method functional and checkin ");
	  
	  }
	 
	  @Test(groups = { "smoketest" })
	  public void testMethod3() {
	  
		  System.out.println("In third method this is only functest");
	  }
	}