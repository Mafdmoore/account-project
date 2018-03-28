import java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service
{
	private HashMap<Integer, Account> accountMap;
	private int key;
	
	
	public Service()
	{
		this.accountMap = new HashMap<Integer, Account>();
		this.key = 0;
	}
	

	public void addAccount(String firstName, String lastName, int accountNumber)
	{
		accountMap.put(key, new Account(firstName, lastName, accountNumber));
		key++;
	}
	
	public void removeAccount(int key)
	{
		if(accountMap.containsKey(key)) accountMap.remove(key);
	}
	
	public Account retrieveAccount(int key)
	{
		return accountMap.get(key);
	}

	public String translateAccountMap() throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonMap = mapper.writeValueAsString(accountMap);
		System.out.println(jsonMap);
		
		
		return jsonMap;
	}

	public int countAccounts(String firstName)
	{
		return (int)accountMap.values().stream().filter(eachAccount -> eachAccount.getFirstName().equals(firstName)).count();
	}
}