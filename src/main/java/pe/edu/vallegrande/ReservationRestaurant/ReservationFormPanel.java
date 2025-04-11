package pe.edu.vallegrande.ReservationRestaurant;

import com.github.lgooddatepicker.components.TimePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class ReservationFormPanel extends JPanel {

    private JTextField txtName;
    private JTextField txtPhone;
    private JDatePickerImpl datePicker;
    private TimePicker timePicker;
    private JButton btnSubmit;

    // NUEVOS CAMPOS
    private JTextField apellidoField;
    private JTextField dniField;
    private JTextField edadField;
    private JComboBox<String> sexoComboBox;

    public ReservationFormPanel() {
        setBackground(new Color(249, 230, 207));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        // Nombre
        JLabel lblName = new JLabel("Nombre: ");
        txtName = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = y;
        add(lblName, gbc);
        gbc.gridx = 1;
        add(txtName, gbc);

        // Apellido
        JLabel lblApellido = new JLabel("Apellido: ");
        apellidoField = new JTextField(20);
        gbc.gridx = 2;
        add(lblApellido, gbc);
        gbc.gridx = 3;
        add(apellidoField, gbc);
        y++;

        // Teléfono
        JLabel lblPhone = new JLabel("Teléfono: ");
        txtPhone = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = y;
        add(lblPhone, gbc);
        gbc.gridx = 1;
        add(txtPhone, gbc);

        // DNI
        JLabel lblDni = new JLabel("DNI: ");
        dniField = new JTextField(15);
        gbc.gridx = 2;
        add(lblDni, gbc);
        gbc.gridx = 3;
        add(dniField, gbc);
        y++;

        // Edad
        JLabel lblEdad = new JLabel("Edad: ");
        edadField = new JTextField(3);
        gbc.gridx = 0; gbc.gridy = y;
        add(lblEdad, gbc);
        gbc.gridx = 1;
        add(edadField, gbc);

        // Sexo
        JLabel lblSexo = new JLabel("Sexo: ");
        String[] opcionesSexo = {"Masculino", "Femenino", "Otro"};
        sexoComboBox = new JComboBox<>(opcionesSexo);
        gbc.gridx = 2;
        add(lblSexo, gbc);
        gbc.gridx = 3;
        add(sexoComboBox, gbc);
        y++;

        // Fecha
        JLabel lblDate = new JLabel("Fecha: ");
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        gbc.gridx = 0; gbc.gridy = y;
        add(lblDate, gbc);
        gbc.gridx = 1;
        add(datePicker, gbc);

        // Hora
        JLabel lblTime = new JLabel("Hora: ");
        timePicker = new TimePicker();
        gbc.gridx = 2;
        add(lblTime, gbc);
        gbc.gridx = 3;
        add(timePicker, gbc);
        y++;

        // Botón
        btnSubmit = new JButton("Reservar");
        gbc.gridx = 0; gbc.gridy = y;
        gbc.gridwidth = 4;
        add(btnSubmit, gbc);

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleReservation();
            }
        });
    }

    public void handleReservation() {
        String name = txtName.getText();
        String apellido = apellidoField.getText();
        String phone = txtPhone.getText();
        String dni = dniField.getText();
        String edadTexto = edadField.getText();
        String sexo = (String) sexoComboBox.getSelectedItem();
        String date = datePicker.getJFormattedTextField().getText();
        String time = timePicker.getText();

        if (name.isEmpty() || apellido.isEmpty() || phone.isEmpty() ||
                dni.isEmpty() || edadTexto.isEmpty() || date.isEmpty() || time.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor complete todos los campos",
                    "Error de validación", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Edad debe ser un número válido",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aquí puedes usar estos datos como necesites
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + apellido);
        System.out.println("Teléfono: " + phone);
        System.out.println("DNI: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo);
        System.out.println("Fecha: " + date);
        System.out.println("Hora: " + time);

        // Esta parte solo guarda los datos básicos
        ReservationTablePanel.addReservation(
                new Reservation(name, apellido, phone, dni, edad, sexo, date, time)
        );

        JOptionPane.showMessageDialog(this,
                "Reserva registrada exitosamente",
                "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        clearForm();
    }

    private void clearForm() {
        txtName.setText("");
        apellidoField.setText("");
        txtPhone.setText("");
        dniField.setText("");
        edadField.setText("");
        sexoComboBox.setSelectedIndex(0);
        datePicker.getJFormattedTextField().setText("");
        timePicker.setText("");
    }
}
