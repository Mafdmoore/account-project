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
		jsonOutput = "{\"0\":{\"accountNumber\":0,\"firstName\":\"Matt\",\"lastName\":\"Moore\"},\"1\":{\"accountNumber\":1,\"firstName\":\"Nick\",\"lastName\":\"Watton\"},\"2\":{\"accountNumber\":2,\"firstName\":\"Anirban\",\"lastName\":\"Biswas\"},\"3\":{\"accountNumber\":3,\"firstName\":\"Andrew\",\"lastName\":\"McGill\"}}";
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
		assertEquals(jsonMap, jsonOutput);
	}
	
	@Test
	public void countAccountsTest()
	{
		accountCount = service.countAccounts("Andrew");
		assertEquals(accountCount, 2);
	}
}