package com.iudigital.gusto.supremo.controller;

import com.iudigital.gusto.supremo.dao.UnidadMedidaDao;
import com.iudigital.gusto.supremo.domain.UnidadMedida;
import java.sql.SQLException;
import java.util.List;

public class UnidadMedidaController {
    
    private UnidadMedidaDao unidadMedidaDao;
    
    public UnidadMedidaController() {
        unidadMedidaDao = new UnidadMedidaDao();
    }
    
    public List<UnidadMedida> getUnidadesMedidas () throws SQLException {
        return unidadMedidaDao.getUnidadesMedidas();
    }
    
}
