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

    public void importProvinces(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName), ';')) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String code = nextLine[0];
                String name = nextLine[1];

                Province province = new Province(name, code);

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
                String provinceCode = nextLine[0];
                String name = nextLine[2];

//                System.out.println("Province Code: " + provinceCode);
//                System.out.println("Municipality Name: " + name);



                Province province = provincesDAO.findByCode(provinceCode);
                if (province != null) {
                    Municipality municipality = new Municipality(name, provinceCode, province);

                    municipalitiesDAO.save(municipality);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String combineColumns(String[] columns, int startIndex, int endIndex) {
        StringBuilder combinedValue = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            combinedValue.append(columns[i]);
            if (i < endIndex) {
                combinedValue.append(" ");
            }
        }
        return combinedValue.toString();
    }
}
