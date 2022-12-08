package coffee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Coffee_HostPage {
	public static void main(String[]args) {
		Host h = new Host();
	}
}
//+ rs.getString(4)+ " / " + rs.getString(5)
class Host extends Frame implements ActionListener{
	//상품 테이블 읽어와서 저장하는 2차원 배열
	String coffee[][] = new String[6][4];
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Label title = new Label("자판기-관리자화면");
	Label One = new Label("상품 1");
	Label Oname = new Label("이름: ");
	TextField ton = new TextField();
	Label Omarch = new Label("수량: ");
	TextField tom = new TextField();
	Label Oprice = new Label("가격: ");
	TextField top = new TextField();
	Label Two = new Label("상품 2");
	Label Tname = new Label("이름: ");
	TextField ttn = new TextField();
	Label Tmarch = new Label("수량: ");
	TextField ttm = new TextField();
	Label Tprice = new Label("가격: ");
	TextField ttp = new TextField();
	Label Three = new Label("상품 3");
	Label Thname = new Label("이름: ");
	TextField tthn = new TextField();
	Label Thmarch = new Label("수량: ");
	TextField tthm = new TextField();
	Label Thprice = new Label("가격: ");
	TextField tthp = new TextField();
	Label Four = new Label("상품 4");
	Label Foname = new Label("이름: ");
	TextField tfon = new TextField();
	Label Fomarch = new Label("수량: ");
	TextField tfom = new TextField();
	Label Foprice = new Label("가격: ");
	TextField tfop = new TextField();
	Label Five = new Label("상품 5");
	Label Finame = new Label("이름: ");
	TextField tfin = new TextField();
	Label Fimarch = new Label("수량: ");
	TextField tfim = new TextField();
	Label Fiprice = new Label("가격: ");
	TextField tfip = new TextField();
	Label Six = new Label("상품 6");
	Label Sname = new Label("이름: ");
	TextField tsn = new TextField();
	Label Smarch = new Label("수량: ");
	TextField tsm = new TextField();
	Label Sprice = new Label("가격: ");
	TextField tsp = new TextField();
	Button bt1 = new Button("적용");
	Button bt2 = new Button("적용");
	Button bt3 = new Button("적용");
	Button bt4 = new Button("적용");
	Button bt5 = new Button("적용");
	Button bt6 = new Button("적용");
	
	Host()
	{
		super("데이타베이스");
		this.setSize(800,400);
		this.center();
		this.init();
		this.start();
		this.setVisible(true);
		getData();
	}
	void start() 
	{	
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
	}
	
	void center() 
	{
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	void init() 
	{	
		this.setLayout(null);
		this.add(title);			this.add(One);			this.add(Oname);
		this.add(Omarch);			this.add(Oprice);		this.add(Two);
		this.add(Tname);			this.add(Tmarch);		this.add(Tprice);
		this.add(Three);			this.add(Thname);		this.add(Thmarch);
		this.add(Thprice);			this.add(Four);			this.add(Foname);
		this.add(Fomarch);			this.add(Foprice);		this.add(Five);
		this.add(Finame);			this.add(Fimarch);		this.add(Fiprice);
		this.add(Six);				this.add(Sname);		this.add(Smarch);
		this.add(Sprice);			
		this.add(bt1);			this.add(bt2);
		this.add(bt3);				this.add(bt4);			this.add(bt5);		
		this.add(bt6);
		this.add(ton);			this.add(tom);	this.add(top);
		this.add(ttn);			this.add(ttm);	this.add(ttp);
		this.add(tthn);			this.add(tthm);	this.add(tthp);
		this.add(tfon);			this.add(tfom);	this.add(tfop);
		this.add(tfin);			this.add(tfim);	this.add(tfip);
		this.add(tsn);			this.add(tsm);	this.add(tsp);
		
		title.setBounds(30,30,180,30); title.setFont(font15);
		One.setBounds(30,60,50,30);  One.setFont(font15);
		Oname.setBounds(90,60,40,30);Oname.setFont(font15);
		ton.setBounds(140,60,100,30);ton.setFont(font15);
		Omarch.setBounds(250,60,40,30);Omarch.setFont(font15);
		tom.setBounds(300,60,100,30); tom.setFont(font15);
		Oprice.setBounds(410,60,40,30);Oprice.setFont(font15);
		top.setBounds(460,60,100,30);top.setFont(font15);
		Two.setBounds(30,100,50,30);Two.setFont(font15);
		Tname.setBounds(90,100,40,30);Tname.setFont(font15);
		ttn.setBounds(140,100,100,30);ttn.setFont(font15);
		Tmarch.setBounds(250,100,40,30);Tmarch.setFont(font15);
		ttm.setBounds(300,100,100,30);ttm.setFont(font15);
		Tprice.setBounds(410,100,40,30);Tprice.setFont(font15);
		ttp.setBounds(460,100,100,30);ttp.setFont(font15);
		Three.setBounds(30,150,50,30);Three.setFont(font15);
		Thname.setBounds(90,150,40,30);Thname.setFont(font15);
		tthn.setBounds(140,150,100,30);tthn.setFont(font15);
		Thmarch.setBounds(250,150,40,30);Thmarch.setFont(font15);
		tthm.setBounds(300,150,100,30);tthm.setFont(font15);
		Thprice.setBounds(410,150,40,30);Thprice.setFont(font15);
		tthp.setBounds(460,150,100,30);tthp.setFont(font15);
		Four.setBounds(30,200,50,30);Four.setFont(font15);
		Foname.setBounds(90,200,40,30);Foname.setFont(font15);
		tfon.setBounds(140,200,100,30);tfon.setFont(font15);
		Fomarch.setBounds(250,200,40,30);Fomarch.setFont(font15);
		tfom.setBounds(300,200,100,30);tfom.setFont(font15);
		Foprice.setBounds(410,200,40,30);Foprice.setFont(font15);
		tfop.setBounds(460,200,100,30);tfop.setFont(font15);
		Five.setBounds(30,250,50,30);Five.setFont(font15);
		Finame.setBounds(90,250,40,30);Finame.setFont(font15);
		tfin.setBounds(140,250,100,30);tfin.setFont(font15);
		Fimarch.setBounds(250,250,40,30);Fimarch.setFont(font15);
		tfim.setBounds(300,250,100,30);tfim.setFont(font15);
		Fiprice.setBounds(410,250,40,30);Fiprice.setFont(font15);
		tfip.setBounds(460,250,100,30);tfip.setFont(font15);
		Six.setBounds(30,300,50,30);Six.setFont(font15);
		Sname.setBounds(90,300,40,30);Sname.setFont(font15);
		tsn.setBounds(140,300,100,30);tsn.setFont(font15);
		Smarch.setBounds(250,300,40,30);Smarch.setFont(font15);
		tsm.setBounds(300,300,100,30);tsm.setFont(font15);
		Sprice.setBounds(410,300,40,30);Sprice.setFont(font15);
		tsp.setBounds(460,300,100,30);tsp.setFont(font15);
		bt1.setBounds(580,60,80,30);bt1.setFont(font15);
		bt2.setBounds(580,100,80,30);bt2.setFont(font15);
		bt3.setBounds(580,150,80,30);bt3.setFont(font15);
		bt4.setBounds(580,200,80,30);bt4.setFont(font15);
		bt5.setBounds(580,250,80,30);bt5.setFont(font15);
		bt6.setBounds(580,300,80,30);bt6.setFont(font15);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String name  = 	ton.getText();
		String name2 = 	ttn.getText();
		String name3 = 	tthn.getText();
		String name4 = 	tfon.getText();
		String name5 = 	tfin.getText();
		String name6 = 	tsn.getText();
		String march = 	tom.getText();
		String march2 = ttm.getText();
		String march3 = tthm.getText();
		String march4 = tfom.getText();
		String march5 = tfim.getText();
		String march6 = tsm.getText();
		String price = 	top.getText();
		String price2 = ttp.getText();
		String price3 = tthp.getText();
		String price4 = tfop.getText();
		String price5 = tfip.getText();
		String price6 = tsp.getText();
		
		if(e.getSource()==bt1) 
		{
			if(spaceCheck(name, march, price))
			{
				return;
			}
			else
			{
				update(1,name, march, price);
			}
		}
		if(e.getSource()==bt2) 
		{
			if(spaceCheck(name, march, price))
			{
				return;
			}
			else
			{
				update(2,name2, march2, price2);
			}
		}
		if(e.getSource()==bt3) 
		{
			if(spaceCheck(name, march, price))
			{
				return;
			}
			else
			{
				update(3,name3, march3, price3);
			}
		}
		if(e.getSource()==bt4) 
		{
			if(spaceCheck(name, march, price))
			{
				return;
			}
			else
			{
				update(4,name4, march4, price4);
			}
		}
		if(e.getSource()==bt5) 
		{
			if(spaceCheck(name, march, price))
			{
				return;
			}
			else
			{
				update(5,name5, march5, price5);
			}
		}
		if(e.getSource()==bt6) 
		{
			if(spaceCheck(name, march, price))
			{
				return;
			}
			else
			{
				update(6,name6, march6, price6);
			}
		}
		
	}
	boolean spaceCheck(String name, String march, String price)	
	{
		if(name.equals("")) {msg("커피명을 적어주세요."); return true;}
		if(march.equals("")) {msg("수량을 적어주세요.");   return true;}
		if(price.equals("")) {msg("가격을 적어주세요."); return true;}
			
		//여기까지왔다는건 공백이 아니라서 false~
		return false;
	}	
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);	lbMsg.setFont(font20);
		lbMsg.setBounds(100, 100, 450, 30);
		
		dlg.setSize(500, 250);
		dlg.setLocation(700, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
	void getData()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브가 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from coffee";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
			int count=0;
			
			while (rs.next()) {
				coffee[count][0] = rs.getInt("idx")+"";
				coffee[count][1] = rs.getString("name");
				coffee[count][2] = rs.getString("march");
				coffee[count][3] = rs.getString("price");				
				count++;
			}
			//화면에 뿌리기...노가다..					
					ton.setText(coffee[0][1]);
					tom.setText(coffee[0][2]);
					top.setText(coffee[0][3]);
					
					ttn.setText(coffee[1][1]);
					ttm.setText(coffee[1][2]);
					ttp.setText(coffee[1][3]);
					
					tthn.setText(coffee[2][1]);
					tthm.setText(coffee[2][2]);
					tthp.setText(coffee[2][3]);
					
					tfon.setText(coffee[3][1]);
					tfom.setText(coffee[3][2]);
					tfop.setText(coffee[3][3]);
					
					tfin.setText(coffee[4][1]);
					tfim.setText(coffee[4][2]);
					tfip.setText(coffee[4][3]);
					
					tsn.setText(coffee[5][1]);
					tsm.setText(coffee[5][2]);
					tsp.setText(coffee[5][3]);
			
		
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	boolean update(int idx, String name, String march, String price)
	{
		Connection dc=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {		
		}
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "qwer";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
		
		String query = "update coffee set name = ?, march = ?, price = ? where idx = ?";
		
		
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, march);
			pstmt.setString(3, price);
			pstmt.setInt(4, idx);
			
			pstmt.executeUpdate();
			pstmt.close();
			msg("회원정보수정완료!");
		} catch (SQLException ee) {
			System.err.println("회원 정보수정 실패!!");
			return false;
		}
		return true;
	}
	
}
