import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;


public class ImagePanel extends JPanel{
	ListPanel lp;
	JTextField tf;
	JButton play;
	JButton init;
	JTextField ff;
	JLabel label;
	String fileName = null;
	MovingImageFrame mis = null;
	public ImagePanel(){
		setPreferredSize(new Dimension(300,1200));
		setBackground(Color.gray);
		lp = new ListPanel();
		init = new JButton("초기화");
		tf = new JTextField(5);
		ff= new JTextField(10);
		label = new JLabel("파일이름");
		label.setForeground(Color.WHITE);
		JScrollPane scroll = new JScrollPane(lp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//scroll.setBounds(0, 20, 600, 600);
		scroll.setPreferredSize(new Dimension(300, 700));
		play = new JButton("실행 및 저장");
	
		add(tf);
		add(play);
		add(init);
		add(label);
		add(ff);
		add(scroll);
		



		play.addActionListener(new AL());
		ff.addKeyListener(new AL());
		init.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lp.removeAll();	
				lp.init();
				revalidate();
				repaint();
			}
		});
	}
	
	class AL extends KeyAdapter implements ActionListener {

		int speed;
		public void actionPerformed(ActionEvent e) {
			speed = Integer.parseInt(tf.getText());
			fileName=ff.getText();
			mis = new MovingImageFrame(speed,lp.iv, fileName);
			
		}
		

		

	}


}


class ListPanel extends JPanel{ 

	Vector<BufferedImage> iv;
	Vector<JPanel> pv = new Vector<JPanel>();
	ImageIcon temp; 
	int k = 0; 


	public ListPanel(){
		setLayout(new FlowLayout(FlowLayout.CENTER));
		iv = new Vector<BufferedImage>();
		setPreferredSize(new Dimension(250,5000));
		setBackground(new Color(200, 255, 255));

	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}

	void setBuffedImage(BufferedImage img){
		//System.out.println("hi");
		iv.add(img);

		//System.out.println(img.toString());

	}
	void drawImageByButton(){
		//System.out.println("zzzz");
		JPanel temp1 = new addImagePanel(iv.get(k));
		temp1.repaint();
		temp1.setBounds( 30, 20+(90*k)+(k*20), 190, 90);
		temp1.setPreferredSize(new Dimension(190, 90));
		pv.add(temp1);
		k++;
		add(temp1);
	}
	
	void init() {
		k=0;
		iv = new Vector<BufferedImage>();
		pv = new Vector<JPanel>(); 
	}
}
class addImagePanel extends JPanel{
	BufferedImage k;
	public addImagePanel(BufferedImage i){
		k = i;
		repaint();
	}
	public void paint(Graphics g){
		if(k !=null){
			System.out.println(getWidth());

			g.drawImage(k,0,0,getWidth(),getHeight(),0,0,820,840,this);
		}
	}

}
class MovingImageFrame extends JFrame{

	int speed;
	Move jp;
	BufferedImage fr;
	Vector<BufferedImage> v ;
	public MovingImageFrame(int s, Vector<BufferedImage> v, String fileName){
		this.v= v;
		jp = new Move();   
		Thread th = new Thread(jp);
		th.start();
		speed = s;
		add(jp);
		GifEncoder e = new GifEncoder();
		e.start("./result/" + fileName+ ".gif");
		e.setDelay(speed);   // 1 frame per sec
		e.setRepeat(Integer.MAX_VALUE);
		for(int i = 0 ; i < v.size(); i++){
			e.addFrame(v.get(i));
		}
		e.finish();
		setSize(600,600);
		setVisible(true);
		for(int i = 0; i< v.size(); i++){
			System.out.println(v.get(i));
		}
	}
	
	public void init() {
		v = new Vector<BufferedImage>();
	}

	class Move extends JPanel implements Runnable{
		public void run() {
			// TODO Auto-generated method stub
			int i = 0;
			while(true){

				if(i == v.size())
					i = 0;
				try{                
					int t = speed;
					//System.out.println(t);
					Thread.sleep(t);
				}catch(InterruptedException e){return;}      
				fr = v.get(i);
				repaint();
				i++;
				//System.out.println(fr.toString());
				// System.out.println("asdf");
			}         
		}   
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			System.out.println("zzz");
			if(fr != null){
				g.drawImage(fr,0,0, getWidth(), getHeight(), this);
			}
		}
	}
}


