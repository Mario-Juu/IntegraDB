package org.mario;

import org.mario.controller.ContatoController;
import org.mario.model.Contato;
import org.mario.view.Menu;

import java.util.List;


public class Main {
    public static void main(String[] args)  {
        ContatoController cc = new ContatoController();
        cc.delete(7);
    }
}
