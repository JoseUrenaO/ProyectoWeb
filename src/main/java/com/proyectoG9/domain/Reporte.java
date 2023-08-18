package com.proyectoG9.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "reporte")

public class Reporte implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    
    private Long idReporte;
    private String imagen;
    private Long numeroRamas;
    private String tipoFlor;
    private Long anosVida;

    public Reporte() {
    }

    public Reporte(String imagen, Long numeroRamas, String tipoFlor, Long anosVida) {
        this.imagen = imagen;
        this.numeroRamas = numeroRamas;
        this.tipoFlor = tipoFlor;
        this.anosVida = anosVida;
    }

    public boolean isActivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        
    
}
