package bap;


public class Daughter implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("�쁽誘몃갈 �떕�뼱 �떕�뼱===> �궃 ��諛� 醫뗭븘 ");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("�뵺�쓽 移쒓뎄"+friend+"�엯�땲�떎");
	}
}
