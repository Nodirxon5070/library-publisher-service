package com.company.publisherservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublisherResponseDto {

    private Integer publisherId;
    @NotBlank(message = "Publisher cannot be null or empty")
    private String publisher;
    @NotBlank(message = "Location cannot be null or empty")
    private String location;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
