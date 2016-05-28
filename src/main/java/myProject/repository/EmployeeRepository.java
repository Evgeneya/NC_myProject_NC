package myProject.repository;

import myProject.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 1 on 27.04.2016.
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findById(long id);

    List<EmployeeEntity> findByName(String name);

    List<EmployeeEntity> findByPositionId(long position_id);

    List<EmployeeEntity> findByNameAndPositionId(String name, long position_id);

    List<EmployeeEntity> findByExperienceBetween(int exp1, int exp2);

    List<EmployeeEntity> findBySalaryBetween(int sal1, int sal2);

    List<EmployeeEntity> findByExperienceBetweenAndSalaryBetween(int exp1, int exp2, int sal1, int sal2);

    List<EmployeeEntity> findByNameAndExperienceBetweenAndSalaryBetween(String name, int exp1, int exp2, int sal1, int sal2);

    List<EmployeeEntity> findByPositionIdAndExperienceBetweenAndSalaryBetween(long position_id, int exp1, int exp2, int sal1, int sal2);

    List<EmployeeEntity> findByNameAndPositionIdAndExperienceBetweenAndSalaryBetween(String name, long position_id, int exp1, int exp2, int sal1, int sal2);

    List<EmployeeEntity> findByPositionIdAndEmploymentsProjectIdOrderByEmploymentsCountHourAsc(long position_id, long project_id);

    List<EmployeeEntity> findByPositionIdAndEmploymentsProjectIdOrPositionIdOrderByEmploymentsCountHourAsc(long position_id, long project_id, long position_id2);

    List<EmployeeEntity> findByPositionIdOrderByEmploymentsCountHourAsc(long position_id);

    @Query(value = "select t.id, t.name, t.position_id, t.email, t.phone, t.age, t.experience, t.status, t.salary from " +
                   "select e, sum(em.count_hour) as sum_hour" +
                    "      from employee e left join employment em" +
                    "      on e.id = em.employee_id" +
                    "      where e.position_id = 2" +
                    "      GROUP by e.id, e.name, e.position_id, e.email, e.phone, e.age, e.experience, e.status, e.salary" +
                    "      Order by sum_hour t", nativeQuery = true)
    List<EmployeeEntity> findSortEmployee();
}
