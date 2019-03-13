package com.hoc.motobox.utils;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class SuperController<T> {

    /**
     * TODO private?
     */
    private SuperRestService<T> service;

    public SuperController(SuperRestService<T> service){
        this.service = service;
    }

    @GetMapping
    public List<T> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public T findId(@PathVariable Long id){
        return service.findById(id).orElseGet(()->null);
    }

    @PostMapping
    public  T save(@RequestBody T json){
        return service.save(json);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
