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
import java.util.Date;

import javax.swing.ImageIcon;

public class Main_Page {
	public static void main(String[]args) {
		Main m = new Main();
		
	}
}
class Main extends Frame implements ActionListener{
	int coffeePrice[] = {5500,3000,4500,4000,2000,1500};
	int coffeeMarch[] = {1200,2000,800,1700,900,600};
	String coffeeName[] = {"��īĿ��","�Ƹ޸�ī��","īǪġ��","ī���","���ھ�","������"};
	int selCoffee = 0;
	private Image img;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	private Image img6;
	private Image imgSel;
	int MoneyC = 0;
	int Cnt=1;
	int price=0;
	int price2=0;

	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font15 = new Font("SansSerif", Font.BOLD, 15);
	Label title = new Label("Ŀ�� ���Ǳ�");
	Button Moka = new Button("��īĿ��");
	Label PayMoka = new Label("5500��");
	Label HaveMo = new Label(coffeeMarch[0]+"��");
	Button Ame = new Button("�Ƹ޸�ī��");
	Label PayAme = new Label("3000��");
	Label HaveAme = new Label(coffeeMarch[1]+"��");
	Button Capu = new Button("īǪġ��");
	Label PayCapu = new Label("4500��");
	Label HaveCapu = new Label(coffeeMarch[2]+"��");
	Button Latte = new Button("ī���");
	Label PayLatte = new Label("4000��");
	Label HaveLa = new Label(coffeeMarch[3]+"��");
	Button Choc = new Button("���ھ�");
	Label PayChoc = new Label("2000��");
	Label HaveChoc = new Label(coffeeMarch[4]+"��");
	Button Yulmu = new Button("������");
	Label PayYulmu = new Label("1500��");
	Label HaveYul = new Label(coffeeMarch[5]+"��");
	Label Money = new Label("���Աݾ�");
	Label NowChange = new Label("�����ܾ� :");
	Label PayMoney = new Label("�����ݾ� :");
	Label Choice = new Label("���û�ǰ");
	Label NowMon = new Label(" ��");
	Label PayMon = new Label(" ��");	
	Button bt1 = new Button("1000��");
	Button bt2 = new Button("5000��");
	Button bt3 = new Button("10000��");
	Button btPay = new Button("�����ϱ�");
	Label ChoiceC = new Label("...");
	Label ChoiceH = new Label("...");
	Label ChoiceP = new Label("...");
	Label Change = new Label("�����ݾ� :");
	Label PayChange = new Label(" ��");
	TextField TNow = new TextField();
	TextField TPay = new TextField();
	
	Main()
	{
		
			super("����Ÿ���̽�");
			this.setSize(800,700);
			this.center();
			this.init();
			this.start();
			this.setVisible(true);
			
		
	}
	void start() 
	{
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		btPay.addActionListener(this);
		Moka.addActionListener(this);
		Ame.addActionListener(this);
		Latte.addActionListener(this);
		Capu.addActionListener(this);
		Choc.addActionListener(this);
		Yulmu.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainClose();
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
	void MainClose() 
	{
		this.setVisible(false);
	}
	public void paint(Graphics g) {


			g.drawImage(img,  20,  60, 100, 90, this);
			g.drawImage(img2, 170, 60, 100, 90, this);
			g.drawImage(img3, 330, 60, 100, 90, this);
			g.drawImage(img4, 20,  250, 100, 80, this);
			g.drawImage(img5, 170, 250, 100, 80, this);
			g.drawImage(img6, 330, 250, 100, 80, this);
			
			g.drawImage(imgSel, 500, 150, 100, 80, this);
		}
	
	void init() 
	{	//��� �����ؼ� ��ó��
		// ��ǰ��, ��ǰ����, ��ǰ������ ������
		getData();
		
		Moka.setLabel(coffeeName[0]);
		HaveMo.setText("����"+coffeeMarch[0]+"��");
		PayMoka.setText(coffeePrice[0]+"��");

		Ame.setLabel(coffeeName[1]);
		HaveAme.setText("����"+coffeeMarch[1]+"��");
		PayAme.setText(coffeePrice[1]+"��");

		Capu.setLabel(coffeeName[2]);
		HaveCapu.setText("����"+coffeeMarch[2]+"��");
		PayCapu.setText(coffeePrice[2]+"��");

		Latte.setLabel(coffeeName[3]);
		HaveLa.setText("����"+coffeeMarch[3]+"��");
		PayLatte.setText(coffeePrice[3]+"��");

		Choc.setLabel(coffeeName[4]);
		HaveChoc.setText("����"+coffeeMarch[4]+"��");
		PayChoc.setText(coffeePrice[4]+"��");

		Yulmu.setLabel(coffeeName[5]);
		HaveYul.setText("����"+coffeeMarch[5]+"��");
		PayYulmu.setText(coffeePrice[5]+"��");
		
		img = Toolkit.getDefaultToolkit().getImage("Moka.jpg");
		img2 = Toolkit.getDefaultToolkit().getImage("Ame.jpg");
		img3 = Toolkit.getDefaultToolkit().getImage("Cafu.jpg");
		img4 = Toolkit.getDefaultToolkit().getImage("Latte.jpg");
		img5 = Toolkit.getDefaultToolkit().getImage("Choco.jpg");
		img6 = Toolkit.getDefaultToolkit().getImage("Yulmu.jpg");
		
		this.setLayout(null);
		this.add(title);
		this.add(Moka);			this.add(PayMoka); 	this.add(HaveMo);
		this.add(Ame);			this.add(PayAme);	this.add(HaveAme);
		this.add(Capu);			this.add(PayCapu);	this.add(HaveCapu);
		this.add(Latte);		this.add(PayLatte);	this.add(HaveLa);
		this.add(Choc);			this.add(PayChoc);	this.add(HaveChoc);
		this.add(Yulmu);		this.add(PayYulmu);	this.add(HaveYul);
		this.add(Money);		this.add(NowChange);
		this.add(PayMoney);		this.add(Choice);
		this.add(HaveMo);		this.add(bt1);
		this.add(bt2);			this.add(bt3);
		this.add(btPay);		this.add(TNow);
		this.add(TPay);			this.add(NowMon);
		this.add(PayMon);		this.add(ChoiceC);
		this.add(ChoiceH);		this.add(ChoiceP);
		this.add(Change);		this.add(PayChange);
		
		
		title.setBounds(150,30,100,30); title.setFont(font15);
		Moka.setBounds(20,160,80,30); Moka.setFont(font15);
		PayMoka.setBounds(20,200,80,30);PayMoka.setFont(font15);
		HaveMo.setBounds(20,230,80,20);HaveMo.setFont(font15);
		Ame.setBounds(170,160,100,30); Ame.setFont(font15);
		PayAme.setBounds(170,200,80,30);PayAme.setFont(font15);
		HaveAme.setBounds(170,230,80,20);HaveAme.setFont(font15);
		Capu.setBounds(330,160,80,30); Capu.setFont(font15);
		PayCapu.setBounds(330,200,80,30);PayCapu.setFont(font15);
		HaveCapu.setBounds(330,230,80,20);HaveCapu.setFont(font15);
		Latte.setBounds(20,350,80,30); Latte.setFont(font15);
		PayLatte.setBounds(20,390,80,30);PayLatte.setFont(font15);
		HaveLa.setBounds(20,420,80,20);HaveLa.setFont(font15);
		Choc.setBounds(170,350,80,30); Choc.setFont(font15);
		PayChoc.setBounds(170,390,80,30);PayChoc.setFont(font15);
		HaveChoc.setBounds(170,420,80,20);HaveChoc.setFont(font15);
		Yulmu.setBounds(330,350,80,30); Yulmu.setFont(font15);
		HaveYul.setBounds(330,420,80,20);HaveYul.setFont(font15);
		PayYulmu.setBounds(330,390,80,30);PayYulmu.setFont(font15);
		Money.setBounds(20,450,90,30);Money.setFont(font15);
		bt1.setBounds(20,490,100,30);bt1.setFont(font15);
		bt2.setBounds(130,490,100,30);bt2.setFont(font15);
		bt3.setBounds(240,490,100,30);bt3.setFont(font15);
		btPay.setBounds(360,490,100,30);btPay.setFont(font15);
		NowChange.setBounds(20,570,100,30);NowChange.setFont(font15);
		NowMon.setBounds(130,570,100,30);NowMon.setFont(font15);
		PayMoney.setBounds(400,570,100,30);PayMoney.setFont(font15);
		PayMon.setBounds(530,570,100,30);PayMon.setFont(font15);
		Choice.setBounds(500,100,80,30);Choice.setFont(font15);
		ChoiceC.setBounds(500,230,100,30);ChoiceC.setFont(font15);
		ChoiceH.setBounds(500,280,100,30);ChoiceH.setFont(font15);
		ChoiceP.setBounds(500,330,100,30);ChoiceP.setFont(font15);
		Change.setBounds(400,600,100,30);Change.setFont(font15);
		PayChange.setBounds(530,600,100,30);PayChange.setFont(font15);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
			if(e.getSource()==Moka) 
			{	
				selCoffee=0;
				imgSel = Toolkit.getDefaultToolkit().getImage("Moka.jpg");
				coffeeMarch[0]--;
				HaveMo.setText("����"+coffeeMarch[0]+"��");
				price=price+5500;
				System.out.println("��īĿ�� ����");
				ChoiceC.setText("��īĿ��");
				ChoiceH.setText("5500��");
				ChoiceP.setText("����: "+Cnt++);
				PayMon.setText(price+"��");
				this.repaint();
				
				
			}
			if(e.getSource()==Ame) 
			{	
				selCoffee=1;
				imgSel = Toolkit.getDefaultToolkit().getImage("Ame.jpg");
				coffeeMarch[1]--;
				HaveAme.setText("����"+coffeeMarch[1]+"��");
				price=price+3000;
				System.out.println("�Ƹ޸�ī�� ����");
				ChoiceC.setText("�Ƹ޸�ī��");
				ChoiceH.setText("3000��");
				ChoiceP.setText("����: "+Cnt++);
				PayMon.setText(price+"��");
				this.repaint();
				
			}
			if(e.getSource()==Capu) 
			{	
				selCoffee=2;
				imgSel = Toolkit.getDefaultToolkit().getImage("Cafu.jpg");
				coffeeMarch[2]--;
				HaveCapu.setText("����"+coffeeMarch[2]+"��");
				price=price+4500;
				System.out.println("īǪġ�� ����");
				ChoiceC.setText("īǪġ��");
				ChoiceH.setText("4500��");
				ChoiceP.setText("����: "+Cnt++);
				PayMon.setText(price+"��");
				this.repaint();
			
			}
			if(e.getSource()==Latte) 
			{	
				selCoffee=3;
				imgSel = Toolkit.getDefaultToolkit().getImage("Latte.jpg");
				coffeeMarch[3]--;
				HaveLa.setText("����"+coffeeMarch[3]+"��");
				price=price+4000;
				System.out.println("��� ����");
				ChoiceC.setText("ī���");
				ChoiceH.setText("4000��");
				ChoiceP.setText("����: "+Cnt++);
				PayMon.setText(price+"��");
				this.repaint();
				
			}
			if(e.getSource()==Choc) 
			{	
				selCoffee=4;
				imgSel = Toolkit.getDefaultToolkit().getImage("Choco.jpg");
				coffeeMarch[4]--;
				HaveChoc.setText("����"+coffeeMarch[4]+"��");
				price=price+2000	;
				System.out.println("���ھ� ����");
				ChoiceC.setText("���ھ�");
				ChoiceH.setText("2000��");
				ChoiceP.setText("����: "+Cnt++);
				PayMon.setText(price+"��");
				this.repaint();
				
			}
			if(e.getSource()==Yulmu) 
			{	
				selCoffee=5;
				imgSel = Toolkit.getDefaultToolkit().getImage("Yulmu.jpg");
				coffeeMarch[5]--;
				HaveYul.setText("����"+coffeeMarch[5]+"��");
				price=price+1500;
				System.out.println("������ ����");
				ChoiceC.setText("������");
				ChoiceH.setText("1500��");
				ChoiceP.setText("����: "+Cnt++);
				PayMon.setText(price+"��");
				this.repaint();
				
			}
			if(e.getSource()==bt1) 
			{	
				price2=price2+1000;
				System.out.println("1000���� ���ԵǾ����ϴ�.");
				NowMon.setText(price2+"��");
				
			}
			if(e.getSource()==bt2) 	
			{
				price2=price2+5000;
				System.out.println("5000���� ���ԵǾ����ϴ�.");
				NowMon.setText(price2+" ��");
			}
			if(e.getSource()==bt3) 	
			{
				price2=price2+10000;
				System.out.println("10000���� ���ԵǾ����ϴ�.");
				NowMon.setText(price2+" ��");
			}
			if(e.getSource()==btPay) 	
			{
				PayChange.setText(price2-price+" ��");
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				countCheck(selCoffee);
			}
		}
	void countCheck(int selCoffee) 
	{
		if(selCoffee==0) 
		{
			
			HaveMo.setText("����"+coffeeMarch[0]+"��");
		}
		else if(selCoffee==1)
		{
			
			
			HaveAme.setText("����"+coffeeMarch[1]+"��");
			
		}
		else if(selCoffee==2)
		{
			
			HaveCapu.setText("����"+coffeeMarch[2]+"��");
			
		}
		else if(selCoffee==3)
		{
			
			HaveLa.setText("����"+coffeeMarch[3]+"��");
			
		}
		else if(selCoffee==4)
		{
			
			HaveChoc.setText("����"+coffeeMarch[4]+"��");
			
		}
		else if(selCoffee==5)
		{
			
			HaveYul.setText("����"+coffeeMarch[5]+"��");
			
		}
		
		//�����ϴ� �޼��� ȣ��
		update(selCoffee+1, coffeeMarch[selCoffee]);
	}
	boolean update(int idx, int cnt)
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
		
		String query = "update coffee set march = ? where idx = ?";
	
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setInt(1, cnt);
			pstmt.setInt(2, idx);		
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException ee) {
			System.err.println("�������� ����!!:"+ee.getMessage());
			return false;
		}
		return true;
	}
	void getData()
	{
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("����̺갡 ����ȵ�.");
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
				
				coffeeName[count] = rs.getString("name");
				coffeeMarch[count] = rs.getInt("march");
				coffeePrice[count] = rs.getInt("price");				
				count++;
			}				
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	
}