package Ficheros;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
* Clase practica
* Frame para mostrar los datos del archivo
* @author Gustavo Daniel Afonso Hernández / UCAM
* @version 0.1, 2020/10/21
*/

public class practica extends JFrame {

  JTable propiedadesarchivo;
  DefaultTableModel modelo;
  File archivo;
  int i = 0;
  
  /**
   * Método práctica
   * Crea la clase.
   * @args p descripción del parámetro.
   */
  
  public practica() {
    JButton btnexplorar = new JButton("Explorar archivos...");
    btnexplorar.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JFileChooser selector = new JFileChooser();
        int r = selector.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
          archivo = selector.getSelectedFile();
          propiedadesarchivo.setValueAt(archivo.getName(), i, 0);
          propiedadesarchivo.setValueAt(archivo.length() / 1024, i, 1);
          propiedadesarchivo.setValueAt(archivo.canRead(), i, 2);
          propiedadesarchivo.setValueAt(archivo.canWrite(), i, 3);
          Date d = new Date(archivo.lastModified());
          propiedadesarchivo.setValueAt(d, i, 4);
          i++;
        }
      }
    });

    String [] nombresCols = {"Nombre", "Tamaño (KB)", "Lectura", "Escritura", "F. Modificacion"};
    modelo = new DefaultTableModel(nombresCols, 10);
    propiedadesarchivo = new JTable(modelo);
    
    JPanel pboton = new JPanel();
    pboton.add(btnexplorar);

    add(pboton, BorderLayout.NORTH);
    add(new JScrollPane(propiedadesarchivo));
  }
  
  public static void main(String[] args) {
    practica p = new practica();
    p.setVisible(true);
    p.setBounds(0, 0, 1000, 265);
    p.setLocationRelativeTo(null);
    p.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}