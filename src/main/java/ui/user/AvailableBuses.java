package ui.user;

import javax.swing.JFrame;
import lib.BusDetails;

public class AvailableBuses extends javax.swing.JFrame {

    String source;
    String dest;
    String day;
    JFrame prevFrame;

    public AvailableBuses(String source, String dest, String day, JFrame prevFrame) {
        this.source = source;
        this.dest = dest;
        this.day = day;
        this.prevFrame = prevFrame;
        initComponents();

//        resultsPanel.add(new BusSearchPanel(new BusDetails("hello",
//                "122",
//                "20",
//                "120",
//                new lib.ScheduleDetails("123", "1100110", "120"),
//                new lib.StopDetails[]{
//                    new lib.StopDetails("123", "Katra", 1, "8:00"),
//                    new lib.StopDetails("123", "Panthal", 3, "8:15")
//                },
//                12,
//                ""
//        )));
//        resultsPanel.add(new BusSearchPanel(new BusDetails("hello",
//                "122",
//                "20",
//                "120",
//                new lib.ScheduleDetails("123", "1100110", "120"),
//                new lib.StopDetails[]{
//                    new lib.StopDetails("123", "Katra", 1, "8:00"),
//                    new lib.StopDetails("123", "Panthal", 3, "8:15")
//                },
//                12,
//                ""
//        )));
//        resultsPanel.add(new BusSearchPanel(new BusDetails("hello",
//                "122",
//                "20",
//                "120",
//                new lib.ScheduleDetails("123", "1100110", "120"),
//                new lib.StopDetails[]{
//                    new lib.StopDetails("123", "Katra", 1, "8:00"),
//                    new lib.StopDetails("123", "Panthal", 3, "8:15")
//                },
//                12,
//                ""
//        )));
//        resultsPanel.add(new BusSearchPanel(new BusDetails()));
        try {
            BusDetails[] res = new services.Api().searchBuses(source, dest, day);
            for (BusDetails x : res) {
                resultsPanel.add(new BusSearchPanel(x));
            }
        } catch (Exception err) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error searchig for buses!" + err);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        destLB = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        sourceLB = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        resultsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel3.setFont(new java.awt.Font("Rockwell", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("  AVAILABLE BUSES");

        destLB.setText(this.dest);

        jLabel13.setText("→");

        sourceLB.setText(this.source);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sourceLB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destLB)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceLB)
                    .addComponent(destLB)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        backButton.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        backButton.setText("← BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addGap(315, 315, 315)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(164, 164, 164)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 940, 50));

        resultsPanel.setBackground(new java.awt.Color(0, 0, 0,80));
        resultsPanel.setLayout(new javax.swing.BoxLayout(resultsPanel, javax.swing.BoxLayout.PAGE_AXIS));
        getContentPane().add(resultsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 940, 400));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pngtree-journey-concept-road-image_15867312.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 480));

        setSize(new java.awt.Dimension(974, 487));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        this.prevFrame.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel destLB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JLabel sourceLB;
    // End of variables declaration//GEN-END:variables
}
