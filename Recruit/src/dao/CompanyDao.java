package dao;

import java.util.List;
import bean.Company;
/**
 * @ClassName: CompanyDao.java
 * @Author: 周天乐
 * @Data: 2019年1月9日上午8:28:57
 */
public interface CompanyDao {
	List<Company> searchAll() throws Exception;   //寻找全部
	public boolean addNewCompany(Company company) throws Exception; //增加一个公司的数据
	List<Company> searchByCompanyAddress(String address) throws Exception;
	Company searchByCompanyId(int companyId) throws Exception;
	List<Company> searchByCompanyName(String companyName) throws Exception;
}
