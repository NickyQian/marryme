package nicky.service.impls;

import nicky.service.interfaces.ITestService;

import org.springframework.stereotype.Service;
@Service
public class TestServiceImpl implements ITestService {
//    @Autowired
//    private DaoTest daoTest;
    @Override
    public String find() {
        // TODO Auto-generated method stub
        return "";
//        return daoTest.find().getPic_url();
    }
    
}
