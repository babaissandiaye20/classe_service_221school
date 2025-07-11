package com.Test.gesclass.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestResponse<T> {
    @Builder.Default
    private int code = 201;
    @Builder.Default
    private String status = "CREATED";
    private T data;
    private String message;
} 