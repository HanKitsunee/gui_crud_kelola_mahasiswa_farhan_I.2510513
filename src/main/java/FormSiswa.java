import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Gerald
 */
public class FormSiswa extends javax.swing.JFrame {

    // Menggunakan hak akses private untuk enkapsulasi yang lebih baik
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    private DefaultTableModel tabModel;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormSiswa.class.getName());

    /**
     * Creates new form FormSiswa
     */
    public FormSiswa() {
        initComponents();

        // Memanggil fungsi koneksi dari kelas Koneksi.java
        cn = Koneksi.Koneksi();

        inisialisasiTabel();
        tampilData("");
        resetForm();
    }

    private void inisialisasiTabel() {
        Object[] kolom = {"NIS/NIM", "Nama Siswa", "Jurusan", "Jenis Kelamin", "Alamat"};
        tabModel = new DefaultTableModel(null, kolom);
        tableSiswa.setModel(tabModel);
    }

    public void tampilData(String tuju) {
        try {
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();

            rs = st.executeQuery("SELECT * FROM students " + tuju);
            while (rs.next()) {
                Object[] data = {
                        rs.getString("nis"),
                        rs.getString("nama"),
                        rs.getString("jurusan"),
                        rs.getString("jk"),
                        rs.getString("alamat")
                };
                tabModel.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memuat data: " + e.getMessage());
        }
    }

    public void resetForm() {
        txtNamaSiswa.setText("");
        txtNis.setText("");
        cmbJurusan.setSelectedIndex(0);
        cmbJK.setSelectedIndex(0);
        txtAlamat.setText("");

        txtNis.setEnabled(true);
        btnSimpan.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnHapus.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNamaSiswa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNis = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSiswa = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbJurusan = new javax.swing.JComboBox<>();
        cmbJK = new javax.swing.JComboBox<>();
        txtAlamat = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Data Siswa");

        jLabel1.setText("Nama Siswa");
        txtNamaSiswa.setText("");

        jLabel2.setText("NIS");
        txtNis.setText("");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        tableSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSiswa);

        jLabel3.setText("Jurusan");
        jLabel4.setText("JK");
        jLabel5.setText("Alamat");

        cmbJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hukum", "Ilmu Komputer", "Fisip", "FAIPG" }));
        cmbJK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        txtAlamat.setText("");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnReset.setText("Reset");
        btnReset.addActionListener(this::btnResetActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtNis)
                                                        .addComponent(txtNamaSiswa)
                                                        .addComponent(cmbJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cmbJK, 0, 150, Short.MAX_VALUE)
                                                        .addComponent(txtAlamat)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                        .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(cmbJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(cmbJK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSimpan)
                                        .addComponent(btnHapus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnReset))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null); // Membuat form muncul di tengah layar
    }// </editor-fold>

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        // Validasi input sederhana
        if (txtNis.getText().isEmpty() || txtNamaSiswa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "NIS dan Nama tidak boleh kosong!");
            return;
        }

        String sql = "INSERT INTO students (nis, nama, jurusan, jk, alamat) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, txtNis.getText());
            pst.setString(2, txtNamaSiswa.getText());
            pst.setString(3, cmbJurusan.getSelectedItem().toString());
            pst.setString(4, cmbJK.getSelectedItem().toString());
            pst.setString(5, txtAlamat.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            tampilData("");
            resetForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan: " + e.getMessage());
        }
    }

    private void tableSiswaMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = tableSiswa.getSelectedRow();

        txtNis.setText(tableSiswa.getValueAt(selectedRow, 0).toString());
        txtNamaSiswa.setText(tableSiswa.getValueAt(selectedRow, 1).toString());
        cmbJurusan.setSelectedItem(tableSiswa.getValueAt(selectedRow, 2).toString());
        cmbJK.setSelectedItem(tableSiswa.getValueAt(selectedRow, 3).toString());
        txtAlamat.setText(tableSiswa.getValueAt(selectedRow, 4).toString());

        txtNis.setEnabled(false); // Kunci field NIS saat edit data
        btnSimpan.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnHapus.setEnabled(true);
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String sql = "UPDATE students SET nama=?, jurusan=?, jk=?, alamat=? WHERE nis=?";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, txtNamaSiswa.getText());
            pst.setString(2, cmbJurusan.getSelectedItem().toString());
            pst.setString(3, cmbJK.getSelectedItem().toString());
            pst.setString(4, txtAlamat.getText());
            pst.setString(5, txtNis.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            tampilData("");
            resetForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Update: " + e.getMessage());
        }
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (jawab != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "DELETE FROM students WHERE nis=?";
        try (PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setString(1, txtNis.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            tampilData("");
            resetForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Menghapus: " + e.getMessage());
        }
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        resetForm();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new FormSiswa().setVisible(true));
    }

    // Pembaruan Deklarasi Variabel yang Rapi dan Sesuai Standar
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JComboBox<String> cmbJK;
    private javax.swing.JComboBox<String> cmbJurusan;
    private javax.swing.JTextField txtNis;
    private javax.swing.JTextField txtNamaSiswa;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSiswa;
}