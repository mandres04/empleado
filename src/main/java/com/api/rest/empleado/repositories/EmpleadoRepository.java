package com.api.rest.empleado.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.empleado.model.Empleado;


@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
