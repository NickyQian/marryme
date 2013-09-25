package nicky.service.impls;

import nicky.bean.FileMeta;
import nicky.dao.mapper.file.FileMapper;
import nicky.service.interfaces.IFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FileServiceImpl implements IFileService {
    @Autowired
    private FileMapper fileMapper;
    @Override
    public void saveFileInfo(FileMeta file) throws Exception {
        // TODO Auto-generated method stub
        fileMapper.saveFile(file);
    }

}
