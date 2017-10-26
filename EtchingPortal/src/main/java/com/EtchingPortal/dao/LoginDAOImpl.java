
package com.EtchingPortal.dao;


import org.apache.struts2.components.ElseIf;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.Restrictions;

import com.EtchingPortal.domain.Candidate;
import com.EtchingPortal.domain.Company;


public class LoginDAOImpl implements LoginDAO {

    @Override
    public Candidate findCandidate(String userName, String passWord) {
        Candidate candidate;
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Criteria criteria = s.createCriteria(Candidate.class)
                .add(Restrictions.eq("userName", userName))
                .add(Restrictions.eq("passWord", passWord));
        candidate = (Candidate) criteria.uniqueResult();
        s.close();
        sf.close();
        return candidate;
    }

    @Override
    public Company findCompany(String cif, String passWord) {
        Company company;
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Criteria criteria = s.createCriteria(Company.class)
                .add(Restrictions.eq("cif", cif))
                .add(Restrictions.eq("passWord", passWord));
        company = (Company) criteria.uniqueResult();
        s.close();
        sf.close();
        return company;
    }

    @Override
    public void updateLastLogin(Candidate candidate, Company company) {
        if (company == null) {
            try {
                SessionFactory sf = new Configuration().configure().buildSessionFactory();
                Session s = sf.openSession();
                s.beginTransaction();
                s.update(candidate);
                s.getTransaction().commit();
                s.close();
                sf.close();
            } catch (HibernateException e) {
            }
        }
        if (candidate == null) {
            try {
                SessionFactory sf = new Configuration().configure().buildSessionFactory();
                Session s = sf.openSession();
                s.beginTransaction();
                s.update(company);
                s.getTransaction().commit();
                s.close();
                sf.close();
            } catch (HibernateException e) {
            }
        }
    }
}
