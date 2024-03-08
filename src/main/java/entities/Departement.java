package entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Employe> employes;

    public void addEmploye(Employe e){
        if (employes == null)
            employes = new ArrayList<>();
        employes.add(e);
    }

    public void removeEmploye(Employe e){
        if (employes != null){
            employes.remove(e);
        }
    }
}
