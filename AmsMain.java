package ams;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsMain {
	// Ʋ���

	public static void main(String[] args) {
		AmsField af = new AmsField();// ���������� new�� ������ ���� �޸� ����(�ʱ�ȭ��)
										// ��, Static������ ���α׷� ���� ��. �޸� ����(�ʱ�ȭ)
		ImageIcon img = new ImageIcon("src/img/main.gif");
		// ������: �� ��ġ�� ������ ã�ư� �� �ִ� ���
		// ��� ���: �� ��ġ�� ���� ����Ǵ� ���
		String[] menu = { "�߰��ϱ�", "�˻��ϱ�", "�����ϱ�", "�����ϱ�", "��Ϻ���" }; // 0����
		int choice = 0;
		String keyword = "";
		String insertMsg = "[�߰��Ͻ� ������ �״�� �Է��ϼ���(, ����)]\n" + "�װ���, �װ����ȣ, �ִ�°���, �����, ������";
		String[] arPlane = new String[5];
		String deleteMsg = "�����Ͻ� �װ��� ��ȣ�� �Է��ϼ���\n";
		String[] updateMenu = { "����� ����", "������ ����" };
		String[] searchMenu = { "�װ���", "�װ��� ��ȣ", "�ִ� �°���", "�����", "����ġ" };
		String updateMsg = "�����Ͻ� �װ��� ��ȣ�� �Է��ϼ���!\n";
		int index = 0;

		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, img, menu, null);

			System.out.println(choice);
			if (choice == -1) {
				break;
			}

			switch (choice) {
			// �߰��ϱ� ����
			case 0:
				arPlane = JOptionPane.showInputDialog(insertMsg).split(", ");
				af.insert(arPlane);
				break;
				
			// �˻��ϱ� ����
			case 1:
				index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, img, searchMenu, null);
				if (index != -1) {
					keyword = JOptionPane.showInputDialog("�˻��Ͻ� " + searchMenu[index] + "��(��) �Է��ϼ���");
					JOptionPane.showMessageDialog(null, af.search(keyword, index));
				}
				break;

			// �����ϱ� ����
			case 2:
				String planeNum = JOptionPane.showInputDialog(updateMsg);
				String temp = af.search(planeNum, 1);// �װ����ȣ�̱⿡ :1
				if (temp.equals("�˻� ��� ����")) {
					JOptionPane.showMessageDialog(null, "���� ����");
				} else {
					index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE, img, updateMenu, null);
					if (index != -1) {
						String newValue = JOptionPane.showInputDialog("���ο�" + updateMenu[index] + "�� �Է��ϼ���");
						af.update(index, newValue);
						
											}
				}
				break;
			// �����ϱ� ����
			case 3:
				keyword = JOptionPane.showInputDialog(deleteMsg);
				if (af.delet(keyword)) {
					JOptionPane.showMessageDialog(null, "���� ����");
				} else {
					JOptionPane.showMessageDialog(null, "���� ����");

				}

				break;
			// ��Ϻ��� ����
			case 4:
				JOptionPane.showMessageDialog(null, af.show());
				break;
			}
			// default���� �ʿ�x : ��ư�̱⿡
		}
	}
}
