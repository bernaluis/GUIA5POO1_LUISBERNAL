/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Equipos;
import com.sv.udb.recursos.Conexion;
import java.sql.*;
import java.util.*;


/**
 *
 * @author vergo_000
 */
public class Equipos_Ctrl {
    private final Connection conn;


    public Equipos_Ctrl() {
        this.conn = new Conexion().getCon();
    }



    public boolean guardarEquipo(String nombreEquipo,String descEquipo)
    {
        boolean resp=false;
        try{
            PreparedStatement cmd= this.conn.prepareStatement("INSERT INTO equipos VALUES (NULL, ?, ?)");
            cmd.setString(1, nombreEquipo);
            cmd.setString(2, descEquipo);
            cmd.executeUpdate();
            resp=true;
        }
        catch(SQLException e)
        {
            System.err.println("Error al guardar el equipo "+e.getMessage());
        }
        finally
        {
            try {
                if(this.conn!=null){
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion "+e.getMessage());
            }
        }
        return resp;
    }
    public boolean eliminarEquipo(String codigoEquipo)
    {
                boolean resp=false;
        try{
            PreparedStatement cmd= this.conn.prepareStatement("delete  from equipos where codi_equi=?");
            cmd.setString(1, codigoEquipo);
            cmd.executeUpdate();
            resp=true;
        }
        catch(SQLException e)
        {
            System.err.println("Error al eliminar el equipo "+e.getMessage());
        }
        finally
        {
            try {
                if(this.conn!=null){
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion "+e.getMessage());
            }
        }
        return resp;
    }
    public boolean actualizarEquipo(String codigoEquipo,String nombreEquipo,String descEquipo)
    {
         boolean resp=false;
        try{
            PreparedStatement cmd= this.conn.prepareStatement("UPDATE `equipos` SET `nomb_equi`=?,`desc_equi`=? WHERE codi_equi=?");
            cmd.setString(1, nombreEquipo);
            cmd.setString(2, descEquipo);
            cmd.setString(3, codigoEquipo);
            cmd.executeUpdate();
            resp=true;
        }
        catch(SQLException e)
        {
            System.err.println("Error al actualizar el equipo "+e.getMessage());
        }
        finally
        {
            try {
                if(this.conn!=null){
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion "+e.getMessage());
            }
        }
        return resp;
    }
    /**
     * 
     * @return 
     */
    public List<Equipos> consTodo()
    {
       List<Equipos> resp = new ArrayList<>();
        try
        {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM equipos");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                resp.add(new Equipos(rs.getInt(1),rs.getString(2), rs.getString(3)));
            }
        }
        catch(SQLException ex)
        {
            System.err.println("Error al consultar Equipos: " + ex.getMessage());
        }
        finally
        {
            try
            {
                if(this.conn != null)
                {
                    if(!this.conn.isClosed())
                    {
                        this.conn.close();
                    }
                }
            }
            catch(SQLException ex)
            {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return resp;
    }
}
