
<%@include file="/views/common/header.jsp"%>

<div class="container">
	<h4>Student List</h4>
	<table>
	<a href="#">Add New Student</a>
		<thead>
			<tr>
				<th>Roll No</th>
				<th>Name</th>
				<th>Address</th>
				<th>College Reg. No</th>
				<th>Update Action</th>
				<th>Delete Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sessionScope.student.studentList}" var="uistudent">
				<tr>
					<td>${uistudent.student.rollNo}</td>
					<td>${uistudent.student.name}</td>
					<td>${uistudent.student.address}</td>
					<td>${uistudent.student.collRegNo}</td>
					<td><a href="${uistudent.updateUrl}">Edit</a></td>
					<td><a href="${uistudent.deleteUrl}">Remove</a></td>
				</tr>
			</c:forEach>
			
		
		</tbody>
	</table>
</div>

<jsp:include page="/views/footer.jsp"></jsp:include>