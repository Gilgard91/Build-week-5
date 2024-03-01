package be.epicode.buildWeek5.CSV;

import au.com.bytecode.opencsv.CSVReader;
import be.epicode.buildWeek5.entities.Comune;
import be.epicode.buildWeek5.entities.Provincia;
import be.epicode.buildWeek5.repositories.ComuniDAO;
import be.epicode.buildWeek5.repositories.ProvinceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class CSVImporter {

    @Autowired
    private ProvinceDAO provinceDAO;
    @Autowired
    private ComuniDAO comuniDAO;


    public void importProvince(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName), ';')) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String sigla = nextLine[0];
                String nome = nextLine[1];

                switch (nome) {
                    case "Verbania":
                        nome = "Verbano-Cusio-Ossola";
                        break;
                    case "Aosta":
                        nome = "Valle d'Aosta/Vallée d'Aoste";
                        break;
                    case "Monza-Brianza":
                        nome = "Monza e della Brianza";
                        break;
                    case "Bolzano":
                        nome = "Bolzano/Bozen";
                        break;
                    case "La-Spezia":
                        nome = "La Spezia";
                        break;
                    case "Reggio-Emilia":
                        nome = "Reggio nell'Emilia";
                        break;
                    case "Forli-Cesena":
                        nome = "Forlì-Cesena";
                        break;
                    case "Pesaro-Urbino":
                        nome = "Pesaro e Urbino";
                        break;
                    case "Ascoli-Piceno":
                        nome = "Ascoli Piceno";
                        break;
                    case "Reggio-Calabria":
                        nome = "Reggio Calabria";
                        break;
                    case "Vibo-Valentia":
                        nome = "Vibo Valentia";
                        break;
                    case "Carbonia Iglesias":
                        nome = "Sud Sardegna";
                        break;

                }

                Provincia provincia = new Provincia(nome, sigla);

                provinceDAO.save(provincia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importComuni(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName), ';')) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String nome = nextLine[2];
                String nomeProvincia = nextLine.length >= 4 ? nextLine[3] : null;

                Provincia provincia = provinceDAO.findProvinceByNome(nomeProvincia);

                if (provincia != null) {
                    Comune comune = new Comune(nome, provincia);

                    comuniDAO.save(comune);
                }
                else{
                    System.out.println(nomeProvincia);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
