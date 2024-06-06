package com.collins.todomanagement.dto;

public record TodoDto(Long id,
                      String title,
                      String description,
                      boolean isCompleted) {
}
