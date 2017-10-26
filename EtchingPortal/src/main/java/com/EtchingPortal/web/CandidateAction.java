
package com.EtchingPortal.web;

import com.EtchingPortal.dao.CandidateDAO;
import com.EtchingPortal.dao.CandidateDAOImpl;
import com.EtchingPortal.domain.Candidate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import java.security.MessageDigest;


public class CandidateAction extends ActionSupport implements ModelDriven<Candidate> {

    private static final long serialVersionUID = 1L;
    String flashMessage;
    String userName, passWord, passWordConf, email;
    int id;
    Candidate candidate;
    private List<Candidate> listCandidate;
    private CandidateDAO candidateDAO;

    public void validateAdd() {
        
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            if (getUserName().length() == 0) {
                addFieldError("userName", "Please enter your username");
            }
            if (getEmail().length() == 0 || !getEmail().contains("@")) {
                addFieldError("email", "Please enter a valid email");
            }
            if (getPassWord().length() == 0) {
                addFieldError("passWord", "Please enter a password");
            }
            if (getPassWordConf().length() == 0) {
                addFieldError("passWordConf", "Please repeat the password");
            }
            if (!getPassWordConf().equals(getPassWord())) {
                addFieldError("passWordConf", "The passwords do not match");
                addFieldError("passWord", "The passwords do not match");
            }
        }
    }

    public void validateEdit() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            if (getEmail().length() < 3 || !getEmail().contains("@")) {
                addFieldError("email", "Please enter a valid email");
            }
            if (getPassWord().length() == 0) {
                addFieldError("passWord", "Please enter a password");
            }
            if (getPassWordConf().length() == 0) {
                addFieldError("passWordConf", "Please repeat the password");
            }
            if (!getPassWordConf().equals(getPassWord())) {
                addFieldError("passWordConf", "The passwords do not match");
                addFieldError("passWord", "The passwords do not match");
            }
            candidateDAO = new CandidateDAOImpl();
            candidate = candidateDAO.findById(getId());
            setUserName(ActionContext.getContext().getSession().get("userName").toString());
        }

    }

    public boolean authCandidate(int id) {
        Map session = ActionContext.getContext().getSession();
        try {
            return session.get("logged_in").equals(true)
                    && session.get("role").equals("candidate")
                    && session.get("id").equals(id);
        } catch (Exception e) {
            return false;
        }
    }

    public String view() throws Exception {

        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (authCandidate(Integer.parseInt(request.getParameter("id")))) {
            candidateDAO = new CandidateDAOImpl();
            candidate = candidateDAO.findById(Integer.parseInt(request.getParameter("id")));
            return SUCCESS;
        } else {
            setFlashMessage("You do not have access to this content");
            return ERROR;
        }
    }

    public String edit() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (authCandidate(Integer.parseInt(request.getParameter("id")))) {
            if (request.getMethod().equals("POST")) {
                candidateDAO = new CandidateDAOImpl();
                candidate = candidateDAO.findById(Integer.parseInt(request.getParameter("id")));
                candidate.setEmail(getEmail());
                candidate.setPassWord(MD5Hashing(getPassWord()));
                candidate.setModified(new Date());
                candidate = candidateDAO.editCandidate(candidate);
                setFlashMessage("Ok, el candidato " + candidate.getUserName() + " has been edited");
                return "post";
            } else {
                candidateDAO = new CandidateDAOImpl();
                candidate = candidateDAO.findById(Integer.parseInt(request.getParameter("id")));
                return "get";
            }
        } else {
            setFlashMessage("You do not have access to this content");
            return ERROR;
        }
    }

    public String delete() throws Exception {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (authCandidate(Integer.parseInt(request.getParameter("id")))) {
            candidateDAO = new CandidateDAOImpl();
            candidate = candidateDAO.deleteCandidate(Integer.parseInt(request.getParameter("id")));
            setFlashMessage("Ok, the candidate " + candidate.getUserName() + "has been deleted");
            return SUCCESS;
        } else {
            setFlashMessage("You do not have access to this content");
            return ERROR;
        }
    }

    public String list() throws Exception {
        candidateDAO = new CandidateDAOImpl();
        listCandidate = candidateDAO.listCandidate();
        setListCandidate(listCandidate);
        return SUCCESS;
    }

    public String add() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (request.getMethod().equals("POST")) {
            try {
                candidate = new Candidate();
                candidate.setUserName(getUserName());
                candidate.setPassWord(MD5Hashing(getPassWord())); // Codifica la contraseña en MD5
                candidate.setEmail(getEmail());
                candidate.setCreated(new Date());
                candidate.setModified(new Date());
                candidateDAO = new CandidateDAOImpl();
                if (candidateDAO.addCandidate(candidate)) {
                    setFlashMessage("Ok, the candidate " + getUserName() + "has been saved");
                    return "post";
                } else {
                    setFlashMessage("Error, the candidate has not been saved");
                    return ERROR;
                }
            } catch (Exception ex) {
                setFlashMessage("Error, the candidate has not been saved");
                return ERROR;
            }
        } else {
            return "get";
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Candidate> getListCandidate() {
        return this.listCandidate;
    }

    public void setListCandidate(List<Candidate> listCandidate) {
        this.listCandidate = listCandidate;
    }

    public String getFlashMessage() {
        return flashMessage;
    }

    public void setFlashMessage(String flashMessage) {
        this.flashMessage = flashMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWordConf() {
        return passWordConf;
    }

    public void setPassWordConf(String passWordConf) {
        this.passWordConf = passWordConf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Candidate getModel() {
        return candidate;
    }

    private String MD5Hashing(String passWord) throws Exception {
    	//String password = "123456";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passWord.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        /*StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());*/

        //convert the byte to hex format method 2
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        //System.out.println("Digest(in hex format):: " + hexString.toString());
        return hexString.toString();
    }
}
