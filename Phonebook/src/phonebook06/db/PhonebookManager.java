package phonebook06.db;

import java.io.Closeable;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import phonebook06.db.Pb;

public class PhonebookManager implements Pb, Closeable {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	// singleton적용
	private PhonebookManager() {

		// JDBC 프로그래밍 , 클래스 로딩 ,연결 CONNECTION, Statement(필요하다면) 생성
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Connection 성공");
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()

	// 전화번호부 생성 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 : 이름 필수
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("insert() 이름입력오류: ", Pb.ERR_EMPTY_STRING);
		}

		int cnt =0;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			 cnt = pstmt.executeUpdate(); //DML
			System.out.println(cnt + "개 행(row) INSERT 성공");
			pstmt.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	

	@Override
	public PhonebookModel[] selectAll() {
		ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery(); 
			
			while (rs.next()) {
				PhonebookModel pbData = new PhonebookModel();
				pbData.setUid(rs.getInt(COL_LABEL_UID));
				pbData.setName(rs.getString(COL_LABEL_NAME));
				pbData.setPhoneNum(rs.getString(COL_LABEL_PHONENUM)); 
				pbData.setMemo(rs.getString(COL_LABEL_MEMO));
				pbData.setRegDate(rs.getDate(COL_LABEL_REGDATE));
				pbList.add(pbData);
				
			}
			System.out.println(pbList.size());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pbList.toArray(new PhonebookModel[pbList.size()]);
	}

	// 특정 uid 의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		
	//	if(PhonebookModel의 )


		return null; // 못찾으면 null 리턴
	}// end selectByUid()

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, Pb.ERR_UID);

		if (name == null || name.trim().length() == 0) // 이름 필수
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);
		
		int cnt =0;
		
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			cnt = pstmt.executeUpdate(); 
			System.out.println(cnt + "개 행(row) UPDATE 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteByUid(int uid) {
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("deleteByUid() uid 오류: " + uid, Pb.ERR_UID);

		int cnt = 0;

		// TODO : SQL_DELETE_BY_UID 사용
		try {
			pstmt = conn.prepareStatement(SQL_DELETE_BY_UID);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cnt;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		//TODO option
		
		return maxUid;
	}


	@Override
	public void close() throws IOException {

		try {
			if (rs != null) {rs.close();}
			if (pstmt != null) {pstmt.close();}
			if (conn != null) {conn.close();}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

} // end PhonebookManager

// 예의 클래스 정의
// 예외발생하면 '에러코드' + '에러메세지'를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {

	private int errCode = Pb.ERR_GENERIC;

	public PhonebookException() {
		super("Phonebook 예외 발생");
	}

	public PhonebookException(String msg) {
		super(msg);
	}

	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}

	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();
		return msg;
	}

} // end PhonebookException
