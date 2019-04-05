/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

    
package com.xiutech.simix.modelo;
// Generated 29-mar-2019 11:00:45 by Hibernate Tools 4.3.1


import com.moonsoft.proyecto.model.ConexionBD;
import com.moonsoft.proyecto.model.Usuario;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.persistence.Query;
import static org.apache.commons.codec.binary.Base64.decodeBase64;

/**
*
* @author jorge
*/

public class Sesion {

   // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
   private final static String alg = "AES";


   // Definición del modo de cifrado a utilizar
   private final static String cI = "AES/CBC/PKCS5Padding";
   private Usuario usuario;

   /**

   * Creates a new instance of Sesion
    */
   public Sesion() {
       usuario = new Usuario();


   }

   public Usuario getusuario() {

       return usuario;

   }

   public void setUsuario(Usuario usuario) {

       this.usuario = usuario;

   }

   /**
    * Método que se encarga de el cierre de sesión de un usuario.
    *
    * @return pantalla_principal
    */

   public static String cerrarSesion() {
       try {

           FacesContext context = getCurrentInstance();
           context.getExternalContext().invalidateSession();

           return "PantallaPrincipalIH.xhtml?faces-redirect=true";

       } catch (Exception n) {

           return "ErrorConexionIH.xhtml?faces-redirect=true";

       }

   }

   /**
    * Método que verifica si un usuario tiene la sesión abierta.
    *
    * @return boolean
    */

   public boolean estaConectado() {

       FacesContext context = getCurrentInstance();

       Usuario l = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
       return l != null;

   }
