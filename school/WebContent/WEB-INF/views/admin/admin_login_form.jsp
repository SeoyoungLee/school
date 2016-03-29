<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp"/>
	<style type="text/css">
		#login{
			margin-top: 5em;
		}
	</style>

	<div id="login">
		<div class="loginTop text-center" >
			<img src="${context}/resources/img/member/login_img.jpg" id="loginImg"/><br><br>
		</div>
		<form>
		<div class="loginCenter row" style="margin-left: 43.5%;">
				<fieldset class="loginField">
					<div class="form-group">
					 	<label for="input_id" class="control-label sr-only">아이디</label>
					 	<div class="col-sm-3">
							<input type="text" class="form-control" id="id" name="id" placeholder="관리자 아이디를 입력하세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="control-label sr-only">비밀번호</label>
					 	<div class="col-sm-3">
							<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력하세요"/>
 						</div>
					</div>
				</fieldset>
			
		</div>
		<div class="input_button text-center">
		<img src="${context}/resources/img/member/login.jpg" id="loginButton" />
		</div>
		</form>
	</div>
</body>
<script>
$(function() {
	$('form').addClass('form-horizontal');
	$('#loginImg').css('border','0').css('height','160px').css('width','160px');
	$('#loginButton').css('height','50px').css('width','160px')
	$('#loginButton').click(function() {
		$('form').attr('action','${context}/admin/admin_form.do').attr('method','post').submit();
	})

});
</script>
</html>