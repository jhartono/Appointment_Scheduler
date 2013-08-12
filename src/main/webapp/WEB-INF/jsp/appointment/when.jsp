<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fmt:formatDate value="${appointment.appointment.startTime}" pattern="HH:mm" var="appointmentStartTime" />

<jsp:include page="templates/top.jsp">
    <jsp:param name="section" value="WHEN" />
</jsp:include>

<form:form modelAttribute="appointment" method="POST">
	<form:errors path="*" cssClass="alert alert-error" element="div" delimiter='</div><div class="alert alert-error">'/>
	
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						Select a date from the calendar and a time slot
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
					</div>
				</div>
				<div class="row-fluid">
					<div class="span5">
					
						<label for="dpd1">Appointment Date</label>
						<input type="text" id="dpd1" name="appointment.appointmentDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${appointment.appointment.appointmentDate}" />" class="span6">
					
					</div>
					<div class="span5">
						<div class="row-fluid">
							<div class="span12">
								<label>Available Morning Time Slot(s)</label>
								<div class="control-group">
								  <div class="controls">
								    <c:forEach items="${timeslots[0]}" var="timeslot" varStatus="status">
								    
								    	<fmt:formatDate value="${timeslot.startTime}" pattern="HH:mm" var="timeslotStartTime" />
								    
								    	<label class="radio">
									      <input id="morning${status.count}" name="timeslots" <c:if test="${appointmentStartTime == timeslotStartTime}">checked="checked"</c:if> value="${timeslot.startMinute}" type="radio">
									      <fmt:formatDate pattern="hh:mm a" value="${timeslot.startTime}" />&nbsp; to &nbsp;
									      <fmt:formatDate pattern="hh:mm a" value="${timeslot.endTime}" />
									    </label>
								    
								    </c:forEach>
								  </div>
								</div>
							</div>
						</div>
						<div class="row-fluid">	
							<div class="span12">
							</div>
						</div>
						<div class="row-fluid">
							<div class="span12">
								<label>Available Afternoon Time Slot(s)</label>
								<div class="control-group">
								  <div class="controls">
								    <c:forEach items="${timeslots[1]}" var="timeslot" varStatus="status"> 
								    
								    	<fmt:formatDate value="${timeslot.startTime}" pattern="HH:mm" var="timeslotStartTime" />
								    
								    	<label class="radio">
									      <input id="afternoon${status.count}" name="timeslots" <c:if test="${appointmentStartTime == timeslotStartTime}">checked="checked"</c:if> value="${timeslot.startMinute}" type="radio">
									      <fmt:formatDate pattern="hh:mm a" value="${timeslot.startTime}" />&nbsp; to &nbsp;
									      <fmt:formatDate pattern="hh:mm a" value="${timeslot.endTime}" />
									    </label>
								    
								    </c:forEach>
								  </div>
								</div>
							</div>
						</div>
					</div>
					<div class="span2">
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
	
	
	<input id="startTime" name="appointment.startTime" type="hidden" value="<fmt:formatDate pattern="HH:mm" value="${appointment.appointment.startTime}" />"/>
	<input id="endTime" name="appointment.endTime" type="hidden" value="<fmt:formatDate pattern="HH:mm" value="${appointment.appointment.endTime}" />"/>
	
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
	
	<!-- Reset Next -->
	<input id="appointment.employee" name="appointment.employee" type="hidden" value=""/>
	<input id="memberStatus" name="memberStatus" type="hidden" value=""/>							
</form:form>

<script>
	$(document).ready(function() {
		var nowTemp = new Date();
		var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);
		
		var dp1 = $('#dpd1').datepicker({
			onRender: function(date) {
				return date.valueOf() < now.valueOf() ? 'disabled' : '';
			},
			format: 'dd/mm/yyyy'
		}).on('hide', function(ev){
			dp1.show();
		}).data('datepicker');
		
		dp1.show();
		
		
		<c:forEach items="${timeslots[0]}" var="timeslot" varStatus="status"> 
			$("#morning${status.count}").change(function () {
				$("#startTime").val("<fmt:formatDate pattern="HH:mm" value="${timeslot.startTime}" />");
				$("#endTime").val("<fmt:formatDate pattern="HH:mm" value="${timeslot.endTime}" />");
	         });
         </c:forEach>
         
         <c:forEach items="${timeslots[1]}" var="timeslot" varStatus="status"> 
			$("#afternoon${status.count}").change(function () {
				$("#startTime").val("<fmt:formatDate pattern="HH:mm" value="${timeslot.startTime}" />");
				$("#endTime").val("<fmt:formatDate pattern="HH:mm" value="${timeslot.endTime}" />");
	         });
         </c:forEach>
	});	
</script>

<jsp:include page="templates/bottom.jsp"/>