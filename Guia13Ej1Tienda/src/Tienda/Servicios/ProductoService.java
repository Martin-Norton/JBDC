/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.Servicios;
import java.util.Collection;

import Tienda.Entidades.Producto;
import Tienda.Persistencias.DAOProducto;
/**
 *
 * @author Martin Norton
 */
public class ProductoService {

    private DAOProducto productoDao;

    public ProductoService() {
        productoDao = new DAOProducto();
    }

    public Collection<Producto> listarProductos() throws Exception {
        return productoDao.listaProducto();
    }

    public Collection<Producto> listarProductosPorPrecio(double precioMin, double precioMax) throws Exception {
        return productoDao.listaProductosPorPrecio(precioMin, precioMax);
    }

    public Collection<Producto> buscarPortatiles() throws Exception {
        return productoDao.buscarProductosPorTipo("Portátil");
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        return productoDao.buscarProductoPorCodigo(codigo);
    }

    public Producto buscarProductoMasBarato() throws Exception {
        return productoDao.buscarProductoMasBarato();
    }

    public void guardarProducto(Producto producto) throws Exception {
        productoDao.guardarProducto(producto);
    }



    public void editarProducto(Producto producto) throws Exception {
        productoDao.modificarProducto(producto);
    }

}
