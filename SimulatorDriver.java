
import java.util.ArrayList;
import java.util.Hashtable;

public class SimulatorDriver 
{
	public static void main(String args[])
	{
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		// Generate number of students.
		int totalStudents = (int) ((Math.random() * 30) + 3);
		
		int count = 0;
		
		for (int a = 0; a < totalStudents; a++) 
		{
			// Add students in student list with random ID.
			studentList.add(new Student ((int) ((Math.random() * 100000))));
		}
		
		int[] studentID = new int[studentList.size()];
		
		for (int a = 0; a < totalStudents; a++) 
		{
			studentID[a] = studentList.get(a).getId();
		}

		iVoteConfig ivote = new iVoteConfig(studentID);
		System.out.println("Number of Students: " + totalStudents + "\n\nWelcome to the iVote Simulator!\n");
		
		// Display Question #1
		Question question1 = new Question("1. Does this poll work?\n A: Yes \n B: No \n", "A");
		System.out.println(question1.getQuestion());
		
		int randomNumber = (int) ((Math.random() * 10) + 1);
		
		for (int a = 0; a < totalStudents; a++) 
		{
			while (true)
			{
				if (randomNumber != 0)
				{
					ivote.submitedAnswers(random(studentList, totalStudents, question1, 2));
					randomNumber--;
					count++;
				} 
				else 
				{
					ivote.countNumberOfSubmissions(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}		
		ivote.displayCorrectAnswer(question1, totalStudents);
		ivote.answerCount(2);
		System.out.println("---------------------------------------------------------------\n");
		
		// Display Question #2
		Question question2 = new Question("2. What is the course ID?\n A: 3750\n B: 3650\n C: 3560\n", "C");
		System.out.println(question2.getQuestion());
		for (int a = 0; a < totalStudents; a++)
		{
			while(true)
			{
				if (randomNumber != 0)
				{
					ivote.submitedAnswers(random(studentList, totalStudents, question2, 3));
					randomNumber--;
					count++;
				} 
				else 
				{
					ivote.countNumberOfSubmissions(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 10) + 1);
		}
		
		ivote.displayCorrectAnswer(question2, totalStudents);
		ivote.answerCount(3);
		System.out.println("---------------------------------------------------------------\n");
		
		// Display Question #3
		Question question3 = new Question("3. What programming language are we using?\n "
				+ "A: Java\n B: C++\n C: Dart\n D: Python", "A");
		System.out.println(question3.getQuestion());
		for (int a = 0; a < totalStudents; a++)
		{
			while(true)
			{
				if(randomNumber != 0)
				{
					ivote.submitedAnswers(random(studentList, totalStudents, question3, 4));
					randomNumber--;
					count++;
				}
				else 
				{
					ivote.countNumberOfSubmissions(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 20) + 1);
		}		
		ivote.displayCorrectAnswer(question3, totalStudents);
		ivote.answerCount(4);
		System.out.println("---------------------------------------------------------------\n");
		
		// Display Question #4
		Question question4 = new Question("4. What variable should be used for whole numbers?\n A: double \n B: boolean \n C: float \n D: int", "D");
		System.out.println(question4.getQuestion());
		for (int a = 0; a < totalStudents; a++)
		{
			while(true)
			{
				if (randomNumber != 0)
				{
					ivote.submitedAnswers(random(studentList, totalStudents, question4, 4));
					randomNumber--;
					count++;
				} 
				else 
				{
					ivote.countNumberOfSubmissions(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 20) + 1);
		}		
		ivote.displayCorrectAnswer(question4, totalStudents);
		ivote.answerCount(4);
		System.out.println("---------------------------------------------------------------\n");
		
		// Display Question #5
		Question question5 = new Question("5. Is Java object oriented?\n A: Yes \n B: No \n", "A");
		System.out.println(question5.getQuestion());
		for (int a = 0; a < totalStudents; a++)
		{
			while(true)
			{
				if (randomNumber != 0)
				{
					ivote.submitedAnswers(random(studentList, totalStudents, question5, 2));
					randomNumber--;
					count++;
				} 
				else 
				{
					ivote.countNumberOfSubmissions(count);
					ivote.displaySubmissions(studentID[a]);
					break;
				}
			}
			count = 0;
			randomNumber = (int) ((Math.random() * 20) + 1);
		}		
		ivote.displayCorrectAnswer(question5, totalStudents);
		ivote.answerCount(2);
		System.out.println("---------------------------------------------------------------\n");
	}
	
	// Generates random answers.
	private static Hashtable<Integer, String> random (ArrayList<Student> studentList, int numberOfStudents, Question question, int numberOfAnswers){
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		
		for(int a = 0; a < numberOfStudents; a++)
		{
			if (question.getAnswer().length() == 1)
			{
				studentList.get(a).chooseAnswer(numberOfAnswers);
			} 
			else 
			{
				studentList.get(a).chooseMultiple(numberOfAnswers);
			}
		}
		
		for (int a = 0; a < numberOfStudents; a++)
		{
			hash.put(studentList.get(a).getId(), studentList.get(a).answer);
		}
		return hash;
	}
}
