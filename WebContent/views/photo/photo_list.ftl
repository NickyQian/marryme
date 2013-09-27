<#import "/layout/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="欢迎来到小屋" 
                csses=['/photo/photo_list.css']
                scripts=[]>

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Marry me!?</h1>
        <p class="lead">Every day is a happy day with U.</p>
        <a class="btn btn-large btn-success" href="#">Yes!</a>
      </div>
      <hr>
        <div id="myCarousel" class="carousel slide">
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
          </ol>
          <!-- Carousel items -->
          <div class="carousel-inner">
              <#if pictures??> 
                    
                        <#list pictures as pic>
                            <#if pic_index == 0>
                                <div class="active item">
                                    <img src = "./photos/${pic.fileName}"/>
                                    <div class="carousel-caption">
                                      <h4>${pic.fileTitle!""}</h4>
                                      <p>${pic.fileDescription!""}</p>
                                    </div>
                                </div>
                            <#else>
                                <div class="item">
                                    <img src = "./photos/${pic.fileName}"/>
                                    <div class="carousel-caption">
                                      <h4>${pic.fileTitle!""}</h4>
                                      <p>${pic.fileDescription!""}</p>
                                    </div>
                                </div>
                            </#if>
                        </#list>
                    
              <#else>
                    <div>暂时没有照片！~。~</div>
              </#if>
          </div>
          <!-- Carousel nav -->
          <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
          <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
        </div>
      
      
      <div>Hello World! ${name!""}</div>

      <!-- Example row of columns -->
      <div class="row-fluid">
        <div class="span4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
        <div class="span4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
       </div>
        <div class="span4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>
          <p><a class="btn" href="#">View details &raquo;</a></p>
        </div>
      </div>

      <hr>
</@layout.page>
</#escape>