<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的员工信息</title>
</head>
<body>
	
<center>
	<table width="80%" border="0" cellspacing="1" bgcolor="#FF00FF" >
		
		<tr bgcolor="#FFFFFF" >
			<th colspan="6" align="right" >
				<a href="saveEmp.jsp" >添加员工</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</th>
		</tr>
		
		<tr bgcolor="#FFFFFF" align="center" height="45" >
			<th colspan="6" >
				<form action="ServlectTest?test=show" method="post" >
					员工姓名：<input type="text" name="LikeNname" />&nbsp;&nbsp;
					所属部门：<select name="LikeDid" >
								<option value="" />--请选择--
								<c:forEach items="${listDept }" var="s" >
									<option value="${s.did }" />${s.dname }
								</c:forEach>
						   </select>&nbsp;
						   <input type="submit" value="查 询" />				
				
				</form>
			</th>
		</tr>
		
		<tr bgcolor="#FFFFFF" >
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>生日</th>
			<th>性别</th>
			<th>所属部门</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${list}" var="emp" >
			<tr align="center" bgcolor="#FFFFFF"  >
				<td>${emp.eid }</td>
				<td>${emp.ename }</td>
				<td>${emp.bdate }</td>
				<td>${emp.sex }</td>
				<td>${emp.dname }</td>
				<td>
					<a href="#">修改</a>&nbsp;
					<a href="ServlectTest?test=DeleteEmp&eid=${emp.eid }">删除</a>
				</td>
			</tr>		
		</c:forEach>
	</table>
</center>			
</body>
</html>