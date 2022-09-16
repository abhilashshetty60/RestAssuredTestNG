package Utils;

public enum Statuscode {

	CODE_200(200, "Successful"),
	CODE_201(201, ""),
	CODE_401(401, "null values"),
	CODE_400(400, ""),
	CODE_404(404, "Invalid"),
	CODE_500(500, "Internal server error");

	public final int code;
	public final String msg;
	
	Statuscode(int code, String msg) {
		this.code=code;
		this.msg=msg;
	}
}
