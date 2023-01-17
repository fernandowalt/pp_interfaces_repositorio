package org.walter.genericsclass;

public class EjemploGenericos {

    public static <T> void imprimirElementos(Camion<T> camion) {
        for (T a : camion) {

            if (a instanceof Animal) {
                System.out.println(((Animal) a).getNombre() + " " + ((Animal) a).getTipo());
            }
            if (a instanceof Automovil) {
                System.out.println(((Automovil) a).getMarca());

            }
            if (a instanceof Maquinaria) {
                System.out.println(((Maquinaria) a).getTipo());

            }
        }


    }


    public static <T> void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Pepe", Tipo.CABALLO));
        transporteCaballos.add(new Animal("Susi", Tipo.CABALLO));
        transporteCaballos.add(new Animal("Tunquen", Tipo.CABALLO));
        transporteCaballos.add(new Animal("Topocalma", Tipo.CABALLO));
        transporteCaballos.add(new Animal("Longotoma", Tipo.CABALLO));

        imprimirElementos(transporteCaballos);


        Camion<Maquinaria> transportarMaquinaria = new Camion<>(3);
        transportarMaquinaria.add(new Maquinaria("Bulldozer"));
        transportarMaquinaria.add(new Maquinaria("Grua Horquilla"));
        transportarMaquinaria.add(new Maquinaria("Perforadora"));

        imprimirElementos(transportarMaquinaria);


        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirElementos(transAuto);


    }
}




