<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- css -->
<link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Additional CSS Files -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/fontawesome.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/templatemo-sixteen.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/owl.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/form.css?dd">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" /> <!-- div 크기 조정 -->

<!-- js -->
<!-- Bootstrap core JavaScript -->
<script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Additional Scripts -->
<script src="<%=request.getContextPath()%>/resources/assets/js/custom.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets/js/owl.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets/js/slick.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets/js/isotope.js"></script>
<script src="<%=request.getContextPath()%>/resources/assets/js/accordions.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script><!-- div 크기 조정 -->
<script src="<%=request.getContextPath()%>/resources/assets/js/formCreate.js?d"></script>

</head>

  <body>

    <!-- ***** Preloader Start ***** -->
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
    <!-- ***** Preloader End ***** -->

    <!-- Header -->
    <header class="">
      <nav class="navbar navbar-expand-lg">
        <div class="container">
          <a class="navbar-brand" href="index.html"><h2>Sixteen <em>Clothing</em></h2></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item active">
                <a class="nav-link" href="index.html">Home
                  <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="products.html">Our Products</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="about.html">About Us</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="contact.html">Contact Us</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>


<body>
    <div style="height: 100px;"></div>
    <!--body-->
      <form action="formCreate" method="post" modelAttribute = "form" onsubmit="return isValidForm()">
      <div id="form_div">

          <div id="menu-bar">+</div>

          <div class="form edit title">
              <input id="formName" name="formName" placeholder="제목을 입력해주세요" value="지워라 나중에" required/>
              <input name="user_id" type="hidden" value="2"/> <!-- value session에서 가져와야함니당 -->
              <select id="category_select" name="category_id" required>
               	<!-- TODO : 카테고리 table에서 READ -->
                <option value="" selected disabled>카테고리 선택</option>
                <!-- value로 카테고리 Id를 넣어야해요! READ할 때 참고해주세욤 -->
                <option value="1">카테고리1</option>
                <option value="2">카테고리2</option>
                <option value="3">카테고리3</option>

              </select><br>
              <input id="startDate" name="startDate" type="date" value="2020-09-23" required/><input id="startTime" name="startTime" type="time" value="10:00" required/>
               ~ <input id="endDate" name="endDate" type="date" value="2020-09-30" required/><input id="endTime" name="endTime" type="time" value="23:00" required/>
              <textarea name="explanation" placeholder="설문지 설명"></textarea>
              <input name="plusPoint" type="hidden" value="0"/> <!-- type="number" -->
              <input name="minusPoint" type="hidden" value="0"/> <!-- type="number" -->
              <input type="hidden" id="count" name="count" value="0"/>
          </div>

          <div class="form edit state">
            상태 선택
          </div>

          <div id="list"></div>

          <div class="form edit button">
            <button type="button" id="confirm">확인</button> 
          </div>

          <div class="form edit button" style="display: none;"><!--UPDATE시 사용 예정 -->
            <button type="button" class="edit">수정</button>
            <button type="button" class="cancle">취소</button>
          </div>

        </div>
        <div id="confirm_modal">
	        <h4>설문지 작성이 완료되었습니다.</h4>
	        <p>
	        <span class="modal_title">제목 : </span><span id="confirm_title"></span><br>
	        <span class="modal_title">분류 : </span><span id="confirm_category"></span><br>
	        <span class="modal_title">기간 : </span><span id="confirm_start"></span> ~ <span id="confirm_end"></span> <br>
	        <span class="modal_title">링크 : </span><input id="link" type="text" name="url"/>
	        <button id="red_ck_link" type="button">중복 확인</button>
	        <span id="link_dup_txt" style="margin-left: 10px;"></span><br>
	        </p>
	        <button type="submit" id="form_submit" class="submit" style="border: solid 1px black">확인</button>
	        <a class="modal_close_btn"><button type="button">취소</button></a>
    	</div>
      </form>

      <div class="add" id="field_add">
        <div class="form edit field" id="filed?"> <!--?에는 나중에 fieldId나 Index 들어감-->
          <input class="field_title" name="f_title?" placeholder="질문 제목"/>
          <input type=checkbox class="isEssential_fake" name="isEssential_fake">
                  <label for="필수질문">필수</label>
          </input>
          <input type="hidden" name="isEssential?" class="isEssential" value="0"/>
          <input type="hidden" class="index" value="0"/>
          <input type="hidden" class="count" id="count?" name="count?" value="0"/>

          <button type="button" class="remove">X</button><br>
          <select class="field_type" name="f_type?"> <!-- TODO required -->
            <option value="" selected disabled>질문유형</option>
            <option value="text">단답형</option>
            <option value="textarea">장문형</option>
            <option value="radio">객관식</option>
            <option value="checkbox">체크박스</option>
            <option value="select">드롭다운</option>
            <option value="file">파일업로드</option>
            <option value="date">날짜</option>
            <option value="time">시간</option>
            <!-- 직선단계, 객관식 그리드, 체크박스 그리드-->
          </select>
          <div class="content"></div>
        </div>
      </div>

    <div class="add" id="radio_add">
      <div>
        <input class="radio_fake" type="radio" disabled><label class="item" for=""></label></input><button type="button" class="remove_item">X</button>
        <input class="radio_real" type="hidden" name="?content?" value=""/>
      </div>
    </div>

    <div class="add" id="chxbox_add">
      <div>
        <input class="checkbox_fake" type="checkbox" disabled><label class="item" for=""></label></input><button type="button" class="remove_item">X</button>
     	<input class="checkbox_real" type="hidden" name="?content?" value=""/>
      </div>
    </div>

   <div class="add" id="select_add">
        <option class="option_fake" value=""/>
    </div>
    
    <div class="add" id="select_value_add">
    	<input class="option_real" type="hidden" name="?content?" value=""/>
    </div>
   

  </body>

    <footer>
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="inner-content">
              <p>Copyright &copy; 2020 Sixteen Clothing Co., Ltd.

            - Design: <a rel="nofollow noopener" href="https://templatemo.com" target="_blank">TemplateMo</a></p>
            </div>
          </div>
        </div>
      </div>
    </footer>

</html>

<script>

/** TODO
* 자동으로 height 조정 (현재는 마우스로 크기조정 가능)
* 그래도 어느 정도의 CSS
* 상태 선택
* 이미지 추가 -> 전체적 or item 마다 -> DB 수정도 필요
* '기타' 추가 기능
* 복사 기능
**/

</script>
