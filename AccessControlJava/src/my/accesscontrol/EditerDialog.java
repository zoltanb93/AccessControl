package my.accesscontrol;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditerDialog extends javax.swing.JDialog {
    
    int currentIndex;
    String originalHouseNumber;
    Main mainFrame;

    public EditerDialog(java.awt.Frame parent, boolean modal, int index, Main mainFrame) {
        super(parent, modal);
        initComponents();
        
        this.currentIndex = index;
        this.mainFrame = mainFrame;
        updateEditerForm();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 32767));
        houseNumberLabel = new javax.swing.JLabel();
        codeLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        houseNumberTB = new javax.swing.JTextField();
        codeTB = new javax.swing.JTextField();
        ownerTB = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módosítás");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        houseNumberLabel.setText("Házszám");

        codeLabel.setText("Kód");

        ownerLabel.setText("Tulajdonos");

        okButton.setText("OK");
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(houseNumberLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ownerTB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(codeTB, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(houseNumberTB, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(codeLabel)
                            .addComponent(ownerLabel))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(houseNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(codeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codeTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ownerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ownerTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(okButton)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseClicked
        HouseValidator v = new HouseValidator();
        
        boolean houseNumberMatched = v.isHouseNumberCorrect(houseNumberTB.getText());
        boolean codeMatched = v.isCodePatternCorrect(codeTB.getText());
        boolean ownerMatched = v.isOwnerPatternCorrect(ownerTB.getText());
        boolean notDuplicate = false;
        
        //Nem fogja tudni a felhasználó, hogy a házszám duplikált vagy üresen hagyta.
        try {
            notDuplicate = v.notDuplicate(houseNumberTB.getText());
        } catch (Exception e) {}
        
        if(houseNumberTB.getText().equals(originalHouseNumber)) {
            notDuplicate = true;
        }

        if (houseNumberMatched && codeMatched && ownerMatched && notDuplicate) {
            House h = House.getHouseList().get(currentIndex);
            
            h.setHouseNumber(Integer.parseInt(houseNumberTB.getText()));
            h.setCode(Integer.parseInt(codeTB.getText()));
            h.setResidents(ownerTB.getText());
            
            this.dispose();
        } else {
            String errorMessages = new String();
            int errorLineCount = 0;

            if (!houseNumberMatched) {
                errorMessages += "A házszámnak 1 és 99 közé kell esnie!";
                errorLineCount++;
            }
            if (!codeMatched) {
                if(errorLineCount > 0) errorMessages += "\n";
                errorMessages += "A belépőkódnak 4 számjegyűnek kell lennie!";
                errorLineCount++;
            }
            if (!ownerMatched) {
                if(errorLineCount > 0) errorMessages += "\n";
                errorMessages += "A tulajodonos mező helyes formátuma: Vezetéknév + Keresztnév!";
                errorLineCount++;
            }
            if (!notDuplicate) {
                if(errorLineCount > 0) errorMessages += "\n";
                errorMessages += "Két azonos házszám nem szerepelhet!";
                errorLineCount++;
            }

            JOptionPane.showMessageDialog(null, errorMessages);
        }
        
    }//GEN-LAST:event_okButtonMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        mainFrame.onFrameClosed();
    }//GEN-LAST:event_formWindowClosed

    public static void startEditerDialog(int index, Main mainFrame) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(EditerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditerDialog dialog = new EditerDialog(new javax.swing.JFrame(), true, index, mainFrame);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel codeLabel;
    private javax.swing.JTextField codeTB;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel houseNumberLabel;
    private javax.swing.JTextField houseNumberTB;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JTextField ownerTB;
    // End of variables declaration//GEN-END:variables

    public void updateEditerForm() {
        houseNumberTB.setText(Integer.toString(House.getHouseList().get(currentIndex).getHouseNumber()));
        codeTB.setText(Integer.toString(House.getHouseList().get(currentIndex).getCode()));
        ownerTB.setText(House.getHouseList().get(currentIndex).getResidents());
        
        originalHouseNumber = houseNumberTB.getText();
    }
}
