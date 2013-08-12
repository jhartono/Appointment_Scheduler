<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="templates/top.jsp">
    <jsp:param name="section" value="WHO" />
</jsp:include>

<form:form modelAttribute="appointment" method="POST" class="form-horizontal">
	<form:errors path="*" cssClass="alert alert-error" element="div" delimiter='</div><div class="alert alert-error">'/>
	
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						Your personal data
					</div>
				</div>
				<div class="row-fluid">
					<div class="span8">
					
						<div class="control-group">
						  <label class="control-label" for="memberStatus">Are you a member</label>
						  <div class="controls">
						    <label class="radio inline">
						      <input id="radioYes" name="memberStatus" <c:if test="${appointment.memberStatus == 'Y'}">checked="checked"</c:if> value="Y" type="radio">
						      Yes
						    </label>
						    <label class="radio inline">
						      <input id="radioNo" name="memberStatus" <c:if test="${appointment.memberStatus == 'N'}">checked="checked"</c:if> value="N" type="radio">
						      No
						    </label>
						  </div>
						</div>
						
						
						<div id="memberContainer">
							<div class="control-group">
							  <label class="control-label" for="appointment.client.externalId">Member Number</label>
							  <div class="controls">
							  	<c:choose>
								    <c:when test="${appointment.memberStatus == 'Y'}">
								        <form:input class="input-xlarge" path="appointment.client.externalId" />
								    </c:when>
								    <c:otherwise>
								    	<input id="appointment.client.externalId" class="input-xlarge" type="text" value="" name="appointment.client.externalId">
								    </c:otherwise>
								</c:choose>
							  </div>
							</div>
						</div>
						
						<div id="nonMemberContainer">
							<div class="control-group">
							  <label class="control-label" for="appointment.client.firstName">First Name</label>
							  <div class="controls">
							  	<c:choose>
								    <c:when test="${appointment.memberStatus == 'N'}">
								        <form:input class="input-xlarge" path="appointment.client.firstName" />
								    </c:when>
								    <c:otherwise>
								    	<input id="appointment.client.firstName" class="input-xlarge" type="text" value="" name="appointment.client.firstName">
								    </c:otherwise>
								</c:choose>
							  </div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="appointment.client.middleName">Middle Name</label>
							  <div class="controls">
							  	<c:choose>
								    <c:when test="${appointment.memberStatus == 'N'}">
								        <form:input class="input-xlarge" path="appointment.client.middleName" />
								    </c:when>
								    <c:otherwise>
								    	<input id="appointment.client.middleName" class="input-xlarge" type="text" value="" name="appointment.client.middleName">
								    </c:otherwise>
								</c:choose>
							  </div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="appointment.client.lastName">Last Name</label>
							  <div class="controls">
							  	<c:choose>
								    <c:when test="${appointment.memberStatus == 'N'}">
								        <form:input class="input-xlarge" path="appointment.client.lastName" />
								    </c:when>
								    <c:otherwise>
								    	<input id="appointment.client.lastName" class="input-xlarge" type="text" value="" name="appointment.client.lastName">
								    </c:otherwise>
								</c:choose>
							  </div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="appointment.client.phone">Phone</label>
							  <div class="controls">
							  	<c:choose>
								    <c:when test="${appointment.memberStatus == 'N'}">
								        <form:input class="input-xlarge" path="appointment.client.phone" />
								    </c:when>
								    <c:otherwise>
								    	<input id="appointment.client.phone" class="input-xlarge" type="text" value="" name="appointment.client.phone">
								    </c:otherwise>
								</c:choose>
							  </div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="appointment.client.mobile">Mobile</label>
							  <div class="controls">
							  	<c:choose>
								    <c:when test="${appointment.memberStatus == 'N'}">
								        <form:input class="input-xlarge" path="appointment.client.mobile" />
								    </c:when>
								    <c:otherwise>
								    	<input id="appointment.client.mobile" class="input-xlarge" type="text" value="" name="appointment.client.mobile">
								    </c:otherwise>
								</c:choose>
							  </div>
							</div>
							<div class="control-group">
							  <label class="control-label" for="appointment.client.email">Email</label>
							  <div class="controls">
							  	<c:choose>
								    <c:when test="${appointment.memberStatus == 'N'}">
								        <form:input class="input-xlarge" path="appointment.client.email" />
								    </c:when>
								    <c:otherwise>
								    	<input id="appointment.client.email" class="input-xlarge" type="text" value="" name="appointment.client.email">
								    </c:otherwise>
								</c:choose>
							  </div>
							</div>
						</div>
					</div>
					<div class="span4">
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container">
				<div class="pull-right">
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
					<input type="submit" class="btn btn-success" name="_eventId_back" value="Back"/>
					<input type="submit" class="btn btn-primary" name="_eventId_next" value="Next"/>
				</div>
			</div>
		</div>
	</div>							
</form:form>

<script>
	$(document).ready(function() {
		<c:choose>
		    <c:when test="${appointment.memberStatus == 'Y'}">
		        $('#memberContainer').show();
		        $('#nonMemberContainer').hide();
		    </c:when>
		    <c:when test="${appointment.memberStatus == 'N'}">
		        $('#memberContainer').hide();
		        $('#nonMemberContainer').show();
		    </c:when>
		    <c:otherwise>
		    	$('#memberContainer').hide();
		        $('#nonMemberContainer').hide();
		    </c:otherwise>
		</c:choose>
		
		$("#radioYes").change(function () {
        	$('#memberContainer').show();
			$('#nonMemberContainer').hide();
         });
         
         $("#radioNo").change(function () {
        	$('#memberContainer').hide();
			$('#nonMemberContainer').show();
         });
	});	
</script>

<jsp:include page="templates/bottom.jsp"/>