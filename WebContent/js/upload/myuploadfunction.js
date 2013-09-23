$(function() {
			$('#file_upload').uploadify({
				'buttonImage' : basePath + 'img/photo/test.jpg',
//				'formData' : {
//					'timestamp' : '<?php echo $timestamp;?>',
//					'token'     : '<?php echo md5('unique_salt' . $timestamp);?>'
//				},
				'swf'      : basePath + 'jquery/uploadify/uploadify.swf',
				'uploader' : basePath + 'maintain/upload',
				'method'   : 'post', 
				'auto' : false,		// 是否自动上传 
				'multi' : true,     // 是否允许传多个文件
				'onUploadSuccess' : function(file, data, response) {
					alert(data);
					alert(file);
					s = eval("("+ data +")");
					 var path=basePath+"photos/"+s[0].fileName;
		                $('#result>img').attr("src",path);
		                $('#photoname_hidden').val(data);
				},
				'onComplete' : function(event,ID,fileObj,response,data){
					alert("ok2");
				}
				
			});
		});
function startUpload() {
	$('#file_upload').uploadify('upload','*');
}
function stopUpload() {
	$('#file_upload').uploadify('cancel', '*');
}