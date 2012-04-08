package views;

import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

public class IntroView implements IView {

	public class TestTexture {
		public int w;
		public int h;
		public BufferedImage img;

	}

	GLU glu = new GLU();
	BufferedImage buffImg;
	TestTexture t;

	public IntroView() throws IOException {
		t = new TestTexture();

		File fis = new File("resources/vehicle01.png");
		t.img = ImageIO.read(fis);
		Logger.getLogger("IntroView").log(Level.INFO, "", +t.img.getHeight());
		t.w = t.img.getWidth();
		t.h = t.img.getHeight();

		// ResourceManager.loadTexture("vehicle01.png");

	}

	private void setup(GL gl) {

		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0, 300, 300, 0, 0, 1);
		gl.glMatrixMode(GL.GL_MODELVIEW);

		WritableRaster raster = Raster.createInterleavedRaster(
				DataBuffer.TYPE_BYTE, t.w, t.h, 4, null);
		ComponentColorModel colorModel = new ComponentColorModel(ColorSpace
				.getInstance(ColorSpace.CS_sRGB), new int[] { 8, 8, 8, 8 },
				true, false, ComponentColorModel.TRANSLUCENT,
				DataBuffer.TYPE_BYTE);
		BufferedImage img = new BufferedImage(colorModel, raster, false, null);
		Graphics2D g = img.createGraphics();
		g.drawImage(img, null, null);
		DataBufferByte imgBuf = (DataBufferByte) raster.getDataBuffer();
		byte[] imgRGBA = imgBuf.getData();
		ByteBuffer bb = ByteBuffer.wrap(imgRGBA);

		bb.position(0);
		bb.mark();
		gl.glBindTexture(GL.GL_TEXTURE_2D, 13); // 13??
		gl.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);

		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);

		// gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER,
		// GL.GL_);

		int left = 100;
		int top = 100;
		gl.glEnable(GL.GL_TEXTURE_2D);
		gl.glBindTexture(GL.GL_TEXTURE_2D, 13);

		gl.glBegin(GL.GL_POLYGON);

		gl.glTexCoord2d(0, 0);
		gl.glVertex2d(left, top);

		gl.glTexCoord2d(0, 0);
		gl.glVertex2d(left + t.w, top);

		gl.glTexCoord2d(0, 0);
		gl.glVertex2d(left + t.w, top + t.h);

		gl.glTexCoord2d(0, 0);
		gl.glVertex2d(left, top + t.h);

		gl.glEnd();
		gl.glFlush();

	}

	private void cleanup(GL gl) {

	}

	@Override
	public void draw(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL gl = drawable.getGL();
		setup(gl);
		/*
		 * gl.glVertex2d(0, 0); gl.glColor3f(1.0f, 0.0f, 0.0f);
		 * gl.glBegin(GL.GL_QUADS); gl.glVertex2d(0, 0); gl.glVertex2d(1, 0);
		 * gl.glVertex2d(1, 1); gl.glVertex2d(0, 1); gl.glEnd();
		 */

	}

}
