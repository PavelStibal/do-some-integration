package cz.pavelstibal.domain;

import lombok.Data;

@Data
public class CommonModel {

    private String operation;

    private IntegrationApiModel apiModel;
}
