import dao.departement.DepartementDaoImpl;
import dao.departement.IDepartementDao;
import dao.employe.EmployeDaoImpl;
import dao.employe.IEmployeDao;
import entities.Departement;
import entities.Employe;

public class Main {
    public static void main(String[] args) {
        IEmployeDao employeDao = new EmployeDaoImpl();
        IDepartementDao departementDao = new DepartementDaoImpl();

        Employe employe = new Employe();
        employe.setNom("MOHA");
        employe.setPrenom("KUN");
        employe.setEmail("MOHA@GMAIL.COM");

        Departement departement = new Departement();
        departement.setNom("HR");

        departementDao.saveDepartement(departement);
        employeDao.saveEmploye(employe);

        System.out.println(employeDao.getEmployes());
        System.out.println(departementDao.getDepartements());

        departementDao.addEmployeToDepartement(employe, departement);
        employe.setDepartement(departement);
        employeDao.saveEmploye(employe);

        System.out.println(employeDao.getEmployes());
        System.out.println(departementDao.getDepartements());

        System.out.println(employeDao.getEmployesByDepartement(departement));
        System.out.println(departementDao.getDepartementsByEmploye(employe));

        employeDao.deleteEmploye(employe);
        System.out.println(employeDao.getEmployes());

        //departementDao.deleteDepartement(departement);
        //System.out.println(departementDao.getDepartements());
    }

}
