package com.siili.wall.Domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColumnRepository extends CrudRepository <Column, Long> {
    List<Column> findByColumn(String column);
}
