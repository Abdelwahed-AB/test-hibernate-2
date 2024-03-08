package dao.departement;

import entities.Departement;
import entities.Employe;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.DbConfig;

import java.util.List;

public class DepartementDaoImpl implements IDepartementDao{

    private Session session;

    public DepartementDaoImpl() {
        this.session = DbConfig.getSession();
    }

    @Override
    public Departement getDepartement(Long id){
        Transaction transaction = session.beginTransaction();
        try{
            Departement departement = session.find(Departement.class, id);
            transaction.commit();
            return departement;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<Departement> getDepartements() {
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session.createQuery(
                    "from Departement d"
            );
            List<Departement> departements = query.getResultList();
            transaction.commit();
            return departements;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void saveDepartement(Departement departement) {
        Transaction transaction = session.beginTransaction();
        try{
            session.save(departement);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<Departement> getDepartementsByEmploye(Employe employe) {
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session.createQuery(
                    "from Departement d where :employe member of d.employes"
            );
            query.setParameter("employe", employe);
            List<Departement> departements = query.getResultList();
            transaction.commit();
            return departements;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void addEmployeToDepartement(Employe employe, Departement departement) {
        Transaction transaction = session.beginTransaction();
        try{
            departement = session.find(Departement.class, departement.getId());
            departement.addEmploye(employe);
            session.merge(departement);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void deleteDepartement(Departement departement) {
        Transaction transaction = session.beginTransaction();
        try{
            departement = session.find(Departement.class, departement.getId());
            session.remove(departement);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }
    }
}
