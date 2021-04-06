package com.walab.oas.DTO;

import lombok.Data;

@Data
public class AttachFileDTO {
	private String fileName;  //원본파일 이름
	private String uploadPath;  //업로드 경로
	private String uuid;  //UUID 값
	private boolean image;  //이미지 여부
}