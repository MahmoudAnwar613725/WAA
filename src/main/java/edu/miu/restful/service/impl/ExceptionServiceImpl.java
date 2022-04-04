package edu.miu.restful.service.impl;

import miu.edu.demo.repo.ExceptionAspectRepo;
import miu.edu.demo.service.ExceptionService;
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
