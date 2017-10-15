/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smeditor;

/**
 *
 * @author Sawan Darekar
 */
import java.awt.FlowLayout;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class SMEditor extends JFrame implements ActionListener
{
    static final long serialVersionUID=1;
    String str;
    JMenu Menu1,Menu2,Menu3,Menu4,Menu5,draw;
    JMenuBar Menubar1;
    JMenuItem new1,open,save,save_as,print, exit;
    JMenuItem undo,cut,copy,paste,delete,find,find_next,goto1,selectall,font,help_topic,about_notepad;
    JMenuItem freehand,line,rectangle,circle,square;
    JMenuItem jmicut,jmicopy,jmipaste;
    JPopupMenu jpu;
    JTextArea txtara1;
    JComboBox f,t,s;
    JTextField jtf_f;
    JCheckBoxMenuItem status_bar;
    JLabel status_bar1;
    JScrollPane jsp;
    JDialog jd,jd_f,fnt,jd_loading;
    JButton b1,combo_btn,btn_f1,btn_f2;
    int wc,lc,cc;
    File fl=null;
    int nn=1;
    JComboBox jcb_f,jcb_s;
    int sz=10;
    String ft="Courier";
    Font fnt1;
    JPanel pn;

    public SMEditor()
	{
    	Menubar1 = new JMenuBar();

        Menu1 = new JMenu("File");
        Menu1.setMnemonic(KeyEvent.VK_F);
    	Menu2 = new JMenu("Edit");
        Menu2.setMnemonic(KeyEvent.VK_E);
    	Menu3 = new JMenu("Format");
        Menu3.setMnemonic(KeyEvent.VK_O);
    	Menu4 = new JMenu("View");
        Menu4.setMnemonic(KeyEvent.VK_V);
        Menu5 = new JMenu("Help");
        Menu5.setMnemonic(KeyEvent.VK_H);
        draw=new JMenu("Draw");
        draw.setMnemonic(KeyEvent.VK_D);

//Menu1 File..
        ImageIcon ii1=new ImageIcon("/images/new.gif");
        new1 = new JMenuItem("New       ",ii1);
        new1.setMnemonic(KeyEvent.VK_N);
        new1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
        Menu1.add(new1);
        new1.addActionListener(this);
        ImageIcon ii2=new ImageIcon("/images/open.gif");
        open = new JMenuItem("Open..    ",ii2);
        open.setMnemonic(KeyEvent.VK_O);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
        Menu1.add(open);
        open.addActionListener(this);
        ImageIcon ii3=new ImageIcon("/images/save.gif");
        save = new JMenuItem("Save..   ",ii3);
        save.setMnemonic(KeyEvent.VK_S);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        Menu1.add(save);
        save.addActionListener(this);
        ImageIcon ii4=new ImageIcon("/images/saveas.gif");
        save_as = new JMenuItem("Save as",ii4);
        save_as.setMnemonic(KeyEvent.VK_A);
        save_as.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        Menu1.add(save_as);
        save_as.addActionListener(this);
        Menu1.addSeparator();
        ImageIcon ii5=new ImageIcon("/images/print.gif");
        print = new JMenuItem("Print..  ",ii5);
        print.setMnemonic(KeyEvent.VK_P);
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
        Menu1.add(print);
        print.addActionListener(this);
        Menu1.addSeparator();
        ImageIcon ii6=new ImageIcon("/images/exit.jpg");
        exit = new JMenuItem("Exit",ii6);
        exit.setMnemonic(KeyEvent.VK_X);
        Menu1.add(exit);
        exit.addActionListener(this);

//Menu Edit..
        ImageIcon ii7=new ImageIcon("/images/undo.gif");
        undo = new JMenuItem("Undo",ii7);
        undo.setMnemonic(KeyEvent.VK_Z);
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
        Menu2.add(undo);
        undo.addActionListener(this);
        Menu2.addSeparator();
        ImageIcon ii8=new ImageIcon("/images/cut.gif");
        cut = new JMenuItem("Cut   ",ii8);
        cut.setMnemonic(KeyEvent.VK_X);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
        Menu2.add(cut);
        cut.addActionListener(this);
        ImageIcon ii9=new ImageIcon("/images/copy.gif");
        copy = new JMenuItem("Copy",ii9);
        copy.setMnemonic(KeyEvent.VK_C);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
        Menu2.add(copy);
        copy.addActionListener(this);
        ImageIcon ii10=new ImageIcon("/images/paste.gif");
        paste = new JMenuItem("Paste",ii10);
        paste.setMnemonic(KeyEvent.VK_V);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
        Menu2.add(paste);
        paste.addActionListener(this);
        ImageIcon ii11=new ImageIcon("/images/delete.gif");
        delete = new JMenuItem("delete ",ii11);
        delete.setMnemonic(KeyEvent.VK_D);
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
        Menu2.add(delete);
        delete.addActionListener(this);
        Menu2.addSeparator();
        find = new JMenuItem("find...");
        find.setMnemonic(KeyEvent.VK_F);
        find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
        Menu2.add(find);
        find.addActionListener(this);
        find_next = new JMenuItem("find next  ");
        find_next.setMnemonic(KeyEvent.VK_N);
        Menu2.add(find_next);
        find_next.addActionListener(this);
        goto1 = new JMenuItem("goto...        ");
        goto1.setMnemonic(KeyEvent.VK_G);
        goto1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK));
        Menu2.add(goto1);
        goto1.addActionListener(this);
        Menu2.addSeparator();
        selectall = new JMenuItem("Select All..  ");
        selectall.setMnemonic(KeyEvent.VK_A);
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        Menu2.add(selectall);
        selectall.addActionListener(this);

//Menu Draw
        ImageIcon ii12=new ImageIcon("/images/freehand.gif");
        freehand = new JMenuItem("Free Hand",ii12);
        freehand.setMnemonic(KeyEvent.VK_F);
        draw.add(freehand);
        freehand.addActionListener(this);
        ImageIcon ii13=new ImageIcon("/images/line.gif");
        line = new JMenuItem("Line",ii13);
        line.setMnemonic(KeyEvent.VK_L);
        draw.add(line);
        line.addActionListener(this);
        ImageIcon ii14=new ImageIcon("/images/rectangle.gif");
        rectangle = new JMenuItem("Rectangle",ii14);
        rectangle.setMnemonic(KeyEvent.VK_R);
        draw.add(rectangle);
        rectangle.addActionListener(this);
        ImageIcon ii15=new ImageIcon("/images/circle.gif");
        circle = new JMenuItem("Circle",ii15);
        circle.setMnemonic(KeyEvent.VK_C);
        draw.add(circle);
        circle.addActionListener(this);
        ImageIcon ii16=new ImageIcon("/images/square.gif");
        square = new JMenuItem("Square",ii16);
        square.setMnemonic(KeyEvent.VK_S);
        draw.add(square);
        square.addActionListener(this);

//Menu Format..
        ImageIcon ii17=new ImageIcon("/images/font.gif");
        font = new JMenuItem("Font... ",ii17);
        font.setMnemonic(KeyEvent.VK_F);
        Menu3.add(font);
        font.addActionListener(this);

//Menu View..
        status_bar = new JCheckBoxMenuItem("Status Bar");
        Menu4.add(status_bar);
        status_bar.setState(true);
        status_bar.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent ae)
          {if(!status_bar.isSelected())
           {
               status_bar1.setVisible(false);
               setSize(750,540);
           }
           else
           {
               status_bar1.setVisible(true);
               setSize(750,560);
           }
          }
        });

//Menu Help
        ImageIcon ii18=new ImageIcon("/images/help.gif");
        help_topic = new JMenuItem("Help Topics ",ii18);
        help_topic.setMnemonic(KeyEvent.VK_H);
        Menu5.add(help_topic);
        help_topic.addActionListener(this);
        Menu5.addSeparator();
        ImageIcon ii19=new ImageIcon("/images/about.gif");
        about_notepad = new JMenuItem("About SMNotepad",ii19);
        about_notepad.setMnemonic(KeyEvent.VK_A);
        Menu5.add(about_notepad);
        about_notepad.addActionListener(this);


        Menubar1.add(Menu1);
        Menubar1.add(Menu2);
        Menubar1.add(draw);
        Menubar1.add(Menu3);
        Menubar1.add(Menu4);
        Menubar1.add(Menu5);

        setJMenuBar(Menubar1);

        pn=new JPanel();
        pn.setLayout(new GridLayout(1,2));
     /*   ImageIcon icn=new ImageIcon("/images/loading.gif");
        loading=new JLabel(icn);
        loading.setVisible(true);*/

        status_bar1=new JLabel("Line count:- "+"  word count:- "+"  characters:-");
     //   status_bar1.setHorizontalTextPosition(SwingConstants.LEADING);
      //  status_bar1.setHorizontalAlignment(SwingConstants.LEADING);
      //  status_bar1.setPreferredSize(new Dimension(700,30));

        this.getContentPane().setLayout(new FlowLayout());

        txtara1=new JTextArea();
        txtara1.setMargin(new Insets(1, 3, 1, 1));
        txtara1.setSelectedTextColor(Color.BLUE);
        txtara1.addCaretListener(new CaretListener()
        {
          public void caretUpdate(CaretEvent ce)
          {
        	 String str=txtara1.getText();
             if(str.length()==0)
                    wc=0;
             else
             {
                 String [] strsplit=(str.trim()).split("\\W+");
                 wc=strsplit.length;
                 if(strsplit.length>0 && strsplit[0].length()==0)
                	 wc--;
             }
             status_bar1.setText("Line count:- "+txtara1.getLineCount()+"  word count:- "+wc+"  characters:- "+str.length());
          }
        } );

        txtara1.setDragEnabled(true);
    	txtara1.setCaretPosition(0);
    	txtara1.addMouseListener(new MouseAdapter()
    	{
    		public void mouseReleased(MouseEvent me)
    		{
    			if(me.isPopupTrigger() && me.getButton() == 3 )
    			jpu.show(me.getComponent(),me.getX(),me.getY());
    		}
    	});

        jpu=new JPopupMenu();
    	jmicut = new JMenuItem("Cut");
    	jmicut.addActionListener(this);
    	jmicopy = new JMenuItem("Copy");
    	jmicopy.addActionListener(this);
    	jmipaste = new JMenuItem("Paste");
    	jmipaste.addActionListener(this);

    	jpu.add(jmicut);
    	jpu.add(jmicopy);
    	jpu.add(jmipaste);



        jsp=new JScrollPane(txtara1);
        jsp.setPreferredSize(new Dimension(700,470));
        add(jsp);

        pn.add(status_bar1);
        this.add(pn);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SMNotepad");
        setLocation(150,100);
      	setResizable(false);
        setSize(750,560);
      	setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
	 	if(ae.getSource()==new1)
	 	{
	 		fl=null;
	 		nn=1;
	 		txtara1.setText(null);
       	}
	 	if(ae.getSource()==open)
	 	{
	 		nn=0;
	 		this.fileopen();
        }
	 	if(ae.getSource()==save)
	 	{
	 		this.filesave();
        }
	 	if(ae.getSource()==save_as)
	 	{
		  this.filesaveas();
        }
	 	if(ae.getSource()==print)
	 	{
	 	}
	 	if(ae.getSource()==undo)
	 	{
	 	}

	 	if(ae.getSource()==exit)
	 		System.exit(0);
        if(ae.getSource()==undo)
        {

        }
        if(ae.getSource()==cut || ae.getSource()==jmicut)
        {
        	txtara1.cut();
        }
        if(ae.getSource()==copy|| ae.getSource()==jmicopy)
        {
        	txtara1.copy();
        }
        if(ae.getSource()==paste|| ae.getSource()==jmipaste)
        {
        	txtara1.paste();
        }
        if(ae.getSource()==delete)
        {

        }
        if(ae.getSource()==find)
        {
              find_find_next();
        }
        if(ae.getSource()==find_next)
        {
              find_find_next();
        }
        if(ae.getSource()==goto1)
        {
          go_to();
        }
        if(ae.getSource()==selectall)
        {
        	txtara1.selectAll();
        }
        if(ae.getSource()==freehand)
        {
        }
        if(ae.getSource()==line)
        {

        }
        if(ae.getSource()==rectangle)
        {
        }
        if(ae.getSource()==circle)
        {
        }
        if(ae.getSource()==square)
        {
        }
        if(ae.getSource()==font)
        {
        	select_font();
        }
        if(ae.getSource()==help_topic)
        {
        }
        if(ae.getSource()==about_notepad)
        {
        	this.aboutnotepad();
        }
        if(ae.getSource()==btn_f1)
        {
        	txtara1.setFont(fnt1);
        	jd_f.setVisible(false);
        }
        if(ae.getSource()==btn_f2)
        {
        	jd_f.setVisible(false);
        }
}
/**
 * It moves curser to given line number
 *
 */
public void go_to()
{
	String str=JOptionPane.showInputDialog(null,"Enter Line Number:- ","Goto Line",-1);

	if(str!=null);
    {
  	  System.out.println(str);
    }
}
/**
 * It this fuction used to select different font for text area
 *
 */
public void select_font()
{
      final String FONTS[] =
      { "Arial", "Arial Black", "Arial Narrow","Bodoni MT","Castellar","Courier",
    		  "Fixedsys","Gautami","Gigi","Kiran","Kruti Dev 110","Mangal","Monotype Corsiva",
              	"MS Serif","Palace Script MT","Papyrus","Shivaji01","Shruti","Small Fonts",
              	"Times New Roman","Tunga","WST_Engl","Verdana"};
	  final String SIZE[] =
	  { "2", "4", "8","10","12","14","16","18","20","21","22","24","26","28","30","32","34"};


	  jd_f=new JDialog(this,"Font",true);
	  jd_f.setSize(300,230);
	  jd_f.setLayout(null);
	  JLabel l1=new JLabel("Select Font");
	  l1.setBounds(20,20,80,30);
      jd_f.add(l1);
      jcb_f = new JComboBox(FONTS);
      jcb_f.setMaximumSize(jcb_f.getPreferredSize());
      jcb_f.setBounds(110,20,150,30);
	  jcb_f.addActionListener(new ActionListener() {
	  public void actionPerformed(ActionEvent e) {
		  String s =  txtara1.getSelectedText();
		  if(s.length() > 21)
			  s = s.substring(0, 20);
		  		ft = (jcb_f.getSelectedItem()).toString();
        		fnt1=new Font(ft,Font.PLAIN,sz);
                jtf_f.setFont(fnt1);
                if(s == null)
                	 s = "Sawan Darekar";
                jtf_f.setText(s);

	      }
	    });
      jd_f.add(jcb_f);
	  JLabel l2=new JLabel("Select Size");
	  l2.setBounds(20,60,80,30);
	  jd_f.add(l2);
	  jcb_s = new JComboBox(SIZE);
	  jcb_s.setEditable(true);
	  jcb_s.setMaximumSize(jcb_s.getPreferredSize());
	  jcb_s.setBounds(110,60,50,30);
	  jcb_s.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  String s =  txtara1.getSelectedText();
			  if(s.length() > 21)
				  s = s.substring(0, 20);
			    sz=Integer.parseInt((jcb_s.getSelectedItem()).toString());
                fnt1=new Font(ft,Font.PLAIN,sz);
                jtf_f.setFont(fnt1);
                if(s == null)
               	 s = "Sawan Darekar";
                jtf_f.setText(s);
	      }
	    });
       	jd_f.add(jcb_s);
       	jtf_f=new JTextField();
       	jtf_f.setEditable(true);
       	jtf_f.setBounds(20,100,250,50);
       	jd_f.add(jtf_f);
       	btn_f1=new JButton("OK");
       	btn_f1.setBounds(40,160,80,30);
       	btn_f1.addActionListener(this);
       	jd_f.add(btn_f1);
       	btn_f2=new JButton("Cancle");
       	btn_f2.setBounds(160,160,80,30);
       	btn_f2.addActionListener(this);
       	jd_f.add(btn_f2);
       	jd_f.setLocation(400,200);
       	jd_f.setVisible(true);
}
public void find_find_next()
{


}
/**
 * It shows information about this notepad *
 *
 */
public void aboutnotepad()
{
		jd=new JDialog(this,"About SMNotepad",true);
		jd.setSize(200,200);
		jd.setLayout(new FlowLayout());
		JLabel l1=new JLabel("**simple(SM) Notepad**");
		jd.add(l1);
		JLabel l2=new JLabel("Version 1.0 ");
		jd.add(l2);
		JLabel l3=new JLabel("This is simple(SM) Notepad");
		jd.add(l3);
		JLabel l4=new JLabel("contact:- sawandarekar@gmail.com");
		jd.add(l4);
		b1=new JButton("OK");
		b1.setSize(20,20);
		b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){jd.setVisible(false);}});
		jd.add(b1);
		jd.setLocation(400,200);
		jd.setVisible(true);
}
/**
 * It open's the file chooser wizard to open specific file
 *
 */
public void fileopen()
{
		JFileChooser jfc=new JFileChooser();
        int result=jfc.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
        	fl=jfc.getSelectedFile();
        	txtara1.setText("");
	        try
        	{
        		InputStream in = new FileInputStream(fl);
        		//FileInputStream inputStream = new FileInputStream("str");
        		int b = 0;
        		while(b != -1)
        		{
        			b = in.read();
        			//str1 += (char)b;
        			txtara1.append(""+(char)b);
        		}
        		in.close();
        	}
        	catch (FileNotFoundException e)
        	{
        		JOptionPane.showMessageDialog(this,"File Not Found");
            }
        	catch (IOException e)
        	{
        		JOptionPane.showMessageDialog(this,"I/O Error");
        	}
                catch(Exception e)
                {}
        }
}
/**
 * It saves same file to selected location
 *
 */
public void filesaveas()
{
	JFileChooser jfc;
	File filename=null;
	jfc=new JFileChooser();
	int result=jfc.showSaveDialog(null);
	if(result==JFileChooser.APPROVE_OPTION)
	{
		filename=jfc.getSelectedFile();
		String s=txtara1.getText();
		try
		{
			OutputStream out = new FileOutputStream(filename);
			PrintWriter pw=new PrintWriter(out);
			pw.write(s);
			pw.close();
			out.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
/**
 * It saves the file to selected location
 *
 */
public void filesave()
{
	if(nn==1)
	{
             filesaveas();
    }
	else
	{
		String s=txtara1.getText();
        try
        {
        	OutputStream out = new FileOutputStream(fl);
        	PrintWriter pw=new PrintWriter(out);
        	pw.write(s);
        	pw.close();
        	out.close();
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();
        }
	}
}
public static void main(String[] args)
{
	SwingUtilities.invokeLater(new Runnable()
	{
		public void run(){new SMEditor();}
	});
}
}


