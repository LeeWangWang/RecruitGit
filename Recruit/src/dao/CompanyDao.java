package dao;

import java.util.List;
import bean.Company;


public interface CompanyDao {
	List<Company> searchAll() throws Exception;   //Ѱ��ȫ��
	public void addNewCompany(Company company) throws Exception; //����һ����˾������
}
