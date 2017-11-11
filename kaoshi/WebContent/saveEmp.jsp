<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工</title>
</head>
<body>
<br><br>
<center>
	<form action="ServlectTest?test=saveEmp" method="post" >
		
		<table  width="40%" border="0" cellspacing="1" bgcolor="#FF00FF" >
			<tr bgcolor="#FFFFFF" >
				<th colspan="2" >
					添加员工信息
				</th>
			</tr>	
			
<!-- 			<tr bgcolor="#FFFFFF"> -->
<!-- 				<th align="right" >员工编号:</th> -->
<!-- 				<th align="left" > -->
<!-- 					<input type="text" name="eid" /> -->
<!-- 				</th> -->
<!-- 			</tr>	 -->
			
			<tr bgcolor="#FFFFFF">
				<th align="right" >员工姓名:</th>
				<th align="left" >
					<input type="text" name="ename" />
				</th>				
			</tr>	
			<tr bgcolor="#FFFFFF">
				<th align="right" >员工生日:</th>
				<th align="left" >
					<input type="text" name="bdate" />
				</th>
			</tr>	
			<tr bgcolor="#FFFFFF">
				<th align="right" >员工性别:</th>
				<th align="left" >
					<input type="radio" name="sex" value="f" />男
					<input type="radio" name="sex" value="m" />女
				</th>
			</tr>	
			<tr bgcolor="#FFFFFF">
				<th align="right" >所属部门:</th>
				<th align="left" >
					<select name="deptid" >
						<option value="0" />--请选择--
						<c:forEach items="${listDept }" var="s" > 
							<option value="${s.did }" />${s.dname}
						</c:forEach>
					</select>
				</th>
			</tr>	
			
			<tr bgcolor="#FFFFFF">
				<th colspan="2" >
					<input type="submit" value="提 交" />
					<input type="reset" value="重 置" />
				</th>
			</tr>	
		</table>
		
	</form>
</center>	
</body>
</html>