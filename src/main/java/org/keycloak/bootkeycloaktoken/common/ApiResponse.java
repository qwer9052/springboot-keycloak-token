package org.keycloak.bootkeycloaktoken.common;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    @Builder
    private ApiResponse(int code, T data, String message){
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
