<#import "/layout/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="上传照片" 
                csses=['photo/photo_list.css','upload/uploadify.css']
                scripts=['js/upload/myuploadfunction.js',
                         'jquery/uploadify/jquery.uploadify.min.js']>
<h1>Spring MVC - jQuery File Upload</h1>
    <form>
        <div id="queue"></div>
        <input id="file_upload" name="file_upload" type="file" multiple="true">
    </form>
 
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