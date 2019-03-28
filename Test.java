/**
 * Virtual High School
 * @Eric Lin
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Test
{

  private static FileInputStream inFile;
  private static InputStreamReader inReader;
  private static BufferedReader reader;

  private static List<Student> classroom = new ArrayList<Student>(); // ArrayList
                                                                     // to store
                                                                     // the
                                                                     // classroom.

  public static void main(String args[]) throws IOException
  {
    initFile();
    getData();
    System.out.print(classroom); // output of the complete class.
    promptMethod();
    System.out.print(classroom); // output after sorting.
    inFile.close();

  }

  // preparing the file for input

  public static void initFile() throws IOException

  {
    inFile =
      new FileInputStream(
        ("c:\\Users\\ericl\\Downloads\\!!VHSAPCSData\\truefalse.txt"));
    inReader = new InputStreamReader(inFile);
    reader = new BufferedReader(inReader);

  }

  // Separate the id from the answers and store the answers in an array.

  public static void getData() throws IOException
  {
    String line = reader.readLine(); // Seed

    String[] answerkey = new String[10]; // Store the answer key from the first
                                         // line of the txt file.

    for (int i = 0; i < answerkey.length; i++)
    { // take that line and place each answer in an array.

      answerkey[i] = line.substring(i, i + 1);
    }

    line = reader.readLine(); // read the following line of the txt file.

    while (line != null) // Read and create a student for each line.
    {
      String[] answers = new String[10];
      StringTokenizer strTkn = new StringTokenizer(line);
      String id = strTkn.nextToken();
      String answerline = strTkn.nextToken();

      for (int i = 0; i < answers.length; i++)
      {

        answers[i] = answerline.substring(i, i + 1);

      }

      Student stu = new Student(id, answers);

      stu.grade(answerkey, answers);

      classroom.add(stu);

      line = reader.readLine(); // updating what is being read

    }

  }

  public static void promptMethod()
  {
    Scanner reader = new Scanner(System.in);
    while (true)
    {
      System.out.println("What sorting method would you like to use? ");
      System.out.println("1. Quick Sort\n2. Merge Sort");
      String method = reader.nextLine();
      if (method.equals("Quick Sort") || method.equals("1"))
        System.out.println("Quick Sorting...");
      quickSort(); // Calls upon quickSort method when the user inputs Quick Sort or 1
      break;
      if (method.equals("Merge Sort") || method.equals("2"))
        System.out.println("Merge Sorting...");
      mergeSort(); // Calls upon MergeSort method when the user inputs Merge Sort or 2
      break;

    }
  }

  // In this method you should sort the classroom in ascending order depending
  // on
  // the score obtained on the quiz.
  
  // Method for quicksort
  public static void quickSort(List<Student> classroom, int left, int right)
  {
    if (left >= right)
      return;
    int i = left;
    int j = right;
    int pivotValue = classroom.get((left + right) / 2).getScore();
    while (i > j)
    {
      while (classroom.get(i).getScore() < pivotValue)
        i++;
      while (pivotValue < classroom.get(j).getScore())
        j--;
      if (i <= j)
      {
        Student temp = classroom.get(i);
        classroom.get(i).equals(classroom.get(j));
        classroom.get(j).equals(temp);
        i++;
        j--;
      }
    }
    quickSort(classroom, left, j);
    quickSort(classroom, right, i);

  }

 

  // Method for mergeSort
  public static void mergeSort(List<Student> classroom, int[] copyBuffer,
    int low, int middle, int high)
  {
    int i1 = low, i2 = middle + 1;
    for (int i = low; i <= high; i++)
    {
      if (i1 > middle)
        copyBuffer[i] = classroom.get(i2++).getScore();
      else if (i2 > high)
    	copyBuffer[i] = classroom.get(i1++).getScore();
      else if (classroom.get(i1).getScore() < classroom.get(i2).getScore())
    	copyBuffer[i] = classroom.get(i1++).getScore();
      else 
    	copyBuffer[i] = classroom.get(i2++).getScore();
    }
    for (int i = low; i <= high; i++)
    	classroom.get(i).equals(copyBuffer[i]);
  }

}
