package org.epde.tfm.infrastructure.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String field;
    private String message;
}