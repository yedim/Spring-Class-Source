package exam.springjdbc;

public class Singer {
	private String name;//db에 속성과 같게
	private int member;
	
	public Singer()
	{
		
	}

	public Singer(String name, int member) {
		super();
		this.name = name;
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Singer [name=" + name + ", member=" + member + "]";
	}
	
}
