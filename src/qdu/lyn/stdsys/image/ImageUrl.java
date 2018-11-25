package qdu.lyn.stdsys.image;

import java.net.URL;

public class ImageUrl {
	//通用图标

	public static final URL LOGIN_BACKGROUND = getResource("/img/bg/loginbg.png");

	public static URL getResource(String filename) {
		return ImageUrl.class.getResource(filename);
	}
}
