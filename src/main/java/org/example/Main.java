package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opcionMenu;
        System.out.println("taller para el parcial 2");
        System.out.println("1. Empresa TUYA");
        System.out.println("2. Hector y Tito");
        System.out.println("3.Moda express");
        System.out.println("4.piedra papel y tijera");
        System.out.println("5.salir");
        do {
            System.out.print("ingrese la opcion deseada: ");
            opcionMenu=sc.nextInt();
            if (opcionMenu==1){
                Double deudaTotal=0.0;
                System.out.println("Sistema de manejo de deuda empresa TUYA");
                sc.nextLine();
                System.out.print("ingrese su nombre: ");
                String NombreUsuario=sc.nextLine();
                System.out.print("intrese su edad: ");
                Integer edadUsuario=sc.nextInt();
                System.out.print("ingrese el numero de usos de la tarjeta el ultmo mes: ");
                Integer usosTarjeta=sc.nextInt();
                System.out.print("ingrese el monto gastado en productos de aseo: ");
                Double montoAseo=sc.nextDouble();
                System.out.print("ingrese el monto gastado en productos alimenticios: ");
                Double montoAlimento=sc.nextDouble();
                System.out.print("ingrese el monto gastado en otros gastos: ");
                Double montosExtra=sc.nextDouble();
                System.out.println("ingrese su puntaje de credito 1-9");
                int puntaje=sc.nextInt();
                deudaTotal=montoAlimento+montoAseo+montosExtra;
                if (puntaje==1){
                    System.out.println("por su puntaje: "+puntaje+" se aplicara 25% de descuento");
                    deudaTotal*=0.25;
                } else if (puntaje==2) {
                    System.out.println("por su puntaje: "+puntaje+" se aplicara 20% de descuento");
                    deudaTotal*=0.20;
                } else if (puntaje==3) {
                    System.out.println("por su puntaje: "+puntaje+" se aplicara 15% de descuento");
                    deudaTotal*=0.15;
                } else if (puntaje==4) {
                    System.out.println("por su puntaje: "+puntaje+" se aplicara 10% de descuento");
                    deudaTotal*=0.10;
                } else if (puntaje>=5 && puntaje<=9) {
                    System.out.println("puntaje no aplica para descuento");
                }else {
                    System.out.println("puntaje incorrecto");
                }
                System.out.println("su deuda total con el descuento es de: $"+deudaTotal);


            } else if (opcionMenu==2) {
                System.out.println("Sistema compra de boletas");
                sc.nextLine();
                System.out.print("ingrese su nombre: ");
                String NombreUsuario=sc.nextLine();
                System.out.println("ingrese su numero de cedula: ");
                String cedulaUsuario=sc.nextLine();
                System.out.print("intrese su edad: ");
                Integer edadUsuario=sc.nextInt();
                if (edadUsuario>=18){
                    System.out.println("ingrese cuantas boletas quiere para VIP, valor $450.000");
                    Integer cantidadBoletas=sc.nextInt();
                    if (cantidadBoletas>4) {
                        System.out.println("El total de la compra es de: " + (450000 * cantidadBoletas) + " para: " +
                                +cantidadBoletas + " boletas");
                    }else {
                        System.out.println("solo puede adquirir maximo 4");
                    }
                }else {
                    System.out.println("Edad incorrecta no puede comprar boletas");
                }
            } else if (opcionMenu==3) {
                System.out.println("Sistema de gestion de descuentos Moda Express");
                sc.nextLine();
                System.out.print("ingrese su nombre: ");
                String NombreUsuario=sc.nextLine();
                System.out.println("ingrese su tipo de cliente: /regular/vip");
                String tipoCliente=sc.nextLine().toLowerCase();
                System.out.println("ingrese la cantidad de articulos comprados: ");
                int cantidadArticulos=sc.nextInt();
                System.out.println("Ingrese el precio total de la compra: ");
                Double totalCompra=sc.nextDouble();
                totalCompra-= (totalCompra*calcularDescuento(tipoCliente,cantidadArticulos));
                System.out.println("el total de su compra es de: $" +totalCompra);

            } else if (opcionMenu==4) {
                System.out.println("Bienvenido a piedra, papel o tijera");
                System.out.println("ingrese una opcion: piedra/papel/tijera");
                sc.nextLine();
                String opcionUsuario=sc.nextLine().toLowerCase();
                Random random=new Random();

                if (opcionUsuario.equals("piedra")||opcionUsuario.equals("papel")||opcionUsuario.equals("tijera")){
                    String[] opciones ={"piedra","papel","tijera"};
                    int opcionInt= random.nextInt(opciones.length);
                    String opcionPc=opciones[opcionInt];
                    if (opcionUsuario.equals(opcionPc)){
                        System.out.println("empate de la maquina con: "+opcionPc);
                    } else if ((opcionUsuario.equals("piedra") && opcionPc.equals("tijera")) ||
                                (opcionUsuario.equals("papel") && opcionPc.equals("piedra")) ||
                                (opcionUsuario.equals("tijera") && opcionPc.equals("papel")) ) {
                        System.out.println(" ganaste, la computadora saco: "+opcionPc);

                    }else {
                        System.out.println("la computadora gana con: "+opcionPc);
                    }


                }else{
                    System.out.println("opcion no valida");
                }


            }else if (opcionMenu==5){

            }else {
                System.out.println("digite una opcion correcta");
            }

        }while (opcionMenu!=5);

    }
    private static double calcularDescuento(String tipoCliente, int cantidadArticulos) {
        if (tipoCliente.equalsIgnoreCase("Regular")) {
            if (cantidadArticulos >= 1 && cantidadArticulos <= 3) {
                return 0.05;
            } else if (cantidadArticulos >= 4 && cantidadArticulos <= 6) {
                return 0.10;
            } else {
                return 0.15;
            }
        } else if (tipoCliente.equalsIgnoreCase("VIP")) {
            if (cantidadArticulos >= 1 && cantidadArticulos <= 3) {
                return 0.10;
            } else if (cantidadArticulos >= 4 && cantidadArticulos <= 6) {
                return 0.15;
            } else {
                return 0.20;
            }
        } else {
            // Tipo de cliente no válido, sin descuento
            return 0;
        }
    }
}