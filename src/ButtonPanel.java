
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *  왼쪽 버튼을 나타내는 패널
 *
 */

public class ButtonPanel extends JPanel implements ActionListener, ChangeListener
{
	protected DrawPanel dp;
	private JToggleButton line, rect, eclipse, eraser, pencil, select, cut, paste, copy, roundrect, zolaman,house,tree;
	private JButton[] moveBt;
	private ButtonGroup bg = new ButtonGroup();
	private JSlider sliP,sliE;

	/**
	 *  ButtonPanel 생성자, 버튼은 토글버튼으로 만듬
	 *  토글버튼으로 눌르면 들어가고 다른버튼을 누르면 다시 나옴
	 */
	public ButtonPanel(final DrawPanel dp){
		
		setBackground(new Color(200, 255, 255));  //패널색 설정
		setBorder(BorderFactory.createRaisedBevelBorder()); // 테두리 설정
		setLayout(new FlowLayout());
		//Dimension IconSize = new Dimension(40,50); // 사이즈설정
		this.dp=dp;
		JPanel leftPanel = new JPanel(new GridLayout(2,1));
		JPanel rightPanel= new JPanel();

		JPanel shapeTool = new JPanel();
		JPanel moveTool = new JPanel();
		JPanel drawTool = new JPanel(new GridLayout(2,1));
		JPanel penP = new JPanel(new FlowLayout());
		JPanel eraP = new JPanel(new FlowLayout());
		JPanel editTool = new JPanel(new GridLayout(2,2,5,5));
		JPanel colorP = new JPanel(new BorderLayout());
		leftPanel.setBackground(new Color(200, 255, 255));
		rightPanel.setBackground(new Color(200, 255, 255));
		moveTool.setBackground(new Color(200, 255, 255));
		drawTool.setBackground(new Color(200, 255, 255));
		penP.setBackground(new Color(200, 255, 255));
		eraP.setBackground(new Color(200, 255, 255));

		JColorChooser chooser = new JColorChooser();



		drawTool.add(penP);
		drawTool.add(eraP);
		leftPanel.add(shapeTool);
		leftPanel.add(moveTool);
		add(leftPanel);
		add(rightPanel);
		add(editTool);
		add(drawTool);
		add(colorP);
		JCheckBox fillmode = new JCheckBox("채우기");  //체크박스 체크되면 도형 그릴때 채워서 그려짐 익명클래스로 설정
		fillmode.setBackground(new Color(200, 255, 255));
		fillmode.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					dp.fillMode=1; //fillmode1이면 채워서 그림
				}
				else
					dp.fillMode=0;

			}
		});


		shapeTool.setLayout(new GridLayout(1,8));    //도구버튼 그리드레이아웃 설정
		shapeTool.setCursor(new Cursor(Cursor.HAND_CURSOR)); //패널진입시 손모양 마우스로 커서변경 
		moveTool.setCursor(new Cursor(Cursor.HAND_CURSOR));
		drawTool.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// 토글버튼들 사진, 툴팁, 사이즈, 선택되었을때 들어가는것처럼 보이기 위해 작은사진 한개 더 넣음


		pencil = new JToggleButton(new ImageIcon("image/Pencil.png"));
		pencil.setToolTipText("연필");
		pencil.addActionListener(this);
		pencil.setSelected(true); //연필버튼 처음부터 선택되있음
		pencil.setBackground(Color.WHITE);

		eraser = new JToggleButton(new ImageIcon("image/Eraser.png"));
		eraser.setToolTipText("지우개");
		eraser.addActionListener(this);
		eraser.setBackground(Color.WHITE);

		line = new JToggleButton(new ImageIcon("image/line.png"));
		line.setToolTipText("선그리기");
		line.addActionListener(this);
		line.setBackground(Color.WHITE);


		rect = new JToggleButton(new ImageIcon("image/rect.png"));
		rect.setToolTipText("사각형그리기");
		rect.addActionListener(this);
		rect.setBackground(Color.WHITE);

		roundrect = new JToggleButton(new ImageIcon("image/RoundRect.jpg"));
		roundrect.setToolTipText("둥근사각형");
		roundrect.addActionListener(this);
		roundrect.setBackground(Color.WHITE);

		eclipse = new JToggleButton(new ImageIcon("image/circle.png"));
		eclipse.setToolTipText("원그리기");
		eclipse.addActionListener(this);	
		eclipse.setBackground(Color.WHITE);

		zolaman = new JToggleButton(new ImageIcon("image/zolaman.png"));
		zolaman.setToolTipText("졸라맨그리기");
		zolaman.addActionListener(this);	
		zolaman.setBackground(Color.WHITE);

		house = new JToggleButton(new ImageIcon("image/house.png"));
		house.setToolTipText("집그리기");
		house.addActionListener(this);	
		house.setBackground(Color.WHITE);

		tree = new JToggleButton(new ImageIcon("image/tree.png"));
		tree.setToolTipText("나무그리기");
		tree.addActionListener(this);	
		tree.setBackground(Color.WHITE);


		select = new JToggleButton(new ImageIcon("image/Select.jpg"));
		select.setToolTipText("선택하기");
		select.addActionListener(this);
		select.setBackground(Color.WHITE);

		cut = new JToggleButton(new ImageIcon("image/Cut.png"));
		cut.setToolTipText("잘라내기");
		cut.addActionListener(this);
		cut.setBackground(Color.WHITE);


		copy = new JToggleButton(new ImageIcon("image/Copy.png"));
		copy.setToolTipText("복사하기");
		copy.addActionListener(this);
		copy.setBackground(Color.WHITE);

		paste = new JToggleButton(new ImageIcon("image/Paste.png"));
		paste.setToolTipText("붙여넣기");
		paste.addActionListener(this);
		paste.setBackground(Color.WHITE);

		sliP = new JSlider();
		sliE = new JSlider();
		
		sliE.addChangeListener(this);
		sliP.addChangeListener(this);

		moveBt = new JButton[8];
		String[] btName = {"up","right","down","left","up-r","up-l","down-r","down-l"};
		for(int i = 0 ; i < 8 ; i++){
			moveBt[i] = new JButton(new ImageIcon("image/"+btName[i]+".png"));
			moveBt[i].setBackground(Color.WHITE);
			moveBt[i].setPreferredSize(new Dimension(70, 50));
			moveBt[i].addActionListener(this);
			moveTool.add(moveBt[i]);
		}
		moveTool.add(fillmode);
		bg.add(pencil);
		bg.add(eraser);
		bg.add(line);
		bg.add(eclipse);
		bg.add(rect);
		bg.add(roundrect);
		bg.add(select);
		bg.add(cut);
		bg.add(copy);
		bg.add(paste);
		bg.add(zolaman);
		bg.add(house);
		bg.add(tree);


		penP.add(pencil);
		penP.add(sliP);
		eraP.add(eraser);
		eraP.add(sliE);

		shapeTool.add(line);
		shapeTool.add(eclipse);
		shapeTool.add(rect);
		shapeTool.add(roundrect);
		shapeTool.add(zolaman);
		shapeTool.add(house);
		shapeTool.add(tree);
		editTool.add(select);
		editTool.add(cut);
		editTool.add(copy);
		editTool.add(paste);




	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	

		if(e.getSource()==sliE){
			dp.eraserSize = sliE.getValue();

		}
		else{
			dp.pencilSize = sliP.getValue();
		}
		
	}
	/**
	 *  버튼이 눌렸을때마다 발생하는 이벤트를 설정하는 메소드
	 *  선택버튼의 경우 잘라내기, 복사, 붙여넣기에 한에서 선택버튼 개속 유지되도록 설정함
	 */

	public void actionPerformed(ActionEvent e){
		if (e.getSource().getClass().getName().equals("javax.swing.JToggleButton")) {
			JToggleButton tAction =(JToggleButton)e.getSource();
			if(tAction==eraser)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.ERASER);
			}
			else if(tAction==line)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.LINE);
			}			
			else if(tAction==rect)
			{
				dp.select=0;	
				dp.setDrawMode(DrawPanel.RECT);
			}
			else if(tAction==eclipse)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.ECLIPSE);
			}
			else if(tAction==pencil)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.PEN);
			}
			else if(tAction==roundrect)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.ROUNDRECT);
			}
			else if(tAction==zolaman)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.ZOLAMAN);
			}
			else if(tAction==house)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.HOUSE);
			}
			else if(tAction==tree)
			{
				dp.select=0;
				dp.setDrawMode(DrawPanel.TREE);
			}
			else if(tAction==select)
			{
				dp.select=1;
			}
			else if(tAction==cut)
			{
				dp.cut();
			}
			else if(tAction==copy)
			{
				dp.copy();
			}
			else if(tAction==paste)
			{			
				dp.paste();
			}
		}

		if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
			JButton bAction =(JButton)e.getSource();
			for (int i = 0; i < moveBt.length; i++) {
				if(bAction==moveBt[i])
				{			
					dp.moveRegion(i);
				}		
			}
		}

	}



}