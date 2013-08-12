<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Appointment Scheduler</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
    <link href="${bootstrapCSS}" rel="stylesheet" />
    
    <!-- Modernizr for browser feature-checking 
                        + HTML5shiv (included in modernizr) see modernizr.com -->
    <spring:url value="/resources/js/modernizr.min.js" var="modernizrJs" />
    <script src="${modernizrJs}"></script>
    
    <!-- jQuery -->
    <spring:url value="/resources/js/jquery.min.js" var="jqueryJS" />
    <script src="${jqueryJS}"></script>
  </head>
  <body>
