package com.gavy.pro;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.KakaoProfile;
import model.OAuthToken_DTO;

@Controller
public class MemberController {
	
	@RequestMapping("/index")
	public String test() {
	return "index";
	}
	
	//한글깨짐으로 추가 (application/json;charset=UTF-8)
	@RequestMapping(value = "/kakaoLog", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	@ResponseBody
	public String kakaoCallback(String code){

//		Https://kauth.kakao.com/oauth/token 
//			grant_type = authorization_code
//			client_id = REST API키
//			redirect_uri = 설정한 redirect_uri
//			code = 인가 코드 받기 요청으로 얻은 인가 코드
//			client_secret = 필수x
		
		
		
		// HttpHeader 오브젝트 생성
		RestTemplate rt = new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		//HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "4b022c628d4dfcc0d79d0dec15b391be");
		params.add("redirect_uri", "http://localhost:8088/pro/kakaoLog");
		params.add("code", code);
		
		
		// HttpHeader + HttpBody 를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = 
				new HttpEntity<>(params,headers);
		
		
		//왜 HttpEntity 에 하나로 담느냐 ????
		//RestTemplate의 exchange 메서드가     HttpEntity를 받도록 되어져있다.
		
		
		
		//실제 요청 ( Http요청하기 - post방식으로, response 변수 응답받음 )
		ResponseEntity<String> response = rt.exchange(
			"Https://kauth.kakao.com/oauth/token", //토큰발급요청주소
			HttpMethod.POST, 						// 요청방식
			kakaoTokenRequest,						//데이터 (바디와 헤더값)
			String.class 							// 응답받을 타입
		);
		
		
		
		
		//Gson, JsonSimple, ObjectMapper 다양한 라이브러리가 잇음 (ObjectMapper사용)
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthToken_DTO oauthToken= null;
		try {
			 oauthToken = objectMapper.readValue(response.getBody(), OAuthToken_DTO.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("카카오 엑세스 토큰 : "+oauthToken.getAccess_token());
		//___________________________________________
		

		// HttpHeader 오브젝트 생성
		RestTemplate rt2 = new RestTemplate(); 
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization","Bearer " + oauthToken.getAccess_token());
		headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		
		// HttpHeader를 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest2 =  new HttpEntity<>(headers2);
		
		
		//왜 HttpEntity 에 하나로 담느냐 ????
		//RestTemplate의 exchange 메서드가 HttpEntity를 받도록 되어져있다.
		
		
		
		//실제 요청 ( Http요청하기 - post방식으로, response 변수 응답받음 )
		ResponseEntity<String> response2 = rt2.exchange(
			"https://kapi.kakao.com/v2/user/me", //토큰발급요청주소
			HttpMethod.POST, 						// 요청방식
			kakaoProfileRequest2,						//데이터 (바디와 헤더값)
			String.class 							// 응답받을 타입
		);
		
		//----------------------------------------------------------------------------------------
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile= null;
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(response2.getBody());
		
		System.out.println("카카오 아이디(번호):" + kakaoProfile.getId());
		System.out.println("카카오 닉네임:" + kakaoProfile.getProperties().getNickname());
		System.out.println("카카오 프로필이미지:" + kakaoProfile.getProperties().getProfile_image());
		
		//haeder내용보단 , body의 내용이 중요하다...
		//테
		return response2.getBody();
	}

	
	
	
	
	
	
	
}
