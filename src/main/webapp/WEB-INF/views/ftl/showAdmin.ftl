<#import "init.ftl" as init />
<@init.pageInit title="ADMIN PAGE" adminJS=1/>
<@init.pageBody>
<@init.renderNaviBar />
  <div id="noteContainer" style="padding-top: 80px; width: 1000px;">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Show notes by author</h3>
      </div>
      <div class="panel-body">
        <form id="noteByUsernameForm">
         <div class="row">
	         <div class="col-lg-6">
	    		<div class="input-group">
	      			<input type="text" name="authId" id="authorName" class="form-control" placeholder="Znajdz po autorze...">
	      			<span class="input-group-btn">
	        			<button class="btn btn-default" type="submit">Szukaj!</button>
	      			</span>
	    		</div><!-- /input-group -->
  			</div><!-- /.col-lg-6 -->
		</div><!-- /.row -->
         
         
        </form>
      </div>
    </div>
    <div class="noteFormAdmin" style="width: 300px;">

    </div>
	    <form id="userDetailsByUsernameForm">
	      <label for="authorNameForDetails">Author: </label><input name="aName" id="authorNameForDetails" />
	      <input type="submit" value="Get Author's Details" /> <br /><br/>
	    </form>

	    <input type="submit" id="showAllNotesBtn" value="All Notes" /><br/><br/>
	    <input type="submit" id="showOneNoteBtn" value="One Note" /><br/><br/>
	    <div id="dataLoad"> </div>
  </div>
</@init.pageBody>
