package br.com.vitorhugo.config;

/**
 *
 * @author alexandre
 */
public record ErrorResponse(
    int status,
    String message,
    String stackTrace,
    long timestamp
) {}
