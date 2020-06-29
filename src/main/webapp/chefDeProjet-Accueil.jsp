<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Accueil</title>
	    <link rel="stylesheet" href="css/base.css">
	    <link rel="stylesheet" href="css/normalize.css">
	    <link rel="stylesheet" href="css/style.css">
	</head>
	
	<body>
	
		<jsp:include page="componants/header.jsp"></jsp:include>
		
		<jsp:include page="componants/navHeader.jsp"></jsp:include>
		
	    <main class="container-main">
	    
			<jsp:include page="componants/filArianne.jsp"></jsp:include>
			
	        <section>
	            <div>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nam, neque fugiat vero quas nulla quisquam rerum voluptatum amet, culpa consequatur aliquam impedit omnis. Optio illum aliquam illo nisi voluptate nam!</div>
	        </section>
	    </main>
	    
		<jsp:include page="componants/footer.jsp"></jsp:include>
	    
	</body>
	
</html>