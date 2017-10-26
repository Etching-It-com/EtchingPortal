
package com.EtchingPortal.web;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

import com.EtchingPortal.dao.InscriptionDAOImpl;
import com.EtchingPortal.dao.JobDAOImpl;
import com.EtchingPortal.domain.Job;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;


public class JobAction extends ActionSupport implements ModelDriven<Job> {

    private static final long serialVersionUID = 1L;
    String flashMessage;
    String companyName, title, description, category, location, experience, training, languages;
    int companyId, id;
    boolean isInscribed;
    Job job;
    JobDAOImpl jobDAO;
    private List<Job> listJob;
    public List<String> listCategory, listLocation, listTraining, listExperience, listLanguages;

    public JobAction() {
        listCategory = new ArrayList<>();
        listLocation = new ArrayList<>();
        listTraining = new ArrayList<>();
        listExperience = new ArrayList<>();
        listLanguages = new ArrayList<>();
        
        listLocation.add("Alabama"); 
        listLocation.add("Alaska");
        listLocation.add("Arizona"); 
        listLocation.add("Arkansas");
        listLocation.add("California"); 
        listLocation.add("Colorado"); 
        listLocation.add("Connecticut"); 
        listLocation.add("Delaware"); 
        listLocation.add("Florida"); 
        listLocation.add("Georgia"); 
        listLocation.add("Hawaii"); 
        listLocation.add("Idaho"); 
        listLocation.add("Illinois Indiana"); 
        listLocation.add("Iowa"); 
        listLocation.add("Kansas"); 
        listLocation.add("Kentucky"); 
        listLocation.add("Louisiana"); 
        listLocation.add("Maine"); 
        listLocation.add("Maryland"); 
        listLocation.add("Massachusetts"); 
        listLocation.add("Michigan"); 
        listLocation.add("Minnesota"); 
        listLocation.add("Mississippi"); 
        listLocation.add("Missouri"); 
        listLocation.add("Montana Nebraska"); 
        listLocation.add("Nevada"); 
        listLocation.add("New Hampshire"); 
        listLocation.add("New Jersey"); 
        listLocation.add("New Mexico"); 
        listLocation.add("New York"); 
        listLocation.add("North Carolina"); 
        listLocation.add("North Dakota"); 
        listLocation.add("Ohio"); 
        listLocation.add("Oklahoma"); 
        listLocation.add("Oregon"); 
        listLocation.add("Pennsylvania Rhode Island"); 
        listLocation.add("South Carolina"); 
        listLocation.add("South Dakota"); 
        listLocation.add("Tennessee"); 
        listLocation.add("Texas"); 
        listLocation.add("Utah"); 
        listLocation.add("Vermont"); 
        listLocation.add("Virginia"); 
        listLocation.add("Washington"); 
        listLocation.add("West Virginia"); 
        listLocation.add("Wisconsin"); 
        listLocation.add("Wyoming");

        listCategory.add("All");
        listCategory.add("Public Administration");
        listCategory.add("Business Administration");
        listCategory.add("Customer Service");
        listCategory.add("Quality, production and R & D");
        listCategory.add("Sales and sales");
        listCategory.add("Purchasing, Logistics and Warehousing");
        listCategory.add("Design and graphic arts");
        listCategory.add("Education and training");
        listCategory.add("Finance and Banking");
        listCategory.add("IT and Telecoms");
        listCategory.add("Engineers and technicians");
        listCategory.add("Real estate and construction");
        listCategory.add("Legal");
        listCategory.add("Marketing and communication");
        listCategory.add("Professionals, arts and crafts");
        listCategory.add("Human Resources");
        listCategory.add("Health and health");
        listCategory.add("Tourism and restoration");
        listCategory.add("Retail Sales");
        listCategory.add("Others");

        listTraining.add("no studies");
        listTraining.add("that");
        listTraining.add("Bachelors");
        listTraining.add("Grade Medium");
        listTraining.add("superior grade");
        listTraining.add("Diploma");
        listTraining.add("Graduate");

        listExperience.add("without experience");
        listExperience.add("Less than one year");
        listExperience.add("1 year");
        listExperience.add("2 year");
        listExperience.add("3 years or more");

        listLanguages.add("hindi");
        listLanguages.add("english");
        listLanguages.add("France");
        listLanguages.add("German");
    }

    public void validateAdd() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            if (getTitle().length() == 0) {
                addFieldError("title", "Please enter the title of the job offer");
            }
            if (getDescription().length() == 0) {
                addFieldError("description", "Please select a descripction");
            }
            if (getCategory().length() == 0) {
                addFieldError("category", "Please select category");
            }
            if (getLocation().length() == 0) {
                addFieldError("location", "Please select a location");
            }
            if (getTraining().length() == 0) {
                addFieldError("training", "Please select a training");
            }
            if (getLanguages().length() == 0) {
                addFieldError("languages", "Please select a languages");
            }
        }
    }

    public void validateEdit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            if (getTitle().length() == 0) {
                addFieldError("title", "Please enter the title of the job offer");
            }
            if (getDescription().length() == 0) {
                addFieldError("description", "Please select a description");
            }
            if (getCategory().length() == 0) {
                addFieldError("category", "Please select a category");
            }
            if (getLocation().length() == 0) {
                addFieldError("location", "Please select a location");
            }
            if (getTraining().length() == 0) {
                addFieldError("training", "Please select a training");
            }
            if (getLanguages().length() == 0) {
                addFieldError("languages", "Please select a language");
            }
            jobDAO = new JobDAOImpl();
            job = jobDAO.findById(getId());
        }
    }

    public boolean authCompany(int id) {
        Map session = ActionContext.getContext().getSession();
        try {
            jobDAO = new JobDAOImpl();
            job = jobDAO.findById(id);
            return session.get("id").equals(job.getCompanyId()) && session.get("role").equals("company");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean authListJobByCompanyId(int id) {
        Map session = ActionContext.getContext().getSession();
        try {
            return session.get("id").equals(id) && session.get("role").equals("company");
        } catch (Exception e) {
            return false;
        }
    }

    public String add() {
        Map session = ActionContext.getContext().getSession();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            if (session.get("role").equals("company")) {
                if (request.getMethod().equals("POST")) {
                    try {
                        job = new Job();
                        job.setCompanyId(getCompanyId());
                        job.setCompanyName(getCompanyName());
                        job.setTitle(getTitle());
                        job.setDescription(getDescription());
                        job.setLocation(getLocation());
                        job.setCategory(getCategory());
                        job.setExperience(experience);
                        job.setTraining(training);
                        job.setLanguages(languages);
                        job.setCreated(new Date());
                        job.setModified(new Date());
                        jobDAO = new JobDAOImpl();
                        jobDAO.addJob(job);
                        setFlashMessage("Ok work " + getTitle() + "has been saved");
                        return "post";
                    } catch (Exception ex) {
                        setFlashMessage("Opppsss, some error has occurred");
                        return ERROR;
                    }
                } else {
                    return "get";
                }
            } else {
                setFlashMessage("You do not have access to this content");
                return ERROR;
            }
        } catch (Exception e) {
            setFlashMessage("You do not have access to this content");
            return ERROR;
        }
    }

    public String edit() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            if (authCompany(Integer.parseInt(request.getParameter("id")))) {
                if (request.getMethod().equals("POST")) {

                    jobDAO = new JobDAOImpl();//
                    job = jobDAO.findById(getId());
                    job.setTitle(getTitle());
                    job.setDescription(getDescription());
                    job.setExperience(experience);
                    job.setTraining(training);
                    job.setLanguages(languages);
                    job.setModified(new Date());
                    job = jobDAO.editJob(job);
                    setFlashMessage("Ok, the job " + job.getTitle() + " has been edited");
                    return "post";
                } else {
                    jobDAO = new JobDAOImpl();
                    job = jobDAO.findById(Integer.parseInt(request.getParameter("id")));
                    return "get";
                }
            } else {
                setFlashMessage("You do not have access to this content");
                return ERROR;
            }
        } catch (NumberFormatException ex) {
            setFlashMessage("You do not have access to this content");
            return ERROR;
        }
    }

    public String delete() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            if (authCompany(Integer.parseInt(request.getParameter("id")))) {
                jobDAO = new JobDAOImpl();
                job = jobDAO.deleteJob(Integer.parseInt(request.getParameter("id")));
                setFlashMessage("Ok, the job" + job.getTitle() + " has been deleted");
                return SUCCESS;
            } else {
                setFlashMessage("You do not have access to this content");
                return ERROR;
            }
        } catch (NumberFormatException e) {
            setFlashMessage("You do not have access to this content");
            return ERROR;
        }
    }

    public String view() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            Map session = ActionContext.getContext().getSession();
            jobDAO = new JobDAOImpl();
            job = jobDAO.findById(Integer.parseInt(request.getParameter("id")));
            if (session.get("id") != null) {
                InscriptionDAOImpl inscriptionDAO = new InscriptionDAOImpl();
                isInscribed = inscriptionDAO.findByCandidateIdAndJobId(Integer.parseInt(session.get("id").toString()), job.getId()); // Comprueba si el usuario está inscrito
            }
            setFlashMessage(getFlashMessage());
            return SUCCESS;
        } catch (Exception e) {
            setFlashMessage("Opppsss, some error has occurred");
            return ERROR;
        }
    }

    public String list() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        jobDAO = new JobDAOImpl();
        if (request.getParameter("id") != null) {
            if (authListJobByCompanyId(Integer.parseInt(request.getParameter("id")))) {
                setListJob(jobDAO.listJobByCompanyId(Integer.parseInt(request.getParameter("id"))));
            } else {
                setFlashMessage("You do not have access to this content");
                return ERROR;
            }
        } else {
            listJob = jobDAO.listJob();
        }
        setListJob(listJob);
        return SUCCESS;
    }

    public List<Job> getListJob() {
        return this.listJob;
    }

    public void setListJob(List<Job> listJob) {
        this.listJob = listJob;
    }

    public String getFlashMessage() {
        return flashMessage;
    }

    public void setFlashMessage(String flashMessage) {
        this.flashMessage = flashMessage;
    }

    public boolean getIsInscribed() {
        return isInscribed;
    }

    public void setIsInscribed(boolean isInscribed) {
        this.isInscribed = isInscribed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTraining() {
        return this.training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public List<String> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<String> listLocation) {
        this.listLocation = listLocation;
    }

    public List<String> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<String> listCategory) {
        this.listCategory = listCategory;
    }

    public List<String> getListTraining() {
        return listTraining;
    }

    public void setListTraining(List<String> listTraining) {
        this.listTraining = listTraining;
    }

    public List<String> getListExperience() {
        return listExperience;
    }

    public void setListExperience(List<String> listExperience) {
        this.listExperience = listExperience;
    }

    public List<String> getListLanguages() {
        return listLanguages;
    }

    public void setListLanguages(List<String> listLanguages) {
        this.listLanguages = listLanguages;
    }

    @Override
    public Job getModel() {
        return job;
    }
}
