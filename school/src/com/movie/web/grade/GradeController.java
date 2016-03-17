package com.movie.web.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeController {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		GradeService service = new GradeServiceImpl();

		while (true) {
			System.out.println("[메뉴] 1.등록  2.수정  3.삭제  4.조회(전체) 5.조회(이름)  6.조회(학번)  7.회원수   0.종료");

			switch (scanner.nextInt()) {
			case 1:
				System.out.println("학번, 이름, 자바, SQL, JSP, 스프링");
				service.input(new GradeBean(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(),
						scanner.nextInt(), scanner.nextInt()));
				break;
			case 2:
				System.out.println("수정하려는 성적표의 학번, 자바, SQL, JSP, 스프링 점수를 입력하세요.");
				int hak = scanner.nextInt();
				String name = service.getGradeByHak(hak).getName();
				System.out.println(service.update(new GradeBean(hak, name, scanner.nextInt(), scanner.nextInt(),scanner.nextInt(), scanner.nextInt())));
				
				break;
			case 3:
				System.out.println("삭제하려는 학번을 입력해주세요.");
				service.delete(scanner.nextInt());
				break;
			case 4:
				System.out.println(service.getList());

				break;
			case 5:
				System.out.println("이름을 입력해주세요.");
				ArrayList<GradeBean> tempList = service.getGrades(scanner.next());
				System.out.println((tempList.size() == 0) ? "조회하려는 이름이 없습니다." : tempList.toString());
				break;
			case 6:
				System.out.println("학번을 입력해주세요.");
				GradeBean temp = service.getGradeByHak(scanner.nextInt());

				System.out.println((temp.getName() == null) ? "조회하려는 학번이 없습니다." : temp.toString());
				break;
			case 7:
				System.out.println(service.getCount());
				break;
			case 0:
				System.out.println("종료");
				return;

			default:
				System.out.println("잘못된값");
				return;
			}
		}
	}
}
