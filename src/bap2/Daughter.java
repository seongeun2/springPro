package bap2;


public class Daughter implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("�쁽誘몃�? �떕�뼱 �떕�뼱===> �궃 ��諛� ?��?���? ");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("�뵺�쓽 移쒓?��"+friend+"�엯�땲�떎");
	}
}
