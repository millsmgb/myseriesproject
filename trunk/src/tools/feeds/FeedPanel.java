/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PhotoPanel.java
 *
 * Created on 5 Σεπ 2010, 10:44:29 μμ
 */
package tools.feeds;

import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myComponents.myGUI.MyScrollableFlowPanel;
import tools.DesktopSupport;
import tools.options.Options;

/**
 *
 * @author lordovol
 */
public class FeedPanel extends javax.swing.JPanel implements Runnable {

  public static final long serialVersionUID = 235346345645L;
  private MyScrollableFlowPanel feedPanel;
  private SyndEntryImpl entry;
  private URI uri;
  private boolean isMinimized = true;
  private String title = "";
  private String titleCut = "";
  private String date = "";
  private String content = "";
  private String contentType = "text";
  private String TextContent = "";
  public static final int TITLE_MAX_LENGTH = 30;
  public static final int MINIMIZED = 0;
  public static final int MAXIMIZED = 1;
  public static int min_width;
  public static int max_width;
  public static int min_height = 60;
  public static int max_height = 300;
  public int id = -1;
  private int numberOfColumns = Options.toInt(Options.FEED_COLUMNS);
  public static final int CUT_TITLE_PADDING = 120;

  /** Creates new form PhotoPanel */
  public FeedPanel() {
    initComponents();
  }

  public FeedPanel(MyScrollableFlowPanel feedPanel, SyndEntryImpl entry) {
    this.feedPanel = feedPanel;
    this.entry = entry;
    getWidths(MINIMIZED);
    initComponents();
    ep_content.addHyperlinkListener(new HyperlinkListener() {

      @Override
      public void hyperlinkUpdate(HyperlinkEvent e) {
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
         MyUsefulFunctions.browse(e.getURL());
        }
      }
    });
  }

  private void getWidths(int size) {
    if (size == MINIMIZED) {
      min_width = myseries.MySeries.feedPreviewPanel.getWidth() / numberOfColumns - 20;
      setPreferredSize(new Dimension(FeedPanel.min_width, FeedPanel.min_height));
    } else {
      max_width = myseries.MySeries.feedPreviewPanel.getWidth() - 35;
      setPreferredSize(new Dimension(FeedPanel.max_width, FeedPanel.max_height));
    }
  }

  public void resize(int size) {
    getWidths(size);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    label_title = new javax.swing.JLabel();
    label_date = new javax.swing.JLabel();
    scroll = new javax.swing.JScrollPane();
    ep_content = new javax.swing.JEditorPane();
    bt_link = new javax.swing.JButton();
    bt_max = new javax.swing.JButton();
    label_id = new javax.swing.JLabel();

    setBackground(new java.awt.Color(255, 255, 255));
    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    setPreferredSize(new java.awt.Dimension(360, 160));

    label_title.setBackground(new java.awt.Color(255, 255, 255));
    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD));
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    label_title.setText("jLabel1");
    label_title.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    label_title.setOpaque(true);
    label_title.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        label_titleMouseReleased(evt);
      }
    });

    label_date.setFont(label_date.getFont().deriveFont((label_date.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD, label_date.getFont().getSize()-1));
    label_date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_date.setText("jLabel1");

    scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    ep_content.setEditable(false);
    scroll.setViewportView(ep_content);

    bt_link.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/weblink.png"))); // NOI18N
    bt_link.setToolTipText("Vist webpage");
    bt_link.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    bt_link.setBorderPainted(false);
    bt_link.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bt_link.setIconTextGap(0);
    bt_link.setMargin(new java.awt.Insets(0, 0, 0, 0));
    bt_link.setOpaque(false);
    bt_link.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_linkActionPerformed(evt);
      }
    });

    bt_max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maximize.png"))); // NOI18N
    bt_max.setToolTipText("Vist webpage");
    bt_max.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    bt_max.setBorderPainted(false);
    bt_max.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    bt_max.setIconTextGap(0);
    bt_max.setMargin(new java.awt.Insets(0, 0, 0, 0));
    bt_max.setOpaque(false);
    bt_max.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_maxActionPerformed(evt);
      }
    });

    label_id.setText("jLabel1");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(scroll, javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(label_date, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addComponent(label_id)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_link, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_max, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(13, 13, 13)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_id)
          .addComponent(label_title)
          .addComponent(bt_max)
          .addComponent(bt_link))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(label_date, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void bt_linkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_linkActionPerformed
    MyUsefulFunctions.browse(uri);
    
  }//GEN-LAST:event_bt_linkActionPerformed

  private void bt_maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_maxActionPerformed
    if (isMinimized) {
      resize(MAXIMIZED);
      bt_max.setIcon(new ImageIcon(getClass().getResource("/images/minimize.png")));
      label_title.setText(this.title);
      scroll.setVisible(true);
      if (id % numberOfColumns != 0 && numberOfColumns > 1) {
        feedPanel.remove(this);
        feedPanel.add(this, id - id % numberOfColumns);
      }
      showHtml();
      isMinimized = false;
    } else {
      resize(MINIMIZED);
      bt_max.setIcon(new ImageIcon(getClass().getResource("/images/maximize.png")));
      scroll.setVisible(false);
      label_title.setText(this.titleCut);
      if (id % numberOfColumns != 0 && numberOfColumns > 1) {
        feedPanel.remove(this);
        feedPanel.add(this, id);
      }
      showText();
      isMinimized = true;
    }

    revalidate();
    repaint();
    feedPanel.validate();
    feedPanel.repaint();
  }//GEN-LAST:event_bt_maxActionPerformed

  private void label_titleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_titleMouseReleased
    bt_maxActionPerformed(null);
  }//GEN-LAST:event_label_titleMouseReleased

  public void selectFeed() {
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton bt_link;
  private javax.swing.JButton bt_max;
  private javax.swing.JEditorPane ep_content;
  private javax.swing.JLabel label_date;
  private javax.swing.JLabel label_id;
  private javax.swing.JLabel label_title;
  private javax.swing.JScrollPane scroll;
  // End of variables declaration//GEN-END:variables

  @Override
  public void run() {
    getData();
    label_title.setText(this.titleCut);
    label_date.setText(date);
    showText();
    scroll.setVisible(false);
    resize(MINIMIZED);
    id = feedPanel.getComponentCount();
    feedPanel.add(this);
    label_id.setText("" + (id + 1));
    feedPanel.revalidate();
    feedPanel.repaint();
  }

  private void getData() {
    title = entry.getTitle();
    titleCut = getTitleCut();
    date = getDate();
    content = getContent();
    TextContent = getTextContent();
    contentType = getContentType();
    uri = getUri();
  }

  private String getDate() {
    DateFormat df = new SimpleDateFormat(Options.toString(Options.DATE_FORMAT));
    if (entry.getPublishedDate() != null) {
      return df.format(entry.getPublishedDate());
    } else if (entry.getUpdatedDate() != null) {
      return df.format(entry.getUpdatedDate());
    }
    return "";

  }

  private String getContent() {
    if (entry.getDescription() != null) {
      return entry.getDescription().getValue();
    } else {
      List con = entry.getContents();
      if (con.size() > 0) {
        SyndContentImpl synd = (SyndContentImpl) con.get(0);
        return synd.getValue();
      }
    }
    return "";
  }

  private String getContentType() {
    if (entry.getDescription() != null) {
      return entry.getDescription().getType();
    } else {
      List con = entry.getContents();
      if (con.size() > 0) {
        SyndContentImpl synd = (SyndContentImpl) con.get(0);
        return synd.getType().indexOf("html") > -1 ? "text/html" : "text";
      }
    }
    return "text";
  }

  private URI getUri() {
    try {
      if (MyUsefulFunctions.isLink(entry.getLink())) {
        return new URL(entry.getLink()).toURI();
      } else if (MyUsefulFunctions.isLink(entry.getUri())) {
        return new URL(entry.getUri()).toURI();
      } else if (!entry.getLinks().isEmpty()) {
        String link = (String) entry.getLinks().get(0);
        return new URL(link).toURI();
      }
      bt_link.setVisible(false);
      return null;
    } catch (Exception ex) {
      bt_link.setVisible(false);
      return null;
    }

  }

  private String getTextContent() {
    return content.toString().replaceAll("(\\<img.*?>)|(\\<a.*?>)|(\\</a>)", "");

  }

  private void showHtml() {
    ep_content.setContentType(contentType);
    ep_content.setText(content);
    setCursorPosition();
  }

  private void showText() {
    ep_content.setContentType(contentType);
    ep_content.setText(TextContent);
    setCursorPosition();
  }

  private String getTitleCut() {
    String cut = "";
    FontMetrics metrics = label_title.getFontMetrics(label_title.getFont());
    String[] titleArr = title.split(" ", -1);
    for (int i = 0; i < titleArr.length; i++) {
      String t = titleArr[i];
      int w = metrics.stringWidth(cut + t);
      if (w < min_width - CUT_TITLE_PADDING) {
        cut += t + " ";
      }
    }
    return cut.trim().length() == title.trim().length() ? cut : cut + "...";
  }

  private void setCursorPosition() {
    ep_content.setCaretPosition(0);
  }
}
