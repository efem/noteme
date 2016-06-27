<#import "../spring.ftl" as spring>
<#-- MACRO for initializing html page structure -->
<#macro pageStart title>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${title!""}</title>
		<link rel="stylesheet" type="text/css" href="<@spring.url '/resources/css/style.css'/>"/>
		<#nested>
	</head>
</#macro>

<#-- MACRO for initializing html page structure -->
<#macro pageBody>
	<body>
		<#nested>
	</body>
</html>
</#macro>

<#-- MACRO for listing borrowers -->
<#macro borrowersMacro borrowers valuesB>
<select name="borrower_id">
	<#list valuesB as singleBorrower>
		<option value="${singleBorrower.id!""}">${singleBorrower!""}</option>
	</#list>
</select>
</#macro>

<#-- MACRO for listing genres-->
<#macro genresMacro genre values>
	<select name="genre_id">
	<#list values as singleGenre>
		<option value="${singleGenre.id!""}" <#if singleGenre == command.bookDto.genre>selected</#if>>${singleGenre!""}</option>
	</#list>
	</select>
</#macro>

<#-- MACRO for listing authors-->
<#macro authorsMacro authors valuesA>
	<select name="author_id">
	<#list valuesA as singleAuthor>
		<option value="${singleAuthor.id!""}" <#if singleAuthor == command.bookDto.author>selected</#if>>${singleAuthor!""}</option>
	</#list>
	</select>
</#macro>

<#-- MACRO for listing authors in newBook page-->
<#macro authorsMacroNewBook authors valuesA>
	<#list valuesA as singleAuthor>
		<option value="${singleAuthor.id!""}">${singleAuthor!""}</option>
	</#list>
</#macro>

<#-- MACRO for listing all books in listBook page-->
<#macro showBooks command values>
	<#list values as singlebook>
		<tr>
			<td><input type="radio" value="${singlebook.id!""}" name="id"></td>
			<td>${singlebook.id!""}</td>
			<td>${singlebook.isbn!""}</td>
			<td>${singlebook.title!""}</td>
			<td>${singlebook.genre!""}</td>
			<td>${singlebook.author!""}</td>
			<td>${singlebook.noOfPages!""}</td>
			<td>${singlebook.publishingDate!""}</td>
			<td>${singlebook.borrower!""}</td>
		</tr>
	</#list>
</#macro>

<#-- MACRO for genres in newBook page -->
<#macro genresMacroNewBook genres values>
	<#list values as singleGenre>
		<option value="${singleGenre.id!""}">${singleGenre!""}</option>
	</#list>
</#macro>

<#-- MACRO check whether book is borroowed and act accordingly -->
<#macro checkIfBookBorrowed>
<#if book.bookDto.borrower??>
	${book.bookDto.borrower}
	<input type="hidden" name="borrower_id" value="0" readonly/>
	<input type="submit" value="<@spring.message code="label.giveback" />" />
<#else>	
	<@borrowersMacro "borrowers" book.borrowers/>
	<input type="submit" value="<@spring.message code="label.borrow" />" />
</#if>
</#macro>

<#-- MACRO - show errors in new table row -->
<#macro showErrorsInNewRow>
<tr>
	<td></td>
	<td><@spring.showErrors "<br />", "error" /></td>
</tr>
</#macro>

<#-- MACRO show button Save and Back - editBook -->
<#macro showButtonsBackSave>
<div class="buttonHolder">
	<input type="submit" value="<@spring.message code="label.save" />" />
	<@showBackButton />
</div>
</#macro>

<#-- MACRO for showing ONLY back button -->
<#macro showBackButton>
<#--<@generateInputButton type="button" value="label.back" name="Back" other="onClick=\"history.go(-1);\"" /> -->
<input type="button" value="<@spring.message code="label.back" />" onClick="history.go(-1);">
</#macro>

<#-- MACRO for generating input button -->
<#macro generateInputButton type name value id='someId' readonly='false' other='someOther'>
<#assign textValue = spring.message code=value>

<input type=${type} name=${name} value=${textValue} other=${other} />
</#macro>