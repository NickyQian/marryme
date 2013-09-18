<#import "/layout/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="上传照片" 
                csses=['photo/photo_list.css',
                'upload/dropzone.css']
                scripts=['jquery/jquery.iframe-transport.js',
                'jquery/jquery.fileupload.js',
                'js/upload/myuploadfunction.js']>
<h1>Spring MVC - jQuery File Upload</h1>
    <div style="width:500px;padding:20px">
        <input id="fileupload" type="file" name="files[]" data-url="${basePath}/maintain/upload" multiple>
        <div id="dropzone">Drop files here</div>
        <div id="progress">
        <div style="width: 0%;"></div>
    </div>
 
    <table id="uploaded-files">
        <tr>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th>Download</th>
        </tr>
    </table>
</@layout.page>
</#escape>