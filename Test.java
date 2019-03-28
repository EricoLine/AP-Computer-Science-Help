import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static BufferedReader reader;

	private static List<Student> classroom = new ArrayList<Student>(); // ArrayList to store the classroom.

	public static void main(String args[]) throws IOException {
		initFile();
		getData();
		System.out.print(classroom); // output of the complete class.
		sort();
		System.out.print(classroom); // output after sorting.
		inFile.close();

	}

	// preparing the file for input

	public static void initFile() throws IOException

	{
		inFile = new FileInputStream("c:\\Users\\Eric lin\\Downloads\\!VHSAPCSData\\truefalse.txt");
		inReader = new InputStreamReader(inFile);
		reader = new BufferedReader(inReader);

	}

	// Separate the id from the answers and store the answers in an array.

	public static void getData() throws IOException {
		String line = reader.readLine(); // Seed

		String[] answerkey = new String[10]; // Store the answer key from the first line of the txt file.

		for (int i = 0; i < answerkey.length; i++) { // take that line and place each answer in an array.

			answerkey[i] = line.substring(i, i + 1);
		}

		line = reader.readLine(); // read the following line of the txt file.

		while (line != null) // Read and create a student for each line.
		{
			String[] answers = new String[10];
			StringTokenizer strTkn = new StringTokenizer(line);
			String id = strTkn.nextToken();
			String answerline = strTkn.nextToken();

			for (int i = 0; i < answers.length; i++) {

				answers[i] = answerline.substring(i, i + 1);

			}

			Student stu = new Student(id, answers);

			stu.grade(answerkey, answers);

			classroom.add(stu);

			line = reader.readLine(); // updating what is being read

		}

	}

	// In this method you should sort the classroom in ascending order depending on
	// the score obtained on the quiz.
	public static void sort() // selection sort
	  {
	    /*
	     * for all except the last index, find the smallest grade from indexes
	     * greater than i. If the grade's index is not i, swap that Student and the
	     * student at index i
	     */
	    for (int i = 0; i < (classroom.size() - 1); i++)
	    {
	      int minIndex = findMin(classroom, i);
	      if (minIndex != i)
	        swap(classroom, i, minIndex);
	    }
	  }

	  // finds the minimum grade of a student from indexes greater than
	  // "firstElement"
	  public static int findMin(List<Student> students, int firstElement)
	  {
	    int minIndex = firstElement; // sets minIndex equal to firstElement

	    // finds the smallest score of a student from indexes greater than
	    // firstElement
	    for (int i = firstElement + 1; i < students.size(); i++)
	    {
	      if ((students.get(i)).score < (students.get(minIndex)).score)
	        minIndex = i;
	    }

	    /*
	     * return the index of the student with the smallest grade from indexes
	     * greater than firstElement
	     */
	    return minIndex;
	  }

	  // swaps the elements at index1 and index2
	  public static void swap(List<Student> students, int index1, int index2)
	  {
	    // temporarily stores the object at index1
	    Student temp = students.get(index1);
	    
	    // swaps the position of the two elements
	    students.set(index1, students.get(index2));
	    students.set(index2, temp);
	  }
	}


