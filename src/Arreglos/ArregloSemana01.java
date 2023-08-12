package Arreglos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ArregloSemana01 extends JFrame {

    private final JLabel lblNumero;
    private final JLabel lblPosicion;
    private final JLabel lblResultado;
    private final JTextField txtNumero;
    private final JTextField txtPosicion;
    private final JTextField txtResultado;
    private final JButton btnAgregar;
    private final JButton btnBorrar;
    private final JButton btnResultado;
    private final JButton btnConsultar;
    private final JButton btnPromedio;
    private final int[] arreglo = new int[10];

    public ArregloSemana01() {
        setTitle("Arreglo Unidimensional");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        lblNumero = new JLabel("numero");
        lblNumero.setForeground(Color.blue);
        lblPosicion = new JLabel("Posicion");
        lblPosicion.setForeground(Color.blue);
        lblResultado = new JLabel("Resultado");
        lblResultado.setForeground(Color.blue);
        txtNumero = new JTextField();
        txtPosicion = new JTextField();
        txtResultado = new JTextField();
        txtResultado.setEditable(false);

        btnAgregar = new JButton("Agregar Dato");
        btnAgregar.setForeground(Color.red);
        btnAgregar.setBackground(Color.lightGray);
        btnBorrar = new JButton("Borrar Dato");
        btnBorrar.setForeground(Color.red);
        btnBorrar.setBackground(Color.lightGray);
        btnResultado = new JButton("Limpiar Arreglo");
        btnResultado.setForeground(Color.red);
        btnResultado.setBackground(Color.lightGray);
        btnConsultar = new JButton("Consultar Arreglo");
        btnConsultar.setForeground(Color.red);
        btnConsultar.setBackground(Color.lightGray);
        btnPromedio = new JButton("Calcular Promedio");
        btnPromedio.setForeground(Color.red);
        btnPromedio.setBackground(Color.lightGray);

        btnAgregar.addActionListener((ActionEvent e) -> {
            agregarDato();
        });

        btnBorrar.addActionListener((ActionEvent e) -> {
            borrarDato();
        });

        btnResultado.addActionListener((ActionEvent e) -> {
            limpiarArreglo();
        });

        btnConsultar.addActionListener((ActionEvent e) -> {
            consultarArreglo();
        });

        btnPromedio.addActionListener((ActionEvent e) -> {
            calcularPromedio();
        });

        add(lblNumero);
        add(txtNumero);
        add(lblPosicion);
        add(txtPosicion);
        add(btnAgregar);
        add(btnBorrar);
        add(btnResultado);
        add(btnConsultar);
        add(btnPromedio);
        add(lblResultado);
        add(txtResultado);

        pack();
        setBounds(600, 400,600,400);
        setLocationRelativeTo(null);
    }

    private void agregarDato() {
        int numero = Integer.parseInt(txtNumero.getText());
        int posicion = Integer.parseInt(txtPosicion.getText());

        if (posicion >= 0 && posicion < arreglo.length) {
            arreglo[posicion] = numero;
            txtResultado.setText("Dato agregado en posición " + posicion);
        } else {
            txtResultado.setText("Posición fuera de rango");
        }
    }

    private void borrarDato() {
        int posicion = Integer.parseInt(txtPosicion.getText());

        if (posicion >= 0 && posicion < arreglo.length) {
            arreglo[posicion] = 0;
            txtResultado.setText("Dato en posición " + posicion + " borrado");
        } else {
            txtResultado.setText("Posición fuera de rango");
        }
    }

    private void limpiarArreglo() {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = 0;
        }
        txtResultado.setText("Arreglo limpiado");
    }

    private void consultarArreglo() {
        StringBuilder sb = new StringBuilder("Arreglo: [");
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        txtResultado.setText(sb.toString());
    }

    private void calcularPromedio() {
        int suma = 0;
        int count = 0;

        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
            if (arreglo[i] != 0) {
                count++;
            }
        }

        if (count > 0) {
            double promedio = (double) suma / count;
            txtResultado.setText("Promedio: " + promedio);
        } else {
            txtResultado.setText("No hay datos para calcular promedio");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArregloSemana01().setVisible(true);
        });
    }
}
