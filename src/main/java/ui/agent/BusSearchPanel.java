package ui.agent;

public class BusSearchPanel extends javax.swing.JPanel {

    lib.BusDetails busDetails;

    public BusSearchPanel(lib.BusDetails busDetails) {
        this.busDetails = busDetails;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busNameLB = new javax.swing.JLabel();
        busNumLB = new javax.swing.JLabel();
        daysLB = new javax.swing.JLabel();
        sourceLB = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        destLB = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        stopsLB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        standLB = new javax.swing.JLabel();
        sitLB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        busNameLB.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        busNameLB.setText(busDetails.name);

        busNumLB.setText(busDetails.number);

        daysLB.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        daysLB.setText(this.busDetails.schedule.days);

        sourceLB.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        sourceLB.setText(this.busDetails.stops[0].arrival);

        jLabel14.setText("→");

        destLB.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        destLB.setText(this.busDetails.stops[busDetails.stops.length - 1].arrival);

        jLabel15.setText("•");

        stopsLB.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        stopsLB.setText(this.busDetails.interimStops + "");

        jLabel9.setText("🧍: Rs");

        jLabel10.setText("🪑 : Rs");

        standLB.setText(this.busDetails.standingFare);

        sitLB.setText(this.busDetails.sittingFare);

        jLabel1.setText("stops");

        jLabel2.setText(this.busDetails.stops[0].stopName);

        jLabel3.setText(this.busDetails.stops[busDetails.stops.length - 1].stopName);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(busNameLB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(busNumLB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(daysLB))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sourceLB)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel14))
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(destLB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stopsLB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 564, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sitLB)
                        .addGap(169, 169, 169))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(standLB)
                        .addGap(167, 167, 167))))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(standLB)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(busNameLB)
                            .addComponent(daysLB)
                            .addComponent(busNumLB))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sourceLB)
                            .addComponent(jLabel14)
                            .addComponent(destLB)
                            .addComponent(jLabel15)
                            .addComponent(stopsLB)
                            .addComponent(jLabel10)
                            .addComponent(sitLB)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel busNameLB;
    private javax.swing.JLabel busNumLB;
    private javax.swing.JLabel daysLB;
    private javax.swing.JLabel destLB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel sitLB;
    private javax.swing.JLabel sourceLB;
    private javax.swing.JLabel standLB;
    private javax.swing.JLabel stopsLB;
    // End of variables declaration//GEN-END:variables
}
