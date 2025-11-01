import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DesainAplikasiKontak extends javax.swing.JFrame {
// Koneksi Database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_kontak";
    private static final String DB_USER = "root";  // ubah sesuai konfigurasi
    private static final String DB_PASS = "";      // isi jika pakai password
    public DesainAplikasiKontak() {
        initComponents();
        btnExport.addActionListener(e -> exportToCSV());
        btnImport.addActionListener(e -> importFromCSV());
        loadData();
        
        // Batasi input nomor telepon hanya angka dan maksimal 12 digit
    txtNoTelepon.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            char c = evt.getKeyChar();

            // Hanya izinkan angka
            if (!Character.isDigit(c)) {
                evt.consume(); // abaikan karakter non-angka
            }

            // Batasi panjang maksimal 12
            if (txtNoTelepon.getText().length() >= 12) {
                evt.consume();
            }
        }
     });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtNoTelepon = new javax.swing.JTextField();
        cmbKategori = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblisi = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama:");

        jLabel2.setText("Nomor Telepon:");

        jLabel3.setText("Kategori:");

        jLabel4.setText("Cari (Nama/Telp:");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        txtNoTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTeleponActionPerformed(evt);
            }
        });

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Keluarga", "Teman", "Kerja" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tblisi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Telepon", "Kategori"
            }
        ));
        jScrollPane1.setViewportView(tblisi);

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(txtNoTelepon)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh)
                        .addGap(0, 236, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExport)
                    .addComponent(btnImport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnEdit))
                        .addGap(16, 16, 16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCari)
                        .addComponent(btnHapus)
                        .addComponent(btnRefresh))
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImport)))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String nama = txtNama.getText().trim();
        String telp = txtNoTelepon.getText().trim();
        String kategori = cmbKategori.getSelectedItem().toString();

        if (nama.isEmpty() || telp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama dan Telepon wajib diisi!");
            return;
        }

        if (!telp.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Nomor telepon hanya boleh angka!");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO kontak (nama, telp, kategori) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, telp);
            ps.setString(3, kategori);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Kontak berhasil ditambahkan!");
            clearForm();
            loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
      }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblisi.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih kontak yang ingin diedit!");
        return;
    }

    int id = Integer.parseInt(tblisi.getValueAt(row, 0).toString());
    String nama = txtNama.getText().trim();
    String telp = txtNoTelepon.getText().trim();
    String kategori = cmbKategori.getSelectedItem().toString();

    if (nama.isEmpty() || telp.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nama dan Telepon wajib diisi!");
        return;
    }

    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
        String sql = "UPDATE kontak SET nama=?, telp=?, kategori=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nama);
        ps.setString(2, telp);
        ps.setString(3, kategori);
        ps.setInt(4, id);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
        clearForm();
        loadData();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
     }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int row = tblisi.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih kontak yang akan dihapus!");
            return;
        }

        int id = Integer.parseInt(tblisi.getValueAt(row, 0).toString());
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi != JOptionPane.YES_OPTION) return;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "DELETE FROM kontak WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Kontak berhasil dihapus!");
            loadData();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
      }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String keyword = txtCari.getText().trim();
        DefaultTableModel model = (DefaultTableModel) tblisi.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM kontak WHERE nama LIKE ? OR telp LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("telp"),
                        rs.getString("kategori")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
      }
    }//GEN-LAST:event_btnCariActionPerformed
        private void loadData() {
        DefaultTableModel model = (DefaultTableModel) tblisi.getModel();
        model.setRowCount(0);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM kontak ORDER BY id DESC")) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("telp"),
                        rs.getString("kategori")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
      }
    }

    private void clearForm() {
        txtNama.setText("");
        txtNoTelepon.setText("");
        txtCari.setText("");
        cmbKategori.setSelectedIndex(0);
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        clearForm();
        loadData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtNoTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTeleponActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImportActionPerformed

    private void exportToCSV() {
    try {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Simpan sebagai CSV");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();

            // Tambahkan ekstensi .csv jika belum ada
            if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
                fileToSave = new java.io.File(fileToSave.getAbsolutePath() + ".csv");
            }

            try (java.io.PrintWriter pw = new java.io.PrintWriter(fileToSave)) {
                pw.println("ID,Nama,Telepon,Kategori");

                try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                     Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery("SELECT * FROM kontak")) {

                    while (rs.next()) {
                        pw.println(
                            rs.getInt("id") + "," +
                            rs.getString("nama") + "," +
                            rs.getString("telp") + "," +
                            rs.getString("kategori")
                        );
                    }
                }

                JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke: " + fileToSave.getAbsolutePath());
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal mengekspor data: " + e.getMessage());
    }
}

// === IMPOR CSV ===
private void importFromCSV() {
    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Pilih file CSV untuk diimpor");
    int userSelection = fileChooser.showOpenDialog(this);

    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File fileToOpen = fileChooser.getSelectedFile();

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(fileToOpen));
             Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {

            String line;
            boolean skipHeader = true;
            while ((line = br.readLine()) != null) {
                if (skipHeader) { skipHeader = false; continue; }

                String[] data = line.split(",");
                if (data.length < 4) continue;

                String nama = data[1].trim();
                String telp = data[2].trim();
                String kategori = data[3].trim();

                String sql = "INSERT INTO kontak (nama, telp, kategori) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nama);
                ps.setString(2, telp);
                ps.setString(3, kategori);
                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Data dari CSV berhasil diimpor!");
            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal mengimpor data: " + e.getMessage());
        }
    }
}
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(DesainAplikasiKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesainAplikasiKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesainAplikasiKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesainAplikasiKontak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesainAplikasiKontak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblisi;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelepon;
    // End of variables declaration//GEN-END:variables
}
