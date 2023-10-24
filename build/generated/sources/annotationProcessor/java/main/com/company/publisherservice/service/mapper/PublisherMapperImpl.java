package com.company.publisherservice.service.mapper;

import com.company.publisherservice.dto.PublisherDto;
import com.company.publisherservice.dto.PublisherDto.PublisherDtoBuilder;
import com.company.publisherservice.modul.Publisher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T18:02:15+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class PublisherMapperImpl extends PublisherMapper {

    @Override
    public PublisherDto toDto(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherDtoBuilder publisherDto = PublisherDto.builder();

        publisherDto.publisherId( publisher.getPublisherId() );
        publisherDto.publisher( publisher.getPublisher() );
        publisherDto.location( publisher.getLocation() );
        publisherDto.createdAt( publisher.getCreatedAt() );
        publisherDto.updatedAt( publisher.getUpdatedAt() );
        publisherDto.deletedAt( publisher.getDeletedAt() );

        return publisherDto.build();
    }

    @Override
    public Publisher toEntity(PublisherDto dto) {
        if ( dto == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setPublisherId( dto.getPublisherId() );
        publisher.setPublisher( dto.getPublisher() );
        publisher.setLocation( dto.getLocation() );

        return publisher;
    }

    @Override
    public void updatePublisherFromDto(Publisher publisher, PublisherDto dto) {
        if ( publisher == null ) {
            return;
        }

        if ( publisher.getPublisherId() != null ) {
            dto.setPublisherId( publisher.getPublisherId() );
        }
        if ( publisher.getPublisher() != null ) {
            dto.setPublisher( publisher.getPublisher() );
        }
        if ( publisher.getLocation() != null ) {
            dto.setLocation( publisher.getLocation() );
        }
        if ( publisher.getCreatedAt() != null ) {
            dto.setCreatedAt( publisher.getCreatedAt() );
        }
        if ( publisher.getUpdatedAt() != null ) {
            dto.setUpdatedAt( publisher.getUpdatedAt() );
        }
        if ( publisher.getDeletedAt() != null ) {
            dto.setDeletedAt( publisher.getDeletedAt() );
        }
    }
}
