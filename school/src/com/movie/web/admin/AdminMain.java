package com.movie.web.admin;

import java.util.Scanner;

public class AdminMain {
	public static void main(String[] args) {
		AdminService service = new AdminServiceImpl();
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("[메뉴] 1.학생리스트출력 0.종료");
			switch (s.nextInt()) {
			case 1: 
				System.out.println(service.getMemberList());
				break;
			case 2: 
				break;
			case 3:
				break;
			case 4: break;
			case 5: break;
			case 0:System.out.println("시스템 종료"); return;

			default:
				return;
			}
		}
	}

}
