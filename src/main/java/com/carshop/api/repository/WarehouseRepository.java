package com.carshop.api.repository;

import com.carshop.api.entity.WarehouseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for manipulating Warehouse data. It extends <em>JPAs</em> {@link CrudRepository} which contains
 * most * of the CRUD operation methods.
 *
 * @author Shivaji Pote
 **/
@Repository
public interface WarehouseRepository extends CrudRepository<WarehouseEntity,Long> {
}
