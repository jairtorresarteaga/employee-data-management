package com.bian.ms.employee_data_management.models;

public class BackendRequestDTO {
    private String tipo_documento;
    private String numero_documento;

    // Constructor por defecto
    public BackendRequestDTO() {
    }

    // Constructor con parámetros
    public BackendRequestDTO(String tipo_documento, String numero_documento) {
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
    }

    // Getter y setter para tipo_documento
    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    // Getter y setter para numero_documento
    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }
}
