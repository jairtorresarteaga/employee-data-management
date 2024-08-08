package com.bian.ms.employee_data_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitiateResponseDTO {
    @JsonProperty("Account")
    private AccountInnerDTO account;

    public AccountInnerDTO getAccount() {
        return account;
    }

    public void setAccount(AccountInnerDTO account) {
        this.account = account;
    }

    public static class AccountInnerDTO {

        @JsonProperty("Identification")
        private String identification;

        @JsonProperty("BaseCurrency")
        private String baseCurrency;

        public String getIdentification() {
            return identification;
        }

        public void setIdentification(String identification) {
            this.identification = identification;
        }

        public String getBaseCurrency() {
            return baseCurrency;
        }

        public void setBaseCurrency(String baseCurrency) {
            this.baseCurrency = baseCurrency;
        }
    }
}
