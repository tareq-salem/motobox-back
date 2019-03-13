package com.hoc.motobox.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T>
 */
public interface SuperRestService<T> {
    public JpaRepository<T, Long> getDao();

    /**
     *
     * @return
     */
    default  public List<T> findAll(){
        return getDao().findAll();
    }

    /**
     * Permet de trouver un élément par son id si la méthod existe dans le service d
     * @param id
     * @return @override function findById() si n'est pas trouvé
     */
    default public Optional<T> findById(Long id){
        return getDao().findById(id);
    }

    /**
     * 
     * @param t
     * @return
     */
    default public  T save(T t){
        return save(t);
    }

    /**
     *
     * @param id
     */
    default public void deleteById(Long id){
        Optional<T> t = getDao().findById(id);
        t.ifPresent(entity -> getDao().delete(entity));
    }

    /**
     *
     * @param t
     */
    default public void delete(T t){
        getDao().delete(t);
    }
}
