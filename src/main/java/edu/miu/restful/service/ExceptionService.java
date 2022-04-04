package edu.miu.restful.service;


import edu.miu.restful.entity.Exception;
import org.springframework.stereotype.Service;

@Service
public interface ExceptionService {
    void save(Exception exception);

}
