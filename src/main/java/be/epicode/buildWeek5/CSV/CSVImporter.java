package be.epicode.buildWeek5.CSV;

import au.com.bytecode.opencsv.CSVReader;
import be.epicode.buildWeek5.entities.Municipality;
import be.epicode.buildWeek5.entities.Province;
import be.epicode.buildWeek5.repositories.MunicipalitiesDAO;
import be.epicode.buildWeek5.repositories.ProvincesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class CSVImporter {

    @Autowired
    private ProvincesDAO provincesDAO;
    @Autowired
    private MunicipalitiesDAO municipalitiesDAO;

//    private Map<String, Province> provinceMap = new HashMap<>();

    public void importProvinces(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName), ';')) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String code = nextLine[0];
                String name = nextLine[1];

                switch (name) {
                    case "Verbania":
                        name = "Verbano-Cusio-Ossola";
                        break;
                    case "Aosta":
                        name = "Valle d'Aosta/Vallée d'Aoste";
                        break;
                    case "Monza-Brianza":
                        name = "Monza e della Brianza";
                        break;
                    case "Bolzano":
                        name = "Bolzano/Bozen";
                        break;
                    case "La-Spezia":
                        name = "La Spezia";
                        break;
                    case "Reggio-Emilia":
                        name = "Reggio nell'Emilia";
                        break;
                    case "Forli-Cesena":
                        name = "Forlì-Cesena";
                        break;
                    case "Pesaro-Urbino":
                        name = "Pesaro e Urbino";
                        break;
                    case "Ascoli-Piceno":
                        name = "Ascoli Piceno";
                        break;
                    case "Reggio-Calabria":
                        name = "Reggio Calabria";
                        break;
                    case "Vibo-Valentia":
                        name = "Vibo Valentia";
                        break;
                    case "Carbonia Iglesias":
                        name = "Sud Sardegna";
                        break;

                }

                Province province = new Province(name, code);
//              provinceMap.put(code,province);

                provincesDAO.save(province);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importMunicipalities(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName), ';')) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String name = nextLine[2];
                String provinceName = nextLine.length >= 4 ? nextLine[3] : null;

//                System.out.println("Municipality Name: " + name);
//                System.out.println("Province Name: " + provinceName);


//                Province province = provinceMap.get(provinceCode);
                Province province = provincesDAO.findProvinceByName(provinceName);

                if (province != null) {
                    Municipality municipality = new Municipality(name, province);

                    municipalitiesDAO.save(municipality);
                }
                else{
                    System.out.println(provinceName);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    private String combineColumns(String[] columns, int startIndex, int endIndex) {
//        StringBuilder combinedValue = new StringBuilder();
//        for (int i = startIndex; i <= endIndex; i++) {
//            combinedValue.append(columns[i]);
//            if (i < endIndex) {
//                combinedValue.append(" ");
//            }
//        }
//        return combinedValue.toString();
//    }
}
