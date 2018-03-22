package bap2;


public class Sun implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("ï¿½ì½èª˜ëªƒê°? ï¿½ë–•ï¿½ë¼± ï¿½ë–•ï¿½ë¼±===> ï¿½ê¶ƒ ?®?“­?”  ?†«?—­ë¸?");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("ï¿½ë¸˜ï¿½ë±¾ï¿½ì“½ ç§»ì’“?„"+friend+"ï¿½ì—¯ï¿½ë•²ï¿½ë–");
	}
}
