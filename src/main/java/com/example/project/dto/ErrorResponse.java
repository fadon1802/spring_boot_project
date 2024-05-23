package com.example.project.dto;

public record ErrorResponse(int status, String message, String error) {
}
