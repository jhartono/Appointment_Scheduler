<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="templates/top.jsp">
    <jsp:param name="section" value="WHAT" />
</jsp:include>

<form:form modelAttribute="appointment" method="POST" class="form-horizontal">
	<form:errors path="*" cssClass="alert alert-error" element="div" delimiter='</div><div class="alert alert-error">'/>
	
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						Specify the purpose of your appointment in order to be welcomed by the most appropriate collaborator
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
					</div>
				</div>
				<div class="row-fluid">
					<div class="span8">
					
						<div class="control-group">
					    	<label for="country" class="control-label">Your Subject</label>
					    	<div class="controls">
					    		<select name="appointment.topic" id="appointment.topic" class="input-xlarge">
					    			<c:if test="${empty appointment.appointment.topic}">
					    				<option selected="selected" value="">-- Please select a topic --</option>
					    			</c:if>
					    			<c:forEach items="${topics}" var="topic"> 
					        			<option <c:if test="${not empty appointment.appointment.topic && 
					        				appointment.appointment.topic.id == topic.id}">selected="selected"</c:if> value="${topic.id}">${topic.text}</option>
					    			</c:forEach>
					    		</select>
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
					<input type="submit" class="btn btn-primary" name="_eventId_next" value="Continue"/>
				</div>
			</div>
		</div>
	</div>	
	
	<!-- Reset Next -->
	<input id="searchLocationForm.zipCode" name="searchLocationForm.zipCode" type="hidden" value=""/>
	<input id="searchLocationForm.locality" name="searchLocationForm.locality" type="hidden" value=""/>
	<input id="searchLocationForm.counter" name="searchLocationForm.counter" type="hidden" value="0"/>
	
	<input id="appointment.location" name="appointment.location" type="hidden" value=""/>								
</form:form>

<jsp:include page="templates/bottom.jsp"/>