package ams;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsMain {
	// 틀잡기

	public static void main(String[] args) {
		AmsField af = new AmsField();// 전역변수는 new를 만나는 순간 메모리 해제(초기화됨)
										// 단, Static변수는 프로그램 종료 시. 메모리 해제(초기화)
		ImageIcon img = new ImageIcon("src/img/main.gif");
		// 절대경로: 내 위치가 어디든지 찾아갈 수 있는 경로
		// 상대 경로: 내 위치에 따라서 변경되는 경로
		String[] menu = { "추가하기", "검색하기", "수정하기", "삭제하기", "목록보기" }; // 0부터
		int choice = 0;
		String keyword = "";
		String insertMsg = "[추가하실 정보를 그대로 입력하세요(, 포함)]\n" + "항공사, 항공기번호, 최대승객수, 출발지, 도착지";
		String[] arPlane = new String[5];
		String deleteMsg = "삭제하실 항공기 번호를 입력하세요\n";
		String[] updateMenu = { "출발지 수정", "목적지 수정" };
		String[] searchMenu = { "항공사", "항공기 번호", "최대 승객수", "출발지", "도착치" };
		String updateMsg = "수정하실 항공기 번호를 입력하세요!\n";
		int index = 0;

		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, img, menu, null);

			System.out.println(choice);
			if (choice == -1) {
				break;
			}

			switch (choice) {
			// 추가하기 영역
			case 0:
				arPlane = JOptionPane.showInputDialog(insertMsg).split(", ");
				af.insert(arPlane);
				break;
				
			// 검색하기 영역
			case 1:
				index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, img, searchMenu, null);
				if (index != -1) {
					keyword = JOptionPane.showInputDialog("검색하실 " + searchMenu[index] + "을(를) 입력하세요");
					JOptionPane.showMessageDialog(null, af.search(keyword, index));
				}
				break;

			// 수정하기 영역
			case 2:
				String planeNum = JOptionPane.showInputDialog(updateMsg);
				String temp = af.search(planeNum, 1);// 항공기번호이기에 :1
				if (temp.equals("검색 결과 없음")) {
					JOptionPane.showMessageDialog(null, "수정 실패");
				} else {
					index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, img, updateMenu, null);
					if (index != -1) {
						String newValue = JOptionPane.showInputDialog("새로운" + updateMenu[index] + "를 입력하세요");
						af.update(index, newValue);
						
											}
				}
				break;
			// 삭제하기 영역
			case 3:
				keyword = JOptionPane.showInputDialog(deleteMsg);
				if (af.delet(keyword)) {
					JOptionPane.showMessageDialog(null, "삭제 성공");
				} else {
					JOptionPane.showMessageDialog(null, "삭제 실패");

				}

				break;
			// 목록보기 영역
			case 4:
				JOptionPane.showMessageDialog(null, af.show());
				break;
			}
			// default적을 필요x : 버튼이기에
		}
	}
}
