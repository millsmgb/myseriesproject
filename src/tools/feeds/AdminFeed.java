/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminFeed.java
 *
 * Created on 31 Οκτ 2010, 1:14:41 μμ
 */
package tools.feeds;

import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.RequiredValidator;
import com.googlecode.svalidators.validators.SValidator;
import com.googlecode.svalidators.validators.UrlValidator;
import database.FeedsRecord;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import myComponents.MyMessages;
import myComponents.myGUI.MyDraggable;

/**
 *
 * @author lordovol
 */
public class AdminFeed extends MyDraggable {

  public static final long serialVersionUID = 23525522525L;
  public boolean isFeedSaved = false;
  private FeedsRecord feed;

  /** Creates new form AdminFeed */
  public AdminFeed() {
    this(null);
  }

  public AdminFeed(FeedsRecord f) {
    initComponents();
    if (f == null) {
      this.feed = new FeedsRecord();
      label_title.setText("Add a new rss feed");
      tf_title.setEnabled(false);
      tf_title.setVisible(false);
      label_feedtitle.setVisible(false);
      tf_title.removeValidator(SValidator.REQUIRED);
    } else {
      this.feed = f;
      label_title.setText("Edit " + f.getTitle());
      tf_url.setText(f.getUrl());
      tf_title.setText(f.getTitle());
    }
    setLocationRelativeTo(null);
    setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    label_title = new javax.swing.JLabel();
    bt_ok = new javax.swing.JButton();
    bt_cancel = new javax.swing.JButton();
    label_url = new javax.swing.JLabel();
    tf_url = new com.googlecode.svalidators.formcomponents.STextField(new UrlValidator());
    label_feedtitle = new javax.swing.JLabel();
    tf_title = new com.googlecode.svalidators.formcomponents.STextField(new RequiredValidator());

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_title.setText("title");

    bt_ok.setText("OK");
    bt_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_okActionPerformed(evt);
      }
    });

    bt_cancel.setText("Cancel");
    bt_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_cancelActionPerformed(evt);
      }
    });

    label_url.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_url.setText("Feed URL :");

    tf_url.setName("Feed url"); // NOI18N

    label_feedtitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_feedtitle.setText("Feed Title :");

    tf_title.setName("Feed url"); // NOI18N

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                  .addComponent(label_feedtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(tf_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                  .addComponent(label_url, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(tf_url, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(bt_ok)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_cancel)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(tf_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tf_title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(label_feedtitle)))
          .addComponent(label_url))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(bt_cancel)
          .addComponent(bt_ok))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
    ValidationGroup val = new ValidationGroup();
    val.addComponent(tf_url);
    if (tf_title.isEnabled()) {
      val.addComponent(tf_title);
    }
    if (val.validate()) {
      String url = tf_url.getText().trim();
      feed.setUrl(url);
      feed.setTitle(tf_title.getText().trim());
      try {
        int id = feed.save();
        if(feed.getFeed_ID() ==0){
          feed.setFeed_ID(id);
        }
        isFeedSaved = true;
        FeedUpdater fu = new FeedUpdater(myseries.MySeries.feedTree, feed);
        fu.run();
        FeedReader fr = new FeedReader(myseries.MySeries.feedTree, feed);
        myseries.MySeries.feedTree.populate(feed.getFeed_ID());
        dispose();
      } catch (SQLException ex) {
        myseries.MySeries.logger.log(Level.SEVERE, null, ex);
        MyMessages.error("Feed Saving", "An error occured and the feed is not saved");
      }

    } else {
      val.errorMessage(true);
    }

  }//GEN-LAST:event_bt_okActionPerformed

  private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
    dispose();
  }//GEN-LAST:event_bt_cancelActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bt_cancel;
  private javax.swing.JButton bt_ok;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel label_feedtitle;
  private javax.swing.JLabel label_title;
  private javax.swing.JLabel label_url;
  private com.googlecode.svalidators.formcomponents.STextField tf_title;
  private com.googlecode.svalidators.formcomponents.STextField tf_url;
  // End of variables declaration//GEN-END:variables
}
