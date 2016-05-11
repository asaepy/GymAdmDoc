package co.edu.unicauca.gymadmdoc.entities;

import co.edu.unicauca.gymadmdoc.entities.GrupomuscRealizaEjercicio;
import co.edu.unicauca.gymadmdoc.entities.MruDia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-11T09:40:59")
@StaticMetamodel(MruGrupomuscular.class)
public class MruGrupomuscular_ { 

    public static volatile CollectionAttribute<MruGrupomuscular, GrupomuscRealizaEjercicio> grupomuscRealizaEjercicioCollection;
    public static volatile SingularAttribute<MruGrupomuscular, Integer> gmId;
    public static volatile SingularAttribute<MruGrupomuscular, MruDia> diaId;
    public static volatile SingularAttribute<MruGrupomuscular, String> gmNombre;

}