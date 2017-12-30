
import java.io.*;

class Data_Item
{
	int dat;	
	Data_Item (int d)
	{
		dat=d;
	}
	public int getKey() 
	{
		return dat;
	}
}

class HashTable
{
	private Data_Item[] hashArr;
	private int arrLen;
	private Data_Item nonItem;
	
	public HashTable(int size) 
	{
	arrLen = size;
	hashArr = new Data_Item[arrLen];
	nonItem = new Data_Item(-1); 
	}
	
	public void displayTable()
	{
		System.out.print(" Table : ");
		for(int i = 0; i < arrLen; i++)
		{
			if(hashArr[i] != null)
				System.out.print(hashArr[i].getKey() + " ");
			else	
				System.out.print("** ");
		}
		System.out.println();
	}
	
	public int hashFunc(int key) 
	{
		int hshValue = 0;
		int temp = arrLen;
		int grpSize = 1;
		
		while(temp > 0) 
		{
			temp = temp / 10;
			grpSize = grpSize * 10;
		}
		
		while(key > 0) 
		{
			hshValue = hshValue + (key % grpSize);
			key = key / grpSize;
		}
		return hshValue;
	}
	
	
	public void insert(Data_Item item) 
	{
		int key = item.getKey(); 
		int hshValue = hashFunc(key); 
		while(hashArr[hshValue] != null && hashArr[hshValue].getKey() != -1)
		{
			++hshValue; 
			hshValue %= arrLen; 
		}
		hashArr[hshValue] = item; 
	} 

	public Data_Item delete(int key) 
	{
		int hashVal = hashFunc(key);
		while(hashArr[hashVal] != null)
		{ 
			if(hashArr[hashVal].getKey()==key)
			{
				Data_Item temp = hashArr[hashVal]; 
				hashArr[hashVal] = nonItem;
				return temp; 
			}
			++hashVal; 
			hashVal %= arrLen; 
		}
		return null; 
	}
	
	public Data_Item find(int key) 
	{
		int hashVal = hashFunc(key); 
		while(hashArr[hashVal] != null) 
		{ 
			if(hashArr[hashVal].getKey()==key)
			{
				return hashArr[hashVal]; 
			}
			++hashVal;
			hashVal %= arrLen; 
		}
		return null; 
	}	
}

public class FldgHashTblApp 
{
	public static void main(String[] args) throws IOException
	{
		
		int aKey;
		
		int hashTblSize, n, keysPerCell;
		Data_Item aDataItem;
		
		System.out.println("Enter the hash table size : ");
		hashTblSize = getInt();
		System.out.println("Enter initial number of items : ");
		n = getInt();		
		keysPerCell = 10;
		
		HashTable theHashTable = new HashTable(hashTblSize);
		
		for(int i = 0; i < n; i++)
		{
			aKey = (int)(java.lang.Math.random() * keysPerCell * hashTblSize);
			aDataItem = new Data_Item(aKey);
			theHashTable.insert(aDataItem);
		}
		
		for(;;)
		{
			System.out.print("Enter first letter of show, insert, delete, or find : ");
			char choice = getChar();
			switch(choice)
			{
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter number to insert : ");
				aKey = getInt();
				aDataItem = new Data_Item(aKey);
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter number to delete: ");
				aKey = getInt();
				theHashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter number to find: ");
				aKey = getInt();
				aDataItem = theHashTable.find(aKey);
				if(aDataItem != null)
					System.out.println("Found " + aKey);
				else
					System.out.println("Could not find " + aKey);
				break;
			default:
				System.out.println("Invalid entry...");
			}
		}
	}
	public static String getString() throws IOException
	{
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException
	{
		return getString().charAt(0);
	}
	
	public static int getInt() throws IOException
	{
		return Integer.parseInt(getString());
	}
}
