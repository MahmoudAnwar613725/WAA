package edu.miu.restful.service.impl;

 import edu.miu.restful.entity.Exception;
 import edu.miu.restful.repo.ExceptionAspectRepo;
 import edu.miu.restful.service.ExceptionService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Autowired
    private ExceptionAspectRepo exceptionAspectRepo;
    @Override
    public void save(Exception exception) {
        exceptionAspectRepo.save(exception);
    }
}
