package edu.miu.restful.service.impl;

 import edu.miu.restful.entity.Logger;
 import edu.miu.restful.repo.LoggerRepo;
 import edu.miu.restful.service.LogerService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoggerServiceImpl implements LogerService {

    @Autowired
    private LoggerRepo logerRepo;

    @Override
    public void save(Logger logger) {
        logerRepo.save(logger);
    }
}
