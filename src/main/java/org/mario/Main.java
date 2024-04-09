package org.mario;

import org.mario.controller.ContatoController;
import org.mario.model.Contato;


public class Main {
    public static void main(String[] args)  {

        ContatoController contatoController = new ContatoController();
        //contatoController.create(new Contato("Mek","Mek@gmail.com","Meknenem"));
        //System.out.println(contatoController.getById(1));
        //contatoController.delete(1);
       // contatoController.update(new Contato("Maria", "maria@gmail.com","(49)8400-2530"), 1);
        System.out.println(contatoController.getAll());
        //contatoController.update(new Contato("Mario", "mario@gmail.com","(49)8900-2530"), 1);
        //System.out.println(contatoController.getById(1));
    }
}
