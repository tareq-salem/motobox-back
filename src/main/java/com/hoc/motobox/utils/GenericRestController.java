package com.hoc.motobox.utils;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericRestController<T> {

    RestService<T> serv;

    public GenericRestController(RestService<T> serv) {
        this.serv = serv;
    }

    @GetMapping
    public List<T> getAll() {
        return serv.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable Long id) {
        return serv.findById(id).orElse(null);
    }

    @PostMapping
    public T save(@RequestBody T json) {
        return serv.save(json);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        serv.deleteById(id);
    }
}
