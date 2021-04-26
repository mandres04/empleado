package com.api.rest.empleado.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.rest.empleado.model.Empleado;
import com.api.rest.empleado.repositories.EmpleadoRepository;

@Component
public class EmpleadoServiceImpl implements EmpleadoService {
    EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

	@Override
	public List<Empleado> getEmpleados() {
		// TODO Auto-generated method stub
		List<Empleado> empleados = new ArrayList<>();
		empleadoRepository.findAll().forEach(empleados::add);
		return empleados;

	}

	@Override
	public Empleado getEmpleadoById(Long id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id).get();
	}

	@Override
	public Empleado insert(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleado);
	}

	@Override
	public void updateEmpleado(Long id, Empleado empleado) {
		// TODO Auto-generated method stub
		Empleado empleadoDB = empleadoRepository.findById(id).get();
		System.out.println(empleadoDB.toString());
		
		empleadoDB.setNombre(empleado.getNombre());
		empleadoDB.setApellidos(empleado.getApellidos());
		empleadoDB.setFechaNacimiento(empleado.getFechaNacimiento());
		empleadoDB.setEmpleadoStatus(empleado.getEmpleadoStatus());
	    
		empleadoRepository.save(empleadoDB);
		
	}

	@Override
	public void deleteEmpleado(Long empleadoId) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(empleadoId);
		
	}

}
