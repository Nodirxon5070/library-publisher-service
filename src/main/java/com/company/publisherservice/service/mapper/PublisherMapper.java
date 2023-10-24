package com.company.publisherservice.service.mapper;

import com.company.publisherservice.dto.PublisherDto;
import com.company.publisherservice.modul.Publisher;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class PublisherMapper {


    public abstract PublisherDto toDto(Publisher publisher);

    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target = "deletedAt",ignore = true)
    public abstract Publisher toEntity(PublisherDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updatePublisherFromDto(Publisher publisher,@MappingTarget PublisherDto dto);

}
