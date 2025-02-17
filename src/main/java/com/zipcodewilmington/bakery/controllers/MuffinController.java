package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/muffin-controller")
public class MuffinController {
    @Autowired
    private MuffinService service;

    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public ResponseEntity<Muffin> show(Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Muffin> create(Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ResponseEntity<Muffin> update(Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/destroy")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }
}
