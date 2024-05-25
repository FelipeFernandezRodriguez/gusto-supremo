package com.iudigital.gusto.supremo.controller;

import com.iudigital.gusto.supremo.dao.IngredienteDao;
import com.iudigital.gusto.supremo.domain.Ingrediente;
import java.sql.SQLException;
import java.util.List;

public class IngredienteController {
    
    private IngredienteDao ingredienteDao;
    
    public IngredienteController() {
        ingredienteDao = new IngredienteDao();
    }
    
    public List<Ingrediente> obtenerIngredientes() throws SQLException {
        return ingredienteDao.obtenerIngredientes();
    }
    
    public void crear(Ingrediente ingrediente) throws SQLException {
        ingredienteDao.crear(ingrediente);
    }
    
    public Ingrediente obtenerIngrediente(int id) throws SQLException {
        return ingredienteDao.obtenerIngrediente(id);
    }
    
    public void actualizarIngrediente(int id, Ingrediente ingrediente) throws SQLException {
        ingredienteDao.actualizarIngrediente(id, ingrediente);
    }
    
    public void eliminarIngrediente(int id) throws SQLException {
        ingredienteDao.eliminarIngrediente(id);
    }
    
}
