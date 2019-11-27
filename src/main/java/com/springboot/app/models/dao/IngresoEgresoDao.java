package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.IngresoEgreso;

public class IngresoEgresoDao { 
    // static variable single_instance of type Singleton 
    private static IngresoEgresoDao single_instance = null; 

    private List<IngresoEgreso> lista = new ArrayList<IngresoEgreso>();

    // static method to create instance of Singleton class 
    public static IngresoEgresoDao getInstance() 
    { 
        if (single_instance == null) {
            single_instance = new IngresoEgresoDao(); 
            single_instance.addIngresoEgreso(new IngresoEgreso("Egreso", "Gigabyte", "Compra de infraestructura tecnológica", "60.000"));
            single_instance.addIngresoEgreso(new IngresoEgreso("Egreso", "Empleados PSA", "Pago de sueldos", "120.000"));
            single_instance.addIngresoEgreso(new IngresoEgreso("Egreso", "Google Cloud", "Pago de servicios", "70.000"));
            single_instance.addIngresoEgreso(new IngresoEgreso("Ingreso", "Amazon", "Pago de cliente en mora", "10.000"));
            single_instance.addIngresoEgreso(new IngresoEgreso("Ingreso", "Coca-Cola SRL", "Pago de cliente en fecha", "50.000"));
            single_instance.addIngresoEgreso(new IngresoEgreso("Ingreso", "Gobierno Nacional", "Cobro de contratos de soporte de cliente", "300.000"));
        }   
  
        return single_instance; 
    }
    
    public void addIngresoEgreso(IngresoEgreso value) {
        this.lista.add(value);
    }

    public List<IngresoEgreso> getAll() {
        return this.lista;
    }
} 