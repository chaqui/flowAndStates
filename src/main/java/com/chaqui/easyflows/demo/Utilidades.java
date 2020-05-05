package com.chaqui.easyflows.demo;

import com.chaqui.easyflows.demo.models.Usuario;

public class Utilidades {


    private Utilidades() {
        throw new IllegalStateException("Utility class");
      }
    
    
    public static Usuario asignarUsuario(String tipoAsignacion)
    {
        if(tipoAsignacion.equals("aleatoria")){
            return asignarUsuarioAleatorio();
        }
        return asignarUsuarioMinimo(); 
 
    }

    private static Usuario asignarUsuarioMinimo() {
        return null;
    }

    private static Usuario asignarUsuarioAleatorio() {
        return null;
    }
}