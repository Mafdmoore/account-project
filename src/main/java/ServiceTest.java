import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ServiceTest
{
	@Test
	public void test() throws JsonProcessingException
	{
		Service service = new Service();
		String jsonMap;
		String jsonOutput = "{\"0\":{\"accountNumber\":0,\"firstName\":\"Matt\",\"lastName\":\"Moore\"},\"1\":{\"accountNumber\":1,\"firstName\":\"Nick\",\"lastName\":\"Watton\"},\"2\":{\"accountNumber\":2,\"firstName\":\"Anirban\",\"lastName\":\"Biswas\"},\"3\":{\"accountNumber\":3,\"firstName\":\"Andrew\",\"lastName\":\"McGill\"}}";
		
		service.addAccount("Matt", "Moore", 0);
		assertTrue(service.retrieveAccount(0).getAccountNumber() == 0);
		service.addAccount("Nick", "Watton", 1);
		assertTrue(service.retrieveAccount(1).getAccountNumber() == 1);
		service.addAccount("Anirban", "Biswas", 2);
		assertTrue(service.retrieveAccount(2).getAccountNumber() == 2);
		service.addAccount("Andrew", "McGill", 3);
		assertTrue(service.retrieveAccount(3).getAccountNumber() == 3);
		
		jsonMap = service.translateAccountMap();
		assertEquals(jsonMap, jsonOutput);
		
		service.removeAccount(3);
		service.removeAccount(2);
		service.removeAccount(1);
		service.removeAccount(0);
	}
}