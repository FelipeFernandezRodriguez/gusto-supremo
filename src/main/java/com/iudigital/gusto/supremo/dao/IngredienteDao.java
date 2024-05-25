package com.iudigital.gusto.supremo.dao;

import com.iudigital.gusto.supremo.domain.Ingrediente;
import com.iudigital.gusto.supremo.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDao {
    
    private static final String GET_INGREDIENTES = "SELECT ingredientes.*, "
            + "unidad_medida.nombre AS unidad_medida_nombre "
            + "FROM ingredientes "
            + "INNER JOIN unidad_medida on ingredientes.id_unidad_medida = unidad_medida.id_unidad_medida "
            + "ORDER BY ingredientes.id_ingrediente ASC ";
    
    private static final String CREATE_INGREDIENTE = "INSERT INTO ingredientes (id_unidad_medida, nombre, cantidad_inventario, cantidad_minima ) "
            + "VALUES (?, ?, ?, ?) ";
    
    private static final String GET_INGREDIENTE_BY_ID = "SELECT ingredientes.*, "
            + "unidad_medida.nombre AS unidad_medida_nombre, "
            + "FROM ingredientes "
            + "INNER JOIN unidad_medida on ingredientes.id_unidad_medida = unidad_medida.id_unidad_medida "
            + "WHERE id_funcionario = ? ";
    
    private static final String UPDATE_INGREDIENTE = "UPDATE ingredientes SET id_unidad_medida = ?, nombre = ?, cantidad_inventario = ?, cantidad_minima = ? "
            + "WHERE id_ingrediente = ? ";
    
    private static final String DELETE_INGREDIENTE = "DELETE FROM ingredientes WHERE id_ingrediente = ? ";
    
    
    public List<Ingrediente> obtenerIngredientes() throws SQLException {        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        List<Ingrediente> ingredientes = new ArrayList<>();
        
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_INGREDIENTES);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                Ingrediente ingrediente = new Ingrediente();
                
                ingrediente.setId(resultSet.getInt("id_ingrediente"));
                ingrediente.setIdUnidadMedida(resultSet.getString("id_unidad_medida"));
                ingrediente.setUnidadMedidaNombre(resultSet.getString("unidad_medida_nombre"));
                ingrediente.setNombre(resultSet.getString("nombre"));
                ingrediente.setCantidadInventario(resultSet.getInt("cantidad_inventario"));
                ingrediente.setCantidadMinima(resultSet.getInt("cantidad_minima"));
                
                ingredientes.add(ingrediente);
            }
            return ingredientes;
        } finally {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        }        
    }
    
    
    public void crear (Ingrediente ingrediente) throws SQLException {        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
              
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_INGREDIENTE);
            
            preparedStatement.setInt(1, Integer.parseInt(ingrediente.getIdUnidadMedida()));
            preparedStatement.setString(2, ingrediente.getNombre());
            preparedStatement.setInt(3, ingrediente.getCantidadInventario());
            preparedStatement.setInt(4, ingrediente.getCantidadMinima());
            
            preparedStatement.executeUpdate();

            } finally {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }        
    }
    
    
    public Ingrediente obtenerIngrediente (int id) throws SQLException {        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Ingrediente ingrediente = null;
                
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_INGREDIENTE_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()){
                ingrediente = new Ingrediente();
                
                ingrediente.setId(resultSet.getInt("id_ingrediente"));
                ingrediente.setIdUnidadMedida(resultSet.getString("id_unidad_medida"));
                ingrediente.setUnidadMedidaNombre(resultSet.getString("unidad_medida_nombre"));
                ingrediente.setNombre(resultSet.getString("nombre"));
                ingrediente.setCantidadInventario(resultSet.getInt("cantidad_inventario"));
                ingrediente.setCantidadMinima(resultSet.getInt("cantidad_minima"));                        
            }
            return ingrediente;
        } finally {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        }  
    }
    
    
    public void actualizarIngrediente (int id, Ingrediente ingrediente) throws SQLException {        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
              
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_INGREDIENTE);
            
            preparedStatement.setInt(1, Integer.parseInt(ingrediente.getIdUnidadMedida()));
            preparedStatement.setString(2, ingrediente.getNombre());
            preparedStatement.setInt(3, ingrediente.getCantidadInventario());
            preparedStatement.setInt(4, ingrediente.getCantidadMinima());
            preparedStatement.setInt(5, id);
            
            preparedStatement.executeUpdate();

            } finally {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
            }        
    }
    
    
    public void eliminarIngrediente (int id) throws SQLException {        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
                
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_INGREDIENTE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }  
    }
    
    
}
