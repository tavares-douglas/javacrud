/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inatel.projetofinal2.view;

import br.inatel.projetofinal2.model.Paciente;
import br.inatel.projetofinal2.model.Consulta;
import br.inatel.projetofinal2.modelDAO.MedicoDAO;
import br.inatel.projetofinal2.modelDAO.PacienteDAO;
import br.inatel.projetofinal2.modelDAO.ConsultaDAO;
import javax.swing.JOptionPane;


/**
 *
 * @author gabri
 */
public class CadastroConsulta extends javax.swing.JFrame {

    /** Creates new form CadastroConsulta */
    public CadastroConsulta() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelConsulta = new javax.swing.JPanel();
        crmMedico = new javax.swing.JLabel();
        cpfPaciente = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        horario = new javax.swing.JLabel();
        campoCrmMedico = new javax.swing.JFormattedTextField();
        campoCpfPaciente = new javax.swing.JFormattedTextField();
        campoData = new javax.swing.JFormattedTextField();
        campoHorario = new javax.swing.JFormattedTextField();
        botaoConfirmar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 255), 2, true), "Consulta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 18))); // NOI18N

        crmMedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        crmMedico.setText("CRM:");

        cpfPaciente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cpfPaciente.setText("CPF:");

        data.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        data.setText("Data:");

        horario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        horario.setText("Horário:");

        try {
            campoCrmMedico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoCpfPaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        botaoConfirmar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botaoConfirmar.setText("Confirmar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelConsultaLayout = new javax.swing.GroupLayout(painelConsulta);
        painelConsulta.setLayout(painelConsultaLayout);
        painelConsultaLayout.setHorizontalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelConsultaLayout.createSequentialGroup()
                        .addComponent(botaoConfirmar)
                        .addGap(60, 60, 60)
                        .addComponent(botaoCancelar))
                    .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelConsultaLayout.createSequentialGroup()
                            .addComponent(crmMedico)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoCrmMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelConsultaLayout.createSequentialGroup()
                            .addComponent(horario)
                            .addGap(18, 18, 18)
                            .addComponent(campoHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelConsultaLayout.createSequentialGroup()
                            .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(data)
                                .addComponent(cpfPaciente))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoCpfPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(campoData)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelConsultaLayout.setVerticalGroup(
            painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConsultaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crmMedico)
                    .addComponent(campoCrmMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfPaciente)
                    .addComponent(campoCpfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horario)
                    .addComponent(campoHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(painelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmar)
                    .addComponent(botaoCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // TODO add your handling code here:
        Cancelar();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
        // TODO add your handling code here:
        Confirmar();
        
    }//GEN-LAST:event_botaoConfirmarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JFormattedTextField campoCpfPaciente;
    private javax.swing.JFormattedTextField campoCrmMedico;
    private javax.swing.JFormattedTextField campoData;
    private javax.swing.JFormattedTextField campoHorario;
    private javax.swing.JLabel cpfPaciente;
    private javax.swing.JLabel crmMedico;
    private javax.swing.JLabel data;
    private javax.swing.JLabel horario;
    private javax.swing.JPanel painelConsulta;
    // End of variables declaration//GEN-END:variables

    
    //Volta para tela principal
    private void Cancelar(){
        
        TelaMain tm = new TelaMain();
        tm.setVisible(true);
        this.dispose();
    }
    
    
    //Salva os dados
    private void Confirmar(){
        
        MedicoDAO mDAO = new MedicoDAO();
        PacienteDAO pDAO = new PacienteDAO();
        ConsultaDAO cDAO = new ConsultaDAO();
        Consulta c = new Consulta(campoCrmMedico.getText(),campoCpfPaciente.getText(),
        campoData.getText(), campoHorario.getText());
        boolean check1 = mDAO.verificaMedico(campoCrmMedico.getText());
        boolean check2 = pDAO.verificaPaciente(campoCpfPaciente.getText());
        
        if("".equals(campoData.getText()) || "".equals(campoHorario.getText()))// Veirfica se há campos em branco
            JOptionPane.showMessageDialog(null, "Preencha os dados corretamente!");
        else if(!check1 || !check2)// Verifica se os dados existem
            JOptionPane.showMessageDialog(null, "Digite CPF e CRM válidos!");
        else{
            
            cDAO.inserirConsulta(c);
            JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso!");
            
        }
        
        
    }



}

