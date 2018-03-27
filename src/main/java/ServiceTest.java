import static org.junit.Assert.*;

import org.junit.Test;

public class ServiceTest
{
	@Test
	public void test()
	{
		Service service = new Service();
		
		service.addAccount("Matt", "Moore", 0);
		assertTrue(service.retrieveAccount(0).getAccountNumber() == 0);
		service.addAccount("Nick", "Watton", 1);
		assertTrue(service.retrieveAccount(1).getAccountNumber() == 1);
		service.addAccount("Anirban", "Biswas", 2);
		assertTrue(service.retrieveAccount(2).getAccountNumber() == 2);
		service.addAccount("Andrew", "McGill", 3);
		assertTrue(service.retrieveAccount(3).getAccountNumber() == 3);
		
		service.removeAccount(3);
		service.removeAccount(2);
		service.removeAccount(1);
		service.removeAccount(0);
	}
}