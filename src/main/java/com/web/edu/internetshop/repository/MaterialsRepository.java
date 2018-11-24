package com.web.edu.internetshop.repository;

import com.web.edu.internetshop.model.product.Materials;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, Long> {

    Page<Materials> findAllByAvailable(Boolean available, Pageable pageable);

}
