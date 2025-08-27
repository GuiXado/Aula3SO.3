package view;

import controller.DistroController;

public class Principal {

    public static void main(String[] args) {
        DistroController distro = new DistroController();
        distro.exibeDistro();
    }
}
