// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
package hw1_q2;

import java.util.Scanner;

class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
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
   public long getMax()              //gets the maximum
	{
	    long max=-1;                //default max value : -1
	    for (long temp : a) {       //foreach loop to compare each element in the array with max
			if(temp > max)
			{
				max=temp;
			}
		}
		return max;                //returns max element in the array or default val (-1) if array is empty
	}
   //----------------------------------------------------------
   public boolean removeMax(long max)  //removes the maximum element from the array
	{
	    boolean b=false;
		b=delete(max);             // deletes the passed parameter from the array
		return b;
	}
   }  // end class HighArray
	
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
	
   public static void main(String[] args)
      {
      int maxSize = 100;            // array max size
      int arrSize=0;
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the number of elements in the array : ");
      arrSize=sc.nextInt();
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array
      if(arrSize!=0)                // taking elements from the user if the array size is not zero
      {
    	  System.out.println("Enter the elements : "); 
    	  for(int i=0;i<arrSize;i++)
    		  arr.insert(sc.nextLong());
      }
      System.out.println("The elements are :");
      arr.display();                // display items

      long arrMaxVal=arr.getMax(); // getting the maximum element in the array
      System.out.println("The maximum element in the array is : "+arrMaxVal);
      
      arr.removeMax(arrMaxVal);
      System.out.println("The elements after deleting the max element are : ");
      arr.display();
      }  // end main()
   }  // end class HighArrayApp
