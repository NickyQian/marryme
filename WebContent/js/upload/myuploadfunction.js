$(function() {
			$('#file_upload').uploadify({
				'buttonImage' : basePath + 'img/photo/test.jpg',
//				'formData' : {
//					'timestamp' : '<?php echo $timestamp;?>',
//					'token'     : '<?php echo md5('unique_salt' . $timestamp);?>'
//				},
				'swf'      : basePath + 'jquery/uploadify/uploadify.swf',
				'uploader' : basePath + 'maintain/upload'
			});
		});