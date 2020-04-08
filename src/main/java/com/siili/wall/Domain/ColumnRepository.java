package com.siili.wall.Domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ColumnRepository extends CrudRepository <Column, Long> {

    Optional<Column> findByName(String name);
}
