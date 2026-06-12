package edu.teamrocket.central;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA STARNAV ===");
        System.out.println("[INFO] Registrando naves en la flota...");

        // NOTA: El estudiante debe crear la clase FlotaSpacial que implementa Gestionable
        FlotaSpacial miFlota = new FlotaSpacial();

        // 1. Instanciar usando el Enumerado con constructor privado
        Nave nave1 = new Nave("NX-01", "Enterprise", 100.0, TipoMision.EXPLORACION);
        Nave nave2 = new Nave("M-01", "Milano", 50.0, TipoMision.CONVOY);

        // CRUD: Create
        miFlota.agregar(nave1);
        miFlota.agregar(nave2);

        System.out.println("=== BUSCANDO NAVES (Uso de Optionals) ===");
        // CRUD: Read empleando Optional e isPresent()
        Optional<Nave> busqueda1 = miFlota.buscarPorId("NX-01");
        if (busqueda1.isPresent()) {
            Nave n = busqueda1.get();
            System.out.println("¿Existe la nave NX-01?: SÍ -> Nombre: " + n.getNombre() 
                + " | Misión: " + n.getTipoMision() 
                + " (Peligro: " + n.getTipoMision().getNivelPeligro() + ")");
        } else {
            System.out.println("¿Existe la nave NX-01?: NO -> Nave no encontrada en el radar.");
        }

        Optional<Nave> busqueda2 = miFlota.buscarPorId("X-WING");
        if (busqueda2.isPresent()) {
            System.out.println("¿Existe la nave X-WING?: SÍ");
        } else {
            System.out.println("¿Existe la nave X-WING?: NO -> Nave no encontrada en el radar.");
        }

        System.out.println("\n=== REPORTE DE ACTUALIZACIÓN (CRUD - Update) ===");
        // CRUD: Update
        System.out.println("[UPDATE] Actualizando combustible de la Milano...");
        boolean actualizado = miFlota.actualizarCombustible("M-01", 95.5);
        if (actualizado) {
            System.out.println("¡Combustible actualizado con éxito a 95.5%!");
        } else {
            System.out.println("[ERROR] No se pudo actualizar la nave.");
        }

        System.out.println("\n=== LISTADO COMPLETO DE LA FLOTA (Loops No Cableados) ===");
        // Uso de ArrayList dinámico obtenido desde el HashMap para recorrer sin cablear
        List<Nave> listaNaves = miFlota.obtenerTodasLasNaves();
        
        // Bucle dinámico basado estrictamente en el tamaño de la colección
        for (int i = 0; i < listaNaves.size(); i++) {
            Nave n = listaNaves.get(i);
            System.out.println("Nave " + (i + 1) + ": ID: " + n.getId() 
                + " | Nombre: " + n.getNombre() 
                + " | Combustible: " + n.getCombustible() + "L");
        }
        System.out.println("=================================");
    }
}