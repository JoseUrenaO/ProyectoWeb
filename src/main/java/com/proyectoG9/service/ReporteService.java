package com.proyectoG9.service;


import com.proyectoG9.domain.Reporte;
import java.util.List;

public interface ReporteService {
    //El siguiente metodo retorna una lista con las categorias
    //Que estan en la tabla categoria, todas o solo las activas
    public List<Reporte> getReportees();
    
    //Aca siguien los metodos para hacer un CRUD de la tabla categoria
    // Se obtiene un Categoria, a partir del id de un categoria
    public Reporte getCategoria(Reporte reporte);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Reporte reporte);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Reporte reporte);
}
