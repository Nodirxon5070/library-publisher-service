package com.company.publisherservice.service;


import com.company.publisherservice.dto.ResponseDto;
import com.company.publisherservice.dto.request.PublisherRequestDto;
import com.company.publisherservice.dto.response.PublisherResponseDto;
import com.company.publisherservice.modul.Publisher;
import com.company.publisherservice.repository.PublisherRepository;
import com.company.publisherservice.service.mapper.PublisherMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public ResponseDto<PublisherResponseDto> create(@Valid PublisherRequestDto dto) {
        try{
            Publisher publisher = this.publisherMapper.toEntity(dto);
            publisher.setCreatedAt(LocalDateTime.now());
            this.publisherRepository.save(publisher);
            return ResponseDto.<PublisherResponseDto>builder()
                    .data(this.publisherMapper.toDto(publisher))
                    .message("OK")
                    .success(true)
                    .build();
        }catch (Exception e){
            return ResponseDto.<PublisherResponseDto>builder()
                    .code(-2)
                    .message(String.format("publisher save while error %s",e.getMessage()))
                    .build();
        }

    }

    public ResponseDto<PublisherResponseDto> get(@Valid Integer entityId) {
        return publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                .map(publisher ->
                     ResponseDto.<PublisherResponseDto>builder()
                            .message("OK")
                            .success(true)
                            .data(this.publisherMapper.toDto(publisher))
                            .build()
                ).orElse(ResponseDto.<PublisherResponseDto>builder()
                        .message("Publisher is not found!")
                        .code(-1)
                        .build());


    }

    public ResponseDto<PublisherResponseDto> update(@Valid Integer entityId, PublisherRequestDto dto) {
        try {
            return this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                    .map(publisher -> {
                        this.publisherMapper.updatePublisherFromDto(publisher,dto);
                        publisher.setUpdatedAt(LocalDateTime.now());
                        this.publisherRepository.save(publisher);
                        return ResponseDto.<PublisherResponseDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.publisherMapper.toDto(publisher))
                                .build();
                    }).orElse(ResponseDto.<PublisherResponseDto>builder()
                            .code(-1)
                            .message("Publisher is not found")
                            .build());
        }catch (Exception e){
            return ResponseDto.<PublisherResponseDto>builder()
                    .message(String.format("Publisher while updating error %s",e))
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<PublisherResponseDto> delete(@Valid Integer entityId) {
        return this.publisherRepository.findByPublisherIdAndDeletedAtIsNull(entityId)
                .map(publisher -> {
                    publisher.setDeletedAt(LocalDateTime.now());
                    this.publisherRepository.save(publisher);
                    return ResponseDto.<PublisherResponseDto>builder()
                            .success(true)
                            .message("OK")
                            .data(this.publisherMapper.toDto(publisher))
                            .build();
                }).orElse(ResponseDto.<PublisherResponseDto>builder()
                        .code(-1)
                        .message("Publisher is not found!")
                        .build());

        }
}
