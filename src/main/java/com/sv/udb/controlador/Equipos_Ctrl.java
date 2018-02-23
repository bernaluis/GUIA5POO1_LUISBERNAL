/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.recursos.Conexion;
import java.sql.*;


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
}
