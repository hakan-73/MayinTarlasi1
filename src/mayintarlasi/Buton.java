/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mayintarlasi;

import javax.swing.JButton;

/**
 *
 * @author Hakan
 */
public class Buton extends JButton {
    private int row,col,count;
    private boolean mayin,bayrak;

    public Buton(int row, int col) {
        this.row = row;
        this.col = col;
        this.count = 0;
        this.mayin = false;
        this.bayrak = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getCount() {
        return count;
    }

    public boolean isMayin() {
        return mayin;
    }

    public boolean isBayrak() {
        return bayrak;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setMayin(boolean mayin) {
        this.mayin = mayin;
    }

    public void setBayrak(boolean bayrak) {
        this.bayrak = bayrak;
    }
    
    
}
