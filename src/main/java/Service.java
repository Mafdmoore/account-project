import java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service
{
	//ATTRIBUTES
	private HashMap<Integer, Account> m_accountMap;
	private int m_key;
	
	
	//METHODS
	
	//Constructor
	public Service()
	{
		m_accountMap = new HashMap<Integer, Account>();
		m_key = 0;
	}
	
	
	//Add and remove account
	public void addAccount(String firstname, String lastname, int accountnumber)
	{
		m_accountMap.put(m_key, new Account(firstname, lastname, accountnumber));
		m_key++;
	}
	
	public void removeAccount(int key)
	{
		if(m_accountMap.containsKey(key)) m_accountMap.remove(key);
	}
	
	//Retrieve account
	public Account retrieveAccount(int key)
	{
		return m_accountMap.get(key);
	}

	//Translate hashmap to JSON
	public String translateAccountMap() throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonmap = mapper.writeValueAsString(m_accountMap);
		System.out.println(jsonmap);
		
		
		return jsonmap;
	}
}