package ui.agent;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class SchedulePanel extends javax.swing.JPanel {

    JPanel parent;

    public String scheduleId;

    public SchedulePanel(JPanel parent) {
        this.parent = parent;
        initComponents();
        stopsPanel.add(new StopPanel(stopsPanel));
    }

    public String getDays() {
        StringBuilder days = new StringBuilder();

        for (Component c : daysPanel.getComponents()) {
            JToggleButton dayBtn = (JToggleButton) c;
            days.append(dayBtn.isSelected() ? '1' : '0');
        }

        return days.toString();
    }

    public lib.StopDetails[] getStops() {
        Component[] cs = stopsPanel.getComponents();
        lib.StopDetails[] sds = new lib.StopDetails[cs.length];
        for (int i = 0; i < cs.length; i++) {
            sds[i] = ((StopPanel) cs[i]).getStopDetails();
            sds[i].scheduleId = scheduleId;
            sds[i].stopSeq = i + 1;
        }
        return sds;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        daysPanel = new javax.swing.JPanel();
        mon = new javax.swing.JToggleButton();
        tue = new javax.swing.JToggleButton();
        wed = new javax.swing.JToggleButton();
        thu = new javax.swing.JToggleButton();
        fri = new javax.swing.JToggleButton();
        sat = new javax.swing.JToggleButton();
        sun = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        stopsPanel = new javax.swing.JPanel();

        daysPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        mon.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        mon.setText("Mon");
        mon.setMargin(new java.awt.Insets(2, 3, 2, 3));
        daysPanel.add(mon);

        tue.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        tue.setText("Tue");
        tue.setMargin(new java.awt.Insets(2, 3, 2, 3));
        tue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tueActionPerformed(evt);
            }
        });
        daysPanel.add(tue);

        wed.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        wed.setText("Wed");
        wed.setMargin(new java.awt.Insets(2, 3, 2, 3));
        daysPanel.add(wed);

        thu.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        thu.setText("Thu");
        thu.setMargin(new java.awt.Insets(2, 3, 2, 3));
        daysPanel.add(thu);

        fri.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        fri.setText("Fri");
        fri.setMargin(new java.awt.Insets(2, 3, 2, 3));
        daysPanel.add(fri);

        sat.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        sat.setText("Sat");
        sat.setMargin(new java.awt.Insets(2, 3, 2, 3));
        daysPanel.add(sat);

        sun.setFont(new java.awt.Font("Source Code Pro", 0, 12)); // NOI18N
        sun.setText("Sun");
        sun.setMargin(new java.awt.Insets(2, 3, 2, 3));
        daysPanel.add(sun);

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        jButton1.setText("❌");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        stopsPanel.setLayout(new javax.swing.BoxLayout(stopsPanel, javax.swing.BoxLayout.PAGE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(daysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daysPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(stopsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.parent.remove(this);
        this.parent.revalidate();
        this.parent.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel daysPanel;
    private javax.swing.JToggleButton fri;
    private javax.swing.JButton jButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToggleButton mon;
    private javax.swing.JToggleButton sat;
    private javax.swing.JPanel stopsPanel;
    private javax.swing.JToggleButton sun;
    private javax.swing.JToggleButton thu;
    private javax.swing.JToggleButton tue;
    private javax.swing.JToggleButton wed;
    // End of variables declaration//GEN-END:variables
}
