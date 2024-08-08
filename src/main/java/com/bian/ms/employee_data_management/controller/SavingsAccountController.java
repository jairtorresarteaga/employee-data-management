package com.bian.ms.employee_data_management.controller;

import com.bian.ms.employee_data_management.dto.InitiateRequestDTO;
import com.bian.ms.employee_data_management.dto.InitiateResponseDTO;
import com.bian.ms.employee_data_management.service.EmployeeDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/savings-account/v1.0")
public class SavingsAccountController {

    private final EmployeeDataService employeeDataService;

    public SavingsAccountController(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }

    @Operation(
            summary = "API para iniciar una nueva cuenta de ahorro",
            description = "Initiate a new savings account based on customer's identity document type and number",
            tags = {"Savings Account"}
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successful response",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = InitiateResponseDTO.class)
            )
    )
    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
    @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content)
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
    @ApiResponse(responseCode = "429", description = "Too Many Requests", content = @Content)
    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    @PostMapping("/initiate")
    public ResponseEntity<InitiateResponseDTO> initiateAccount(
            @Parameter(description = "Object containing customer identification details", required = true)
            @RequestBody InitiateRequestDTO requestDTO
    ) {
        InitiateResponseDTO initiateResponse = employeeDataService.createAccount(requestDTO );
        return ResponseEntity.ok(initiateResponse);
    }

}