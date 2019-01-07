package dao;

import java.util.List;
import bean.Company;


public interface CompanyDao {
	List<Company> searchAll() throws Exception;   //寻找全部
	public void addNewCompany(Company company) throws Exception; //增加一个公司的数据
	List<Company> search(String search) throws Exception;
	Company searchByCompanyId(int companyId) throws Exception;
}
