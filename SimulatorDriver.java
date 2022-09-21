
/* Name: Kyle Tam
 * Assignment: iVote Simulator 
 * Course: CS 3560.03
 * Dr. Yu Sun
 * Date: 9-29-2022
 */ 

import java.util.ArrayList;
import java.util.Hashtable;

public class SimulatorDriver 
{
	public static void main(String args[])
	{
		// Create array list of Student objects.
		ArrayList<Student> studentList = new ArrayList<Student>();
		int questionStage = 1;
		
		// Generate number of students.
		int totalStudents = (int) ((Math.random() * 7) + 3);
		
		int count = 0;
		
		for(int a = 0; a < totalStudents; a++) 
		{
			// Add students in student list with random ID.
			studentList.add(new Student ((int) ((Math.random() * 100000))));
		}
		
		// Create and configure array for displaying students' IDs.
		int[] studentID = new int[studentList.size()];
		
		for(int a = 0; a < totalStudents; a++) 
		{
			studentID[a] = studentList.get(a).getId();
		}
		iVoteConfig ivote = new iVoteConfig(studentID);
		
		// Welcome message.
		System.out.println("Number of Students: " + totalStudents + "\n\nWelcome to the iVote Simulator!\n");
		
		// Display Question #1.
		Question question1 = new Question("1. Does this poll work?\n A: Yes \n B: No \n", "A");
		ivote.displayQuestion(question1);
		
		// Generate random number for number of times students submit answers.
		int randomNumber = (int) ((Math.random() * 10) + 1);
		
		for(int a = 0; a < totalStudents; a++) 
		{
			while(randomNumber != 0)
			{
				ivote.submitedAnswers(randomizeAnswerSelection(studentList, totalStudents, question1, 2));
				randomNumber--;
				count++;
			}
			
			ivote.countNumberOfSubmissions(count);
			ivote.displaySubmissions(studentID[a]);
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}
		ivote.displayCorrectAnswer(question1, totalStudents);
		ivote.answerCount(2);
		printNext(questionStage);
		
		// Display Question #2.
		Question question2 = new Question("2. What is the course ID?\n A: 3750\n B: 3650\n C: 3560\n", "C");
		ivote.displayQuestion(question2);
		
		for(int a = 0; a < totalStudents; a++)
		{
			while(randomNumber != 0)
			{
				ivote.submitedAnswers(randomizeAnswerSelection(studentList, totalStudents, question2, 3));
				randomNumber--;
				count++;
			}
			
			ivote.countNumberOfSubmissions(count);
			ivote.displaySubmissions(studentID[a]);
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}
		
		ivote.displayCorrectAnswer(question2, totalStudents);
		ivote.answerCount(3);
		printNext(questionStage);
		
		// Display Question #3.
		Question question3 = new Question("3. What programming language are we using?\n "
				+ "A: Java\n B: C++\n C: Dart\n D: Python\n", "A");
		ivote.displayQuestion(question3);
		
		for(int a = 0; a < totalStudents; a++)
		{
			while(randomNumber != 0)
			{
				ivote.submitedAnswers(randomizeAnswerSelection(studentList, totalStudents, question3, 4));
				randomNumber--;
				count++;
			}
			
			ivote.countNumberOfSubmissions(count);
			ivote.displaySubmissions(studentID[a]);
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}		
		ivote.displayCorrectAnswer(question3, totalStudents);
		ivote.answerCount(4);
		printNext(questionStage);
		
		// Display Question #4.
		Question question4 = new Question("4. What languages are object-oriented?\n "
				+ "A: C-Sharp \n B: Python \n C: Dart \n D: Java\n", "ABD");
		ivote.displayQuestion(question4);
		
		for(int a = 0; a < totalStudents; a++)
		{
			while(randomNumber != 0)
			{
				ivote.submitedAnswers(randomizeAnswerSelection(studentList, totalStudents, question4, 4));
				randomNumber--;
				count++;
			}
			
			ivote.countNumberOfSubmissions(count);
			ivote.displaySubmissions(studentID[a]);
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}		
		ivote.displayCorrectAnswer(question4, totalStudents);
		ivote.answerCount(4);
		questionStage = 2;
		printNext(questionStage);
		
		// Display Question #5.
		Question question5 = new Question("5. Which of the following are Java primitives?\n "
				+ "A: int[]\n B: int\n C: float\n D: final\n", "BC");
		ivote.displayQuestion(question5);
		
		for(int a = 0; a < totalStudents; a++)
		{
			while(randomNumber != 0)
			{
				ivote.submitedAnswers(randomizeAnswerSelection(studentList, totalStudents, question5, 4));
				randomNumber--;
				count++;
			}
			
			ivote.countNumberOfSubmissions(count);
			ivote.displaySubmissions(studentID[a]);
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}		
		ivote.displayCorrectAnswer(question5, totalStudents);
		ivote.answerCount(4);
		questionStage = 3;
		printNext(questionStage);
	}
	
	// Generates a hash table based on the number of students and the given number of question answers.
	private static Hashtable<Integer, String> randomizeAnswerSelection (ArrayList<Student> studentList, int numberOfStudents, Question question, int numberOfAnswers)
	{
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		
		for(int a = 0; a < numberOfStudents; a++)
		{
			// For questions with only one answer choice.
			if(question.getAnswer().length() == 1)
			{
				studentList.get(a).chooseAnswer(numberOfAnswers);
			}
			// For questions with multiple answer choices.
			else 
			{
				studentList.get(a).chooseMultipleAnswers(numberOfAnswers);
			}
			
			hash.put(studentList.get(a).getId(), studentList.get(a).getStudentAnswer());
		}
		return hash;
	}
	
	public static void printNext(int qStage) 
	{	
		if(qStage == 1)
		{
			System.out.println("<------------------- Next Question! ------------------->\n");
		}
		else if(qStage == 2)
		{
			System.out.println("<------------------- Final Question! ------------------->\n");
		}
		else
		{
			System.out.println("<------------------- End of Poll! ------------------->\n");
		}
	}
}
