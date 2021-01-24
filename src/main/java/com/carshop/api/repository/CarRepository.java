package com.carshop.api.repository;

import com.carshop.api.entity.CarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for manipulating Cars data. It extends <em>JPAs</em> {@link CrudRepository} which contains most
 * of the CRUD operation methods.
 *
 * @author Shivaji Pote
 **/
@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {

  /**
   * This method retrieves Car's data for specified car id and warehouse id.
   *
   * @param warehouseId warehouse id
   * @param carId       car id
   * @return Car entity
   */
  @Query("SELECT c from CarEntity c INNER JOIN c.wareHouseEntity w WHERE w.warehouseId=:warehouseId AND c.carId=:carId")
  CarEntity findWareHouseAndCarId(@Param("warehouseId") Long warehouseId, @Param("carId") Long carId);

}
