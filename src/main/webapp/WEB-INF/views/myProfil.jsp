<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Accueil</title>
	<spring:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" var="bootstrap" />
	<spring:url value="/resources/css/style1.css" var="style1"></spring:url>
	<link href="${bootstrap}" rel="stylesheet" />
	<link href="${style1}" rel="stylesheet" />
</head>
<body>
<div class="container">
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
           <A href="edit.html" >Edit Profile</A>

        <A href="/app/logout" >Logout</A>
       <br>
<p class=" text-info">May 05,2014,03:00 pm </p>
      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Mon profil</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png" class="img-circle img-responsive"> </div>
                
              
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
	                   	 <tr>
	                        <td>ID:</td>
	                        <td>${membre.membreID }</td>
	                      </tr>
	                      <tr>
	                        <td>Nom:</td>
	                        <td>${membre.nom }</td>
	                      </tr>
	                      <tr>
	                        <td>Prénom:</td>
	                        <td>${membre.prenom }</td>
	                      </tr>
	                      <tr>
	                        <td>Email</td>
	                        <td>${membre.email }</td>
	                      </tr>
	                      <tr>
	                        <td>Tel</td>
	                        <td>${membre.tel }</td>
	                      </tr>
                    </tbody>
                  </table>
                  
                  <a href="href="editMembre?membreID=${membre.membreID}"" class="btn btn-primary">Editer</a>
                  <a href="deleteMembre?membreID=${membre.membreID}" class="btn btn-primary">Supprimer</a>
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>
            
          </div>
        </div>
      </div>
    </div>
                
</body>
</html>
