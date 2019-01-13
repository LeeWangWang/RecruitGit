/**@FileName: Jihe.java
 * @Description: 
 * @Paclage: gui.candidate
 * @Author: ������
 * @Data: 2019��1��8������9:12:01
 */
package gui.candidate;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import bean.Company;
import bean.Position;
import bean.Resume;

/**
 * �����������ҵ�����ְ�ţ�ͨ����ְ�ŵ�ְλIdȥ��ְλ����ͨ��ְλ�еĹ�˾��ID�����ҹ�˾��ID
 * @author hp
 * @Description
 * @data 2019��1��7��
 */
public class Jihe {

	private int candidateId;            //����ID
	private int positionId;             //ְλ��ID 
	private String positionName;	    //ְλ������
	private int companyId;              //��˾��ID
	private String companyName; 	    //��˾������
	private String companyAddress;  	//��˾�ĵ�ַ
	private String luyong;			    //�Ƿ�¼��1
	private List<Resume> resumeList;	//��ְ��List�洢
	private List<Position> positionList;//ְλList�洢
	private List<Company> companyList;  //��˾��List�洢
	private Vector<Resume> resumeVector;//��ְ�ŵ�Vector�Ĵ洢
	private Vector<Position> positionVector;//ְλ��Vector�洢
	private Vector<Company> companyVector; //��˾��Vector
	
	private Vector<Ren> renOnce;         //1��Vector
	private Vector<Vector<Ren>> renTwice;  //2��Vector
	
	public Jihe(int candidateId,List<Position> positionList
			,List<Resume> resumeList,List<Company> companyList) {
		this.candidateId = candidateId;
		this.resumeList = resumeList;
		this.positionList = positionList;	
		this.companyList  = companyList;
		
		renOnce = new Vector<Ren>();
		for(int i = 0;i < resumeList.size();i++) { //�Ȳ�����ְ��
			if(resumeList.get(i).getCandidateId() == this.getCandidateId()) { //�ҵ����Լ�ID����ְ��
				//Vector<Ren> renNew = new Vector<Ren>();
				Ren ren = new Ren();
				ren.toString();
				ren.setPositionId(resumeList.get(i).getPositionId());
				if(resumeList.get(i).getIsInterview() == 1) {
					ren.setLuyong("¼�ã�����ϵ��˾��������");
				}else if(resumeList.get(i).getIsInterview() == 0) {
					ren.setLuyong("��δ¼��");
				}
				//System.out.println(ren);
				for(int j = 0;j < positionList.size();j++) {  //ͨ����ְ�ŵ�ְλID������ְλ
					if(positionList.get(j).getPositionId() == ren.getPositionId()) {
						ren.setCompanyId(positionList.get(j).getCompanyId());  //����˾ID���и�ֵ
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
