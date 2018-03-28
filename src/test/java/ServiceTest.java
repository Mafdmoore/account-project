import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ServiceTest
{
	Service service;
	String jsonMap;
	String jsonOutput;
	int accountCount;
	
	@Before
	public void setUp()
	{
		service = new Service();
		jsonOutput = "{\"0\":{\"firstName\":\"Matt\",\"lastName\":\"Moore\",\"accountNumber\":0},\"1\":{\"firstName\":\"Nick\",\"lastName\":\"Watton\",\"accountNumber\":1},\"2\":{\"firstName\":\"Anirban\",\"lastName\":\"Biswas\",\"accountNumber\":2},\"3\":{\"firstName\":\"Andrew\",\"lastName\":\"McGill\",\"accountNumber\":3},\"4\":{\"firstName\":\"Andrew\",\"lastName\":\"Prideaux\",\"accountNumber\":4}}";
		accountCount = 0;
		
		service.addAccount("Matt", "Moore", 0);
		service.addAccount("Nick", "Watton", 1);
		service.addAccount("Anirban", "Biswas", 2);
		service.addAccount("Andrew", "McGill", 3);
		service.addAccount("Andrew", "Prideaux", 4);
	}
	
	@After
	public void cleanUp()
	{
		service.removeAccount(4);
		service.removeAccount(3);
		service.removeAccount(2);
		service.removeAccount(1);
		service.removeAccount(0);
	}
	
	@Test
	public void checkElementPresenceTest()
	{
		assertTrue(service.retrieveAccount(0).getAccountNumber() == 0);
		assertTrue(service.retrieveAccount(1).getAccountNumber() == 1);
		assertTrue(service.retrieveAccount(2).getAccountNumber() == 2);
		assertTrue(service.retrieveAccount(3).getAccountNumber() == 3);
	}
	
	@Test
	public void translateAccountMap() throws JsonProcessingException
	{
		jsonMap = service.translateAccountMap();
		assertEquals(jsonOutput, jsonMap);
	}
	
	@Test
	public void countAccountsTest()
	{
		accountCount = service.countAccounts("Andrew");
		assertEquals(2, accountCount);
	}
}