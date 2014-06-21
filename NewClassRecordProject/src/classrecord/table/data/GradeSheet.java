package classrecord.table.data;

public abstract class GradeSheet extends Displays{
	private String minorExamQuiz1 = "";
	private String minorExamQuiz2 = "";
	private String majorExamMidterm = "";
	private String projectMidterm = "";
	private String minorExamQuiz3 = "";
	private String minorExamQuiz4 = "";
	private String majorExamFinal = "";
	private String projectFinal = "";
	
	public void setQuiz1(String minorExamQuiz1){
		this.minorExamQuiz1 = minorExamQuiz1;
	}
	
	public String getQuiz1(){																																
		return this.minorExamQuiz1;																														
	}																																								
		
	public void setQuiz2(String minorExamQuiz2){
		this.minorExamQuiz2 = minorExamQuiz2;
	}
	
	public String getQuiz2(){																																
		return this.minorExamQuiz2;																														
	}		
	
	public void setQuiz3(String minorExamQuiz3){
		this.minorExamQuiz3 = minorExamQuiz3;
	}
		
	public String getQuiz3(){																																
		return this.minorExamQuiz3;																														
	}																																								
	
	public void setQuiz4(String minorExamQuiz4){
		this.minorExamQuiz4 = minorExamQuiz4;
	}
	
	public String getQuiz4(){																																
		return this.minorExamQuiz4;																														
	}																																								
		
	public void setMidtermExam(String majorExamMidterm){
		this.majorExamMidterm = majorExamMidterm;
	}
	
	public String getMidtermExam(){																													
		return this.majorExamMidterm;																													
	}																																								
		
	public void setFinalExam(String majorExamFinal){
		this.majorExamFinal = majorExamFinal;
	}
	
	public String getFinalExam(){																															
		return this.majorExamFinal;																														
	}																																								
	
	public void setMidtermProject(String projectMidterm){
		this.projectMidterm = projectMidterm;
	}
	
	public String getMidtermProject(){																													
		return this.projectMidterm;																														
	}																																								
	
	public void setFinalProject(String projectFinal){
		this.projectFinal = projectFinal;
	}
	
	public String getFinalProject(){																														
		return this.projectFinal;																															
	}	
	
	public void clearGrades(){
		this.minorExamQuiz1 = "";
		this.minorExamQuiz2 = "";
		this.majorExamMidterm = "";
		this.projectMidterm = "";
		this.minorExamQuiz3 = "";
		this.minorExamQuiz4 = "";
		this.majorExamFinal = "";
		this.projectFinal = "";
	}
}
