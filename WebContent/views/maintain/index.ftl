<#import "/layout/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="上传照片"
                csses=['photo/photo_list.css','upload/uploadify.css']
                scripts=['js/upload/myuploadfunction.js',
                         'jquery/uploadify/jquery.uploadify.min.js']>
<h1>Spring MVC</h1>
<div style = "position:relative;height: auto">
    <div style = "position:absolute; left:0px;">
        <input id="file_upload" name="file_upload" type="file" multiple="true" />
        <form action="${basePath}/maintain/batch_save" method = "post">
            <div id = "holder">
            </div>
            <input id = "submit_all_btn" type = "submit" class="btn btn-warning" style = "float:right; display:none" value = "保存全部"/>
        </form>
        <!-- Template, display = none  -->
        <div class="container-fluid" id = "editInput" style = "display:none">
            <hr>
            <div class="row-fluid">
                <div id = "result" class="span5">
                </div>
                <div class="span7" >
                    <input type="hidden" id="file_id" name="fileId">
                    <div>图片名称：<input id="file_title" name="fileTitle" type="text" placeholder="请输入照片名称" style="width:200px"></div>
                    <div>图片描述：</div>
                    <div><textarea name="fileDesc" rows="4" style="width:500px"></textarea></div>
                </div>
           </div>
        </div>
        <!-- Template end -->
    </div>
    <div style = "position:absolute; left:200px;">
        <i class="glyphicon glyphicon-plus"></i>
        <a id = "start" href = "javascript:startUpload();" class="btn btn-success">开始上传</a>
        <a id = "cancel" href = "javascript:stopUpload()" class="btn btn-success cancel">取消上传</a>
        <a href = "javascript:void(0);" class="btn btn-warning">保存</a>
        <a href = "${basePath}/maintain/logout" class = "btn btn-primary" style = "margin-left:200px"> logout </a>
    </div>
</div>
</@layout.page>
</#escape>