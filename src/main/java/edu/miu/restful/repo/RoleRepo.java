package edu.miu.restful.repo;

 import edu.miu.restful.entity.Role;
 import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Long> {
}
