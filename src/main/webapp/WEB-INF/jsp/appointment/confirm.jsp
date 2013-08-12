<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="templates/top.jsp">
    <jsp:param name="section" value="CONFIRM" />
</jsp:include>

<form:form modelAttribute="appointment" method="POST" class="form-horizontal">							
	<form:errors path="*" cssClass="alert alert-error" element="div" delimiter='</div><div class="alert alert-error">'/>
	
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						Look at the details below and click 'Confirm' to fix your appointment
					</div>
				</div>
				<div class="row-fluid">
					<div class="span4">
						<h4>Appointment Detail</h4>
						<div class="row-fluid">
							<div class="span12">
								<div class="row-fluid">
									<div class="span4">
										<span style="font-weight:bold;">Date</span>
									</div>
									<div class="span8">
										<fmt:formatDate pattern="E, dd/MM/yyyy" value="${appointment.appointment.appointmentDate}" />
									</div>
								</div>
								<div class="row-fluid">
									<div class="span4">
										<span style="font-weight:bold;">Time</span>
									</div>
									<div class="span8">
										<fmt:formatDate pattern="hh:mm a" value="${appointment.appointment.startTime}" />
										 to 
										 <fmt:formatDate pattern="hh:mm a" value="${appointment.appointment.endTime}" />
									</div>
								</div>
								<div class="row-fluid">
									<div class="span4">
										<span style="font-weight:bold;">Contact</span>
									</div>
									<div class="span8">
										${appointment.appointment.employee.firstName}
										<c:if test="${not empty appointment.appointment.employee.middleName}">
											&nbsp;${appointment.appointment.employee.middleName}
										</c:if>
										<c:if test="${not empty appointment.appointment.employee.lastName}">
											&nbsp;${appointment.appointment.employee.lastName}
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="span4">
						<h4>Location Detail</h4>
						<div class="row-fluid">
							<div class="span12">
								<div class="row-fluid">
									<div class="span4">
										<span style="font-weight:bold;">Name</span>
									</div>
									<div class="span8">
										${appointment.appointment.location.name}
									</div>
								</div>
								<div class="row-fluid">
									<div class="span4">
										<span style="font-weight:bold;">Address</span>
									</div>
									<div class="span8">
										${appointment.appointment.location.address1}
										<c:if test="${not empty appointment.appointment.location.address2}">
											<br/>${appointment.appointment.location.address2}
										</c:if>
										<c:if test="${not empty appointment.appointment.location.address3}">
											<br/>${appointment.appointment.location.address3}
										</c:if>
										<br/>${appointment.appointment.location.city},&nbsp;${appointment.appointment.location.state}&nbsp;${appointment.appointment.location.zipCode}
									</div>
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
				<div class="row-fluid">
					<div class="span8">
						<h4>Appointment Topic</h4>
						<div class="row-fluid">
							<div class="span12">
								Please state below the topics you would like to discuss (max. 800 characters)
								<textarea class="span12" id="appointment.additionalDetail" name="appointment.additionalDetail" placeholder="Type in your message" rows="5"></textarea>
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
					<input type="submit" class="btn btn-primary" name="_eventId_next" value="Confirm"/>
				</div>
			</div>
		</div>
	</div>								
</form:form>

<jsp:include page="templates/bottom.jsp"/>