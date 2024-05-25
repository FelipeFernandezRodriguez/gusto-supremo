package com.iudigital.gusto.supremo.dao;

import com.iudigital.gusto.supremo.domain.UnidadMedida;
import com.iudigital.gusto.supremo.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnidadMedidaDao {
    
    private static final String GET_UNIDAD_MEDIDA = "SELECT * FROM unidad_medida ";
    
    public List<UnidadMedida> getUnidadesMedidas() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<UnidadMedida> unidadesMedidas = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_UNIDAD_MEDIDA);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UnidadMedida unidadMedida = new UnidadMedida();

                unidadMedida.setId(resultSet.getInt("id_unidad_medida"));
                unidadMedida.setNombre(resultSet.getString("nombre"));
                unidadMedida.setDescripcion(resultSet.getString("descripcion"));

                unidadesMedidas.add(unidadMedida);
            }
            return unidadesMedidas;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
        
}
