package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.EmpleadoIT;

public class ProductividadEmpleadoDao { 
    // static variable single_instance of type Singleton 
    private static ProductividadEmpleadoDao single_instance = null; 

    private List<EmpleadoIT> lista = new ArrayList<EmpleadoIT>();

    // static method to create instance of Singleton class 
    public static ProductividadEmpleadoDao getInstance() 
    { 
        if (single_instance == null) {
            single_instance = new ProductividadEmpleadoDao(); 
            EmpleadoIT a = new EmpleadoIT("Carlos Dijkstra");
            a.addProductividadPorProyecto("PSA BA 1.1", 80);
            a.addProductividadPorProyecto("PSA CRM 1.0", 70);
            EmpleadoIT b = new EmpleadoIT("Emanuel Torvalds");
            b.addProductividadPorProyecto("PSA BA 1.1", 90);
            b.addProductividadPorProyecto("PSA New Spring ERP 3.0", 92);
            EmpleadoIT c = new EmpleadoIT("Germán Turing");
            c.addProductividadPorProyecto("PSA ERP 3.4", 65);
            c.addProductividadPorProyecto("PSA CRM 1.0", 85);
            single_instance.addEmpleado(a);
            single_instance.addEmpleado(b);
            single_instance.addEmpleado(c);
            }   
            
        return single_instance; 
    }
    
    public void addEmpleado(EmpleadoIT value) {
        this.lista.add(value);
    }

    public List<EmpleadoIT> getAll() {
        return this.lista;
    }
} 