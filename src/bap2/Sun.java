package bap2;


public class Sun implements Person{
	private String friend;
	
	public void bap() {
		System.out.println("�쁽誘몃�? �떕�뼱 �떕�뼱===> �궃 ?��?��?�� ?��?���?");
	}
	public void setFriend(String friend) {
		this.friend=friend;
	}
	public void getFriend() {
		System.out.println("�븘�뱾�쓽 移쒓?��"+friend+"�엯�땲�떎");
	}
}
