package nicky.service.impls;

import nicky.dao.mapper.DaoTest;
import nicky.service.interfaces.ITestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private DaoTest daoTest;
    @Override
    public String find() {
        // TODO Auto-generated method stub
        return daoTest.find().getPic_url();
    }
    
}
