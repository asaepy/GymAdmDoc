package co.edu.unicauca.gymadmdoc.entities;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-15T22:52:44")
@StaticMetamodel(MrecInformacionRecaudo.class)
public class MrecInformacionRecaudo_ { 

    public static volatile SingularAttribute<MrecInformacionRecaudo, Long> irecId;
    public static volatile SingularAttribute<MrecInformacionRecaudo, Integer> irecMes;
    public static volatile SingularAttribute<MrecInformacionRecaudo, String> irecEstadoRecaudo;
    public static volatile SingularAttribute<MrecInformacionRecaudo, Date> irecFechaLimite;
    public static volatile SingularAttribute<MrecInformacionRecaudo, Integer> irecAnio;
    public static volatile SingularAttribute<MrecInformacionRecaudo, Long> usuIdentificacion;
    public static volatile SingularAttribute<MrecInformacionRecaudo, BigInteger> rpagReferencia;

}