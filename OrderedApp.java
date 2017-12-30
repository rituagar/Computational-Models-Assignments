// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
package hw1_q3;

import java.util.Scanner;

class OrdArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------
   public int find(long searchKey)
      {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

      while(true)
         {
         curIn = (lowerBound + upperBound ) / 2;
         if(a[curIn]==searchKey)
            return curIn;              // found it
         else if(lowerBound > upperBound)
            return nElems;             // can't find it
         else                          // divide range
            {
            if(a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
         }  // end while
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      int j;
      for(j=0; j<nElems; j++)        // find where it goes
         if(a[j] > value)            // (linear search)
            break;
      for(int k=nElems; k>j; k--)    // move bigger ones up
         a[k] = a[k-1];
      a[j] = value;                  // insert it
      nElems++;                      // increment size
      }  // end insert()
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j = find(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   	public void merge(OrdArray x,OrdArray y) //merges the 2 arrays
   	{
   		int n3=x.nElems+y.nElems;     //the size of 3rd arr is the sum of the other 2 arrays
   		for(int j=0,k=0;nElems<n3;)
   		{ 
   			//add the 1st array elements to the destination array until 2nd array elements start becoming larger than the 1st one.
   			
   			while(x.a[j]<y.a[k] && j!=x.nElems) 
   			{
   				a[nElems]=x.a[j];
   				nElems++;
   				j++;
   			}
   			a[nElems]=y.a[k];
   			nElems++;
   			k++;
   		}
   	}
   }  // end class OrdArray
////////////////////////////////////////////////////////////////
class OrderedApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;             // array size
      Scanner sc=new Scanner(System.in);
      OrdArray arr1,arr2,arr3;                  // reference to array
      arr1 = new OrdArray(maxSize);   // create the array
      arr2 = new OrdArray(maxSize);   
      arr3 = new OrdArray(maxSize);   
      
      //taking user inputs for 1st array
      System.out.println("Enter the number of elements in 1st array : ");
      int n1=sc.nextInt();
      System.out.println("Enter the elements : ");
      for (int i=0;i<n1;i++) {
		arr1.insert(sc.nextLong());
	}
      
      //taking user inputs for 2nd array
      System.out.println("Enter the number of elements in 2nd array : ");
      int n2 = sc.nextInt();
      System.out.println("Enter the elements : ");
      for (int i=0;i<n2;i++) {
  		arr2.insert(sc.nextLong());
  	}
      
      arr3.merge(arr1, arr2);         //merging 1st and 2nd arrays and storing in the 3rd one
      
      // display items 
      System.out.println("1st array : ");
      arr1.display();                 
      System.out.println("2nd array : ");
      arr2.display();
      System.out.println("Merged array : ");
      arr3.display();
      
      sc.close();
      }  // end main()
   }  // end class OrderedApp
