package dtu.str.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

public class MainGUI extends javax.swing.JFrame {

    private static final String TITLE = "Tóm tắt trích chọn theo TextRank";

    public MainGUI() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(TITLE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(false);        

//        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.txtRawText.setLineWrap(true);
        this.txtRawText.setWrapStyleWord(true);
        this.txtResult.setLineWrap(true);
        this.txtResult.setWrapStyleWord(true);
        this.sldPercent.setValue(50);
        String fileName = "resources/caykhe.txt";
        addText(fileName);
       
        setValueSlideText();
    }

    private void addText(String fileName) {
        String text = "";
        String line;
        try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
            while ((line = buff.readLine()) != null) {
                text += line + " ";
            }
            text = text.trim();
            if (0 < text.length()) {
                btnSummary.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "File rỗng !");
            }
            txtRawText.setText(reorderSentence(text));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "không thể mở file!");
            btnSummary.setEnabled(false);
            btnVisualize.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFileName = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnSummary = new javax.swing.JButton();
        btnVisualize = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRawText = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        txtPercent = new javax.swing.JLabel();
        sldPercent = new javax.swing.JSlider();
        txtNumNote = new javax.swing.JLabel();
        sldNumber = new javax.swing.JSlider();
        btnTextRank = new javax.swing.JButton();
        cbAllNote = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel1.setText("Chọn file:");

        txtFileName.setEditable(false);
        txtFileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFileNameActionPerformed(evt);
            }
        });

        btnBrowse.setText("Chọn file");
        btnBrowse.setToolTipText("");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnSummary.setText("Tóm tắt");
        btnSummary.setEnabled(false);
        btnSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummaryActionPerformed(evt);
            }
        });

        btnVisualize.setText("Xem đồ thị");
        btnVisualize.setEnabled(false);
        btnVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizeActionPerformed(evt);
            }
        });

        txtRawText.setColumns(20);
        txtRawText.setRows(5);
        txtRawText.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtRawText);
        txtRawText.getAccessibleContext().setAccessibleName("Browse");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPercent.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPercent.setText("Kích thước rút gọn: 50%");

        sldPercent.setMinimum(1);
        sldPercent.setValue(20);
        sldPercent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sldPercent.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldPercentStateChanged(evt);
            }
        });

        txtNumNote.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNumNote.setText("Số node đồ thị: 5");

        sldNumber.setMaximum(12);
        sldNumber.setMinimum(2);
        sldNumber.setMinorTickSpacing(1);
        sldNumber.setValue(7);
        sldNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sldNumber.setEnabled(false);
        sldNumber.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldNumberStateChanged(evt);
            }
        });

        btnTextRank.setText("Bảng TextRank");
        btnTextRank.setToolTipText("");
        btnTextRank.setEnabled(false);
        btnTextRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTextRankActionPerformed(evt);
            }
        });

        cbAllNote.setText("Hiển thị tất cả");
        cbAllNote.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPercent)
                .addGap(30, 30, 30)
                .addComponent(sldPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumNote)
                .addGap(18, 18, 18)
                .addComponent(sldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbAllNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTextRank)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTextRank)
                        .addComponent(cbAllNote))
                    .addComponent(sldNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumNote)
                    .addComponent(sldPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPercent))
                .addContainerGap())
        );

        btnTextRank.getAccessibleContext().setAccessibleName("Bảng Text rank");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFileName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse)
                    .addComponent(btnSummary)
                    .addComponent(btnVisualize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtResult.setEditable(false);
        txtResult.setColumns(20);
        txtResult.setForeground(new java.awt.Color(255, 0, 0));
        txtResult.setRows(5);
        jScrollPane2.setViewportView(txtResult);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSave.setText("Lưu văn bản tóm tắt");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Thoát");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFileNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFileNameActionPerformed

    private JFileChooser chooser;
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        if (chooser == null) {
            chooser = new JFileChooser();
        }
        chooser.setDialogTitle("Chọn file tóm tắt");
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String fileName = chooser.getSelectedFile().getAbsolutePath();
            txtFileName.setText(fileName);
            addText(fileName);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummaryActionPerformed
        controller.summray(txtRawText.getText());
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnSummaryActionPerformed

    private void btnVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizeActionPerformed
        controller.startVisualize(sldNumber.getValue());
    }//GEN-LAST:event_btnVisualizeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed


    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (chooser == null) {
            chooser = new JFileChooser();
        }
        chooser.setDialogTitle("Lưu văn bản tóm tắt");

        int userSelection = chooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            FileWriter writer = null;
            try {
                File fileToSave = chooser.getSelectedFile();
                writer = new FileWriter(fileToSave);
                writer.write(txtResult.getText());                
                writer.close();
                JOptionPane.showMessageDialog(this, "Lưu file thành công");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Không thể lưu file");
            } 
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void sldPercentStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldPercentStateChanged
        setValueSlideText();
    }//GEN-LAST:event_sldPercentStateChanged

    private void sldNumberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldNumberStateChanged
        setValueSlideText();
    }//GEN-LAST:event_sldNumberStateChanged

    private void btnTextRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTextRankActionPerformed
        controller.showTextRankTable();
    }//GEN-LAST:event_btnTextRankActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSummary;
    private javax.swing.JButton btnTextRank;
    private javax.swing.JButton btnVisualize;
    private javax.swing.JCheckBox cbAllNote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider sldNumber;
    private javax.swing.JSlider sldPercent;
    private javax.swing.JTextField txtFileName;
    private javax.swing.JLabel txtNumNote;
    private javax.swing.JLabel txtPercent;
    private javax.swing.JTextArea txtRawText;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables

    private Controller controller;

    void setController(Controller aThis) {
        this.controller = aThis;
    }

    private String reorderSentence(String text) {
//        SentenceDetectorME sentenceDetector = SentenceDetector.getSentenceDetector();
//        String sentences[] = sentenceDetector.sentDetect(text);
//        System.out.println("Number of Sentence: " + sentences.length);
//        StringJoiner joiner = new StringJoiner("\n");
//        for (String sent : sentences) {
//            joiner.add(sent);
//        }
//        return joiner.toString();
//        StringTokenizer tokenizer = new StringTokenizer(text);
//        StringBuilder builder = new StringBuilder();
//        int length = 0;
//        while (tokenizer.hasMoreTokens()) {
//            String nextToken = tokenizer.nextToken();
//            length += nextToken.length() + 1;
//            builder.append(nextToken).append(" ");
//            if ( 120 < length) {
//                builder.append("\n");
//                length = 0;
//            } 
//        }
        return text;
    }

    void showResult(String result) {
        txtResult.setText(reorderSentence(result));
        btnVisualize.setEnabled(true);
        
        cbAllNote.setEnabled(true);
        sldNumber.setEnabled(true);
        btnTextRank.setEnabled(true);
    }
    
    private String fillText(String src, int length){
        String buff = new String(src);
        while (buff.length() < length) {            
            buff = "0" + buff;
        }
        return buff;
    }
    
    private void setValueSlideText(){
        txtPercent.setText("Kích thước rút gọn: " + fillText(sldPercent.getValue() + "%",4));        
//        txtMin.setText("Min Summary: " + fillText(sldMin.getValue() + "", 5));
        txtNumNote.setText("Số đỉnh đồ thị: " + fillText(sldNumber.getValue()+"", 3));
    }

//    public JSlider getSldMin() {
//        return sldMin;
//    }

    public JSlider getSldNumber() {
        return sldNumber;
    }

    public JSlider getSldPercent() {
        return sldPercent;
    }
    
    public boolean isShowAllNote(){
        return cbAllNote.isSelected();
    }
    
}
