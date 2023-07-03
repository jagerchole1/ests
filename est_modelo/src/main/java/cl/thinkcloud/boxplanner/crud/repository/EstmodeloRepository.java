package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.Est_modeloEntity;

@Repository
public interface EstmodeloRepository extends CrudRepository<Est_modeloEntity, Integer> {
}
