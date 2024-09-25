package com.example.inicial1.controllers;

import com.example.inicial1.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Pageable;
import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable>{
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save (@RequestBody E entity);
    public ResponseEntity<?> delete (@PathVariable ID id);
    public ResponseEntity<?> update (@PathVariable ID id,@RequestBody E entity);
}