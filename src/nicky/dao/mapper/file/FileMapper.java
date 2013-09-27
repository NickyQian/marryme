package nicky.dao.mapper.file;

import java.util.List;

import nicky.bean.FileMeta;

public interface FileMapper {
    /**
     * save file
     * @param file
     * @throws Exception
     */
    public void saveFile(FileMeta file) throws Exception;
    /**
     * update file title, file description by file id.
     * @param files
     */
    public void updateFile(FileMeta file);
    /**
     * find all files
     * @return
     */
    public List<FileMeta> findAllFiles();
    
}
