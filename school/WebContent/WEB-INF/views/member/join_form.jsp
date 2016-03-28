<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../global/header.jsp" />
<div id="join">
	<div class="joinTop">
		<h2 class="text-center">회원가입</h2>
	</div>
	<form>
	<div class="joinCenter row">
			<fieldset class="joinField">
				<div class="form-group">
					<label for="input_id" class="col-sm-4 control-label">아이디</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="id" name="id"
							placeholder="아이디를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="비밀번호를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_pw_check" class="col-sm-4 control-label">비밀번호
						확인</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" name="passwordCheck"
							id="passwordCheck" placeholder="비밀번호를 확인하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">이름</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="이름을 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">주소</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="addr" name="addr"
							placeholder="주소를 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="birth" name="birth"
							placeholder="생년월일을 입력하세요" />
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">수강과목</label>
					<div class="col-sm-4">
						<input type="checkbox" class="form-control" id="subject" name="subject" /> Java
						<input type="checkbox" class="form-control" id="subject" name="subject" /> Jsp
						<input type="checkbox" class="form-control" id="subject" name="subject" /> SQL
						<input type="checkbox" class="form-control" id="subject" name="subject" /> Spring
						<input type="checkbox" class="form-control" id="subject" name="subject" /> 파이썬
						<input type="checkbox" class="form-control" id="subject" name="subject" /> 노드JS
						<input type="checkbox" class="form-control" id="subject" name="subject" /> 안드로이드
					</div>
				</div>
				<div class="form-group">
					<label for="input_name" class="col-sm-4 control-label">전  공</label>
					<select name="major" id="major">
					<option value="computer">컴퓨터공학</option>
					<option value="info">정보통신</option>
					<option value="security">정보보안</option>
					</select>
				</div>
				
				
				<div class="input_button text-center">
					<img src="${context}/resources/img/member/join.png" id="joinButton" />
					<img src="${context}/resources/img/member/reset.jpg" id="resetButton" />
				</div>

			</fieldset>
		</form>
		<script>
			$(function() {
				$('form').addClass('form-horizontal');
				$('#joinButton').css('width','160px').css('height','50px')
				$('#resetButton').css('width','160px').css('height','50px')
				$('#joinButton').click(	function() {
					$('form').attr('action','${context}/member/join.do').attr('method','post').submit();
				})
				$('#resetButton').click(function() {
					 $("form")[0].reset(); 
				})
			});
		</script>
	</div>
</div>
