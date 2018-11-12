package minigame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

// ��ŰŬ��Ŀ - ������
class A_cookie implements ActionListener{
	private JLabel store, score, ss;
	private JButton[] good;
	private JLabel[] mat;
	private JLabel bake;
	private JButton cookie, oven;
	private int add = 1;
	private int s = 0;
	private int flour = 0, egg = 0, sugar = 0;
	private int coo=0;
	
	public A_cookie() {
		JFrame frame= new JFrame();
		frame.setTitle("COOKIE CLICKER!!!");
		
		//�г�
		JPanel jp = new JPanel(null);
		jp.setBackground(new Color(255,235,205));
		frame.add(jp);
		
		//��Ű��ư
		cookie = new JButton(new ImageIcon("cookie.jpg"));
		cookie.setBounds(50, 50, 400, 250);
		cookie.addActionListener(this);
		jp.add(cookie);
		
		//����
		ss = new JLabel("SCORE:" + s);
		ss.setBounds(170, 300, 300, 100);
		ss.setFont(new Font("����ǹ��� �־�", 40, 45));
		jp.add(ss);
		
		//�����ư
		oven = new JButton(new ImageIcon("oven.jpg"));
		oven.setBounds(50, 400, 260, 300);
		oven.addActionListener(this);
		jp.add(oven);
		
		//bake
		bake = new JLabel("��Ű : " + coo);
		bake.setBounds(400, 510, 200, 50);
		bake.setFont(new Font("����ǹ��� �־�", 40, 30));
		jp.add(bake);
		
		//store
		store = new JLabel("STORE");
		store.setBounds(690, 40, 300, 40);
		store.setFont(new Font("����ǹ��� �־�", 40, 40));
		jp.add(store);
		
		
		//��ǰ
		good = new JButton[4];
		good[0] = new JButton("+" + add + " ����(-200p)");
		good[1] = new JButton("�а���+����ŷ�Ŀ��+����(-500p)");
		good[2] = new JButton("�ް�+����(-300p)");
		good[3] = new JButton("����+�ұ�(-100p)");
	
		good[0].setBounds(600, 90, 280, 60);
		good[1].setBounds(600, 160, 280, 60);
		good[2].setBounds(600, 230, 280, 60);
		good[3].setBounds(600, 300, 280, 60);
		
		for(int i=0; i<4; i++){
			good[i].setBackground(new Color(255,140,120));
			good[i].setFont(new Font("����ǹ��� �־�", 10, 18));
			good[i].addActionListener(this);
			jp.add(good[i]);
		}
		
		//�а���+����ŷ�Ŀ��+�ް�........
		mat = new JLabel[3];
		mat[0] = new JLabel("�а���+����ŷ�Ŀ�� : " + flour);
		mat[1] = new JLabel("�ް�+����+���� : " + egg);
		mat[2] = new JLabel("����+�ұ� : " + sugar);
		
		for(int i=0; i<3; i++){
			mat[i].setFont(new Font("����ǹ��� �־�", 40, 30));
			jp.add(mat[i]);
		}
		mat[0].setBounds(600, 450, 400, 50);
		mat[1].setBounds(600, 510, 400, 50);
		mat[2].setBounds(600, 570, 400, 50);
		
		frame.setSize(1000, 800);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		//��Ű
		if(e.getSource() == cookie){
			s += add;
			ss.setText("SCORE:" + s);
		}
		
		//����
		if(e.getSource() == oven && flour >= 1 && egg >= 1 && sugar >= 1){
			coo++;
			flour--;
			egg--;
			sugar--;
			mat[0].setText("�а���+����ŷ�Ŀ�� : " + flour);
			mat[1].setText("�ް�+����+���� : " + egg);
			mat[2].setText("����+�ұ� : " + sugar);
			bake.setText("��Ű : " + coo);
			JOptionPane.showMessageDialog(null, "��Ű 1���� �ϼ��Ǿ����ϴ�!", "��Ű ����", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == oven && (flour < 1 || egg < 1 || sugar < 1)){
			JOptionPane.showMessageDialog(null, "��� ��ᰡ 1�� �̻� �־�� ��Ű�� ���� �� �ֽ��ϴ�.", "��� ����", JOptionPane.WARNING_MESSAGE);
		}
		
		//���ϱ�
		if(e.getSource() == good[0] && s>=200){
			s -= 200;
			add++;
			good[0].setText("+" + add + " ����(-200p)");
			ss.setText("SCORE:" + s);
			JOptionPane.showMessageDialog(null, "������ ���� �Ϸ�!", "������ ����", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[0] && s<200){
			JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.", "����Ʈ ����", JOptionPane.WARNING_MESSAGE);
		}
		
		//�а���+����ŷ�Ŀ��
		if(e.getSource() == good[1] && s>=500){
			s -= 500;
			flour++;
			ss.setText("SCORE:" + s);
			mat[0].setText("�а���+����ŷ�Ŀ�� : " + flour);
			JOptionPane.showMessageDialog(null, "�а���+����ŷ�Ŀ�� ���� �Ϸ�!", "���� �˸�", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[1] && s<500){
			JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.", "����Ʈ ����", JOptionPane.WARNING_MESSAGE);
		}
		
		//�ް�+����+����
		if(e.getSource() == good[2] && s>=300){
			s -= 300;
			egg++;
			ss.setText("SCORE:" + s);
			mat[1].setText("�ް�+����+���� : " + egg);
			JOptionPane.showMessageDialog(null, "�ް�+����+���� ���� �Ϸ�!", "���� �˸�", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[2] && s<300){
			JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.", "����Ʈ ����", JOptionPane.WARNING_MESSAGE);
		}
		
		//����+�ұ�
		if(e.getSource() == good[3] && s>=100){
			s -= 100;
			sugar++;
			ss.setText("SCORE:" + s);
			mat[2].setText("����+�ұ� : " + sugar);
			JOptionPane.showMessageDialog(null, "����+�ұ� ���� �Ϸ�!", "���� �˸�", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[3] && s<100){
			JOptionPane.showMessageDialog(null, "����Ʈ�� �����մϴ�.", "����Ʈ ����", JOptionPane.WARNING_MESSAGE);
		}
	}
}

class B_reverseword extends JFrame implements ActionListener{
	private JLabel print,howto;
	private int k = 0;
	private JTextField input = new JTextField();
	private String in;
	private JButton bt;
	ArrayList<String> words;
	
	//�ܾ� ����
	private String reversewords[] = {"doof", "eikooc", "elppa", "nep", "olleh", "traeh", "rats", "eseehc", "azzip", "nekcihc", "�似�ϳ��", "�似�������ÿ����","����ص��ӰԸ���"};
	public B_reverseword(){
    	//������
		JFrame frame= new JFrame();
		frame.setTitle("�βٲ�!!!!");
		//�г�
		JPanel jp = new JPanel(null);
		frame.add(jp);
		jp.setBackground(new Color(255,235,205));
		
		//�ܾ�
		addWords();
		
		howto = new JLabel("�Ųٷε� �ܾ� �� ������ ������� �ٲ㼭 �Է��غ�����!");
		howto.setBounds(105, 40, 500, 50);
		howto.setFont(new Font("����ǹ��� �־�",40,15));
		jp.add(howto);
		//ù�ܾ� �ֱ�
		print = new JLabel(""+reversewords[k++]);
		print.setBounds(110,120,300,100);
		jp.add(print);
		print.setFont(new Font("����ǹ��� �־�", 40, 20));
		input = new JTextField(8);
		input.setBounds(290,120,100,50);
		jp.add(input);
		
		//Ȯ�ι�ư
		bt = new JButton("Ȯ��");
		bt.addActionListener(this);
		bt.setBounds(300, 200, 70, 30);
		bt.setFont(new Font("����ǹ��� �־�", 40, 15));
		bt.setFocusPainted(false);
		bt.setBackground(new Color(255,255,255));
		jp.add(bt);
		
		frame.setSize(600, 400);
		frame.setVisible(true);
    }
    //�¾��� ��쿡 �����ܾ� �ֱ�
    public void la(){
		print.setText(""+reversewords[k++]);
	}
    //�ܾ� words�� �ֱ�
    public void addWords() {
    	words = new ArrayList<>();
    	for(int i=0; i<reversewords.length; i++){
    		words.add(i, reversewords[i]);
    	}
    }
    //�̺�Ʈ
    @Override
	public void actionPerformed(ActionEvent e){
    	if(e.getSource() == bt){
    		in = input.getText();
    		String word = new StringBuffer(reversewords[k-1]).reverse().toString();
    		
        	if(in.equals(word)){
        		JOptionPane.showMessageDialog(null, "����", "����", JOptionPane.INFORMATION_MESSAGE);
        		try{
        			la();
        		}catch(ArrayIndexOutOfBoundsException error){
        			JOptionPane.showMessageDialog(null, "���ӳ�", "���ӳ�", JOptionPane.INFORMATION_MESSAGE);
        			System.exit(1);
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "����", "����", JOptionPane.INFORMATION_MESSAGE);
        	}
    	}
    }
}
    
class C_YunFrame extends JFrame implements ActionListener{
	
	int startnumber = 1;
	int setstart = 1;
	
	JButton[] C_Button = new JButton[9];
	JPanel jpanel = new JPanel(null);
	JLabel jlabel = new JLabel("���ӹ�� : 1���� 9���� ���ڸ� ������� �����ּ���.");
	
	public C_YunFrame(){
		setSize(600,600);
		setTitle("�����߸�");
		setVisible(true);
		add(jpanel);
		jpanel.add(jlabel);
		jlabel.setFont(new Font("����ǹ��� �־�",10,15));
		jlabel.setBounds(150, 30, 500, 50);
		jpanel.setBackground(new Color(255,235,205));
		
		
				
		JButton C_start = new JButton("start");
		jpanel.add(C_start);
		C_start.setBounds(240, 100, 100, 50);
		C_start.setFocusPainted(false);
		C_start.setBackground(new Color(240,240,240));
		C_start.addActionListener(this);
		C_start.setFont(new Font("����ǹ��� �־�",10,20));
		
		
		
		button();
	}
	//���� ���� �����
	public int[] make(){
		int tmp=0;
		int size=9;
		int i=1;
		int[] test = new int[9];
		Random rnd = new Random();
		for(i=0;i<9;i++){
		    test[i]= i+1;
		}
		for(i=0;i<9;i++){
			int des =rnd.nextInt(size);
		    tmp = test[i];
		    test[i]=test[des];
		    test[des]=tmp;
		}
		 	
		return test;
	}
	//��ư �����
	public void button(){
		int[] first = make();
		
		for(int j=0; j < C_Button.length; j++){
			C_Button[j] = new JButton(first[j]+"");
			jpanel.add(C_Button[j]);
			C_Button[j].setFocusPainted(false);
			C_Button[j].setBackground(new Color(240,240,240));
			C_Button[j].addActionListener(this);
			C_Button[j].setFont(new Font("����ǹ��� �־�",10,25));
		}
		
		C_Button[0].setBounds(140,200,100,100);
		C_Button[1].setBounds(240,200,100,100);
		C_Button[2].setBounds(340,200,100,100);
		C_Button[3].setBounds(140,300,100,100);
		C_Button[4].setBounds(240,300,100,100);
		C_Button[5].setBounds(340,300,100,100);
		C_Button[6].setBounds(140,400,100,100);
		C_Button[7].setBounds(240,400,100,100);
		C_Button[8].setBounds(340,400,100,100);
	
	}
	//��ư ���� ����
	public void differ(){
		int[] next = make();
		for(int i = 0; i<9;i++){
			C_Button[i].setText(next[i]+"");			
		}
	}
	//��ư �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent e){
		JButton b = (JButton)e.getSource();
		if(b.getText().equals(startnumber+"")){
			b.setBackground(new Color(255,255,255));
			click();
		}
		
		JButton c = (JButton)e.getSource();
		if(c.getText().equals("start")){
			for(int i=0; i<9;i++){
				jpanel.remove(C_Button[i]);
				}
			button();
		
		}
	}
	
	//���� �Ϸ�
	public void click(){
		startnumber++;
		if(startnumber==10){
			startnumber=1;
			JOptionPane.showMessageDialog(null, "�ٽ� �ϰ� �����ø� start ��ư�� �����ּ���.", "����!", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	
}
public class minigame implements ActionListener{
	private JButton A, B, C;
	private JPanel jp;
	
	JFrame frame;
	
	public minigame() {
		JFrame frame = new JFrame();
		frame.setTitle("�̴ϰ���õ��!!");

		ImageIcon icon = new ImageIcon("back1.jpg");
		
		JPanel panel = new JPanel(null){
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		frame.add(panel);
		
		JLabel title = new JLabel("�̴ϰ���õ��!!");
		title.setBounds(380, 80, 500, 100);
		title.setFont(new Font("����ǹ��� �־�", 40, 45));
		panel.add(title);
		
		A = new JButton("1. ��ŰŬ��Ŀ");
		A.setFont(new Font("����ǹ��� �־�", 40, 30));
		A.setBounds(390, 280, 220, 70);
		A.addActionListener(this);
		A.setFocusPainted(false);
		A.setBackground(new Color(255,255,255));
		panel.add(A);
		
		B = new JButton("2. �βٲ�!");
		B.setBounds(410, 400, 180, 70);
		B.setFont(new Font("����ǹ��� �־�", 40, 30));
		B.addActionListener(this);
		B.setFocusPainted(false);
		B.setBackground(new Color(255,255,255));
		panel.add(B);
		
		C = new JButton("3. �����߸�");
		C.setBounds(395, 520, 210, 70);
		C.setFont(new Font("����ǹ��� �־�", 40, 30));
		C.addActionListener(this);
		C.setFocusPainted(false);
		C.setBackground(new Color(255,255,255));
		panel.add(C);
		
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == A){
			A_cookie a = new A_cookie();
		}
		if(e.getSource() == B){
			B_reverseword b = new B_reverseword();
		}
		if(e.getSource() == C){
			C_YunFrame c = new C_YunFrame();
		}
	}
	
	public static void main(String[] args) {
		new minigame();
	}
}