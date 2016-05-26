package myProject.servicesImpl;

import myProject.entities.PositionEntity;
import myProject.repository.PositionRepository;
import myProject.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 02.05.2016.
 */
@Service("jpaPositionService")
@Repository
@Transactional
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<PositionEntity> findAll() {
        return positionRepository.findAll();
    }

    public List<PositionEntity> findById(long id){
        return positionRepository.findById(id);
    }

    public PositionEntity save(PositionEntity position){
        return positionRepository.save(position);
    }
    public void delete(Long id){
        positionRepository.delete(id);
        return;
    }
    public List<PositionEntity> findByName(String name) {
        return positionRepository.findByName(name);
    }

    public List<PositionEntity> findLessMinSalary(int minSal){
        return positionRepository.findByMinSalaryBetween(0, minSal);  //буду искать должности с зп меньше указанной
    }
    public List<PositionEntity> findMoreMaxSalary(int maxSal){
        return positionRepository.findByMaxSalaryBetween(maxSal, 500000); //буду искать должности с зп больше указанной

    }

}

