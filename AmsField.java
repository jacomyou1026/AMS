package ams;


import javax.swing.JOptionPane;

//��ɱ���
public class AmsField {
	// �װ���, �װ����ȣ, �ִ�°���, �����, ������
	String[][] arrPlane = new String[100][5]; // 100���� �����
	int count; // ���������� ����� 0�ڵ�
	int cLength = arrPlane[0].length;
	String result = "";
	int updateIndex;
	// �߰��ϱ�
	void insert(String[] arPlane) {
		// count�� ���������� ����� ȣ���ҋ����� 0���� ���µȴ�.
		arrPlane[count] = arPlane;
		count++;
	}

	// �˻��ϱ�
	String search(String keyword,int index) { // ����� �κ��� return���� ��ü�� string �̱⿡
		int arIndex[];
		String result = "";
		int Searchcount = 0;// count���ϸ� ���������̱⿡ ��ü ����- but, �˻��� �͸� �����Ǿ �ϱ⿡
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

	// �����ϱ�

	// �����, �������װ��� ��ȣ�� �Է¹ް� �ش�
	// ����� ���� ,������ ����
	// �װ��� ��ȣ �����,
	// JOptionpane.showOptionDialog()����ϱ�
	//  �װ����� ������� �������� ����
	// ������� �������� �����ϸ� ���� ����

	// �װ��� ��ȣ, ����� �������� ������ �������� , ������ ���ο� ��
	//index,newValue
	void update( int btnIndex, String newValue) {
		arrPlane[updateIndex][btnIndex+3]=newValue;
		if(arrPlane[updateIndex][3].equals(arrPlane[updateIndex][4]) ) {
			JOptionPane.showMessageDialog(null, "������� �������� �����ϴ�.");
		}
				//btnIndex
				//����� :0
				//������ :1
				//index ��ȣ 
				//����� :3
				//������ : 4
			}
		
	

	// �����ϱ�
	// �װ����ȣ��
	boolean delet(String keyword) {
		boolean deleteCheck = false;
		if(count==0) {
			JOptionPane.showMessageDialog(null, "����");
		}
	
		for (int i = 0; i < count; i++) {
			if (arrPlane[i][1].equals(keyword)) {
				// count-1 : ������ ������ ��� ��
				// count:null�� ��� ��
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

	// ��Ϻ���
	String show() {
		String result = "	�װ���, �װ����ȣ, �ִ�°���(��), �����, ������\n";

		for (int i = 0; i < count; i++) {
			result += "��"; // �� ù �ึ��
			for (int j = 0; j < cLength; j++) {
				result += j == cLength - 1 ? arrPlane[i][j] : arrPlane[i][j] + ", "; // �������� �� ��ǥ ���� �ϱ����� (���� ������)
			}
			result += "\n";

		}
		if (count == 0 || count < 0) {
			result = "��� ����";
		}
		return result;

	}

	// �˻���� ����(�����ε�) //
	String show(int[] arIndex) {
		// ��Ϻ���� �˻���� result ���� �������
		String result = "�װ���, �װ����ȣ, �ִ�°���(��), �����, ������\n";

		for (int i = 0; i < arIndex.length; i++) {
			result += "��"; // �� ù �ึ��
			for (int j = 0; j < cLength; j++) {
				result += arrPlane[arIndex[i]][j];// �� ��ȣ ����
				result += j == cLength - 1 ? "" : ", ";// ���������� ��ǥ ������x
			}
			result += "\n";
		}
		if (arIndex.length == 0) {
			result = "�˻� ��� ����";
		}
		return result;
	}

}
