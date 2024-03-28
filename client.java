import javax.swing.*;       // JFrame ke liye
import javax.swing.border.*;
import java.awt.*;          // color ke liye
import java.awt.event.*;    // ye awt ke andar aur ek sub package hai event nam ka usko import kiya
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class client implements ActionListener{
JTextField text;
static JPanel a1;
static Box vertical = Box.createVerticalBox();
static DataOutputStream dout;
static JFrame f = new JFrame();






    client(){
        // Green Panel code
        f.setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));   // green color ka RGB value hai
        p1.setLayout(null);     // panel ka layout bhi null set karna padega nhi to vo default leta hai
        f.add(p1);            // panel add kiye bina panel dikhega nhi
        p1.setBounds(0, 0, 450, 70);    // pehele 2 parameters matlab frame me kaha ayega aur dusre 2 matlab uski length, breadth kitni hogi

        // Back Label code
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));    // image ko image icon me convert kiya
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);    // image ko shrink krke 25x25 ke scale me laya taki vo label me fit ho jaye
        ImageIcon i3 = new ImageIcon(i2);    // shrink ki huyi image i2 me hai usko label me dalne ke liye vapas image icon me convert karna padega
        JLabel back = new JLabel(i3);       // image icon ko label me convert kiya
        back.setBounds(5, 20, 25, 25);
         
        p1.add(back);

        // mouse ke click pe band ho jana chahiye
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae){
                System.exit(0);                 // back arrow dabane pe window close ho rahi hai
            }
        });

        // profile pic label code
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));    // image ko image icon me convert kiya
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);    // image ko shrink
        ImageIcon i6 = new ImageIcon(i5);    // shrink ki huyi image ko vapas image icon me convert karna padega
        JLabel profile = new JLabel(i6);       // image icon ko label me convert kiya
        profile.setBounds(40, 10, 50, 50); 
        p1.add(profile);

        // video icon label code
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));    // image ko image icon me convert kiya
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);    // image ko shrink
        ImageIcon i9 = new ImageIcon(i8);    // shrink ki huyi image vapas image icon me convert karna padega
        JLabel video = new JLabel(i9);       // image icon ko label me convert kiya
        video.setBounds(300, 20, 30, 30); 
        p1.add(video);

        // call icon label code
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));    // image ko image icon me convert kiya
        Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);    // image ko shrink
        ImageIcon i12 = new ImageIcon(i11);    // shrink ki huyi image vapas image icon me convert karna padega
        JLabel phone = new JLabel(i12);       // image icon ko label me convert kiya
        phone.setBounds(360, 20, 30, 30); 
        p1.add(phone);

        // 3 dots label code
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));    // image ko image icon me convert kiya
        Image i14 = i13.getImage().getScaledInstance(15, 30, Image.SCALE_DEFAULT);    // image ko shrink
        ImageIcon i15 = new ImageIcon(i14);    // shrink ki huyi image vapas image icon me convert karna padega
        JLabel menu = new JLabel(i15);       // image icon ko label me convert kiya
        menu.setBounds(410, 20, 15, 30); 
        p1.add(menu);

        // name besides the profile pic
        JLabel name = new JLabel("Thor");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SANS_SERIF", Font.BOLD, 18));        //"new font" anonymous object hai aur vo constructor hai 
        p1.add(name);

        // status under name
        JLabel status = new JLabel("Active-now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SANS_SERIF", Font.BOLD, 14));   
        p1.add(status);

       
       
       
       
        a1 = new JPanel();
        a1.setBounds(5,75,440,570);
        f.add(a1);


        //text box   
        text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(text);

        // add send button
        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.GREEN);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(send);

        
        
        //Frame code
        f.setSize(450,700);
        f.setLocation(830,30);    // screen pe kaha khul rahi hai vo set kar rahe hai
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);    // ye awt library ka hai

        f.setVisible(true);       // makes frame visible, iske bina frame ban to jayegi par dikhegi nhi
    }

    public void actionPerformed(ActionEvent ae){
      try{
      String out = text.getText();

 

     JPanel p2 = formatLabel(out);
 
     
     



      a1.setLayout(new BorderLayout());

      JPanel right = new JPanel(new BorderLayout());
      right.add(p2,BorderLayout.LINE_END);


      vertical.add(right);
      vertical.add(Box.createVerticalStrut(15));


      a1.add(vertical,BorderLayout.PAGE_START);
      dout.writeUTF(out);


      text.setText("");

      f.repaint();
      f.invalidate();
      f.validate();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
    public static JPanel formatLabel(String out)
    {
      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout( panel,BoxLayout.Y_AXIS));



      JLabel output = new JLabel("<html><p style=\"width:150px\">" + out + "</p></html>");
      output.setFont(new Font("Tahoma",Font.PLAIN,16));
      output.setBackground(new Color(37,211,102));
      output.setOpaque(true);
      output.setBorder(new EmptyBorder(15,15,15,50));
      panel.add(output);

      Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("HH::mm");

      JLabel time = new JLabel();
      time.setText(sdf.format(cal.getTime()));
      panel.add(time);





      return panel;
    }
    


    public static void main(String[] args) {
        new client();    // create anonymous object of server class
        try
        {
        Socket s =  new Socket("127.0.0.1",6001);
         DataInputStream din = new DataInputStream(s.getInputStream());
          dout = new DataOutputStream(s.getOutputStream());

           while (true)
          {
            a1.setLayout(new BorderLayout());
          String msg = din.readUTF();

          JPanel panel = formatLabel(msg);
          JPanel left = new JPanel(new BorderLayout());
          left.add(panel , BorderLayout.LINE_START);


          vertical.add(left);


          vertical.add(Box.createVerticalStrut(15));
          a1.add(vertical,BorderLayout.PAGE_START);
          f.validate();
          }

        }

        catch(Exception e)
        {
          e.printStackTrace();
        }
}
}