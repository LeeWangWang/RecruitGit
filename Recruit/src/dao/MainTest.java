package dao;

import bean.Resume;
import service.ResumeServImpl;
import service.ResumeService;

public class MainTest {

	public static void main(String[] args) {
		ResumeService resumeService = new ResumeServImpl(new ResumeDaoImpl());
		Resume resume = new Resume(1,1,0);
		if(resumeService.addResume(resume)) {
			System.out.println("666");
		}else {
			System.out.println("000");
		}
	}

}
