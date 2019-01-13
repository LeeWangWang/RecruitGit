/**@FileName: Jihe.java
 * @Description: 
 * @Paclage: gui.candidate
 * @Author: 李旺旺
 * @Data: 2019年1月8日下午9:12:01
 */
package gui.candidate;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import bean.Company;
import bean.Position;
import bean.Resume;

/**
 * 在这里面先找的是求职信，通过求职信的职位Id去找职位，在通过职位中的公司的ID来查找公司的ID
 * @author hp
 * @Description
 * @data 2019年1月7日
 */
public class Jihe {

	private int candidateId;            //个人ID
	private int positionId;             //职位的ID 
	private String positionName;	    //职位的名字
	private int companyId;              //公司的ID
	private String companyName; 	    //公司的名字
	private String companyAddress;  	//公司的地址
	private String luyong;			    //是否录用1
	private List<Resume> resumeList;	//求职信List存储
	private List<Position> positionList;//职位List存储
	private List<Company> companyList;  //公司的List存储
	private Vector<Resume> resumeVector;//求职信的Vector的存储
	private Vector<Position> positionVector;//职位的Vector存储
	private Vector<Company> companyVector; //公司的Vector
	
	private Vector<Ren> renOnce;         //1层Vector
	private Vector<Vector<Ren>> renTwice;  //2层Vector
	
	public Jihe(int candidateId,List<Position> positionList
			,List<Resume> resumeList,List<Company> companyList) {
		this.candidateId = candidateId;
		this.resumeList = resumeList;
		this.positionList = positionList;	
		this.companyList  = companyList;
		
		renOnce = new Vector<Ren>();
		for(int i = 0;i < resumeList.size();i++) { //先查找求职信
			if(resumeList.get(i).getCandidateId() == this.getCandidateId()) { //找到有自己ID的求职信
				//Vector<Ren> renNew = new Vector<Ren>();
				Ren ren = new Ren();
				ren.toString();
				ren.setPositionId(resumeList.get(i).getPositionId());
				if(resumeList.get(i).getIsInterview() == 1) {
					ren.setLuyong("录用，请联系公司进行面试");
				}else if(resumeList.get(i).getIsInterview() == 0) {
					ren.setLuyong("还未录用");
				}
				//System.out.println(ren);
				for(int j = 0;j < positionList.size();j++) {  //通过求职信的职位ID来查找职位
					if(positionList.get(j).getPositionId() == ren.getPositionId()) {
						ren.setCompanyId(positionList.get(j).getCompanyId());  //给公司ID进行赋值
						ren.setPositionName(positionList.get(j).getPositionName());
						ren.setPositionDiploma(positionList.get(j).getPositionDiploma());
						//System.out.println(ren);
						for(int z = 0;z < companyList.size();z++) {
							if(ren.getCompanyId() == companyList.get(z).getCompanyId()) {
								ren.setCompanyAddress(companyList.get(z).getCompanyAddress());
								ren.setCompanyName(companyList.get(z).getCompanyName());
								renOnce.add(ren);
								//System.out.println(ren);
							}
						}
					}
				}
			}
		}
		
	}

	public Vector<Ren> getRenOnce() {
		return renOnce;
	}

	public void setRenOnce(Vector<Ren> renOnce) {
		this.renOnce = renOnce;
	}

	public Iterator Iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getLuyong() {
		return luyong;
	}

	public void setLuyong(String luyong) {
		this.luyong = luyong;
	}

	public List<Resume> getResumeList() {
		return resumeList;
	}

	public void setResumeList(List<Resume> resumeList) {
		this.resumeList = resumeList;
	}

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public Vector<Resume> getResumeVector() {
		return resumeVector;
	}

	public void setResumeVector(Vector<Resume> resumeVector) {
		this.resumeVector = resumeVector;
	}

	public Vector<Position> getPositionVector() {
		return positionVector;
	}

	public void setPositionVector(Vector<Position> positionVector) {
		this.positionVector = positionVector;
	}

	public Vector<Company> getCompanyVector() {
		return companyVector;
	}

	public void setCompanyVector(Vector<Company> companyVector) {
		this.companyVector = companyVector;
	}

	public Vector<Vector<Ren>> getRenTwice() {
		return renTwice;
	}

	public void setRenTwice(Vector<Vector<Ren>> renTwice) {
		this.renTwice = renTwice;
	}

}
