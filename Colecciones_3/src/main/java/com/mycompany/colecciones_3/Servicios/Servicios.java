/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.colecciones_3.Servicios;

import com.mycompany.colecciones_3.Atributos.Alumnos;
import java.util.*;

/**
 *
 * @author crowl
 */
public class Servicios {

    private ArrayList<Alumnos> Lista;
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Servicios() {
        Lista=new ArrayList<Alumnos>();
    }

    public void ingresoDatos() {

        String nombre;
        ArrayList<Integer> notas = new ArrayList<Integer>();
        int nota;
        System.out.println("Ingrese el nombre del Alumno");
        nombre = leer.next();
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese la nota N° " + (i + 1));
            nota = leer.nextInt();
            notas.add(nota);
        }
        System.out.println("=========================");
        crearAlumnos(nombre,notas);
    }

    public void crearAlumnos(String nombre, ArrayList<Integer> notas) {
        Alumnos alum = new Alumnos();
        alum.setAlumnos(nombre);
        alum.setNotas(notas);
        agregarAl(alum);
    }

    public void agregarAl(Alumnos alum) {
        Lista.add(alum);
    }

    public void mostar() {
        for (Alumnos alumnos : Lista) {
            System.out.println(alumnos);
            
        }
    }

    public Alumnos encontrar() {
        System.out.println("Ingrese el nombre del alumno a buscar");
        String nombre = leer.next();
        Alumnos alum = buscar(nombre);
        if (alum != null) {
            System.out.println("La nota final del alumno es: " + notaFinal(alum));
            System.out.println("=========================");
        } else {
            System.out.println("No existe el alumno con el nombre ingresado");
        }
        return alum;
    }

    public Alumnos buscar(String alumno) {
        Alumnos alum = null;
        for (Alumnos var : Lista) {
            if (var.getAlumnos().equalsIgnoreCase(alumno)) {
                alum = var;
                break;
            }

        }
        return alum;
    }

    public double notaFinal(Alumnos alum) {
        int total = 0;
        for (int nota : alum.getNotas()) {
            total += nota;
        }
        return (double) total / alum.getNotas().size();
    }
}
