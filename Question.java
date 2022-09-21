
/* Create Question class, where a Question object contains 
   strings of the question and the answer to it. Includes
   getter and setter methods.
*/ 

public class Question 
{
	private String question;
	private String answer;
	
	public Question(String question, String answer)
	{
		this.setQuestion(question);
		this.setAnswer(answer);
	}

	public void setQuestion(String question) 
	{
		this.question = question;
	}

	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}
	
	public String getAnswer() 
	{
		return answer;
	}
	
	public String getQuestion() 
	{
		return question;
	}
}
