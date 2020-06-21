package com.anil.marketApp.UI;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.anil.marketApp.UI.KasiyerEkrani;
import javax.swing.JLabel;

/**
 *
 * @author anila
 */
public class TableListener implements MouseListener {

    private JTable transferEdilecekTablo;
    private JLabel label;

    public TableListener(JTable transferEdilecekTablo, JLabel label) {
        this.transferEdilecekTablo = transferEdilecekTablo;
        this.label = label;
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) transferEdilecekTablo.getModel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable source = (JTable) e.getSource();
        Double tutar = 0.0;

        /**
         * çift tıklandığında ordaki veriyi karşıya transfer et
         * eğer aynı ürün karşı da varsa sayısını arttır.
         */
        if (e.getClickCount() == 2) {
            int[] index = source.getSelectedRows(); //seçilen satırların index no'larını tutar
            Object[] row = new Object[4]; //yeni bir satır nesnesi
            int nerede = 0; //karşı da o ürün varsa nerede olduğu index bilgsi

            for (int i = 0; i < index.length; i++) { //Seçilen her satır için bu işlem tekrarlanacaktır
                boolean varMi = false;

                for (int j = 0; j < getTableModel().getRowCount(); j++) {//Karşı da var mı yok mu kontrol
                    if (getTableModel().getValueAt(j, 0) == source.getModel().getValueAt(index[i], 0)) {
                        nerede = j;
                        varMi = true;
                        break;
                    }
                }

                row[0] = source.getModel().getValueAt(index[i], 0); //satıra ürün bilgileri eklenir
                row[1] = source.getModel().getValueAt(index[i], 1);
                row[2] = source.getModel().getValueAt(index[i], 2);

                if (varMi == false) {   //ürün yoksa ürün adeti 1 atanır ve yeni satır oluşturulur
                    row[3] = 1;
                    getTableModel().addRow(row);
                } else { //ürün varsa ürün adeti 1 artırılır
                    Object valueAt = getTableModel().getValueAt(nerede, 3);
                    int adet = Integer.valueOf(valueAt.toString());
                    adet++;
                    getTableModel().setValueAt(adet, nerede, 3);
                }
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
