import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Representa un animal general.
 */
class Animal {
    protected String nombreCientifico;
    protected String habitat;
    protected int esperanzaVida;

    /**
     * Constructor de Animal.
     * @param nombreCientifico Nombre científico del animal.
     * @param habitat Hábitat del animal.
     * @param esperanzaVida Años de vida.
     */
    public Animal(String nombreCientifico, String habitat, int esperanzaVida) {
        this.nombreCientifico = nombreCientifico;
        this.habitat = habitat;
        this.esperanzaVida = esperanzaVida;
    }
}

/**
 * Representa un ave, hereda de Animal.
 */
class Ave extends Animal {
    protected double envergaduraAlas;
    protected String tipoPico;
    protected boolean esVoladora;
    protected String colorPlumaje;
    protected int huevosPorPuesta;
    protected double peso;
    protected String dieta;

    /**
     * Constructor de Ave.
     * @param nombreCientifico Nombre científico.
     * @param habitat Hábitat natural.
     * @param esperanzaVida Años de vida.
     * @param envergaduraAlas Envergadura en metros.
     * @param tipoPico Tipo de pico.
     * @param esVoladora Indica si vuela.
     * @param colorPlumaje Color de plumas.
     * @param huevosPorPuesta Número de huevos.
     * @param peso Peso en kilogramos.
     * @param dieta Dieta del ave.
     */
    public Ave(String nombreCientifico, String habitat, int esperanzaVida, double envergaduraAlas, String tipoPico,
               boolean esVoladora, String colorPlumaje, int huevosPorPuesta, double peso, String dieta) {
        super(nombreCientifico, habitat, esperanzaVida);
        this.envergaduraAlas = envergaduraAlas;
        this.tipoPico = tipoPico;
        this.esVoladora = esVoladora;
        this.colorPlumaje = colorPlumaje;
        this.huevosPorPuesta = huevosPorPuesta;
        this.peso = peso;
        this.dieta = dieta;
    }

    /**
     * Calcula la comida diaria.
     * @return Comida en gramos.
     */
    public double calcularComidaDiaria() {
        if (this.peso <= 0.2) {
            return this.peso * 0.25 * 1000;
        } else if (this.peso <= 0.8) {
            return this.peso * 0.15 * 1000;
        } else if (this.peso <= 7) {
            return this.peso * 0.10 * 1000;
        } else {
            return this.peso * 0.035 * 1000;
        }
    }

    /**
     * Calcula el costo mensual de mantenimiento.
     * @return Costo mensual.
     */
    public double calcularCostoMantenimiento() {
        int costoRecinto;
        if (this.peso <= 0.2) {
            costoRecinto = 150;
        } else if (this.peso <= 0.8) {
            costoRecinto = 200;
        } else if (this.peso <= 7) {
            costoRecinto = 300;
        } else {
            costoRecinto = 500;
        }
        double comidaDiaria = this.calcularComidaDiaria();
        return (costoRecinto + comidaDiaria) * 30;
    }
}

/**
 * Representa un ave voladora.
 */
class AveVoladora extends Ave {
    private double velocidadVuelo;
    private double alturaMaxima;
    private boolean esMigratoria;

    /**
     * Constructor de AveVoladora.
     * @param nombreCientifico Nombre científico.
     * @param habitat Hábitat natural.
     * @param esperanzaVida Años de vida.
     * @param envergaduraAlas Envergadura en metros.
     * @param tipoPico Tipo de pico.
     * @param colorPlumaje Color de plumas.
     * @param huevosPorPuesta Número de huevos.
     * @param peso Peso en kilogramos.
     * @param dieta Dieta del ave.
     * @param velocidadVuelo Velocidad en km/h.
     * @param alturaMaxima Altura máxima de vuelo en metros.
     * @param esMigratoria Indica si es migratoria.
     */
    public AveVoladora(String nombreCientifico, String habitat, int esperanzaVida, double envergaduraAlas,
                       String tipoPico, String colorPlumaje, int huevosPorPuesta, double peso, String dieta,
                       double velocidadVuelo, double alturaMaxima, boolean esMigratoria) {
        super(nombreCientifico, habitat, esperanzaVida, envergaduraAlas, tipoPico, true, colorPlumaje, huevosPorPuesta, peso, dieta);
        this.velocidadVuelo = velocidadVuelo;
        this.alturaMaxima = alturaMaxima;
        this.esMigratoria = esMigratoria;
    }

    /**
     * Calcula el espacio necesario para el ave.
     * @return Espacio en metros cuadrados.
     */
    public double calcularEspacioRecinto() {
        return Math.max(5, this.envergaduraAlas * 5);
    }
}

/**
 * Representa un ave no voladora.
 */
class AveNoVoladora extends Ave {
    private double velocidadDesplazamiento;
    private String tipoDesplazamiento;

    /**
     * Constructor de AveNoVoladora.
     * @param nombreCientifico Nombre científico.
     * @param habitat Hábitat natural.
     * @param esperanzaVida Años de vida.
     * @param envergaduraAlas Envergadura en metros.
     * @param tipoPico Tipo de pico.
     * @param colorPlumaje Color de plumas.
     * @param huevosPorPuesta Número de huevos.
     * @param peso Peso en kilogramos.
     * @param dieta Dieta del ave.
     * @param velocidadDesplazamiento Velocidad en km/h.
     * @param tipoDesplazamiento Tipo de desplazamiento (corre/nada).
     */
    public AveNoVoladora(String nombreCientifico, String habitat, int esperanzaVida, double envergaduraAlas,
                         String tipoPico, String colorPlumaje, int huevosPorPuesta, double peso, String dieta,
                         double velocidadDesplazamiento, String tipoDesplazamiento) {
        super(nombreCientifico, habitat, esperanzaVida, envergaduraAlas, tipoPico, false, colorPlumaje, huevosPorPuesta, peso, dieta);
        this.velocidadDesplazamiento = velocidadDesplazamiento;
        this.tipoDesplazamiento = tipoDesplazamiento;
    }

    /**
     * Calcula el espacio necesario según el tipo de desplazamiento.
     * @return Espacio en metros cuadrados.
     */
    public double calcularEspacioRecinto() {
        if (this.tipoDesplazamiento.equals("corre")) {
            return this.peso > 7 ? 450 : 200;
        } else if (this.tipoDesplazamiento.equals("nada")) {
            return this.peso > 7 ? 300 : 150;
        }
        return 0;
    }
}

/**
 * Clase principal que gestiona un zoológico de aves.
 */
public class ZooAves {

    private static List<String> registroAceptados = new ArrayList<>();

    /**
     * Guarda un registro de animales aceptados en un archivo.
     * @param animal Nombre del animal.
     * @param fecha Fecha de aceptación.
     */
    public static void guardarAnimalAceptado(String animal, String fecha) {
        registroAceptados.add(animal + " - Aceptado el: " + fecha);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("animales_aceptados.txt", true))) {
            writer.write(animal + " - Aceptado el: " + fecha + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el registro.");
        }
    }

    /**
     * Muestra el historial de animales aceptados.
     */
    public static void mostrarAnimalesAceptados() {
        System.out.println("\nHistorial de animales aceptados:");
        for (String registro : registroAceptados) {
            System.out.println(registro);
        }
    }

    /**
     * Evalúa si un animal puede ser aceptado en el zoológico según presupuesto.
     * @param presupuesto Presupuesto anual disponible.
     * @param costoRecinto Costo de construir el recinto.
     * @param costoMantenimiento Costo mensual de mantenimiento.
     * @return true si se puede aceptar, false de lo contrario.
     */
    public static boolean evaluarAceptacion(double presupuesto, double costoRecinto, double costoMantenimiento) {
        double costoTotalAnual = (costoRecinto + costoMantenimiento) * 12;
        return presupuesto >= costoTotalAnual;
    }

    /**
     * Método principal que ejecuta el programa.
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de un ave voladora
        AveVoladora aguila = new AveVoladora("Aquila chrysaetos", "Montañas", 20, 2.5, "Pico afilado", "Marrón", 2, 6.5, "Carnívora", 120, 3000, true);
        double espacioAguila = aguila.calcularEspacioRecinto();
        double comidaAguila = aguila.calcularComidaDiaria();
        double costoMantenimientoAguila = aguila.calcularCostoMantenimiento();

        System.out.println("Datos del Águila:");
        System.out.println("Espacio requerido: " + espacioAguila + " m²");
        System.out.println("Comida diaria: " + comidaAguila + " g");
        System.out.println("Costo mensual: Q" + costoMantenimientoAguila);

        // Simular la aceptación del ave
        System.out.print("\nIngrese el presupuesto anual disponible: Q");
        double presupuesto = scanner.nextDouble();

        System.out.print("Ingrese el costo de construir el recinto si es necesario: Q");
        double costoRecinto = scanner.nextDouble();

        boolean seAcepta = evaluarAceptacion(presupuesto, costoRecinto, costoMantenimientoAguila);

        if (seAcepta) {
            System.out.println("\nEl zoológico puede aceptar al águila.");
            String fechaAceptacion = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            guardarAnimalAceptado("Águila (Aquila chrysaetos)", fechaAceptacion);
        } else {
            System.out.println("\nNo se puede aceptar al águila debido a los costos.");
        }

        // Mostrar historial de animales aceptados
        mostrarAnimalesAceptados();

        scanner.close();
    }
}
