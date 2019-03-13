package com.hoc.motobox.utils;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestService<T> {

    /**
     * DAO utilisée par le service REST
     * @return une instance de DAO utilisée par le service
     */
    public JpaRepository<T, Long> getDao();

    /**
     * Récupère toutes les instances de la classe
     * @return toutes les entités
     */
    default public List<T> findAll() {
        return getDao().findAll();
    }

    /**
     * Retourne l'entité correspondante à l'id passé en paramètre
     * @param id ne doit pas être null
     * @return l'entité correspondant à cet id
     */
    default public Optional<T> findById(Long id) {
        return getDao().findById(id);
    }

    /**
     * Persiste une entité donnée. Si l'id n'existait pas l'entité est ajoutée. Sinon elle remplace l'ancienne entité.
     * @param t ne doit pas être null
     * @return l'entité persistée. Ne sera jamais null
     */
    default public T save(T t) {
        return getDao().save(t);
    }

    /**
     * Supprime l'entité passée en paramètre.
     * @param t ne doit pas être null
     */
    default public void deleteById(Long id) {
        Optional<T> t = getDao().findById(id);
        t.ifPresent(entity -> getDao().delete(entity));
    }

    /**
     * Supprime l'entité passée en paramètre.
     * @param t ne doit pas être null
     */
    default public void delete(T t) {
        getDao().delete(t);
    }

}
