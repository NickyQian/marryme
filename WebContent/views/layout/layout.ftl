<#global basePath="${request.getContextPath()}">
<#macro page title csses scripts>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title?html}</title>
    <meta name="description" content="Pm System" />
    <meta name="keywords" content="issue,bug,tracker" />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache,must-revalidate">
    <meta http-equiv="expires" content="0">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${basePath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9] -->
      <script src="//cdnjs.bootcss.com/ajax/libs/html5shiv/3.6.2/html5shiv.js"></script>
    <!--[endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="${basePath}/img/ico/favicon.png">
    <link href="//cdnjs.bootcss.com/ajax/libs/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="${basePath}/css/layout/layout.css" rel="stylesheet">
    <#list csses as css>
        <link href="${basePath}/css/${css}" type="text/css" rel="stylesheet" />
    </#list>
    <style type="text/css">
      
    </style>
    <script type="text/javascript">
        var basePath="${basePath}/";
    </script>
    <style type="text/css">
        .uploadify-button {
            background-color: transparent;
            border: none;
            padding: 0;
        }
        .uploadify:hover .uploadify-button {
            background-color: transparent;
        }
    </style>
</head>
<body>

<div class="container">
      <div class="masthead">
        <h3 class="muted">Project name</h3>
        <div class="navbar">
          <div class="navbar-inner">
            <div class="container">
              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Downloads</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
              </ul>
            </div>
          </div>
        </div><!-- /.navbar -->
      </div>
     <#nested>
     <div class="footer" style = "text-align: center;">
         <p><a href="${basePath}/maintain/index">&copy; Nicky 2013</a></p>
     </div>
</div><!-- /.container -->

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${basePath}/jquery/jquery-1.9.1.min.js"></script>
    <script src="${basePath}/jquery/jquery-ui-1.8.14.custom.min.js"></script>
    <script src="//cdnjs.bootcss.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <#list scripts as scr>
        <script src="${basePath}/${scr}" type="text/javascript"></script>
    </#list>
</body>
</html>
</#macro>