package edu.miu.restful.repo;

import edu.miu.restful.entity.Exception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExceptionAspectRepo extends CrudRepository<Exception, Long> {
}
