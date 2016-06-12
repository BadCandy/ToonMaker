
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  ProjectFrame 전체 그림판의 프레임을 나타내는 클래스
 */

public class ProjectFrame extends JFrame implements ActionListener {
	private JMenuItem New, Open, SaveAs, Exit, Select, Copy, Paste, Line, Rectangle, Eclipse, Cut, By, Eraser, Pen, RoundRect, Brush;//
 	private JMenu File, Edit, Shape, Help;
 	private DrawPanel dp;
 	private ColorPanel cp;
 	private ButtonPanel bp;
 	private ImagePanel ip;
 	
 	
 	 /**
     *  현재 설정된 컬러 
     */
 	public static Color color = Color.black; 
 	 /**
     *  기본설정된 파일이름 
     */
 	public static String filename;
    
    /**
     *  ProjectFrame 생성자 
     */
 	   
	public ProjectFrame(String title) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	//패널을 프레임에 삽입하고 레이아웃설정	
		
		filename="제목 없음.jpg"; 
		ip = new ImagePanel();
		dp = new DrawPanel(filename,ip);
		cp = new ColorPanel();
		bp = new ButtonPanel(dp);
		createMenu(); //메뉴추가
		
		add(dp, BorderLayout.CENTER);
		add(cp, BorderLayout.WEST);
		add(bp, BorderLayout.NORTH);
		add(ip, BorderLayout.EAST);
		setTitle(filename+" - "+"아무개"); //초기파일이름 설정
		setSize(1200,1000); //사이즈 설정
		setLocation(200, 60); //기본 위치설정
		setResizable(false);// 사이즈변경 불가
		setVisible(true);
		
	}
	

	
	
	 /**
     *  프레임의 메뉴를 설정하는 메소드
     */
	public void createMenu(){
		
		JMenuBar menuBar= new JMenuBar();
		//모든메뉴의 단축키, 이미지, 이벤트 설정
		File = new JMenu("File(F)");
		File.setMnemonic('f');
		New = new JMenuItem("새로 만들기(N)", new ImageIcon("image/New.jpg"));
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
   	    New.addActionListener(this);		
		Open = new JMenuItem("열기(O)", new ImageIcon("image/Open.jpg"));
		Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		Open.addActionListener(this);
	
	    SaveAs = new JMenuItem("저장(S)", new ImageIcon("image/Save.jpg"));
	    SaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		SaveAs.addActionListener(this);
		Exit = new JMenuItem("종료", new ImageIcon("image/Exit.jpg"));
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
	    Exit.addActionListener(this);
					
	    File.add(New);
	    File.add(Open);
	    File.add(SaveAs);
		File.addSeparator();
		File.add(Exit);  //파일메뉴 추가
		
		Edit = new JMenu("Edit(E)");
		Edit.setMnemonic('e');
		
		Select = new JMenuItem("선택하기(T)", new ImageIcon("image/Select2.jpg"));
		Select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		Select.addActionListener(this);		
		Edit.add(Select);
		
		Cut = new JMenuItem("잘라내기(X)", new ImageIcon("image/Cut2.jpg"));
		Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		Cut.addActionListener(this);		
		Edit.add(Cut);
		
		Copy = new JMenuItem("복사하기(C)", new ImageIcon("image/Copy2.jpg"));
		Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		Copy.addActionListener(this);		
		Edit.add(Copy);
		
		Paste = new JMenuItem("붙여넣기(V)", new ImageIcon("image/Paste2.jpg"));
		Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		Paste.addActionListener(this);		
		Edit.add(Paste); //에딧메뉴 추가
				
		Shape = new JMenu("Shape(S)");
		Shape.setMnemonic('s');
				
		Pen = new JMenuItem("연필(P)", new ImageIcon("image/Pencil2.jpg"));
		Pen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		Pen.addActionListener(this);		
		Shape.add(Pen);
		
		Brush = new JMenuItem("색칠하기(B)", new ImageIcon("image/Brush2.jpg"));
		Brush.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		Brush.addActionListener(this);		
		Shape.add(Brush);
		
		Line = new JMenuItem("선그리기(L)", new ImageIcon("image/Line2.jpg"));
		Line.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		Line.addActionListener(this);		
		Shape.add(Line);
		
		
		Rectangle = new JMenuItem("사각형(R)", new ImageIcon("image/Rect2.jpg"));
		Rectangle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		Rectangle.addActionListener(this);	
		Shape.add(Rectangle);
		
		RoundRect = new JMenuItem("둥근사각형(O)", new ImageIcon("image/RoundRect2.jpg"));
		RoundRect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.ALT_MASK));
		RoundRect.addActionListener(this);	
		Shape.add(RoundRect);
		
		Eclipse = new JMenuItem("원그리기(C)", new ImageIcon("image/Oval2.jpg"));
		Eclipse.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		Eclipse.addActionListener(this);	
		Shape.add(Eclipse);
		
		Eraser = new JMenuItem("지우개(A)", new ImageIcon("image/Eraser2.jpg"));
		Eraser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		Eraser.addActionListener(this);		
		Shape.add(Eraser);  //Shape메뉴 추가
		
		Help = new JMenu("Help(H)");
		Help.setMnemonic('h');
		
		By = new JMenuItem("만든이..");
		By.addActionListener(this);	
		Help.add(By); //help메뉴 추가
					
		menuBar.add(File);
		//menuBar.add(Edit);
		//menuBar.add(Shape);
		menuBar.add(Help);
		setJMenuBar(menuBar);
		}
	
	
	/**
	 *  프레임의 메뉴가 선택되었을때 발생하는 이벤트가 나타나는 메소드
	 */
	public void actionPerformed(ActionEvent e) {
		String col = (String)e.getActionCommand(); //발생한 이벤트 메뉴 반환
		if (col.equals("새로 만들기(N)")) {
			JLabel msg = new JLabel();
			msg.setText("현재 내용을 저장하겠습니까?");
			if (JOptionPane.showConfirmDialog(null, msg, "확인",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) != JOptionPane.YES_OPTION) {
				    filename=dp.creation();      // 새로만들고 파일이름 변경
				    setTitle(filename+" - "+"아무개");
			}
			else {
				
				dp.reNameSave(); //저장하고 새로만듬
				dp.creation();
			}
		}

		else if(col.equals("열기(O)")){    //파일불러오고 파일이름 변경
			JLabel msg = new JLabel();       
			msg.setText("현재 내용을 저장하겠습니까?");
			if (JOptionPane.showConfirmDialog(null, msg, "확인",	JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				dp.reNameSave(); //저장
				filename=dp.open();
				setTitle(filename+" - "+"아무개"); //프레임타이틀 변경
				}
			else{
				filename=dp.open();
				setTitle(filename+" - "+"아무개");
				}
			}
				
		
		else if(col.equals("저장(S)")){  // 저장
			dp.reNameSave();
			setTitle(filename+" - "+"아무개");
		}
		else if(col.equals("종료")){  //종료
			JLabel msg = new JLabel();
			msg.setText("종료 하시겠습니까?");

			if (JOptionPane.showConfirmDialog(null, msg, "확인",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) != JOptionPane.YES_OPTION)
				return;

			System.exit(0); //확인시 종료
		} //메뉴선택시 해당기능 설정수행  select 1이면 선택모드. setDrawMode에 설정된 값에따라 설정후 기능 수행
		else if(col.equals("선택하기(T)")){
			dp.select=1;
			
		}
		else if(col.equals("복사하기(C)")){
			
			dp.copy();
		}
		else if(col.equals("잘라내기(X)")){
			
			dp.cut();
		}
		else if(col.equals("붙여넣기(V)")){
			
			dp.paste();
		}
		else if(col.equals("선그리기(L)")){
			dp.select=0;
			dp.setDrawMode(DrawPanel.LINE);
		}
		else if(col.equals("사각형(R)")){
			dp.select=0;
			dp.setDrawMode(DrawPanel.RECT);
		}
		else if(col.equals("둥근사각형(O)")){
			dp.select=0;
			dp.setDrawMode(DrawPanel.ROUNDRECT);
		}
		else if(col.equals("원그리기(C)")){
			dp.select=0;
			dp.setDrawMode(DrawPanel.ECLIPSE);
		}
		else if(col.equals("연필(P)")){
			dp.select=0;
			dp.setDrawMode(DrawPanel.PEN);
		}
		else if(col.equals("지우개(A)")){
			dp.select=0;
			dp.setDrawMode(DrawPanel.ERASER);
		}
		else if(col.equals("색칠하기(B)")){
			dp.select=0;
			dp.setDrawMode(DrawPanel.BRUSH);
		}
		else if(col.equals("만든이..")){
			JOptionPane.showMessageDialog(this, "흔남흔녀조 \nWrite By \n정윤철 \n범민규 \n김국진 \n김현준 \n이유진 ", "전남대학교", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 *  프레임의 메인 메소드
	 */

	public static void main(String args[]) {
		new ProjectFrame("그림판");

	}
}
	
			
			
	
