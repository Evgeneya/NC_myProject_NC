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
            return (ArrayList<PositionEntity>)positionRepository.findAll();
            //return Lists.newArrayList(positionRepository.findAll());
        }

        public List<PositionEntity> findByName(String name) {
            return positionRepository.findByName(name);
        }

    }

