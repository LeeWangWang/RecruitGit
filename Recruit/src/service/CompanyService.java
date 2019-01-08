package service;

import java.util.List;
import bean.Company;

public interface CompanyService {
	public List<Company> searchAll();           //Ѱ��ȫ������Ϣ
	public void addNewCompany(Company company); //�����µĹ�˾
	public List<Company> searchByCompanyAddress(String companyAddress);
	public Company searchByCompanyId(int companyId);
	public List<Company> searchByCompanyName(String companyName);
}

