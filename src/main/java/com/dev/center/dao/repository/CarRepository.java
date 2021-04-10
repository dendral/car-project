package com.dev.center.dao.repository;

import com.dev.center.dao.Car;
import com.dev.center.model.CarDownload;
import com.dev.center.model.ResponseOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "car", path = "car")
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findById(Integer id);
    @Query(value="SELECT c.id as carId, b.id as brandId, p.id as priceId, p.price as price, p.start_date as startDate, p.end_date as endDate " +
            "FROM car AS c JOIN car_price AS cp JOIN price AS p JOIN brand b " +
            "WHERE cp.car_id=c.id AND cp.price_id=p.id AND c.brand_id=b.id AND c.id=?1 AND (p.start_date<=?2 AND p.end_date>=?2)", nativeQuery = true)
    public List<ResponseOne> queryCarByIdAndDate(Integer identifier, Date fecha);

    @Query(value="SELECT c.id as carId, c.model as model, c.color as color, b.id as brandId " +
            "FROM car AS c JOIN brand b WHERE c.brand_id=b.id", nativeQuery = true)
    public List<CarDownload> retrievaAllCars();
}
