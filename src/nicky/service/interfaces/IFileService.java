package nicky.service.interfaces;

import nicky.bean.FileMeta;

public interface IFileService {
    /**
     * 保存图片信息
     * @param file
     */
    public void saveFileInfo(FileMeta file) throws Exception;
}
