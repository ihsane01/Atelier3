package com.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import com.ejb.entity.Etudiant;
import com.ejb.session.ManageEtudiantBeanRemote;


@ManagedBean(name = "etudiantManagedBean")
@RequestScoped
public class EtudiantsManagedBean {

	
	 private Etudiant  etudiant =new Etudiant();

	 
	  @EJB(mappedName="java:global/EtudiantsWEB-0.0.1-SNAPSHOT/ManageEtudiantBean!com.ejb.session.ManageEtudiantBean")
	    ManageEtudiantBeanRemote ejb ;
	   
	   
	  
	    private List<Etudiant> userList = new ArrayList(); 
	    
	    
	  public String addetudiant() {
		  
        String result = "Failure";
        boolean c = this.ejb.addEtudiant(etudiant);
        if (!c ) {
        			System.out.println("noo add");        }
        result = "Success";
        return "/listEtudiant.xhtml?faces-redirect=true";
}
	  public String editetu() {
		  
		  ejb.updateEtudiant(this.etudiant);
          userList=ejb.AllEtudiants();

          return "/listEtudiant.xhtml?faces-redirect=true";
      
	}
	
	  public String editetudiant(Etudiant etu){
	        this.etudiant = etu;
	        System.out.println(etudiant.getNom());
	        return "/edit.xhtml?faces-redirect=true";
	    }
	  @SuppressWarnings("unchecked")
		public List<Etudiant> listerEtudiants() {
			
		  userList=ejb.AllEtudiants();
			return userList;
			
			
		}
	  
	  
	  public String deleteEtudiant(Etudiant etu){
	       
	        
	            ejb.deleteEtudiant(etu);
	            userList=ejb.AllEtudiants();
	            
	            return "/listEtudiant.xhtml?faces-redirect=true";
	        
	    }
	    
	  
	  
	  
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public List<Etudiant> getUserList() {
		return userList;
	}
	public void setUserList(List<Etudiant> userList) {
		this.userList = userList;
	}
	  
	  
}