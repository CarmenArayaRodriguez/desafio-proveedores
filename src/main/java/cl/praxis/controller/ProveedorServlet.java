package cl.praxis.controller;

import cl.praxis.model.Proveedor;
import cl.praxis.model.dao.ProveedorDAO;
import cl.praxis.model.dao.ProveedorDAOImpl;
import cl.praxis.model.dto.ProveedorDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value= {"/ProveedorServlet", "/"})
public class ProveedorServlet extends HttpServlet {
	
	   @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   System.out.println("Recibiendo solicitud GET para la página de inicio");
	        response.sendRedirect("view/index.jsp");
	    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8"); 
    	System.out.println("Recibiendo solicitud POST");
        // Recuperar los datos del formulario
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");

        // Logging de datos recibidos
        System.out.println("Datos recibidos: Nombre=" + nombre + ", RUT=" + rut + ", Dirección=" + direccion + ", Correo=" + correo + ", Teléfono=" + telefono + ", Contacto=" + contacto + ", Teléfono Contacto=" + telefonoContacto);

        // Crear el modelo y asignar valores
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(nombre);
        proveedor.setRut(rut);
        proveedor.setDireccion(direccion);
        proveedor.setCorreo(correo);
        proveedor.setTelefono(telefono);
        proveedor.setContacto(contacto);
        proveedor.setTelefonoContacto(telefonoContacto);

        // Instanciar el DAO y realizar la inserción
        ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
        try {
            boolean success = proveedorDAO.addProveedor(proveedor);
            if (success) {
                System.out.println("Proveedor insertado exitosamente.");
            } else {
                System.out.println("Error al insertar el proveedor.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Excepción al insertar el proveedor: " + e.getMessage());
        }

        // Obtener la lista actualizada de proveedores
        try {
            List<ProveedorDTO> proveedores = proveedorDAO.getAllProveedoresDTO();
            System.out.println("Total de proveedores recuperados en servlet: " + proveedores.size());
            request.setAttribute("proveedores", proveedores);
            request.getRequestDispatcher("/view/proveedores.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Excepción al obtener la lista de proveedores: " + e.getMessage());
        }
    }
}
