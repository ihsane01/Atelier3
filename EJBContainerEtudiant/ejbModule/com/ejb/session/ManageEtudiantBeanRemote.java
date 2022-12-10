package com.ejb.session;

import java.util.List;

import javax.ejb.Remote;

import com.ejb.entity.Etudiant;

@Remote
public interface ManageEtudiantBeanRemote {
	 public boolean addEtudiant(Etudiant etudiant);
	
	 public boolean deleteEtudiant(Etudiant etu);
	 public boolean updateEtudiant(Etudiant etu);
	 public Etudiant findEtudiant(int id);
	 public List<Etudiant> AllEtudiants();
}
