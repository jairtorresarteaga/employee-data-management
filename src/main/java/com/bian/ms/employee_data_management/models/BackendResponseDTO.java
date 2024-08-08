package com.bian.ms.employee_data_management.models;

public class BackendResponseDTO {
    private String id_cuenta;
    private String tipo_moneda;

    // Constructor por defecto
    public BackendResponseDTO() {
    }

    // Getters para los campos
    public String getId_cuenta() {
        return id_cuenta;
    }

    public String getTipo_moneda() {
        return tipo_moneda;
    }

    // Setters para los campos (si es necesario para tu lógica de negocio)
    public void setId_cuenta(String id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setTipo_moneda(String tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }
}
