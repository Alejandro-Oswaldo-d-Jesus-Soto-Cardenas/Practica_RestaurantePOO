package pe.edu.vallegrande.ReservationRestaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReservationTablePanel extends JPanel {

    public static DefaultTableModel tableModel;

    public ReservationTablePanel() {
        setLayout(new BorderLayout());

        // Nuevas columnas con los campos añadidos
        String[] columnNames = {
                "Nombre", "Apellido", "Teléfono", "DNI", "Edad", "Sexo", "Fecha", "Hora"
        };

        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public static void addReservation(Reservation reservation) {
        Object[] row = {
                reservation.getName(),
                reservation.getApellido(),
                reservation.getPhone(),
                reservation.getDni(),
                reservation.getEdad(),
                reservation.getSexo(),
                reservation.getDate(),
                reservation.getTime()
        };

        tableModel.addRow(row);
    }
}

