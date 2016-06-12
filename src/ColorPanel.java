
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


/**
 *  아래쪽에 색깔을 설정하는 패널
 *
 */

public class ColorPanel extends JPanel implements ActionListener, MouseListener
{
	
	JToggleButton black, white, blue, Brown, Gold, gray, gray2, Green, Lime, Orange, Pink, Red, Red2, Sky, violet, Wine, Yellow, Yellow2;
    JPanel selectColor;
    /**
     *  ColorPanel 생성자, 여러 색깔 버튼들을 생성에 패널에 추가
     */
	public ColorPanel(){
		setBackground(new Color(200, 255, 255)); //패널색 설정
		setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5)); //플로우레이아웃 왼쪽정렬 사이즈 15,5
        setPreferredSize(new Dimension(140,500)); //사이즈 설정
        setBorder(BorderFactory.createRaisedBevelBorder()); // 테두리 설정
        Dimension IconSize = new Dimension(50,50); // 아이콘사이즈 설정
              
        JPanel nowColor = new JPanel();    //현재 선택된 색이 보이는 패널
     	nowColor.setBorder(BorderFactory.createRaisedBevelBorder());
     	nowColor.setPreferredSize(new Dimension(100,100));
     	selectColor = new JPanel();
	 	selectColor.setBorder(BorderFactory.createLoweredBevelBorder());	// 테두리 설정
	 	selectColor.setBackground(Color.black);
   	 	selectColor.setToolTipText("선택된 색상");
   	 	selectColor.setPreferredSize(new Dimension(100, 70));	
   	 	
   	    //고급설정 클릭시 색다이얼로그 나타나서 정교하게 설정가능
   	    JPanel nowcolortextPanel = new JPanel();
   	    
   	    nowcolortextPanel.add(new JLabel("고급 설정"));
   	    nowColor.setLayout(new BorderLayout());
     	nowColor.add(nowcolortextPanel, BorderLayout.CENTER);        
     	nowColor.add(selectColor, BorderLayout.NORTH);
     	nowColor.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양커서
     	nowColor.addMouseListener(this);
     	add(nowColor);
     	//기본색깔 나오는 패널 설정
     	JPanel Color = new JPanel();
     	
     	Color.setLayout(new GridLayout(9,2));
     	Color.setBorder(BorderFactory.createRaisedBevelBorder()); // 테두리 설정
     	Color.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양커서
     	add(Color);
     	
     	//색깔버튼에 이미지와 툴팁 사이즈 액션 설정
     	black = new JToggleButton(("검정"),new ImageIcon("Color/Black.jpg"));
        black.setToolTipText("검정");
        black.setPreferredSize(IconSize);
        black.addActionListener(this);
     	Color.add(black);
     	
     	white = new JToggleButton(("흰색"), new ImageIcon("Color/White.jpg"));
     	white.setToolTipText("흰색");
     	white.setPreferredSize(IconSize);
     	white.addActionListener(this);
     	Color.add(white);
        
        blue = new JToggleButton(("옥색"),new ImageIcon("Color/Blue.jpg"));
        blue.setToolTipText("옥색");
        blue.setPreferredSize(IconSize);
        blue.addActionListener(this);
        Color.add(blue);
        
        
        Brown = new JToggleButton(("브라운"),new ImageIcon("Color/Brown.jpg"));
        Brown.setToolTipText("브라운");
        Brown.setPreferredSize(IconSize);
        Brown.addActionListener(this);
        Color.add(Brown);
        
        Gold = new JToggleButton(("황금색"),new ImageIcon("Color/Gold.jpg"));
        Gold.setToolTipText("황금색");
        Gold.setPreferredSize(IconSize);
        Gold.addActionListener(this);
        Color.add(Gold);
        
        gray = new JToggleButton(("진한회색"),new ImageIcon("Color/gray.jpg"));
        gray.setToolTipText("진한회색");
        gray.setPreferredSize(IconSize);
        gray.addActionListener(this);
        Color.add(gray);
        
        gray2 = new JToggleButton(("연한회색"),new ImageIcon("Color/gray2.jpg"));
        gray2.setToolTipText("연한회색");
        gray2.setPreferredSize(IconSize);
        gray2.addActionListener(this);
        Color.add(gray2);
        
        Green = new JToggleButton(("녹색"),new ImageIcon("Color/Green.jpg"));
        Green.setToolTipText("녹색");
        Green.setPreferredSize(IconSize);
        Green.addActionListener(this);
        Color.add(Green);
        
        
        Lime = new JToggleButton(("라임"),new ImageIcon("Color/Lime.jpg"));
        Lime.setToolTipText("라임");
        Lime.setPreferredSize(IconSize);
        Lime.addActionListener(this);
        Color.add(Lime);
        
        
        Orange = new JToggleButton(("주황"),new ImageIcon("Color/Orange.jpg"));
        Orange.setToolTipText("주황");
        Orange.setPreferredSize(IconSize);
        Orange.addActionListener(this);
        Color.add(Orange);
        
        Pink = new JToggleButton(("핑크색"),new ImageIcon("Color/Pink.jpg"));
        Pink.setToolTipText("핑크색");
        Pink.setPreferredSize(IconSize);
        Pink.addActionListener(this);
        Color.add(Pink);
        
        
        Red = new JToggleButton(("빨강"),new ImageIcon("Color/Red.jpg"));
        Red.setToolTipText("빨강");
        Red.setPreferredSize(IconSize);
        Red.addActionListener(this);
        Color.add(Red);
        
        Red2 = new JToggleButton(("진한빨강"),new ImageIcon("Color/Red2.jpg"));
        Red2.setToolTipText("진한빨강");
        Red2.setPreferredSize(IconSize);
        Red2.addActionListener(this);
        Color.add(Red2);
        
        Sky = new JToggleButton(("하늘색"),new ImageIcon("Color/Sky.jpg"));
        Sky.setToolTipText("하늘색");
        Sky.setPreferredSize(IconSize);
        Sky.addActionListener(this);
        Color.add(Sky);
        
        
        violet = new JToggleButton(("연한보라"),new ImageIcon("Color/violet.jpg"));
        violet.setToolTipText("연한보라");
        violet.setPreferredSize(IconSize);
        violet.addActionListener(this);
        Color.add(violet);
        
        Wine = new JToggleButton(("자주"),new ImageIcon("Color/Wine.jpg"));
     	Wine.setToolTipText("자주");
        Wine.setPreferredSize(IconSize);
        Wine.addActionListener(this);
        Color.add(Wine);
        
        
        Yellow = new JToggleButton(("노랑"),new ImageIcon("Color/Yellow.jpg"));
        Yellow.setToolTipText("노랑");
        Yellow.setPreferredSize(IconSize);
        Yellow.addActionListener(this);
        Color.add(Yellow);
        
        Yellow2 = new JToggleButton(("연한노랑"),new ImageIcon("Color/Yellow2.jpg"));
        Yellow2.setToolTipText("연한노랑");
        Yellow2.setPreferredSize(IconSize);
        Yellow2.addActionListener(this);
        Color.add(Yellow2);
       
	}
	
	 /**
     *  버튼이 눌렸을때마다 발생하는 이벤트를 설정 
     */

	public void actionPerformed(ActionEvent e) { 
    // 버튼이 눌리면 현재색나오는 패널변경 변경하고 색설정
		String col = (String)e.getActionCommand(); 
		Color c;
		if (col.equals("검정")) {
			selectColor.setBackground(Color.black);
			ProjectFrame.color=Color.black;
			
			}
		else if (col.equals("흰색")) {
			selectColor.setBackground(Color.white);
			ProjectFrame.color=Color.white;
			}
		else if (col.equals("옥색")) {
			selectColor.setBackground(new Color(0,162,232));
			ProjectFrame.color=new Color(0,162,232);
		}
		else if (col.equals("브라운")) {
			selectColor.setBackground(new Color(185,122,87));
			ProjectFrame.color=new Color(185,122,87);
		}
		else if (col.equals("하늘색")) {
			selectColor.setBackground(new Color(128,255,255));
			ProjectFrame.color=new Color(128,255,255);
		}
		else if (col.equals("녹색")) {
			selectColor.setBackground(new Color(34,177,76));
			ProjectFrame.color=new Color(34,177,76);
		}
		else if (col.equals("라임")) {
			selectColor.setBackground(new Color(181,230,29));
			ProjectFrame.color=new Color(181,230,29);
		}
		else if (col.equals("주황")) {
			selectColor.setBackground(new Color(255,127,39));
			ProjectFrame.color=new Color(255,127,39);
		}
		else if (col.equals("핑크색")) {
			selectColor.setBackground(new Color(255,174,201));
			ProjectFrame.color=new Color(255,174,201);
		}
		else if (col.equals("빨강")) {
			selectColor.setBackground(new Color(237,28,36));
			ProjectFrame.color=new Color(237,28,36);
		}
		else if (col.equals("진한빨강")) {
			selectColor.setBackground(new Color(136,0,21));
			ProjectFrame.color= new Color(136,0,21);
		}	
		else if (col.equals("노랑")) {
			selectColor.setBackground(new Color(255,242,0));
			ProjectFrame.color=new Color(255,242,0);
		}
		else if (col.equals("연한노랑")) {
			selectColor.setBackground(new Color(239,228,176));
			ProjectFrame.color=new Color(239,228,176);
		}
		else if (col.equals("황금색")) {
			selectColor.setBackground(new Color(255,201,14));
			ProjectFrame.color=new Color(255,201,14);
		}
		else if (col.equals("연한보라")) {
			selectColor.setBackground(new Color(200,191,231));
			ProjectFrame.color=new Color(200,191,231);
		}
		else if (col.equals("자주")) {
			selectColor.setBackground(new Color(163,73,164));
			ProjectFrame.color=new Color(163,73,164);
		}
		else if (col.equals("진한회색")) {
			selectColor.setBackground(new Color(127,127,127));
			ProjectFrame.color=new Color(127,127,127);
		}
		else if (col.equals("연한회색")) {
			selectColor.setBackground(new Color(195,195,195));
			ProjectFrame.color=new Color(195,195,195);
		}
				
	}
	
	 /**
     *  마우스 클릭스 고급색 설정 이벤트 발생 색버튼 외에 정교하게 색 설정 가능 
     */
	public void mouseClicked(MouseEvent e) {
		JColorChooser chooser = new JColorChooser();
		Color selectedColor = chooser.showDialog(null,"Color",selectColor.getBackground());
		if(selectedColor != null)
		{
			selectColor.setBackground(selectedColor);
			ProjectFrame.color=selectedColor;
		}
	}
	/**
	 * 미사용 구현 메소드
	 */
	public void mousePressed(MouseEvent e) {}
	/**
	 * 미사용 구현 메소드
	 */
	public void mouseReleased(MouseEvent e) {}
	/**
	 * 미사용 구현 메소드
	 */
	public void mouseEntered(MouseEvent e) {}
	/**
	 * 미사용 구현 메소드
	 */
	public void mouseExited(MouseEvent e) {	}
	

}