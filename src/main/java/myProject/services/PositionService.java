package myProject.services;

import myProject.entities.PositionEntity;

import java.util.List;

/**
 * Created by 1 on 02.05.2016.
 */
public interface PositionService {
    List<PositionEntity> findAll();
    List<PositionEntity> findByName(String name);
}
