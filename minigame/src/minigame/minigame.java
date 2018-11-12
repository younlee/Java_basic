package minigame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

// 쿠키클리커 - 김지수
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
		
		//패널
		JPanel jp = new JPanel(null);
		jp.setBackground(new Color(255,235,205));
		frame.add(jp);
		
		//쿠키버튼
		cookie = new JButton(new ImageIcon("cookie.jpg"));
		cookie.setBounds(50, 50, 400, 250);
		cookie.addActionListener(this);
		jp.add(cookie);
		
		//점수
		ss = new JLabel("SCORE:" + s);
		ss.setBounds(170, 300, 300, 100);
		ss.setFont(new Font("배달의민족 주아", 40, 45));
		jp.add(ss);
		
		//오븐버튼
		oven = new JButton(new ImageIcon("oven.jpg"));
		oven.setBounds(50, 400, 260, 300);
		oven.addActionListener(this);
		jp.add(oven);
		
		//bake
		bake = new JLabel("쿠키 : " + coo);
		bake.setBounds(400, 510, 200, 50);
		bake.setFont(new Font("배달의민족 주아", 40, 30));
		jp.add(bake);
		
		//store
		store = new JLabel("STORE");
		store.setBounds(690, 40, 300, 40);
		store.setFont(new Font("배달의민족 주아", 40, 40));
		jp.add(store);
		
		
		//상품
		good = new JButton[4];
		good[0] = new JButton("+" + add + " 증가(-200p)");
		good[1] = new JButton("밀가루+베이킹파우더+우유(-500p)");
		good[2] = new JButton("달걀+버터(-300p)");
		good[3] = new JButton("설탕+소금(-100p)");
	
		good[0].setBounds(600, 90, 280, 60);
		good[1].setBounds(600, 160, 280, 60);
		good[2].setBounds(600, 230, 280, 60);
		good[3].setBounds(600, 300, 280, 60);
		
		for(int i=0; i<4; i++){
			good[i].setBackground(new Color(255,140,120));
			good[i].setFont(new Font("배달의민족 주아", 10, 18));
			good[i].addActionListener(this);
			jp.add(good[i]);
		}
		
		//밀가루+베이킹파우더+달걀........
		mat = new JLabel[3];
		mat[0] = new JLabel("밀가루+베이킹파우더 : " + flour);
		mat[1] = new JLabel("달걀+버터+우유 : " + egg);
		mat[2] = new JLabel("설탕+소금 : " + sugar);
		
		for(int i=0; i<3; i++){
			mat[i].setFont(new Font("배달의민족 주아", 40, 30));
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
		//쿠키
		if(e.getSource() == cookie){
			s += add;
			ss.setText("SCORE:" + s);
		}
		
		//오븐
		if(e.getSource() == oven && flour >= 1 && egg >= 1 && sugar >= 1){
			coo++;
			flour--;
			egg--;
			sugar--;
			mat[0].setText("밀가루+베이킹파우더 : " + flour);
			mat[1].setText("달걀+버터+우유 : " + egg);
			mat[2].setText("설탕+소금 : " + sugar);
			bake.setText("쿠키 : " + coo);
			JOptionPane.showMessageDialog(null, "쿠키 1개가 완성되었습니다!", "쿠키 생성", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == oven && (flour < 1 || egg < 1 || sugar < 1)){
			JOptionPane.showMessageDialog(null, "모든 재료가 1개 이상 있어야 쿠키를 구울 수 있습니다.", "재료 부족", JOptionPane.WARNING_MESSAGE);
		}
		
		//더하기
		if(e.getSource() == good[0] && s>=200){
			s -= 200;
			add++;
			good[0].setText("+" + add + " 증가(-200p)");
			ss.setText("SCORE:" + s);
			JOptionPane.showMessageDialog(null, "아이템 구매 완료!", "아이템 구매", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[0] && s<200){
			JOptionPane.showMessageDialog(null, "포인트가 부족합니다.", "포인트 부족", JOptionPane.WARNING_MESSAGE);
		}
		
		//밀가루+베이킹파우더
		if(e.getSource() == good[1] && s>=500){
			s -= 500;
			flour++;
			ss.setText("SCORE:" + s);
			mat[0].setText("밀가루+베이킹파우더 : " + flour);
			JOptionPane.showMessageDialog(null, "밀가루+베이킹파우더 구입 완료!", "구입 알림", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[1] && s<500){
			JOptionPane.showMessageDialog(null, "포인트가 부족합니다.", "포인트 부족", JOptionPane.WARNING_MESSAGE);
		}
		
		//달걀+버터+우유
		if(e.getSource() == good[2] && s>=300){
			s -= 300;
			egg++;
			ss.setText("SCORE:" + s);
			mat[1].setText("달걀+버터+우유 : " + egg);
			JOptionPane.showMessageDialog(null, "달걀+버터+우유 구입 완료!", "구입 알림", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[2] && s<300){
			JOptionPane.showMessageDialog(null, "포인트가 부족합니다.", "포인트 부족", JOptionPane.WARNING_MESSAGE);
		}
		
		//설탕+소금
		if(e.getSource() == good[3] && s>=100){
			s -= 100;
			sugar++;
			ss.setText("SCORE:" + s);
			mat[2].setText("설탕+소금 : " + sugar);
			JOptionPane.showMessageDialog(null, "설탕+소금 구입 완료!", "구입 알림", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == good[3] && s<100){
			JOptionPane.showMessageDialog(null, "포인트가 부족합니다.", "포인트 부족", JOptionPane.WARNING_MESSAGE);
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
	
	//단어 저장
	private String reversewords[] = {"doof", "eikooc", "elppa", "nep", "olleh", "traeh", "rats", "eseehc", "azzip", "nekcihc", "요세하녕안", "요세내보간시운거즐","요봐해도임게른다"};
	public B_reverseword(){
    	//프레임
		JFrame frame= new JFrame();
		frame.setTitle("로꾸꺼!!!!");
		//패널
		JPanel jp = new JPanel(null);
		frame.add(jp);
		jp.setBackground(new Color(255,235,205));
		
		//단어
		addWords();
		
		howto = new JLabel("거꾸로된 단어 및 문장을 원래대로 바꿔서 입력해보세요!");
		howto.setBounds(105, 40, 500, 50);
		howto.setFont(new Font("배달의민족 주아",40,15));
		jp.add(howto);
		//첫단어 넣기
		print = new JLabel(""+reversewords[k++]);
		print.setBounds(110,120,300,100);
		jp.add(print);
		print.setFont(new Font("배달의민족 주아", 40, 20));
		input = new JTextField(8);
		input.setBounds(290,120,100,50);
		jp.add(input);
		
		//확인버튼
		bt = new JButton("확인");
		bt.addActionListener(this);
		bt.setBounds(300, 200, 70, 30);
		bt.setFont(new Font("배달의민족 주아", 40, 15));
		bt.setFocusPainted(false);
		bt.setBackground(new Color(255,255,255));
		jp.add(bt);
		
		frame.setSize(600, 400);
		frame.setVisible(true);
    }
    //맞았을 경우에 다음단어 넣기
    public void la(){
		print.setText(""+reversewords[k++]);
	}
    //단어 words에 넣기
    public void addWords() {
    	words = new ArrayList<>();
    	for(int i=0; i<reversewords.length; i++){
    		words.add(i, reversewords[i]);
    	}
    }
    //이벤트
    @Override
	public void actionPerformed(ActionEvent e){
    	if(e.getSource() == bt){
    		in = input.getText();
    		String word = new StringBuffer(reversewords[k-1]).reverse().toString();
    		
        	if(in.equals(word)){
        		JOptionPane.showMessageDialog(null, "정답", "정답", JOptionPane.INFORMATION_MESSAGE);
        		try{
        			la();
        		}catch(ArrayIndexOutOfBoundsException error){
        			JOptionPane.showMessageDialog(null, "게임끝", "게임끝", JOptionPane.INFORMATION_MESSAGE);
        			System.exit(1);
        		}
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "실패", "실패", JOptionPane.INFORMATION_MESSAGE);
        	}
    	}
    }
}
    
class C_YunFrame extends JFrame implements ActionListener{
	
	int startnumber = 1;
	int setstart = 1;
	
	JButton[] C_Button = new JButton[9];
	JPanel jpanel = new JPanel(null);
	JLabel jlabel = new JLabel("게임방법 : 1부터 9까지 숫자를 순서대로 눌러주세요.");
	
	public C_YunFrame(){
		setSize(600,600);
		setTitle("원투뜨리");
		setVisible(true);
		add(jpanel);
		jpanel.add(jlabel);
		jlabel.setFont(new Font("배달의민족 주아",10,15));
		jlabel.setBounds(150, 30, 500, 50);
		jpanel.setBackground(new Color(255,235,205));
		
		
				
		JButton C_start = new JButton("start");
		jpanel.add(C_start);
		C_start.setBounds(240, 100, 100, 50);
		C_start.setFocusPainted(false);
		C_start.setBackground(new Color(240,240,240));
		C_start.addActionListener(this);
		C_start.setFont(new Font("배달의민족 주아",10,20));
		
		
		
		button();
	}
	//랜덤 숫자 만들기
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
	//버튼 만들기
	public void button(){
		int[] first = make();
		
		for(int j=0; j < C_Button.length; j++){
			C_Button[j] = new JButton(first[j]+"");
			jpanel.add(C_Button[j]);
			C_Button[j].setFocusPainted(false);
			C_Button[j].setBackground(new Color(240,240,240));
			C_Button[j].addActionListener(this);
			C_Button[j].setFont(new Font("배달의민족 주아",10,25));
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
	//버튼 숫자 변경
	public void differ(){
		int[] next = make();
		for(int i = 0; i<9;i++){
			C_Button[i].setText(next[i]+"");			
		}
	}
	//버튼 이벤트
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
	
	//게임 완료
	public void click(){
		startnumber++;
		if(startnumber==10){
			startnumber=1;
			JOptionPane.showMessageDialog(null, "다시 하고 싶으시면 start 버튼을 눌러주세요.", "성공!", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	
}
public class minigame implements ActionListener{
	private JButton A, B, C;
	private JPanel jp;
	
	JFrame frame;
	
	public minigame() {
		JFrame frame = new JFrame();
		frame.setTitle("미니게임천국!!");

		ImageIcon icon = new ImageIcon("back1.jpg");
		
		JPanel panel = new JPanel(null){
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		frame.add(panel);
		
		JLabel title = new JLabel("미니게임천국!!");
		title.setBounds(380, 80, 500, 100);
		title.setFont(new Font("배달의민족 주아", 40, 45));
		panel.add(title);
		
		A = new JButton("1. 쿠키클리커");
		A.setFont(new Font("배달의민족 주아", 40, 30));
		A.setBounds(390, 280, 220, 70);
		A.addActionListener(this);
		A.setFocusPainted(false);
		A.setBackground(new Color(255,255,255));
		panel.add(A);
		
		B = new JButton("2. 로꾸꺼!");
		B.setBounds(410, 400, 180, 70);
		B.setFont(new Font("배달의민족 주아", 40, 30));
		B.addActionListener(this);
		B.setFocusPainted(false);
		B.setBackground(new Color(255,255,255));
		panel.add(B);
		
		C = new JButton("3. 원투뜨리");
		C.setBounds(395, 520, 210, 70);
		C.setFont(new Font("배달의민족 주아", 40, 30));
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