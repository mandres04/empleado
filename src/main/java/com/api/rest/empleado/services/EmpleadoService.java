package com.api.rest.empleado.services;

import java.util.List;

import com.api.rest.empleado.model.Empleado;

public interface EmpleadoService {
    List<Empleado> getEmpleados();

    Empleado getEmpleadoById(Long id);

    Empleado insert(Empleado empleado);

    void updateEmpleado(Long id, Empleado empleado);

    void deleteEmpleado(Long empleadoId);
}
