package com.company.publisherservice.controller;

import com.company.publisherservice.dto.ResponseDto;
import com.company.publisherservice.dto.SimpleCRUD;
import com.company.publisherservice.dto.request.PublisherRequestDto;
import com.company.publisherservice.dto.response.PublisherResponseDto;
import com.company.publisherservice.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.publisherservice.constants.Constants.EXAMPLE_PUBLISHER_NOT_FOUND;
import static com.company.publisherservice.constants.Constants.EXAMPLE_PUBLISHER_SUCCESS;
import static com.company.publisherservice.constants.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequestMapping(value = "publisher")
public class PublisherController implements SimpleCRUD<Integer, PublisherResponseDto, PublisherRequestDto> {

    @Autowired
    private PublisherService publisherService;

    @Override
    @Operation(
            method = "Post",
            summary = "This method creates Publisher",
            description = "Create Publisher",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            )

    })
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto<PublisherResponseDto>> create(@RequestBody PublisherRequestDto dto) {
        return convertStatusCodeByData(this.publisherService.create(dto));
    }

    @Override
    @Operation(
            method = "Get",
            summary = "This method gets Publisher",
            description = "Get Publisher",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            )

    })
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseDto<PublisherResponseDto>> get(@PathVariable(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.publisherService.get(entityId));
    }

    @Override
    @Operation(
            method = "Put",
            summary = "This method Updates Publisher",
            description = "Updates Publisher",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            )

    })
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDto<PublisherResponseDto>> update(@PathVariable(value = "id") Integer entityId, @RequestBody PublisherRequestDto dto) {
        return convertStatusCodeByData(this.publisherService.update(entityId,dto));
    }

    @Override
    @Operation(
            method = "Delete",
            summary = "This method deletes Publisher",
            description = "Delete Publisher",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_PUBLISHER_NOT_FOUND)
                            )
                    }

            )

    })
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto<PublisherResponseDto>> delete(@PathVariable(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.publisherService.delete(entityId));
    }
}
