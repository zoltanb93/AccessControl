package my.accesscontrol;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame implements EditorFrameClosed {
    
    ItemListener iL;

    public Main() {
        initComponents();
        initMainForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        houseSelectorCB = new javax.swing.JComboBox<>();
        addBTN = new javax.swing.JButton();
        removeBTN = new javax.swing.JButton();
        logBTN = new javax.swing.JButton();
        houseNumberTB = new javax.swing.JTextField();
        codeTB = new javax.swing.JTextField();
        ownerTB = new javax.swing.JTextField();
        houseNumberLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        houseSelectorLabel2 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        updateController = new javax.swing.JButton();
        editBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Access Control");
        setPreferredSize(new java.awt.Dimension(361, 350));
        setResizable(false);

        addBTN.setText("Hozzáadás");
        addBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBTNMouseClicked(evt);
            }
        });

        removeBTN.setText("Eltávolítás");
        removeBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeBTNMouseClicked(evt);
            }
        });

        logBTN.setText("Napló");

        houseNumberTB.setEditable(false);
        houseNumberTB.setText("test");

        codeTB.setEditable(false);

        ownerTB.setEditable(false);
        ownerTB.setToolTipText("");

        houseNumberLabel.setText("Házszám");

        codeLabel.setText("Kód");

        ownerLabel.setText("Tulaj");

        houseSelectorLabel2.setText("Házszám-választó");

        titleLabel.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Version 0.1");

        updateController.setText("MCU frissítés");

        editBTN.setText("Módosítás");
        editBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBTNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(houseSelectorLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removeBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(houseSelectorCB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codeLabel)
                            .addComponent(houseNumberLabel)
                            .addComponent(ownerLabel)
                            .addComponent(houseNumberTB)
                            .addComponent(codeTB)
                            .addComponent(ownerTB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(updateController)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(houseNumberLabel)
                            .addComponent(houseSelectorLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(houseNumberTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(houseSelectorCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ownerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ownerTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editBTN)
                        .addGap(18, 18, 18)
                        .addComponent(addBTN)
                        .addGap(18, 18, 18)
                        .addComponent(removeBTN)
                        .addGap(18, 18, 18)
                        .addComponent(logBTN)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(updateController)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBTNMouseClicked
        AdderDialog.startAdderDialog(this);
    }//GEN-LAST:event_addBTNMouseClicked

    private void editBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBTNMouseClicked
        EditerDialog.startEditerDialog(houseSelectorCB.getSelectedIndex(), this);
    }//GEN-LAST:event_editBTNMouseClicked

    private void removeBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeBTNMouseClicked
        Object[] options = {"Nem", "Igen"};
        int n = JOptionPane.showOptionDialog(null, "Biztosan törölni akarja az kiválasztott házzal kapcsolatos bejegyzést?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, titleLabel);
        
        if(n == 1) {
            House.removeFromList(houseSelectorCB.getSelectedIndex());
        }
        
        updateCB();
    }//GEN-LAST:event_removeBTNMouseClicked

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBTN;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JTextField codeTB;
    private javax.swing.JButton editBTN;
    private javax.swing.JLabel houseNumberLabel;
    private javax.swing.JTextField houseNumberTB;
    private javax.swing.JComboBox<String> houseSelectorCB;
    private javax.swing.JLabel houseSelectorLabel2;
    private javax.swing.JButton logBTN;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JTextField ownerTB;
    private javax.swing.JButton removeBTN;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateController;
    // End of variables declaration//GEN-END:variables

    //Saját fv-k
    
    private void houseSelectorCBItemStateChanged(ItemEvent evt) {
        updateTBs();
    }
    
    
    private void updateCB() {      

        if (houseSelectorCB.getItemCount() > 0) {
            houseSelectorCB.removeItemListener(iL);
            houseSelectorCB.removeAllItems();
            houseSelectorCB.addItemListener(iL);
        }

        List<House> houseList = House.getHouseList();

        for (House house : houseList) {
            houseSelectorCB.addItem(house.getResidents());
        }

        updateTBs();

    }

    private void updateTBs() {
        int index = houseSelectorCB.getSelectedIndex();
        houseNumberTB.setText(Integer.toString(House.getHouseList().get(index).getHouseNumber()));
        codeTB.setText(Integer.toString(House.getHouseList().get(index).getCode()));
        ownerTB.setText(House.getHouseList().get(index).getResidents());
    }

    private void initMainForm() {
        
        iL = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                houseSelectorCBItemStateChanged(evt);
            }
        };
        
        houseSelectorCB.addItemListener(iL);

        
        DataHandler.getDataFromController();
        updateCB();
    }

    @Override
    public void onFrameClosed() {
        updateCB();
    }

}
