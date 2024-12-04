package ui.user;

public class TicketSummaryPanel extends javax.swing.JPanel {

    lib.TicketDetails ticketDetails;

    public TicketSummaryPanel(lib.TicketDetails ticketDetails) {
        this.ticketDetails = ticketDetails;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busNumLB = new javax.swing.JLabel();
        sourceLB = new javax.swing.JLabel();
        destLB = new javax.swing.JLabel();
        seatTypeLB = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        busNumLB.setText(this.ticketDetails.busNumber);

        sourceLB.setText(this.ticketDetails.fromStop);

        destLB.setText(this.ticketDetails.toStop);

        seatTypeLB.setText(this.ticketDetails.seatType);

        jButton1.setText("Cancel Trip");

        jButton2.setText("View Ticket");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(busNumLB)
                .addGap(121, 121, 121)
                .addComponent(sourceLB)
                .addGap(117, 117, 117)
                .addComponent(destLB)
                .addGap(114, 114, 114)
                .addComponent(seatTypeLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busNumLB)
                    .addComponent(sourceLB)
                    .addComponent(destLB)
                    .addComponent(seatTypeLB)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        javax.swing.SwingUtilities.invokeLater(() -> new TicketView(this.ticketDetails).setVisible(true));

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel busNumLB;
    private javax.swing.JLabel destLB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel seatTypeLB;
    private javax.swing.JLabel sourceLB;
    // End of variables declaration//GEN-END:variables
}
