package nicky.service.impls;

import java.util.List;

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

    @Override
    public void batchSaveFile(Long[] fileIds, String[] fileTitles, String[] fileDescs) {
        if(fileIds != null && fileIds.length != 0) {
            List<FileMeta> files = FileMeta.formFileList(fileIds, fileTitles, fileDescs);
            for (FileMeta file : files) {
                    fileMapper.updateFile(file);
                }
        }
    }
    /**
     * find all files
     */
    @Override
    public List<FileMeta> findAllFiles() {
        // TODO Auto-generated method stub
        return fileMapper.findAllFiles();
    }
    

}
