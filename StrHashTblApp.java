import java.io.*;

class DataItem
{
	String sDat;

	public String getKey() 
	{
		return sDat;
	}
	
	DataItem (String s)
	{
		sDat=s;
	}
	
}

class StringHashTable
{
	private DataItem nonItem;
	private DataItem[] hashArray;
	private int arrLen;
	
	public StringHashTable(int size) 
	{
		arrLen = size;
		hashArray = new DataItem[arrLen];
		nonItem = new DataItem("-");
	}
	
	public void displayTbl()
	{
		System.out.print("Table : ");
		for(int i = 0; i < arrLen; i++)
		{
			if(hashArray[i] != null)
				System.out.print(hashArray[i].getKey() + " ");
			else
				System.out.print("** ");
		}
		System.out.println();
	}
	
	public int hashFunc(String key) 
	{
		int hshValue = 0;
		for (int i = 0; i < key.length(); i++) 
		{
			int letter = key.charAt(i);
			hshValue = (hshValue * 27 + letter) % arrLen;
		}
		return hshValue;
	}
	
	public void insert(DataItem item) 
	{
		String key = item.getKey(); 
		int hshValue = hashFunc(key);
	
		while(hashArray[hshValue]!=null && hashArray[hshValue].getKey()!="-")
		{
			++hshValue; 
			hshValue %= arrLen; 
		}
		hashArray[hshValue] = item;
	} 
	
	public DataItem delete(String key) 
	{
		
		int hashVal = hashFunc(key); 
		
		while(hashArray[hashVal] != null)
		{
			if(hashArray[hashVal].getKey().equals(key))
			{
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem; 
				return temp;
			}
			++hashVal; 
			hashVal %= arrLen; 
		}
		return null; 
	} 
	public DataItem find(String key) 
	{
		int hashVal = hashFunc(key); 
		while(hashArray[hashVal] != null) 
		{ 
			if(hashArray[hashVal].getKey().equals(key))
			{
				return hashArray[hashVal]; 
			}
			++hashVal; 
			hashVal %= arrLen; 
		}
		return null; 
	}
		
}

public class StrHashTblApp 
{
	public static void main(String[] args) throws IOException
	{
		DataItem aDataItem;
		int size, n, keysPerCell;
		String aKey;
		
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		keysPerCell = 10;
		
		StringHashTable theHashTable = new StringHashTable(size);
		
		for(int j=0; j<n; j++)
		{
			aKey = Double.toString((java.lang.Math.random() * keysPerCell * size));
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		
		while(true)
		{
			System.out.print("Enter first letter of show, insert, delete, or find: ");
			char choice = getChar();
			switch(choice)
			{
				case 's':
					theHashTable.displayTbl();
					break;
				case 'i':
					System.out.print("Enter string to insert: ");
					aKey = getString();
					aDataItem = new DataItem(aKey);
					theHashTable.insert(aDataItem);
					break;
				case 'd':
					System.out.print("Enter string to delete: ");
					aKey = getString();
					theHashTable.delete(aKey);
					break;
				case 'f':
					System.out.print("Enter string to find: ");
					aKey = getString();
					aDataItem = theHashTable.find(aKey);
				
					if(aDataItem != null)
					{
						System.out.println("Found " + aKey);
					}
					else
					{
						System.out.println("Not Found " + aKey);
					}
					break;
				default:
					System.out.println("Invalid entry...");
			}
		}
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		return getString().charAt(0);
	}
	
	
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
	
}
