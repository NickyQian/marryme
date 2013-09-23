<#import "/layout/layout.ftl" as layout>
<#escape x as x?html>
<@layout.page title="登陆" 
                csses=['/photo/photo_list.css']
                scripts=[]>
      <div style = "margin:200px">
      <form action = "${basePath}/maintain/login" class="form-horizontal" method = "post">
          <div class="control-group">
            <label class="control-label">user name</label>
            <div class="controls">
              <input type="text" id="inputEmail" name ="userName" placeholder="user name" value = "Nicky">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Password</label>
            <div class="controls">
              <input type="password" id="inputPassword" name = "password" placeholder="Password" value = "NIcky">
            </div>
          </div>
          <div class="control-group">
            <div class="controls">
              <label class="checkbox">
                <input name = "isRemember" type="checkbox" checked> Remember me
              </label>
              <button type="submit" class="btn">Sign in</button>
            </div>
          </div>
      </form>
      </div>
</@layout.page>
</#escape>