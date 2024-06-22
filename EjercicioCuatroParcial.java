/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciocuatroparcial;
    
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EjercicioCuatroParcial {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MundialApp().setVisible(true));
    }
}

class MundialApp extends JFrame {
    private JTabbedPane tabbedPane;
    private Mundial mundial;

    // Componentes para la pestaña de Equipos
    private JTextField nombreEquipoField, entrenadorField;
    private JTextField nombreJugadorField, edadJugadorField, posicionJugadorField;
    private JButton registrarEquipoButton, registrarJugadorButton;
    private JList<String> equiposList;
    private DefaultListModel<String> equiposListModel;

    // Componentes para la pestaña de Partidos
    private JComboBox<String> equipoLocalCombo, equipoVisitanteCombo;
    private JTextField resultadoField;
    private JButton registrarPartidoButton;
    private JList<String> partidosList;
    private DefaultListModel<String> partidosListModel;

    // Componentes para la pestaña de Grupos
    private JTextField nombreGrupoField;
    private JButton registrarGrupoButton;
    private JList<String> gruposList;
    private DefaultListModel<String> gruposListModel;

    // Componentes para la pestaña de Estadios
    private JTextField nombreEstadioField, ciudadEstadioField, capacidadEstadioField;
    private JButton registrarEstadioButton;
    private JList<String> estadiosList;
    private DefaultListModel<String> estadiosListModel;

    public MundialApp() {
        super("Mundial App");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mundial = new Mundial();

        tabbedPane = new JTabbedPane();
        
        initEquiposTab();
        initPartidosTab();
        initGruposTab();
        initEstadiosTab();

        add(tabbedPane);
    }

    private void initEquiposTab() {
        JPanel equiposPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        nombreEquipoField = new JTextField(20);
        entrenadorField = new JTextField(20);
        registrarEquipoButton = new JButton("Registrar Equipo");

        nombreJugadorField = new JTextField(20);
        edadJugadorField = new JTextField(20);
        posicionJugadorField = new JTextField(20);
        registrarJugadorButton = new JButton("Registrar Jugador");

        inputPanel.add(new JLabel("Nombre del Equipo:"));
        inputPanel.add(nombreEquipoField);
        inputPanel.add(new JLabel("Entrenador:"));
        inputPanel.add(entrenadorField);
        inputPanel.add(registrarEquipoButton);
        inputPanel.add(new JLabel()); // Espaciador
        inputPanel.add(new JLabel("Nombre del Jugador:"));
        inputPanel.add(nombreJugadorField);
        inputPanel.add(new JLabel("Edad del Jugador:"));
        inputPanel.add(edadJugadorField);
        inputPanel.add(new JLabel("Posición del Jugador:"));
        inputPanel.add(posicionJugadorField);
        inputPanel.add(registrarJugadorButton);

        equiposListModel = new DefaultListModel<>();
        equiposList = new JList<>(equiposListModel);

        registrarEquipoButton.addActionListener(e -> registrarEquipo());
        registrarJugadorButton.addActionListener(e -> registrarJugador());

        equiposPanel.add(inputPanel, BorderLayout.NORTH);
        equiposPanel.add(new JScrollPane(equiposList), BorderLayout.CENTER);

        tabbedPane.addTab("Equipos", equiposPanel);
    }

    private void initPartidosTab() {
        JPanel partidosPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        equipoLocalCombo = new JComboBox<>();
        equipoVisitanteCombo = new JComboBox<>();
        resultadoField = new JTextField(20);
        registrarPartidoButton = new JButton("Registrar Partido");

        inputPanel.add(new JLabel("Equipo Local:"));
        inputPanel.add(equipoLocalCombo);
        inputPanel.add(new JLabel("Equipo Visitante:"));
        inputPanel.add(equipoVisitanteCombo);
        inputPanel.add(new JLabel("Resultado:"));
        inputPanel.add(resultadoField);
        inputPanel.add(registrarPartidoButton);

        partidosListModel = new DefaultListModel<>();
        partidosList = new JList<>(partidosListModel);

        registrarPartidoButton.addActionListener(e -> registrarPartido());

        partidosPanel.add(inputPanel, BorderLayout.NORTH);
        partidosPanel.add(new JScrollPane(partidosList), BorderLayout.CENTER);

        tabbedPane.addTab("Partidos", partidosPanel);
    }

    private void initGruposTab() {
        JPanel gruposPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        nombreGrupoField = new JTextField(20);
        registrarGrupoButton = new JButton("Registrar Grupo");

        inputPanel.add(new JLabel("Nombre del Grupo:"));
        inputPanel.add(nombreGrupoField);
        inputPanel.add(registrarGrupoButton);

        gruposListModel = new DefaultListModel<>();
        gruposList = new JList<>(gruposListModel);

        registrarGrupoButton.addActionListener(e -> registrarGrupo());

        gruposPanel.add(inputPanel, BorderLayout.NORTH);
        gruposPanel.add(new JScrollPane(gruposList), BorderLayout.CENTER);

        tabbedPane.addTab("Grupos", gruposPanel);
    }

    private void initEstadiosTab() {
        JPanel estadiosPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        nombreEstadioField = new JTextField(20);
        ciudadEstadioField = new JTextField(20);
        capacidadEstadioField = new JTextField(20);
        registrarEstadioButton = new JButton("Registrar Estadio");

        inputPanel.add(new JLabel("Nombre del Estadio:"));
        inputPanel.add(nombreEstadioField);
        inputPanel.add(new JLabel("Ciudad:"));
        inputPanel.add(ciudadEstadioField);
        inputPanel.add(new JLabel("Capacidad:"));
        inputPanel.add(capacidadEstadioField);
        inputPanel.add(registrarEstadioButton);

        estadiosListModel = new DefaultListModel<>();
        estadiosList = new JList<>(estadiosListModel);

        registrarEstadioButton.addActionListener(e -> registrarEstadio());

        estadiosPanel.add(inputPanel, BorderLayout.NORTH);
        estadiosPanel.add(new JScrollPane(estadiosList), BorderLayout.CENTER);

        tabbedPane.addTab("Estadios", estadiosPanel);
    }

    private void registrarEquipo() {
        String nombre = nombreEquipoField.getText();
        String entrenador = entrenadorField.getText();
        if (!nombre.isEmpty() && !entrenador.isEmpty()) {
            Equipo equipo = new Equipo(nombre, entrenador);
            mundial.registrarEquipo(equipo);
            equiposListModel.addElement(equipo.toString());
            equipoLocalCombo.addItem(nombre);
            equipoVisitanteCombo.addItem(nombre);
            nombreEquipoField.setText("");
            entrenadorField.setText("");
        }
    }

    private void registrarJugador() {
        String nombre = nombreJugadorField.getText();
        String edadStr = edadJugadorField.getText();
        String posicion = posicionJugadorField.getText();
        if (!nombre.isEmpty() && !edadStr.isEmpty() && !posicion.isEmpty()) {
            try {
                int edad = Integer.parseInt(edadStr);
                Jugador jugador = new Jugador(nombre, edad, posicion);
                int selectedIndex = equiposList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Equipo equipo = mundial.getEquipos().get(selectedIndex);
                    equipo.agregarJugador(jugador);
                    JOptionPane.showMessageDialog(this, "Jugador registrado con éxito.");
                    nombreJugadorField.setText("");
                    edadJugadorField.setText("");
                    posicionJugadorField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, seleccione un equipo primero.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La edad debe ser un número entero.");
            }
        }
    }

    private void registrarPartido() {
        String equipoLocal = (String) equipoLocalCombo.getSelectedItem();
        String equipoVisitante = (String) equipoVisitanteCombo.getSelectedItem();
        String resultado = resultadoField.getText();
        if (equipoLocal != null && equipoVisitante != null && !resultado.isEmpty()) {
            Equipo local = mundial.getEquipoByNombre(equipoLocal);
            Equipo visitante = mundial.getEquipoByNombre(equipoVisitante);
            if (local != null && visitante != null) {
                Partido partido = new Partido(local, visitante);
                partido.jugarPartido(resultado);
                mundial.registrarPartido(partido);
                partidosListModel.addElement(partido.mostrarResultado());
                resultadoField.setText("");
            }
        }
    }

    private void registrarGrupo() {
        String nombre = nombreGrupoField.getText();
        if (!nombre.isEmpty()) {
            Grupo grupo = new Grupo(nombre);
            mundial.registrarGrupo(grupo);
            gruposListModel.addElement(grupo.getNombre());
            nombreGrupoField.setText("");
        }
    }

    private void registrarEstadio() {
        String nombre = nombreEstadioField.getText();
        String ciudad = ciudadEstadioField.getText();
        String capacidadStr = capacidadEstadioField.getText();
        if (!nombre.isEmpty() && !ciudad.isEmpty() && !capacidadStr.isEmpty()) {
            try {
                int capacidad = Integer.parseInt(capacidadStr);
                Estadio estadio = new Estadio(nombre, ciudad, capacidad);
                mundial.registrarEstadio(estadio);
                estadiosListModel.addElement(estadio.mostrarInfo());
                nombreEstadioField.setText("");
                ciudadEstadioField.setText("");
                capacidadEstadioField.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La capacidad debe ser un número entero.");
            }
        }
    }
}

class Mundial {
    private ArrayList<Equipo> equipos;
    private ArrayList<Partido> partidos;
    private ArrayList<Grupo> grupos;
    private ArrayList<Estadio> estadios;

    public Mundial() {
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
        grupos = new ArrayList<>();
        estadios = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void registrarPartido(Partido partido) {
        partidos.add(partido);
    }

    public void registrarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public void registrarEstadio(Estadio estadio) {
        estadios.add(estadio);
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public Equipo getEquipoByNombre(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
        return null;
    }
}

class Equipo {
    private String nombre;
    private String entrenador;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " - Entrenador: " + entrenador;
    }
}

class Jugador {
    private String nombre;
    private int edad;
    private String posicion;

    public Jugador(String nombre, int edad, String posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return nombre + " - " + edad + " años - " + posicion;
    }
}

class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String resultado;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public void jugarPartido(String resultado) {
        this.resultado = resultado;
    }

    public String mostrarResultado() {
        return equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre() + " - Resultado: " + resultado;
    }
}

class Grupo {
    private String nombre;
    private ArrayList<Equipo> equipos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }
}

class Estadio {
    private String nombre;
    private String ciudad;
    private int capacidad;

    public Estadio(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    public String mostrarInfo() {
        return "Estadio: " + nombre + " - Ciudad: " + ciudad + " - Capacidad: " + capacidad;
    }
}