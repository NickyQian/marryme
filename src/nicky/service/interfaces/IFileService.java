package nicky.service.interfaces;

import java.util.List;

import nicky.bean.FileMeta;

public interface IFileService {
    /**
     * 保存图片信息
     * @param file
     */
    public void saveFileInfo(FileMeta file) throws Exception;
    /**
     * update file titles and fileDescs in batch
     * @param fileIds
     * @param fileTitles
     * @param fileDescs
     */
    public void batchSaveFile(Long[] fileIds, String[] fileTitles, String[] fileDescs);
    /**
     * find all files
     * @return
     */
    public List<FileMeta> findAllFiles();
}
