package com.company.publisherservice.service.mapper;

import com.company.publisherservice.dto.request.PublisherRequestDto;
import com.company.publisherservice.dto.response.PublisherResponseDto;
import com.company.publisherservice.dto.response.PublisherResponseDto.PublisherResponseDtoBuilder;
import com.company.publisherservice.modul.Publisher;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T17:29:24+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class PublisherMapperImpl extends PublisherMapper {

    @Override
    public PublisherResponseDto toDto(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherResponseDtoBuilder publisherResponseDto = PublisherResponseDto.builder();

        publisherResponseDto.publisherId( publisher.getPublisherId() );
        publisherResponseDto.publisher( publisher.getPublisher() );
        publisherResponseDto.location( publisher.getLocation() );
        publisherResponseDto.createdAt( publisher.getCreatedAt() );
        publisherResponseDto.updatedAt( publisher.getUpdatedAt() );
        publisherResponseDto.deletedAt( publisher.getDeletedAt() );

        return publisherResponseDto.build();
    }

    @Override
    public Publisher toEntity(PublisherRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Publisher publisher = new Publisher();

        publisher.setPublisher( dto.getPublisher() );
        publisher.setLocation( dto.getLocation() );

        return publisher;
    }

    @Override
    public Publisher updatePublisherFromDto(Publisher publisher, PublisherRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getPublisher() != null ) {
            publisher.setPublisher( dto.getPublisher() );
        }
        if ( dto.getLocation() != null ) {
            publisher.setLocation( dto.getLocation() );
        }

        return publisher;
    }
}
