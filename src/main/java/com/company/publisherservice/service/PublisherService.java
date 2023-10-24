package com.company.publisherservice.service;


import com.company.publisherservice.dto.PublisherDto;
import com.company.publisherservice.dto.ResponseDto;
import com.company.publisherservice.dto.SimpleCRUD;
import com.company.publisherservice.modul.Publisher;
import com.company.publisherservice.repository.PublisherRepository;
import com.company.publisherservice.service.mapper.PublisherMapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public record PublisherService(PublisherRepository publisherRepository,
                               PublisherMapper publisherMapper
                               )
        implements SimpleCRUD<Integer, PublisherDto> {
    @Override
    public ResponseDto<PublisherDto> create(@Valid PublisherDto dto) {
        try{
            Publisher publisher = this.publisherMapper.toEntity(dto);
            publisher.setCreatedAt(LocalDateTime.now());
            this.publisherRepository.save(publisher);
            return ResponseDto.<PublisherDto>builder()
                    .data(this.publisherMapper.toDto(publisher))
                    .message("OK")
                    .success(true)
                    .build();
        }catch (Exception e){
            return ResponseDto.<PublisherDto>builder()
                    .code(-2)
                    .message(String.format("publisher save while error %s",e.getMessage()))
                    .build();
        }

    }

    @Override
    public ResponseDto<PublisherDto> get(@Valid Integer entityId) {
        return publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                .map(publisher ->
                     ResponseDto.<PublisherDto>builder()
                            .message("OK")
                            .success(true)
                            .data(this.publisherMapper.toDto(publisher))
                            .build()
                ).orElse(ResponseDto.<PublisherDto>builder()
                        .message("Publisher is not found!")
                        .code(-1)
                        .build());


    }

    @Override
    public ResponseDto<PublisherDto> update(@Valid Integer entityId, PublisherDto dto) {
        try {
            return this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                    .map(publisher -> {
                        this.publisherMapper.updatePublisherFromDto(publisher,dto);
                        publisher.setUpdatedAt(LocalDateTime.now());
                        this.publisherRepository.save(publisher);
                        return ResponseDto.<PublisherDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.publisherMapper.toDto(publisher))
                                .build();
                    }).orElse(ResponseDto.<PublisherDto>builder()
                            .code(-1)
                            .message("Publisher is not found")
                            .build());
        }catch (Exception e){
            return ResponseDto.<PublisherDto>builder()
                    .message(String.format("Publisher while updating error %s",e))
                    .code(-2)
                    .build();
        }
    }

    @Override
    public ResponseDto<PublisherDto> delete(@Valid Integer entityId) {
        return this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                .map(publisher -> {
                    publisher.setDeletedAt(LocalDateTime.now());
                    this.publisherRepository.save(publisher);
                    return ResponseDto.<PublisherDto>builder()
                            .success(true)
                            .message("OK")
                            .data(this.publisherMapper.toDto(publisher))
                            .build();
                }).orElse(ResponseDto.<PublisherDto>builder()
                        .code(-1)
                        .message("Publisher is not found!")
                        .build());

        }
}
