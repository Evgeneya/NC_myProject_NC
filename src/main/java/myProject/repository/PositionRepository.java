package myProject.repository;


import myProject.entities.PositionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by 1 on 02.05.2016.
 */
public interface PositionRepository extends CrudRepository<PositionEntity, Long> {
    List<PositionEntity> findAll();
    List<PositionEntity> findById(long id);
    List<PositionEntity> findByName(String name);
    List<PositionEntity> findByMinSalaryBetween(int zero, int minSal);
    List<PositionEntity> findByMaxSalaryBetween(int maxSal, int largeSal);
}
