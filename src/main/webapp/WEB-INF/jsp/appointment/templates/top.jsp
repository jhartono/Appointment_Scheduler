<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Appointment Scheduler</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
    <!-- Bootstrap -->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
    <link href="${bootstrapCSS}" rel="stylesheet" />
    
    <!-- Bootstrap -->
    <spring:url value="/resources/css/datepicker.css" var="bootstrapDatepickerCSS" />
    <link href="${bootstrapDatepickerCSS}" rel="stylesheet" />
    
    <style type="text/css">
	    body {
			padding-top: 40px;
			padding-bottom: 40px;
		}
	</style>
    
    <!-- Modernizr for browser feature-checking 
                        + HTML5shiv (included in modernizr) see modernizr.com -->
    <spring:url value="/resources/js/modernizr.min.js" var="modernizrJs" />
    <script src="${modernizrJs}"></script>
    
    <!-- jQuery -->
    <spring:url value="/resources/js/jquery.min.js" var="jqueryJS" />
    <script src="${jqueryJS}"></script>
    
  </head>
  <body>
  	<div class="container">
		<div class="span12">
			<section id="wizard">	
				<div id="rootwizard">
					<div class="navbar">
					  <div class="navbar-inner">
					    <div class="container">
							<ul class="nav nav-pills">
							  	<li <c:if test="${param.section == 'WHAT'}">class="active"</c:if>><a data-toggle="tab" href="#">What</a></li>
								<li <c:if test="${param.section == 'WHERE'}">class="active"</c:if>><a data-toggle="tab" href="#">Where</a></li>
								<li <c:if test="${param.section == 'WHEN'}">class="active"</c:if>><a data-toggle="tab" href="#">When</a></li>
								<li <c:if test="${param.section == 'WHO'}">class="active"</c:if>><a data-toggle="tab" href="#">Who</a></li>
								<li <c:if test="${param.section == 'CONFIRM'}">class="active"</c:if>><a data-toggle="tab" href="#">Confirmation</a></li>
							</ul>
					 	</div>
					  </div>
					</div>
					<div class="tab-content">
						<div class="tab-pane active">
						    <div class="row">
								<div class="span12">