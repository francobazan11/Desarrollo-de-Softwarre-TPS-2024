package com.example.inicial1.controllers;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.services.AutorService;
import com.example.inicial1.services.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping(path = "/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {
}
