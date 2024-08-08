package com.bian.ms.employee_data_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;



public class InitiateRequestDTO {

    @JsonProperty("PersonIdentification")
    private PersonIdentificationDTO personIdentification;

    public PersonIdentificationDTO getPersonIdentification() {
        return personIdentification;
    }

    public void setPersonIdentification(PersonIdentificationDTO personIdentification) {
        this.personIdentification = personIdentification;
    }

    public static class PersonIdentificationDTO {

        @JsonProperty("TypeOfIdentification")
        private String typeOfIdentification;

        @JsonProperty("IdentityCardNumber")
        private String identityCardNumber;

        public String getTypeOfIdentification() {
            return typeOfIdentification;
        }

        public void setTypeOfIdentification(String typeOfIdentification) {
            this.typeOfIdentification = typeOfIdentification;
        }

        public String getIdentityCardNumber() {
            return identityCardNumber;
        }

        public void setIdentityCardNumber(String identityCardNumber) {
            this.identityCardNumber = identityCardNumber;
        }
    }
}
