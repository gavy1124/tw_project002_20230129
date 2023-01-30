<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

 <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">Project 02</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">홈</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">고객센터</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">기타</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                    </ul>
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi bi-box-arrow-in-left" data-bs-toggle="modal" data-bs-target="#loginModal">로그인</i> </button>
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi bi-door-open">로그아웃</i></button>
                            
                            
                            
						                            
 <!-- Button trigger modal -->
<!-- 						<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
						  Launch demo modal
						</button>
						 -->
						
<!-- Modal -->
						<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						        아이디<input><br/><br/>
						        비밀번호<input><br/><br/>
						        <div><a href="https://kauth.kakao.com/oauth/authorize?client_id=4b022c628d4dfcc0d79d0dec15b391be&redirect_uri=http://localhost:8088/pro/kakaoLog&response_type=code"><img alt="" src="/pro/images/kakao_login.png"></a></div>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						        <button type="button" class="btn btn-primary">Save changes</button>
						      </div>
						    </div>
						  </div>
						</div>   
						                            
                            
                            
                            
                            
                            
                            
                </div>
            </div>
        </nav>
        


</body>
</html>