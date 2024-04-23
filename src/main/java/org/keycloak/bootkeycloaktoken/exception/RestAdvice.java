package org.keycloak.bootkeycloaktoken.exception;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.bootkeycloaktoken.common.ApiResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class RestAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleException(HttpServletRequest request, Exception ex){
        log.error(ex.getMessage(),ex);
        return ApiResponse.builder()
                .code(500)
                .message(ex.getMessage())
                .data(null)
                .build();
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ApiResponse errorData) {
            response.setStatusCode(HttpStatus.valueOf(errorData.getCode()));
            return ApiResponse.builder()
                    .code(errorData.getCode())
                    .data(errorData.getData())
                    .message(errorData.getMessage())
                    .build();
        }

        return ApiResponse.builder()
                .code(200)
                .data(body)
                .message("성공")
                .build();
    }
}
