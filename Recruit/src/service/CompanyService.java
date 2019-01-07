package service;

import java.util.List;
import bean.Company;

public interface CompanyService {
	public List<Company> searchAll();           //寻找全部的信息
	public void addNewCompany(Company company); //增加新的公司
	public List<Company> search(String search);
	public Company searchByCompanyId(int companyId);
}

