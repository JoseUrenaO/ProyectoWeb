package com.proyectoG9.service.impl;

import com.proyectoG9.dao.ReporteDao;
import com.proyectoG9.domain.Reporte;

import com.proyectoG9.service.ReporteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReporteServiceImpl implements ReporteService {

    //La anotacion Autowire crea un unico objeto sin hacer new.. y se mantiene
    @Autowired
    private ReporteDao reporteDao;

    @Override
    public Reporte getCategoria(Reporte reporte) {
        return reporteDao.findById(reporte.getIdReporte()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reporte reporte) {
        reporteDao.save(reporte);
    }

    @Override
    @Transactional
    public void delete(Reporte reporte) {
        reporteDao.delete(reporte);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reporte> getReportees() {
        List<Reporte> lista = reporteDao.findAll();
       
        return lista;
    }

   

}
