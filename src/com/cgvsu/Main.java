package com.cgvsu;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import com.cgvsu.objwriter.ObjWriter;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        // Тетраэдр
        String fileObj = "test";
        Path dataDir = Path.of("").toAbsolutePath().resolve("data");
        Path fileName = dataDir.resolve(fileObj + ".obj");
        // Цилиндр
        String fileObj2 = "test_2";
        Path dataDir2 = Path.of("").toAbsolutePath().resolve("data");
        Path fileName2 = dataDir2.resolve(fileObj2 +".obj");
        // NURBS Сфера
        String fileObj3 = "test_3";
        Path dataDir3 = Path.of("").toAbsolutePath().resolve("data");
        Path fileName3 = dataDir3.resolve(fileObj3 +".obj");

        String fileContent = Files.readString(fileName);
        String fileContent2 = Files.readString(fileName2);
        String fileContent3 = Files.readString(fileName3);
        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.getVertices().size());
        System.out.println("Texture vertices: " + model.getTextureVertices().size());
        System.out.println("Normals: " + model.getNormals().size());
        System.out.println("Polygons: " + model.getPolygons().size());

        System.out.println("\nSaving model back...");

        Path outputFile = fileName.resolveSibling(String.format(Locale.ROOT, "%s_output.obj", fileObj));
        ObjWriter.write(model, outputFile.toString());

        System.out.println("Model saved to: " + outputFile);
        System.out.println("\n" + "=".repeat(50));

        System.out.println("Loading model ...");

        Model model2 = ObjReader.read(fileContent2);

        System.out.println("Vertices: " + model2.getVertices().size());
        System.out.println("Texture vertices: " + model2.getTextureVertices().size());
        System.out.println("Normals: " + model2.getNormals().size());
        System.out.println("Polygons: " + model2.getPolygons().size());

        System.out.println("\nSaving model back...");

        Path outputFile2 = fileName.resolveSibling(String.format(Locale.ROOT, "%s_output.obj", fileObj2));
        ObjWriter.write(model2, outputFile2.toString());

        System.out.println("Model saved to: " + outputFile);
        System.out.println("\n" + "=".repeat(50));

        System.out.println("Loading model ...");

        Model model3 = ObjReader.read(fileContent3);

        System.out.println("Vertices: " + model3.getVertices().size());
        System.out.println("Texture vertices: " + model3.getTextureVertices().size());
        System.out.println("Normals: " + model3.getNormals().size());
        System.out.println("Polygons: " + model3.getPolygons().size());

        System.out.println("\nSaving model back...");

        Path outputFile3 = fileName.resolveSibling(String.format(Locale.ROOT, "%s_output.obj", fileObj3));
        ObjWriter.write(model3, outputFile3.toString());

        System.out.println("Model saved to: " + outputFile);
        System.out.println("\n" + "=".repeat(50));
    }
}