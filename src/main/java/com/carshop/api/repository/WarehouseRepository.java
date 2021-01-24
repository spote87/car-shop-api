package com.carshop.api.repository;

import com.carshop.api.entity.WarehouseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shivaji Pote
 **/
@Repository
public interface WarehouseRepository extends CrudRepository<WarehouseEntity,Long> {
}
