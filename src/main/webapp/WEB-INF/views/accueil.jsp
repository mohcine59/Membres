<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Inscription</title>
	<spring:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" var="bootstrap" />
	<spring:url value="/resources/css/style1.css" var="style1"></spring:url>
	<link href="${bootstrap}" rel="stylesheet" />
	<link href="${style1}" rel="stylesheet" />
</head>
<body>

	<form action="<c:url value='/j_spring_security_check' />" method="POST">
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="connexion"></td>
			</tr>
		</table>
	</form>
<div class="container">
    <h1>Inscription</h1>
  	<hr>
	
      
      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        
        <h3>Mon profil</h3>
        <f:form modelAttribute="inscriptionDto" action="saveMembre" method="post" class="form-horizontal">
          <div class="form-group">
            <label class="col-lg-3 control-label">Nom:</label>
            <div class="col-lg-8">
            	<f:input path="nom" class="form-control"/>
            	<f:errors path="nom" cssClass="errors" ></f:errors>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Prénom:</label>
            <div class="col-lg-8">
            	<f:input path="prenom" class="form-control"/>
            	<f:errors path="prenom" cssClass="errors"></f:errors>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
            	<f:input path="email" class="form-control"/>
            	<f:errors path="email" cssClass="errors"></f:errors>
            </div>
          </div>
          <div class="form-group">
            <label class="col-lg-3 control-label">Téléphone:</label>
            <div class="col-lg-8">
            	<f:input path="tel" class="form-control"/>
            	<f:errors path="tel" cssClass="errors"></f:errors>
            </div>
          </div>
         
          <div class="form-group">
            <label class="col-md-3 control-label">Mot de passe:</label>
            <div class="col-md-8">
            	<f:input type="password" path="password" class="form-control"/>
            	<f:errors path="password" cssClass="errors"></f:errors>
            </div>
          </div>
          <div class="form-group">
            <label class="col-md-3 control-label"></label>
            <div class="col-md-8">
              <button class="btn btn-primary" >Valider</button>
            </div>
          </div>
        </f:form>
      </div>
  </div>
</div>


</body>
</html>