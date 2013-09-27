$(function() {
			$('#file_upload').uploadify({
//				'buttonClass' : 'some-class',
				'removeTimeout' : 0,
				'buttonImage' : basePath + 'img/photo/test.jpg',
				'fileTypeExts' : '*.jpg',
				'progressData' : 'speed',
				'swf'      : basePath + 'jquery/uploadify/uploadify.swf',
				'uploader' : basePath + 'maintain/upload',
				'method'   : 'post', 
				'auto' : false,		// 是否自动上传 
				'multi' : true,     // 是否允许传多个文件
				'onUploadSuccess' : function(file, data, response) {
					dataArr = eval("("+ data +")");
					$.each(dataArr, function(i,file){
					      var path = basePath+"photos/tumbnailphotos/"+file.fileName;
					      var $editInput = $("#editInput").clone();
					      $editInput.attr("id", "file" + file.fileId);
					      var $img = $("<img class = 'img-polaroid'/>");
					      $editInput.show();
					      $img.attr("src",path);
					      $editInput.find("#result").append($img);
					      $editInput.find("#file_title").val(file.fileTitle);
					      $editInput.find("#file_id").val(file.fileId);
					      $('#holder').append($editInput);
					      $("#submit_all_btn").show();
					  });
				}
			});
		});
function startUpload() {
	$('#file_upload').uploadify('upload','*');
}
function stopUpload() {
	$('#file_upload').uploadify('cancel', '*');
}