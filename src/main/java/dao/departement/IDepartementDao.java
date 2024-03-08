package dao.departement;

import entities.Departement;
import entities.Employe;

import java.util.List;

public interface IDepartementDao {
     Departement getDepartement(Long id);
    List<Departement> getDepartements();
    void saveDepartement(Departement departement);
    List<Departement> getDepartementsByEmploye(Employe employe);
    void addEmployeToDepartement(Employe employe, Departement departement);
    void deleteDepartement(Departement departement);
}
