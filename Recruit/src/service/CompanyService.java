package service;

import java.util.List;
import bean.Company;

public interface CompanyService {
	public List<Company> searchAll();           //Ѱ��ȫ������Ϣ
	public void addNewCompany(Company company); //�����µĹ�˾
}

