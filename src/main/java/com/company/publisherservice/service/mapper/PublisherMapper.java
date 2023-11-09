package com.company.publisherservice.service.mapper;

import com.company.publisherservice.dto.request.PublisherRequestDto;
import com.company.publisherservice.dto.response.PublisherResponseDto;
import com.company.publisherservice.modul.Publisher;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class PublisherMapper {


    public abstract PublisherResponseDto toDto(Publisher publisher);


    public abstract Publisher toEntity(PublisherRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Publisher.class)
    public abstract Publisher updatePublisherFromDto(@MappingTarget Publisher publisher, PublisherRequestDto dto);

}
