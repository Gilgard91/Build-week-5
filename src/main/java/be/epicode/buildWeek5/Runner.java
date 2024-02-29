package be.epicode.buildWeek5;
import be.epicode.buildWeek5.CSV.CSVImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private CSVImporter csvImporter;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public Runner(CSVImporter csvImporter) {
        this.csvImporter = csvImporter;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource province = resourceLoader.getResource("classpath:province-italiane.csv");
        Resource municipality = resourceLoader.getResource("classpath:comuni-italiani.csv");
//        String pro = province.getFile().getAbsolutePath();
//        System.out.println(pro);

        String provinceFileName = province.getFile().getAbsolutePath();
//                getClass().getResource("/province-italiane.csv").getFile();
        String municipalityFileName = municipality.getFile().getAbsolutePath();
//        getClass().getResource("/comuni-italiani.csv").getFile();

        csvImporter.importProvinces(provinceFileName);
        csvImporter.importMunicipalities(municipalityFileName);

    }

<<<<<<< HEAD
}
=======
}


//@Component
//public class Runner implements CommandLineRunner {
//
//    private CSVImporter csvImporter;
//
//    @Autowired
//    public Runner(CSVImporter csvImporter) {
//        this.csvImporter = csvImporter;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        String provinceFileName = getClass().getResource("/province-italiane.csv").getFile();
//        String municipalityFileName = getClass().getResource("/comuni-italiani.csv").getFile();
//
//        csvImporter.importProvinces(provinceFileName);
//        csvImporter.importMunicipalities(municipalityFileName);
//    }
//}
>>>>>>> develop
