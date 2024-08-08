package com.bian.ms.employee_data_management.service;

import com.bian.ms.employee_data_management.dto.InitiateRequestDTO;
import com.bian.ms.employee_data_management.dto.InitiateResponseDTO;
import com.bian.ms.employee_data_management.models.BackendRequestDTO;
import com.bian.ms.employee_data_management.models.BackendResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeDataService {
    private final RestTemplate restTemplate;
    private final String backendServiceUrl = "https://apis.arquitecturabank.com/core/api/v1/crear-cuenta-ahorro";

    @Autowired
    public EmployeeDataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public InitiateResponseDTO createAccount(InitiateRequestDTO requestDTO) {

        BackendRequestDTO backendRequestDTO = new BackendRequestDTO(
                requestDTO.getPersonIdentification().getTypeOfIdentification(),
                requestDTO.getPersonIdentification().getIdentityCardNumber()
        );
        // Realiza la llamada POST al servicio backend y obtiene la respuesta
        BackendResponseDTO backendResponse = restTemplate.postForObject(
                backendServiceUrl,
                backendRequestDTO,
                BackendResponseDTO.class
        );

        // Asegúrate de que la respuesta del backend no sea nula antes de mapearla
        if (backendResponse == null) {
            throw new RuntimeException("No response from backend service");
        }

        // Mapea la respuesta del backend al DTO de respuesta esperado
        InitiateResponseDTO initiateResponseDTO = new InitiateResponseDTO();
        InitiateResponseDTO.AccountInnerDTO accountInnerDTO = new InitiateResponseDTO.AccountInnerDTO();
        accountInnerDTO.setIdentification(backendResponse.getId_cuenta());
        accountInnerDTO.setBaseCurrency(backendResponse.getTipo_moneda());
        initiateResponseDTO.setAccount(accountInnerDTO);

        // Retorna la respuesta mapeada
        return initiateResponseDTO;
    }

}
