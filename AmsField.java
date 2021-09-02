package ams;


import javax.swing.JOptionPane;

//기능구현
public class AmsField {
	// 항공사, 항공기번호, 최대승객수, 출발지, 도착지
	String[][] arrPlane = new String[100][5]; // 100개의 비행기
	int count; // 전역변수로 선언시 0자동
	int cLength = arrPlane[0].length;
	String result = "";
	int updateIndex;
	// 추가하기
	void insert(String[] arPlane) {
		// count를 지역변수를 선언시 호출할떄마다 0으로 리셋된다.
		arrPlane[count] = arPlane;
		count++;
	}

	// 검색하기
	String search(String keyword,int index) { // 사용한 부분의 return값의 전체가 string 이기에
		int arIndex[];
		String result = "";
		int Searchcount = 0;// count로하면 전역변수이기에 전체 증가- but, 검색된 것만 증가되어여 하기에
		for (int i = 0; i < count; i++) {
			if (keyword.equals(arrPlane[i][index])) {
				Searchcount++;
				updateIndex=i;
				result += "" + i + ",";

			}
		}
		arIndex = new int[Searchcount];
		for (int i = 0; i < arIndex.length; i++) {
			arIndex[i] = Integer.parseInt(result.split(",")[i]);
		}
		return show(arIndex);

	}

	// 수정하기

	// 출발지, 목적지항공기 번호를 입력받고 해당
	// 출발지 수정 ,목적지 수정
	// 항공기 번호 존재시,
	// JOptionpane.showOptionDialog()사용하기
	//  항공기의 출발지와 목적지를 수정
	// 출발지와 목적지가 동일하면 수정 실패

	// 항공기 번호, 출발지 수정인지 목적지 수정인지 , 수정할 새로운 값
	//index,newValue
	void update( int btnIndex, String newValue) {
		arrPlane[updateIndex][btnIndex+3]=newValue;
		if(arrPlane[updateIndex][3].equals(arrPlane[updateIndex][4]) ) {
			JOptionPane.showMessageDialog(null, "출발지와 도착지가 같습니다.");
		}
				//btnIndex
				//출발지 :0
				//도착지 :1
				//index 번호 
				//출발지 :3
				//도착지 : 4
			}
		
	

	// 삭제하기
	// 항공기번호로
	boolean delet(String keyword) {
		boolean deleteCheck = false;
		if(count==0) {
			JOptionPane.showMessageDialog(null, "없음");
		}
	
		for (int i = 0; i < count; i++) {
			if (arrPlane[i][1].equals(keyword)) {
				// count-1 : 마지막 정보가 담긴 행
				// count:null이 담긴 행
				for (int j = i; j < count; j++) {
					arrPlane[j] = arrPlane[j + 1];
				}
				deleteCheck = true;
				count--;
				break;
			}
		}
	

		return deleteCheck;
	}

	// 목록보기
	String show() {
		String result = "	항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n";

		for (int i = 0; i < count; i++) {
			result += "♥"; // 각 첫 행마다
			for (int j = 0; j < cLength; j++) {
				result += j == cLength - 1 ? arrPlane[i][j] : arrPlane[i][j] + ", "; // 마지막일 때 쉼표 없이 하기위해 (삼항 연산자)
			}
			result += "\n";

		}
		if (count == 0 || count < 0) {
			result = "목록 없음";
		}
		return result;

	}

	// 검색결과 보기(오버로딩) //
	String show(int[] arIndex) {
		// 목록보기와 검색결과 result 따로 만들어줌
		String result = "항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n";

		for (int i = 0; i < arIndex.length; i++) {
			result += "♥"; // 각 첫 행마다
			for (int j = 0; j < cLength; j++) {
				result += arrPlane[arIndex[i]][j];// 행 번호 고정
				result += j == cLength - 1 ? "" : ", ";// 마지막에는 쉼표 붙이지x
			}
			result += "\n";
		}
		if (arIndex.length == 0) {
			result = "검색 결과 없음";
		}
		return result;
	}

}
