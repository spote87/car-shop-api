package com.carshop.api.repository;

import com.carshop.api.entity.CarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Shivaji Pote
 **/
@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {

  @Query("SELECT c from CarEntity c INNER JOIN c.wareHouseEntity w WHERE w.warehouseId=:warehouseId AND c.carId=:carId")
  CarEntity findWareHouseAndCarId(@Param("warehouseId") Long warehouseId, @Param("carId") Long carId);

}
