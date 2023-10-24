package com.company.publisherservice.repository;

import com.company.publisherservice.modul.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
    Optional<Publisher> findByPublisherIdAndDeletedAtIsNull(Integer publisherId);

    List<Publisher> findAllByDeletedAtIsNull();
}
