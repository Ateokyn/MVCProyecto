/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.*; 

/**
 *
 * @author Kentry Gutter
 */
public class DAOAutor {
    
    public Autor Insertar(String cedula,String nombres, String apellidos, String email, java.sql.Date fechaNac){
        String transacciones = "INSERT INTO Autor VALUES('"
                + nombres + "', '"
                + apellidos + "', '"
                + email + "', '"
                + cedula + "', '"
                + fechaNac + "')";
        
        if(new DataBase().Actualizar(transacciones) > 0){
            return new Autor(cedula, nombres, apellidos, email, fechaNac);
        }
        return null;
    }
    
    public int Actualizar(int id, String nombres, String apellidos, String email,String cedula, java.sql.Date fechaNac){
        String transaccion = "UPDATE Autor SET nombres='"
                + nombres + "', apellidos='"
                + apellidos + "', email='"
                + email + "', fechaNac='"
                + fechaNac+ "', cedula='"
                + cedula  + "' WHERE id_autor="
                + id;
        return new DataBase(). Actualizar(transaccion);
    }
    
    public List ObtenerDatos(){
        String transaccion = "SELECT * FROM Autor";
        
        List<Map> registros = new DataBase(). Listar(transaccion);
        List<Autor> autores = new ArrayList();
        
        for(Map registro : registros){
            Autor aut =  new Autor((int)registro.get("id_autor"),
            (String)registro.get("nombres"),
            (String)registro.get("apellidos"),
            (String)registro.get("email"),
            (String)registro.get("cedula"),
            (java.sql.Date) registro.get("fechaNac"));
            autores.add(aut);
        }
        return autores;
    }
    
    public int Eliminar(int id){
        String transaccion = "DELETE FROM Autor WHERE id_autor='" + id + "'";
        
        return new DataBase().Actualizar(transaccion);
    }
}
