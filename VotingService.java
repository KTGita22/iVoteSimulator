
import java.util.Hashtable;

public interface VotingService 
{
	public void answerCount(int answers);
	public void displayCorrectAnswer(Question question, int numberOfStudents);
	public void submitedAnswers(Hashtable<Integer, String> table);
	public void displayQuestion(Question question);
	public void countNumberOfSubmissions(int number);
	public void displaySubmissions(int ID);
}
