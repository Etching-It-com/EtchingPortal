
package com.EtchingPortal.dao;

import java.util.List;

import com.EtchingPortal.domain.Company;


public interface CompanyDAO {

    public Company findById(int id);

    public List<Company> listCompany();

    public boolean addCompany(Company company);

    public Company deleteCompany(int id);

    public Company editCompany(Company company);
}
