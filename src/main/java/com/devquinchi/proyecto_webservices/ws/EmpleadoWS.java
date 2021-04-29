/**
 * 
 */
package com.devquinchi.proyecto_webservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.devquinchi.proyecto_webservices.entity.Empleado;
import com.devquinchi.proyecto_webservices.service.EmpleadoService;

/**
 * @author Julio
 * Webservices generado con JERSEY
 * Se le pone la abreviatura WS  ala clase para diferencia de las otras clases , ya que esta clase es de WEBSERVICES O API
 * Ruta del webservices ejemplo: localhost:8080/nombreProyecto/url-del-pattern que esta en web.xml/Nombre-del-Path de la clase/los metodos get,post,delete entre otras.
 * localhost:8080/proyecto-webservices/devquinchi/empleadoWS
 */
@Path("empleadoWS")
public class EmpleadoWS {
	private EmpleadoService EmpleadoService=new EmpleadoService();
	
	@Path("test")
	@GET
	public String test() {
		return "corriendo en el puerto 80";
		
	}
	@Path("consultarEmpleado")
	@GET
	@Produces(MediaType.APPLICATION_JSON) //RESULTADO QUE DESEO GENERAR
	//@Consumes(MediaType.APPLICATION_JSON) //ESTO ME PERMITE CONSUMIR A MI WEBSERVICES DESDE CUALQUIER APLICACION
	public Empleado consultarEmpleado() {
		return this.EmpleadoService.consultarEmpleado();
	}
	@GET
	@Path("listaEmpleado")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> listaEmpleado(){
		return this.EmpleadoService.consultarEmpleados();
	}
	// uso de parametros , uso de anotaciones
	@GET
	@Path("listaEmpleado/{idEmpleado}") //para agregar el parametro
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleadoById(@PathParam("idEmpleado") String id) { //agregar anotacion en el metodo, y en el apartado del parametro
		return this.EmpleadoService.consultarEmpleadoById(id);
	}
	
	// uso del response 
	@GET
	@Path("consultarEmpleadoPorID/{idEmpleado}") //para agregar el parametro	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoByID(@PathParam("idEmpleado") String id) { //agregar anotacion en el metodo, y en el apartado del parametro
		Empleado empleadoConsultado= this.EmpleadoService.consultarEmpleadoById(id);
		if(empleadoConsultado==null) {
			return Response.status(402).entity("No se encontro ").build();
			//return Response.noContent().build(); // yo creo que es para verificar si existe el contenido,y si no hay que no lo muestre
			
		}
		// es buena practica el uso de GenericEntity
		GenericEntity<Empleado> empleadoGeneric=new GenericEntity<Empleado>(empleadoConsultado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}
	
	// HACER METODO POST
	// validar resultados
	@POST
	@Path("guardarEmpleado") //para agregar el parametro	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado) {
		if(empleado==null) {
			return Response.status(400).entity("No se ingreso informacion del empleado, favor de capturar los datos").build();
		}if(empleado.getNombre()==null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre es requerido").build();
		}
		GenericEntity<Empleado> empleadoGeneric=new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}
}
