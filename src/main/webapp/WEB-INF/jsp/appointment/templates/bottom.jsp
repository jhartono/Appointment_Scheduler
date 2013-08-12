<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

								</div> <!-- //.span12 -->
							</div> <!-- //.row -->
    					</div> <!-- //.tab-pane active -->
    				</div> <!-- //.span12 -->
    			</div> <!-- //.rootwizard -->
			</section>
 		</div> <!-- //.span12 -->
	</div> <!-- //.container -->
	
	<!-- Bootstrap JS: compiled and minified -->
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
	<script src="${bootstrapJS}"></script>
	
	<!-- Bootstrap Datepicker JS: compiled and minified -->
	<spring:url value="/resources/js/bootstrap-datepicker.js" var="bootstrapDatepickerJS" />
	<script src="${bootstrapDatepickerJS}"></script>
	
	<!-- Bootstrap Wizard JS: compiled and minified -->
	<spring:url value="/resources/js/jquery.bootstrap.wizard.min.js" var="bootstrapWizardJS" />
	<script src="${bootstrapWizardJS}"></script>
	
	<script>
		$(document).ready(function() {
			$('#rootwizard').bootstrapWizard({onTabClick: function(tab, navigation, index) {
				return false;
			}});
		});	
	</script>
  </body>
</html>