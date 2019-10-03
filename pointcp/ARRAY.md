Olivia Borel
300075826
Assigment 1, Question 7

*the code used is copy/pasted at end of the note.


Part a)

	After running the code 10 times, the following data was collected:

		    |  MEAN   |  MEDIAN  |  MIN.  |  MAX.  | 

	LinkedList  |  12023  |   11724  |  9926  |  14415 |

	ArrayList   |  11096  |   10517  |  9802  |  14286 |

	Array       |  1555   |   1475   |  1403  |  1732  |


	note: all values are in ms.



Part b)

	After running the code 10 times, the following data was collected:

		    |  MEAN  |  MEDIAN |  MIN.  |  MAX.  | 

	LinkedList  |  5205  |   3082  |  1721  |  11511 |

	ArrayList   |  844   |   829   |  268   |  1683  |

	Array       |   67   |   65    |   62   |   89   |


	note: all values are in ms.


Conclusion/Recommendation:

	Based on the tests summarized above, one can conclude that the array is the 
	most efficient during these runs. 
	While a simple array does have its limitations (such as a set size), 
	it is very quick at populating itself and in adding the values stored within it. 
	It is also worth noting that while LinkedList and ArrayList are fairly close in results, 
	ArrayList is consistently faster than LinkedList. 

	With these observations in mind, 
	one could recommend designers to use arrays when performing simple tasks such as these. 
	The results prove that an array is significantly faster than a LinkedList or ArrayList 
	when populating itself with random floats, and when adding those floats together. 
	However, it is important for designers to keep in mind what their tasks and goals are 
	when designing a program. While speed is extremely important, 
	it is also important to implement designs that can be easily manipulated, stored, 
	and used with the task at hand.







Below is the code for the testing of LinkedList, ArrayList, and array consecutively. 
First the list/array is made, and then it is timed while the values are being added.


import java.util.*;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;
public class ArrayTests{
   public static void main(String args[]){


    //Test the LinkedList
      LinkedList<Double> LLList=new LinkedList<Double>();
      int i = 0;
      double min = 0.0;
      double max = 9.0;

      for(i=0;i<40000000;i++){
        double random = min + Math.random() * (max - min);
        LLList.add(random);
      }

      Iterator<Double> iterator = LLList.iterator();
      double sum = 0;

      Instant start = Instant.now();

        while(iterator.hasNext()){
          double n = iterator.next();
          sum += n;
        }

      Instant finish = Instant.now();
      long timeElapsed = Duration.between(start, finish).toMillis();

      System.out.println("Time elapsed for LinkedList: "+ timeElapsed);
      LLList.clear();


    //Test the ArrayList
      ArrayList<Double> ALList = new ArrayList<Double>();

      for(i=0;i<40000000;i++){
        double random = min + Math.random() * (max - min);
        ALList.add(random);
      }

      Iterator<Double> iter = ALList.iterator();

      start = Instant.now();

        while(iter.hasNext()){
          double m = iter.next();
          sum += m;
        }

      finish = Instant.now();
      timeElapsed = Duration.between(start, finish).toMillis();

      System.out.println("Time elapsed for ArrayList: "+timeElapsed);
      ALList.clear();


    //Test the array
      double arr[] = new double[40000000];

      for(i=0;i<40000000;i++){
        double random = min + Math.random() * (max - min);
        arr[i] = random;
      }

      start = Instant.now();

        for (double j : arr)
          sum += i;

      finish = Instant.now();
      timeElapsed = Duration.between(start, finish).toMillis();

      System.out.println("Time elapsed for array: "+timeElapsed);

   }
}
