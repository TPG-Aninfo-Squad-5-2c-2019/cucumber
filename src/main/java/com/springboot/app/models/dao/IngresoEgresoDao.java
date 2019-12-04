package com.springboot.app.models.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.app.models.entity.IngresoEgreso;

public class IngresoEgresoDao { 
    // static variable single_instance of type Singleton 
    private static IngresoEgresoDao single_instance = null; 

    private static List<IngresoEgreso> lista = new ArrayList<IngresoEgreso>();

    // static method to create instance of Singleton class 
    public static IngresoEgresoDao getInstance() 
    { 
        if (single_instance == null) {
            single_instance = new IngresoEgresoDao(); 
            lista.add(new IngresoEgreso("Egreso", "Gigabyte", "Compra de infraestructura tecnológica", 60.000));
            lista.add(new IngresoEgreso("Egreso", "Empleados PSA", "Pago de sueldos", 120.000));
            lista.add(new IngresoEgreso("Egreso", "Google Cloud", "Pago de servicios", 70.000));
            lista.add(new IngresoEgreso("Ingreso", "Amazon", "Pago de cliente en mora", 10.000));
            lista.add(new IngresoEgreso("Ingreso", "Coca-Cola SRL", "Pago de cliente en fecha", 50.000));
            lista.add(new IngresoEgreso("Ingreso", "Gobierno Nacional", "Cobro de contratos de soporte de cliente", 300.000));
        }   
  
        return single_instance; 
    }
    
    public void addIngresoEgreso(IngresoEgreso value) {
    	Boolean existente = false;
    	for(IngresoEgreso ie : lista) {
    		if(ie.getTipo().equals(value.getTipo()) && 
    				ie.getEmpresa().equals(value.getEmpresa()) &&
    				ie.getConcepto().equals(value.getConcepto())){
    			ie.setMonto(ie.getMonto()+value.getMonto());
    			existente = true;
    			break;
    		}   
    	}
    	if(!existente) {
   			 lista.add(value);
    	}
    }

    public List<IngresoEgreso> getAll() {
        return lista;
    }
} 