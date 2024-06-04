// Balderrama Resenndiz Angel Joel PROYECTO FINAL POO
// Librerias necesarias
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Clase principal
public class ProyectoMain {
    private static JTextField cuentaTxt;
    private static JButton ingresarBtn;
    private static JButton depositarBtn;
    private static JButton retirarBtn;
    private static JButton saldoBtn;
    private static JButton salirBtn;

    public static void main(String[] args) {
        ProyectoF cuenta = new ProyectoF(0, "", 0, "");

        // Crear y configurar el frame principal
        JFrame frame = new JFrame("Mi Banamex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Crear el panel de ingreso de cuenta
        JPanel panelIng = new JPanel();
        panelIng.add(new JLabel("Ingresa número de cuenta: "));
        cuentaTxt = new JTextField(10);
        panelIng.add(cuentaTxt);
        ingresarBtn = new JButton("Ingresar");
        panelIng.add(ingresarBtn);

        // Crear el panel de botones
        JPanel panel = new JPanel();
        panel.setBounds(20, 20, 200, 200);
        depositarBtn = new JButton("Depositar");
        retirarBtn = new JButton("Retirar");
        saldoBtn = new JButton("Obtener Saldo");
        salirBtn = new JButton("Salir");

        panel.add(depositarBtn);
        panel.add(retirarBtn);
        panel.add(saldoBtn);
        panel.add(salirBtn);

        // Agregar los paneles al frame
        frame.add(panelIng, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);

        // Configurar acciones de los botones
        ingresarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numCuenta = Integer.parseInt(cuentaTxt.getText());
                    String nombre = "Angel Joel Balderrama Resendiz";
                    String dom = "Domicilio: Las casitas";
                    double saldoInicial = 1000.0;
        
                    cuenta.setSaldo(saldoInicial);
                    cuenta.setNombre(nombre);
                    cuenta.setNumCuenta(numCuenta);
                    cuenta.setDom(dom);
        
                    JOptionPane.showMessageDialog(frame, "Cuenta ingresada exitosamente.\nNombre: " + cuenta.getNombre() + "\nDomicilio: " + cuenta.getDom());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Número de cuenta inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
      

        depositarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cantidadStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad a depositar:");
                if (cantidadStr != null) {
                    try {
                        double cantidadDeposito = Double.parseDouble(cantidadStr);
                        cuenta.depositar(cantidadDeposito);
                        JOptionPane.showMessageDialog(frame, "Depósito exitoso.\nNuevo saldo: " + cuenta.getSaldo());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        retirarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cantidadStr = JOptionPane.showInputDialog(frame, "Ingrese la cantidad a retirar:");
                if (cantidadStr != null) {
                    try {
                        double cantidadRetiro = Double.parseDouble(cantidadStr);
                        if (cuenta.retirar(cantidadRetiro)) {
                            JOptionPane.showMessageDialog(frame, "Retiro exitoso.\nNuevo saldo: " + cuenta.getSaldo());
                        } else {
                            JOptionPane.showMessageDialog(frame, "Saldo insuficiente.\nSaldo actual: " + cuenta.getSaldo());
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        saldoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Saldo actual: " + cuenta.getSaldo());
            }
        });

        salirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Gracias por utilizar Santander xd.");
                System.exit(0);
            }
        });
    }
}

// Clase para la lógica de la cuenta bancaria
class ProyectoF {
    private int numCuenta;
    private String nombre;
    private double saldo;
    private String dom;

    public ProyectoF(int numCuenta, String nombre, double saldo, String dom) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
        this.dom = dom;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    public boolean retirar(double cantidad) {
        if (this.saldo >= cantidad) {
            this.saldo -= cantidad;
            return true;
        } else {
            return false;
        }
    }
}
