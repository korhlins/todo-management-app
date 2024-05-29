package com.collins.todomanagement.dto;

import lombok.AllArgsConstructor;


public record TodoDto(Long id,
                      String title,
                      String description,
                      boolean isCompleted) {
}
