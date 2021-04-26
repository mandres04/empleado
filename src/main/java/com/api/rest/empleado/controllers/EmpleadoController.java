package com.api.rest.empleado.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.empleado.model.Empleado;
import com.api.rest.empleado.services.EmpleadoService;


@RestController
@RequestMapping("/api/v1/empleado")

public class EmpleadoController {
    EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    //lista todos los empleados
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.getEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    //busca un empleado
    @GetMapping({"/{empleadoId}"})
    public ResponseEntity<Empleado> getEmpleado(@PathVariable Long empleadoId) {
        return new ResponseEntity<>(empleadoService.getEmpleadoById(empleadoId), HttpStatus.OK);
    }

    //registra empleado
    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado empleado1 = empleadoService.insert(empleado);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("empleado", "/api/v1/empleado/" + empleado1.getId().toString());
        return new ResponseEntity<>(empleado1, httpHeaders, HttpStatus.CREATED);
    }

    //actualiza empleado
    @PutMapping({"/{empleadoId}"})
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable("empleadoId") Long empleadoId, @RequestBody Empleado empleado) {
        empleadoService.updateEmpleado(empleadoId, empleado);
        return new ResponseEntity<>(empleadoService.getEmpleadoById(empleadoId), HttpStatus.OK);
    }

    //elimina empleado
    @DeleteMapping({"/{empleadoId}"})
    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable("empleadoId") Long empleadoId) {
        empleadoService.deleteEmpleado(empleadoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

