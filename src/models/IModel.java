package models;

import java.awt.Point;

public interface IModel {
	public void setPoint(int x, int y);

	public void setSprite();

	public Point getPoint();

	public Sprite getSprite();
}