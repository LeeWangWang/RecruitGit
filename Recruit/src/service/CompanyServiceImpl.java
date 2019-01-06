package service;

import java.util.List;

import bean.*;
import dao.CompanyDao;

//������
public class CompanyServiceImpl implements CompanyService {
	private CompanyDao companyDao; //����һ���ӿ�
	public CompanyServiceImpl(CompanyDao companyDao) {
		this.companyDao = companyDao;  //��ʹ�õ������ʵ����������ӿ�
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
