/**
 * 
 */
package com.devquinchi.proyecto_webservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.devquinchi.proyecto_webservices.entity.Empleado;

/**
 * @author Julio
 * metodo que simula la consulta de un empleado
 * @return {@link String} empleado consultado
 */
public class EmpleadoService {
	
	/**
	 * metodo que permite consultar por el ID
	 * @param id
	 * @return {@link lista} lista de empleado
	 */
	public Empleado consultarEmpleadoById(String id) {
		List<Empleado> empleado=this.consultarEmpleados();
		for (Empleado empleadoConsultado : empleado) {
			if(empleadoConsultado.getNumeroEmpleado().equals(id)) {
				return empleadoConsultado;
			}
			
		}
		return null;
	}
	public Empleado consultarEmpleado() {
		Empleado empleado=new Empleado();
		empleado.setNumeroEmpleado("12345");
		empleado.setNombre("Julio");
		empleado.setPrimerApellido("Quinchiguango");
		empleado.setSegundoApellido("Maldonado");
		empleado.setEdad(31);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		return empleado;
	}
	/**
	 * Metodo que permite consultar la lista de empleados
	 * @return {@link Lista} lista consultada
	 */
	public List<Empleado> consultarEmpleados(){
		List<Empleado> empleados=new ArrayList();
		Empleado empleado=new Empleado();
		empleado.setNumeroEmpleado("12345");
		empleado.setNombre("Carlos");
		empleado.setPrimerApellido("Quinchi");
		empleado.setSegundoApellido("Maradona");
		empleado.setEdad(34);
		empleado.setFechaCreacion(LocalDateTime.now());
		
		Empleado empleadonuevo=new Empleado();
		empleadonuevo.setNumeroEmpleado("123456");
		empleadonuevo.setNombre("Carlos");
		empleadonuevo.setPrimerApellido("Quinchi");
		empleadonuevo.setSegundoApellido("Maradona");
		empleadonuevo.setEdad(34);
		empleadonuevo.setFechaCreacion(LocalDateTime.now());
		
		empleados.add(empleado);
		empleados.add(empleadonuevo);
		
		return empleados;
		
		
	}

}
