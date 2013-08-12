<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="templates/top.jsp">
    <jsp:param name="section" value="WHERE" />
</jsp:include>

<form:form modelAttribute="appointment" method="POST">							
	<form:errors path="*" cssClass="alert alert-error" element="div" delimiter='</div><div class="alert alert-error">'/>
	
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span12">
						Please enter a postal code and/or locality
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
					</div>
				</div>
				<div class="row-fluid">
					<div class="span10">
					
						<div class="control-group">
						    <div class="controls form-inline">
						        <label>Postal Code&nbsp;&nbsp;</label>
						        <form:input class="span3" path="searchLocationForm.zipCode" />
						        <label>&nbsp;&nbsp;And/Or Locality&nbsp;&nbsp;</label>
						        <form:input id="localitySearch" class="span3"  path="searchLocationForm.locality" />
						       	&nbsp;&nbsp;
								<input id="searchLocationForm.counter" name="searchLocationForm.counter" type="hidden" value="${appointment.searchLocationForm.counter + 1}"/>
								<input type="submit" class="btn btn-success" name="_eventId_search" value="Search"/>
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
					<div class="span10">
					
						<c:choose>
						    <c:when test="${appointment.searchLocationForm.counter == 0}">
						        <input type="hidden" value="" name="appointment.location" id="appointment.location">
						    </c:when>
						    <c:when test="${appointment.searchLocationForm.counter > 0 and empty appointment.searchLocationForm.zipCode and empty appointment.searchLocationForm.locality}">
						        <input type="hidden" value="" name="appointment.location" id="appointment.location">
						    </c:when>
						    <c:otherwise>
						    	<table class="table table-bordered table-condensed">
						    		<thead>
				        				<tr>
									  		<th>#</th>
									  		<th>
									  			Name
									  		</th>
									  		<th>
									  			Address
									  		</th>
									  		<th>
									  			City
									  		</th>
									  		<th>
									  			State
									  		</th>
									  		<th>
									  			Postal Code
									  		</th>
				        				</tr>
				   					</thead>
				   					
				   					<tbody>
								    	<c:choose>
										    <c:when test="${empty locations}">
										        <tr>
										    		<td colspan="6">
												    	<input type="hidden" value="" name="appointment.location" id="appointment.location">
												    	<span style="font-weight: bold;">No Location Found</span>
										    		</td>
										    	</tr>
										    </c:when>
										    <c:otherwise>
										    	<c:forEach items="${locations}" var="location"> 
				  									<tr>
										    			<td width="10px">
															<input type="radio" value="${location.id}" name="appointment.location" <c:if test="${not empty appointment.appointment.location && appointment.appointment.location.id == location.id}">checked="checked"</c:if> />
											    		</td>
											    		<td>
															 ${location.name}
											    		</td>
											    		<td>
														      ${location.address1}
														      <c:if test="${not empty location.address2}"><br/>${location.address2}</c:if>
														      <c:if test="${not empty location.address3}"><br/>${location.address3}</c:if>
											    		</td>
											    		<td>
															  ${location.city}
											    		</td>
											    		<td>
															  ${location.state}
											    		</td>
											    		<td>
															  ${location.zipCode}
											    		</td>				
										    		</tr>
										    	</c:forEach>
										    </c:otherwise>
										</c:choose>
								    </tbody>
				   					
								</table>
				    		</c:otherwise>
						</c:choose>
					
					</div>
					<div class="span2">
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
	
	<!-- Reset Next --> 
	<input id="appointment.appointmentDate" name="appointment.appointmentDate" type="hidden" value=""/>
	
	<input id="appointment.startTime" name="appointment.startTime" type="hidden" value=""/>
	<input id="appointment.endTime" name="appointment.endTime" type="hidden" value=""/>
	
</form:form>

<script>
	$(document).ready(function() {
		$('#localitySearch').typeahead({
        	minLength: 3,
        	source: function(query, process) {
        		var url = 'city/search?q=' + encodeURIComponent(query);
            	$.getJSON(url, function(data) {
					process(data);
				});
        	},
        	sorter: function (items) {
	            items.unshift(this.query);
	            return items;
	        }
    	});
	});	
</script>

<jsp:include page="templates/bottom.jsp"/>