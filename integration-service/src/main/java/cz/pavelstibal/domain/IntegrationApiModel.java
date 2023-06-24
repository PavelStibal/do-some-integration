package cz.pavelstibal.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = Account.class)
public class IntegrationApiModel {
}
