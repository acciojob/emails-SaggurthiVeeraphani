package com.driver;

import java.util.*;

public class Gmail extends Email {
    HashMap<String,Node> hm = new HashMap<>;
    Stack<Node> st = new Stack<>();
    Queue<Node> q = new LinkedList<>();
    Queue<Node> trash = new LinkedList<>();


    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

    public Gmail(String emailId, int inboxCapacity) {
       super(emailId);
       this.inboxCapacity = inboxCapacity;
    }

    public Gmail(String emailId) {
        super(emailId);
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
       if(hm.size()>=inboxCapacity){
          Node node = q.poll();
          trash.add(node);
          String s = node.message;
          hm.remove(s);
       }
       if(hm.size()<inboxCapacity){
         if(hm.getOrDefault(message,null)==null){
             Node node = new Node(date,sender,message);
             hm.put(message,node);
             st.push(node);
             q.add(node);
         }
      }
     }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
       if(hm.getOrDefault(message,null)!=null){
           Node node = hm.get(message);
           trash.add(node);
           hm.remove(message);
       }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
      if(hm.size()==0){
          return null;
      }
      else{
          Node node = st.peek();
          while(!st.isEmpty() && hm.getOrDefault(node.message,null)==null){
              st.pop();
              node = st.peek()
          }
          return node.message;
      }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(hm.size()==0){
            return null;
        }
        else{
            Node node = q.peek();
            while(!q.isEmpty() && hm.getOrDefault(node.message,null)==null){
                q.poll();
                node = q.peek();
            }
            return node.message;
        }

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
      int count = 0;
        if(hm.size()!=0){
          for(String s : hm.keySet()){
              Node node = hm.get(s);
              if(node.date.after(start) && node.date.before(end){
                  count++;
              }
          }
      }
        return count;
    }

    public int getInboxSize(){
        return hm.size();

    }

    public int getTrashSize(){
        return trash.size();

    }

    public void emptyTrash(){
        trash.clear();

    }

    public int getInboxCapacity() {
        return inboxCapacity;
    }
}
public class Node{
    Date date;
    String sender;
    String message;
    Node(Date date,String sender,String message){
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}
