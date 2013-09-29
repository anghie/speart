package controlador.experto;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import controlador.basedatos.Conexion;
import java.util.Date;

/**
 *
 * @author 
 */import modelo.agenda.ItemAgenda;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.experiment.DatabaseUtils;
import weka.experiment.InstanceQuery;

public class ExpertoAgenda {

    private String controladorDB;
    private String usuario;
    private String clave;

    public ExpertoAgenda(String controladorDB, String usuario, String clave) {
        this.controladorDB = controladorDB;
        this.usuario = usuario;
        this.clave = clave;
    }

    public ExpertoAgenda() {
        this.controladorDB = "jdbc:mysql://" + Conexion.host_bd + ":3306/speiess";//"jdbc:mysql://localhost:3306/speiess";
        this.usuario = Conexion.user;//"root";
        this.clave = Conexion.clave;//"root";
    }

    // Obtiene un ID de la actividad de la agenda mas apropiado
    public String getResultado(ItemAgenda itemAgenda, String mes, String dia) throws Exception {
        ///Obtener Actividades de la base de datos para q el experto decida q actividad se deba realizar
        DatabaseUtils utils = new DatabaseUtils();
        String resultado = null;
        InstanceQuery query = new InstanceQuery();
        //query.set
        Class.forName("com.mysql.jdbc.Driver");
        query.setDatabaseURL(controladorDB);
        query.setUsername(usuario);
        query.setPassword(clave);//,dia_del_mes,id "SELECT mes,dia,horaInicio,horaFin,actividad_idActividad,id FROM ItemAgenda"
        query.setQuery("SELECT mes,dia,nombre_actividad,CAST(id AS CHAR) FROM ItemAgenda where mes='"+mes+"' and dia='"+dia+"'");//and completada=1
        // The result of this query is the table which Weka is going to //use for classification or prediction
        Instances coleccion = query.retrieveInstances();
        query.close();
        if (coleccion.numInstances() > 0) {
            // Asignar el último atributo como clase objetivo es decir la conclucion
            coleccion.setClassIndex(coleccion.numAttributes() - 1);
            System.out.println(coleccion);
            // Inicializar y entrenar el clasificador
            MultilayerPerceptron clasificador = new MultilayerPerceptron();
            // clasificador.setGUI(true);// Mostrar por pantalla el modelo construido
            clasificador.buildClassifier(coleccion);
            //System.out.println(coleccion);
            // Crear un nuevo ejemplo con los valores de la linea de órdenes  [ mes,dia,horaInicio,horaFin,idActividad]
            Instance datosItemAgenda = getDatosItemAgenda(itemAgenda,coleccion);
            System.out.println("----------------------------");
            System.out.println(datosItemAgenda);
// Clasificar el nuevo ejemplar
            double indiceClase = clasificador.classifyInstance(datosItemAgenda);
// Mostrar la clase del ejemplar por pantalla
//        System.out.println(coleccion.classAttribute().value((int) indiceClase));
            resultado = coleccion.classAttribute().value((int) indiceClase);
        }
        return resultado;
    }

    public Instance getDatosItemAgenda(ItemAgenda itemAgenda,Instances coleccion) {
       // Attribute attr3 = new Attribute("my-date","yyyy-MM-dd\'T\'HH:mm:ss");
        Instance datosdiag = new Instance(4);//6
        // Marcar la anterior como colección de referencia
        System.out.println("Item Agenda :"+itemAgenda.getMes()+" "+itemAgenda.getDia()+" "+itemAgenda.getDia_del_mes());
        datosdiag.setDataset(coleccion);
       
        datosdiag.setValue(0, itemAgenda.getMes());
        datosdiag.setValue(1, itemAgenda.getDia());
        datosdiag.setValue(2, itemAgenda.getNombre_actividad());
//        datosdiag.setValue(2, itemAgenda.getDia_del_mes());
//        datosdiag.setValue(3, itemAgenda.getNombre_actividad());
        
        //datosdiag.setValue(0, ""+itemAgenda.getId());
        //datosdiag.setValue(2, itemAgenda.getHoraInicio().toString());
        //datosdiag.setValue(3, itemAgenda.getHoraFin().toString());
        // datosdiag.setValue(3, itemAgenda.getActividad().getIdActividad());
        //datosdiag.setValue(6, itemAgenda.getId());
        return datosdiag;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getControladorDB() {
        return controladorDB;
    }

    public void setControladorDB(String controladorDB) {
        this.controladorDB = controladorDB;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
