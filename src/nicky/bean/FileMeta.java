package nicky.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//ignore "bytes" when return json format
@JsonIgnoreProperties({"bytes"})
public class FileMeta {
    private Long fileId;
    private String fileName;
    private String fileTitle;
    private String fileDescription;
    /* file size unit: kb */
    private Long fileSize;
    /* created time*/
    private String createTime;
    /* update time */
    private String updateTime;

    private byte[] bytes;
    public FileMeta(){}
    public FileMeta(Long fileId, String fileTitle, String fileDescription){
        this.fileId = fileId;
        this.fileTitle = fileTitle;
        this.fileDescription = fileDescription;
    }
    /**
     * form list, fileIds can not be null or empty.
     * @param fileIds
     * @param fileTitles
     * @param fileDescriptions
     * @return
     */
    public static List<FileMeta> formFileList(Long[] fileIds, String[] fileTitles, String[] fileDescriptions){
        List<FileMeta> files = new ArrayList<FileMeta>();
        for(int i = 0;i < fileIds.length; i++) {
            String fileTitle = "";
            String fileDescription = "";
            if(fileTitles.length != 0) {
                fileTitle = fileTitles[i];
            }
            if(fileDescriptions.length != 0) {
                fileDescription = fileDescriptions[i];
            }
            FileMeta file = new FileMeta(fileIds[i],fileTitle,fileDescription);
            files.add(file);
        }
        return files;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}