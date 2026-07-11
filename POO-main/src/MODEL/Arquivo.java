package MODEL;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Arquivo {

    static void salvar() {
        try {
            FileOutputStream arqv = new FileOutputStream("lindorpg.dat");
            //manda p construtor... p criar arqv com esse nome no final
            ObjectOutputStream arqvSalvar = new ObjectOutputStream(arqv);
            //manda p construtor de objectoutputstream
            arqvSalvar.write();

        } catch (Exception e) {

        }

        try {

        }
    }

}
