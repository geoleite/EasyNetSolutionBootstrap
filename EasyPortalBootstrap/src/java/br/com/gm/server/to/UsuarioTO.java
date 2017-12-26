/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gm.server.to;

import java.util.Date;

/**
 *
 * @author geoleite
 */
public class UsuarioTO {
    private int usuNrId;
    private String usuTxNome, usuTxLogin, usuTxEmail, usuTxTrocarSenha;
    private Date usuDtCadastro;

    /**
     * @return the usuNrId
     */
    public int getUsuNrId() {
        return usuNrId;
    }

    /**
     * @param usuNrId the usuNrId to set
     */
    public void setUsuNrId(int usuNrId) {
        this.usuNrId = usuNrId;
    }

    /**
     * @return the usuTxNome
     */
    public String getUsuTxNome() {
        return usuTxNome;
    }

    /**
     * @param usuTxNome the usuTxNome to set
     */
    public void setUsuTxNome(String usuTxNome) {
        this.usuTxNome = usuTxNome;
    }

    /**
     * @return the usuTxLogin
     */
    public String getUsuTxLogin() {
        return usuTxLogin;
    }

    /**
     * @param usuTxLogin the usuTxLogin to set
     */
    public void setUsuTxLogin(String usuTxLogin) {
        this.usuTxLogin = usuTxLogin;
    }

    /**
     * @return the usuTxEmail
     */
    public String getUsuTxEmail() {
        return usuTxEmail;
    }

    /**
     * @param usuTxEmail the usuTxEmail to set
     */
    public void setUsuTxEmail(String usuTxEmail) {
        this.usuTxEmail = usuTxEmail;
    }

    /**
     * @return the usuTxTrocarSenha
     */
    public String getUsuTxTrocarSenha() {
        return usuTxTrocarSenha;
    }

    /**
     * @param usuTxTrocarSenha the usuTxTrocarSenha to set
     */
    public void setUsuTxTrocarSenha(String usuTxTrocarSenha) {
        this.usuTxTrocarSenha = usuTxTrocarSenha;
    }

    /**
     * @return the usuDtCadastro
     */
    public Date getUsuDtCadastro() {
        return usuDtCadastro;
    }

    /**
     * @param usuDtCadastro the usuDtCadastro to set
     */
    public void setUsuDtCadastro(Date usuDtCadastro) {
        this.usuDtCadastro = usuDtCadastro;
    }
            
}
