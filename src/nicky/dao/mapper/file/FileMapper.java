package nicky.dao.mapper.file;

import nicky.bean.FileMeta;

public interface FileMapper {
    /* 保存文件 */
    public void saveFile(FileMeta file) throws Exception;
    
}
