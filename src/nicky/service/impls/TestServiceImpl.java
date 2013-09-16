package nicky.service.impls;

import javax.inject.Inject;

import nicky.dao.mapper.DaoTest;
import nicky.service.interfaces.ITestService;

import org.springframework.stereotype.Service;
@Service
public class TestServiceImpl implements ITestService {
    @Inject
    private DaoTest daoTest;
    @Override
    public String find() {
        // TODO Auto-generated method stub
        
        return daoTest.find().getCLT();
    }
    
}
