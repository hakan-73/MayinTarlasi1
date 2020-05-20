/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayintarlasi;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Hakan
 */
public class MayinTarlasi implements MouseListener{
    JFrame frame;
    Buton[][] board=new Buton [10][10];
    
    public MayinTarlasi(){
        frame =new JFrame("Mayın Tarlası");
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10,10));
        
        for (int row = 0;row  < board.length;row ++) {
            for (int col = 0; col < board[0].length; col++) {
                Buton b=new Buton(row,col);
                frame.add(b);
               b.addMouseListener(this);
                board[row][col]=b;
                
            }
        }
        mayinUret();
    yazdir();
    
        frame.setVisible(true);
    }
    public void mayinUret(){
        int i=0;
        while(i<10){
            int randRow=(int) (Math.random()*board.length);
            int randCol=(int) (Math.random()*board[0].length);
            while(board[randRow][randCol].isMayin()){
             randRow=(int) (Math.random()*board.length);
             randCol=(int) (Math.random()*board[0].length);
            }
            board[randRow][randCol].setMayin(true);
            i++;
        }
    }
    public void yazdir(){
    for (int row = 0;row  < board.length;row ++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isMayin()) {
                    board[row][col].setIcon(new ImageIcon("ikon/mayin.png"));
                }else{
                    board[row][col].setText(board[row][col].getCount()+"");
                    board[row][col].setEnabled(false);
                }
            }
        }
    }

    public void updateCount(){
     for (int row = 0;row  < board.length;row ++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col].isBayrak()) {
                    sayma(row,col);
                }
                }
            }
        }
    public void sayma(int row,int col){
        for (int i = row-1  ; i <row+1; i++) {
            for (int j = col-1; j < col+1; j++) {
                try {
                      int deger=board[i][j].getCount();
                board[i][j].setCount(++deger);
                } catch (Exception e) {
                }
            }
        }
    }
    public void ac(int row,int col){
        if (row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col].getText().length()>0 || board[row][col].isEnabled()==false) {
            return;
           }else if(board[row][col].getCount()!=0){
            board[row][col].setText(board[row][col].getCount()+"");
            board[row][col].setEnabled(false);
        }else{
           board[row][col].setEnabled(false);
            ac(row-1, col);
            ac(row+1, col);
            ac(row, col-1);
            ac(row, col+1);
           }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       Buton b=(Buton) e.getComponent();
        if (e.getButton()==1) {
            if (b.isMayin()) {
            JOptionPane.showMessageDialog(frame, "Mayına Bastınız.");
            yazdir();
            }else{
                ac(b.getRow(), b.getCol());
            }
            System.out.println("sol tık");
        }else if (e.getButton()==3) {
            System.out.println("sağ tık");
            if (!b.isBayrak()) {
                b.setIcon(new ImageIcon("ikon/bayrak.png"));
                b.setBayrak(true);
            }else{
                b.setIcon(null);
                b.setBayrak(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
      
    }
    
}
