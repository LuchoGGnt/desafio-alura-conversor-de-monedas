package modulos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorArchivoJSON {
    public void guardarJSON(Moneda moneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File archivo = new File("conversion.json");

        List<Moneda> historial = new ArrayList<>();

        if (archivo.exists()) {
            try (FileReader reader = new FileReader(archivo)) {
                List<Moneda> historialExistente = gson.fromJson(reader, new TypeToken<List<Moneda>>(){}.getType());
                if (historialExistente != null) {
                    historial.addAll(historialExistente);
                }
            } catch (JsonSyntaxException e) {
                System.out.println("Error al leer el archivo JSON. Creando un nuevo historial...");
            }
        }

        historial.add(moneda);

        try (FileWriter escritura = new FileWriter(archivo)) {
            gson.toJson(historial, escritura);
        }
    }
}
