package com.springboot.app.controllers;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import com.springboot.app.models.dao.ProductividadEmpleadoDao;
import com.springboot.app.models.entity.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DesarrolladoresController {
    @RequestMapping(value="/desarrolladores", method= RequestMethod.GET)
    public String desarroladores( Model model) {
        ProductividadEmpleadoDao dao = ProductividadEmpleadoDao.getInstance();
        List<EmpleadoIT> list = dao.getAll();
        List<ProductividadDesarrolladorData> list2 = new ArrayList<ProductividadDesarrolladorData>();
        for (EmpleadoIT empleado: list) {
            Map<String, Integer> prod = empleado.getDataProductividad();
            for (Map.Entry<String, Integer> entry : prod.entrySet()) {
                list2.add(new ProductividadDesarrolladorData(empleado.getNombre(), entry.getKey(), entry.getValue()));
            }
        }
        model.addAttribute("desarrolladores_data", list2);
        return "desarrolladores";
    }
}

class ProductividadDesarrolladorData {
    String nombreDesarrollador;
    String nombreProyecto;
    Integer nivelEsfuerzo;

    ProductividadDesarrolladorData(String nombreDesarrollador, String nombreProyecto, Integer nivelEsfuerzo) {
        this.nombreDesarrollador = nombreDesarrollador;
        this.nombreProyecto = nombreProyecto;
        this.nivelEsfuerzo = nivelEsfuerzo;
    }

    public String getNombreDesarrollador() {
        return this.nombreDesarrollador;
    }

    public String getNombreProyecto() {
        return this.nombreProyecto;
    }

    public Integer getNivelEsfuerzo() {
        return this.nivelEsfuerzo;
    }
}