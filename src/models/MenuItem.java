package models;

import java.awt.Point;

public class MenuItem implements IModel {
	private final Point point;
	private Sprite sprite;

	public MenuItem() {
		this.point = new Point(0, 0);
	}

	public MenuItem(Point point) {
		this.point = point;
	}

	@Override
	public Point getPoint() {
		return point;
	}

	@Override
	public void setPoint(int x, int y) {
		this.point.x = x;
		this.point.y = x;
	}

	@Override
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	@Override
	public void getSprite() {
		return sprite;
	}
}
