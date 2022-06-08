package es.ruben.p1_colaconprioridad.repositories;

import es.ruben.p1_colaconprioridad.exceptions.ProcesoException;
import es.ruben.p1_colaconprioridad.models.Proceso;

public interface ICola {

    Proceso add(Proceso entity) throws Exception;

    Proceso remove() throws ProcesoException;

    Proceso elemento();

    int size();





}
