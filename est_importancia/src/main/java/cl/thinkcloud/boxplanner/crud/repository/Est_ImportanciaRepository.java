package cl.thinkcloud.boxplanner.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.thinkcloud.boxplanner.crud.entity.Est_ImportanciaEntity;

@Repository
public interface Est_ImportanciaRepository extends CrudRepository<Est_ImportanciaEntity, Integer> {
}
