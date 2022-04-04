package edu.miu.restful.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExceptionAspectRepo extends CrudRepository<Exception, Long> {
}
