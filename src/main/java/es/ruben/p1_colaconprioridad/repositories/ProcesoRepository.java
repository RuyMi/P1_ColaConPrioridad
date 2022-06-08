package es.ruben.p1_colaconprioridad.repositories;

import es.ruben.p1_colaconprioridad.exceptions.ProcesoException;
import es.ruben.p1_colaconprioridad.models.Estado;
import es.ruben.p1_colaconprioridad.models.Proceso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProcesoRepository implements ICola{
    private static ProcesoRepository instance;

    public static ProcesoRepository getInstance() {
        if (instance == null) {
            instance = new ProcesoRepository();
        }
        return instance;
    }

    LinkedList<Proceso> repository = new LinkedList<>();

    @Override
    public Proceso add(Proceso entity) throws ProcesoException {
        if(comprobarId(entity.getId())){
            entity.setEstado(Estado.PROCESANDO);
            repository.add(entity);
            return entity;
        }else {
            throw new ProcesoException("ya existe un proceso con id: " + entity.getId());
        }


    }

    private boolean comprobarId(int id) {
        for (Proceso p : repository) {
            if(p.getId() == id){
                return false;
            }
        }
        return true;
    }

    @Override
    public Proceso remove() throws ProcesoException {
        if(repository.isEmpty()) {
            throw new ProcesoException("No hay procesos en la cola");
        }
        Proceso entity = comprobarPrioridad();
        entity.setEstado(Estado.TERMINADO);
        repository.remove(entity);
        return entity;
    }

    private Proceso comprobarPrioridad() {
        List<Proceso> listaProcesos = new ArrayList<>(repository);
        return listaProcesos.stream().filter(p -> p.getPrioridad() == listaProcesos.stream().min(Comparator.comparingInt(Proceso::getPrioridad)).get().getPrioridad()).findFirst().get();
    }

    @Override
    public Proceso elemento() {
        return null;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Proceso proceso : repository) {
            res.append(proceso.toString()).append("\n");
        }
        return res.toString();
    }
}
