package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.Est_SituacionEntity;

@Repository
public interface IEst_SituacionRepository extends CrudRepository<Est_SituacionEntity, Integer> {
}

