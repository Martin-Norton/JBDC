/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.Persistencias;


import Tienda.Entidades.fabricante;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author Martin Norton
 */
public final class DAOFabricante extends DAO {
     public void guardarFabricante(fabricante fab) throws Exception {
        try {
            if (fab == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            String sql = "INSERT INTO fabricante (codigo, nombre) " +
                    "VALUES (" + fab.getCodigo() + ", '" + fab.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarFabricante(fabricante fab) throws Exception {
        try {
            if (fab == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            String sql = "UPDATE fabricante SET nombre = '" + fab.getNombre() + "' WHERE codigo = " + fab.getCodigo();
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM fabricante WHERE codigo = " + codigo;
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public fabricante buscarFabricantePorCodigo(int codigo) throws Exception {
        fabricante fabricante = null;
        try {
            String sql = "SELECT * FROM fabricante WHERE codigo = " + codigo;
            consultarBase(sql);
            if (resultado.next()) {
                fabricante = new fabricante(resultado.getInt(1), resultado.getNString("nombre"));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    public Collection<fabricante> listaFabricantes() throws Exception {
        Collection<fabricante> fabricantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM fabricante";
            consultarBase(sql);
            while (resultado.next()) {
                fabricante fabricante = new fabricante(resultado.getInt(1), resultado.getNString("nombre"));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
