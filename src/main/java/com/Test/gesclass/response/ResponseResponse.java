package com.Test.gesclass.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResponse<T> {
    @Builder.Default
    private int code = 200;
    @Builder.Default
    private String status = "OK";
    private T data;
    private String message;
} 