/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoG9.dao;

import com.proyectoG9.domain.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alon1
 */

public interface ReporteDao extends JpaRepository<Reporte, Long>{
    
}
