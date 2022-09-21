
import java.util.Hashtable;

public class iVoteConfig implements VotingService
{
	Hashtable<Integer, String> idTable = new Hashtable<Integer, String>();

	private int[] IDs;
	
	private int submissionTotal = 0;
	
	public iVoteConfig(int[] IDs) 
	{
		this.IDs = IDs;
	}
	
	public void submitedAnswers(Hashtable<Integer, String> studentAnswers)
	{
		this.idTable = studentAnswers;
	}

	
	public void displayQuestion(Question question)
	{
		System.out.println(question.getQuestion());
	}

	public void countNumberOfSubmissions(int n)
	{
		this.submissionTotal = n;
	}

	public void answerCount(int answers) 
	{
		int A = 0, B = 0, C = 0, D = 0;

		for(int a = 0; a < IDs.length; a++) 
		{
			for(int b = 0; b < idTable.get(IDs[a]).length(); b++)
			{
				if(idTable.get(IDs[a]).charAt(b) == 'A') 
				{
					A++;
				}
				if(idTable.get(IDs[a]).charAt(b) == 'B') 
				{
					B++;
				}
				if(idTable.get(IDs[a]).charAt(b) == 'C') 
				{
					C++;
				}
				if(idTable.get(IDs[a]).charAt(b) == 'D') 
				{
					D++;
				}
			}
		}
		
		if(answers == 2)
		{
			System.out.println("Total answers: ");
			System.out.println("A: " + A + " | B: " + B + "\n");
		}
		else if(answers == 3)
		{
			System.out.println("Total answers: ");
			System.out.println("A: " + A + " | B: " + B + " | C: " + C + "\n");
		} 
		else if(answers == 4)
		{
			System.out.println("Total answers: ");
			System.out.println("A: " + A + " | B: " + B + " | C: " + C + " | D: " + D + "\n");
		} 
	}

	public void displayCorrectAnswer(Question question, int numberOfStudents) 
	{
		int totalRight = 0;
		int totalWrong = 0;
		for(int a = 0; a < numberOfStudents; a++)
		{
			if(question.getAnswer().equals(idTable.get(IDs[a]))) 
			{
				System.out.println("Student" + "(" + IDs[a] + ") selected " + idTable.get(IDs[a]) + ", and got it right!\n");
				totalRight++;
			} 
			else 
			{
				System.out.println("Student" + "(" + IDs[a] + ") selected " + idTable.get(IDs[a]) + ", and got it wrong.\n");
				totalWrong++;
			}
		}
		
		System.out.println("The correct answer was: " + question.getAnswer() + ".\n");
		System.out.println("Students with right answers: " + totalRight + " | Students with wrong answers: " + totalWrong + "\n");
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
