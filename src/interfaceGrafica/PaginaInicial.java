package interfaceGrafica;

import codigos.CarregaArquivo;
import codigos.ConstruirMusica;
import codigos.DownloadMusica;
import codigos.LerMusica;
import codigos.MoverSlider;
import codigos.ReproduzirMusica;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.swing.JFileChooser;
import org.jfugue.midi.MidiDictionary;

public class PaginaInicial extends javax.swing.JFrame {
    
    private ConstruirMusica musica;
    private ReproduzirMusica reproducao;
    private MoverSlider moverSlider;
    
    public PaginaInicial() {
        initComponents();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());

        for(int i=0; i<128; i++){
            String instrumento = MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get((byte)i);
            inputInstrumento.addItem(i + " - " + instrumento);
        }
    }

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPlay = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        btnDownload = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblTexto = new javax.swing.JTextArea();
        check = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        btnRestart = new javax.swing.JButton();
        sliderMusica = new javax.swing.JSlider();
        inputInstrumento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputBPM = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuCarregar = new javax.swing.JMenuItem();
        menuFechar = new javax.swing.JMenuItem();
        menuIntegrantes = new javax.swing.JMenu();
        menuAlberto = new javax.swing.JMenuItem();
        menuAnderson = new javax.swing.JMenuItem();
        menuBruno = new javax.swing.JMenuItem();
        menuLucas = new javax.swing.JMenuItem();
        menuInfos = new javax.swing.JMenu();
        menuTutorial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Texto para Música");
        setResizable(false);

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/play2.png"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnCriar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCriar.setText("Criar Música");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        btnDownload.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDownload.setText("Download");
        btnDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadActionPerformed(evt);
            }
        });

        lblTexto.setColumns(20);
        lblTexto.setLineWrap(true);
        lblTexto.setRows(5);
        lblTexto.setWrapStyleWord(true);
        lblTexto.setAlignmentX(0.8F);
        lblTexto.setAlignmentY(0.8F);
        lblTexto.setBorder(null);
        lblTexto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblTexto.setMargin(new java.awt.Insets(2, 10, 2, 6));
        jScrollPane3.setViewportView(lblTexto);

        check.setEnabled(false);
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite seu texto aqui");

        btnRestart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/restart.png"))); // NOI18N
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        sliderMusica.setMajorTickSpacing(25);
        sliderMusica.setMinorTickSpacing(5);
        sliderMusica.setValue(0);
        sliderMusica.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderMusicaStateChanged(evt);
            }
        });
        sliderMusica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sliderMusicaMouseEntered(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/instrumento.png"))); // NOI18N
        jLabel2.setText("Instrumento");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bpm2.png"))); // NOI18N
        jLabel3.setText("BPM");

        inputBPM.setModel(new javax.swing.SpinnerNumberModel(120, 50, 300, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("50 - 300");

        barraMenu.setBackground(new java.awt.Color(255, 255, 255));
        barraMenu.setBorder(null);
        barraMenu.setForeground(new java.awt.Color(0, 0, 0));
        barraMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        barraMenu.setOpaque(true);

        menuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page.png"))); // NOI18N
        menuFile.setText("Arquivo");
        menuFile.setFocusable(false);
        menuFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuCarregar.setText("Carregar arquivo...");
        menuCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCarregarActionPerformed(evt);
            }
        });
        menuFile.add(menuCarregar);

        menuFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/door_out.png"))); // NOI18N
        menuFechar.setText("Fechar");
        menuFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFecharActionPerformed(evt);
            }
        });
        menuFile.add(menuFechar);

        barraMenu.add(menuFile);

        menuIntegrantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/group.png"))); // NOI18N
        menuIntegrantes.setText("Integrantes");
        menuIntegrantes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuIntegrantes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIntegrantesActionPerformed(evt);
            }
        });

        menuAlberto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        menuAlberto.setText("Alberto");
        menuAlberto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAlberto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlbertoActionPerformed(evt);
            }
        });
        menuIntegrantes.add(menuAlberto);

        menuAnderson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        menuAnderson.setText("Anderson");
        menuAnderson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAnderson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAndersonActionPerformed(evt);
            }
        });
        menuIntegrantes.add(menuAnderson);

        menuBruno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        menuBruno.setText("Bruno");
        menuBruno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuBruno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBrunoActionPerformed(evt);
            }
        });
        menuIntegrantes.add(menuBruno);

        menuLucas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        menuLucas.setText("Lucas");
        menuLucas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuLucas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLucasActionPerformed(evt);
            }
        });
        menuIntegrantes.add(menuLucas);

        barraMenu.add(menuIntegrantes);

        menuInfos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/help.png"))); // NOI18N
        menuInfos.setText("Infos");
        menuInfos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInfos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInfosActionPerformed(evt);
            }
        });

        menuTutorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pdf.png"))); // NOI18N
        menuTutorial.setText("Abrir Tutorial");
        menuTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTutorialActionPerformed(evt);
            }
        });
        menuInfos.add(menuTutorial);

        barraMenu.add(menuInfos);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(btnDownload)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPlay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRestart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sliderMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputBPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCriar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 258, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputBPM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnCriar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputInstrumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnPlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRestart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDownload)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if (check.isSelected() == true){
            //Aloca Threads para reproduzir musica e mover slider ao mesmo tempo.
            reproducao = new ReproduzirMusica(musica.getMusica());
            reproducao.start();
            moverSlider = new MoverSlider(sliderMusica, musica.getBPM());
            moverSlider.start();
        } else {
            new NovaJanelaPopUp("Primeiro crie a música").setVisible(true);
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        String entrada = lblTexto.getText();
        byte instrumento = (byte)inputInstrumento.getSelectedIndex();
        int BMP = (int)inputBPM.getValue();
        
        if(entrada.isEmpty()) {
            new NovaJanelaPopUp("Primeiro entre com o texto da música").setVisible(true);
        } else {
            musica = new ConstruirMusica(entrada, instrumento, BMP);
        
            musica.gerarMusica();
            check.setSelected(true);
            sliderMusica.setMaximum(musica.getTotalNotas());
            sliderMusica.setValue(0);
        }
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadActionPerformed
        File diretorioAtual = new File(".");
        JFileChooser salvarArquivo = new JFileChooser(diretorioAtual);
        String caminhoArquivo;
        
        if(check.isSelected() == true) {
            try {
                salvarArquivo.showSaveDialog(this);
                caminhoArquivo = salvarArquivo.getSelectedFile().getAbsolutePath();
                caminhoArquivo += ".mid";
                
                DownloadMusica musicaString = new DownloadMusica(musica.getMusica());
                musicaString.criaArquivo(caminhoArquivo);
            } catch(Exception erro) {
                new NovaJanelaPopUp("Arquivo não salvo").setVisible(true);
            }
        } else {
            new NovaJanelaPopUp("Primeiro crie a música").setVisible(true);
        }
    }//GEN-LAST:event_btnDownloadActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActionPerformed

    private void menuAlbertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlbertoActionPerformed
        try{

            URI link = new URI("https://github.com/albertoborsatto");
            Desktop.getDesktop().browse(link);
        }catch(Exception erro){
            new NovaJanelaPopUp("Erro ao abrir GitHub").setVisible(true);
        }
    }//GEN-LAST:event_menuAlbertoActionPerformed

    private void menuAndersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAndersonActionPerformed
        try{
            URI link = new URI("https://github.com/AnderCaporale");
            Desktop.getDesktop().browse(link);
        }catch(Exception erro){
            new NovaJanelaPopUp("Erro ao abrir GitHub").setVisible(true);
        }
    }//GEN-LAST:event_menuAndersonActionPerformed

    private void menuLucasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLucasActionPerformed
        try{
            URI link = new URI("https://github.com/quinhas123");
            Desktop.getDesktop().browse(link);
        }catch(Exception erro){
            new NovaJanelaPopUp("Erro ao abrir GitHub").setVisible(true);
        }
    }//GEN-LAST:event_menuLucasActionPerformed

    private void menuIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIntegrantesActionPerformed

    }//GEN-LAST:event_menuIntegrantesActionPerformed

    private void sliderMusicaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderMusicaStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_sliderMusicaStateChanged

    private void sliderMusicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sliderMusicaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sliderMusicaMouseEntered

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        
        if (check.isSelected() == true){
            try{
                reproducao.pause();
                moverSlider.pause();
            } catch (Exception e){}
        } 
        sliderMusica.setValue(0);
    }//GEN-LAST:event_btnRestartActionPerformed

    private void menuBrunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBrunoActionPerformed
        try{
            URI link = new URI("https://github.com/BrunoGVergara");
            Desktop.getDesktop().browse(link);
        }catch(Exception erro){
            new NovaJanelaPopUp("Erro ao abrir GitHub").setVisible(true);
        }
    }//GEN-LAST:event_menuBrunoActionPerformed

    private void menuCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCarregarActionPerformed
        CarregaArquivo arquivo = new CarregaArquivo();
        int statusArquivo = arquivo.getOpenFileChooser().showOpenDialog(this);
        
        if (statusArquivo == JFileChooser.APPROVE_OPTION) {
            try {
               String caminhoArquivo = arquivo.getOpenFileChooser().getSelectedFile().getAbsolutePath();
               LerMusica textoMusica = new LerMusica();
               textoMusica.abrirArquivo(caminhoArquivo);
               textoMusica.lerArquivo();
               lblTexto.setText(textoMusica.getTextoMusica());
            } catch(Exception erro){
                new NovaJanelaPopUp("Arquivo não carregado").setVisible(true);
            }
        } else {
            new NovaJanelaPopUp("Arquivo não carregado").setVisible(true);
        }
    }//GEN-LAST:event_menuCarregarActionPerformed

    private void menuInfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInfosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuInfosActionPerformed

    private void menuTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTutorialActionPerformed
        // TODO add your handling code here:
        try{
            Desktop desktop = Desktop.getDesktop();  
            desktop.open(new File("extras/Tutorial.pdf"));
        } catch(IOException erro){
            new NovaJanelaPopUp("Erro ao abrir tutorial").setVisible(true);
        }
    }//GEN-LAST:event_menuTutorialActionPerformed

    private void menuFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFecharActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuFecharActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnDownload;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRestart;
    private javax.swing.JCheckBox check;
    private javax.swing.JSpinner inputBPM;
    private javax.swing.JComboBox<String> inputInstrumento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lblTexto;
    private javax.swing.JMenuItem menuAlberto;
    private javax.swing.JMenuItem menuAnderson;
    private javax.swing.JMenuItem menuBruno;
    private javax.swing.JMenuItem menuCarregar;
    private javax.swing.JMenuItem menuFechar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuInfos;
    private javax.swing.JMenu menuIntegrantes;
    private javax.swing.JMenuItem menuLucas;
    private javax.swing.JMenuItem menuTutorial;
    private javax.swing.JSlider sliderMusica;
    // End of variables declaration//GEN-END:variables
}
