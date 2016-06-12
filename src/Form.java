

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.*;

/**
 *  선, 원, 연필, 사각형, 지우개등 각 객체에 대한 정보를 가지고 있는 클래스
 *
 */

public class Form {
	
	private Vector<Point> point = new Vector<Point>();
	private Color color;

	/**
	 *   Form 생성자
	 */

	public Form() {}
	
	/**
	 *  현재 포인트를 저장한다
	 */
	
	public void addPoint(Point p) {
	point.add(p);
	}
	
	/**
	 *  현재 컬러를 설정한다
	 */
	
	public void setColor(Color c) {
		color = c;
	}
	/**
	 *  현재 컬러를 얻어온다
	 *  @return 설정된 색깔을 반환한다.
	 */

	public Color getColor() {
		return color;
	}
	
	/**
	 *  현재 포인트를 얻어온다
	 *  @return 현재 포인트를 반환한다.
	 */
	
	public Vector<Point> getPoint() {
		return point;
	}

	
	/**
	 *   현재 p1, p2 사이의 영역을 반환한다
	 *   @return 인자로 받아온 영역을 계산해 반환한다.   
	 */
	public Rectangle getRect(Point p1, Point p2) {
		Rectangle rect = null;

		int minX = Math.min(p1.x, p2.x);
		int maxX = Math.max(p1.x, p2.x);
		int minY = Math.min(p1.y, p2.y);
		int maxY = Math.max(p1.y, p2.y);

		rect = new Rectangle(minX, minY, maxX - minX, maxY - minY);

		return rect;
	}
	
}
