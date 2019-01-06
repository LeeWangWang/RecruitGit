package service;

import java.util.List;

import bean.*;
import dao.CompanyDao;

//李旺旺
public class CompanyServiceImpl implements CompanyService {
	private CompanyDao companyDao; //这是一个接口
	public CompanyServiceImpl(CompanyDao companyDao) {
		this.companyDao = companyDao;  //将使用的类进行实例化，面向接口
	}

	
	public List<Company> searchAll() {
		try {
			return companyDao.searchAll();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public void addNewCompany(Company company) {
		try {
			companyDao.addNewCompany(company);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
