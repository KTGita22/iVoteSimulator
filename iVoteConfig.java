
import java.util.Hashtable;

public class iVoteConfig implements VotingService
{
	Hashtable<Integer, String> table = new Hashtable<Integer, String>();

	private int[] IDs;
	
	private int submissionTotal = 0;
	
	public iVoteConfig(int[] IDs) 
	{
		this.IDs = IDs;
	}

	public void answerCount(int answers) 
	{
		
		int A = 0, B = 0, C = 0, D = 0;

		for (int a = 0; a < IDs.length; a++) 
		{
			for (int b = 0; b < table.get(IDs[a]).length(); b++)
			{
				if (table.get(IDs[a]).charAt(b) == 'A') 
				{
					A++;
				}
				if (table.get(IDs[a]).charAt(b) == 'B') 
				{
					B++;
				}
				if (table.get(IDs[a]).charAt(b) == 'C') 
				{
					C++;
				}
				if (table.get(IDs[a]).charAt(b) == 'D') 
				{
					D++;
				}
			}
		}
		
		if(answers == 2)
		{
			System.out.println("Total answers: ");
			System.out.println("A: " + A + "\nB: " + B + "\n");
		}
		else if (answers == 3)
		{
			System.out.println("Total answers: ");
			System.out.println("A: " + A + "\nB: " + B + "\nC: " + C + "\n");
		} 
		else if (answers == 4)
		{
			System.out.println("Total answers: ");
			System.out.println("A: " + A + "\nB: " + B + "\nC: " + C + "\nD: " + D + "\n");
		} 
	}

	public void displayCorrectAnswer(Question question, int numberOfStudents) 
	{
		int totalRight = 0;
		int totalWrong = 0;
		for (int a = 0; a < numberOfStudents; a++)
		{
			if (question.getAnswer().equals(table.get(IDs[a]))) 
			{
				System.out.println("Student" + "(" + IDs[a] + ") selected " + table.get(IDs[a]) + ", and got it right!\n");
				totalRight++;
			} 
			else 
			{
				System.out.println("Student" + "(" + IDs[a] + ") selected " + table.get(IDs[a]) + ", and got it wrong.\n");
				totalWrong++;
			}
		}
	
		System.out.println("Total right answers: " + totalRight + "\n");
		System.out.println("Total wrong answers: " + totalWrong + "\n");
	}

	public void submitedAnswers(Hashtable<Integer, String> studentAnswers)
	{
		this.table = studentAnswers;
	}

	public void displayQuestion(Question question)
	{
		System.out.println(question.getQuestion());
	}

	public void countNumberOfSubmissions(int n)
	{
		this.submissionTotal = n;
	}

	public void displaySubmissions(int ID)
	{
		if (submissionTotal == 1)
		{
			System.out.println("Student(" + ID + ") submitted answer: " + submissionTotal + " time.\n");
		} 
		else 
		{
			System.out.println("Student(" + ID + ") submitted answer: "  + submissionTotal + " times.\n");
		}
	}
}
