package io.nosphere.prototype.core.contacts;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long id);

    Page<Contact> findByInactive(boolean inactive, Pageable pageable);
}
