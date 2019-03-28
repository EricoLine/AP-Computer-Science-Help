/**
 * Virtual High School
 * @Eric Lin
 */

import java.util.*;

public class Student
{

  private String id;
  private String[] quizresult = new String[10];
  public int score;
  public char letterGrade;

  // Skims through the quizresult array
  public Student()
  {

    id = " ";
    for (int i = 0; i < quizresult.length; i++)
    {
      quizresult[i] = "";

    }

    score = 0;
  }

  // Fills in the variables and objects with the values imported from the data
  // file
  public Student(String a, String[] answers)
  {

    id = a;

    for (int i = 0; i < answers.length; i++)
    {

      quizresult[i] = answers[i];

    }

    score = 0;

  }

  /**
   * 
   * @returns quiz answers
   **/
  public String[] getAnwers()
  {

    return quizresult;

  }

  /**
   * 
   * @return student id
   */
  public String getId()
  {

    return id;

  }

  /*
   * Compares the answerkey with studentanswer. If the studentanswer values
   * equal the answerkey values, then it adds 10 points to the student's sore
   */
  public void grade(String[] answerkey, String[] studentanswer)
  {

    int count = 0;

    for (int i = 0; i < answerkey.length; i++)
    {

      if (answerkey[i].equals(studentanswer[i]))
      {

        count = count + 10;

      }

    }

    score = count;
    letterGrade(score); // Letter grade to score

  }

  // Assigns letter grade depending on the value of the score
  public void letterGrade(int score)
  {
    if (score == 100)
      letterGrade = 'A';
    else if (score >= 90)
      letterGrade = 'B';
    else if (score >= 70)
      letterGrade = 'C';
    else if (score >= 50)
      letterGrade = 'D';
    else
      letterGrade = 'F';

  }
  public int getScore() {
    return score;
  }


  // toString method that prints the final results of the student
  /**
   * @return String of student ID, quiz answers, and score based on a letter
   *         scale.
   */
  public String toString()
  {

    String a =
      "Student id: " + id + " " + Arrays.toString(quizresult)
        + " The score for this quiz is:  " + letterGrade + "\n";

    return a;

  }

