package pl.hiquality.model;

public record ErrorResponse(
        Integer statusCode,
        String reason,
        String message
) {}
