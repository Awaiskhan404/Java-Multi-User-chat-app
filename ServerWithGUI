/**
 * @author Awais khan
 */
package server;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextArea;

public class ServerWithGUI extends javax.swing.JFrame 
{
  
	private static final long serialVersionUID = 1L;
ArrayList<PrintWriter> clientOutputStreams = new ArrayList<>();
   ArrayList<String> users = new ArrayList<>();
  // static int id = 0 ;

   public class ClientHandler implements Runnable	
   {
       BufferedReader reader;
       Socket sock;
       PrintWriter client;
       int id_privateChat ;

       public ClientHandler(Socket clientSocket, PrintWriter user)//, int useridnumber) 
       {
            client = user;
          //  id_privateChat = useridnumber ;
            try 
            {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (Exception ex) 
            {
                ta_chat.append("Unexpected error... \n");
            }

       }

       @Override
       public void run() 
       {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat" , privatemsg = "private" ;
            String[] data;

            try 
            {
                while ((message = reader.readLine()) != null) 
                {
                   
                    ta_chat.append("\nReceived: " + message + "\n");
                    data = message.split(":");
                    int counter2steps = 0;
                    for (String token:data) 
                    {
                    	if(counter2steps!=2)
                        ta_chat.append(token + " ");
                        counter2steps++;
                    }

                    if (data[2].equals(connect)) 
                    {
                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        userAdd(data[0]);
                    } 
                    else if (data[2].equals(disconnect)) 
                    {
                        tellEveryone((data[0] + "  has :Disconnected" + ":" + chat));
                       // JOptionPane.showMessageDialog(null, clientOutputStreams.size()+"   size");
                        clientOutputStreams.remove(getid(data[0]));
                        userRemove(data[0]);
                        //ta_chat.append(clientOutputStreams.size()+"");
                       
                       // clientOutputStreams.remove(getid(data[0]));
                    } 
                    else if (data[2].equals(chat)) 
                    {
                        tellEveryone(message);
                    } 
                    else if (data[2].equals(privatemsg)) {
                        
                        int recievedID  = getid(data[3]);
                        //JOptionPane.showMessageDialog(null, ""+recievedID);
                       if (recievedID != -1) {
                        	tellthispersononly(message, recievedID, data[3]);
						} else {
							tellthispersononly(message, recievedID, data[0]);
//							String Errormsg = data[0]+ ": User Not Found from the online users :private";
//							tellthispersononly(Errormsg, getid(data[0]), data[0]);
//							//JOptionPane.showMessageDialog(null, "No Name of the online users matches this name : "+ data[3] +"\n Check the online users correctly ", "This user is not found or not online", JOptionPane.ERROR_MESSAGE);
						}
                        
                        
                    }else if (data[2].equals("request")) {
                        
                        int recievedID  ;
                        //JOptionPane.showMessageDialog(null, "I am here ");
                        StringBuilder stringBuilder = new StringBuilder();
                        //stringBuilder.append("\n Online users ; \n");
                       // stringBuilder.append(" ONLINE USERS ;    ");
                             for (String current_user : users)
                     {
                                recievedID  = getid(current_user);
                                stringBuilder.append(current_user).append(", With ID = ").append(recievedID);
                               // stringBuilder.append("\n");
                               stringBuilder.append(".   ");
                    }           
                             recievedID  = getid(data[0]);
                             String finalString = stringBuilder.toString();
                             finalString = data[0]+ ":" +finalString+ ":" + "request" ;
                             tellthispersononly(finalString, recievedID, data[0]); // d[0] here is the reciever person which is the in this case the sender itself 
                             //JOptionPane.showMessageDialog(null, "I am here ,,,,, " + finalString);
                    }
                    else 
                    {
                        ta_chat.append("No Conditions were met. \n");
                    }
                } 
             } 
             catch (Exception ex) 
             {
                // clientOutputStreams.remove(getid(data[0]));
                ta_chat.append("Lost the connection. \n");
             } 
	} 
    }

    public ServerWithGUI() 
    {
    	setBackground(Color.LIGHT_GRAY);
        initComponents();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_chat = new javax.swing.JTextArea();
        ta_chat.setForeground(Color.BLACK);
        ta_chat.setBackground(SystemColor.info);
        b_start = new javax.swing.JButton();
        b_start.setFont(new Font("Tahoma", Font.BOLD, 11));
        b_start.setBackground(Color.PINK);
        b_end = new javax.swing.JButton();
        b_end.setFont(new Font("Tahoma", Font.BOLD, 11));
        b_end.setBackground(Color.PINK);
        b_users = new javax.swing.JButton();
        b_users.setFont(new Font("Tahoma", Font.BOLD, 11));
        b_users.setBackground(Color.PINK);
        b_clear = new javax.swing.JButton();
        b_clear.setFont(new Font("Tahoma", Font.BOLD, 11));
        b_clear.setBackground(Color.PINK);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Server");
        setName("server"); // NOI18N
        setResizable(false);
        setLocation(310,100);

        ta_chat.setColumns(20);
        ta_chat.setRows(5);
        jScrollPane1.setViewportView(ta_chat);

        b_start.setText("START");
        b_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_startActionPerformed(evt);
            }
        });

        b_end.setText("CLOSE");
        b_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_endActionPerformed(evt);
            }
        });

        b_users.setText("Online Users");
        b_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_usersActionPerformed(evt);
            }
        });

        b_clear.setText("Clear");
        b_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_start, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_users, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_end, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_start, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_users, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_end, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_endActionPerformed
        try 
        {
           // Thread.sleep(500);                 //4000 milliseconds is five second.
            ta_chat.append("\n");
            ta_chat.append("\n");
            ta_chat.append("\n");
            ta_chat.append("\n");
            tellEveryone("Server: is stopping and all users will be disconnected:Chat");
            ta_chat.append("Server stopping ... \n");
          //  Thread.sleep(500);   
            ta_chat.setText("");
            ta_chat.setText("closing everything ...");
            Thread.sleep(500);
            System.exit(0);
            
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        
        tellEveryone("Server:is stopping and all users will be disconnected.\n:Chat");
        ta_chat.append("Server stopping... \n");
        
        ta_chat.setText("");
    }//GEN-LAST:event_b_endActionPerformed

    private void b_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startActionPerformed
        Thread starter = new Thread(new ServerStart());
        starter.start();
        ta_chat.setEditable(false);
        ta_chat.append(" Server has been started \n Waiting for connection ...");
        changetxtareafontsize(ta_chat) ;
    }//GEN-LAST:event_b_startActionPerformed

    private void b_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_usersActionPerformed
        ta_chat.append("\n Online users : \n");
        if(!users.isEmpty())
        {
            
        
            for (String current_user : users)
            {
            ta_chat.append(current_user + ", With ID = " + getid(current_user) );
            ta_chat.append("\n");
            }    
        }else {
        	ta_chat.append(" No one is online ...");
        }
    }//GEN-LAST:event_b_usersActionPerformed

    private void b_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_clearActionPerformed
        ta_chat.setText("");
    }//GEN-LAST:event_b_clearActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new ServerWithGUI().setVisible(true);
            }
        });
    }
    
    public class ServerStart implements Runnable 
    {
        
		@Override
        public void run() 
        {
//            clientOutputStreams = new PrintWriter[15];
//            users = new ArrayList(); 
           //  int id = 0 ;
              
            try 
            {
                @SuppressWarnings("resource")
				ServerSocket serverSock = new ServerSocket(6000);

                while (true) 
                {
				Socket clientSock = serverSock.accept();
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
//				clientOutputStreams[id]= writer;
                                clientOutputStreams.add(writer);
				Thread listener = new Thread(new ClientHandler(clientSock, writer)); //, id));
				listener.start();
				ta_chat.append("Got a connection. \n");
				              
			//	id  ++ ;
                }
            }
            catch (Exception ex)
            {
                ta_chat.append("Error making a connection. \n");
            }
        }
    }
    
    public int getid(String data){
        
       int userid = users.indexOf(data);
       // JOptionPane.showMessageDialog(null, "the name is : "+data+ ", his ID is : "+userid);
        return userid ;
    }
    
    public void userAdd (String data) 
    {
        String message, s = ": :Connect", done = "Server: :Done", name = data;
        users.add(name); // add everynew user in this array list
        for (String token:users) // advanced for loop to get each name from the the array
        {
            message = (token + s); // message will be his name plus the string connect
            tellEveryone(message);
        }
        tellEveryone(done);
    }
    
    public void userRemove (String data) 
    {
        @SuppressWarnings("unused")
		String message, s = ": :Disconnect", done = "Server: :Done", name = data;
       // JOptionPane.showMessageDialog(null, "I am here in top of userremove method server");
        users.remove(name);
        //clientOutputStreams.remove(getid(data));
      //  JOptionPane.showMessageDialog(null, "I am here +2 in userremove method server");
        for (String UserName:users) 
        {
            message = (UserName + s);
            tellEveryone(message);
        }
        //tellEveryone(done);
    }
    
    public void tellthispersononly(String msg , int personid, String recievername){
        
    if (personid == -1) {
    	
		msg =  "The Server ... : The User is Not Found in the online users your message has not been deliverd  :private";
//		tellthispersononly(Errormsg, getid(data[0]), data[0]);
//		//JOptionPane.showMessageDialog(null, "No Name of the online users matches this name : "+ data[3] +"\n Check the online users correctly ", "This user is not found or not online", JOptionPane.ERROR_MESSAGE);
		personid=getid(recievername);
		try 
        {
            PrintWriter writer =   clientOutputStreams.get(personid);   //(PrintWriter) it.next();
            writer.println(msg);
            writer.flush();
            ta_chat.append("Sending to {"+recievername+"} only this msg : Message not sent because the User not found in the online Users \n");
            ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
        }catch (Exception ex) 
        {
        	ta_chat.append("Error in telling this to "+ recievername +"." +"\n");
        }
		
	} else {

		
    	
        if (clientOutputStreams.get(personid)!= null) {
                
            try 
            {
                PrintWriter writer =    clientOutputStreams.get(personid); //clientOutputStreams[personid];   //(PrintWriter) it.next();
                writer.println(msg);
                writer.flush();
		ta_chat.append("Sending to {"+recievername+"} only this msg :  " + msg + "\n");
                ta_chat.setCaretPosition(ta_chat.getDocument().getLength());
            }catch (Exception ex) 
            {
		ta_chat.append("Error in telling this "+ recievername +"." +"\n");
            }
        }
        else
        {
            ta_chat.append("Error in telling this ... his ID not found OR His outputstream is null "+ recievername +"." +"\n");
        }
    		}
    }
    
    public void changetxtareafontsize(JTextArea txtarea){
    	Font font1 = new Font("SansSerif", Font.BOLD, 12);
    	txtarea.setFont(font1);
    }
    
    public void tellEveryone(String message) 
    {
	 @SuppressWarnings("rawtypes")
	Iterator it = clientOutputStreams.iterator(); // itrator for looping 
        
       while (it.hasNext()) 
       // for(int i=0 ; i<clientOutputStreams.length ;i++)
        {
    //        if (clientOutputStreams[i]!=null) {
                
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();  //clientOutputStreams[i];   //(PrintWriter) it.next();
                writer.println(message);
                //ta_chat.append("Sending to all: " + message + "\n");
                writer.flush();
                ta_chat.setCaretPosition(ta_chat.getDocument().getLength());

            } 
            catch (Exception ex) 
            {
		ta_chat.append("Error telling everyone. \n");
            }
            //}
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_clear;
    private javax.swing.JButton b_end;
    private javax.swing.JButton b_start;
    private javax.swing.JButton b_users;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_chat;
    // End of variables declaration//GEN-END:variables
}
