package dao.employe;

import entities.Departement;
import entities.Employe;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.DbConfig;

import java.util.List;

public class EmployeDaoImpl implements IEmployeDao{

    private Session session;

    public EmployeDaoImpl() {
        this.session = DbConfig.getSession();
    }

    @Override
    public List<Employe> getEmployes() {
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session.createQuery(
                    "from Employe e"
            );
            List<Employe> employeList = query.getResultList();
            transaction.commit();
            return employeList;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void saveEmploye(Employe employe) {
        Transaction transaction = session.beginTransaction();
        try{
            session.save(employe);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<Employe> getEmployesByDepartement(Departement departement) {
        Transaction transaction = session.beginTransaction();
        try{
            List<Employe> employeList = session.find(Departement.class, departement.getId()).getEmployes();
            transaction.commit();

            return employeList;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void deleteEmploye(Employe employe) {
        Transaction transaction = session.beginTransaction();
        try{
            employe = session.find(Employe.class, employe.getId());
            Departement departement = session.find(Departement.class, employe.getDepartement().getId());
            departement.removeEmploye(employe);
            session.merge(departement);
            session.delete(employe);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }
}
