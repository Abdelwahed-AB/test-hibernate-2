package dao.employe;

import entities.Departement;
import entities.Employe;

import java.util.List;

public interface IEmployeDao {

    List<Employe> getEmployes();
    void saveEmploye(Employe employe);
    List<Employe> getEmployesByDepartement(Departement departement);
    void deleteEmploye(Employe employe);
}
