package dao;

import java.util.List;
import bean.Company;


public interface CompanyDao {
	List<Company> searchAll() throws Exception;   //Ѱ��ȫ��
	public boolean addNewCompany(Company company) throws Exception; //����һ����˾������
	List<Company> searchByCompanyAddress(String address) throws Exception;
	Company searchByCompanyId(int companyId) throws Exception;
	List<Company> searchByCompanyName(String companyName) throws Exception;
}
