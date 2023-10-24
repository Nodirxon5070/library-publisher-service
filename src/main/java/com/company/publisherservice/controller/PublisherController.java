package com.company.publisherservice.controller;

import com.company.publisherservice.dto.PublisherDto;
import com.company.publisherservice.dto.ResponseDto;
import com.company.publisherservice.dto.SimpleCRUD;
import com.company.publisherservice.service.PublisherService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
        tags = @Tag(name = "Publisher tag"),
        info = @Info(
                title = "Library Project",
                description = "Making changes on Publisher class",
                contact = @Contact(
                        name = "Library project",
                        url = "https://t.me/xan_5070",
                        email = "nodirxon5070@gmail.com"
                ),
                license = @License(name = "Publisher License",
                        url = "https://t.me/xan_5070")
        )
)
@RestController
@RequestMapping(value = "publisher")
public class PublisherController implements SimpleCRUD<Integer, PublisherDto> {

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
    @PostMapping(value = "/create")
    public ResponseDto<PublisherDto> create(@RequestBody PublisherDto dto) {
        return this.publisherService.create(dto);
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
    @GetMapping(value = "/get/{id}")
    public ResponseDto<PublisherDto> get(@PathVariable(value = "id") Integer entityId) {
        return this.publisherService.get(entityId);
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
    @PutMapping(value = "/update/{id}")
    public ResponseDto<PublisherDto> update(@PathVariable(value = "id") Integer entityId,@RequestBody PublisherDto dto) {
        return this.publisherService.update(entityId,dto);
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
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<PublisherDto> delete(@PathVariable(value = "id") Integer entityId) {
        return this.publisherService.delete(entityId);
    }
}
