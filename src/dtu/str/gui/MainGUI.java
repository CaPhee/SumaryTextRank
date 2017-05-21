package dtu.str.gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class MainGUI extends javax.swing.JFrame {

    private static final String TITLE = "Tóm tắt trích chọn theo TextRank";

    public MainGUI() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(TITLE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(false);
        this.txtRawText.setLineWrap(true);
        this.txtRawText.setWrapStyleWord(true);
        this.txtResult.setLineWrap(true);
        this.txtResult.setWrapStyleWord(true);
        this.sldPercent.setValue(50);
        //String fileName = "resources/caykhe.txt";
        //addText(fileName);

        setValueSlideText();
    }

    private void addText(String fileName) {
        if (fileName.endsWith("doc")) {
            txtRawText.setText(readDocFile(fileName));
        } else if (fileName.endsWith("docx")) {
            txtRawText.setText(readDocxFile(fileName));
        } else {
            String text = "";
            String line;
            try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
                while ((line = buff.readLine()) != null) {
                    text += line + "\n";
                }
                text = text.trim();
                if (0 < text.length()) {
                    btnSummary.setEnabled(true);
                    sldNumber.setEnabled(true);
                    sldPercent.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "File rỗng !");
                }
                txtRawText.setText(text);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "không thể mở file!");
                btnSummary.setEnabled(false);
                btnVisualize.setEnabled(false);
            }
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
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        cbxTimKiem = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
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
        txtPercent.setText("Kích thước tóm tắt: 50%");

        sldPercent.setMinimum(1);
        sldPercent.setValue(20);
        sldPercent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        sldPercent.setEnabled(false);
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

        txtTimKiem.setName("txtTimKiem"); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("Tìm kiếm: ");
        jLabel2.setName("lbTimKiem"); // NOI18N

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setName("btnTimKiem"); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbxTimKiem.setText("Tìm trên văn bản đầu vào");
        cbxTimKiem.setName("cbxTimKiem"); // NOI18N
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFileName)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxTimKiem)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
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
                    .addComponent(btnSummary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnTimKiem)
                    .addComponent(cbxTimKiem)
                    .addComponent(btnVisualize))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnSave)))
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
            if (fileName.endsWith(".txt") || fileName.endsWith(".doc") || fileName.endsWith(".docx")) {
                txtFileName.setText(fileName);
                addText(fileName);
            } else {
                JOptionPane.showMessageDialog(this, "Định dạng file không đúng! Vui lòng chọn file có định dạng: *.docx, *.doc, *.txt");
            }
        }
    }//GEN-LAST:event_btnBrowseActionPerformed
    private String readDocFile(String fileName) {
        String str = "";
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument doc = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(doc);
            String[] paragraphs = extractor.getParagraphText();
            System.out.println("Tổng số dòng: " + paragraphs.length);
            if (paragraphs.length == 1 && paragraphs[0].toString().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "File rỗng!");
                return null;
            }
            for (int i = 0; i < paragraphs.length; i++) {
                if (i == 0) {
                    str += paragraphs[i].toString().trim();
                } else if (paragraphs[i].toString().trim().length() > 0) {
                    str += "\n" + paragraphs[i].toString().trim();
                }
            }
            fis.close();
            btnSummary.setEnabled(true);
            sldNumber.setEnabled(true);
            sldPercent.setEnabled(true);
        } catch (IOException e) {
        }
        return str;
    }

    private String readDocxFile(String fileName) {
        String str = "";
        try {
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument doc = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = doc.getParagraphs();

            if (paragraphs.size() == 1) {
                for (XWPFParagraph para : paragraphs) {
                    if (para.getText().trim().length() == 0) {
                        JOptionPane.showMessageDialog(this, "Fie rỗng!");
                        return null;
                    }
                }
            }
            System.out.println("Tổng số dòng: " + paragraphs.size());
            for (XWPFParagraph para : paragraphs) {
                if (para.getText().trim().length() > 0) {
                    str += "\n" + para.getText().trim();
                }
            }
            fis.close();
            btnSummary.setEnabled(true);
            //setValueSlideText();
            sldNumber.setEnabled(true);
            sldPercent.setEnabled(true);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return str;
    }
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

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        txtResult.getHighlighter().removeAllHighlights();
        txtRawText.getHighlighter().removeAllHighlights();
        String find = txtTimKiem.getText().trim().toLowerCase();
        int noResult=0;
        if (find.length() <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm!");
        } else {
            Document document;
            if (cbxTimKiem.isSelected()) {
                document = txtRawText.getDocument();
                try {
                    for (int index = 0; index + find.length() < document.getLength(); index++) {
                        String match = document.getText(index, find.length()).toLowerCase();
                        if (match.matches(find)) {
                            noResult++;
                            javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter
                                    = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                            txtRawText.getHighlighter().addHighlight(index, index + find.length(),
                                    highlightPainter);
                        }
                    }
                } catch (BadLocationException exp) {
                    exp.printStackTrace();
                }
            } else {
                document = txtResult.getDocument();
                try {
                    for (int index = 0; index + find.length() < document.getLength(); index++) {
                        String match = document.getText(index, find.length()).toLowerCase();
                        if (match.matches(find)) {
                            noResult++;
                            javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter
                                    = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                            txtResult.getHighlighter().addHighlight(index, index + find.length(),
                                    highlightPainter);
                        }
                    }
                } catch (BadLocationException exp) {
                    exp.printStackTrace();
                }
            }

        }
        if(noResult==0) JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả mong muốn!");
        else JOptionPane.showMessageDialog(this, "Tìm thấy "+noResult+" kết quả!");
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        // TODO add your handling code here:
        txtResult.getHighlighter().removeAllHighlights();
        txtRawText.getHighlighter().removeAllHighlights();
    }//GEN-LAST:event_cbxTimKiemActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                txtResult.getHighlighter().removeAllHighlights();
        txtRawText.getHighlighter().removeAllHighlights();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                txtResult.getHighlighter().removeAllHighlights();
        txtRawText.getHighlighter().removeAllHighlights();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                txtResult.getHighlighter().removeAllHighlights();
        txtRawText.getHighlighter().removeAllHighlights();
            }
            
        });
        
    }//GEN-LAST:event_txtTimKiemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSummary;
    private javax.swing.JButton btnTextRank;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnVisualize;
    private javax.swing.JCheckBox cbAllNote;
    private javax.swing.JCheckBox cbxTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private Controller controller;

    void setController(Controller aThis) {
        this.controller = aThis;
    }

    void showResult(String result) {
        txtResult.setText(result);
        btnVisualize.setEnabled(true);

        cbAllNote.setEnabled(true);
        sldNumber.setEnabled(true);
        btnTextRank.setEnabled(true);
    }

    private String fillText(String src, int length) {
        String buff = new String(src);
        while (buff.length() < length) {
            buff = "0" + buff;
        }
        return buff;
    }

    private void setValueSlideText() {
        txtPercent.setText("Kích thước tóm tắt: " + fillText(sldPercent.getValue() + "%", 4));
//        txtMin.setText("Min Summary: " + fillText(sldMin.getValue() + "", 5));
        txtNumNote.setText("Số đỉnh đồ thị: " + fillText(sldNumber.getValue() + "", 3));
    }

    public JSlider getSldNumber() {
        return sldNumber;
    }

    public JSlider getSldPercent() {
        return sldPercent;
    }

    public boolean isShowAllNote() {
        return cbAllNote.isSelected();
    }

}
