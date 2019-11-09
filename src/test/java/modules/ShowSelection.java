package modules;


public class ShowSelection{
	public static String show_selection(String selection) {
		return selection.contentEquals("select") ? "shows_me" : "doesn't_show_me";
	}
}