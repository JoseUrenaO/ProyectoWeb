package com.proyectoG9.controller;

import com.proyectoG9.domain.Reporte;
import com.proyectoG9.service.FirebaseStorageService;
import com.proyectoG9.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Alon1
 */
@Controller
@RequestMapping("/reporte")
public class ReporteController {



        @Autowired
        private ReporteService reporteService;

        @GetMapping("/listado")
        public String listado(Model model) {
            var lista = reporteService.getReportees();
            model.addAttribute("lista", lista);
            model.addAttribute("totalReportees", lista.size());
            return "/reporte/listado";
        }

        @GetMapping("/nuevo")
        public String reporteNuevo(Reporte reporte) {
            return "/reporte/modifica";
        }

        @Autowired
        private FirebaseStorageService firebaseStorageService;

        @PostMapping("/guardar")
        public String reporteGuardar(Reporte reporte,
                @RequestParam("imagenFile") MultipartFile imagenFile) {
            if (!imagenFile.isEmpty()) {
                reporteService.save(reporte);
                reporte.setImagen(
                        firebaseStorageService.cargaImagen(
                                imagenFile,
                                "reporte",
                                reporte.getIdReporte()));
            }
            reporteService.save(reporte);
            return "redirect:/reporte/listado";
        }

        @GetMapping("/eliminar/{idReporte}")
        public String reporteEliminar(Reporte reporte) {
            reporteService.delete(reporte);
            return "redirect:/reporte/listado";
        }

        @GetMapping("/modificar/{idReporte}")
        public String categoriaModificar(Reporte reporte, Model model) {
            reporte = (Reporte) reporteService.getCategoria(reporte);
            model.addAttribute("reporte", reporte);
            return "/reporte/modifica";
        }

    }

