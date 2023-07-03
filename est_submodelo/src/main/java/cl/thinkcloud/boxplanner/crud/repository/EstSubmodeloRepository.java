package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.EstSub_modeloEntity;

@Repository
public interface EstSubmodeloRepository extends CrudRepository<EstSub_modeloEntity, Integer> {
}
