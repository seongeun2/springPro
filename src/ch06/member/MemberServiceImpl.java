package ch06.member;

public class MemberServiceImpl implements MemberService{

	@Override
	public void regist(MemberRegRequest memberRegReq) {
		System.out.println("MemberServiceImpl.regist() ȣ���");
	}

	@Override
	public boolean update(String id, UpdateInfo updateInfo) {
		System.out.println("MemberServiceImpl.update() ȣ���");
		return true;
	}
	

}
