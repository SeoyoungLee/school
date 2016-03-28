<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../member/member_header.jsp"/>
<div id="detail">
		<div class="joinTop">
			<h2 class="text-center">${sessionScope.user.name} 상세정보</h2>
		</div>
		<div class="joinCenter row">
			<form>
				<fieldset class="joinField">
					<div class="form-group">
					 	<label for="input_id" class="col-sm-4 control-label">아이디</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.id}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_pw" class="col-sm-4 control-label">비밀번호</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.password}" readonly="readonly"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">이름</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.name}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">주소</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.addr}" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group">
						<label for="input_name" class="col-sm-4 control-label">생년월일</label>
					 	<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id" value="${sessionScope.user.birth}" readonly="readonly"/>
						</div>
					</div>
					<div class="input_button text-center">
						<img src="${context}/resources/img/member/update.png" id="updateButton" />
						<img src="${context}/resources/img/member/delete.jpg" id="deleteButton" />
						<img src="${context}/resources/img/member/myscore.png" id="myScoreButton" />
						
					</div>
						
				</fieldset>
			</form>
			</div>
		</div>
		<script>
		$(function() {
			$('form').addClass('form-horizontal');
			$('#updateButton').css('width','160px').css('height','50px')
			$('#deleteButton').css('width','160px').css('height','50px')
			$('#myScoreButton').css('width','160px').css('height','50px')
			$('#updateButton').click(function() {
				location.href='${context}/member/update_form.do';
			})
			$('#deleteButton').click(function() {
				location.href='${context}/member/delete.do';
			})
			$('#myScoreButton').click(function() {
				location.href='${context}/grade/my_grade.do';
			})
		});
		</script>
