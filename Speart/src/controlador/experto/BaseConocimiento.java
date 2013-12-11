/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.experto;

import java.util.Hashtable;
import jpl.Query;

/**
 *
 * @author 
 */
public class BaseConocimiento {

    /**
     * Método que compila un archivo .pl
     *
     * @param dirArchivo La direccion donde se encuentra el archivo .pl
     * @return true Si se ha compilado el archivo correctamente<br>
     *         false Si el archivo <b>NO</b> se ha compilado correctamente
     */
    public boolean compilaArchivo(String dirArchivo) {
        Query q = new Query("consult('" + dirArchivo + "')");
        if (q.hasSolution()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que verifica si se cumple o no una regla
     *
     * @param regla La regla a ser evaluada
     * @return true Si la regla se evaluo como verdadera<br>
     *         false Si la regla se evaluo como falsa
     */
    public boolean cumpleRegla(String regla) {
        Query q = new Query(regla);
        return q.hasSolution();
    }

    /**
     * Metodo que hace una consulta simple de la forma <b>regla(var1,X)</b>
     * donde
     * <b>var1</b> es una variable contenida en la base de conocimientos del
     * archivo pl y <b>X</b> es la variable que deseamos conocer u obtener
     *
     * @param consulta La regla a ser consultada
     * @return El contenido y/o valor de X
     */
    public String consultaSegundoElemento(String consulta) {
        String s;
        Query q = new Query(consulta);
        q.open();
        Hashtable ht = q.getSolution();
        return s = (ht == null) ? "'Error'" : String.valueOf(ht.get("X"));
    }

    /**
     * Metodo que hace una consulta simple de la forma <b>regla(var1,X)</b>
     * donde
     * <b>var1</b> es una variable contenida en la base de conocimientos del
     * archivo pl y <b>X</b> es la variable que deseamos conocer u obtener, la
     * misma que puede tener varios valores
     *
     * @param consulta La regla a ser consultada
     * @return El/los valores de X
     */
    public String consultaSegundoElemVarios(String consulta) {
        String s = "";
        Query q = new Query(consulta);
        while (q.hasMoreSolutions()) {
            Hashtable hm = q.nextSolution();
            s += ((hm == null) ? "'Error'" : String.valueOf(hm.get("X")))+ "\n";
//            s += hm.get("X") + "\n";
        }
        return s;
    }

    public static void main(String args[]) {
        BaseConocimiento bc = new BaseConocimiento();
        ClassLoader cl = BaseConocimiento.class.getClassLoader();//para hacer referencia a archivos dentro del programa
        String dirArchivo = cl.getResource("controlador/experto/evaluacion.pl").getPath();
        if (bc.compilaArchivo(dirArchivo)) {
            System.out.println(bc.consultaSegundoElemento("califResult(100,X)"));
//            System.out.println("Compilacion correcta!!!");
//            System.out.println(bc.cumpleRegla("regla8('Sobresaliente',X)"));       
        }
//        if (bc.compilaArchivo(dirArchivo)) {
//            System.out.println(bc.consultaSegundoElemento("no('1.1',X)"));
//            System.out.println(bc.consultaSegundoElemento("no('1.2',X)"));
//        }
//        if (bc.compilaArchivo(dirArchivo)) {
//            System.out.println(bc.consultaSegundoElemVarios("madre(pepa,X)"));
//        }
//        if (bc.compilaArchivo(dirArchivo)) {
//            System.out.println(bc.cumpleRegla("es_descendiente(pepa,paco)"));
//        }

    }
}
