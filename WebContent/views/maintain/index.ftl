<#import "/layout/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="上传照片"
                csses=['photo/photo_list.css','upload/uploadify.css']
                scripts=['js/upload/myuploadfunction.js',
                         'jquery/uploadify/jquery.uploadify.min.js']>
<h1>Spring MVC - jQuery Uploadify</h1>
    <form>
        <div id="queue"></div>
        <input id="file_upload" name="file_upload" type="file" multiple="true" />
    </form>
    <span id="result" style="font-size: 13px; color: red">
    <img />
    </span>
    <div>
        <a id = "start" href = "javascript:startUpload();">开始上传</a>
        <a id = "cancel" href = "javascript:stopUpload()">取消上传</a>
    </div>
    <table id="uploaded-files">
        <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
        </tr>
    </table>
    <a href = "${basePath}/maintain/logout"> logout </a>
</@layout.page>
</#escape>