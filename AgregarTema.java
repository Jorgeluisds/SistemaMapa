
package com.xiutech.simix.modelo;
// Generated 29-mar-2019 11:00:45 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**

*
* @author jorge
*/

public class AgregaTema {

   private String nombre;
   private Usuario usuario;
   public Usuario getUsuario() {

       return usuario;

   }

   public void setUsuario(Usuario usuario) {

       this.usuario = usuario;

   }

   public String getNombre() {

       return nombre;

    }

   public void setNombre(String nombre) {

       this.nombre = nombre;

   }

   public void agregraTema(){

       Tema u = new Tema();

       TemaDAO udao = new TemaDAO();

       u.setNombre(nombre);

       u.setUsuario(usuario);

        if(udao.find(nombre) == null){

           udao.save(u);

       }

   }

}

